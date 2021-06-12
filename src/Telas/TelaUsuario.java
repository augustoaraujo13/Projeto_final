package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class TelaUsuario extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
        formatarCpf();
        formatarTelefone();
    }

    //Metodo para formatar campo CPF
    private void formatarCpf() {
        try {
            MaskFormatter ms = new MaskFormatter("###.###.###-##");
            ms.install(ForCpf);
        } catch (ParseException e) {
        }

    }

    //Metodo para formatar campo Telefone
    private void formatarTelefone() {
        try {
            MaskFormatter ms = new MaskFormatter("##-#-####-####");
            ms.install(ForTelefone);
        } catch (ParseException e) {
        }

    }

    //Esse metodo cria um novo usuário
    private void Criar() {
        String criando = "insert into usuarios(usuario, cargo, email, CPF, telefone, login, senha)"
                + "values(?,?,?,?,?,?,?);";
        String comcluido = "O usuário foi cadastrado!";

        try {
            st = conn.prepareStatement(criando);
            st.setString(1, TxtUsuario.getText().trim());
            st.setString(2, CbCargo.getSelectedItem().toString());
            st.setString(3, ForCpf.getText().trim());
            st.setString(4, TxtEmail.getText().trim());
            st.setString(5, ForTelefone.getText().trim());
            st.setString(6, TxtLogin.getText().trim());
            st.setString(7, TxtSenha.getText().trim());

            if ((TxtUsuario.getText().isEmpty())
                    || (TxtLogin.getText().isEmpty())
                    || (TxtSenha.getText().isEmpty())
                    || (TxtEmail.getText().isEmpty())) {

                String informacao2 = "Preencha os campos obrigatórios!";
                JOptionPane.showMessageDialog(this, informacao2);

            } else {
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, comcluido);

                CbCargo.setSelectedItem(null);
                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                ForCpf.setText(null);
                TxtEmail.setText(null);
                ForTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            // System.out.println(e);
            TxtId.setText(null);
            TxtUsuario.setText(null);
            CbCargo.setSelectedItem(null);
            ForCpf.setText(null);
            TxtEmail.setText(null);
            ForTelefone.setText(null);
            TxtLogin.setText(null);
            TxtSenha.setText(null);
        }

    }

    //Esse metodo busca um usuário.
    private void Buscar() {
        String mensagem = "Informe o Id do usuário.";
        String idRecebido = JOptionPane.showInputDialog(mensagem);
        String busca = "select * from usuarios where id_user =" +idRecebido+ " ;";

        try {
            st = conn.prepareStatement(busca);
            rs = st.executeQuery();

            if (rs.next()) {
                TxtId.setText(rs.getString(1));
                TxtUsuario.setText(rs.getString(2));
                CbCargo.setSelectedItem(rs.getString(3));
                TxtEmail.setText(rs.getString(4));
                ForCpf.setText(rs.getString(5));
                ForTelefone.setText(rs.getString(6));
                TxtLogin.setText(rs.getString(7));
                TxtSenha.setText(rs.getString(8));
                BtnCriar.setEnabled(false);
            } else {
                String resposta = "O usuário que você pesquisou não existe.";
                JOptionPane.showMessageDialog(this, resposta);

                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                ForCpf.setText(null);
                TxtEmail.setText(null);
                ForTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);
                BtnCriar.setEnabled(true);
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Id Inválido!");
            //System.out.println(e);
            TxtId.setText(null);
            TxtUsuario.setText(null);
            ForCpf.setText(null);
            TxtLogin.setText(null);
            TxtSenha.setText(null);
            CbCargo.setSelectedItem(null);
            BtnCriar.setEnabled(true);
        }

    }

    //Metedo altera dados do usuário
    private void Alterar() {
        String alterando = "update usuarios set usuario =?, cargo =?, email =?, CPF =?,"
                + "telefone =?, login =?, senha =? where id_user =?;";

        try {
            st = conn.prepareStatement(alterando);
            st.setString(1, TxtUsuario.getText().trim());
            st.setString(2, CbCargo.getSelectedItem().toString());
            st.setString(3, TxtEmail.getText().trim());
            st.setString(4, ForCpf.getText().trim());
            st.setString(5, ForTelefone.getText().trim());
            st.setString(6, TxtLogin.getText().trim());
            st.setString(7, TxtSenha.getText().trim());
            st.setString(8, TxtId.getText().trim());

            if ((TxtUsuario.getText().isEmpty())
                    || (TxtLogin.getText().isEmpty())
                    || (TxtSenha.getText().isEmpty())
                    || (TxtEmail.getText().isEmpty())) {
                String informacao2 = "Preencha os campos obrigatórios!!!!";
                JOptionPane.showMessageDialog(this, informacao2);
            } else {
                String comcluido = "Dados do usuário foram alterados com sucesso!";
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, comcluido);
                BtnCriar.setEnabled(true);

                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                ForCpf.setText(null);
                TxtEmail.setText(null);
                ForTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            ///System.out.println(e);
            TxtId.setText(null);
            TxtUsuario.setText(null);
            CbCargo.setSelectedItem(null);
            ForCpf.setText(null);
            TxtEmail.setText(null);
            ForTelefone.setText(null);
            TxtLogin.setText(null);
            TxtSenha.setText(null);
        }

    }

    //Esse Metodo deleta o usuário.
    private void Deletar() {
        String confirmando = "Deseja deletar esse usuário?";
        String confirmando2 = "Atenção";
        int confirmar = JOptionPane.showConfirmDialog(null, confirmando, confirmando2, JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            String deletando = "delete from usuarios where id_user=?;";

            try {
                st = conn.prepareStatement(deletando);
                st.setString(1, TxtId.getText().trim());

                if (TxtId.getText().isEmpty()) {
                    String informacao = "Preencha o campo Id, para excluir usuario!";
                    JOptionPane.showMessageDialog(this, informacao);
                } else {
                    String comcluido = "Usuário foi excluído com sucesso!";
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, comcluido);

                    BtnCriar.setEnabled(true);
                    TxtId.setText(null);
                    TxtUsuario.setText(null);
                    CbCargo.setSelectedItem(null);
                    ForCpf.setText(null);
                    TxtEmail.setText(null);
                    ForTelefone.setText(null);
                    TxtLogin.setText(null);
                    TxtSenha.setText(null);
                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                ///System.out.println(e);
                TxtId.setText(null);
                TxtUsuario.setText(null);
                CbCargo.setSelectedItem(null);
                ForCpf.setText(null);
                TxtEmail.setText(null);
                ForTelefone.setText(null);
                TxtLogin.setText(null);
                TxtSenha.setText(null);
            }

        } else {
            JOptionPane.showMessageDialog(null, "O usuário não foi excluído.");
            TxtId.setText(null);
            TxtUsuario.setText(null);
            CbCargo.setSelectedItem(null);
            ForCpf.setText(null);
            TxtEmail.setText(null);
            ForTelefone.setText(null);
            TxtLogin.setText(null);
            TxtSenha.setText(null);
        }
    }

    //Esse metedo limpa todos os campos.
    private void Limpar() {
        String comcluido = "Os campos foram limpos!!";
        JOptionPane.showMessageDialog(this, comcluido);

        BtnCriar.setEnabled(true);
        TxtId.setText(null);
        TxtUsuario.setText(null);
        CbCargo.setSelectedItem(null);
        ForCpf.setText(null);
        TxtEmail.setText(null);
        ForTelefone.setText(null);
        TxtLogin.setText(null);
        TxtSenha.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelUsuarioInterno = new javax.swing.JPanel();
        LblNomeUsuario = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CbCargo = new javax.swing.JComboBox<>();
        LblCpf = new javax.swing.JLabel();
        LblEmail = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        LblTelefone = new javax.swing.JLabel();
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
        ForTelefone = new javax.swing.JFormattedTextField();
        ForCpf = new javax.swing.JFormattedTextField();
        LogoBranco = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela de usuários.");

        PainelUsuarioInterno.setBackground(new java.awt.Color(6, 47, 79));

        LblNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LblNomeUsuario.setText("Nome *");

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

        LblCpf.setForeground(new java.awt.Color(255, 255, 255));
        LblCpf.setText("CPF");

        LblEmail.setForeground(new java.awt.Color(255, 255, 255));
        LblEmail.setText("Email *");

        TxtEmail.setBackground(new java.awt.Color(231, 223, 221));
        TxtEmail.setForeground(new java.awt.Color(0, 0, 0));

        LblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefone.setText("Telefone");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha *");

        BtnCriar.setBackground(new java.awt.Color(0, 204, 0));
        BtnCriar.setForeground(new java.awt.Color(0, 0, 0));
        BtnCriar.setText("Criar");
        BtnCriar.setToolTipText("Cadastra um novo usuário.");
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
        LblLogin.setText("Login *");

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
        BtnBuscar.setToolTipText("Busca um usuário.");
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
        LblCamposObrigatorios.setText("Campos obrigatórios *");

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

        ForTelefone.setBackground(new java.awt.Color(231, 223, 221));
        ForTelefone.setForeground(new java.awt.Color(0, 0, 0));

        ForCpf.setBackground(new java.awt.Color(231, 223, 221));
        ForCpf.setForeground(new java.awt.Color(0, 0, 0));

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        javax.swing.GroupLayout PainelUsuarioInternoLayout = new javax.swing.GroupLayout(PainelUsuarioInterno);
        PainelUsuarioInterno.setLayout(PainelUsuarioInternoLayout);
        PainelUsuarioInternoLayout.setHorizontalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblNomeUsuario)
                    .addComponent(LblCpf)
                    .addComponent(LblEmail)
                    .addComponent(LblLogin))
                .addGap(26, 26, 26)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(TxtEmail)
                            .addComponent(TxtLogin)
                            .addComponent(ForCpf))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblTelefone)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbCargo, 0, 150, Short.MAX_VALUE)
                            .addComponent(TxtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(ForTelefone)))
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                                .addComponent(BtnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblCamposObrigatorios))
                        .addGap(18, 18, 18)
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                                .addComponent(BtnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDeletar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnLimpar))
                            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                .addComponent(LogoBranco)))))
                .addGap(20, 20, 20))
        );
        PainelUsuarioInternoLayout.setVerticalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNomeUsuario)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCpf)
                    .addComponent(CbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ForCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEmail)
                    .addComponent(LblTelefone)
                    .addComponent(ForTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblCamposObrigatorios)
                        .addComponent(jLabel2))
                    .addComponent(LogoBranco))
                .addContainerGap(22, Short.MAX_VALUE))
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
        Limpar();
    }//GEN-LAST:event_BtnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAlterar;
    javax.swing.JButton BtnBuscar;
    javax.swing.JButton BtnCriar;
    javax.swing.JButton BtnDeletar;
    javax.swing.JButton BtnLimpar;
    javax.swing.JComboBox<String> CbCargo;
    javax.swing.JFormattedTextField ForCpf;
    javax.swing.JFormattedTextField ForTelefone;
    javax.swing.JLabel LblCamposObrigatorios;
    javax.swing.JLabel LblCpf;
    javax.swing.JLabel LblEmail;
    javax.swing.JLabel LblLogin;
    javax.swing.JLabel LblNomeUsuario;
    javax.swing.JLabel LblTelefone;
    javax.swing.JLabel LogoBranco;
    javax.swing.JPanel PainelUsuarioInterno;
    javax.swing.JTextField TxtEmail;
    javax.swing.JTextField TxtId;
    javax.swing.JTextField TxtLogin;
    javax.swing.JTextField TxtSenha;
    javax.swing.JTextField TxtUsuario;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
