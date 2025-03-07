/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ibjm.sistemaestoque.view;

import com.ibjm.sistemaestoque.controller.ProdutoController;
import com.ibjm.sistemaestoque.model.dao.FornecedorDAO;
import com.ibjm.sistemaestoque.model.dao.ProdutoDAO;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author alcan
 */
public class FrameProduto extends javax.swing.JFrame {

	// Frame
	private FramePrincipal fp;
	private String modo;
	private int codSelecionado;
	ArrayList<Fornecedor> fornecedores;
	
	/**
	 * Creates new form FrameProduto
	 * @param fp
	 * @param modo
	 * @param codSelecionado
	 */
	public FrameProduto(FramePrincipal fp, String modo, int codSelecionado) {
		this.fp = fp;
		this.modo = modo;
		this.codSelecionado = codSelecionado;
		fornecedores = new ArrayList<>();
		initComponents();
		preencher();
		setLocationRelativeTo(fp);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        lbMarca = new javax.swing.JLabel();
        String[] categorias = {
            "Alimentos e Bebidas",
            "Eletrônicos",
            "Eletrodomésticos",
            "Roupas e Acessórios",
            "Automotivo",
            "Brinquedos",
            "Construção e Ferramentas",
            "Cosméticos e Perfumaria",
            "Esportes e Lazer",
            "Farmácia e Saúde",
            "Informática",
            "Livros e Papelaria",
            "Móveis e Decoração",
            "Pet Shop"
        };
        comboBoxCategoria = new javax.swing.JComboBox<>(categorias);
        lbCategoria = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lbValorCompra = new javax.swing.JLabel();
        txtValorCompra = new javax.swing.JTextField();
        txtValorVenda = new javax.swing.JTextField();
        lbValorVenda = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskData = null;
        try {
            maskData = new javax.swing.text.MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtDataCadastro = new javax.swing.JFormattedTextField(maskData);
        lbDataCadastro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbQtdMin = new javax.swing.JLabel();
        txtQtdMin = new javax.swing.JTextField();
        txtQtdMax = new javax.swing.JTextField();
        lbQtdMax = new javax.swing.JLabel();
        txtQtdAtual = new javax.swing.JTextField();
        lbQtdAtual = new javax.swing.JLabel();
        lbUnidadeMedida = new javax.swing.JLabel();
        txtUnidadeMedida = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        lbPeso = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbDataFabricacao = new javax.swing.JLabel();
        lbDataValidade = new javax.swing.JLabel();
        comboBoxFornecedores = new javax.swing.JComboBox<>();
        lbFornecedores = new javax.swing.JLabel();
        txtDataFabricacao = new javax.swing.JFormattedTextField(maskData);
        txtDataValidade = new javax.swing.JFormattedTextField(maskData);
        btnAddFornecedor = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        lbCodigo.setText("Codigo");

        txtCod.setEditable(false);

        lbMarca.setText("Marca");

        lbCategoria.setText("Categoria");

        lbDescricao.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lbValorCompra.setText("Valor Compra");

        lbValorVenda.setText("Valor Venda");

        txtDataCadastro.setEditable(false);

        lbDataCadastro.setText("Data Cadastro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescricao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtValorCompra, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbValorCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbValorVenda))))
                        .addGap(0, 334, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDataCadastro)
                            .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCategoria)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbDataCadastro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMarca)
                            .addComponent(lbCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorCompra)
                    .addComponent(lbValorVenda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades"));

        lbQtdMin.setText("Qtd. min.");

        lbQtdMax.setText("Qtd. max.");

        lbQtdAtual.setText("Qtd. atual");

        lbUnidadeMedida.setText("Uni. Medida");

        lbPeso.setText("Peso");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQtdMax)
                    .addComponent(txtQtdMax, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQtdAtual)
                    .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUnidadeMedida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPeso)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbUnidadeMedida)
                            .addComponent(lbPeso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbQtdMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbQtdMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbQtdAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fabricação"));

        lbDataFabricacao.setText("Data Fab.");

        lbDataValidade.setText("Data Val.");

        comboBoxFornecedores.setToolTipText("Para remover clique");
        comboBoxFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxFornecedoresMouseClicked(evt);
            }
        });

        lbFornecedores.setText("Fornecedores");

        btnAddFornecedor.setText("Add");
        btnAddFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDataFabricacao)
                    .addComponent(txtDataFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataValidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(comboBoxFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddFornecedor))
                    .addComponent(lbFornecedores))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataFabricacao)
                    .addComponent(lbDataValidade)
                    .addComponent(lbFornecedores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddFornecedor))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
			// Dados
			int id = Integer.parseInt(txtCod.getText());
			boolean status = true;
			String marca = txtMarca.getText();
			String descricao = txtDescricao.getText();
			double valorCompra = Double.parseDouble(txtValorCompra.getText());
			double valorVenda = Double.parseDouble(txtValorVenda.getText());
			String categoria = comboBoxCategoria.getSelectedItem().toString();
			int qtdMinima = Integer.parseInt(txtQtdMin.getText());
			int qtdAtual = Integer.parseInt(txtQtdAtual.getText());
			int qtdMaxima = Integer.parseInt(txtQtdMax.getText());
			String unidadeMedida = txtUnidadeMedida.getText();
			double peso = Double.parseDouble(txtPeso.getText());
			LocalDate dataFabricacao = LocalDate.parse(txtDataFabricacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate dataValidade = LocalDate.parse(txtDataValidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate dataCadastro = LocalDate.parse(txtDataCadastro.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			// Produto
			Produto produto = new Produto(id, status, fornecedores, marca, descricao, categoria, unidadeMedida, peso, valorCompra, valorVenda, qtdMinima, qtdAtual, qtdMaxima, dataFabricacao, dataValidade, dataCadastro);
			// Adiciona ou Edita
			if (modo.equals("Adicionar")) {
				ProdutoController.addProduto(produto);
				JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
			} else if (modo.equals("Editar")) {
				ProdutoController.editarProduto(produto);
				JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
			}
			// Fecha e atualiza
			dispose();
			fp.selecionar("Produtos");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Problema ao gerenciar Produto: " + e);
		}
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAddFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFornecedorActionPerformed
		try {
			int codFornecedorSelecionado = DialogProcurar.getIDSelecionado(this, "Fornecedores");
			Fornecedor fornecedorSelecionado = FornecedorDAO.encontrarFornecedor(codFornecedorSelecionado);
			
			// Verifica se o fornecedor ja esta presente no array
			boolean encontrado = false;
			for (Fornecedor fornecedor : fornecedores) {
				if (fornecedor.getID() == codFornecedorSelecionado) {
					encontrado = true;
					JOptionPane.showMessageDialog(this, "Esse fornecedor já foi adicionado!");
					break;
				}
			}
			
			// Se não foi adiciona
			if (!encontrado) {
				fornecedores.add(fornecedorSelecionado);
				updateComboBoxFornecedores();
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Problema ao adicionar Fornecedor ao Produto!");
		}
    }//GEN-LAST:event_btnAddFornecedorActionPerformed

    private void comboBoxFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxFornecedoresMouseClicked
        if (fornecedores.size() > 0) {
			if (DialogConfirmar.confirmar(this, "Tem certeza que deseja remover esse Fornecedor?")) {
				int indexFornecedorRemover = comboBoxFornecedores.getSelectedIndex();
				fornecedores.remove(indexFornecedorRemover);
				updateComboBoxFornecedores();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Não há nenhum fornecedor para remover!");
		}
    }//GEN-LAST:event_comboBoxFornecedoresMouseClicked
	
	private void updateComboBoxFornecedores() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for (Fornecedor fornecedor : fornecedores) {
			model.addElement(fornecedor.getNome());
		}
		comboBoxFornecedores.setModel(model);
	}
	
	private void preencher() {
		try {
			// Caso esteja adicionando um Produto
			if (modo.equals("Adicionar")) {
				txtCod.setText(String.format("%04d", ProdutoDAO.getCountProdutos()+1)+"");
				txtDataCadastro.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			} 
			// Caso esteja editando um Produto
			else if (modo.equals("Editar")) {
				Produto produto = ProdutoDAO.encontrarProduto(codSelecionado);
				txtCod.setText(produto.getID()+"");
				txtDataCadastro.setText(produto.getDataCadastroString());
				txtMarca.setText(produto.getMarca());
				txtDescricao.setText(produto.getDescricao());
				txtValorCompra.setText(String.valueOf(produto.getValorCompra()));
				txtValorVenda.setText(String.valueOf(produto.getValorVenda()));
				comboBoxCategoria.setSelectedItem(produto.getCategoria());
				txtQtdMin.setText(String.valueOf(produto.getQtdMinima()));
				txtQtdAtual.setText(String.valueOf(produto.getQtdAtual()));
				txtQtdMax.setText(String.valueOf(produto.getQtdMaxima()));
				txtUnidadeMedida.setText(produto.getUnidadeMedida());
				txtPeso.setText(String.valueOf(produto.getPeso()));
				txtDataFabricacao.setText(produto.getDataFabricacaoString());
				txtDataValidade.setText(produto.getDataValidadeString());
				txtDataCadastro.setText(produto.getDataCadastroString());
				fornecedores = produto.getFornecedores();
				updateComboBoxFornecedores();
				// Focusable
				txtCod.setFocusable(false);
				txtDataCadastro.setFocusable(false);
				txtMarca.setFocusable(true);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFornecedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> comboBoxFornecedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDataCadastro;
    private javax.swing.JLabel lbDataFabricacao;
    private javax.swing.JLabel lbDataValidade;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbFornecedores;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbPeso;
    private javax.swing.JLabel lbQtdAtual;
    private javax.swing.JLabel lbQtdMax;
    private javax.swing.JLabel lbQtdMin;
    private javax.swing.JLabel lbUnidadeMedida;
    private javax.swing.JLabel lbValorCompra;
    private javax.swing.JLabel lbValorVenda;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JFormattedTextField txtDataFabricacao;
    private javax.swing.JFormattedTextField txtDataValidade;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtQtdAtual;
    private javax.swing.JTextField txtQtdMax;
    private javax.swing.JTextField txtQtdMin;
    private javax.swing.JTextField txtUnidadeMedida;
    private javax.swing.JTextField txtValorCompra;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
}
