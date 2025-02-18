/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ibjm.sistemaestoque.view;

import com.ibjm.sistemaestoque.controller.ClienteController;
import com.ibjm.sistemaestoque.controller.FornecedorController;
import com.ibjm.sistemaestoque.controller.NotaFiscalController;
import com.ibjm.sistemaestoque.controller.ProdutoController;
import com.ibjm.sistemaestoque.model.dao.ClienteDAO;
import com.ibjm.sistemaestoque.model.dao.FornecedorDAO;
import com.ibjm.sistemaestoque.model.dao.NotaFiscalDAO;
import com.ibjm.sistemaestoque.model.dao.ProdutoDAO;
import com.ibjm.sistemaestoque.model.vo.Cliente;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import com.ibjm.sistemaestoque.model.vo.NotaFiscal;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alcan
 */
public class FramePrincipal extends javax.swing.JFrame {

	String ambiente = "";
	boolean first = true;
	
	/**
	 * Creates new form FramePrincipal
	 */
	public FramePrincipal() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(this, "Problema ao carregar tema do sistema: " + e);
		}
		initComponents();
		setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
		update();
		setFocusable(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAmbientes = new javax.swing.JPanel();
        btnProdutos = new javax.swing.JToggleButton();
        btnClientes = new javax.swing.JToggleButton();
        btnFornecedores = new javax.swing.JToggleButton();
        btnNotasFiscais = new javax.swing.JToggleButton();
        texFornecedores = new javax.swing.JLabel();
        texNotaFiscal = new javax.swing.JLabel();
        texProdutos = new javax.swing.JLabel();
        texCliente = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panelOperacoes = new javax.swing.JPanel();
        lbBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        comboBoxFiltro = new javax.swing.JComboBox<>();
        lbFiltrar = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        brnRR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IBJM");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelAmbientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-estoque.jpg"))); // NOI18N
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-cliente.png"))); // NOI18N
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-fornecedor.png"))); // NOI18N
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });

        btnNotasFiscais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-nota-fiscal.png"))); // NOI18N
        btnNotasFiscais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasFiscaisActionPerformed(evt);
            }
        });

        texFornecedores.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        texFornecedores.setText("Fornecedores");

        texNotaFiscal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        texNotaFiscal.setText("Notas Fiscais");

        texProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        texProdutos.setText("Estoque");

        texCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        texCliente.setText("Clientes");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Sair");

        javax.swing.GroupLayout panelAmbientesLayout = new javax.swing.GroupLayout(panelAmbientes);
        panelAmbientes.setLayout(panelAmbientesLayout);
        panelAmbientesLayout.setHorizontalGroup(
            panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAmbientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(texProdutos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAmbientesLayout.createSequentialGroup()
                        .addComponent(texCliente)
                        .addGap(23, 23, 23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(texFornecedores)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNotasFiscais, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(texNotaFiscal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        panelAmbientesLayout.setVerticalGroup(
            panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAmbientesLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNotasFiscais, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texProdutos))
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texCliente))
                    .addComponent(btnFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAmbientesLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panelAmbientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texNotaFiscal)
                            .addComponent(texFornecedores))))
                .addContainerGap())
        );

        panelOperacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelOperacoes.setVisible(false);

        lbBuscar.setText("Buscar");
        lbBuscar.setVisible(false);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        txtBuscar.setVisible(false);

        comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nome", "Inativos" }));
        comboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFiltroActionPerformed(evt);
            }
        });
        comboBoxFiltro.setVisible(false);

        lbFiltrar.setText("Filtrar");
        lbFiltrar.setVisible(false);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEditarActionPerformed("Adicionar");
            }
        });

        btnAdicionar.setVisible(false);

        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEditarActionPerformed("Editar");
            }
        });

        brnRR.setText("Remover");
        brnRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnRRActionPerformed(evt);
            }
        });

        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.setVisible(false);
        jScrollPane1.setVisible(false);

        javax.swing.GroupLayout panelOperacoesLayout = new javax.swing.GroupLayout(panelOperacoes);
        panelOperacoes.setLayout(panelOperacoesLayout);
        panelOperacoesLayout.setHorizontalGroup(
            panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOperacoesLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperacoesLayout.createSequentialGroup()
                        .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelOperacoesLayout.createSequentialGroup()
                                .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelOperacoesLayout.createSequentialGroup()
                                        .addComponent(lbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addGap(516, 516, 516))
                                    .addComponent(txtBuscar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelOperacoesLayout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(brnRR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        panelOperacoesLayout.setVerticalGroup(
            panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelOperacoesLayout.createSequentialGroup()
                        .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBuscar)
                            .addComponent(lbFiltrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnAdicionar)
                    .addComponent(brnRR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelOperacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelAmbientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAmbientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOperacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
		comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Codigo", "Descrição", "Marca", "Inativos"}));
		txtBuscar.setText("");
		btnProdutos.setEnabled(false);
		btnClientes.setEnabled(true);
		btnNotasFiscais.setEnabled(true);
		btnFornecedores.setEnabled(true);
		texProdutos.setFont(new Font("Arial", Font.BOLD, 12));
		texCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		texFornecedores.setFont(new Font("Arial", Font.PLAIN, 12));
		texNotaFiscal.setFont(new Font("Arial", Font.PLAIN, 12));
		selecionar("Produtos");
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
		comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Codigo", "Nome", "CPF", "RG", "Telefone", "Email", "Inativos"}));
		txtBuscar.setText("");
		btnProdutos.setEnabled(true);
		btnClientes.setEnabled(false);
		btnNotasFiscais.setEnabled(true);
		btnFornecedores.setEnabled(true);
		texProdutos.setFont(new Font("Arial", Font.PLAIN, 12));
		texCliente.setFont(new Font("Arial", Font.BOLD, 12));
		texFornecedores.setFont(new Font("Arial", Font.PLAIN, 12));
		texNotaFiscal.setFont(new Font("Arial", Font.PLAIN, 12));
		selecionar("Clientes");
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
		comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Codigo", "Nome Fantasia", "CNPJ", "Inscrição Estadual", "CNAE", "Telefone", "Email"}));
		txtBuscar.setText("");
		btnProdutos.setEnabled(true);
		btnClientes.setEnabled(true);
		btnNotasFiscais.setEnabled(true);
		btnFornecedores.setEnabled(false);
		texProdutos.setFont(new Font("Arial", Font.PLAIN, 12));
		texCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		texFornecedores.setFont(new Font("Arial", Font.BOLD, 12));
		texNotaFiscal.setFont(new Font("Arial", Font.PLAIN, 12));
		selecionar("Fornecedores");
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnNotasFiscaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasFiscaisActionPerformed
		comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Número", "Observação", "Cliente", "Finalizadas", "Inativos"}));
		txtBuscar.setText("");
		btnProdutos.setEnabled(true);
		btnClientes.setEnabled(true);
		btnNotasFiscais.setEnabled(false);
		btnFornecedores.setEnabled(true);
		texProdutos.setFont(new Font("Arial", Font.PLAIN, 12));
		texCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		texFornecedores.setFont(new Font("Arial", Font.PLAIN, 12));
		texNotaFiscal.setFont(new Font("Arial", Font.BOLD, 12));
		selecionar("NotasFiscais");
    }//GEN-LAST:event_btnNotasFiscaisActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        update();
    }//GEN-LAST:event_tableMouseClicked

    private void brnRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnRRActionPerformed
        String msg;
        boolean status = comboBoxFiltro.getSelectedItem().toString().equals("Inativos");
        if (status) {
            msg = "restaurar";
        } else {
            msg = "remover";
        }
        try {
            if (DialogConfirmar.confirmar(this, "Tem certeza que deseja " + msg + " esse item?")) {
                switch (ambiente) {
                    case "Produtos" -> {
                        ProdutoController.setStatusProduto(ProdutoDAO.encontrarProduto(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())), status);
                    }
                    case "Clientes" -> {
                        ClienteController.setStatusCliente(ClienteDAO.encontrarCliente(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())), status);
                    }
                    case "Fornecedores" -> {
                        FornecedorController.setStatusFornecedor(FornecedorDAO.encontrarFornecedor(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())), status);
                    }
                    case "NotasFiscais" -> {
						String statusNotaFiscal = "";
						if (status) {
							statusNotaFiscal = "Ativo";
						} else {
							statusNotaFiscal = "Inativo";
						}
						NotaFiscalController.setStatusNotaFiscal(NotaFiscalDAO.encontrarNotaFiscal(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())), statusNotaFiscal);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        selecionar(ambiente);
    }//GEN-LAST:event_brnRRActionPerformed

    private void comboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFiltroActionPerformed
        txtBuscar.setText("");
		selecionar(ambiente);
    }//GEN-LAST:event_comboBoxFiltroActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        selecionar(ambiente);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

	/*
		Clique na janela(ao todo).
	*/
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        table.setFocusable(false);
        table.setSelectionMode(HIDE_ON_CLOSE);
        update();
    }//GEN-LAST:event_formMouseClicked

	private void btnAdicionarEditarActionPerformed(String ambienteBtn) {
		String acao = "";
		int codSelecionado = 0;
		if (ambienteBtn.equals("Adicionar")) {
			acao = "Adicionar";
			codSelecionado = -1;
		} else if (ambienteBtn.equals("Editar")) {
			acao = "Editar";
			codSelecionado = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		}
		
		switch (ambiente) {
		case "Produtos" -> {
			// Frame Produto
			FrameProduto fpdt = new FrameProduto(this, acao, codSelecionado);
			fpdt.setVisible(true);
			}
		case "Clientes" -> {
			// Frame Cliente
			FrameCliente fc = new FrameCliente(this, acao, codSelecionado);
			fc.setVisible(true);
			}
		case "Fornecedores" -> {
			// Frame Fornecedor
			FrameFornecedor ff = new FrameFornecedor(this, acao, codSelecionado);
			ff.setVisible(true);
			}
		case "NotasFiscais" -> {
			// Frame NotaFiscal
			FrameNotaFiscal fnf = new FrameNotaFiscal(this, acao, codSelecionado);
			fnf.setVisible(true);
			}
		}
	}
	
	/*
		De acordo com o que o usuário selecionar, deixa o botão de tabela ativo ou não.
	*/
	public void selecionar(String ambienteSelecionado) {
		
		if (first) {
			lbBuscar.setVisible(true);
			txtBuscar.setVisible(true);
			lbFiltrar.setVisible(true);
			comboBoxFiltro.setVisible(true);
			btnAdicionar.setVisible(true);
			table.setVisible(true);
			jScrollPane1.setVisible(true);
			
			first = false;
		}
		
		panelOperacoes.setVisible(true);
		try {
			String[] cabecalho = null;
			Object[][] arrayDados = null;

			// Deixa o selecionado ativo
			switch (ambienteSelecionado) {
			case "Produtos" -> {
				cabecalho = new String[] {"Codigo", "Status", "Marca", "Descrição", "Categoria", "Uni. Medida", "Peso", "Val. Compra", "Val. Venda", "Qtd. Mín.", "Qtd. Atual", "Qtd. Max.", "Data Fab.", "Data Val.", "Data Cadastro"};
				ArrayList<Produto> arrayProdutos = ProdutoDAO.listarProdutos(comboBoxFiltro.getSelectedItem().toString(), txtBuscar.getText());
				arrayDados = ProdutoController.obterDados(arrayProdutos);
				}
			case "Clientes" -> {
				cabecalho = new String[] {"Codigo", "Status", "Nome", "CPF", "RG", "Endereço", "Telefone", "Email", "Data Cadastro"};
				ArrayList<Cliente> arrayClientes = ClienteDAO.listarClientes(comboBoxFiltro.getSelectedItem().toString(), txtBuscar.getText());
				arrayDados = ClienteController.obterDados(arrayClientes);
				}
			case "Fornecedores" -> {
				cabecalho = new String[] {"Codigo", "Status", "Nome", "CNPJ", "Inscrição Estadual", "CNAE", "Endereço", "Telefone", "Email", "Data Cadastro"};
				ArrayList<Fornecedor> arrayFornecedores = FornecedorDAO.listarFornecedores(comboBoxFiltro.getSelectedItem().toString(), txtBuscar.getText());
				arrayDados = FornecedorController.obterDados(arrayFornecedores);
				}
			case "NotasFiscais" -> {
				cabecalho = new String[] {"Codigo", "Status", "Nome Cliente", "Observação", "Val. Total", "Forma Pag.", "Data Cadastro", "Data Saída"};
				ArrayList<NotaFiscal> arrayNotasFiscais = NotaFiscalDAO.listarNotasFiscais(comboBoxFiltro.getSelectedItem().toString(), txtBuscar.getText());
				arrayDados = NotaFiscalController.obterDadosNotaFiscal(arrayNotasFiscais);
				}
			}

			// Altera a tabela e não deixa editar
			table.setModel(new DefaultTableModel(arrayDados, cabecalho) {
				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			});
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e);
		}
		
		ambiente = ambienteSelecionado;
		update();
	}
	
	/*
		Atualiza os componentes do frame.
	*/
	private void update() {
		// Verifica a ação do botão excluir
		if (comboBoxFiltro.getSelectedItem().toString().equals("Inativos")) {
			brnRR.setText("Restaurar");
		} else {
			brnRR.setText("Remover");
		}
		
		// Deixa ativado ou não as operações
		if (ambiente.equals("")) {
			txtBuscar.setEnabled(false);
			comboBoxFiltro.setEnabled(false);
			btnAdicionar.setEnabled(false);
		} else {
			txtBuscar.setEnabled(true);
			comboBoxFiltro.setEnabled(true);
			btnAdicionar.setEnabled(true);
		}
		
		// Mostra ou não as opções de editar ou remover se a tabela estiver selecionada
		if (table.getSelectedRow() != -1) {
			btnEditar.setVisible(true);
			brnRR.setVisible(true);
		} else { 
			btnEditar.setVisible(false);
			brnRR.setVisible(false);
		}
		
		revalidate();
		repaint();
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnRR;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JToggleButton btnClientes;
    private javax.swing.JButton btnEditar;
    private javax.swing.JToggleButton btnFornecedores;
    private javax.swing.JToggleButton btnNotasFiscais;
    private javax.swing.JToggleButton btnProdutos;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> comboBoxFiltro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbFiltrar;
    private javax.swing.JPanel panelAmbientes;
    private javax.swing.JPanel panelOperacoes;
    private javax.swing.JTable table;
    private javax.swing.JLabel texCliente;
    private javax.swing.JLabel texFornecedores;
    private javax.swing.JLabel texNotaFiscal;
    private javax.swing.JLabel texProdutos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
