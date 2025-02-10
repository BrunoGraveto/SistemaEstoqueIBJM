/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ibjm.sistemaestoque.controller;

import com.ibjm.sistemaestoque.model.dao.EnderecoDAO;
import com.ibjm.sistemaestoque.model.rn.EnderecoRN;
import com.ibjm.sistemaestoque.model.vo.Endereco;

/**
 *
 * @author alcan
 */
public class EnderecoController {
	
	/*
		Verifica e adiciona um novo Cliente ao BD.
	*/
	public static void addEndereco(Endereco endereco) throws Exception {
		EnderecoRN.validarEndereco(endereco);
		EnderecoDAO.addEndereco(endereco);
	}
	
	public static void editarEndereco(Endereco endereco) throws Exception {
		EnderecoRN.validarEndereco(endereco);
		EnderecoDAO.editarEndereco(endereco);
	}
	
}
