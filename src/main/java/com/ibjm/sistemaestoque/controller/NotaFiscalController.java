/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.controller;

import com.ibjm.sistemaestoque.model.vo.NotaFiscal;
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
	public static Object[][] obterDados(ArrayList<NotaFiscal> arrayProdutos) {
		// Vars aux
		int linha = 0;
		int coluna = 0;
		
		// Array que salvara os dados
		Object[][] arrayDados = new Object[arrayProdutos.size()][6];
		
		// Passa pelo array list os colocando no array de objetos
		for (NotaFiscal notaFiscal : arrayProdutos) {
			arrayDados[linha][coluna++] = notaFiscal.getID();
			arrayDados[linha][coluna++] = notaFiscal.getStatus();
			arrayDados[linha][coluna++] = notaFiscal.getObservacao();
			arrayDados[linha][coluna++] = notaFiscal.getValorTotal();
			arrayDados[linha][coluna++] = notaFiscal.getPagamento();
			arrayDados[linha++][coluna++] = notaFiscal.getDataCadastro();
			coluna = 0;
		}
		
		return arrayDados;
	}
	
}
