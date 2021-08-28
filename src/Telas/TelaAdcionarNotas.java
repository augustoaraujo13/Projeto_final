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

    //Esse metedo adiciona notas ao aluno.
    private void AdcionarNotas() {
        try {
            String turma = TxtNomeDaTurma.getText();
            String adicionar = "update " + turma + " set nota_bimestre1 = ?, "
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
                    String comcluido = "Notas adicionadas.";

                    st.setString(1, CbNota1.getSelectedItem().toString());
                    st.setString(2, CbNota2.getSelectedItem().toString());
                    st.setString(3, CbSituacao.getSelectedItem().toString());
                    st.setString(4, TxtId.getText().trim());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(this, comcluido);

                    CbNota1.setSelectedItem(null);
                    CbNota2.setSelectedItem(null);
                    CbSituacao.setSelectedItem(null);
                    TxtId.setText(null);
                    //TxtNomeDaTurma.setText(null);
                }

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            //System.out.println(e);
        }

    }

    //Esse metedo busca as turmas.
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

    //Esse metedo mostra os dados da turma.
    private void Dados() {
        try {
            String turma = TxtNomeDaTurma.getText().trim();
            String dados = "select Id_aluno as Id, nota_bimestre1 as 1°Bimestre,"
                    + " nota_bimestre2 as 2°Bimestre, situacao as Situação"
                    + " from " + turma + ";";
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

    //Esse metedo mostra as turmas.
    private void MostrarTurma() {
        int setar = TabTurmas.getSelectedRow();
        try {
            TxtNomeDaTurma.setText(TabTurmas.getModel().getValueAt(setar, 0).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    //Esse metedo mostra os alunos. 
    private void MostrarAluno() {
        int setar = TabAlunosDaTurma.getSelectedRow();
        try {

            String id = TabAlunosDaTurma.getModel().getValueAt(setar, 0).toString().trim();
            String busca = "select * from alunos where matricula =" + id;

            st = conn.prepareStatement(busca);
            rs = st.executeQuery();

            if (rs.next()) {
                TxtNome.setText(rs.getString(3));
                TxtId.setText(TabAlunosDaTurma.getModel().getValueAt(setar, 0).toString().trim());
                CbNota1.setSelectedItem(TabAlunosDaTurma.getModel().getValueAt(setar, 1).toString().trim());
                CbNota2.setSelectedItem(TabAlunosDaTurma.getModel().getValueAt(setar, 2).toString().trim());
                //CbSituacao.setActionCommand(TabAlunosDaTurma.getModel().getValueAt(setar, 2).toString().trim());
                CbSituacao.setSelectedItem(TabAlunosDaTurma.getModel().getValueAt(setar, 3).toString().trim());
            } else {

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabTurmas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        BtnBuscarTurma = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LblNomeDaTurma = new javax.swing.JLabel();
        TxtNomeDaTurma = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabAlunosDaTurma = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
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
        LogoBranco1 = new javax.swing.JLabel();
        LblNome = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Adicionar nota");

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
                "Turmas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabTurmas.setFocusable(false);
        TabTurmas.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabTurmas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabTurmas.getTableHeader().setResizingAllowed(false);
        TabTurmas.getTableHeader().setReorderingAllowed(false);
        TabTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabTurmasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabTurmas);

        BtnBuscarTurma.setBackground(new java.awt.Color(0, 255, 204));
        BtnBuscarTurma.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarTurma.setText("Turmas");
        BtnBuscarTurma.setToolTipText("Busca as turmas.");
        BtnBuscarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarTurmaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas alunos e usuario não são turmas!");

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
                "Id", "1°Bimestre", "2°Bimestre", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabAlunosDaTurma.setFocusable(false);
        TabAlunosDaTurma.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabAlunosDaTurma.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabAlunosDaTurma.getTableHeader().setResizingAllowed(false);
        TabAlunosDaTurma.getTableHeader().setReorderingAllowed(false);
        TabAlunosDaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabAlunosDaTurmaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabAlunosDaTurma);

        BtnBuscarDados.setBackground(new java.awt.Color(255, 255, 0));
        BtnBuscarDados.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarDados.setText("Alunos");
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

        CbSituacao.setBackground(new java.awt.Color(255, 0, 255));
        CbSituacao.setForeground(new java.awt.Color(0, 0, 0));
        CbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprovado", "Estudando", "Recuperação", "Reprovado" }));

        CbNota1.setBackground(new java.awt.Color(255, 0, 255));
        CbNota1.setForeground(new java.awt.Color(0, 0, 0));
        CbNota1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.00", "0.50", "1.00", "1.50", "2.00", "2.50", "3.00", "3.50", "4.00", "4.50", "5.00", "5.50", "6.00", "6.50", "7.00", "7.50", "8.00", "8.50", "9.00", "9.50", "10.00" }));

        CbNota2.setBackground(new java.awt.Color(255, 0, 255));
        CbNota2.setForeground(new java.awt.Color(0, 0, 0));
        CbNota2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.00", "0.50", "1.00", "1.50", "2.00", "2.50", "3.00", "3.50", "4.00", "4.50", "5.00", "5.50", "6.00", "6.50", "7.00", "7.50", "8.00", "8.50", "9.00", "9.50", "10.00" }));

        BtnAdicionar.setBackground(new java.awt.Color(102, 102, 255));
        BtnAdicionar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAdicionar.setText("Adicionar");
        BtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAdicionarActionPerformed(evt);
            }
        });

        LogoBranco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        LblNome.setForeground(new java.awt.Color(255, 255, 255));
        LblNome.setText("Nome");

        TxtNome.setEditable(false);
        TxtNome.setBackground(new java.awt.Color(231, 223, 221));
        TxtNome.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblNota1)
                                    .addComponent(LblNomeDaTurma))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtNomeDaTurma)
                                            .addComponent(TxtNome))
                                        .addGap(25, 25, 25)
                                        .addComponent(CbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(CbNota1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(LblNota2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CbNota2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LblNome)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnAdicionar)
                            .addComponent(BtnBuscarDados)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(BtnBuscarTurma)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LogoBranco1)
                                    .addGap(26, 26, 26))))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnBuscarTurma, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LogoBranco1)
                                .addGap(23, 23, 23))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscarDados)
                    .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblNomeDaTurma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblNome))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(BtnAdicionar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblId)
                            .addComponent(jLabel2)
                            .addComponent(CbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbNota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNota1)
                            .addComponent(LblNota2)
                            .addComponent(CbNota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
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
        Dados();

    }//GEN-LAST:event_BtnAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAdicionar;
    javax.swing.JButton BtnBuscarDados;
    javax.swing.JButton BtnBuscarTurma;
    javax.swing.JComboBox<String> CbNota1;
    javax.swing.JComboBox<String> CbNota2;
    javax.swing.JComboBox<String> CbSituacao;
    javax.swing.JLabel LblId;
    javax.swing.JLabel LblNome;
    javax.swing.JLabel LblNomeDaTurma;
    javax.swing.JLabel LblNota1;
    javax.swing.JLabel LblNota2;
    javax.swing.JLabel LogoBranco1;
    javax.swing.JTable TabAlunosDaTurma;
    javax.swing.JTable TabTurmas;
    javax.swing.JTextField TxtId;
    javax.swing.JTextField TxtNome;
    javax.swing.JTextField TxtNomeDaTurma;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
