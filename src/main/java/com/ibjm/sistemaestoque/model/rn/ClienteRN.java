/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.rn;

import com.ibjm.sistemaestoque.model.vo.Cliente;

/**
 *
 * @author alcan
 */
public class ClienteRN {
	
    public static void validarCliente(Cliente cliente) throws Exception {
		
        if (cliente == null) {
                    throw new Exception("Cliente inválido!");
        }
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new Exception("Nome não pode ser nulo ou vazio!");
        }

        if (cliente.getCpf() == null || !cliente.getCpf().matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")) {
            throw new Exception("CPF inválido! Deve conter 11 dígitos.");
        }

        if (cliente.getRg() == null || cliente.getRg().trim().isEmpty()) {
            throw new Exception("RG não pode ser nulo ou vazio!");
        }
		
        if (cliente.getTelefone() == null) { // R E V E R
            throw new Exception("Telefone inválido! Deve conter 10 ou 11 dígitos.");
        }

        if (cliente.getEmail() == null || !cliente.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new Exception("Email inválido!");
        }

        if (cliente.getDataCadastro() == null || cliente.getDataCadastro().isAfter(java.time.LocalDate.now())) {
            throw new Exception("Data de cadastro inválida!");
        }
        
        if(cliente.getEmail().indexOf('@') == -1){
             throw new Exception("Email inválido!");
        }
        
    }
	
}
