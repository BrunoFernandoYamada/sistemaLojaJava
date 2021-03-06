package view;

import util.JNumberFormatField;
import util.CampoLimiter;
import util.JtextFieldNumbers;
import dao.EntradaDAO;
import dao.GeneroDAO;
import dao.ProdutoDAO;
import dominio.Genero;
import dominio.Produto;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCadProduto extends javax.swing.JPanel {

    /**
     * Creates new form TelaCadProduto
     */
    public TelaCadProduto() {
        initComponents();

        this.atualizarCB();

        //Limitando tamanho dos campos
        txtDescricao.setDocument(new CampoLimiter(45));
        txtMarca.setDocument(new CampoLimiter(45));
        txtModelo.setDocument(new CampoLimiter((45)));
        txtCodigodeBarras.setDocument(new CampoLimiter(10));
        txtNome.setDocument(new CampoLimiter(45));

        txtCodigodeBarras.setDocument(new CampoLimiter(9));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbProdutos = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnConcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnCadastrarGenero = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAtualizarCB = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigodeBarras = new javax.swing.JFormattedTextField();
        txtValorVenda = new JNumberFormatField(new DecimalFormat("R$ 0.00"));
        txtImpostos = (new JNumberFormatField(){
            {
                setLimit(9);
            }
        });
        txtConsulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(true);
        setPreferredSize(new java.awt.Dimension(1190, 630));

        lbProdutos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbProdutos.setText("Produtos");

        btnConsultar.setBackground(java.awt.Color.darkGray);
        btnConsultar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.setFocusable(false);
        btnConsultar.setNextFocusableComponent(btnSalvar);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(java.awt.Color.darkGray);
        btnSalvar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setFocusable(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(java.awt.Color.darkGray);
        btnAlterar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.setFocusable(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(java.awt.Color.darkGray);
        btnRemover.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 255, 255));
        btnRemover.setText("Remover");
        btnRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemover.setFocusable(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnConcluir.setBackground(java.awt.Color.darkGray);
        btnConcluir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnConcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnConcluir.setText("Concluir");

        btnLimpar.setBackground(java.awt.Color.darkGray);
        btnLimpar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.setFocusable(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nome*");

        txtMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtModelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Modelo*");

        txtNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Gênero*");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Marca*");

        cbGenero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um gênero" }));
        cbGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbGenero.setFocusable(false);
        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Valor de venda*");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Impostos*");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Descrição");

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        btnCadastrarGenero.setBackground(java.awt.Color.darkGray);
        btnCadastrarGenero.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCadastrarGenero.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarGenero.setText("Cadastrar Gênero");
        btnCadastrarGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrarGenero.setFocusable(false);
        btnCadastrarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarGeneroActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Código de Barras*");

        btnAtualizarCB.setBackground(new java.awt.Color(255, 255, 255));
        btnAtualizarCB.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizarCB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imagem_refresh-81af31e9952439f554065f03d6febaf7.png"))); // NOI18N
        btnAtualizarCB.setBorder(null);
        btnAtualizarCB.setBorderPainted(false);
        btnAtualizarCB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizarCB.setFocusable(false);
        btnAtualizarCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCBActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Código do Produto");

        lblCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            txtCodigodeBarras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCodigodeBarras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCodigodeBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigodeBarrasActionPerformed(evt);
            }
        });

        txtValorVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtImpostos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtImpostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpostosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtImpostos))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodigodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGenero, 0, 159, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAtualizarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnCadastrarGenero))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(btnCadastrarGenero)
                        .addComponent(jLabel7)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigodeBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAtualizarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImpostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        txtConsulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tbProdutos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código de Barras", "Nome produto", "Marca", "Modelo", "Gênero", "Descrição", "Imposto", "Valor venda", "Qtd estoque"
            }
        ));
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbProdutosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGap(529, 529, 529)
                .addComponent(lbProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnConcluir)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnRemover))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        ProdutoDAO produtoDAO1 = new ProdutoDAO();
        Produto produto1 = produtoDAO1.buscarPorNome(txtNome.getText());

        if (produto1.getCodProduto().equals(Integer.parseInt(tbProdutos.getModel().getValueAt(tbProdutos.getSelectedRow(), 0).toString()))) {

            int linha = tbProdutos.getSelectedRow();
            if (linha == -1) {

                JOptionPane.showMessageDialog(null, "Selecione um fornecedor na tabela pra excluir");
            } else if (verificarCampos()) {
                int cod = Integer.parseInt(tbProdutos.getModel().getValueAt(tbProdutos.getSelectedRow(), 0).toString());

                //busca do genero no banco por meio do tipo escolhido no comboBox 
                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.buscar(cbGenero.getSelectedItem().toString());

                String preco = txtValorVenda.getText();
                preco = preco.replace("R$", "");
                preco = preco.replace(",", ".");

                String imposto = txtImpostos.getText();
                imposto = imposto.replace("R$", "");
                imposto = imposto.replace(",", ".");

                //Adicionando valore no objeto para alteração
                Produto produto = new Produto();
                produto.setCodProduto(cod);
                produto.setDescricao(txtDescricao.getText());
                produto.setGenero(genero);
                produto.setImposto(Float.parseFloat(imposto));
                produto.setMarca(txtMarca.getText());
                produto.setModelo(txtModelo.getText());
                produto.setNomeProduto(txtNome.getText());
                produto.setPreco(Float.parseFloat(preco));
                produto.setCodBarras(txtCodigodeBarras.getText());

                new ProdutoDAO().editar(produto);

                JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso com sucesso!");
                this.limparCampos();
            }
            this.atualizarTB();
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível altera o produto para este nome, pois já é existente");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGeneroActionPerformed

    private void btnCadastrarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarGeneroActionPerformed

        JFrame tela = new JFrame();

        tela.setSize(804, 461);
        TelaCadGenero telaCadGenero = new TelaCadGenero();
        tela.add(telaCadGenero);

        JDialog dia = new JDialog();
        dia.setModal(true);
        dia.setSize(804, 461);
        dia.setContentPane(tela.getContentPane());
        dia.setLocationRelativeTo(null);
        dia.setVisible(true);

    }//GEN-LAST:event_btnCadastrarGeneroActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        ProdutoDAO produtoDAO1 = new ProdutoDAO();
        Produto produto1 = produtoDAO1.buscarPorNome(txtNome.getText());
        if (produto1 == null) {

            if (verificarCampos()) {

                GeneroDAO generoDAO = new GeneroDAO();
                Genero genero = generoDAO.buscar(cbGenero.getSelectedItem().toString());
                System.out.println(cbGenero.getSelectedItem().toString());

                String preco = txtValorVenda.getText();
                preco = preco.replace("R$", "");
                preco = preco.replace(",", ".");

                String imposto = txtImpostos.getText();
                imposto = imposto.replace("R$", "");
                imposto = imposto.replace(",", ".");
                Produto produto = new Produto();
                produto.setGenero(genero);

                produto.setNomeProduto(txtNome.getText());
                produto.setMarca(txtMarca.getText());
                produto.setModelo(txtModelo.getText());
                produto.setImposto(Float.parseFloat(imposto));
                produto.setDescricao(txtDescricao.getText());
                produto.setCodBarras(txtCodigodeBarras.getText());
                produto.setQtdEstoque(0);
                produto.setPreco(Float.parseFloat(preco));

                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.inserir(produto);

                JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");
                this.atualizarTB();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nome duplicado, já existe um produto com este nome!");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        String palavra = txtConsulta.getText();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtoLista = produtoDAO.buscar(palavra);

        carregarTabela(produtoLista);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tbProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMousePressed

        int linha = tbProdutos.getSelectedRow();

        lblCodigo.setText(tbProdutos.getModel().getValueAt(linha, 0).toString());
        txtCodigodeBarras.setText(tbProdutos.getModel().getValueAt(linha, 1).toString());
        txtNome.setText(tbProdutos.getModel().getValueAt(linha, 2).toString());
        txtMarca.setText(tbProdutos.getModel().getValueAt(linha, 3).toString());
        txtModelo.setText(tbProdutos.getModel().getValueAt(linha, 4).toString());
        cbGenero.setSelectedItem(tbProdutos.getModel().getValueAt(linha, 5).toString());
        txtDescricao.setText(tbProdutos.getModel().getValueAt(linha, 6).toString());
        txtImpostos.setText(tbProdutos.getModel().getValueAt(linha, 7).toString());
        txtValorVenda.setText(tbProdutos.getModel().getValueAt(linha, 8).toString());

    }//GEN-LAST:event_tbProdutosMousePressed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed

        int linha = tbProdutos.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um Produto na tabela pra excluir");
        } else {

            int opc = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cadastro?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {

                Integer cod = Integer.parseInt(tbProdutos.getModel().getValueAt(linha, 0).toString());
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto;
                produto = produtoDAO.buscar(cod);
                produtoDAO.excluir(produto);

                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
            }
        }
        this.atualizarTB();

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAtualizarCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCBActionPerformed
        cbGenero.removeAllItems();
        cbGenero.addItem("Selecione");
        this.atualizarCB();
    }//GEN-LAST:event_btnAtualizarCBActionPerformed

    private void txtCodigodeBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigodeBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigodeBarrasActionPerformed

    private void txtImpostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImpostosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarCB;
    private javax.swing.JButton btnCadastrarGenero;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbProdutos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JFormattedTextField txtCodigodeBarras;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtImpostos;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        lblCodigo.setText(null);
        txtDescricao.setText(null);
        txtImpostos.setText(null);
        txtMarca.setText(null);
        txtModelo.setText(null);
        txtNome.setText(null);
        txtCodigodeBarras.setText(null);
        txtValorVenda.setText(null);
        cbGenero.setSelectedIndex(0);
    }

    private void carregarTabela(List<Produto> produtoLista) {

        String[] colunaTabela = new String[]{"Código", "Código de Barras", "Nome produto", "Marca", "Modelo", "Gênero", "Descrição", "Imposto", "Valor Venda"};

        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunaTabela) {

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        DecimalFormat formater = new DecimalFormat("0.00");

        tbProdutos.setModel(modeloTabela);

        for (Produto produto : produtoLista) {
            modeloTabela.addRow(new String[]{produto.getCodProduto().toString(), produto.getCodBarras(), produto.getNomeProduto(), produto.getMarca(),
                produto.getModelo(), produto.getGenero().getNome(), produto.getDescricao(), formater.format(produto.getImposto()),
                formater.format(produto.getPreco())});
        }

    }

    private boolean verificarCampos() {

        if (cbGenero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Genero para o Produto");
            return false;
        }
        if ((txtNome.getText().isEmpty()) || (txtModelo.getText().isEmpty()) || (txtImpostos.getText().isEmpty())
                || (txtMarca.getText().isEmpty()) || (txtValorVenda.getText().isEmpty()) || (txtCodigodeBarras.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos Obrigatórios!");
            return false;
        } else {
            return true;
        }

    }

    public void atualizarCB() {

        // carregar o JComboBox 
        GeneroDAO generoDAO = new GeneroDAO();
        List<Genero> generoList = generoDAO.listar();
        for (Genero genero : generoList) {
            cbGenero.addItem(genero.getNome());
        }
    }

    public void atualizarTB() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtoLista = produtoDAO.listar();
        carregarTabela(produtoLista);
    }
}
