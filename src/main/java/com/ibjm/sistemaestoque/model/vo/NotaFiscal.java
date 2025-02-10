/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author alcan
 */
public class NotaFiscal {
	
	private int id;
	private boolean status;
	private Cliente cliente;
	private String observacao;
	private ArrayList<Produto> produtos;
	private double valorProdutos;
	private double valorImpostos;
	private double valorTotal;
	Pagamento pagamento;
	LocalDate dataCadastro;

	public NotaFiscal(int id, boolean status, Cliente cliente, String observacao, ArrayList<Produto> produtos, double valorProdutos, double valorImpostos, double valorTotal, Pagamento pagamento, LocalDate dataCadastro) {
		this.id = id;
		this.status = status;
		this.cliente = cliente;
		this.observacao = observacao;
		this.produtos = produtos;
		this.valorProdutos = valorProdutos;
		this.valorImpostos = valorImpostos;
		this.valorTotal = valorTotal;
		this.pagamento = pagamento;
		this.dataCadastro = dataCadastro;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getValorProdutos() {
		return valorProdutos;
	}

	public void setValorProdutos(double valorProdutos) {
		this.valorProdutos = valorProdutos;
	}

	public double getValorImpostos() {
		return valorImpostos;
	}

	public void setValorImpostos(double valorImpostos) {
		this.valorImpostos = valorImpostos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	
}
