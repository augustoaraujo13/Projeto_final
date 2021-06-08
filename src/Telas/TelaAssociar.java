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

    private void Buscar() {
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

    private void Mostrar() {

        int setar = TabAlunos.getSelectedRow();

        TxtMatricula.setText(TabAlunos.getModel().getValueAt(setar, 0).toString().trim());
        TxtAluno.setText(TabAlunos.getModel().getValueAt(setar, 1).toString().trim());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabAlunos = new javax.swing.JTable();
        BtnBuscar4 = new javax.swing.JButton();
        LblMatricula = new javax.swing.JLabel();
        TxtMatricula = new javax.swing.JTextField();
        LblAluno = new javax.swing.JLabel();
        TxtAluno = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Painel de assocair aluno a uma turma");

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
        TabAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabAlunos);

        BtnBuscar4.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscar4.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar4.setText("Buscar");
        BtnBuscar4.setToolTipText("Busca o usuário.");
        BtnBuscar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar4ActionPerformed(evt);
            }
        });

        LblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        LblMatricula.setText("Matricula");

        TxtMatricula.setEditable(false);

        LblAluno.setText("Aluno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblMatricula)
                        .addGap(18, 18, 18)
                        .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(LblAluno)
                        .addGap(18, 18, 18)
                        .addComponent(TxtAluno))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar4))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnBuscar4)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblMatricula)
                    .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblAluno)
                    .addComponent(TxtAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
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
        Mostrar();
    }//GEN-LAST:event_TabAlunosMouseClicked

    private void BtnBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar4ActionPerformed
        Buscar();
    }//GEN-LAST:event_BtnBuscar4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnBuscar4;
    javax.swing.JLabel LblAluno;
    javax.swing.JLabel LblMatricula;
    javax.swing.JTable TabAlunos;
    javax.swing.JTextField TxtAluno;
    javax.swing.JTextField TxtMatricula;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
