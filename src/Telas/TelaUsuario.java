package Telas;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    private void Criar() {

        String criando = "insert into usuarios(usuario, cargo, email, CPF, telefone, login, senha)"
                + "values(?,?,?,?,?,?,?);";
        String comcluido = "Novo usuário cadastrado!";

        try {

            st = conn.prepareStatement(criando);

            st.setString(1, TxtUsuario.getText().trim());
            st.setString(2, CbCargo.getSelectedItem().toString());
            st.setString(3, TxtEmail.getText().trim());
            st.setString(4, TxtCpf.getText().trim());
            st.setString(5, TxtTelefone.getText().trim());
            st.setString(6, TxtLogin.getText().trim());
            st.setString(7, TxtSenha.getText().trim());

            if ((TxtUsuario.getText().isEmpty())
                    || (TxtLogin.getText().isEmpty()) || (TxtSenha.getText().isEmpty())) {

                String informacao2 = "Preencha os campos obrigatórios!!!!";
                JOptionPane.showMessageDialog(this, informacao2);

            } else {
                st.executeUpdate();

                JOptionPane.showMessageDialog(this, comcluido);
                TxtId.setText(null);
                TxtUsuario.setText(null);
                TxtEmail.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);
                CbCargo.setSelectedItem(null);
            }

        } catch (SQLException e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelUsuarioInterno = new javax.swing.JPanel();
        LblUsuario = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CbCargo = new javax.swing.JComboBox<>();
        LblCamposObrigatorios = new javax.swing.JLabel();
        LblEmail = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        LblCpf = new javax.swing.JLabel();
        TxtCpf = new javax.swing.JTextField();
        LblTelefone = new javax.swing.JLabel();
        TxtTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        BtnCriar = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();
        BtnDeletar = new javax.swing.JButton();
        LblLogin = new javax.swing.JLabel();
        TxtLogin = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        TxtSenha = new javax.swing.JTextField();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de usuários");

        PainelUsuarioInterno.setBackground(new java.awt.Color(6, 47, 79));

        LblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LblUsuario.setText("Usuário *");

        TxtUsuario.setBackground(new java.awt.Color(231, 223, 221));
        TxtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cargo *");

        CbCargo.setBackground(new java.awt.Color(204, 0, 204));
        CbCargo.setForeground(new java.awt.Color(0, 0, 0));
        CbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coordenador", "Secretário", "Professor" }));
        CbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbCargoActionPerformed(evt);
            }
        });

        LblCamposObrigatorios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblCamposObrigatorios.setForeground(new java.awt.Color(255, 255, 255));
        LblCamposObrigatorios.setText("Campos obrigatórios*");

        LblEmail.setForeground(new java.awt.Color(255, 255, 255));
        LblEmail.setText("Email ");

        TxtEmail.setBackground(new java.awt.Color(231, 223, 221));
        TxtEmail.setForeground(new java.awt.Color(0, 0, 0));

        LblCpf.setForeground(new java.awt.Color(255, 255, 255));
        LblCpf.setText("CPF");

        TxtCpf.setBackground(new java.awt.Color(231, 223, 221));
        TxtCpf.setForeground(new java.awt.Color(0, 0, 0));

        LblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefone.setText("Telefone");

        TxtTelefone.setBackground(new java.awt.Color(231, 223, 221));
        TxtTelefone.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha*");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");

        TxtId.setEditable(false);
        TxtId.setBackground(new java.awt.Color(231, 223, 221));
        TxtId.setForeground(new java.awt.Color(0, 0, 0));

        BtnCriar.setBackground(new java.awt.Color(0, 204, 0));
        BtnCriar.setForeground(new java.awt.Color(0, 0, 0));
        BtnCriar.setText("Criar");
        BtnCriar.setToolTipText("Cria um novo usuário");
        BtnCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCriarActionPerformed(evt);
            }
        });

        BtnAlterar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAlterar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAlterar.setText("Alterar");
        BtnAlterar.setToolTipText("Altera o usuário no banco de dados");
        BtnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });

        BtnDeletar.setBackground(new java.awt.Color(255, 0, 0));
        BtnDeletar.setForeground(new java.awt.Color(0, 0, 0));
        BtnDeletar.setText("Deletar");
        BtnDeletar.setToolTipText("Cuidado!! Deleta o usuário no banco de dados");
        BtnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarActionPerformed(evt);
            }
        });

        LblLogin.setForeground(new java.awt.Color(255, 255, 255));
        LblLogin.setText("Login*");

        TxtLogin.setBackground(new java.awt.Color(231, 223, 221));
        TxtLogin.setForeground(new java.awt.Color(0, 0, 0));
        TxtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLoginActionPerformed(evt);
            }
        });

        BtnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar.setText("Buscar");
        BtnBuscar.setToolTipText("Busca o usuário no banco de dados");
        BtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        TxtSenha.setBackground(new java.awt.Color(231, 223, 221));
        TxtSenha.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout PainelUsuarioInternoLayout = new javax.swing.GroupLayout(PainelUsuarioInterno);
        PainelUsuarioInterno.setLayout(PainelUsuarioInternoLayout);
        PainelUsuarioInternoLayout.setHorizontalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addComponent(BtnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDeletar))
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblUsuario)
                            .addComponent(jLabel1)
                            .addComponent(LblEmail)
                            .addComponent(LblCpf)
                            .addComponent(LblTelefone)
                            .addComponent(LblLogin)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtUsuario)
                            .addComponent(CbCargo, 0, 150, Short.MAX_VALUE)
                            .addComponent(TxtEmail)
                            .addComponent(TxtCpf)
                            .addComponent(TxtTelefone)
                            .addComponent(TxtLogin)
                            .addComponent(TxtSenha))
                        .addGap(80, 80, 80)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblCamposObrigatorios)
                            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PainelUsuarioInternoLayout.setVerticalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(LblCamposObrigatorios)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblUsuario)
                            .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblCpf))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblTelefone))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblLogin))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnBuscar)
                            .addComponent(BtnCriar)
                            .addComponent(BtnAlterar)
                            .addComponent(BtnDeletar))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelUsuarioInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelUsuarioInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed
        //Deletar();
    }//GEN-LAST:event_BtnDeletarActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
        //Alterar();
    }//GEN-LAST:event_BtnAlterarActionPerformed

    private void BtnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCriarActionPerformed
        Criar();
    }//GEN-LAST:event_BtnCriarActionPerformed

    private void CbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbCargoActionPerformed

    }//GEN-LAST:event_CbCargoActionPerformed

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        //Buscar();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TxtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAlterar;
    javax.swing.JButton BtnBuscar;
    javax.swing.JButton BtnCriar;
    javax.swing.JButton BtnDeletar;
    javax.swing.JComboBox<String> CbCargo;
    javax.swing.JLabel LblCamposObrigatorios;
    javax.swing.JLabel LblCpf;
    javax.swing.JLabel LblEmail;
    javax.swing.JLabel LblLogin;
    javax.swing.JLabel LblTelefone;
    javax.swing.JLabel LblUsuario;
    javax.swing.JPanel PainelUsuarioInterno;
    javax.swing.JTextField TxtCpf;
    javax.swing.JTextField TxtEmail;
    javax.swing.JTextField TxtId;
    javax.swing.JTextField TxtLogin;
    javax.swing.JTextField TxtSenha;
    javax.swing.JTextField TxtTelefone;
    javax.swing.JTextField TxtUsuario;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
