/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.view;

import br.com.senactech.MCadastroPessoa.model.Carro;
import br.com.senactech.MCadastroPessoa.services.CarroServicos;
import br.com.senactech.MCadastroPessoa.services.PessoaServicos;
import br.com.senactech.MCadastroPessoa.services.ServicosFactory;
import br.com.senactech.MCadastroPessoa.util.ValidaCPF;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static mcadastropessoaJF.MCadastroPessoaJF.cadCarros;
import static mcadastropessoaJF.MCadastroPessoaJF.cadPessoas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairb
 */
public class carroCadastro extends javax.swing.JFrame {

    /**
     * Creates new form carroCadastro
     */
    public carroCadastro() throws SQLException {
        initComponents();
//        cadPessoas.mokPessoas();
//        cadCarros.mokCarro();
        //addRowToTable();
        addRowToTableBD();
    }

    public void addRowToTable() {
        //Cria obj model e recebe a modelagem da tabela JtPessoa do JFrame
        DefaultTableModel model = (DefaultTableModel) jtCarros.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[4]; //cria vetor para as colunas da tabela
        for (Carro c : cadCarros.getAll()) {
            rowData[0] = c.getPlaca();
            rowData[1] = c.getMarca();
            rowData[2] = c.getModelo();
            rowData[3] = cadPessoas.getNomePes(c.getIdPessoa());

            model.addRow(rowData);
        }
    }

    public void addRowToTableBD() throws SQLException {
        //Cria obj model e recebe a modelagem da tabela JtPessoa do JFrame
        DefaultTableModel model = (DefaultTableModel) jtCarros.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[4]; //cria vetor para as colunas da tabela
        CarroServicos carroS = ServicosFactory.getCarroServicos();
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        for (Carro c : carroS.getCarros()) {
            rowData[0] = c.getPlaca();
            rowData[1] = c.getMarca();
            rowData[2] = c.getModelo();
            rowData[3] = pessoaS.getNomePessoa(c.getIdPessoa());

            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCarros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfAnoF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfAnoM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfModelo = new javax.swing.JTextField();
        jtfCor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfPortas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jbLimpar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jbDeletar = new javax.swing.JButton();
        jbConfirmar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbPesq = new javax.swing.JButton();
        jcbMarca = new javax.swing.JComboBox<>();
        jtfCPFProp = new javax.swing.JTextField();
        jlNomeProp = new javax.swing.JLabel();
        jtfPlaca = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro Carro");

        jSeparator1.setForeground(new java.awt.Color(255, 204, 51));

        jSeparator2.setForeground(new java.awt.Color(255, 204, 51));

        jtCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Modelo", "Proprietário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCarros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCarrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCarros);

        jLabel1.setText("Placa:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Modelo:");

        jLabel5.setText("Ano F.:");

        jtfAnoF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnoFKeyTyped(evt);
            }
        });

        jLabel6.setText("Ano M.:");

        jtfAnoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnoMKeyTyped(evt);
            }
        });

        jLabel7.setText("Cor:");

        jtfModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfModeloFocusLost(evt);
            }
        });

        jtfCor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCorFocusLost(evt);
            }
        });

        jLabel8.setText("Portas:");

        jtfPortas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPortasKeyTyped(evt);
            }
        });

        jLabel9.setText("CPF:");

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jbDeletar.setText("Deletar");
        jbDeletar.setEnabled(false);
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jbConfirmar.setText("Confirmar");
        jbConfirmar.setEnabled(false);
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbPesq.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbPesq.setForeground(new java.awt.Color(0, 0, 255));
        jbPesq.setText("Pesquisar Placa");
        jbPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesqActionPerformed(evt);
            }
        });

        jcbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Mercedes", "GM", "Peugeot", "Jeep", "Fiat", "Mitsubishi", "Lincoln", "Land Rover", "Jaguard" }));

        jtfCPFProp.setToolTipText("Informe o CPF");
        jtfCPFProp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfCPFPropFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCPFPropFocusLost(evt);
            }
        });

        jlNomeProp.setText("Proprietário...");
        jlNomeProp.setToolTipText("");

        try {
            jtfPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAnoF)
                                    .addComponent(jtfCor)
                                    .addComponent(jtfCPFProp)
                                    .addComponent(jtfPlaca))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfModelo)
                                    .addComponent(jtfAnoM)
                                    .addComponent(jtfPortas)
                                    .addComponent(jbPesq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jlNomeProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbEditar)
                                .addGap(18, 18, 18)
                                .addComponent(jbConfirmar)
                                .addGap(18, 18, 18)
                                .addComponent(jbDeletar)
                                .addGap(18, 18, 18)
                                .addComponent(jbSair)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbPesq)
                    .addComponent(jtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAnoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jtfAnoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jtfPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfCPFProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNomeProp))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpar)
                    .addComponent(jbSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSair)
                    .addComponent(jbDeletar)
                    .addComponent(jbConfirmar)
                    .addComponent(jbEditar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAnoFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnoFKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAnoFKeyTyped

    private void jtfAnoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnoMKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAnoMKeyTyped

    private void jtfPortasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPortasKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPortasKeyTyped

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        jtfPlaca.setText("");
        jtfModelo.setText("");
        jtfAnoF.setText("");
        jtfAnoM.setText("");
        jtfCor.setText("");
        jtfPortas.setText("");
        jtfCPFProp.setText("");
        jcbMarca.setSelectedIndex(0);
        jlNomeProp.setText("Proprietário...");

        jbSalvar.setEnabled(true);
        jbPesq.setEnabled(true);
        jbEditar.setEnabled(false);
        jbConfirmar.setEnabled(false);
        jbDeletar.setEnabled(false);

        jtfPlaca.requestFocus();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jtfCPFPropFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCPFPropFocusLost
        try {
            // TODO add your handling code here:
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            if (!ValidaCPF.isCPF(jtfCPFProp.getText())) {
                JOptionPane.showMessageDialog(this,
                        "CPF informado esta incorreto!!!",
                        ".: Erro :.", JOptionPane.ERROR_MESSAGE);
                jtfCPFProp.requestFocus();
            } else if (!pessoaS.verCPF(jtfCPFProp.getText())) {
                int id = pessoaS.buscarPessoaBD(jtfCPFProp.getText()).getIdPessoa();
                jlNomeProp.setText(pessoaS.getNomePessoa(id));
            } else {
                jlNomeProp.setText("Pessoa não cadastrada!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(carroCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtfCPFPropFocusLost

    private Boolean validaInputs() {
        CarroServicos carroS = ServicosFactory.getCarroServicos();
        PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
        try {
            Boolean verPlaca;
            String placa = jtfPlaca.getText().toUpperCase();
            verPlaca = (placa.length() == 8 && !carroS.verPlaca(placa));
            if (!verPlaca) {
                String msg = "Placa já cadastrada ou incorreta!";
                JOptionPane.showMessageDialog(this, msg, ".: Erro :.",
                        JOptionPane.ERROR_MESSAGE);
                jtfPlaca.requestFocus();
                return false;
            }
            Calendar cal = GregorianCalendar.getInstance();
            int anoAtual = cal.get(Calendar.YEAR);
            int anoF = Integer.parseInt(jtfAnoF.getText());
            if (anoF > anoAtual) {
                String msg = "Ano fabricação inválido!";
                JOptionPane.showMessageDialog(this, msg, ".: Erro :.",
                        JOptionPane.ERROR_MESSAGE);
                jtfAnoF.requestFocus();
                return false;
            }
            boolean testaAnoMod;
            int anoMod = Integer.parseInt(jtfAnoM.getText());
            testaAnoMod = cadCarros.verAnoMod(anoF, anoMod);
            if (!testaAnoMod) {
                String msg = "Ano modelo inválido!";
                JOptionPane.showMessageDialog(this, msg, ".: Erro :.",
                        JOptionPane.ERROR_MESSAGE);
                jtfAnoM.requestFocus();
                return false;
            }
            if (jcbMarca.getSelectedItem().equals("Selecione...")) {
                String msg = "Selecione um marca!";
                JOptionPane.showMessageDialog(this, msg, ".: Erro :.",
                        JOptionPane.ERROR_MESSAGE);
                jcbMarca.requestFocus();
                return false;
            }
            if (pessoaS.verCPF(jtfCPFProp.getText())) {
                jlNomeProp.setText("Proprietário inexistente!");
                String msg = "Primeiro cadastre o portador deste CPF: "
                        + ValidaCPF.imprimeCPF(jtfCPFProp.getText())
                        + ". Para assim cadastrar o veículo!";
                JOptionPane.showMessageDialog(this, msg, ".: Erro :.",
                        JOptionPane.ERROR_MESSAGE);
                jtfCPFProp.requestFocus();
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(carroCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        if (validaInputs()) {
            try {
                CarroServicos carroS = ServicosFactory.getCarroServicos();
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                int id = cadCarros.gerarId();
                int idPessoa = pessoaS.buscarPessoaBD(jtfCPFProp.getText()).getIdPessoa();
                String placa = jtfPlaca.getText();
                String marca = jcbMarca.getSelectedItem().toString();
                String modelo = jtfModelo.getText();
                int anoF = Integer.parseInt(jtfAnoF.getText());
                int anoM = Integer.parseInt(jtfAnoM.getText());
                String cor = jtfCor.getText();
                int portas = Integer.parseInt(jtfPortas.getText());
                Carro c = new Carro(id, placa, marca, modelo, anoF, anoM, cor,
                        portas, idPessoa);
                //cadCarros.add(c);

                carroS.cadCarro(c);
                jbLimpar.doClick();
                //addRowToTable();
                addRowToTableBD();
                JOptionPane.showMessageDialog(this, "Carro foi salvo com sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro!" + ex.getMessage(), "erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jtCarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCarrosMouseClicked
        // TODO add your handling code here:
        jbDeletar.setEnabled(true);
        jbEditar.setEnabled(true);
        jbSalvar.setEnabled(false);
    }//GEN-LAST:event_jtCarrosMouseClicked

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        try {
            // TODO add your handling code here:
            jbEditar.setEnabled(false);
            int linha;
            String placa;
            linha = jtCarros.getSelectedRow();
            placa = (String) jtCarros.getValueAt(linha, 0);
            CarroServicos carroS = ServicosFactory.getCarroServicos();
            Carro c = carroS.pesquisarPlacaBD(placa);

            Object[] resp = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(this,
                    "Deseja realmente deletar " + c.getPlaca() + "?",
                    ".: Deletar :.", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, resp, resp[0]);
            if (resposta == 0) {
                carroS.deletarCarroBD(c.getIdCarro());
                //cadCarros.deletar(c);
                addRowToTableBD();
                JOptionPane.showMessageDialog(this, "Carro deletado com sucesso!");

            } else {
                JOptionPane.showMessageDialog(this, "Entendemos sua decisão!",
                        ".: Deletar :.", JOptionPane.INFORMATION_MESSAGE);
            }
            jbLimpar.doClick();
        } catch (SQLException ex) {
            Logger.getLogger(carroCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        try {
            // TODO add your handling code here:
            jbEditar.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbDeletar.setEnabled(false);
            jbPesq.setEnabled(false);
            jtfPlaca.setEnabled(false);
            jbConfirmar.setEnabled(true);
            jbLimpar.setText("Cancelar");

            int linha = jtCarros.getSelectedRow();
            String placa = (String) jtCarros.getValueAt(linha, 0);

            CarroServicos carroS = ServicosFactory.getCarroServicos();
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();

            Carro c = carroS.pesquisarPlacaBD(placa);

            jtfPlaca.setText(c.getPlaca());
            jtfModelo.setText(c.getModelo());
            jtfAnoF.setText(Integer.toString(c.getAnoFabricacao()));
            jtfAnoM.setText(Integer.toString(c.getAnoModelo()));
            jtfCor.setText(c.getCor());
            jtfPortas.setText(Integer.toString(c.getnPortas()));
            jtfCPFProp.setText(pessoaS.getPessoaById(c.getIdPessoa()).getCpf());
            jlNomeProp.setText(pessoaS.getPessoaById(c.getIdPessoa()).getNomePessoa());
            jcbMarca.setSelectedItem(c.getMarca());
        } catch (SQLException ex) {
            Logger.getLogger(carroCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        // TODO add your handling code here:
        if (validaInputs()) {
            try {
                CarroServicos carroS = ServicosFactory.getCarroServicos();
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                Carro c = carroS.pesquisarPlacaBD(jtfPlaca.getText());

                c.setAnoFabricacao(Integer.parseInt(jtfAnoF.getText()));
                c.setAnoModelo(Integer.parseInt(jtfAnoM.getText()));
                c.setCor(jtfCor.getText());
                c.setMarca(jcbMarca.getSelectedItem().toString());
                c.setModelo(jtfModelo.getText());
                c.setnPortas(Integer.parseInt(jtfPortas.getText()));
                c.setIdPessoa(pessoaS.buscarPessoaBD(jtfCPFProp.getText()).getIdPessoa());

                carroS.atualizarCarroBD(c);
                addRowToTableBD();

                jbLimpar.doClick();
                jbLimpar.setText("Limpar");
                JOptionPane.showMessageDialog(this, "Carro atualizado com sucesso!!!");
            } catch (SQLException ex) {
                Logger.getLogger(carroCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPesqActionPerformed

    private void jtfModeloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfModeloFocusLost
        // TODO add your handling code here:
        jtfModelo.setText(jtfModelo.getText().toUpperCase());
    }//GEN-LAST:event_jtfModeloFocusLost

    private void jtfCPFPropFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCPFPropFocusGained
        // TODO add your handling code here:
        jlNomeProp.setText("Tecle Tab para ver o Propietário!");
    }//GEN-LAST:event_jtfCPFPropFocusGained

    private void jtfCorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCorFocusLost
        // TODO add your handling code here:
        jtfCor.setText(jtfCor.getText().toUpperCase());
    }//GEN-LAST:event_jtfCorFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(carroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new carroCadastro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(carroCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbPesq;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbMarca;
    private javax.swing.JLabel jlNomeProp;
    private javax.swing.JTable jtCarros;
    private javax.swing.JTextField jtfAnoF;
    private javax.swing.JTextField jtfAnoM;
    private javax.swing.JTextField jtfCPFProp;
    private javax.swing.JTextField jtfCor;
    private javax.swing.JTextField jtfModelo;
    private javax.swing.JFormattedTextField jtfPlaca;
    private javax.swing.JTextField jtfPortas;
    // End of variables declaration//GEN-END:variables
}
