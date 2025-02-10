/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.vo;

/**
 *
 * @author alcan
 */
public class Endereco {
	
	private int id;
	private String rua;
	private String bairro;
	private int num;
	private String cep;
	private String cidade;
	private String estado;

	public Endereco(int id, String rua, String bairro, int num, String cep, String cidade, String estado) {
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.num = num;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String endereco) {
		this.rua = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
