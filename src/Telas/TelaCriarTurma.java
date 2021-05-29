package Telas;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCriarTurma extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;

    public TelaCriarTurma() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    private void CriarTurma() throws SQLException {

        String novaTurma1 = "create table ";
        String nomeTurma = TxtNovaTurma.getText().trim();
        String novaTurma2 = "(Id_aluno int not null,nota_bimestre1 decimal(2,2),nota_bimestre2 decimal(2,2),"
                + "situacao varchar(10) not null, foreign key (Id_aluno) references alunos(matricula)"
                + ");";
        String novaTurma3 = "(Id_aluno int not null, "
                + "nota_bimestre1 decimal(2,2), nota_bimestre2 decimal(2,2), "
                + "nota_bimestre3 decimal(2,2), nota_bimestre4 decimal(2,2), "
                + "situacao varchar(10) not null, foreign key (Id_aluno) references alunos(matricula)"
                + ");";
        String sql1 = novaTurma1 + nomeTurma + novaTurma2;
        String sql2 = novaTurma1 + nomeTurma + novaTurma3;
        String comcluido = "Nova turma cadastrada!";

        try {
            st = conn.createStatement();

            if (TxtNovaTurma.getText().isEmpty()) {
                String informacao2 = "Preencha o campo obrigatório!";
                JOptionPane.showMessageDialog(this, informacao2);
            } else {

                if ("2 bimestres".equals(CbBimestre.toString())) {
                    st.executeUpdate(sql1);
                    st.executeBatch();

                    JOptionPane.showMessageDialog(this, comcluido);
                    TxtNovaTurma.setText(null);

                } else {
                    st.executeUpdate(sql1);
                    st.executeBatch();

                    JOptionPane.showMessageDialog(this, comcluido);
                    TxtNovaTurma.setText(null);

                }

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
        CbBimestre = new javax.swing.JComboBox<>();
        LblBimestre = new javax.swing.JLabel();

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

        CbBimestre.setBackground(new java.awt.Color(204, 0, 204));
        CbBimestre.setForeground(new java.awt.Color(0, 0, 0));
        CbBimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 bimestres", "4 bimestres" }));

        LblBimestre.setForeground(new java.awt.Color(255, 255, 255));
        LblBimestre.setText("Bimestre");

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
                            .addComponent(LblBimestre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(TxtNovaTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(CbBimestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblBimestre))
                .addGap(18, 18, 18)
                .addComponent(BtnCriar)
                .addContainerGap(46, Short.MAX_VALUE))
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
    javax.swing.JComboBox<String> CbBimestre;
    javax.swing.JLabel LblBimestre;
    javax.swing.JLabel LblNovaTurma;
    javax.swing.JTextField TxtNovaTurma;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
