package Telas;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class TelaBuscarTurmas extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaBuscarTurmas() {
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Painel de buscar turmas");
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
        jScrollPane1.setViewportView(TabTurmas);

        BtnBuscar2.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscar2.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar2.setText("Buscar");
        BtnBuscar2.setToolTipText("Busca o usuário.");
        BtnBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar2ActionPerformed(evt);
            }
        });

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas aluno e usuario não são turmas!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LogoBranco)
                                .addGap(148, 148, 148)
                                .addComponent(BtnBuscar2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogoBranco)
                    .addComponent(BtnBuscar2))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnBuscar2;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabTurmas;
    javax.swing.JLabel jLabel1;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
