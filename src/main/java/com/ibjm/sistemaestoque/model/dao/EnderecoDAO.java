/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import com.ibjm.sistemaestoque.model.vo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alcan
 */
public class EnderecoDAO {
	
	// SQL
	private static final String SQL_ADD = "insert into endereco (rua_endereco, bairro_endereco, num_endereco, cep_endereco, cidade_endereco, estado_endereco) values (?, ?, ?, ?, ?, ?)";
	private static final String SQL_EDIT = "update endereco set rua_endereco = ?, bairro_endereco = ?, num_endereco = ?, cep_endereco = ?, cidade_endereco = ?, estado_endereco = ? where id_endereco = ?";
	private static final String SQL_ENCONTRAR = "select * from endereco where id_endereco = ?";
	private static final String SQL_LIST = "select * from endereco";
	
	/*
		Adiciona um novo endereço a tabela.
	*/
	public static void addEndereco(Endereco endereco) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ADD)) {
			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getBairro());
			pstm.setInt(3, endereco.getNum());
			pstm.setString(4, endereco.getCep());
			pstm.setString(5, endereco.getCidade());
			pstm.setString(6, endereco.getEstado());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel adicionar o endereço!");
		}
	}
	
	/*
		Edita um endereço
	*/
	public static void editarEndereco(Endereco endereco) throws SQLException {
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_EDIT)) {
			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getBairro());
			pstm.setInt(3, endereco.getNum());
			pstm.setString(4, endereco.getCep());
			pstm.setString(5, endereco.getCidade());
			pstm.setString(6, endereco.getEstado());
			pstm.setInt(7, endereco.getID());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel editar o endereço!");
		}
	}
	
	/*
		Encontra um Endereço pelo ID.
	*/
	public static Endereco encontrarEndereco(int id) throws SQLException {
		Endereco endereco = null;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_ENCONTRAR)) {
			pstm.setInt(1, id);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					endereco = new Endereco(rs.getInt("id_endereco"), rs.getString("rua_endereco"), rs.getString("bairro_endereco"), rs.getInt("num_endereco"), rs.getString("cep_endereco"), rs.getString("cidade_endereco"), rs.getString("estado_endereco"));
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar o endereço!");
		}
		return endereco;
	}
	
	/*
		Retorna a quantidade de registros de endereço.
	*/
	public static int getCountEndereco() throws SQLException {
		int count = 0;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement("select count(*) from endereco");
		ResultSet rs = pstm.executeQuery()) {
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel contar a quantidade de registros de endereço!");
		}
		return count;
	}
	
	/*
		Retorna o ultimo Endereço.
	*/
	public static Endereco getUltimoRegistro() throws SQLException {
		Endereco endereco = null;
		try (Connection conexao = ConexaoDAO.conectar();
		PreparedStatement pstm = conexao.prepareStatement(SQL_LIST);
		ResultSet rs = pstm.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id_endereco");
				String rua = rs.getString("rua_endereco");
				int num = rs.getInt("num_endereco");
				String cep = rs.getString("cep_endereco");
				String estado = rs.getString("estado_endereco");
				String bairro = rs.getString("bairro_endereco");
				String cidade = rs.getString("cidade_endereco");
				endereco = new Endereco(id, rua, bairro, num, cep, estado, cidade);
			}
			return endereco;
		} catch (SQLException e) {
			throw new SQLException("Não foi possivel encontrar o ultimo registro dos endereços!");
		}
	}
	
}
