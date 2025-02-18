/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import com.ibjm.sistemaestoque.model.vo.Cliente;
import com.ibjm.sistemaestoque.model.vo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author alcan
 */
public class ClienteDAO {
	
	// SQL
	private static final String SQL_ADD = "insert into cliente (status_cliente, nome_cliente, cpf_cliente, rg_cliente, telefone_cliente, email_cliente, data_cadastro_cliente) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_EDIT = "update cliente set status_cliente = ?, nome_cliente = ?, cpf_cliente = ?, rg_cliente = ?, telefone_cliente = ?, email_cliente = ?, data_cadastro_cliente = ? where id_cliente = ?";
	private static final String SQL_LIST = "select * from cliente ";
	private static final String SQL_ENCONTRAR = "select * from cliente where id_cliente = ?";
	private static final String SQL_ENCONTRAR_PRIMEIRO = "select * from cliente where nome_cliente like ? limit 1";
	private static final String SQL_QTD = "select count(*) from cliente";
	private static final String SQL_ASSOCIACAO = "insert into cliente_has_endereco (id_cliente, id_endereco) values (?, ?)";
	private static final String SQL_ENCONTRAR_END = "select * from cliente_has_endereco where id_cliente = ?";
	
	/*
		Método que cria um Cliente de acordo com um ResultSet.
	*/
	public static Cliente criarCliente(ResultSet rs) throws SQLException {
		try {
			int id = rs.getInt("id_cliente");
			boolean status = rs.getBoolean("status_cliente");
			String nome = rs.getString("nome_cliente");
			String cpf = rs.getString("cpf_cliente");
			String rg = rs.getString("rg_cliente");
			String telefone = rs.getString("telefone_cliente");
			String email = rs.getString("email_cliente");
			Date dateCadastro = rs.getDate("data_cadastro_cliente");
			LocalDate dataCadastro = dateCadastro.toLocalDate();
			Endereco endereco = EnderecoDAO.encontrarEndereco(encontrarIdEndereco(id));
			return new Cliente(id, status, nome, cpf, rg, endereco, telefone, email, dataCadastro);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/*
		Adiciona um novo Cliente.
	*/
	public static void addCliente(Cliente cliente) throws SQLException {	
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD)) {
			pstm.setBoolean(1, true);
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getRg());
			pstm.setString(5, cliente.getTelefone());
			pstm.setString(6, cliente.getEmail());
			pstm.setDate(7, Date.valueOf(cliente.getDataCadastro()));
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar o cliente!");
		}
	}
	
	/*
		Edita um Cliente existente.
	*/
	public static void editarCliente(Cliente cliente) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_EDIT)) {	
			pstm.setBoolean(1, cliente.getStatus());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getRg());
			pstm.setString(5, cliente.getTelefone());
			pstm.setString(6, cliente.getEmail());
			pstm.setDate(7, Date.valueOf(cliente.getDataCadastro()));
			pstm.setInt(8, cliente.getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel editar o cliente!");
		}
	}
	
	/*
		Filtro
	*/
	private static String pesquisar(String categoria, String procurar) {
		// Altera a categoria para o determinado nome da coluna
		switch (categoria) {
		case "Codigo" -> categoria = "id_cliente";
		case "Inativos" -> categoria = "status_cliente";
		case "Nome" -> categoria = "nome_cliente";
		case "CPF" -> categoria = "cpf_cliente";
		case "RG" -> categoria = "rg_cliente";
		case "Telefone" -> categoria = "telefone_cliente";
		case "Email" -> categoria = "email_cliente";
		}
		// Retorna o determinado comando sql
		if (categoria.equals("status_cliente")) {
			return "where " + categoria + " = false";
		} else if (!procurar.equals("") && !categoria.equals("")) {
			return "where " + categoria + " like " + "'%" + procurar + "%'";
		}
		// Caso o campo de pesquisa esteja vazio
		return "";
	}
	
	/*
		Lista os Clientes de acordo com o filtro.
	*/
	public static ArrayList<Cliente> listarClientes(String categoria, String procurar) throws SQLException {
		ArrayList<Cliente> arrayClientes = new ArrayList<>();
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_LIST+pesquisar(categoria, procurar));
		ResultSet rs = pstm.executeQuery()) {
			while(rs.next()) {
				Cliente cliente = criarCliente(rs);
				if (pesquisar(categoria, procurar).equals("") && !cliente.getStatus()) {
					continue;
				}
				arrayClientes.add(cliente);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel listar os clientes!");
		}
		return arrayClientes;
	}
	
	/*
		Encontra um determinado Cliente pelo ID.
	*/
	public static Cliente encontrarCliente(int id) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return criarCliente(rs);
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar um cliente!");
		}
		return null;
	}
	
	/*
		Retorna o primeiro Cliente a partir de uma pesquisa pelo nome.
	*/
	public static int pesquisarPrimeiroCliente(String pesquisa) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR_PRIMEIRO)) {
			pstm.setString(1, "%" + pesquisa + "%");
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("id_cliente");
				}
			}
		} catch (Exception e) {
			throw new SQLException("Não foi possivel pesquisar o Cliente!", e);
		}
		return 0;
	}
	
	/*
		Retorna a quantidade de Clientes.
	*/
	public static int getCountClientes() throws SQLException {
		int qtd = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_QTD)) {
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				qtd = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel fazer a contagem de registros de clientes!");
		}
		return qtd;
	}
	
	/*
		Adiciona a Associação entre o Cliente e o Endereço.
	*/
	public static void addAssociacaoEndereco(Cliente cliente) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ASSOCIACAO)) {
			pstm.setInt(1, cliente.getID());
			pstm.setInt(2, cliente.getEndereco().getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar uma associação entre o cliente e o endereço!");
		}
	}
	
	/*
		Procura um Endereço pelo ID.
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
			throw new SQLException("Não foi possivel encontrar o id do endereço!");
		}
		return idEndereco;
	}
	
}
