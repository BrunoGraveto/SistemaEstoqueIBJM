/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ibjm.sistemaestoque.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author alcan
 */
public class PanelProcurar extends javax.swing.JPanel {

	FramePrincipal fp;
	
	/**
	 * Creates new form PanelProcurar
	 * @param fp
	 */
	public PanelProcurar(FramePrincipal fp) {
		this.fp = fp;
		initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRR = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(table);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAddEditarActionPerformed("Adicionar");
            }
        });
        btnAdd.setText("Adicionar");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAddEditarActionPerformed("Editar");
            }
        });

        btnRR.setText("Remover");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRR)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFiltrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEditar)
                    .addComponent(btnRR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void comboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFiltroActionPerformed

    }//GEN-LAST:event_comboBoxFiltroActionPerformed

	private void btnAddEditarActionPerformed(String modoBtn) {
		String acao = "";
		int codSelecionado = 0;
		if (modoBtn.equals("Adicionar")) {
			acao = "Adicionar";
			codSelecionado = -1;
		} else if (modoBtn.equals("Editar")) {
			acao = "Editar";
			codSelecionado = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		}
		
		switch (fp.modo) {
		case "Produtos" -> {
			// Frame Produto
			FrameProduto fpdt = new FrameProduto(fp, acao, codSelecionado);
			fpdt.setVisible(true);
			}
		case "Clientes" -> {
			// Frame Cliente
			FrameCliente fc = new FrameCliente(fp, acao, codSelecionado);
			fc.setVisible(true);
			}
		case "Fornecedores" -> {
			// Frame Fornecedor
			FrameFornecedor ff = new FrameFornecedor(fp, acao, codSelecionado);
			ff.setVisible(true);
			}
		case "NotasFiscais" -> {
			// Frame NotaFiscal
			FrameNotaFiscal fnf = new FrameNotaFiscal(fp);
			fnf.setVisible(true);
			}
		}
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRR;
    private javax.swing.JComboBox<String> comboBoxFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbFiltrar;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
