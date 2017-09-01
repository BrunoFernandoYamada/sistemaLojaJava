package view;

import util.CampoLimiter;
import dao.ClienteDAO;
import dao.ItemProdutoDAO;
import dao.MovimentoDAO;
import dao.ProdutoDAO;
import dao.TipoMovimentoDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;
import dominio.Cliente;
import dominio.ItemProduto;
import dominio.Movimento;
import dominio.Produto;
import dominio.TipoMovimento;
import dominio.Usuario;
import dominio.Venda;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.WindowEvent;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class TelaVendas extends javax.swing.JFrame {

    private static Usuario tipoUser;

    public TelaVendas(Usuario usuario) {
        initComponents();
        
        txtCodigoBarras.setDocument(new CampoLimiter(9));
        
        this.carregarTabela();

        tipoUser = usuario;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgForma = new javax.swing.ButtonGroup();
        bgPagar = new javax.swing.ButtonGroup();
        pnlCaixa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlItens = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        txtCodigoBarras = new javax.swing.JTextField();
        lblCodigoBarras = new javax.swing.JLabel();
        pnlPagamento = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        rbParcelado = new javax.swing.JRadioButton();
        cbParcelamento = new javax.swing.JComboBox<>();
        lblParcelamento = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rbDinheiro = new javax.swing.JRadioButton();
        rbCredito = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        rbAVista = new javax.swing.JRadioButton();
        rbCrediario = new javax.swing.JRadioButton();
        rbDebito = new javax.swing.JRadioButton();
        lblMostrar = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        chbEntrada = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        txtDesconto = new javax.swing.JTextField();
        lblPorcento = new javax.swing.JLabel();
        chkDesconto = new javax.swing.JCheckBox();
        btnVerificar = new javax.swing.JButton();
        lblMostrar1 = new javax.swing.JLabel();
        lblMostrar2 = new javax.swing.JLabel();
        pnlTotal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        lblItensComprados = new javax.swing.JLabel();
        lblPagamento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnlCaixa.setBackground(java.awt.Color.darkGray);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caixa");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout pnlCaixaLayout = new javax.swing.GroupLayout(pnlCaixa);
        pnlCaixa.setLayout(pnlCaixaLayout);
        pnlCaixaLayout.setHorizontalGroup(
                pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCaixaLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCaixaLayout.setVerticalGroup(
                pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCaixaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(pnlCaixaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlItens.setBackground(new java.awt.Color(255, 255, 255));
        pnlItens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo", "Produto", "Quantidade", "Valor unitário", "Valor total"
                }
        ));
        tabelaItens.setToolTipText("");
        tabelaItens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaItensKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        txtCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoBarrasKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoBarrasKeyReleased(evt);
            }
        });

        lblCodigoBarras.setText("Codigo de Barras");

        javax.swing.GroupLayout pnlItensLayout = new javax.swing.GroupLayout(pnlItens);
        pnlItens.setLayout(pnlItensLayout);
        pnlItensLayout.setHorizontalGroup(
                pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItensLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCodigoBarras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(6, 6, 6))
        );
        pnlItensLayout.setVerticalGroup(
                pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlItensLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRemover)
                                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodigoBarras))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPagamento.setBackground(new java.awt.Color(255, 255, 255));
        pnlPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bgPagar.add(rbParcelado);
        rbParcelado.setText("Parcelado");
        rbParcelado.setEnabled(false);
        rbParcelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParceladoActionPerformed(evt);
            }
        });

        cbParcelamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "10x", "11x", "12x"}));
        cbParcelamento.setEnabled(false);
        cbParcelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbParcelamentoActionPerformed(evt);
            }
        });

        lblParcelamento.setText("Parcelamento");

        bgForma.add(rbDinheiro);
        rbDinheiro.setSelected(true);
        rbDinheiro.setText("Dinheiro");
        rbDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDinheiroActionPerformed(evt);
            }
        });

        bgForma.add(rbCredito);
        rbCredito.setText("Cartão de crédito");
        rbCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCreditoActionPerformed(evt);
            }
        });

        bgPagar.add(rbAVista);
        rbAVista.setSelected(true);
        rbAVista.setText("Á vista");
        rbAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAVistaActionPerformed(evt);
            }
        });

        bgForma.add(rbCrediario);
        rbCrediario.setText("Crediário");
        rbCrediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCrediarioActionPerformed(evt);
            }
        });

        bgForma.add(rbDebito);
        rbDebito.setText("Cartão de débito");
        rbDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDebitoActionPerformed(evt);
            }
        });

        lblMostrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtEntrada.setEnabled(false);

        chbEntrada.setText("Entrada");
        chbEntrada.setEnabled(false);
        chbEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbEntradaActionPerformed(evt);
            }
        });

        txtDesconto.setEnabled(false);
        txtDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescontoKeyPressed(evt);
            }
        });

        lblPorcento.setText("%");

        chkDesconto.setText("Desconto");
        chkDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDescontoActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar");
        btnVerificar.setEnabled(false);
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        lblMostrar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        lblMostrar2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlPagamentoLayout = new javax.swing.GroupLayout(pnlPagamento);
        pnlPagamento.setLayout(pnlPagamentoLayout);
        pnlPagamentoLayout.setHorizontalGroup(
                pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1)
                .addComponent(jSeparator2)
                .addComponent(jSeparator3)
                .addComponent(jSeparator4)
                .addGroup(pnlPagamentoLayout.createSequentialGroup()
                        .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlPagamentoLayout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(rbAVista)
                                        .addGap(37, 37, 37)
                                        .addComponent(rbParcelado)
                                        .addGap(49, 49, 49)
                                        .addComponent(chbEntrada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlPagamentoLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(lblParcelamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnVerificar))
                                .addGroup(pnlPagamentoLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblMostrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblMostrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlPagamentoLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(chkDesconto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPorcento))
                                .addGroup(pnlPagamentoLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(rbDinheiro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbDebito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbCredito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbCrediario)))
                        .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlPagamentoLayout.setVerticalGroup(
                pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPagamentoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbDinheiro)
                                .addComponent(rbCrediario)
                                .addComponent(rbDebito)
                                .addComponent(rbCredito))
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbAVista)
                                .addComponent(rbParcelado)
                                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chbEntrada))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblParcelamento)
                                .addComponent(cbParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnVerificar))
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPorcento)
                                .addComponent(chkDesconto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMostrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMostrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
        );

        pnlTotal.setBackground(java.awt.Color.darkGray);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblResultado.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        lblResultado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
                pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTotalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar)
                        .addContainerGap())
        );
        pnlTotalLayout.setVerticalGroup(
                pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTotalLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(pnlTotalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnConfirmar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(lblResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblItensComprados.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblItensComprados.setText("Itens comprados");

        lblPagamento.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblPagamento.setText("Pagamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(lblItensComprados)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(lblPagamento)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnlPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblItensComprados)
                                .addComponent(lblPagamento))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnlItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calcularTotal() {

        Double total = 0.0;
        Integer linhas = tabelaItens.getRowCount();
        for (int i = 0; i < linhas; i++) {

            total += Double.parseDouble("" + tabelaItens.getValueAt(i, 4));

        }

        lblMostrar.setText(null);
        lblMostrar1.setText(null);
        lblMostrar2.setText(null);
        lblResultado.setText("" + total);

    }

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        ((DefaultTableModel) tabelaItens.getModel()).removeRow(tabelaItens.getSelectedRow());

        this.calcularTotal();

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtCodigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarrasKeyReleased

        if (evt.getKeyCode() == VK_ENTER) {

            chkDesconto.setSelected(false);
            txtDesconto.setEnabled(false);
            txtDesconto.setText(null);

            String codBarras = txtCodigoBarras.getText();

            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto resultado = produtoDAO.buscarBarras(codBarras);

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "código de barra não cadastrado");
            } else if (resultado.getQtdEstoque() == null) {
                JOptionPane.showMessageDialog(null, "Este produto está cadastrado, mas não há quantidade em estoque!");
            }else if (resultado.getQtdEstoque() <= 0){
                JOptionPane.showMessageDialog(null, "Este produto está cadastrado, mas não há quantidade em estoque!");
            } else {

                String[] dados = new String[5];
                dados[0] = resultado.getCodBarras();
                dados[1] = resultado.getNomeProduto();
                dados[2] = "" + 1;
                dados[3] = "" + resultado.getPreco();
                dados[4] = "" + resultado.getPreco();

                DefaultTableModel modelo = (DefaultTableModel) tabelaItens.getModel();
                modelo.addRow(dados);

                this.calcularTotal();
                txtCodigoBarras.setText(null);
            }
        }

    }//GEN-LAST:event_txtCodigoBarrasKeyReleased

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        if (tabelaItens.getRowCount() > 0) {
            String[] opcoes = {"Cancelar", "Sim"};
            Integer retorno = JOptionPane.showOptionDialog(null, "Deseja salvar esta venda?", "Venda", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
            if (retorno == 1) {

                boolean conCPF = true;
                Cliente cliente = new Cliente();
                cliente = null;

                while (conCPF) {

                    int result = JOptionPane.showConfirmDialog(null, "Venda com CPF ou CNPJ na nota?", "CPF/CNPJ", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        String cpf = JOptionPane.showInputDialog(null, "CPF/CNPJ");
                        ClienteDAO clienteDAO = new ClienteDAO();
                        cliente = clienteDAO.buscarCPF(cpf);

                        if (cliente == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado tente novamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente encontrado");
                            conCPF = false;
                        }
                    } else {
                        conCPF = false;
                    }
                }

                Venda venda = new Venda();
                VendaDAO vendaDAO = new VendaDAO();

                if (cliente != null) {
                    venda.setCodCliente(cliente);
                }
                

                venda.setCodUsuario(tipoUser);
                venda.setDataVenda(this.dataVenda());
                venda.setDesconto(this.desconto());
                venda.setEntrada(this.entrada());
                venda.setFormaPgt(this.forma());
                venda.setJuros(this.juros());
                venda.setParcelamento(this.parcelamento());
                venda.setQtdParcelas(this.qtdParcelas());
                venda.setValorParcela(this.valorParcela());
                venda.setValorParcelado(this.valorParcelado());
                venda.setValorTotal(this.valorTotal());

                vendaDAO.inserir(venda);
                System.out.println("venda salva");

                //Cria uma lista para serem adicionados os protuda da JTable vendas
                List<ItemProduto> listaDeProdutos = new ArrayList<ItemProduto>();

                for (int i = 0; i < tabelaItens.getRowCount(); i++) {

                    String codBarras = tabelaItens.getValueAt(i, 0).toString();
                    Produto produto = new Produto();
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produto = produtoDAO.buscarBarras(codBarras);

                    ItemProduto itemProduto = new ItemProduto();

                    itemProduto.setCodVenda(venda);
                    itemProduto.setCodProduto(produto);
                    itemProduto.setPrecoUnitario(Float.parseFloat(tabelaItens.getValueAt(i, 3).toString()));
                    itemProduto.setQuantidade(Integer.parseInt(tabelaItens.getValueAt(i, 2).toString()));

                    listaDeProdutos.add(itemProduto);

                }
                // adiciona os items ao banco de dados
                for (ItemProduto itemProd : listaDeProdutos) {
                    //novo for
                    ItemProdutoDAO itemProdutoDAO = new ItemProdutoDAO();
                    itemProdutoDAO.inserir(itemProd);
                    System.out.println("item salvo");

                    //subtrai no estoque(banco) o quantidade vendida
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    Produto prod = produtoDAO.buscar(itemProd.getCodProduto().getCodProduto());

                    prod.setQtdEstoque((prod.getQtdEstoque() - itemProd.getQuantidade()));
                    produtoDAO.editar(prod);
                    //Salva dados da movimentação tipo venda
                }

                TipoMovimentoDAO tipoMovimentoDAO = new TipoMovimentoDAO();
                TipoMovimento tipoMov = tipoMovimentoDAO.buscar(1);

                Movimento movimento = new Movimento();
                movimento.setDataExecucao(new Date());
                movimento.setTipoMovimento(tipoMov);
                movimento.setUsuario(tipoUser);

                MovimentoDAO movimentoDAO = new MovimentoDAO();
                movimentoDAO.inserir(movimento);

                
                lblResultado.setText(null);
                this.carregarTabela();
                

                JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Não é possivel efetuar "
                    + "\numa venda sem produtos");
        }
    }

    private void tabelaItensKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaItensKeyReleased

        if (evt.getKeyCode() == VK_ENTER) {

            chkDesconto.setSelected(false);
            txtDesconto.setEnabled(false);
            txtDesconto.setText(null);

            Integer quantidade = Integer.parseInt("" + tabelaItens.getValueAt(tabelaItens.getSelectedRow(), 2));
            Float preco = Float.parseFloat("" + tabelaItens.getValueAt(tabelaItens.getSelectedRow(), 3));
            Float total = preco * quantidade;

            tabelaItens.setValueAt(total, tabelaItens.getSelectedRow(), 4);
            this.calcularTotal();

        }

    }//GEN-LAST:event_tabelaItensKeyReleased

    private void txtCodigoBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarrasKeyPressed

    }//GEN-LAST:event_txtCodigoBarrasKeyPressed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed

        if (tabelaItens.getRowCount() != 0 && rbParcelado.isSelected()) {

            Double entrada;
            String valor;
            if (rbCrediario.isSelected()) {

                if (txtEntrada.getText().equals("") || txtEntrada.getText() == null) {

                    entrada = 0.0;
                    valor = "";

                } else {

                    entrada = Double.parseDouble(txtEntrada.getText());
                    valor = "Uma entrada de: " + entrada + " + ";

                }
                Double total = Double.parseDouble(lblResultado.getText());
                total -= entrada;
                Integer quantidade = Integer.parseInt("" + (cbParcelamento.getSelectedIndex() + 2));
                Double juros = total * 0.06;
                Double parcela = total / quantidade;
                parcela += juros;
                Double novoTotal = (parcela * quantidade) + entrada;

                lblMostrar.setText("Pagamento no crediário ");
                lblMostrar1.setText(valor + "" + quantidade + " x de " + parcela);
                lblMostrar2.setText("Total da compra no crediário: " + novoTotal);

            } else {

                if (txtEntrada.getText().equals("") || txtEntrada.getText() == null) {

                    entrada = 0.0;
                    valor = "";

                } else {

                    entrada = Double.parseDouble(txtEntrada.getText());
                    valor = "Uma entrada de: " + entrada + " + ";

                }

                Double total = Double.parseDouble(lblResultado.getText());
                total -= entrada;
                Integer quantidade = Integer.parseInt("" + (cbParcelamento.getSelectedIndex() + 2));
                Double parcela = total / quantidade;

                lblMostrar.setText("Pagamento no cartão de crédito ");
                lblMostrar1.setText(valor + "" + quantidade + " x de " + parcela);
                lblMostrar2.setText("Valor total da compra: " + (total + entrada));
            }

        }

    }//GEN-LAST:event_btnVerificarActionPerformed

    private void chkDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDescontoActionPerformed

        if (chkDesconto.isSelected()) {

            txtDesconto.setEnabled(true);

        } else {

            txtDesconto.setEnabled(false);
            txtDesconto.setText(null);
            this.calcularTotal();

        }

    }//GEN-LAST:event_chkDescontoActionPerformed

    private void txtDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontoKeyPressed

        if (evt.getKeyCode() == VK_ENTER) {

            this.calcularTotal();
            Double desc = Double.parseDouble(txtDesconto.getText());
            Double valor = Double.parseDouble(lblResultado.getText());

            desc = (desc / 100) * valor;
            valor = valor - desc;
            lblResultado.setText("" + valor);

        }
    }//GEN-LAST:event_txtDescontoKeyPressed

    private void chbEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbEntradaActionPerformed

        if (chbEntrada.isSelected()) {

            txtEntrada.setEnabled(true);

        } else {

            txtEntrada.setEnabled(false);
            txtEntrada.setText(null);
            lblMostrar.setText(null);
            lblMostrar1.setText(null);
            lblMostrar2.setText(null);

        }
    }//GEN-LAST:event_chbEntradaActionPerformed

    private void rbDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDebitoActionPerformed

        rbAVista.setEnabled(true);
        rbAVista.setSelected(true);

        rbParcelado.setEnabled(false);
        rbParcelado.setSelected(false);

        chbEntrada.setEnabled(false);
        chbEntrada.setSelected(false);

        txtEntrada.setEnabled(false);
        txtEntrada.setText(null);

        cbParcelamento.setEnabled(false);

        chkDesconto.setEnabled(true);
        chkDesconto.setSelected(false);
        txtDesconto.setEnabled(false);
        txtDesconto.setText(null);

        btnVerificar.setEnabled(false);
        this.calcularTotal();
    }//GEN-LAST:event_rbDebitoActionPerformed

    private void rbCrediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCrediarioActionPerformed

        rbAVista.setEnabled(false);
        rbAVista.setSelected(false);

        rbParcelado.setEnabled(true);
        rbParcelado.setSelected(true);

        chbEntrada.setEnabled(true);
        chbEntrada.setSelected(false);

        txtEntrada.setEnabled(false);
        txtEntrada.setText(null);

        cbParcelamento.setEnabled(true);

        chkDesconto.setEnabled(false);
        txtDesconto.setEnabled(false);
        txtDesconto.setText(null);

        btnVerificar.setEnabled(true);
        this.calcularTotal();

    }//GEN-LAST:event_rbCrediarioActionPerformed

    private void rbAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAVistaActionPerformed

        chbEntrada.setEnabled(false);
        chbEntrada.setSelected(false);

        txtEntrada.setEnabled(false);
        txtEntrada.setText(null);

        cbParcelamento.setEnabled(false);

        btnVerificar.setEnabled(false);
    }//GEN-LAST:event_rbAVistaActionPerformed

    private void rbCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCreditoActionPerformed

        rbAVista.setEnabled(true);
        rbAVista.setSelected(true);

        rbParcelado.setEnabled(true);

        chbEntrada.setEnabled(false);
        chbEntrada.setSelected(false);

        txtEntrada.setEnabled(false);
        txtEntrada.setText(null);

        cbParcelamento.setEnabled(false);

        chkDesconto.setEnabled(false);
        chkDesconto.setSelected(false);
        txtDesconto.setEnabled(false);
        txtDesconto.setText(null);

        btnVerificar.setEnabled(false);
        this.calcularTotal();
    }//GEN-LAST:event_rbCreditoActionPerformed

    private void rbDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDinheiroActionPerformed

        rbAVista.setEnabled(true);
        rbAVista.setSelected(true);

        rbParcelado.setEnabled(false);
        rbParcelado.setSelected(false);

        chbEntrada.setEnabled(false);
        chbEntrada.setSelected(false);

        txtEntrada.setEnabled(false);
        txtEntrada.setText(null);

        cbParcelamento.setEnabled(false);

        chkDesconto.setEnabled(true);
        chkDesconto.setSelected(false);
        txtDesconto.setEnabled(false);
        txtDesconto.setText(null);

        btnVerificar.setEnabled(false);
        this.calcularTotal();
    }//GEN-LAST:event_rbDinheiroActionPerformed

    private void cbParcelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbParcelamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbParcelamentoActionPerformed

    private void rbParceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParceladoActionPerformed

        chbEntrada.setEnabled(true);

        txtEntrada.setEnabled(false);
        txtEntrada.setText(null);

        cbParcelamento.setEnabled(true);

        btnVerificar.setEnabled(true);

    }//GEN-LAST:event_rbParceladoActionPerformed

    //valorParcelado
    public Float valorParcelado() {

        Double entrada = null;
        Double valorParcelado = null;

        if (rbParcelado.isSelected()) {

            if (rbCrediario.isSelected()) {

                if (txtEntrada.getText().equals("") || txtEntrada.getText() == null) {

                    entrada = 0.0;

                } else {

                    entrada = Double.parseDouble(txtEntrada.getText());

                }

                Double total = Double.parseDouble(lblResultado.getText());
                total -= entrada;
                Integer quantidade = Integer.parseInt("" + (cbParcelamento.getSelectedIndex() + 2));
                Double juros = total * 0.06;
                valorParcelado = total + (juros * quantidade);
                System.out.println("valor parcelado: " + valorParcelado);

            } else if (rbCredito.isSelected()) {

                if (txtEntrada.getText().equals("") || txtEntrada.getText() == null) {

                    entrada = 0.0;

                } else {

                    entrada = Double.parseDouble(txtEntrada.getText());
                }

                Double total = Double.parseDouble(lblResultado.getText());
                total -= entrada;

                valorParcelado = total;
                System.out.println("valor parcelado: " + valorParcelado);

            }

            return Float.parseFloat("" + valorParcelado);

        } else {

            return null;

        }

    }

    //Desconto
    public Float desconto() {

        Float desconto = null;

        if (txtDesconto.getText() == null || txtDesconto.getText().equals("")) {

            desconto = null;

        } else {

            desconto = Float.parseFloat("" + txtDesconto.getText());

        }

        return desconto;
    }

    //formaPgt
    public String forma() {

        String forma = null;

        if (rbDinheiro.isSelected()) {

            forma = "Dinheiro";

        } else if (rbDebito.isSelected()) {

            forma = "Débito";

        } else if (rbCredito.isSelected()) {

            forma = "Crédito";

        } else if (rbCrediario.isSelected()) {

            forma = "Crediário";

        }

        return forma;
    }

    //Entrada
    public Float entrada() {

        Float entrada = null;

        if (txtEntrada.getText() == null || txtEntrada.getText().equals("")) {

            entrada = null;

        } else {

            entrada = Float.parseFloat("" + txtEntrada.getText());

        }

        return entrada;
    }

    //valorParcela
    public Float valorParcela() {

        if (rbParcelado.isSelected()) {

            Double valor = null;
            Double entrada = 0.0;
            if (txtEntrada.getText().equals("") || txtEntrada.getText() == null) {

                entrada = 0.0;

            } else {

                entrada = Double.parseDouble(txtEntrada.getText());

            }

            if (rbParcelado.isSelected() && rbCredito.isSelected()) {

                Double total = Double.parseDouble("" + lblResultado.getText());
                total -= entrada;
                Integer quantidade = Integer.parseInt("" + cbParcelamento.getSelectedIndex() + 2);

                valor = total / quantidade;

            } else if (rbParcelado.isSelected() && rbCrediario.isSelected()) {

                Double total = Double.parseDouble("" + lblResultado.getText());
                total -= entrada;
                Double juros = total * 0.06;
                Integer quantidade = Integer.parseInt("" + cbParcelamento.getSelectedIndex() + 2);

                valor = (total / quantidade) + juros;

            }
            return Float.parseFloat("" + valor);
        } else {

            return null;
        }

    }

    //qtdParcelas
    public Integer qtdParcelas() {

        Integer quantidade = null;
        if (rbParcelado.isSelected()) {

            quantidade = Integer.parseInt("" + cbParcelamento.getSelectedIndex() + 2);

        } else {

            quantidade = null;

        }
        return quantidade;
    }

    //juros
    public String juros() {

        String juros = null;

        if (rbCrediario.isSelected()) {

            juros = "6% a.m.";

        } else {

            juros = null;

        }

        return juros;
    }

    //parcelamento
    public Boolean parcelamento() {

        Boolean parcelamento = null;

        if (rbParcelado.isSelected()) {

            parcelamento = true;

        } else {

            parcelamento = false;

        }

        return parcelamento;
    }

    //valorTotal
    public Float valorTotal() {

        Float valor = Float.parseFloat("" + lblResultado.getText());

        return valor;
    }

    //dataVenda
    public Date dataVenda() {

        Date data = new Date();

        return data;
    }

    public void carregarTabela() {

        String[] colunas = new String[]{"Codigo", "Produto", "Quantidade", "Valor unitário", "Valor total"};

        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int rol, int col) {

                if (col == 0 || col == 1 || col == 3 || col == 4) {

                    return false;

                } else {

                    return true;
                }

            }
        };

        tabelaItens.setModel(modeloTabela);

    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendas(tipoUser).setVisible(true);
            }
        });
    }

    public void windowClosing(WindowEvent e) {

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgForma;
    private javax.swing.ButtonGroup bgPagar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox<String> cbParcelamento;
    private javax.swing.JCheckBox chbEntrada;
    private javax.swing.JCheckBox chkDesconto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCodigoBarras;
    private javax.swing.JLabel lblItensComprados;
    private javax.swing.JLabel lblMostrar;
    private javax.swing.JLabel lblMostrar1;
    private javax.swing.JLabel lblMostrar2;
    private javax.swing.JLabel lblPagamento;
    private javax.swing.JLabel lblParcelamento;
    private javax.swing.JLabel lblPorcento;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JPanel pnlCaixa;
    private javax.swing.JPanel pnlItens;
    private javax.swing.JPanel pnlPagamento;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JRadioButton rbAVista;
    private javax.swing.JRadioButton rbCrediario;
    private javax.swing.JRadioButton rbCredito;
    private javax.swing.JRadioButton rbDebito;
    private javax.swing.JRadioButton rbDinheiro;
    private javax.swing.JRadioButton rbParcelado;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtEntrada;
    // End of variables declaration//GEN-END:variables
}
