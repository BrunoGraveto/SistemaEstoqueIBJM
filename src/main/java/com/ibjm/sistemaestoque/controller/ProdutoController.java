/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.controller;

import com.ibjm.sistemaestoque.model.dao.ProdutoDAO;
import com.ibjm.sistemaestoque.model.rn.ProdutoRN;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.util.ArrayList;

/**
 *
 * @author alcan
 */
public class ProdutoController {
	
	/*
		Converte um ArrayList com os Produtos em um array de objetos para
		colocar na tabela.
	*/
	public static Object[][] obterDados(ArrayList<Produto> arrayProdutos) {
		// Vars aux
		int linha = 0;
		int coluna = 0;
		
		// Array que salvara os dados
		Object[][] arrayDados = new Object[arrayProdutos.size()][15];
		
		// Passa pelo array list os colocando no array de objetos
		for (Produto produto : arrayProdutos) {
			arrayDados[linha][coluna++] = produto.getID();
			arrayDados[linha][coluna++] = produto.getAtividade();
			arrayDados[linha][coluna++] = produto.getMarca();
			arrayDados[linha][coluna++] = produto.getDescricao();
			arrayDados[linha][coluna++] = produto.getValorCompra();
			arrayDados[linha][coluna++] = produto.getValorVenda();
			arrayDados[linha][coluna++] = produto.getCategoria();
			arrayDados[linha][coluna++] = produto.getQtdMinima();
			arrayDados[linha][coluna++] = produto.getQtdAtual();
			arrayDados[linha][coluna++] = produto.getQtdMaxima();
			arrayDados[linha][coluna++] = produto.getUnidadeMedida();
			arrayDados[linha][coluna++] = produto.getPeso();
			arrayDados[linha][coluna++] = produto.getDataFabricacaoString();
			arrayDados[linha][coluna++] = produto.getDataValidadeString();
			arrayDados[linha++][coluna++] = produto.getDataCadastroString();
			coluna = 0;
		}
		
		return arrayDados;
	}
	
	/*
		Verifica e adiciona um novo Produto ao BD.
	*/
	public static void addProduto(Produto produto) throws Exception {
		ProdutoRN.validarProduto(produto);
		ProdutoDAO.addProduto(produto);
	}
	
	/*
		Verifica e altera um produto existente no BD.
	*/
	public static void editarProduto(Produto produto) throws Exception {
		ProdutoRN.validarProduto(produto);
		ProdutoDAO.editarProduto(produto);
	}
	
	/*
		"Remover" um produto.
	*/
	public static void setStatusProduto(Produto produto, boolean status) throws Exception {
		produto.setStatus(status);
		ProdutoDAO.editarProduto(produto);
	}
	
}
