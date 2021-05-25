package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
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

            if ((TxtUsuario.getText().isEmpty()) || (TxtEmail.getText().isEmpty())
                    || (TxtLogin.getText().isEmpty()) || (TxtSenha.getText().isEmpty())) {

                String informacao2 = "Preencha os campos obrigatórios!";
                JOptionPane.showMessageDialog(this, informacao2);

            } else {
                st.executeUpdate();

                JOptionPane.showMessageDialog(this, comcluido);

                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                TxtEmail.setText(null);
                TxtCpf.setText(null);
                TxtTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);

            }

        } catch (SQLException e) {
        }

    }

    private void Buscar() {

        String mensagem = "Informe Id do usuário.";
        String idRecebido = JOptionPane.showInputDialog(mensagem);
        String busca = "select * from usuarios where id_user =" + idRecebido;

        try {

            st = conn.prepareStatement(busca);
            rs = st.executeQuery();

            if (rs.next()) {

                TxtId.setText(rs.getString(1));
                TxtUsuario.setText(rs.getString(2));
                CbCargo.setSelectedItem(rs.getString(3));
                TxtEmail.setText(rs.getString(4));
                TxtCpf.setText(rs.getString(5));
                TxtTelefone.setText(rs.getString(6));
                TxtLogin.setText(rs.getString(7));
                TxtSenha.setText(rs.getString(8));
                BtnCriar.setEnabled(false);

            } else {
                String resposta = "O usuario que você pesquisou não existe.";

                JOptionPane.showMessageDialog(this, resposta);

                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                TxtEmail.setText(null);
                TxtCpf.setText(null);
                TxtTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);

            }

        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(this, "OS Inválida!");
            // System.out.println(e);

            TxtId.setText(null);
            TxtUsuario.setText(null);
            TxtEmail.setText(null);
            TxtLogin.setText(null);
            TxtSenha.setText(null);
            CbCargo.setSelectedItem(null);

        }

    }

    private void Alterar() {

        String alterando = "update usuarios set usuario =?, cargo =?, email =?, CPF =?,"
                + "telefone =?, login =?, senha =? where id_user =?;";

        try {
            st = conn.prepareStatement(alterando);

            st.setString(1, TxtUsuario.getText().trim());
            st.setString(2, CbCargo.getSelectedItem().toString());
            st.setString(3, TxtEmail.getText().trim());
            st.setString(4, TxtCpf.getText().trim());
            st.setString(5, TxtTelefone.getText().trim());
            st.setString(6, TxtLogin.getText().trim());
            st.setString(7, TxtSenha.getText().trim());
            st.setString(8, TxtId.getText().trim());

            if ((TxtUsuario.getText().isEmpty()) || (TxtEmail.getText().isEmpty())
                    || (TxtLogin.getText().isEmpty()) || (TxtSenha.getText().isEmpty())) {

                String informacao2 = "Preencha os campos obrigatórios!!!!";
                JOptionPane.showMessageDialog(this, informacao2);

            } else {
                String comcluido = "Dados alterados com sucesso!";

                st.executeUpdate();

                JOptionPane.showMessageDialog(this, comcluido);

                BtnCriar.setEnabled(true);

                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                TxtEmail.setText(null);
                TxtCpf.setText(null);
                TxtTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            ///System.out.println(e);
        }

    }

    private void Deletar() {

        String confirmando = "Deseja deletar esse usuário?";
        String confirmando2 = "Atenção";

        int confirmar = JOptionPane.showConfirmDialog(null, confirmando, confirmando, JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {

            String deletando = "delete from usuarios where id_user=?;";

            try {

                st = conn.prepareStatement(deletando);
                st.setString(1, TxtId.getText().trim());

                if (TxtId.getText().isEmpty()) {

                    String informacao = "Preencha o campo Id, para excluir usuario!";
                    JOptionPane.showMessageDialog(this, informacao);

                } else {

                    String comcluido = "Usuário excluído com sucesso!";

                    st.executeUpdate();

                    JOptionPane.showMessageDialog(this, comcluido);

                    BtnCriar.setEnabled(true);

                    TxtId.setText(null);
                    TxtUsuario.setText(null);
                    CbCargo.setSelectedItem(null);
                    TxtEmail.setText(null);
                    TxtCpf.setText(null);
                    TxtTelefone.setText(null);
                    TxtLogin.setText(null);
                    TxtSenha.setText(null);

                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                ///System.out.println(e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente");
        }
    }

    private void limpar() {

        String comcluido = "Os campos foram limpos!!";

        JOptionPane.showMessageDialog(this, comcluido);

        BtnCriar.setEnabled(true);

        TxtId.setText(null);
        TxtUsuario.setText(null);
        CbCargo.setSelectedItem(null);
        TxtEmail.setText(null);
        TxtCpf.setText(null);
        TxtTelefone.setText(null);
        TxtLogin.setText(null);
        TxtSenha.setText(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelUsuarioInterno = new javax.swing.JPanel();
        LblUsuario = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CbCargo = new javax.swing.JComboBox<>();
        LblEmail = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        LblCpf = new javax.swing.JLabel();
        TxtCpf = new javax.swing.JTextField();
        LblTelefone = new javax.swing.JLabel();
        TxtTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BtnCriar = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();
        BtnDeletar = new javax.swing.JButton();
        LblLogin = new javax.swing.JLabel();
        TxtLogin = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        TxtSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        LblCamposObrigatorios = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnLimpar = new javax.swing.JButton();

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

        LblEmail.setForeground(new java.awt.Color(255, 255, 255));
        LblEmail.setText("Email * ");

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

        BtnAlterar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAlterar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAlterar.setText("Alterar");
        BtnAlterar.setToolTipText("Altera os dados do usuário.");
        BtnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });

        BtnDeletar.setBackground(new java.awt.Color(255, 0, 0));
        BtnDeletar.setForeground(new java.awt.Color(0, 0, 0));
        BtnDeletar.setText("Deletar");
        BtnDeletar.setToolTipText("Cuidado!! Deleta o usuário.");
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
        BtnBuscar.setToolTipText("Busca o usuário.");
        BtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        TxtSenha.setBackground(new java.awt.Color(231, 223, 221));
        TxtSenha.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id #");

        TxtId.setEditable(false);
        TxtId.setBackground(new java.awt.Color(231, 223, 221));
        TxtId.setForeground(new java.awt.Color(0, 0, 0));

        LblCamposObrigatorios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblCamposObrigatorios.setForeground(new java.awt.Color(255, 255, 255));
        LblCamposObrigatorios.setText("Campos obrigatórios*");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Campos automáticos #");

        BtnLimpar.setBackground(new java.awt.Color(204, 0, 204));
        BtnLimpar.setForeground(new java.awt.Color(0, 0, 0));
        BtnLimpar.setText("Limpar");
        BtnLimpar.setToolTipText("Limpa os campos.");
        BtnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelUsuarioInternoLayout = new javax.swing.GroupLayout(PainelUsuarioInterno);
        PainelUsuarioInterno.setLayout(PainelUsuarioInternoLayout);
        PainelUsuarioInternoLayout.setHorizontalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblUsuario)
                    .addComponent(LblEmail)
                    .addComponent(LblCpf)
                    .addComponent(LblLogin))
                .addGap(26, 26, 26)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(TxtEmail)
                            .addComponent(TxtCpf)
                            .addComponent(TxtLogin))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblTelefone)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                                .addComponent(BtnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblCamposObrigatorios))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                                .addComponent(BtnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDeletar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnLimpar)))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        PainelUsuarioInternoLayout.setVerticalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblUsuario)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEmail)
                    .addComponent(CbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblCpf)
                    .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTelefone))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblLogin)
                    .addComponent(jLabel3)
                    .addComponent(TxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscar)
                    .addComponent(BtnCriar)
                    .addComponent(BtnAlterar)
                    .addComponent(BtnDeletar)
                    .addComponent(BtnLimpar))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCamposObrigatorios)
                    .addComponent(jLabel2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelUsuarioInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelUsuarioInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed
        Deletar();
    }//GEN-LAST:event_BtnDeletarActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
        Alterar();
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
        Buscar();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void TxtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLoginActionPerformed

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_BtnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAlterar;
    javax.swing.JButton BtnBuscar;
    javax.swing.JButton BtnCriar;
    javax.swing.JButton BtnDeletar;
    javax.swing.JButton BtnLimpar;
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
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}