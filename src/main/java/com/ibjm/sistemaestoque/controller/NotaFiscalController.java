/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.controller;

import com.ibjm.sistemaestoque.model.dao.NotaFiscalDAO;
import com.ibjm.sistemaestoque.model.rn.NotaFiscalRN;
import com.ibjm.sistemaestoque.model.vo.NotaFiscal;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.util.ArrayList;

/**
 *
 * @author alcan
 */
public class NotaFiscalController {
	
	/*
		Converte um ArrayList com os Produtos em um array de objetos para
		colocar na tabela.
	*/
	public static Object[][] obterDadosNotaFiscal(ArrayList<NotaFiscal> arrayNotasFiscais) {
		// Vars aux
		int linha = 0;
		int coluna = 0;
		
		// Array que salvara os dados
		Object[][] arrayDados = new Object[arrayNotasFiscais.size()][8];
		
		// Passa pelo array list os colocando no array de objetos
		for (NotaFiscal notaFiscal : arrayNotasFiscais) {
			arrayDados[linha][coluna++] = String.format("%04d", notaFiscal.getID());
			arrayDados[linha][coluna++] = notaFiscal.getStatus();
			arrayDados[linha][coluna++] = notaFiscal.getCliente().getNome();
			arrayDados[linha][coluna++] = notaFiscal.getObservacao();
			arrayDados[linha][coluna++] = notaFiscal.getValorTotalString();
			arrayDados[linha][coluna++] = notaFiscal.getFormaPagamento();
			arrayDados[linha][coluna++] = notaFiscal.getDataCadastroString();
			arrayDados[linha++][coluna] = notaFiscal.getDataSaidaString();
			coluna = 0;
		}
		
		return arrayDados;
	}
	
	public static Object[][] obterDadosProdutoNotaFiscal(ArrayList<Produto> arrayListProdutos, ArrayList<Integer> qtds) {
		int linha = 0;
		int coluna = 0;
		
		Object[][] arrayDados = new Object[arrayListProdutos.size()][10];
		
		for (Produto produto : arrayListProdutos) {
			if (produto != null) {
				arrayDados[linha][coluna++] = String.format("%04d", produto.getID());
				arrayDados[linha][coluna++] = qtds.get(linha);
				arrayDados[linha][coluna++] = produto.getUnidadeMedida();
				arrayDados[linha][coluna++] = produto.getDescricao();
				arrayDados[linha][coluna++] = produto.getMarca();
				arrayDados[linha][coluna++] = produto.getValorVendaString();
				String valorTotal = produto.getValorVendaTotalString(qtds.get(linha));
				arrayDados[linha++][coluna] = valorTotal;
				coluna = 0;
			}
		}
		
		return arrayDados;
	}

	/*
		Verifica e adiciona um novo Cliente ao BD.
	*/
	public static void addNotaFiscal(NotaFiscal notaFiscal, ArrayList<Integer> arrayQtdProdutos) throws Exception {
		NotaFiscalRN.validarNotaFiscal(notaFiscal);
		NotaFiscalDAO.addNotaFiscal(notaFiscal);
		NotaFiscalDAO.addAssociacaoProdutos(notaFiscal, arrayQtdProdutos);
	}
	
	/*
		Verifica e altera um cliente existente no BD.
	*/
	public static void editarNotaFiscal(NotaFiscal notaFiscal, ArrayList<Integer> arrayQtdProdutos) throws Exception {
		NotaFiscalRN.validarNotaFiscal(notaFiscal);
		NotaFiscalDAO.editarNotaFiscal(notaFiscal);
		NotaFiscalDAO.addAssociacaoProdutos(notaFiscal, arrayQtdProdutos);
	}
	
	/*
		"Remover" um cliente.
	*/
	public static void setStatusNotaFiscal(NotaFiscal notaFiscal, String status) throws Exception {
		notaFiscal.setStatus(status);
		NotaFiscalDAO.editarNotaFiscal(notaFiscal);
		for (Produto produto : notaFiscal.getProdutos()) {
			NotaFiscalDAO.updateStatusProdutoNotaFiscal(notaFiscal.getID(), produto.getID(), notaFiscal.getStatusBoolean());
		}
	}
	
}
