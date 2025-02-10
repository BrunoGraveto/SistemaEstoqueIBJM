package com.ibjm.sistemaestoque.controller;


import com.ibjm.sistemaestoque.model.dao.EnderecoDAO;
import com.ibjm.sistemaestoque.model.dao.FornecedorDAO;
import com.ibjm.sistemaestoque.model.rn.FornecedorRN;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alcan
 */
public class FornecedorController {
	
	/*
		Converte um ArrayList com os fornecedors em um array de objetos para
		colocar na tabela.
	*/
	public static Object[][] obterDados(ArrayList<Fornecedor> arrayFornecedores) {
		// Vars aux
		int linha = 0;
		int coluna = 0;
		
		// Array que salvara os dados
		Object[][] arrayDados = new Object[arrayFornecedores.size()][11];
		
		// Passa pelo array list os colocando no array de objetos
		for (Fornecedor fornecedor : arrayFornecedores) {
			arrayDados[linha][coluna++] = fornecedor.getID();
			arrayDados[linha][coluna++] = fornecedor.getAtividade();
			arrayDados[linha][coluna++] = fornecedor.getNome();
			arrayDados[linha][coluna++] = fornecedor.getCnpj();
			arrayDados[linha][coluna++] = fornecedor.getInscricaoEstadual();
			arrayDados[linha][coluna++] = fornecedor.getCnae();
			arrayDados[linha][coluna++] = fornecedor.getEndereco().getRua() + ", " + fornecedor.getEndereco().getNum() + " - " + fornecedor.getEndereco().getBairro() + ", " + fornecedor.getEndereco().getCidade() + " - " + fornecedor.getEndereco().getEstado();
			arrayDados[linha][coluna++] = fornecedor.getEndereco().getCep();
			arrayDados[linha][coluna++] = fornecedor.getTelefone();
			arrayDados[linha][coluna++] = fornecedor.getEmail();
			arrayDados[linha++][coluna++] = fornecedor.getDataCadastroString();
			coluna = 0;
		}
		
		return arrayDados;
	}
	
	/*
		Verifica e adiciona um novo Fornecedor ao BD.
	*/
	public static void addFornecedor(Fornecedor fornecedor) throws Exception {
		EnderecoController.addEndereco(fornecedor.getEndereco());
		fornecedor.getEndereco().setID(EnderecoDAO.getUltimoRegistro().getID());
		FornecedorRN.validarFornecedor(fornecedor);
		FornecedorDAO.addFornecedor(fornecedor);
		FornecedorDAO.addAssociacaoEndereco(fornecedor);
	}
	
	/*
		Verifica e altera um fornecedor existente no BD.
	*/
	public static void editarFornecedor(Fornecedor fornecedor) throws Exception {
		fornecedor.getEndereco().setID(FornecedorDAO.encontrarIdEndereco(fornecedor.getEndereco().getID()));
		EnderecoController.editarEndereco(fornecedor.getEndereco());
		FornecedorRN.validarFornecedor(fornecedor);
		FornecedorDAO.editarFornecedor(fornecedor);
	}
	
	/*
		"Remover" um fornecedor.
	*/
	public static void setStatusFornecedor(Fornecedor fornecedor, boolean status) throws Exception {
		fornecedor.setStatus(status);
		FornecedorDAO.editarFornecedor(fornecedor);
	}
	
}
