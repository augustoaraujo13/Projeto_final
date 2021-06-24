package Telas;

import Conexao.ConexaoBanco;
//import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaLogin() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    //Esse metedo faz login no sistema.
    private void Logar() {
        String comando = "select * from usuarios where login = ? and senha = ?;";

        try {
            st = conn.prepareStatement(comando);
            st.setString(1, TxtUsuario.getText());
            st.setString(2, PasSenha.getText());
            rs = st.executeQuery();

            if ((TxtUsuario.getText().trim().isEmpty())
                    || (PasSenha.getText().trim().isEmpty())) {
                String informacao1 = "Preencha todos os campos.";
                JOptionPane.showMessageDialog(this, informacao1);
                
            } else {
                if (rs.next()) {
                    String cargo = rs.getString(3);

                    if (cargo.equals("Coordenador")) {
                        TelaPrincipal tp = new TelaPrincipal();
                        tp.setVisible(true);
                        String funcionario = "coordenador(a) ";
                        // Coloca o nome e o cargo do usuário na tela principal
                        tp.LblNomeUsuario.setText(funcionario + rs.getString(2) + "!");
                        this.dispose();

                    } else if (cargo.equals("Professor")) {
                        TelaPrincipal tp = new TelaPrincipal();
                        tp.setVisible(true);
                        String funcionario = "professor(a) ";
                        // Coloca o nome e o cargo do usuário na tela principal
                        tp.LblNomeUsuario.setText(funcionario + rs.getString(2) + "!");
                        //Menu cadastro
                        tp.MenuAluno.setEnabled(false);
                        tp.MenuUsuario.setEnabled(false);
                        //Menu turma
                        tp.MenuAlterarDeletar.setEnabled(false);
                        tp.MenuAssociar.setEnabled(false);
                        tp.MenuBuscar.setEnabled(false);
                        tp.MenuCriar.setEnabled(false);
                        //Menu secretário
                        tp.MenuVerAlunos.setEnabled(false);
                        tp.MenuVerNotas.setEnabled(false);
                        this.dispose();

                    } else {
                        TelaPrincipal tp = new TelaPrincipal();
                        tp.setVisible(true);
                        String funcionario = "secretário(a) ";
                        // Coloca o nome e o cargo do usuário na tela principal
                        tp.LblNomeUsuario.setText(funcionario + rs.getString(2) + "!");
                        //Menu cadastro
                        tp.MenuAluno.setEnabled(false);
                        tp.MenuUsuario.setEnabled(false);
                        //Menu turma
                        tp.MenuAlterarDeletar.setEnabled(false);
                        tp.MenuAssociar.setEnabled(false);
                        tp.MenuBuscar.setEnabled(false);
                        tp.MenuCriar.setEnabled(false);
                        //Menu professor
                        tp.MenuBuscarAluno.setEnabled(false);
                        tp.MenuAdicionarNotas.setEnabled(false);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha Inválidos!");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LblBenVindo = new javax.swing.JLabel();
        LblSeusDados = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        LblSenha = new javax.swing.JLabel();
        PasSenha = new javax.swing.JPasswordField();
        BtnLogar = new javax.swing.JButton();
        LblLogoNormal = new javax.swing.JLabel();

        setTitle("Login.");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(220, 199, 170));

        jPanel3.setBackground(new java.awt.Color(6, 47, 79));

        LblBenVindo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        LblBenVindo.setForeground(new java.awt.Color(255, 255, 255));
        LblBenVindo.setText("Seja bem-vindo!!");

        LblSeusDados.setForeground(new java.awt.Color(255, 255, 255));
        LblSeusDados.setText("Entre com os seus dados, para fazer login.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(LblSeusDados))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(LblBenVindo)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblBenVindo, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblSeusDados)
                .addContainerGap())
        );

        LblUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LblUsuario.setForeground(new java.awt.Color(6, 47, 79));
        LblUsuario.setText("Usuário");

        TxtUsuario.setBackground(new java.awt.Color(231, 223, 221));
        TxtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        TxtUsuario.setToolTipText("Campo usuário.");

        LblSenha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LblSenha.setForeground(new java.awt.Color(6, 47, 79));
        LblSenha.setText("Senha");

        PasSenha.setBackground(new java.awt.Color(231, 223, 221));
        PasSenha.setForeground(new java.awt.Color(0, 0, 0));
        PasSenha.setToolTipText("Campo senha.");
        PasSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasSenhaActionPerformed(evt);
            }
        });

        BtnLogar.setBackground(new java.awt.Color(247, 195, 49));
        BtnLogar.setForeground(new java.awt.Color(0, 0, 0));
        BtnLogar.setText("Logar");
        BtnLogar.setToolTipText("Clique aqui para fazer o login.");
        BtnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogarActionPerformed(evt);
            }
        });

        LblLogoNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoAzul.png"))); // NOI18N
        LblLogoNormal.setToolTipText("Logomarca.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LblLogoNormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnLogar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PasSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblSenha)
                        .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(LblUsuario)
                .addGap(18, 18, 18)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(LblSenha)
                .addGap(18, 18, 18)
                .addComponent(PasSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLogar)
                    .addComponent(LblLogoNormal))
                .addGap(0, 20, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(304, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PasSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasSenhaActionPerformed

    }//GEN-LAST:event_PasSenhaActionPerformed

    private void BtnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogarActionPerformed
        Logar();
    }//GEN-LAST:event_BtnLogarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnLogar;
    javax.swing.JLabel LblBenVindo;
    javax.swing.JLabel LblLogoNormal;
    javax.swing.JLabel LblSenha;
    javax.swing.JLabel LblSeusDados;
    javax.swing.JLabel LblUsuario;
    javax.swing.JPasswordField PasSenha;
    javax.swing.JTextField TxtUsuario;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
