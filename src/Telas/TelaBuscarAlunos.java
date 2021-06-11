package Telas;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaBuscarAlunos extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaBuscarAlunos() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    private void Buscar() {

        String pesquisa = "select matricula, situacao,"
                + " nome, email, telefone from alunos "
                + "order by matricula;";
        try {
            st = conn.prepareStatement(pesquisa);
            rs = st.executeQuery();
            TabAlunos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Houve um erro");
            //System.out.println(e);
        }
    }

    private void Mostrar() {

        int setar = TabAlunos.getSelectedRow();

        try {
            TxtMatricula.setText(TabAlunos.getModel().getValueAt(setar, 0).toString().trim());
            TxtSituacao.setText(TabAlunos.getModel().getValueAt(setar, 1).toString().trim());
            TxtNome.setText(TabAlunos.getModel().getValueAt(setar, 2).toString().trim());
            TxtEmail.setText(TabAlunos.getModel().getValueAt(setar, 3).toString().trim());
            TxtTelefone.setText(TabAlunos.getModel().getValueAt(setar, 4).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

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
        LblSituacao = new javax.swing.JLabel();
        TxtSituacao = new javax.swing.JTextField();
        LblNome = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        LblTelefone = new javax.swing.JLabel();
        TxtTelefone = new javax.swing.JTextField();
        LblEmail = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        LogoBranco = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Buscar alunos.");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(6, 47, 79));
        jPanel1.setToolTipText("Painel buscar alunos");

        TabAlunos.setForeground(new java.awt.Color(0, 0, 0));
        TabAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Situação", "Nome", "Telefone", " Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
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

        BtnBuscar4.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscar4.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar4.setText("Buscar");
        BtnBuscar4.setToolTipText("Busca os alunos.");
        BtnBuscar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar4ActionPerformed(evt);
            }
        });

        LblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        LblMatricula.setText("Matricula");

        TxtMatricula.setBackground(new java.awt.Color(231, 223, 221));

        LblSituacao.setForeground(new java.awt.Color(255, 255, 255));
        LblSituacao.setText("Situação");

        TxtSituacao.setBackground(new java.awt.Color(231, 223, 221));

        LblNome.setForeground(new java.awt.Color(255, 255, 255));
        LblNome.setText("Nome");

        TxtNome.setBackground(new java.awt.Color(231, 223, 221));

        LblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefone.setText("Telefone");

        TxtTelefone.setBackground(new java.awt.Color(231, 223, 221));

        LblEmail.setForeground(new java.awt.Color(255, 255, 255));
        LblEmail.setText("Email");

        TxtEmail.setBackground(new java.awt.Color(231, 223, 221));

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnBuscar4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblMatricula)
                            .addComponent(LblNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(LblSituacao)
                                .addGap(18, 18, 18)
                                .addComponent(TxtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblTelefone)
                                    .addComponent(LblEmail))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))))
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoBranco)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnBuscar4)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblMatricula)
                    .addComponent(LblSituacao)
                    .addComponent(TxtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTelefone)
                    .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNome)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEmail)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LogoBranco)
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void BtnBuscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscar4ActionPerformed
        Buscar();
    }//GEN-LAST:event_BtnBuscar4ActionPerformed

    private void TabAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabAlunosMouseClicked
        Mostrar();
    }//GEN-LAST:event_TabAlunosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnBuscar4;
    javax.swing.JLabel LblEmail;
    javax.swing.JLabel LblMatricula;
    javax.swing.JLabel LblNome;
    javax.swing.JLabel LblSituacao;
    javax.swing.JLabel LblTelefone;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabAlunos;
    javax.swing.JTextField TxtEmail;
    javax.swing.JTextField TxtMatricula;
    javax.swing.JTextField TxtNome;
    javax.swing.JTextField TxtSituacao;
    javax.swing.JTextField TxtTelefone;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
