/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ibjm.sistemaestoque.view;

import com.ibjm.sistemaestoque.controller.ClienteController;
import com.ibjm.sistemaestoque.controller.FornecedorController;
import com.ibjm.sistemaestoque.controller.ProdutoController;
import com.ibjm.sistemaestoque.model.dao.ClienteDAO;
import com.ibjm.sistemaestoque.model.dao.FornecedorDAO;
import com.ibjm.sistemaestoque.model.dao.ProdutoDAO;
import com.ibjm.sistemaestoque.model.vo.Cliente;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alcan
 */
public class DialogProcurar extends javax.swing.JDialog {

	private int codSelecionado;
	String ambiente;
	
	/**
	 * Creates new form DialogSelecionar
	 * @param parent
	 * @param ambiente
	 */
	public DialogProcurar(JFrame parent, String ambiente) {
		super(parent, true);
		this.ambiente = ambiente;
		initComponents();
		setLocationRelativeTo(null);
		update();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        comboBoxFiltro = new javax.swing.JComboBox<>();
        lbFiltrar = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar Fornecedor");

        lbBuscar.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nome", "Inativos" }));
        comboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFiltroActionPerformed(evt);
            }
        });

        lbFiltrar.setText("Filtrar");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(table);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFiltrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        update();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void comboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFiltroActionPerformed
        update();
    }//GEN-LAST:event_comboBoxFiltroActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        try {
			codSelecionado = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi selecionado nenhum item!");
		}
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
		dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

	private void update() {
		try {
			// Tabela
			String[] cabecalho = null;
			Object[][] arrayDados = null;

			switch (ambiente) {
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
	//			cabecalho = new String[] {"Codigo", "Status", "Nome", "CNPJ", "Endereço", "Email", "Telefone", "Data Cadastro"};
	//			ArrayList<NotaFiscal> arrayNotasFiscais = NotaFiscalDAO.listarFornecedores();
	//			arrayDados = NotaFiscalController.obterDados(arrayNotasFiscais);
				}
			}

			// Altera a tabela
			table.setModel(new DefaultTableModel(arrayDados, cabecalho) {
				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			});
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Problema ao carregar tabela: " + e);
		}
	}
	
	public static int getIDSelecionado(JFrame frame, String ambiente) {
		DialogProcurar dialogProcurar = new DialogProcurar(frame, ambiente);
		dialogProcurar.setVisible(true);
		return dialogProcurar.codSelecionado;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> comboBoxFiltro;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbFiltrar;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
