/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.rn;

import com.ibjm.sistemaestoque.model.vo.Produto;

/**
 *
 * @author alcan
 */
public class ProdutoRN {
	
	public static void validarProduto(Produto produto) throws Exception {
		
		if (produto == null) {
			throw new Exception("Produto inválido!");
		}

		if (produto.getID()<= 0) {
			throw new IllegalArgumentException("ID inválido.");
		}

		if (produto.getMarca() == null || produto.getMarca().trim().isEmpty()) {
			throw new IllegalArgumentException("Marca não pode ser nula ou vazia.");
		}

		if (produto.getDescricao() == null || produto.getDescricao().trim().isEmpty()) {
			throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
		}

		if (produto.getValorCompra() <= 0) {
			throw new IllegalArgumentException("Valor de compra deve ser maior que zero.");
		}

		if (produto.getValorVenda() <= 0) {
			throw new IllegalArgumentException("Valor de venda deve ser maior que zero.");
		}

		if (produto.getQtdAtual() < 0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa.");
		}

		if (produto.getCategoria() == null || produto.getCategoria().trim().isEmpty()) {
			throw new IllegalArgumentException("Categoria não pode ser nula ou vazia.");
		}

		if (produto.getQtdMinima() < 0) {
			throw new IllegalArgumentException("Quantidade mínima não pode ser negativa.");
		}

		if (produto.getQtdMaxima() <= 0 || produto.getQtdMaxima() < produto.getQtdMinima()) {
			throw new IllegalArgumentException("Quantidade máxima deve ser maior que zero e maior ou igual à quantidade mínima.");
		}

		if (produto.getQtdAtual() < 0) {
			throw new IllegalArgumentException("Quantidade atual não pode ser negativa.");
		}

		if (produto.getUnidadeMedida() == null || produto.getUnidadeMedida().trim().isEmpty()) {
			throw new IllegalArgumentException("Unidade de medida não pode ser nula ou vazia.");
		}

		if (produto.getPeso() <= 0) {
			throw new IllegalArgumentException("Peso deve ser maior que zero.");
		}

		if (produto.getFornecedores() == null || produto.getFornecedores().isEmpty()) {
			throw new IllegalArgumentException("Deve haver pelo menos um fornecedor.");
		}

		if (produto.getDataFabricacao() == null) {
			throw new IllegalArgumentException("Data de fabricação não pode ser nula.");
		}

		if (produto.getDataValidade() == null || produto.getDataValidade().isBefore(produto.getDataFabricacao())) {
			throw new IllegalArgumentException("Data de validade não pode ser nula ou anterior à data de fabricação.");
		}

		if (produto.getDataCadastro() == null) {
			throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
		}
		
	}
	
}
