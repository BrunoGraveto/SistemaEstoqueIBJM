/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ibjm.sistemaestoque.view;

import com.ibjm.sistemaestoque.controller.FornecedorController;
import com.ibjm.sistemaestoque.model.dao.FornecedorDAO;
import com.ibjm.sistemaestoque.model.vo.Fornecedor;
import com.ibjm.sistemaestoque.model.vo.Endereco;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author alcan
 */
public class FrameFornecedor extends javax.swing.JFrame {

	// Frame
	private FramePrincipal fp;
	private String modo;
	private int codSelecionado;
	
	/**
	 * Creates new form FrameFornecedor
	 * @param fp
	 * @param modo
	 * @param codSelecionado
	 */
	public FrameFornecedor(FramePrincipal fp, String modo ,int codSelecionado) {
		this.fp = fp;
		this.modo = modo;
		this.codSelecionado = codSelecionado;
		initComponents();
		preencher();
		setLocationRelativeTo(fp);
		txtCod.setFocusable(false);
		txtDataCadastro.setFocusable(false);
		txtNomeFantasia.setFocusable(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        lbDataCadastro = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        lbNomeFantasia = new javax.swing.JLabel();
        lbCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        txtInscricaoEstadual = new javax.swing.JTextField();
        lbInscricaoEstadual = new javax.swing.JLabel();
        lbCnae = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskData = null;
        try {
            maskData = new javax.swing.text.MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtDataCadastro = new javax.swing.JFormattedTextField(maskData);
        javax.swing.text.MaskFormatter maskCnae = null;
        try {
            maskCnae = new javax.swing.text.MaskFormatter("####-#/##");
            maskCnae.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtCnae = new javax.swing.JFormattedTextField(maskCnae);
        jPanel2 = new javax.swing.JPanel();
        lbRua = new javax.swing.JLabel();
        txtEndRua = new javax.swing.JTextField();
        txtEndNum = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        lbCep = new javax.swing.JLabel();
        comboBoxEndEstado = new javax.swing.JComboBox<>();
        lbEstado = new javax.swing.JLabel();
        lbBairro = new javax.swing.JLabel();
        txtEndBairro = new javax.swing.JTextField();
        txtEndCidade = new javax.swing.JTextField();
        lbCidade = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskCep = null;
        try {
            maskCep = new javax.swing.text.MaskFormatter("#####-###");
            maskCep.setPlaceholderCharacter('_');
        } catch(Exception e) {
            e.printStackTrace();
        }
        txtEndCep = new javax.swing.JFormattedTextField(maskCep);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedor");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        lbCod.setText("Codigo");

        txtCod.setEditable(false);

        lbDataCadastro.setText("Data Cadastro");

        lbNomeFantasia.setText("Nome Fantasia");

        lbCnpj.setText("CNPJ");

        lbInscricaoEstadual.setText("Inscrição Estadual");

        lbCnae.setText("CNAE");

        txtDataCadastro.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbCod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCod))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDataCadastro)
                                .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtCnpj))
                    .addComponent(lbCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNomeFantasia)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNomeFantasia)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lbInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCnae)
                            .addComponent(txtCnae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCod)
                    .addComponent(lbDataCadastro)
                    .addComponent(lbNomeFantasia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCnpj)
                    .addComponent(lbInscricaoEstadual)
                    .addComponent(lbCnae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        lbRua.setText("Rua");

        lbNumero.setText("Número");

        lbCep.setText("CEP");

        comboBoxEndEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Acre", "Alagoas", "Amazonas", "Bahia", "Ceará", "Espírito Santo",
            "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
            "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro",
            "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima",
            "Santa Catarina", "São Paulo", "Sergipe", "Tocantins", "Distrito Federal"
        }));

        lbEstado.setText("Estado");

        lbBairro.setText("Bairro");

        lbCidade.setText("Cidade");

        lbTelefone.setText("Telefone");

        lbEmail.setText("Email");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEndNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbCep)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbEstado)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboBoxEndEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEndBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbBairro, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCidade)
                                    .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTelefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(lbNumero)
                    .addComponent(lbCep)
                    .addComponent(lbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEndEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro)
                    .addComponent(lbCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(lbEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
			// ID ambos
			int id = Integer.parseInt(txtCod.getText());
			// Endereço
			String rua = txtEndRua.getText();
			String bairro = txtEndBairro.getText();
			int num = Integer.parseInt(txtEndNum.getText());
			String cep = txtEndCep.getText();
			String cidade = txtEndCidade.getText();
			String estado = comboBoxEndEstado.getSelectedItem().toString();
			Endereco endereco = new Endereco(id, rua, bairro, num, cep, cidade, estado);
			// Fornecedor
			String nome = txtNomeFantasia.getText();
			String cnpj = txtCnpj.getText();
			String inscricaoEstadual = txtInscricaoEstadual.getText();
			String cnae = txtCnae.getText();
			String email = txtEmail.getText();
			String telefone = txtTelefone.getText();
			LocalDate dataCadastro = LocalDate.parse(txtDataCadastro.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Fornecedor fornecedor = new Fornecedor(id, true, nome, cnpj, inscricaoEstadual, cnae, endereco, telefone, email, dataCadastro);
			// Adicionar ou editar
			if (modo.equals("Adicionar")) {
				FornecedorController.addFornecedor(fornecedor);
				JOptionPane.showMessageDialog(this, "Fornecedor adicionado com sucesso!");
			} else if (modo.equals("Editar")) {
				FornecedorController.editarFornecedor(fornecedor);
				JOptionPane.showMessageDialog(this, "Fornecedor alterado com sucesso!");
			}
			// Fecha e atualiza
			dispose();
			fp.selecionar("Fornecedores");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao adicionar Fornecedor: " + e.getMessage());
		}
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

	private void preencher() {
		try {
		// Caso esteja adicionando um fornecedor
		if (modo.equals("Adicionar")) {
			txtCod.setText(String.format("%04d", FornecedorDAO.getCountFornecedores()+1)+"");
			txtDataCadastro.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		} 
		// Caso esteja editando um fornecedor
		else if (modo.equals("Editar")) {
			Fornecedor fornecedor = FornecedorDAO.encontrarFornecedor(codSelecionado);
			txtCod.setText(fornecedor.getID()+"");
			txtDataCadastro.setText(fornecedor.getDataCadastroString());
			txtNomeFantasia.setText(fornecedor.getNome());
			txtCnpj.setText(fornecedor.getCnpj());
			txtInscricaoEstadual.setText(fornecedor.getInscricaoEstadual());
			txtCnae.setText(fornecedor.getCnae());
			txtEndRua.setText(fornecedor.getEndereco().getRua());
			txtEndNum.setText(fornecedor.getEndereco().getNum()+"");
			txtEndCep.setText(fornecedor.getEndereco().getCep());
			comboBoxEndEstado.setSelectedItem(fornecedor.getEndereco().getEstado());
			txtEndBairro.setText(fornecedor.getEndereco().getBairro());
			txtEndCidade.setText(fornecedor.getEndereco().getCidade());
			txtTelefone.setText(fornecedor.getTelefone());
			txtEmail.setText(fornecedor.getEmail());
		}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxEndEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCnae;
    private javax.swing.JLabel lbCnpj;
    private javax.swing.JLabel lbCod;
    private javax.swing.JLabel lbDataCadastro;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbInscricaoEstadual;
    private javax.swing.JLabel lbNomeFantasia;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbRua;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JFormattedTextField txtCnae;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndBairro;
    private javax.swing.JFormattedTextField txtEndCep;
    private javax.swing.JTextField txtEndCidade;
    private javax.swing.JTextField txtEndNum;
    private javax.swing.JTextField txtEndRua;
    private javax.swing.JTextField txtInscricaoEstadual;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
