package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAdcionarNotas extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaAdcionarNotas() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    private void AdcionarNotas() {

        try {

            String turma = TxtNomeDaTurma.getText();   
            String adicionar = "update " +turma+ " set nota_bimestre1 = ?, "
                    + "nota_bimestre2 = ?, situacao = ?"
                    + " where Id_aluno = ?;";
            st = conn.prepareStatement(adicionar);

            if ("usuarios".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma");
                TxtNomeDaTurma.setText(null);
            } else if ("alunos".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma");
                TxtNomeDaTurma.setText(null);
            } else {

                if (turma.isEmpty()) {
                    String informacao2 = "Selecione uma turma.";
                    JOptionPane.showMessageDialog(this, informacao2);
                } else if (TxtId.getText().isEmpty()) {
                    String informacao2 = "Você não selecionou um aluno.";
                    JOptionPane.showMessageDialog(this, informacao2);
                } else {

                    String comcluido = "Notas adicionadas";
                    
                    st.setString(1, CbNota1.getSelectedItem().toString());
                    st.setString(2, CbNota2.getSelectedItem().toString());
                    st.setString(3, CbSituacao.getSelectedItem().toString());
                    st.setString(4, TxtId.getText().trim());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(this, comcluido);
                    
                    TxtId.setText(null);
                    TxtNomeDaTurma.setText(null);

                }

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }

    }

    private void BuscarTurma() {

        String pesquisa = "show tables from projeto_final;";

        try {
            st = conn.prepareStatement(pesquisa);
            rs = st.executeQuery();
            TabTurmas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private void Dados() {

        try {

            String turma = TxtNomeDaTurma.getText().trim();
            String dados = "select * from " + turma + ";";
            st = conn.prepareStatement(dados);

            if ("usuarios".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma");
                TxtNomeDaTurma.setText(null);
            } else if ("alunos".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma");
                TxtNomeDaTurma.setText(null);
            } else {

                if (turma.isEmpty()) {
                    String informacao2 = "Selecione uma turma.";
                    JOptionPane.showMessageDialog(this, informacao2);
                } else {
                    String comcluido = "Busca realizada.";
                    rs = st.executeQuery();
                    JOptionPane.showMessageDialog(this, comcluido);
                    TabAlunosDaTurma.setModel(DbUtils.resultSetToTableModel(rs));
                }

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    private void MostrarTurma() {

        int setar = TabTurmas.getSelectedRow();

        try {
            TxtNomeDaTurma.setText(TabTurmas.getModel().getValueAt(setar, 0).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    private void MostrarAluno() {

        int setar = TabAlunosDaTurma.getSelectedRow();

        try {
            TxtId.setText(TabAlunosDaTurma.getModel().getValueAt(setar, 0).toString().trim());
            CbNota1.setSelectedItem(TabAlunosDaTurma.getModel().getValueAt(setar, 1).toString().trim());
            CbNota2.setSelectedItem(TabAlunosDaTurma.getModel().getValueAt(setar, 2).toString().trim());
            //CbSituacao.setActionCommand(TabAlunosDaTurma.getModel().getValueAt(setar, 2).toString().trim());
            CbSituacao.setSelectedItem(TabAlunosDaTurma.getModel().getValueAt(setar, 3).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabTurmas = new javax.swing.JTable();
        BtnBuscarTurma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LblNomeDaTurma = new javax.swing.JLabel();
        TxtNomeDaTurma = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabAlunosDaTurma = new javax.swing.JTable();
        BtnBuscarDados = new javax.swing.JButton();
        LblId = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        LblNota1 = new javax.swing.JLabel();
        LblNota2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CbSituacao = new javax.swing.JComboBox<>();
        CbNota1 = new javax.swing.JComboBox<>();
        CbNota2 = new javax.swing.JComboBox<>();
        BtnAdicionar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Adicionar notas a turma");

        jPanel1.setBackground(new java.awt.Color(6, 47, 79));

        TabTurmas.setForeground(new java.awt.Color(0, 0, 0));
        TabTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tabelas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabTurmas.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabTurmas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabTurmasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabTurmas);

        BtnBuscarTurma.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscarTurma.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarTurma.setText("Buscar");
        BtnBuscarTurma.setToolTipText("Buscar turmas.");
        BtnBuscarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarTurmaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas aluno e usuario não são turmas!");

        LblNomeDaTurma.setForeground(new java.awt.Color(255, 255, 255));
        LblNomeDaTurma.setText("Turma");

        TxtNomeDaTurma.setEditable(false);
        TxtNomeDaTurma.setBackground(new java.awt.Color(231, 223, 221));
        TxtNomeDaTurma.setForeground(new java.awt.Color(0, 0, 0));

        TabAlunosDaTurma.setForeground(new java.awt.Color(0, 0, 0));
        TabAlunosDaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id aluno", "Nota 1°B", "Nota 2°B", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabAlunosDaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabAlunosDaTurmaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabAlunosDaTurma);

        BtnBuscarDados.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscarDados.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarDados.setText("Buscar aluno");
        BtnBuscarDados.setToolTipText("Busca o usuário.");
        BtnBuscarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarDadosActionPerformed(evt);
            }
        });

        LblId.setForeground(new java.awt.Color(255, 255, 255));
        LblId.setText("Id");

        TxtId.setBackground(new java.awt.Color(231, 223, 221));
        TxtId.setForeground(new java.awt.Color(0, 0, 0));
        TxtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdActionPerformed(evt);
            }
        });

        LblNota1.setForeground(new java.awt.Color(255, 255, 255));
        LblNota1.setText("Nota 1°B");

        LblNota2.setForeground(new java.awt.Color(255, 255, 255));
        LblNota2.setText("Nota 2°B");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Situação");

        CbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprovado", "Estudando", "Recuperação", "Reprovado" }));

        CbNota1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.00", "0.50", "1.00", "1.50", "2.00", "2.50", "3.00", "3.50", "4.00", "4.50", "5.00", "5.50", "6.00", "6.50", "7.00", "7.50", "8.00", "8.50", "9.00", "9.50", "10.00" }));

        CbNota2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.00", "0.50", "1.00", "1.50", "2.00", "2.50", "3.00", "3.50", "4.00", "4.50", "5.00", "5.50", "6.00", "6.50", "7.00", "7.50", "8.00", "8.50", "9.00", "9.50", "10.00" }));

        BtnAdicionar.setBackground(new java.awt.Color(0, 204, 0));
        BtnAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAdicionar.setText("Adicionar");
        BtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBuscarDados)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnBuscarTurma)
                                .addGap(18, 18, 18)
                                .addComponent(LblNomeDaTurma)
                                .addGap(18, 18, 18)
                                .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNota1))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtId, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(CbNota1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblNota2)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CbSituacao, 0, 123, Short.MAX_VALUE)
                            .addComponent(CbNota2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(BtnAdicionar)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnBuscarTurma)
                            .addComponent(LblNomeDaTurma)
                            .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnBuscarDados)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblId)
                            .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(CbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNota1)
                            .addComponent(LblNota2)
                            .addComponent(CbNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAdicionar)
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTurmasMouseClicked
        MostrarTurma();
    }//GEN-LAST:event_TabTurmasMouseClicked

    private void BtnBuscarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarTurmaActionPerformed
        BuscarTurma();
    }//GEN-LAST:event_BtnBuscarTurmaActionPerformed

    private void BtnBuscarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarDadosActionPerformed
        Dados();
    }//GEN-LAST:event_BtnBuscarDadosActionPerformed

    private void TabAlunosDaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabAlunosDaTurmaMouseClicked
        MostrarAluno();
    }//GEN-LAST:event_TabAlunosDaTurmaMouseClicked

    private void TxtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdActionPerformed

    private void BtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAdicionarActionPerformed
        AdcionarNotas();
    }//GEN-LAST:event_BtnAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAdicionar;
    javax.swing.JButton BtnBuscarDados;
    javax.swing.JButton BtnBuscarTurma;
    javax.swing.JComboBox<String> CbNota1;
    javax.swing.JComboBox<String> CbNota2;
    javax.swing.JComboBox<String> CbSituacao;
    javax.swing.JLabel LblId;
    javax.swing.JLabel LblNomeDaTurma;
    javax.swing.JLabel LblNota1;
    javax.swing.JLabel LblNota2;
    javax.swing.JTable TabAlunosDaTurma;
    javax.swing.JTable TabTurmas;
    javax.swing.JTextField TxtId;
    javax.swing.JTextField TxtNomeDaTurma;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
