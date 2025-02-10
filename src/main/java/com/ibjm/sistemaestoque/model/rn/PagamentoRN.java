/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.rn;

import com.ibjm.sistemaestoque.model.vo.Pagamento;

/**
 *
 * @author alcan
 */
public class PagamentoRN {
	
	public static void validarPagamento(Pagamento pagamento) throws Exception {
		
		if (pagamento == null) {
            throw new Exception("Pagamento inválido!");
		}
		
		if (pagamento.getID()<= 0) {
			throw new Exception("ID deve ser maior que zero.");
		}
		
		if (pagamento.getDescricao() == null || pagamento.getDescricao().trim().isEmpty()) {
			throw new Exception("Descrição não pode ser vazia.");
		}
		
		if (pagamento.getFormaPagamento() == null || pagamento.getFormaPagamento().trim().isEmpty()) {
			throw new Exception("Forma de pagamento não pode ser vazia.");
		}
		
		if (pagamento.getValor() <= 0) {
			throw new Exception("Valor deve ser maior que zero.");
		}
		
	}
	
}
