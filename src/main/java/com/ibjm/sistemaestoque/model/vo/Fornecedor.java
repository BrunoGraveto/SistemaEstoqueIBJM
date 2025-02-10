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
public class Fornecedor {
	
	private int id;
	private boolean status;
	private String nome;
	private String cnpj;
	private String inscricaoEstadual;
	private String cnae;
	private Endereco endereco;
	private String telefone;
	private String email;
	private LocalDate dataCadastro;

	public Fornecedor(int id, boolean status, String nome, String cnpj, String inscricaoEstadual, String cnae, Endereco endereco, String telefone, String email, LocalDate dataCadastro) {
		this.id = id;
		this.status = status;
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.cnae = cnae;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
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
