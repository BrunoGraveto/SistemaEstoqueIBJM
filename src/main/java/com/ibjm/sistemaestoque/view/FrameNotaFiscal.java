/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ibjm.sistemaestoque.view;

import com.ibjm.sistemaestoque.controller.NotaFiscalController;
import com.ibjm.sistemaestoque.model.dao.ClienteDAO;
import com.ibjm.sistemaestoque.model.dao.NotaFiscalDAO;
import com.ibjm.sistemaestoque.model.dao.ProdutoDAO;
import com.ibjm.sistemaestoque.model.vo.Cliente;
import com.ibjm.sistemaestoque.model.vo.NotaFiscal;
import com.ibjm.sistemaestoque.model.vo.Produto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alcan
 */
public class FrameNotaFiscal extends javax.swing.JFrame {
	
	// Frame
	FramePrincipal fp;
	String modo;
	int codSelecionado;
	NotaFiscal notaFiscal;
	Cliente cliente;
	ArrayList<Integer> arrayQtdProdutos;
	ArrayList<Produto> arrayProdutos;
	double valorTotal;
	
	/**
	 * Creates new form FrameNotaFiscal
	 * @param fp
	 * @param modo
	 * @param codSelecionado
	 */
	public FrameNotaFiscal(FramePrincipal fp, String modo, int codSelecionado) {
		this.fp = fp;
		this.modo = modo;
		this.codSelecionado = codSelecionado;
		arrayQtdProdutos = new ArrayList<>();
		arrayProdutos = new ArrayList<>();
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

        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        lbDataCadastro = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        lbObservacao = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        lbNum = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter maskData = null;
        try {
            maskData = new javax.swing.text.MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtDataCadastro = new javax.swing.JFormattedTextField(maskData);
        txtCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        panelProdutos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        panelPagamento = new javax.swing.JPanel();
        lbValorTotal = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        lbFormaPagamento = new javax.swing.JLabel();
        comboBoxFormaPagamento = new javax.swing.JComboBox<>();
        try {
            maskData = new javax.swing.text.MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtDataSaida = new javax.swing.JFormattedTextField(maskData);
        lbDataCadastro1 = new javax.swing.JLabel();
        btnFecharNotaFiscal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nota Fiscal");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        lbDataCadastro.setText("Data Cadastro");

        lbCliente.setText("Cliente");

        lbObservacao.setText("Observação");

        txtNum.setEditable(false);
        txtNum.setFocusable(false);

        lbNum.setText("Num.");

        txtDataCadastro.setEditable(false);
        txtDataCadastro.setFocusable(false);

        txtCliente.setEditable(false);
        txtCliente.setFocusable(false);

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNum)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDataCadastro)
                    .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCliente)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lbObservacao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtObservacao, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataCadastro)
                    .addComponent(lbCliente)
                    .addComponent(lbNum)
                    .addComponent(lbObservacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableProdutos.setCellSelectionEnabled(true);
        tableProdutos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableProdutosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableProdutosFocusLost(evt);
            }
        });
        tableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableProdutosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableProdutos);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setVisible(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProdutosLayout = new javax.swing.GroupLayout(panelProdutos);
        panelProdutos.setLayout(panelProdutosLayout);
        panelProdutosLayout.setHorizontalGroup(
            panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelProdutosLayout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProdutosLayout.setVerticalGroup(
            panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdutosLayout.createSequentialGroup()
                .addGroup(panelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        lbValorTotal.setText("Valor Total Produtos");

        txtValorTotal.setEditable(false);
        txtValorTotal.setText("R$ 0.0");

        lbFormaPagamento.setText("Forma Pagamento");

        comboBoxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "PIX", "Boleto", "Débito", "Crédito" }));

        txtDataSaida.setEditable(false);
        txtDataSaida.setFocusable(false);

        lbDataCadastro1.setText("Data Saída");

        javax.swing.GroupLayout panelPagamentoLayout = new javax.swing.GroupLayout(panelPagamento);
        panelPagamento.setLayout(panelPagamentoLayout);
        panelPagamentoLayout.setHorizontalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbValorTotal)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFormaPagamento)
                    .addComponent(comboBoxFormaPagamento, 0, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataCadastro1))
                .addGap(175, 175, 175))
        );
        panelPagamentoLayout.setVerticalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addComponent(lbDataCadastro1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPagamentoLayout.createSequentialGroup()
                            .addComponent(lbValorTotal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagamentoLayout.createSequentialGroup()
                            .addComponent(lbFormaPagamento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        btnFecharNotaFiscal.setText("Fechar Nota Fiscal");
        btnFecharNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharNotaFiscalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnFecharNotaFiscal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(panelInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnFecharNotaFiscal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        try {
			int codClienteSelecionado = DialogProcurar.getIDSelecionado(this, "Clientes");
			cliente = ClienteDAO.encontrarCliente(codClienteSelecionado);
			txtCliente.setText(cliente.getNome());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Problema ao selcionar Cliente: " + e);
		}
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
			int idProdutoSelecionado = DialogProcurar.getIDSelecionado(fp, "Produtos");
			// Verifica o estoque do produto e se ja foi adicionado
			boolean encontrado = false;
			boolean semEstoque = false;
			for (Produto produto : arrayProdutos) {
				if (produto.getID() == idProdutoSelecionado) {
					encontrado = true;
				}
			}
			if (ProdutoDAO.encontrarProduto(idProdutoSelecionado).getQtdAtual() <= 0 && idProdutoSelecionado != -1) {
				semEstoque = true;
			}
			if (!encontrado && !semEstoque) {
				// Atualiza o estoque do produto
				arrayProdutos.add(ProdutoDAO.encontrarProduto(idProdutoSelecionado));
				arrayQtdProdutos.add(1);
				updateTableProdutos();
			} else if (encontrado) {
				JOptionPane.showMessageDialog(this, "Esse produto já foi adicionado!");
			} else if (semEstoque) {
				JOptionPane.showMessageDialog(this, "Não há itens suficiente em estoque para isso!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Problema ao adicionar Produto a Nota Fiscal: " + e);
		}
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tableProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosMousePressed
        btnRemover.setVisible(true);
    }//GEN-LAST:event_tableProdutosMousePressed

    private void tableProdutosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableProdutosFocusLost
        updateQtds();
    }//GEN-LAST:event_tableProdutosFocusLost

    private void tableProdutosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableProdutosFocusGained
        updateQtds();
		updateTableProdutos();
    }//GEN-LAST:event_tableProdutosFocusGained

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        btnRemover.setVisible(false);
    }//GEN-LAST:event_formMousePressed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (DialogConfirmar.confirmar(this, "Tem certeza que deseja remover esse item?")) {
			arrayProdutos.remove(tableProdutos.getSelectedRow());
			arrayQtdProdutos.remove(tableProdutos.getSelectedRow());
			updateTableProdutos();
		}
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
		try {
			loadNotaFiscal();
			// Ação
			if (modo.equals("Adicionar")) {
				NotaFiscalController.addNotaFiscal(notaFiscal, arrayQtdProdutos);
				JOptionPane.showMessageDialog(this, "Nota Fiscal Adicionada com sucesso!");
			} else if (modo.equals("Editar")) {
				NotaFiscalController.editarNotaFiscal(notaFiscal, arrayQtdProdutos);
				JOptionPane.showMessageDialog(this, "Nota Fiscal alterada com sucesso!");
			}
			// Fecha e atualiza
			dispose();
			fp.selecionar("NotasFiscais");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Problema ao gerenciar Nota Fiscal: " + e.getMessage());
		}
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharNotaFiscalActionPerformed
        // Atualiza o estoque
		loadNotaFiscal();
		try {
			NotaFiscalController.setStatusNotaFiscal(notaFiscal, false);
			JOptionPane.showMessageDialog(this, "Nota Fiscal finalizada com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Problema ao fechar Nota Fiscal: " + e);
		}
		dispose();
		fp.selecionar("NotasFiscais");
    }//GEN-LAST:event_btnFecharNotaFiscalActionPerformed

	private void preencher() {
		try {
			// Caso esteja adicionando um NotaFiscal
			if (modo.equals("Adicionar")) {
				txtNum.setText(String.format("%04d", NotaFiscalDAO.getCountNotasFiscais()+1)+"");
				txtDataCadastro.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				txtDataSaida.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			} 
			// Caso esteja editando um NotaFiscal
			else if (modo.equals("Editar")) {
				notaFiscal = NotaFiscalDAO.encontrarNotaFiscal(codSelecionado);
				txtNum.setText(notaFiscal.getID()+"");
				txtDataCadastro.setText(notaFiscal.getDataCadastroString());
				txtCliente.setText(notaFiscal.getCliente().getNome());
				txtObservacao.setText(notaFiscal.getObservacao());
				txtValorTotal.setText(notaFiscal.getValorTotalString());
				arrayProdutos = NotaFiscalDAO.getProdutosNotaFiscal(notaFiscal.getID());
				for (Produto produto : arrayProdutos) {
					arrayQtdProdutos.add(NotaFiscalDAO.getQtdProdutosNotaFiscal(notaFiscal.getID(), produto.getID()));
				}
				updateTableProdutos();
				comboBoxFormaPagamento.setSelectedItem(notaFiscal.getFormaPagamento());
				txtDataCadastro.setText(notaFiscal.getDataCadastroString());
				txtDataSaida.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				cliente = notaFiscal.getCliente();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	private void updateTableProdutos() {
		// Altera a tabela e não deixa editar
		Object[][] arrayDados = NotaFiscalController.obterDadosProdutoNotaFiscal(arrayProdutos, arrayQtdProdutos);
		tableProdutos.setModel(new DefaultTableModel(arrayDados, new String[] {"Cod.", "Qtd.",  "Uni. Medida", "Descrição", "Marca", "Val. Uni.", "Val. Total"}) {
			@Override
			public boolean isCellEditable(int row, int col) {
				return col == 1;
			}
		});
		updateValores();
	}
	
	/*
		Atualiza as quantidades dos Produtos da Nota Fiscal
	*/
	private void updateQtds() {
		try {
			// Verifica se a quantidade inserida não é superior ao que há em estoque
			int linhaSelecionada = tableProdutos.getSelectedRow();
			int qtd = Integer.parseInt(tableProdutos.getValueAt(linhaSelecionada, 1).toString());
			int idProduto = Integer.parseInt(tableProdutos.getValueAt(linhaSelecionada, 0).toString());
			if (qtd > ProdutoDAO.encontrarProduto(idProduto).getQtdAtual()) {
				JOptionPane.showMessageDialog(null, "Não há itens suficiente em estoque para isso!");
			} else {
				arrayQtdProdutos.set(linhaSelecionada, qtd);
			}
		} catch (Exception e) {
		}
	}
	
	/*
		Atualiza os valores da Nota Fiscal
	*/
	private void updateValores() {
		valorTotal = 0.0;
		for (int i = 0; i < arrayProdutos.size(); i++) {
			valorTotal += arrayQtdProdutos.get(i) * arrayProdutos.get(i).getValorVenda();
		}
		txtValorTotal.setText("R$ " + valorTotal);
	}
	
	/*
		Carrega a Nota Fiscal
	*/
	public void loadNotaFiscal() {
		int num = Integer.parseInt(txtNum.getText());
		boolean status = true;
		String observacao = txtObservacao.getText();
		String formaPagamento = comboBoxFormaPagamento.getSelectedItem().toString();
		LocalDate dataCadastro = LocalDate.parse(txtDataCadastro.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dataSaida = LocalDate.parse(txtDataSaida.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		notaFiscal = new NotaFiscal(num, status, observacao, cliente, arrayProdutos, valorTotal, formaPagamento, dataCadastro, dataSaida);
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFecharNotaFiscal;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxFormaPagamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbDataCadastro;
    private javax.swing.JLabel lbDataCadastro1;
    private javax.swing.JLabel lbFormaPagamento;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbObservacao;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelPagamento;
    private javax.swing.JPanel panelProdutos;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
