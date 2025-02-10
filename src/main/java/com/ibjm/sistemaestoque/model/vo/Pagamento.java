/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.vo;

/**
 *
 * @author alcan
 */
public class Pagamento {
	
	private int id;
	private String descricao;
	private String formaPagamento;
	private double valor;

	public Pagamento(int id, String descricao, String formaPagamento, double valor) {
		this.id = id;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
		this.valor = valor;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
