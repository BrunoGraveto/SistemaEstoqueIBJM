/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import com.ibjm.sistemaestoque.model.vo.Produto;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author alcan
 */
public class ProdutoDAO {
	
	// SQL
	private static final String SQL_ADD = "insert into produto (status_produto, marca_produto, descricao_produto, valor_compra_produto, valor_venda_produto, categoria_produto, qtd_minima_produto, qtd_atual_produto, qtd_maxima_produto, unidade_medida_produto, peso_produto, data_fabricacao_produto, data_validade_produto, data_cadastro_produto) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_EDIT = "update produto set status_produto = ?, marca_produto = ?, descricao_produto = ?, valor_compra_produto = ?, valor_venda_produto = ?, categoria_produto = ?, qtd_minima_produto = ?, qtd_atual_produto = ?, qtd_maxima_produto = ?, unidade_medida_produto = ?, peso_produto = ?, data_fabricacao_produto = ?, data_validade_produto = ?, data_cadastro_produto = ? where id_produto = ?";
	private static final String SQL_LIST = "select * from produto ";
	private static final String SQL_ENCONTRAR = "select * from produto where id_produto = ?";
	private static final String SQL_QTD = "select count(*) from produto";
	private static final String SQL_ADD_ASSOCIACAO = "insert into produto_has_fornecedor (id_produto, id_fornecedor) values (?, ?)";
	private static final String SQL_DELETE = "delete from produto_has_fornecedor where id_produto = ? and id_fornecedor = ?";
	private static final String SQL_ENCONTRAR_FORNECEDOR = "select * from produto_has_fornecedor where id_produto = ?";
	private static final String SQL_VF_ASSOCIACAO = "select * from produto_has_fornecedor where id_produto = ? and id_fornecedor = ?";
	
	/*
		Método que cria um Produto de acordo com um ResultSet.
	*/
	public static Produto criarProduto(ResultSet rs) throws SQLException {
		try {
			int id = rs.getInt("id_produto");
			boolean status = rs.getBoolean("status_produto");
			String marca = rs.getString("marca_produto");
			String descricao = rs.getString("descricao_produto");
			double valorCompra = rs.getDouble("valor_compra_produto");
			double valorVenda = rs.getDouble("valor_venda_produto");
			String categoriaP = rs.getString("categoria_produto");
			int qtdMinima = rs.getInt("qtd_minima_produto");
			int qtdAtual = rs.getInt("qtd_atual_produto");
			int qtdMaxima = rs.getInt("qtd_maxima_produto");
			String unidadeMedida = rs.getString("unidade_medida_produto");
			double peso = rs.getDouble("peso_produto");
			Date dateFabricacao = rs.getDate("data_fabricacao_produto");
			LocalDate dataFabricacao = dateFabricacao.toLocalDate();
			Date dateValidade = rs.getDate("data_validade_produto");
			LocalDate dataValidade = dateValidade.toLocalDate();
			Date dateCadastro = rs.getDate("data_cadastro_produto");
			LocalDate dataCadastro = dateCadastro.toLocalDate();
			ArrayList<Fornecedor> fornecedores = getFornecedoresProduto(id);
			return new Produto(id, status, fornecedores, marca, descricao, categoriaP, unidadeMedida, peso, valorCompra, valorVenda, qtdMinima, qtdAtual, qtdMaxima, dataFabricacao, dataValidade, dataCadastro);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/*
		Adiciona um novo Produto.
	*/
	public static void addProduto(Produto produto) throws SQLException {	
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD)) {
			pstm.setBoolean(1, true);
			pstm.setString(2, produto.getMarca());
			pstm.setString(3, produto.getDescricao());
			pstm.setDouble(4, produto.getValorCompra());
			pstm.setDouble(5, produto.getValorVenda());
			pstm.setString(6, produto.getCategoria());
			pstm.setInt(7, produto.getQtdMinima());
			pstm.setInt(8, produto.getQtdAtual());
			pstm.setInt(9, produto.getQtdMaxima());
			pstm.setString(10, produto.getUnidadeMedida());
			pstm.setDouble(11, produto.getPeso());
			pstm.setDate(12, Date.valueOf(produto.getDataFabricacao()));
			pstm.setDate(13, Date.valueOf(produto.getDataValidade()));
			pstm.setDate(14, Date.valueOf(produto.getDataCadastro()));
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar o produto: + e");
		}
	}
	
	/*
		Encontra um determinado produto pelo codigo.
	*/
	public static void editarProduto(Produto produto) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_EDIT)) {	
			pstm.setBoolean(1, produto.getStatus());
			pstm.setString(2, produto.getMarca());
			pstm.setString(3, produto.getDescricao());
			pstm.setDouble(4, produto.getValorCompra());
			pstm.setDouble(5, produto.getValorVenda());
			pstm.setString(6, produto.getCategoria());
			pstm.setInt(7, produto.getQtdMinima());
			pstm.setInt(8, produto.getQtdAtual());
			pstm.setInt(9, produto.getQtdMaxima());
			pstm.setString(10, produto.getUnidadeMedida());
			pstm.setDouble(11, produto.getPeso());
			pstm.setDate(12, Date.valueOf(produto.getDataFabricacao()));
			pstm.setDate(13, Date.valueOf(produto.getDataValidade()));
			pstm.setDate(14, Date.valueOf(produto.getDataCadastro()));
			pstm.setInt(15, produto.getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Problema ao verificar Associação: " + e);
		}
	}
	
	/*
		Lista os Produtos com uma certa especificação
	*/
	private static String pesquisar(String categoria, String procurar) {
		// Altera a categoria para o determinado nome da coluna
		switch (categoria) {
		case "Codigo" -> categoria = "id_produto";
		case "Inativos" -> categoria = "status_produto";
		case "Descrição" -> categoria = "descricao_produto";
		case "Marca" -> categoria = "marca_produto";
		}
		// Retorna o determinado comando sql
		if (categoria.equals("status_produto")) {
			return "where " + categoria + " = false";
		} else if (!procurar.equals("") && !categoria.equals("")) {
			return "where " + categoria + " like " + "'%" + procurar + "%'";
		}
		// Caso o campo de pesquisa esteja vazio
		return "";
	}
	
	/*
		Lista os Produtos existentes.
	*/
	public static ArrayList<Produto> listarProdutos(String categoria, String procurar) throws SQLException {
		ArrayList<Produto> arrayProdutos = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_LIST+pesquisar(categoria, procurar));
		ResultSet rs = pstm.executeQuery()) {
			while(rs.next()) {
				Produto produto = criarProduto(rs);
				if (pesquisar(categoria, procurar).equals("") && !produto.getStatus()) {
					continue;
				}
				arrayProdutos.add(produto);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel listar os produtos: " + e);
		}
		return arrayProdutos;
	}
	
	/*
		Encontra um determinado produto pelo codigo.
	*/
	public static Produto encontrarProduto(int id) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return criarProduto(rs);
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar um produto: " + e);
		}
		return null;
	}
	
	/*
		Retorna a quantidade de registros da tabela produto.
	*/
	public static int getCountProdutos() throws SQLException {
		int qtd = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_QTD)) {
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				qtd = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel fazer a contagem de registros de produtos: " + e);
		}
		return qtd;
	}
	
	/*
		Encontra os fornecedores de um determinado produto.
	*/
	public static ArrayList<Fornecedor> getFornecedoresProduto(int id) throws SQLException {
		ArrayList<Fornecedor> arrayFornecedores = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR_FORNECEDOR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				while (rs.next()) {
					arrayFornecedores.add(FornecedorDAO.encontrarFornecedor(rs.getInt("id_fornecedor")));
				}
			}
		} catch (Exception e) {
			throw new SQLException("Não foi encontrar os fornecedores do produto: " + e);
		}
		return arrayFornecedores;
	}
	
	/*
		Encontra um determinado produto pelo codigo.
	*/
	public static void addAssociacaoFornecedor(Produto produto) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD_ASSOCIACAO)) {
			// Remover antigos
			ArrayList<Integer> idsAntigos = getIDFornecedores(encontrarProduto(produto.getID()));
			ArrayList<Integer> idsAtuais = getIDFornecedores(produto);
			for (int id : idsAntigos) {
				if (idsAtuais.indexOf(id) == -1) {
					removerAssociacao(produto.getID(), id);
				}
			}
			
			// Adicionar novos
			for (Fornecedor fornecedor : produto.getFornecedores()) {
				if (!verificarAssociacao(produto.getID(), fornecedor.getID())) {
					pstm.setInt(1, produto.getID());
					pstm.setInt(2, fornecedor.getID());
					pstm.executeUpdate();
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar a associação entre o produto e o Fornecedor: " + e);
		}
	}
	
	/*
		Verifica se ja existe uma associacao.
	*/
	public static boolean verificarAssociacao(int idProduto, int idFornecedor) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_VF_ASSOCIACAO)) {
			pstm.setInt(1, idProduto);
			pstm.setInt(2, idFornecedor);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Problema ao verificar Associação entre Produto e Fornecedor: " + e);
		}
		return false;
	}
	
	/*
		Retorna os ids dos Fornecedores de um Produto
	*/
	public static ArrayList<Integer> getIDFornecedores(Produto produto) {
		ArrayList<Integer> ids = new ArrayList<>();
		for (Fornecedor fornecedor : produto.getFornecedores()) {
			ids.add(fornecedor.getID());
		}
		return ids;
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
		Procura um Fornecedor
	*/
	public static int encontrarIdFornecedor(int id) throws SQLException {
		int idFornecedor = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR_FORNECEDOR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					idFornecedor = rs.getInt("id_fornecedor");
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar o id do Fornecedor: " + e);
		}
		return idFornecedor;
	}
	
	public static int getQtdProdutoReal(int id) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement("select * from nf_has_produto where id_produto = ?")) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				int qtdTotal = encontrarProduto(id).getQtdAtual();
				while (rs.next()) {
					if (rs.getBoolean("status_nf")) {
						qtdTotal -= rs.getInt("qtd_produto"); 
					}
				}
				return qtdTotal;
			}
		} catch (Exception e) {
			throw new SQLException("Não foi possivel fazer a contagem da Quantidade do Produto: " + e);
		}
	}
	
}
