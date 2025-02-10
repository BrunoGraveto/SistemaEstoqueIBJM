/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alcan
 */
public class Cliente {
	
	private int id;
	private boolean status;
	private String nome;
	private String cpf;
	private String rg;
	private Endereco endereco;
	private String telefone;
	private String email;
	private LocalDate dataCadastro;

	public Cliente(int id, boolean status, String nome, String cpf, String rg, Endereco endereco, String telefone, String email, LocalDate dataCadastro) {
		this.id = id;
		this.status = status;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
