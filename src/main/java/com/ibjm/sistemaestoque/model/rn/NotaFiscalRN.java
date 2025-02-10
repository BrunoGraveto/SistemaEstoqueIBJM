/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.model.rn;

import com.ibjm.sistemaestoque.model.vo.NotaFiscal;
import java.time.LocalDate;

/**
 *
 * @author alcan
 */
public class NotaFiscalRN {
    
    public static void validarNotaFiscal(NotaFiscal notaFiscal) throws Exception {
        
        if (notaFiscal == null) {
            throw new Exception("Nota Fiscal inválida: o objeto NotaFiscal está nulo.");
        }
		
        if (notaFiscal.getID() <= 0) {
            throw new Exception("ID inválido: o ID deve ser um número positivo.");
        }
		
        if (notaFiscal.getCliente() == null) {
            throw new Exception("Cliente inválido: o cliente não pode ser nulo.");
        }
		
        if (notaFiscal.getObservacao() == null || notaFiscal.getObservacao().trim().isEmpty()) {
            notaFiscal.setObservacao("Sem observações.");
        }
		
        if (notaFiscal.getProdutos() == null || notaFiscal.getProdutos().isEmpty()) {
            throw new Exception("Produtos inválidos: a lista de produtos não pode ser vazia ou nula.");
        }
		
        for (int i = 0; i < notaFiscal.getProdutos().size(); i++) {
            if (notaFiscal.getProdutos().get(i) == null) {
                throw new Exception("Produto inválido na posição " + i + ": o produto não pode ser nulo.");
            }
        }
		
        if (notaFiscal.getValorProdutos() < 0) {
            throw new Exception("Valor dos produtos inválido: não pode ser negativo.");
        }
		
        if (notaFiscal.getValorImpostos() < 0) {
            throw new Exception("Valor dos impostos inválido: não pode ser negativo.");
        }
		
        double valorTotalCalculado = notaFiscal.getValorProdutos() + notaFiscal.getValorImpostos();
		
        if (notaFiscal.getValorTotal() != valorTotalCalculado) {
            throw new Exception("Valor total inválido: deve ser igual à soma do valor dos produtos e impostos.");
        }
		
        if (notaFiscal.getPagamento() == null) {
            throw new Exception("Informação de pagamento inválida: o pagamento não pode ser nulo.");
        }
		
        if (notaFiscal.getDataCadastro() == null || notaFiscal.getDataCadastro().isAfter(LocalDate.now())) {
            throw new Exception("Data de cadastro inválida: não pode ser nula ou futura.");
        }
		
    }
}