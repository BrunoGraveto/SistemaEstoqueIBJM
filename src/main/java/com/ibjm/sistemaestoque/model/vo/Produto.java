/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author alcan
 */
public class Produto {
	
	private int id;
	private boolean status;
	ArrayList<Fornecedor> fornecedores;
	private String marca;
	private String descricao;
	private double valorCompra;
	private double valorVenda;
	private String categoria;
	private int qtdMinima;
	private int qtdAtual;
	private int qtdMaxima;
	private String unidadeMedida;
	private double peso;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private LocalDate dataCadastro;

	public Produto(int id, boolean status, ArrayList<Fornecedor> fornecedores, String marca, String descricao, double valorCompra, double valorVenda, String categoria, int qtdMinima, int qtdAtual, int qtdMaxima, String unidadeMedida, double peso, LocalDate dataFabricacao, LocalDate dataValidade, LocalDate dataCadastro) {
		this.id = id;
		this.status = status;
		this.fornecedores = fornecedores;
		this.marca = marca;
		this.descricao = descricao;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.categoria = categoria;
		this.qtdMinima = qtdMinima;
		this.qtdAtual = qtdAtual;
		this.qtdMaxima = qtdMaxima;
		this.unidadeMedida = unidadeMedida;
		this.peso = peso;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.dataCadastro = dataCadastro;
	}
	
	public String getDataFabricacaoString() {
		return dataFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getDataValidadeString() {
		return dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getDataCadastroString() {
		return dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getAtividade() {
		if (status) {
			return "Ativo";
		} else {
			return "Inativo";
		}
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public int getQtdAtual() {
		return qtdAtual;
	}

	public void setQtdAtual(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}

	public int getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(int qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
}
