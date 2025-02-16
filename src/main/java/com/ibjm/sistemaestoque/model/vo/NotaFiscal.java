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
public class NotaFiscal {
	
	private int id;
	private boolean status;
	private String observacao;
	private Cliente cliente;
	private ArrayList<Produto> produtos;
	private double valorTotal;
	String formaPagamento;
	LocalDate dataCadastro;
	LocalDate dataSaida;

	public NotaFiscal(int id, boolean status, String observacao, Cliente cliente, ArrayList<Produto> produtos, double valorTotal, String formaPagamento, LocalDate dataCadastro, LocalDate dataSaida) {
		this.id = id;
		this.status = status;
		this.observacao = observacao;
		this.cliente = cliente;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.dataCadastro = dataCadastro;
		this.dataSaida = dataSaida;
	}
	
	public String getValorTotalString() {
		return "R$ " + valorTotal;
	}
	
	public String getDataCadastroString() {
		return dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getDataSaidaString() {
		return dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
}
