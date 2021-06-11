package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaVerNotas extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaVerNotas() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabTurmas = new javax.swing.JTable();
        BtnBuscar2 = new javax.swing.JButton();
        LogoBranco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabAlunoDaTurma = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TxtNomeDaTurma = new javax.swing.JTextField();
        BtnBuscarDados = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Buscar turmas");
        setAutoscrolls(true);

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

        BtnBuscar2.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscar2.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar2.setText("Buscar");
        BtnBuscar2.setToolTipText("Busca as tabelas");
        BtnBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar2ActionPerformed(evt);
            }
        });

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas aluno e usuario não são turmas!");

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
        jScrollPane2.setViewportView(TabAlunoDaTurma);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da turma");

        TxtNomeDaTurma.setEditable(false);
        TxtNomeDaTurma.setBackground(new java.awt.Color(231, 223, 221));
        TxtNomeDaTurma.setForeground(new java.awt.Color(0, 0, 0));

        BtnBuscarDados.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscarDados.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarDados.setText("Buscar");
        BtnBuscarDados.setToolTipText("Busca os alunos da turma.");
        BtnBuscarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBuscar2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(BtnBuscarDados))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoBranco)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar2)
                    .addComponent(jLabel1)
                    .addComponent(BtnBuscarDados))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogoBranco)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void BtnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar2ActionPerformed
        Buscar();
    }//GEN-LAST:event_BtnBuscar2ActionPerformed

    private void BtnBuscarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarDadosActionPerformed
        Dados();
    }//GEN-LAST:event_BtnBuscarDadosActionPerformed

    private void TabTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTurmasMouseClicked
        MostrarTurma();
    }//GEN-LAST:event_TabTurmasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnBuscar2;
    javax.swing.JButton BtnBuscarDados;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabAlunoDaTurma;
    javax.swing.JTable TabTurmas;
    javax.swing.JTextField TxtNomeDaTurma;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
