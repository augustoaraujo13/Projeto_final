/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

/**
 *
 * @author augus
 */
public class TelaUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaUsuario
     */
    public TelaUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jLabel2 = new javax.swing.JLabel();
        TxtTelefone = new javax.swing.JTextField();
        LblLogin = new javax.swing.JLabel();
        TxtLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PassSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cargo *");

        CbCargo.setBackground(new java.awt.Color(204, 51, 0));
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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Telefone");

        TxtTelefone.setBackground(new java.awt.Color(231, 223, 221));
        TxtTelefone.setForeground(new java.awt.Color(0, 0, 0));

        LblLogin.setForeground(new java.awt.Color(255, 255, 255));
        LblLogin.setText("Login *");

        TxtLogin.setBackground(new java.awt.Color(231, 223, 221));
        TxtLogin.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha*");

        PassSenha.setBackground(new java.awt.Color(231, 223, 221));
        PassSenha.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id");

        jTextField1.setBackground(new java.awt.Color(231, 223, 221));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout PainelUsuarioInternoLayout = new javax.swing.GroupLayout(PainelUsuarioInterno);
        PainelUsuarioInterno.setLayout(PainelUsuarioInternoLayout);
        PainelUsuarioInternoLayout.setHorizontalGroup(
            PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblUsuario)
                    .addComponent(jLabel1)
                    .addComponent(LblEmail)
                    .addComponent(jLabel2)
                    .addComponent(LblLogin)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(CbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtEmail)
                    .addComponent(TxtTelefone)
                    .addComponent(TxtLogin)
                    .addComponent(PassSenha))
                .addGap(67, 67, 67)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblCamposObrigatorios)
                    .addGroup(PainelUsuarioInternoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
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
                        .addContainerGap()
                        .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblUsuario))
                        .addGap(18, 18, 18)))
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEmail))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblLogin)
                    .addComponent(TxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelUsuarioInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PassSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(153, Short.MAX_VALUE))
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

    private void CbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JComboBox<String> CbCargo;
    javax.swing.JLabel LblCamposObrigatorios;
    javax.swing.JLabel LblEmail;
    javax.swing.JLabel LblLogin;
    javax.swing.JLabel LblUsuario;
    javax.swing.JPanel PainelUsuarioInterno;
    javax.swing.JPasswordField PassSenha;
    javax.swing.JTextField TxtEmail;
    javax.swing.JTextField TxtLogin;
    javax.swing.JTextField TxtTelefone;
    javax.swing.JTextField TxtUsuario;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
