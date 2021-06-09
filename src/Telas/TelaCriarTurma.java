package Telas;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCriarTurma extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private Statement st = null;
    private final ResultSet rs = null;

    public TelaCriarTurma() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    private void CriarTurma() throws SQLException {

        String novaTurma1 = "create table ";
        String nomeTurma = TxtNovaTurma.getText().trim().toLowerCase();
        String novaTurma2 = "(Id_aluno int not null,nota_bimestre1 decimal(4,2),nota_bimestre2 decimal(4,2),"
                + "situacao varchar(15) not null, foreign key (Id_aluno) references alunos(matricula)"
                + ");";
        String sql1 = novaTurma1 + nomeTurma + novaTurma2;
        String comcluido = "Nova turma cadastrada!";

        try {
            st = conn.createStatement();

            if (TxtNovaTurma.getText().isEmpty()) {
                String informacao2 = "Preencha o campo obrigatório!";
                JOptionPane.showMessageDialog(this, informacao2);
            } else {
                st.executeUpdate(sql1);
                st.executeBatch();

                JOptionPane.showMessageDialog(this, comcluido);
                TxtNovaTurma.setText(null);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblNovaTurma = new javax.swing.JLabel();
        TxtNovaTurma = new javax.swing.JTextField();
        BtnCriar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LogoBranco = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Painel de criação de turma");

        jPanel1.setBackground(new java.awt.Color(6, 47, 79));

        LblNovaTurma.setForeground(new java.awt.Color(255, 255, 255));
        LblNovaTurma.setText("Nome da turma");

        TxtNovaTurma.setBackground(new java.awt.Color(231, 223, 221));
        TxtNovaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNovaTurmaActionPerformed(evt);
            }
        });

        BtnCriar.setBackground(new java.awt.Color(0, 204, 0));
        BtnCriar.setForeground(new java.awt.Color(0, 0, 0));
        BtnCriar.setText("Criar");
        BtnCriar.setToolTipText("Cria um novo usuário.");
        BtnCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCriarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("EX: Informatica_2022.2");

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblNovaTurma)
                            .addComponent(LogoBranco))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(TxtNovaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNovaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblNovaTurma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(BtnCriar))
                    .addComponent(LogoBranco))
                .addContainerGap(56, Short.MAX_VALUE))
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

    private void BtnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCriarActionPerformed
        try {
            CriarTurma();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCriarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnCriarActionPerformed

    private void TxtNovaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNovaTurmaActionPerformed

    }//GEN-LAST:event_TxtNovaTurmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnCriar;
    javax.swing.JLabel LblNovaTurma;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTextField TxtNovaTurma;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
