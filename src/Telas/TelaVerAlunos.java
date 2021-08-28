package Telas;

import Conexao.ConexaoBanco;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import net.proteanit.sql.DbUtils;

public class TelaVerAlunos extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaVerAlunos() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
        formatarNascimeto();
        formatarCpf();
        formatarTelefone();
    }

    //Metedo para formar campo
    private void formatarNascimeto() {
        try {
            MaskFormatter ms = new MaskFormatter("####/##/##");
            ms.install(ForNascimento);
        } catch (ParseException e) {
        }

    }

    //Metedo para formar campo
    private void formatarCpf() {
        try {
            MaskFormatter ms = new MaskFormatter("###.###.###-##");
            ms.install(ForCpfResposanvel);
            ms.install(ForCpf);
        } catch (ParseException e) {
        }

    }

    //Metedo para formar campo
    private void formatarTelefone() {
        try {
            MaskFormatter ms = new MaskFormatter("##-#####-####");
            ms.install(ForTelefone);
            ms.install(ForTelefoneResposanvel);
        } catch (ParseException e) {
        }

    }

    //Busca os alunos.
    private void BuscarAlunos() {
        try {
            String buscando = "select matricula as Matrícula, nome as Nome from alunos order by matricula;";
            st = conn.prepareStatement(buscando);
            String comcluido = "Sua busca foi realizada.";
            rs = st.executeQuery();
            JOptionPane.showMessageDialog(this, comcluido);
            TabAlunos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Campo vazio!");
            //System.out.println(e);
        }
    }

    //Mostra o aluno na tabela.
    private void Mostrar(){
    
         int setar = TabAlunos.getSelectedRow();
        try {
             String id = TabAlunos.getModel().getValueAt(setar, 0).toString().trim();
            String busca = "select * from alunos where matricula =" + id;

            st = conn.prepareStatement(busca);
            rs = st.executeQuery();

            if (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date dataBanco = rs.getDate(4);
                String dataRecebida = sdf.format(dataBanco);

                TxtMatricula.setText(rs.getString(1));
                TxtSituacao.setText(rs.getString(2));
                TxtNome.setText(rs.getString(3));
                ForNascimento.setText(dataRecebida);
                ForCpf.setText(rs.getString(5));
                TxtEmail.setText(rs.getString(6));
                ForTelefone.setText(rs.getString(7));
                TxtResposavel.setText(rs.getString(8));
                ForCpfResposanvel.setText(rs.getString(9));
                TxtEmailResposavel.setText(rs.getString(10));
                ForTelefoneResposanvel.setText(rs.getString(11));
                TxtEndereco.setText(rs.getString(12));
                
            } else {

            }

        } catch (SQLException e) {
        }
        
    }

    // Limpa os campos.
    private void Limpar() {
        String comcluido = "Os campos foram limpos.";
        JOptionPane.showMessageDialog(this, comcluido);

        TxtMatricula.setText(null);
        TxtSituacao.setText(null);
        TxtNome.setText(null);
        ForNascimento.setText(null);
        ForCpf.setText(null);
        TxtEmail.setText(null);
        ForTelefone.setText(null);
        TxtResposavel.setText(null);
        ForCpfResposanvel.setText(null);
        TxtEmailResposavel.setText(null);
        ForTelefoneResposanvel.setText(null);
        TxtEndereco.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblMatricula = new javax.swing.JLabel();
        TxtMatricula = new javax.swing.JTextField();
        LblSituacao = new javax.swing.JLabel();
        LblCpf = new javax.swing.JLabel();
        LblNascimento = new javax.swing.JLabel();
        LblEmail = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        LblNome = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        LblTelefone = new javax.swing.JLabel();
        LblResposavel = new javax.swing.JLabel();
        TxtResposavel = new javax.swing.JTextField();
        LblCpfResponsavel = new javax.swing.JLabel();
        LblTelefoneResponsavel = new javax.swing.JLabel();
        LblEmailResponsavel = new javax.swing.JLabel();
        TxtEmailResposavel = new javax.swing.JTextField();
        LblEndereco = new javax.swing.JLabel();
        TxtEndereco = new javax.swing.JTextField();
        BtnLimpar = new javax.swing.JButton();
        ForNascimento = new javax.swing.JFormattedTextField();
        ForCpfResposanvel = new javax.swing.JFormattedTextField();
        ForCpf = new javax.swing.JFormattedTextField();
        ForTelefone = new javax.swing.JFormattedTextField();
        ForTelefoneResposanvel = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabAlunos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        BtnBuscarAlunos = new javax.swing.JButton();
        LogoBranco = new javax.swing.JLabel();
        TxtSituacao = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver alunos");

        jPanel1.setBackground(new java.awt.Color(6, 47, 79));

        LblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        LblMatricula.setText("Matricula #");

        TxtMatricula.setEditable(false);
        TxtMatricula.setBackground(new java.awt.Color(231, 223, 221));
        TxtMatricula.setForeground(new java.awt.Color(0, 0, 0));

        LblSituacao.setForeground(new java.awt.Color(255, 255, 255));
        LblSituacao.setText("Situação *");

        LblCpf.setForeground(new java.awt.Color(255, 255, 255));
        LblCpf.setText("CPF *");

        LblNascimento.setForeground(new java.awt.Color(255, 255, 255));
        LblNascimento.setText("Nascimeto *");

        LblEmail.setForeground(new java.awt.Color(255, 255, 255));
        LblEmail.setText("Email *");

        TxtEmail.setEditable(false);
        TxtEmail.setBackground(new java.awt.Color(231, 223, 221));
        TxtEmail.setForeground(new java.awt.Color(0, 0, 0));

        LblNome.setForeground(new java.awt.Color(255, 255, 255));
        LblNome.setText("Nome *");

        TxtNome.setEditable(false);
        TxtNome.setBackground(new java.awt.Color(231, 223, 221));
        TxtNome.setForeground(new java.awt.Color(0, 0, 0));

        LblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefone.setText("Telefone");

        LblResposavel.setForeground(new java.awt.Color(255, 255, 255));
        LblResposavel.setText("Responsável ");

        TxtResposavel.setEditable(false);
        TxtResposavel.setBackground(new java.awt.Color(231, 223, 221));
        TxtResposavel.setForeground(new java.awt.Color(0, 0, 0));

        LblCpfResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        LblCpfResponsavel.setText("CPF Res ");

        LblTelefoneResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefoneResponsavel.setText("Telefone Res");

        LblEmailResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        LblEmailResponsavel.setText("Email Res ");

        TxtEmailResposavel.setEditable(false);
        TxtEmailResposavel.setBackground(new java.awt.Color(231, 223, 221));
        TxtEmailResposavel.setForeground(new java.awt.Color(0, 0, 0));

        LblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        LblEndereco.setText("Endereço *");

        TxtEndereco.setEditable(false);
        TxtEndereco.setBackground(new java.awt.Color(231, 223, 221));

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

        ForNascimento.setEditable(false);
        ForNascimento.setBackground(new java.awt.Color(231, 223, 221));
        ForNascimento.setForeground(new java.awt.Color(0, 0, 0));

        ForCpfResposanvel.setEditable(false);
        ForCpfResposanvel.setBackground(new java.awt.Color(231, 223, 221));
        ForCpfResposanvel.setForeground(new java.awt.Color(0, 0, 0));

        ForCpf.setEditable(false);
        ForCpf.setBackground(new java.awt.Color(231, 223, 221));
        ForCpf.setForeground(new java.awt.Color(0, 0, 0));

        ForTelefone.setEditable(false);
        ForTelefone.setBackground(new java.awt.Color(231, 223, 221));
        ForTelefone.setForeground(new java.awt.Color(0, 0, 0));

        ForTelefoneResposanvel.setEditable(false);
        ForTelefoneResposanvel.setBackground(new java.awt.Color(231, 223, 221));
        ForTelefoneResposanvel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText(" Área caso aluno seja menor de idade ");

        TabAlunos.setForeground(new java.awt.Color(0, 0, 0));
        TabAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Matrícula", "Nome "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabAlunos.setFocusable(false);
        TabAlunos.setSelectionBackground(new java.awt.Color(204, 0, 204));
        TabAlunos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TabAlunos.getTableHeader().setResizingAllowed(false);
        TabAlunos.getTableHeader().setReorderingAllowed(false);
        TabAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabAlunos);

        BtnBuscarAlunos.setBackground(new java.awt.Color(255, 255, 0));
        BtnBuscarAlunos.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarAlunos.setText("Alunos");
        BtnBuscarAlunos.setToolTipText("Busca o aluno");
        BtnBuscarAlunos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarAlunosActionPerformed(evt);
            }
        });

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        TxtSituacao.setEditable(false);
        TxtSituacao.setBackground(new java.awt.Color(231, 223, 221));
        TxtSituacao.setForeground(new java.awt.Color(0, 0, 0));
        TxtSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSituacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LblResposavel)
                                .addComponent(LblEmailResponsavel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblTelefoneResponsavel)))
                            .addComponent(LblNome)
                            .addComponent(LblTelefone)
                            .addComponent(LblMatricula))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblNascimento)
                                            .addComponent(LblSituacao))
                                        .addGap(18, 19, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ForNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                            .addComponent(TxtSituacao))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblEmail)
                                            .addComponent(LblCpf))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                            .addComponent(ForCpf))
                                        .addContainerGap(54, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LblEndereco)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ForTelefoneResposanvel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ForTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TxtEmailResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ForCpfResposanvel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TxtResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BtnLimpar)
                                                .addGap(126, 126, 126)
                                                .addComponent(BtnBuscarAlunos)
                                                .addGap(56, 56, 56))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoBranco)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblMatricula)
                            .addComponent(LblSituacao)
                            .addComponent(LblCpf)
                            .addComponent(ForCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtSituacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblEmail)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblNascimento)
                        .addComponent(ForNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTelefone)
                    .addComponent(LblEndereco)
                    .addComponent(TxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ForTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblResposavel)
                            .addComponent(TxtResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblEmailResponsavel)
                            .addComponent(TxtEmailResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblCpfResponsavel)
                            .addComponent(ForCpfResposanvel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblTelefoneResponsavel)
                            .addComponent(ForTelefoneResposanvel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnBuscarAlunos)
                            .addComponent(BtnLimpar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoBranco)
                .addContainerGap())
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

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed
        Limpar();
    }//GEN-LAST:event_BtnLimparActionPerformed

    private void TabAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabAlunosMouseClicked
        Mostrar();
    }//GEN-LAST:event_TabAlunosMouseClicked

    private void BtnBuscarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarAlunosActionPerformed
        BuscarAlunos();
    }//GEN-LAST:event_BtnBuscarAlunosActionPerformed

    private void TxtSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSituacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnBuscarAlunos;
    javax.swing.JButton BtnLimpar;
    javax.swing.JFormattedTextField ForCpf;
    javax.swing.JFormattedTextField ForCpfResposanvel;
    javax.swing.JFormattedTextField ForNascimento;
    javax.swing.JFormattedTextField ForTelefone;
    javax.swing.JFormattedTextField ForTelefoneResposanvel;
    javax.swing.JLabel LblCpf;
    javax.swing.JLabel LblCpfResponsavel;
    javax.swing.JLabel LblEmail;
    javax.swing.JLabel LblEmailResponsavel;
    javax.swing.JLabel LblEndereco;
    javax.swing.JLabel LblMatricula;
    javax.swing.JLabel LblNascimento;
    javax.swing.JLabel LblNome;
    javax.swing.JLabel LblResposavel;
    javax.swing.JLabel LblSituacao;
    javax.swing.JLabel LblTelefone;
    javax.swing.JLabel LblTelefoneResponsavel;
    javax.swing.JLabel LogoBranco;
    javax.swing.JTable TabAlunos;
    javax.swing.JTextField TxtEmail;
    javax.swing.JTextField TxtEmailResposavel;
    javax.swing.JTextField TxtEndereco;
    javax.swing.JTextField TxtMatricula;
    javax.swing.JTextField TxtNome;
    javax.swing.JTextField TxtResposavel;
    javax.swing.JTextField TxtSituacao;
    javax.swing.JLabel jLabel1;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
