/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.rn;

import com.ibjm.sistemaestoque.model.vo.Endereco;

/**
 *
 * @author alcan
 */

public class EnderecoRN {

    public static void validarEndereco(Endereco endereco) throws Exception {
		
        if (endereco == null) {
            throw new Exception("Endereco inválido!");
        }
		
        if (endereco.getID() <= 0) {
            throw new IllegalArgumentException("ID deve ser um valor positivo.");
        }
		
        if (endereco.getRua() == null || endereco.getRua().isEmpty()) {
            throw new IllegalArgumentException("Rua não pode ser nula ou vazia.");
        }
		
        if (endereco.getBairro() == null || endereco.getBairro().isEmpty()) {
            throw new IllegalArgumentException("Bairro não pode ser nulo ou vazio.");
        }
		
        if (endereco.getNum() <= 0) {
            throw new IllegalArgumentException("Número deve ser um valor positivo.");
        }
		
        if (endereco.getCep() == null || !endereco.getCep().matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido.");
        }
		
        if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia.");
        }
		
        if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
            throw new IllegalArgumentException("Estado não pode ser nulo ou vazio.");
        }
		
    }
}