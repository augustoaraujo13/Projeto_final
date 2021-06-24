package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAlterarDeletar extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaAlterarDeletar() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    private void Buscar() {

        String pesquisa = "show tables from projeto_final;";

        try {
            st = conn.prepareStatement(pesquisa);
            rs = st.executeQuery();
            TabTurmas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            //System.out.println(e);
        }

    }

    private void MostrarTurma() {

        int setar = TabTurmas.getSelectedRow();

        try {
            TxtNomeDaTurma.setText(TabTurmas.getModel().getValueAt(setar, 0).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio.");
            //System.out.println(e);
        }

    }

    private void AlterarNome() {

        try {
            String turma = TxtNomeDaTurma.getText().trim();
            String mensagem = "Informe o novo nome da turma.";
            String nomeTurma = JOptionPane.showInputDialog(mensagem).trim();
            String alterar = "rename table " + turma + " to " + nomeTurma + ";";
            st = conn.prepareStatement(alterar);

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
                    String comcluido = "Nome da turma foi alterado.";
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(this, comcluido);
                    TxtNomeDaTurma.setText(null);
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Nome da turma não foi alterado.");
            //System.out.println(e);
        }

    }

    private void DeletarTurma() throws SQLException {
        String confirmando = "Deseja deletar essa turma?";
        String confirmando2 = "Atenção";

        int confirmar = JOptionPane.showConfirmDialog(null, confirmando, confirmando2, JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {

            try {
                String turma = TxtNomeDaTurma.getText().trim();
                String deletando = "drop table " + turma + ";";
                st = conn.prepareStatement(deletando);

                if ("usuarios".equals(turma)) {
                    JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                    TxtNomeDaTurma.setText(null);
                } else if ("alunos".equals(turma)) {
                    JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                    TxtNomeDaTurma.setText(null);
                } else {
                    String comcluido = "Turma foi deletada.";
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(this, comcluido);
                    TxtNomeDaTurma.setText(null);

                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "A turma não foi deletada.");
                System.out.println(e);
            }

        } else {
            JOptionPane.showMessageDialog(this, "A turma não foi deletada.");
            TxtNomeDaTurma.setText(null);
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
                    TabAlunoDaTurma.setModel(DbUtils.resultSetToTableModel(rs));
                }

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    private void Mostrar() {

        int setar = TabAlunoDaTurma.getSelectedRow();

        try {
            TxtMatricula.setText(TabAlunoDaTurma.getModel().getValueAt(setar, 0).toString().trim());
            TxtNome.setText(TabAlunoDaTurma.getModel().getValueAt(setar, 1).toString().trim());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    private void DeletarAluno() {

        String confirmando = "Deseja deletar esse aluno da turma?";
        String confirmando2 = "Atenção";

        int confirmar = JOptionPane.showConfirmDialog(null, confirmando, confirmando2, JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {

            try {

                String turma = TxtNomeDaTurma.getText().trim();
                String id = TxtMatricula.getText().trim();
                String deletando = "delete from " + turma + " where Id_aluno = "
                        + id + ";";
                st = conn.prepareStatement(deletando);

                if ("usuarios".equals(turma)) {
                    JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                    TxtNomeDaTurma.setText(null);
                } else if ("alunos".equals(turma)) {
                    JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                    TxtNomeDaTurma.setText(null);
                } else {
                    if (id.isEmpty()) {
                        String informacao = "Selecione um aluno para poder excluir.";
                        JOptionPane.showMessageDialog(this, informacao);
                    } else {
                        String comcluido = "Aluno foi excluído da turma com sucesso!";
                        st.executeUpdate();

                        JOptionPane.showMessageDialog(this, comcluido);
                        TxtNomeDaTurma.setText(null);
                        TxtMatricula.setText(null);

                    }

                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, e);
                System.out.println(e);
                TxtNomeDaTurma.setText(null);
                TxtMatricula.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O aluno não foi excluído da turma.");
            TxtNomeDaTurma.setText(null);
            TxtMatricula.setText(null);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabTurmas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnBuscarTurma = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtNomeDaTurma = new javax.swing.JTextField();
        BtnAlterarTurmas = new javax.swing.JButton();
        BtnDeletarTurmas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabAlunoDaTurma = new javax.swing.JTable();
        BtnBuscarAlunos = new javax.swing.JButton();
        LblMatricula = new javax.swing.JLabel();
        TxtMatricula = new javax.swing.JTextField();
        LblNome = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        BtnDeletarAluno = new javax.swing.JButton();
        LogoBranco = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alterar e deletar");

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
        jScrollPane1.setViewportView(TabTurmas);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas alunos e usuario não são turmas!");

        BtnBuscarTurma.setBackground(new java.awt.Color(0, 255, 204));
        BtnBuscarTurma.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarTurma.setText("Turmas");
        BtnBuscarTurma.setToolTipText("Busca as tabelas");
        BtnBuscarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarTurmaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da turma");

        TxtNomeDaTurma.setBackground(new java.awt.Color(231, 223, 221));
        TxtNomeDaTurma.setForeground(new java.awt.Color(0, 0, 0));
        TxtNomeDaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomeDaTurmaActionPerformed(evt);
            }
        });

        BtnAlterarTurmas.setBackground(new java.awt.Color(255, 153, 0));
        BtnAlterarTurmas.setForeground(new java.awt.Color(0, 0, 0));
        BtnAlterarTurmas.setText("Alterar");
        BtnAlterarTurmas.setToolTipText("Altera nome da turma.");
        BtnAlterarTurmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAlterarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarTurmasActionPerformed(evt);
            }
        });

        BtnDeletarTurmas.setBackground(new java.awt.Color(255, 0, 0));
        BtnDeletarTurmas.setForeground(new java.awt.Color(0, 0, 0));
        BtnDeletarTurmas.setText("Deletar");
        BtnDeletarTurmas.setToolTipText("Cuidado!! Deleta a turma");
        BtnDeletarTurmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeletarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarTurmasActionPerformed(evt);
            }
        });

        TabAlunoDaTurma.setForeground(new java.awt.Color(0, 0, 0));
        TabAlunoDaTurma.setModel(new javax.swing.table.DefaultTableModel(
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
        TabAlunoDaTurma.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabAlunoDaTurma.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabAlunoDaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabAlunoDaTurmaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabAlunoDaTurma);

        BtnBuscarAlunos.setBackground(new java.awt.Color(255, 255, 0));
        BtnBuscarAlunos.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarAlunos.setText("Alunos");
        BtnBuscarAlunos.setToolTipText("Busca os alunos da turma.");
        BtnBuscarAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarAlunosActionPerformed(evt);
            }
        });

        LblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        LblMatricula.setText("Matrícula");

        TxtMatricula.setBackground(new java.awt.Color(231, 223, 221));

        LblNome.setForeground(new java.awt.Color(255, 255, 255));
        LblNome.setText("Nome");

        TxtNome.setBackground(new java.awt.Color(231, 223, 221));

        BtnDeletarAluno.setBackground(new java.awt.Color(255, 0, 0));
        BtnDeletarAluno.setForeground(new java.awt.Color(0, 0, 0));
        BtnDeletarAluno.setText("Deletar");
        BtnDeletarAluno.setToolTipText("Cuidado!! Deleta o aluno da turma.");
        BtnDeletarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeletarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarAlunoActionPerformed(evt);
            }
        });

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("---------Alunos---------");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("---------Turmas---------");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnBuscarTurma)
                                .addGap(32, 32, 32)
                                .addComponent(BtnAlterarTurmas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnDeletarTurmas))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblMatricula)
                            .addComponent(LblNome))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNome)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnBuscarAlunos)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDeletarAluno)
                                .addGap(27, 27, 27)
                                .addComponent(LogoBranco)))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(193, 193, 193))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnBuscarTurma)
                        .addComponent(BtnAlterarTurmas)
                        .addComponent(BtnDeletarTurmas)
                        .addComponent(LblMatricula)
                        .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnDeletarAluno)
                        .addComponent(BtnBuscarAlunos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNome)
                            .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(LogoBranco)))
                .addGap(16, 31, Short.MAX_VALUE))
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
        Buscar();
    }//GEN-LAST:event_BtnBuscarTurmaActionPerformed

    private void TxtNomeDaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomeDaTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomeDaTurmaActionPerformed

    private void BtnAlterarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarTurmasActionPerformed
        AlterarNome();
    }//GEN-LAST:event_BtnAlterarTurmasActionPerformed

    private void BtnDeletarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarTurmasActionPerformed
        try {
            DeletarTurma();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAlterarDeletar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnDeletarTurmasActionPerformed

    private void BtnBuscarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarAlunosActionPerformed
        Dados();
    }//GEN-LAST:event_BtnBuscarAlunosActionPerformed

    private void TabAlunoDaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabAlunoDaTurmaMouseClicked
        Mostrar();
    }//GEN-LAST:event_TabAlunoDaTurmaMouseClicked

    private void BtnDeletarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarAlunoActionPerformed
        DeletarAluno();
    }//GEN-LAST:event_BtnDeletarAlunoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAlterarTurmas;
    javax.swing.JButton BtnBuscarAlunos;
    javax.swing.JButton BtnBuscarTurma;
    javax.swing.JButton BtnDeletarAluno;
    javax.swing.JButton BtnDeletarTurmas;
    javax.swing.JLabel LblMatricula;
    javax.swing.JLabel LblNome;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabAlunoDaTurma;
    javax.swing.JTable TabTurmas;
    javax.swing.JTextField TxtMatricula;
    javax.swing.JTextField TxtNome;
    javax.swing.JTextField TxtNomeDaTurma;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
