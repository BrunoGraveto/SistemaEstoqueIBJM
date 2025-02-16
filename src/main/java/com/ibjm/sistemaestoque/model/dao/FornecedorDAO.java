/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import com.ibjm.sistemaestoque.model.vo.Endereco;
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
public class FornecedorDAO {
	
	// SQL
	private static final String SQL_ADD = "insert into fornecedor (nome_fornecedor, status_fornecedor, cnpj_fornecedor, inscricao_estadual_fornecedor, cnae_fornecedor, telefone_fornecedor, email_fornecedor, data_cadastro_fornecedor) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_ASSOCIACAO = "insert into fornecedor_has_endereco (id_fornecedor, id_endereco) values (?, ?)";
	private static final String SQL_LIST = "select * from fornecedor ";
	private static final String SQL_QTD = "select count(*) from fornecedor";
	private static final String SQL_ENCONTRAR = "select * from fornecedor where id_fornecedor = ?";
	private static final String SQL_ENCONTRAR_END = "select * from fornecedor_has_endereco where id_fornecedor = ?";
	private static final String SQL_EDIT = "update fornecedor set status_fornecedor = ?, nome_fornecedor = ?, cnpj_fornecedor = ?, inscricao_estadual_fornecedor = ?, cnae_fornecedor = ?, telefone_fornecedor = ?, email_fornecedor = ?, data_cadastro_fornecedor = ? where id_fornecedor = ?";
	
	/*
		Adiciona um novo Fornecedor.
	*/
	public static void addFornecedor(Fornecedor fornecedor) throws SQLException {	
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD)) {
			pstm.setBoolean(1, fornecedor.getStatus());
			pstm.setString(2, fornecedor.getNome());
			pstm.setString(3, fornecedor.getCnpj());
			pstm.setString(4, fornecedor.getInscricaoEstadual());
			pstm.setString(5, fornecedor.getCnae());
			pstm.setString(6, fornecedor.getTelefone());
			pstm.setString(7, fornecedor.getEmail());
			pstm.setDate(8, Date.valueOf(fornecedor.getDataCadastro()));
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar o Fornecedor!");
		}
	}
	
	/*
		Encontra um determinado fornecedor pelo codigo.
	*/
	public static void addAssociacaoEndereco(Fornecedor fornecedor) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ASSOCIACAO)) {
			pstm.setInt(1, fornecedor.getID());
			pstm.setInt(2, fornecedor.getEndereco().getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar a associação entre o fornecedor e endereço!");
		}
	}
	
	/*
		Encontra um determinado fornecedor pelo codigo.
	*/
	public static void editarFornecedor(Fornecedor fornecedor) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_EDIT)) {
			pstm.setBoolean(1, fornecedor.getStatus());
			pstm.setString(2, fornecedor.getNome());
			pstm.setString(3, fornecedor.getCnpj());
			pstm.setString(4, fornecedor.getInscricaoEstadual());
			pstm.setString(5, fornecedor.getCnae());
			pstm.setString(6, fornecedor.getEmail());
			pstm.setString(7, fornecedor.getTelefone());
			pstm.setDate(8, Date.valueOf(fornecedor.getDataCadastro()));
			pstm.setInt(9, fornecedor.getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel editar o fornecedor!");
		}
	}
	
	/*
		Lista os Fornecedors existentes.
	*/
	public static ArrayList<Fornecedor> listarFornecedores(String categoria, String procurar) throws SQLException {
		ArrayList<Fornecedor> arrayFornecedors = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_LIST+pesquisar(categoria, procurar));
		ResultSet rs = pstm.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id_fornecedor");
				boolean status = rs.getBoolean("status_fornecedor");
				String nome = rs.getString("nome_fornecedor");
				String cnpj = rs.getString("cnpj_fornecedor");
				String inscricaoEstadual = rs.getString("inscricao_estadual_fornecedor");
				String cnae = rs.getString("cnae_fornecedor");
				String email = rs.getString("email_fornecedor");
				String telefone = rs.getString("telefone_fornecedor");
				Date dateCadastro = rs.getDate("data_cadastro_fornecedor");
				LocalDate dataCadastro = dateCadastro.toLocalDate();
				Endereco endereco = EnderecoDAO.encontrarEndereco(encontrarIdEndereco(id));
				Fornecedor fornecedor = new Fornecedor(id, status, nome, cnpj, inscricaoEstadual, cnae, endereco, telefone, email, dataCadastro);
				// Caso o fornecedor esteja inativo, não o coloca no array
				if (pesquisar(categoria, procurar).equals("") && !status) {
					continue;
				}
				arrayFornecedors.add(fornecedor);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel listar os fornecedores!");
		}
		return arrayFornecedors;
	}
	
	/*
		Lista os Fornecedores com uma certa especificação
	*/
	private static String pesquisar(String categoria, String procurar) {
		// Altera a categoria para o determinado nome da coluna
		switch (categoria) {
		case "Codigo" -> categoria = "id_fornecedor";
		case "Nome Fantasia" -> categoria = "nome_fornecedor";
		case "Inativos" -> categoria = "status_fornecedor";
		case "CNPJ" -> categoria = "nome_fornecedor";
		case "Inscrição Estadual" -> categoria = "inscricao_estadual_fornecedor";
		case "CNAE" -> categoria = "cnae_fornecedor";
		case "Telefone" -> categoria = "telefone_fornecedor";
		case "Email" -> categoria = "email_fornecedor";
		}
		// Retorna o determinado comando sql
		if (categoria.equals("status_fornecedor")) {
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
	public static int encontrarIdEndereco(int id) throws SQLException {
		int idEndereco = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR_END)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					idEndereco = rs.getInt("id_endereco");
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar o id de endereço!");
		}
		return idEndereco;
	}
	
	/*
		Encontra um determinado fornecedor pelo codigo.
	*/
	public static Fornecedor encontrarFornecedor(int id) throws SQLException {
		Fornecedor fornecedor = null;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					boolean status = rs.getBoolean("status_fornecedor");
					String nome = rs.getString("nome_fornecedor");
					String cnpj = rs.getString("cnpj_fornecedor");
					String inscricaoEstadual = rs.getString("inscricao_estadual_fornecedor");
					String cnae = rs.getString("cnae_fornecedor");
					String email = rs.getString("email_fornecedor");
					String telefone = rs.getString("telefone_fornecedor");
					Date dateCadastro = rs.getDate("data_cadastro_fornecedor");
					LocalDate dataCadastro = dateCadastro.toLocalDate();
					Endereco endereco = EnderecoDAO.encontrarEndereco(encontrarIdEndereco(id));
					fornecedor = new Fornecedor(id, status, nome, cnpj, inscricaoEstadual, cnae, endereco, telefone, email, dataCadastro);
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar o fornecedor!");
		}
		return fornecedor;
	}
	
	/*
		Retorna a quantidade de registros da tabela fornecedor.
	*/
	public static int getCountFornecedores() throws SQLException {
		int qtd = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_QTD);
		ResultSet rs = pstm.executeQuery()) {
			if (rs.next()) {
				qtd = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel fazer a contagem da quantidade de registros de fornecedores!");
		}
		return qtd;
	}
	
	
}
