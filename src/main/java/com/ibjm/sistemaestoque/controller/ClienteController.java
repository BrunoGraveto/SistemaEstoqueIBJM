/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.controller;

import com.ibjm.sistemaestoque.model.dao.ClienteDAO;
import com.ibjm.sistemaestoque.model.dao.EnderecoDAO;
import com.ibjm.sistemaestoque.model.rn.ClienteRN;
import com.ibjm.sistemaestoque.model.vo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author alcan
 */
public class ClienteController {
	
	/*
		Converte um ArrayList com os Clientes em um array de objetos para
		colocar na tabela.
	*/
	public static Object[][] obterDados(ArrayList<Cliente> arrayClientes) {
		// Vars aux
		int linha = 0;
		int coluna = 0;
		
		// Array que salvara os dados
		Object[][] arrayDados = new Object[arrayClientes.size()][9];
		
		// Passa pelo array list os colocando no array de objetos
		for (Cliente cliente : arrayClientes) {
			arrayDados[linha][coluna++] = cliente.getID();
			arrayDados[linha][coluna++] = cliente.getAtividade();
			arrayDados[linha][coluna++] = cliente.getNome();
			arrayDados[linha][coluna++] = cliente.getCpf();
			arrayDados[linha][coluna++] = cliente.getRg();
			arrayDados[linha][coluna++] = cliente.getEndereco().getRua() + ", " + cliente.getEndereco().getNum() + " - " + cliente.getEndereco().getBairro() + ", " + cliente.getEndereco().getCidade() + " - " + cliente.getEndereco().getEstado();
			arrayDados[linha][coluna++] = cliente.getTelefone();
			arrayDados[linha][coluna++] = cliente.getEmail();
			arrayDados[linha++][coluna++] = cliente.getDataCadastroString();
			coluna = 0;
		}
		
		return arrayDados;
	}
	
	/*
		Verifica e adiciona um novo Cliente ao BD.
	*/
	public static void addCliente(Cliente cliente) throws Exception {
		EnderecoController.addEndereco(cliente.getEndereco());
		cliente.getEndereco().setID(EnderecoDAO.getUltimoRegistro().getID());
		ClienteRN.validarCliente(cliente);
		ClienteDAO.addCliente(cliente);
		ClienteDAO.addAssociacaoEndereco(cliente);
	}
	
	/*
		Verifica e altera um cliente existente no BD.
	*/
	public static void editarCliente(Cliente cliente) throws Exception {
		cliente.getEndereco().setID(ClienteDAO.encontrarIdEndereco(cliente.getEndereco().getID()));
		EnderecoController.editarEndereco(cliente.getEndereco());
		ClienteRN.validarCliente(cliente);
		ClienteDAO.editarCliente(cliente);
	}
	
	/*
		"Remover" um cliente.
	*/
	public static void setStatusCliente(Cliente cliente, boolean status) throws Exception {
		cliente.setStatus(status);
		ClienteDAO.editarCliente(cliente);
	}
	
}
