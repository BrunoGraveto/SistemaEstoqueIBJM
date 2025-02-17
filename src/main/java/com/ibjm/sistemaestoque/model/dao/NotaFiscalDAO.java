/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import com.ibjm.sistemaestoque.model.vo.Cliente;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.ibjm.sistemaestoque.model.vo.NotaFiscal;

/**
 *
 * @author alcan
 */
public class NotaFiscalDAO {
    
    // Tabela Principal
    private static final String SQL_ADD = "insert into nota_fiscal (status_nf, observacao_nf, valor_total_nf, forma_pagamento_nf, data_cadastro_nf, data_saida_nf, id_cliente) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_EDIT = "update nota_fiscal set status_nf = ?, observacao_nf = ?, valor_total_nf = ?, forma_pagamento_nf = ?, data_cadastro_nf = ?, data_saida_nf = ?, id_cliente = ? where num_nf = ?";
	private static final String SQL_LIST = "select * from nota_fiscal ";
	private static final String SQL_ENCONTRAR = "select * from nota_fiscal where num_nf = ?";
	private static final String SQL_QTD = "select count(*) from nota_fiscal";
	
	// Tabela has Produto
    private static final String SQL_ADD_ASSOCIACAO_PRODUTO = "insert into nf_has_produto (num_nf, id_produto, qtd_produto) values (?, ?, ?)";
    private static final String SQL_ENCONTRAR_PRODUTOS = "select * from nf_has_produto where num_nf = ?";
	private static final String SQL_GET_QTD_PRODUTO = "select * from nf_has_produto where num_nf = ? and id_produto = ?";
	private static final String SQL_VF_ASSOCIACAO_PRODUTO = "select * from nf_has_produto where num_nf = ? and id_produto = ?";
	private static final String SQL_DELETE = "delete from nf_has_produto where num_nf = ? and id_produto = ?";
	private static final String SQL_UPDATE_HAS_PRODUTO = "update nf_has_produto set qtd_produto = ? where num_nf = ? and id_produto = ?";
	
	// Tabela has Cliente
    
	/*
		Adiciona uma nova Nota Fiscal
	*/
    public static void addNotaFiscal(NotaFiscal notaFiscal) throws SQLException {	
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD)) {
			pstm.setBoolean(1, true);
			pstm.setString(2, notaFiscal.getObservacao());
			pstm.setDouble(3, notaFiscal.getValorTotal());
			pstm.setString(4, notaFiscal.getFormaPagamento());
			pstm.setDate(5, Date.valueOf(notaFiscal.getDataCadastro()));
			pstm.setDate(6, Date.valueOf(notaFiscal.getDataSaida()));
			pstm.setInt(7, notaFiscal.getCliente().getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar a Nota Fiscal: " + e);
		}
	}
	
	/*
		Edita a Nota Fiscal
	*/
	public static void editarNotaFiscal(NotaFiscal notaFiscal) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_EDIT)) {
			pstm.setBoolean(1, notaFiscal.getStatus());
			pstm.setString(2, notaFiscal.getObservacao());
			pstm.setDouble(3, notaFiscal.getValorTotal());
			pstm.setString(4, notaFiscal.getFormaPagamento());
			pstm.setDate(5, Date.valueOf(notaFiscal.getDataCadastro()));
			pstm.setDate(6, Date.valueOf(notaFiscal.getDataSaida()));
			pstm.setInt(7, notaFiscal.getCliente().getID());
			pstm.setInt(8, notaFiscal.getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel editar o notaFiscal: " + e);
		}
	}
	
	/*
		Lista os Produtos com uma certa especificação
	*/
	private static String pesquisar(String categoria, String procurar) throws SQLException {
		// Altera a categoria para o determinado nome da coluna
		switch (categoria) {
		case "Número" -> categoria = "num_nf";
		case "Finalizadas" -> categoria = "status_nf";
		case "Observação" -> categoria = "observacao_nf";
		case "Cliente" -> categoria = "id_cliente";
		}
		// Retorna o determinado comando sql
		if (categoria.equals("id_cliente")) {
			ArrayList<Cliente> procurarCliente = ClienteDAO.listarClientes("Nome", procurar);
			return "where " + categoria + " = " + procurarCliente.get(0).getID();
		} else if (categoria.equals("status_nf")) {
			return "where " + categoria + " = false";
		} else if (!procurar.equals("") && !categoria.equals("")) {
			return "where " + categoria + " like " + "'%" + procurar + "%'";
		}
		// Caso o campo de pesquisa esteja vazio
		return "";
	}
	
	/*
		Lista as Notas Fiscais Existentes
	*/
	public static ArrayList<NotaFiscal> listarNotasFiscais(String categoria, String procurar) throws SQLException {
		ArrayList<NotaFiscal> arrayNotasFiscais = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_LIST+pesquisar(categoria, procurar));
		ResultSet rs = pstm.executeQuery()) {
			while(rs.next()) {
                int num = rs.getInt("num_nf");
				boolean status = rs.getBoolean("status_nf");
                String observacao = rs.getString("observacao_nf");
				double valorTotal = rs.getDouble("valor_total_nf");
				String formaPagamento = rs.getString("forma_pagamento_nf");
                Date dateCadastro = rs.getDate("data_cadastro_nf");
                LocalDate dataCadastro = dateCadastro.toLocalDate();
                Date dateSaida = rs.getDate("data_saida_nf");
                LocalDate dataSaida = dateSaida.toLocalDate();
				Cliente cliente = ClienteDAO.encontrarCliente(rs.getInt("id_cliente"));
				ArrayList<Produto> produtos = getProdutosNotaFiscal(num);
                NotaFiscal notaFiscal = new NotaFiscal(num, status, observacao, cliente, produtos, valorTotal, formaPagamento, dataCadastro, dataSaida);
				// Caso o notaFiscal esteja inativo, não o coloca no array
				if (pesquisar(categoria, procurar).equals("") && !status) {
					continue;
				}
				arrayNotasFiscais.add(notaFiscal);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel listar as Notas Fiscais: " + e);
		}
		return arrayNotasFiscais;
	}
	
	/*
		Encontra um determinado notaFiscal pelo codigo.
	*/
	public static NotaFiscal encontrarNotaFiscal(int num) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR)) {
			pstm.setInt(1, num);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					boolean status = rs.getBoolean("status_nf");
					String observacao = rs.getString("observacao_nf");
					double valorTotal = rs.getDouble("valor_total_nf");
					String formaPagamento = rs.getString("forma_pagamento_nf");
					Date dateCadastro = rs.getDate("data_cadastro_nf");
					LocalDate dataCadastro = dateCadastro.toLocalDate();
					Date dateSaida = rs.getDate("data_saida_nf");
					LocalDate dataSaida = dateSaida.toLocalDate();
					Cliente cliente = ClienteDAO.encontrarCliente(rs.getInt("id_cliente"));
					ArrayList<Produto> produtos = getProdutosNotaFiscal(num);
					return new NotaFiscal(num, status, observacao, cliente, produtos, valorTotal, formaPagamento, dataCadastro, dataSaida);
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar uma Nota Fiscal!");
		}
		return null;
	}
	
	/*
		Retorna a quantidade de registros da tabela notaFiscal.
	*/
	public static int getCountNotasFiscais() throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_QTD)) {
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel fazer a contagem de registros de Notas Fiscais!");
		}
		return 0;
	}
	
	/*
		Adiciona a associação entres os Produtos e a Nota Fiscal
	*/
	public static void addAssociacaoProdutos(NotaFiscal notaFiscal, ArrayList<Integer> arrayQtdProdutos) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD_ASSOCIACAO_PRODUTO)) {
			// Remover antigos
			ArrayList<Integer> idsAntigos = getIDsProdutos(encontrarNotaFiscal(notaFiscal.getID()));
			ArrayList<Integer> idsAtuais = getIDsProdutos(notaFiscal);
			for (int id : idsAntigos) {
				if (idsAtuais.indexOf(id) == -1) {
					removerAssociacao(notaFiscal.getID(), id);
				}
			}
			
			// Adicionar novos
			int counterQtd = 0;
			for (Produto produto : notaFiscal.getProdutos()) {
				if (!verificarExisteProduto(notaFiscal.getID(), produto.getID())) {
					pstm.setInt(1, notaFiscal.getID());
					pstm.setInt(2, produto.getID());
					pstm.setInt(3, arrayQtdProdutos.get(counterQtd));
					pstm.executeUpdate();
				} 
				// Se a quantidade do item for diferente de antes atualiza
				else if (getQtdProdutosNotaFiscal(notaFiscal.getID(), produto.getID()) != arrayQtdProdutos.get(counterQtd)) {
					updateQtdProdutoNotaFiscal(notaFiscal.getID(), produto.getID(), arrayQtdProdutos.get(counterQtd));
				}
				counterQtd++;
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar uma associação entre a Nota Fiscal e o Produto: " + e);
		}
	}
	
	/*
		Atualizar qtd em uma associação
	*/
	public static void updateQtdProdutoNotaFiscal(int numNf, int idProduto, int qtd) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_UPDATE_HAS_PRODUTO)) {
			pstm.setInt(1, qtd);
			pstm.setInt(2, numNf);
			pstm.setInt(3, idProduto);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Problema ao atualizar quantidade do Produto: " + e);
		}
	}
	
	/*
		Remove uma associacao
	*/
	public static void removerAssociacao(int idProduto, int idFornecedor) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_DELETE)) {
			pstm.setInt(1, idProduto);
			pstm.setInt(2, idFornecedor);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Problema ao remover associação " + e);
		}
	}
	
	/*
		Verifica se ja existe uma associacao.
	*/
	public static boolean verificarExisteProduto(int numNf, int idProduto) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_VF_ASSOCIACAO_PRODUTO)) {
			pstm.setInt(1, numNf);
			pstm.setInt(2, idProduto);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Problema ao verificar Associação entre Nota Fiscal e Produto: " + e);
		}
		return false;
	}
	
	/*
		Retorna os ids dos Produtos de uma Nota Fiscal
	*/
	public static ArrayList<Integer> getIDsProdutos(NotaFiscal notaFiscal) {
		ArrayList<Integer> ids = new ArrayList<>();
		for (Produto produto : notaFiscal.getProdutos()) {
			ids.add(produto.getID());
		}
		return ids;
	}
	
	/*
		Ver a quantidade de um determinado produto em uma nota
	*/
	public static int getQtdProdutosNotaFiscal(int numNf, int idProduto) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_GET_QTD_PRODUTO)) {
			pstm.setInt(1, numNf);
			pstm.setInt(2, idProduto);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("qtd_produto");
				}
			} catch (Exception e) {
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel obter a quantidade de um determinado Produto: " + e);
		}
		return 0;
	}
	
	/*
		Encontra os fornecedores de um determinado notaFiscal.
	*/
	public static ArrayList<Produto> getProdutosNotaFiscal(int id) throws SQLException {
		ArrayList<Produto> arrayProdutos = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR_PRODUTOS)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				while (rs.next()) {
					arrayProdutos.add(ProdutoDAO.encontrarProduto(rs.getInt("id_produto")));
				}
			}
		} catch (Exception e) {
			throw new SQLException("Não foi possivel encontrar os Produtos da Nota Fiscal!");
		}
		return arrayProdutos;
	}
	
	/*
		Procura um id de um produto.
	*/
	public static int encontrarIDProdutoPorIDNotaFiscal(int id) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR_PRODUTOS)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("id_produto");
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar o id do Produto!");
		}
		return 0;
	}
	
}