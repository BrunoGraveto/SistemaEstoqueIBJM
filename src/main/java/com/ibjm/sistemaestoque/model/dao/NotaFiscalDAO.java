/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import com.ibjm.sistemaestoque.model.vo.Cliente;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.ibjm.sistemaestoque.model.vo.NotaFiscal;
import com.ibjm.sistemaestoque.model.vo.Pagamento;

/**
 *
 * @author alcan
 */
public class NotaFiscalDAO {
    
    // SQL
    private static final String SQL_ADD = "insert into notafiscal (status_nf, observacao_nf, valor_nf, valor_produtos_nf, valor_impostos_nf, data_emissao_nf, data_saida_nf, id_pagamento) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_ASSOCIACAO = "insert into produto_has_fornecedor (num_nf, id_fornecedor) values (?, ?)";
    private static final String SQL_LIST = "select * from nota_fiscal ";
    private static final String SQL_QTD = "select count(*) from nota_fiscal";
    private static final String SQL_ENCONTRAR = "select * from nota_fiscal where num_nf = ?";
    private static final String SQL_ENCONTRAR_FORNECEDOR = "select * from nota_fiscal_has_endereco where num_nf = ?";
    private static final String SQL_EDIT = "update nota_fiscal set status_nf = ?, observacao_nf = ?, valor_nf = ?, valor_produtos_nf = ?, valor_impostos_nf = ?, valor_total = ?,  data_cadastro_nf = ?, data_emissao_nf = ? where num_nf = ?";
    
    public static void addNotaFiscal(NotaFiscal notaFiscal) throws SQLException {	
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD)) {
			pstm.setBoolean(1, true);
			pstm.setInt(2, notaFiscal.getID());
			pstm.setBoolean(3, notaFiscal.getStatus());
			pstm.setDouble(4, notaFiscal.getValorProdutos());
			pstm.setDouble(5, notaFiscal.getValorImpostos());
			pstm.setDouble(6, notaFiscal.getValorTotal());
			pstm.setDate(14, Date.valueOf(notaFiscal.getDataCadastro()));
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar o notaFiscal!");
		}
	}
	
	/*
		Encontra um determinado notaFiscal pelo codigo.
	*/
	public static void addAssociacaoFornecedor(Produto notaFiscal) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ASSOCIACAO)) {
			for (Fornecedor fornecedor : notaFiscal.getFornecedores()) {
				pstm.setInt(1, notaFiscal.getID());
				pstm.setInt(2, fornecedor.getID());
				pstm.executeUpdate();
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar uma associação entre o notaFiscal e o Fornecedor!");
		}
	}
	
	/*
		Encontra um determinado notaFiscal pelo codigo.
	*/
	public static void editarNotaFiscal(NotaFiscal notaFiscal) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_EDIT)) {	
			pstm.setInt(1, notaFiscal.getID());
			pstm.setBoolean(2, notaFiscal.getStatus());
			pstm.setDouble(3, notaFiscal.getValorProdutos());
			pstm.setDouble(4, notaFiscal.getValorImpostos());
			pstm.setDouble(5, notaFiscal.getValorTotal());
			pstm.setDate(6, Date.valueOf(notaFiscal.getDataCadastro()));
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel editar o notaFiscal!");
		}
	}
	
	/*
		Lista os Produtos existentes.
	*/
	public static ArrayList<NotaFiscal> listarNotasFiscais(String categoria, String procurar) throws SQLException {
		ArrayList<NotaFiscal> arrayNotasFiscais = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_LIST+pesquisar(categoria, procurar));
		ResultSet rs = pstm.executeQuery()) {
			while(rs.next()) {
                                int id = rs.getInt("id");
				boolean status = rs.getBoolean("status_notaFiscal");
                                String observacao = rs.getString("observacao_nf");
                                double valor = rs.getDouble("valor_nf");
                                double valorProdutos = rs.getDouble("valor_produtos_nf");
                                double valorImpostos = rs.getDouble("valor_impostos_nf");
                                Date dateCadastro = rs.getDate("data_cadastro_nf");
                                LocalDate dataCadastro = dateCadastro.toLocalDate();
                                Date dateEmissao = rs.getDate("data_emissao_nf");
                                LocalDate dataEmissao = dateEmissao.toLocalDate();
                                NotaFiscal notaFiscal = new NotaFiscal(id, status, null, observacao, null, valor, valorProdutos, valorImpostos, null, dataCadastro);
				// Caso o notaFiscal esteja inativo, não o coloca no array
				if (pesquisar(categoria, procurar).equals("") && !status) {
					continue;
				}
				arrayNotasFiscais.add(notaFiscal);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel listar os notaFiscals!");
		}
		return arrayNotasFiscais;
	}
	
	/*
		Encontra os fornecedores de um determinado notaFiscal.
	*/
	public static ArrayList<Fornecedor> encontrarFornecedoresProduto(int id) throws SQLException {
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
			throw new SQLException("Não foi encontrar os fornecedores do notaFiscal!");
		}
		return arrayFornecedores;
	}
	
	/*
		Lista os Produtos com uma certa especificação
	*/
	private static String pesquisar(String categoria, String procurar) {
		// Altera a categoria para o determinado nome da coluna
		switch (categoria) {
		case "Codigo" -> categoria = "id_notaFiscal";
		case "Nome" -> categoria = "nome_notaFiscal";
		case "Inativos" -> categoria = "status_notaFiscal";
		}
		// Retorna o determinado comando sql
		if (categoria.equals("status_notaFiscal")) {
			return "where " + categoria + " = false";
		} else if (!procurar.equals("") && !categoria.equals("")) {
			return "where " + categoria + " like " + "'%" + procurar + "%'";
		}
		// Caso o campo de pesquisa esteja vazio
		return "";
	}
	
	/*
		Produra um certo endereco.
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
			throw new SQLException("Não foi possivel encontrar o id do Fornecedor!");
		}
		return idFornecedor;
	}
	
	/*
		Encontra um determinado notaFiscal pelo codigo.
	*/
	public static NotaFiscal encontrarNotaFiscal(int id) throws SQLException {
		NotaFiscal notaFiscal = null;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					boolean status = rs.getBoolean("status_notaFiscal");
					String observacao = rs.getString("observacao_nf");
					double valor = rs.getDouble("valor_nf");
					double valorProdutos = rs.getDouble("valor_produtos_nf");
					double valorImpostos = rs.getDouble("valor_impostos_nf");
                                        Date dateCadastro = rs.getDate("data_cadastro_nf");
                                        LocalDate dataCadastro = dateCadastro.toLocalDate();
					Date dateEmissao = rs.getDate("data_emissao_nf");
                                        LocalDate dataEmissao = dateEmissao.toLocalDate();
					notaFiscal = new NotaFiscal(id, status, null, observacao, null, valor, valorProdutos, valorImpostos, null, dataCadastro);
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar um notaFiscal!");
		}
		return notaFiscal;
	}
	
	/*
		Retorna a quantidade de registros da tabela notaFiscal.
	*/
	public static int getCountNotasFiscais() throws SQLException {
		int qtd = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_QTD)) {
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				qtd = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel fazer a contagem de registros de notaFiscals!");
		}
		return qtd;
	}
	
}
