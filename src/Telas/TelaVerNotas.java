package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaVerNotas extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaVerNotas() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
    }

    //Esse metodo busca todas as tabelas do banco.
    private void Buscar() {
        String pesquisa = "show tables from projeto_final;";

        try {
            st = conn.prepareStatement(pesquisa);
            rs = st.executeQuery();
            TabTurmas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            //System.out.println(e);
        }

    }

    //Esse metodo inseri uma turma no TxtNomeDaTurma.
    private void MostrarTurma() {
        int setar = TabTurmas.getSelectedRow();

        try {
            TxtNomeDaTurma.setText(TabTurmas.getModel().getValueAt(setar, 0).toString().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Campo vazio.");
            //System.out.println(e);
        }

    }

    // Esse metedo mostra todos os dados da tabela.
    private void Dados() {

        try {
            String turma = TxtNomeDaTurma.getText().trim();
            String dados = "select Id_aluno as Id, nota_bimestre1 as 1°Bimestre,"
                    + " nota_bimestre2 as 2°Bimestre, situacao as Situação"
                    + " from " + turma + ";";
            st = conn.prepareStatement(dados);

            if ("usuarios".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                TxtNomeDaTurma.setText(null);
            } else if ("alunos".equals(turma)) {
                JOptionPane.showMessageDialog(this, "O que você escolheu não é uma turma.");
                TxtNomeDaTurma.setText(null);
            } else {
                if (turma.isEmpty()) {
                    String informacao2 = "Selecione uma turma.";
                    JOptionPane.showMessageDialog(this, informacao2);
                } else {
                    String comcluido = "Sua busca foi realizada.";
                    rs = st.executeQuery();
                    JOptionPane.showMessageDialog(this, comcluido);
                    //TabAlunoDaTurma.setModel(DbUtils.resultSetToTableModel(rs));
                    TabAlunoDaTurma.setModel((DbUtils.resultSetToTableModel(rs)));
                }

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
            //System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabTurmas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        BtnBuscar2 = new javax.swing.JButton();
        LogoBranco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabAlunoDaTurma = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        jLabel2 = new javax.swing.JLabel();
        TxtNomeDaTurma = new javax.swing.JTextField();
        BtnBuscarDados = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver notas");
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
                "Turmas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabTurmas.setFocusable(false);
        TabTurmas.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabTurmas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabTurmas.getTableHeader().setResizingAllowed(false);
        TabTurmas.getTableHeader().setReorderingAllowed(false);
        TabTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabTurmas);
        if (TabTurmas.getColumnModel().getColumnCount() > 0) {
            TabTurmas.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnBuscar2.setBackground(new java.awt.Color(0, 255, 204));
        BtnBuscar2.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar2.setText("Turmas");
        BtnBuscar2.setToolTipText("Busca as turmas.");
        BtnBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscar2ActionPerformed(evt);
            }
        });

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tabelas alunos e usuario não são turmas!");

        TabAlunoDaTurma.setForeground(new java.awt.Color(0, 0, 0));
        TabAlunoDaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "1°Bimestre", "2°Bimestre", "Situação"
            }
        ));
        TabAlunoDaTurma.setFocusable(false);
        TabAlunoDaTurma.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabAlunoDaTurma.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabAlunoDaTurma.getTableHeader().setResizingAllowed(false);
        TabAlunoDaTurma.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TabAlunoDaTurma);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da turma");

        TxtNomeDaTurma.setEditable(false);
        TxtNomeDaTurma.setBackground(new java.awt.Color(231, 223, 221));
        TxtNomeDaTurma.setForeground(new java.awt.Color(0, 0, 0));

        BtnBuscarDados.setBackground(new java.awt.Color(255, 255, 0));
        BtnBuscarDados.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarDados.setText("Alunos");
        BtnBuscarDados.setToolTipText("Mostra os aluno da turma.");
        BtnBuscarDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(BtnBuscarDados)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoBranco))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(BtnBuscar2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogoBranco)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnBuscar2)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnBuscarDados)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(TxtNomeDaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void BtnBuscarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarDadosActionPerformed
        Dados();
    }//GEN-LAST:event_BtnBuscarDadosActionPerformed

    private void TabTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabTurmasMouseClicked
        MostrarTurma();
    }//GEN-LAST:event_TabTurmasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnBuscar2;
    javax.swing.JButton BtnBuscarDados;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabAlunoDaTurma;
    javax.swing.JTable TabTurmas;
    javax.swing.JTextField TxtNomeDaTurma;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
