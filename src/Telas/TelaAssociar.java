package Telas;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAssociar extends javax.swing.JInternalFrame {
    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaAssociar() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    //Esse metedo busca os alunos.
    private void BuscarAluno() {
        String pesquisa = "select matricula, nome, "
                + "CPF from alunos order by matricula;";
        try {
            st = conn.prepareStatement(pesquisa);
            rs = st.executeQuery();
            TabAlunos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Esse metodo busca todas as tabelas do banco.
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

    //Esse metodo seta as informações da pesquisa nos campos.
    private void MostrarAluno() {
        int setar = TabAlunos.getSelectedRow();

        try {
            TxtMatricula.setText(TabAlunos.getModel().getValueAt(setar, 0).toString().trim());
            TxtAluno.setText(TabAlunos.getModel().getValueAt(setar, 1).toString().trim());
            TxtCpf.setText(TabAlunos.getModel().getValueAt(setar, 2).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    //Esse metedo seta o campoo com nome da turma escolhido.
    private void MostrarTurma() {
        int setar = TabTurmas.getSelectedRow();

        try {
            TxtNomeDaTurma.setText(TabTurmas.getModel().getValueAt(setar, 0).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    // Esse metodo associa o aluno a turma escolhida.
    private void Associar() {
        try {
            String turma = TxtNomeDaTurma.getText().trim();
            String associando = "insert into " + turma + "(id_aluno, nota_bimestre1, "
                    + "nota_bimestre2, situacao)"
                    + " values (?, '0.00', '0.00', 'Estudando');";
            st = conn.prepareStatement(associando);

            if ("usuarios".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                TxtNomeDaTurma.setText(null);
            } else if ("alunos".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                TxtNomeDaTurma.setText(null);
            } else {
                if (turma.isEmpty()) {
                    String informacao2 = "Selecione uma turma.";
                    JOptionPane.showMessageDialog(this, informacao2);
                } else {
                    String comcluido = "Aluno foi associado a turma.";
                    st.setString(1, TxtMatricula.getText().trim());
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(this, comcluido);

                    TxtAluno.setText(null);
                    TxtMatricula.setText(null);
                    TxtNomeDaTurma.setText(null);
                    TxtCpf.setText(null);
                }

            }

        } catch (SQLException e) {
            //System.out.println(e);
            JOptionPane.showMessageDialog(this, e);
            TxtAluno.setText(null);
            TxtMatricula.setText(null);
            TxtNomeDaTurma.setText(null);
            TxtCpf.setText(null);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabAlunos = new javax.swing.JTable();
        BtnBuscarAluno = new javax.swing.JButton();
        LblMatricula = new javax.swing.JLabel();
        TxtMatricula = new javax.swing.JTextField();
        LblAluno = new javax.swing.JLabel();
        TxtAluno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabTurmas = new javax.swing.JTable();
        BtnBuscarTurma = new javax.swing.JButton();
        LblNomeDaTurma = new javax.swing.JLabel();
        TxtNomeDaTurma = new javax.swing.JTextField();
        BtnAssociar = new javax.swing.JButton();
        LogoBranco = new javax.swing.JLabel();
        LblCpf = new javax.swing.JLabel();
        TxtCpf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela associar");

        jPanel1.setBackground(new java.awt.Color(6, 47, 79));

        TabAlunos.setForeground(new java.awt.Color(0, 0, 0));
        TabAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabAlunos.setToolTipText("");
        TabAlunos.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabAlunos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabAlunos);

        BtnBuscarAluno.setBackground(new java.awt.Color(255, 255, 0));
        BtnBuscarAluno.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarAluno.setText("Alunos");
        BtnBuscarAluno.setToolTipText("Busca os alunos.");
        BtnBuscarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarAlunoActionPerformed(evt);
            }
        });

        LblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        LblMatricula.setText("Matricula");

        TxtMatricula.setEditable(false);
        TxtMatricula.setBackground(new java.awt.Color(231, 223, 221));
        TxtMatricula.setForeground(new java.awt.Color(0, 0, 0));

        LblAluno.setForeground(new java.awt.Color(255, 255, 255));
        LblAluno.setText("Aluno");

        TxtAluno.setEditable(false);
        TxtAluno.setBackground(new java.awt.Color(231, 223, 221));
        TxtAluno.setForeground(new java.awt.Color(0, 0, 0));

        TabTurmas.setForeground(new java.awt.Color(0, 0, 0));
        TabTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
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

        BtnBuscarTurma.setBackground(new java.awt.Color(0, 255, 204));
        BtnBuscarTurma.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarTurma.setText("Turmas");
        BtnBuscarTurma.setToolTipText("Mostra todas as turmas.");
        BtnBuscarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarTurmaActionPerformed(evt);
            }
        });

        LblNomeDaTurma.setForeground(new java.awt.Color(255, 255, 255));
        LblNomeDaTurma.setText("Nome da turma");

        TxtNomeDaTurma.setEditable(false);
        TxtNomeDaTurma.setBackground(new java.awt.Color(231, 223, 221));
        TxtNomeDaTurma.setForeground(new java.awt.Color(0, 0, 0));

        BtnAssociar.setBackground(new java.awt.Color(255, 0, 255));
        BtnAssociar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAssociar.setText("Associar");
        BtnAssociar.setToolTipText("Associar o aluno a turma.");
        BtnAssociar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAssociarActionPerformed(evt);
            }
        });

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        LblCpf.setForeground(new java.awt.Color(255, 255, 255));
        LblCpf.setText("CPF");

        TxtCpf.setEditable(false);
        TxtCpf.setBackground(new java.awt.Color(231, 223, 221));
        TxtCpf.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas aluno e usuario não são turmas!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnAssociar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoBranco)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnBuscarAluno))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BtnBuscarTurma)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblNomeDaTurma)
                                    .addComponent(LblMatricula))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(LblCpf))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LblAluno)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(74, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscarAluno)
                    .addComponent(BtnBuscarTurma)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMatricula)
                    .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblAluno)
                    .addComponent(TxtAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNomeDaTurma)
                    .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblCpf)
                    .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoBranco)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BtnAssociar)
                        .addContainerGap(24, Short.MAX_VALUE))))
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

    private void TabAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabAlunosMouseClicked
        MostrarAluno();
    }//GEN-LAST:event_TabAlunosMouseClicked

    private void BtnBuscarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarAlunoActionPerformed
        BuscarAluno();
    }//GEN-LAST:event_BtnBuscarAlunoActionPerformed

    private void BtnBuscarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarTurmaActionPerformed
        BuscarTurma();
    }//GEN-LAST:event_BtnBuscarTurmaActionPerformed

    private void TabTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTurmasMouseClicked
        MostrarTurma();
    }//GEN-LAST:event_TabTurmasMouseClicked

    private void BtnAssociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAssociarActionPerformed
        Associar();
    }//GEN-LAST:event_BtnAssociarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAssociar;
    javax.swing.JButton BtnBuscarAluno;
    javax.swing.JButton BtnBuscarTurma;
    javax.swing.JLabel LblAluno;
    javax.swing.JLabel LblCpf;
    javax.swing.JLabel LblMatricula;
    javax.swing.JLabel LblNomeDaTurma;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabAlunos;
    javax.swing.JTable TabTurmas;
    javax.swing.JTextField TxtAluno;
    javax.swing.JTextField TxtCpf;
    javax.swing.JTextField TxtMatricula;
    javax.swing.JTextField TxtNomeDaTurma;
    javax.swing.JLabel jLabel1;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
