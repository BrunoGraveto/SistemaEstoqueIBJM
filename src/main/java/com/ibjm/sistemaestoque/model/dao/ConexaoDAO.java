/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alcan
 */
public class ConexaoDAO {
	
	// Config
	private static final String URL = "jdbc:mysql://localhost:3306/sistema_estoque";
	private static final String USUARIO = "root";
	private static final String SENHA = "iPakif_#2130";
	
	public static Connection conectar() {
		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problema ao conectar ao Banco de Dados MySQL!");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
