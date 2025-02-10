/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.rn;

import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import java.time.LocalDate;

/**
 *
 * @author alcan
 */
public class FornecedorRN {
	
	public static void validarFornecedor(Fornecedor fornecedor) throws Exception {
		
		if (fornecedor == null) {
            throw new Exception("Fornecedor inválido!");
		}
		
		if (fornecedor.getNome() == null || fornecedor.getNome().trim().isEmpty()) {
			throw new Exception("Nome não pode ser vazio.");
		}
		
		if (fornecedor.getCnpj() == null || !fornecedor.getCnpj().matches("\\d{14}")) {
			throw new Exception("CNPJ inválido.");
		}
		
		if (fornecedor.getInscricaoEstadual() == null || fornecedor.getInscricaoEstadual().trim().isEmpty()) {
			throw new Exception("Inscrição estadual não pode ser vazia.");
		}
		
		if (fornecedor.getCnae() == null || fornecedor.getCnae().trim().isEmpty()) {
			throw new Exception("CNAE não pode ser vazio.");
		}
		
		if (fornecedor.getEndereco() == null) {
			throw new Exception("Endereço não pode ser nulo.");
		}
		if (fornecedor.getTelefone() == null || !fornecedor.getTelefone().matches("\\d{10,11}")) {
			throw new Exception("Telefone inválido.");
		}
		
		if (fornecedor.getEmail() == null || !fornecedor.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			throw new Exception("Email inválido.");
		}
		
		if (fornecedor.getDataCadastro() == null || fornecedor.getDataCadastro().isAfter(LocalDate.now())) {
			throw new Exception("Data de cadastro inválida.");
		}
		
	}
	
}
