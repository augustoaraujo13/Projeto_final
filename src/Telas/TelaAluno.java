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

public class TelaAluno extends javax.swing.JInternalFrame {

    private Connection conn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    public TelaAluno() {
        initComponents();
        conn = ConexaoBanco.abrirBanco();
        formatarNascimeto();
        formatarCpf();
        formatarCpf2();
        formatarTelefone();
        formatarTelefone2();
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
            ms.install(ForCpf1);
        } catch (ParseException e) {
        }

    }

    private void formatarCpf2() {
        try {
            MaskFormatter ms = new MaskFormatter("###.###.###-##");
            ms.install(ForCpfResposanvel);
        } catch (ParseException e) {
        }

    }

    //Metedo para formar campo
    private void formatarTelefone() {
        try {
            MaskFormatter ms = new MaskFormatter("##-#####-####");
            ms.install(ForTelefoneResposanvel);
        } catch (ParseException e) {
            System.out.println(e);
        }

    }

    private void formatarTelefone2() {
        try {
            MaskFormatter ms = new MaskFormatter("##-#####-####");
            ms.install(ForTelefone1);
        } catch (ParseException e) {
            System.out.println(e);
        }

    }

    // Esse metedo cadastra um novo aluno.
    private void Criar() {
        String criando = "insert into alunos(situacao, nome, nascimento, CPF, email,"
                + " telefone, responsavel, CPF_responsavel, email_responsavel,"
                + " telefone_responsavel, endereco)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        String comcluido = "O aluno foi cadastrado!";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String dataString = ForNascimento.getText();
            Date data = sdf.parse(dataString);
            st = conn.prepareStatement(criando);

            st.setString(1, CbSituacao.getSelectedItem().toString());
            st.setString(2, TxtNome.getText().trim());
            st.setDate(3, new java.sql.Date(data.getTime()));
            st.setString(4, ForCpf1.getText().trim());
            st.setString(5, TxtEmail.getText().trim());
            st.setString(6, ForTelefone1.getText().trim());
            st.setString(7, TxtResposavel.getText().trim());
            st.setString(8, ForCpfResposanvel.getText().trim());
            st.setString(9, TxtEmailResposavel.getText().trim());
            st.setString(10, ForTelefoneResposanvel.getText().trim());
            st.setString(11, TxtEndereco.getText().trim());

            if ((TxtNome.getText().isEmpty())
                    || (ForNascimento.getText().isEmpty()) || (ForCpf1.getText().isEmpty())
                    || (TxtEmail.getText().isEmpty()) || (TxtEndereco.getText().isEmpty())) {
                String informacao2 = "Preencha os campos obrigatórios!";
                JOptionPane.showMessageDialog(this, informacao2);

            } else {
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, comcluido);

                CbSituacao.setSelectedItem(null);
                TxtNome.setText(null);
                ForNascimento.setText(null);
                ForCpf1.setText(null);
                TxtEmail.setText(null);
                ForTelefone1.setText(null);
                TxtResposavel.setText(null);
                ForCpfResposanvel.setText(null);
                TxtEmailResposavel.setText(null);
                ForTelefoneResposanvel.setText(null);
                TxtEndereco.setText(null);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            //System.out.println(e);

            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);

        } catch (HeadlessException e2) {
            JOptionPane.showMessageDialog(this, e2);
            //System.out.println(e2);

            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);
        } catch (ParseException e3) {
            JOptionPane.showMessageDialog(this, "Os campos estão vazios.");
            //System.out.println(e2);

            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);

        }

    }

    // Esse metedo busca um aluno.
    private void Buscar() {
        String mensagem = "Informe a matrícula do aluno.";
        String idRecebido = JOptionPane.showInputDialog(mensagem);
        String busca = "select * from alunos where matricula =" + idRecebido;

        try {
            st = conn.prepareStatement(busca);
            rs = st.executeQuery();

            if (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date dataBanco = rs.getDate(4);
                String dataRecebida = sdf.format(dataBanco);

                TxtMatricula.setText(rs.getString(1));
                CbSituacao.setSelectedItem(rs.getString(2));
                TxtNome.setText(rs.getString(3));
                ForNascimento.setText(dataRecebida);
                ForCpf1.setText(rs.getString(5));
                TxtEmail.setText(rs.getString(6));
                ForTelefone1.setText(rs.getString(7));
                TxtResposavel.setText(rs.getString(8));
                ForCpfResposanvel.setText(rs.getString(9));
                TxtEmailResposavel.setText(rs.getString(10));
                ForTelefoneResposanvel.setText(rs.getString(11));
                TxtEndereco.setText(rs.getString(12));
                BtnCriar.setEnabled(false);

            } else {
                String resposta = "O aluno que você pesquisou não existe.";
                JOptionPane.showMessageDialog(this, resposta);

                TxtMatricula.setText(null);
                CbSituacao.setSelectedItem(null);
                TxtNome.setText(null);
                ForNascimento.setText(null);
                ForCpf1.setText(null);
                TxtEmail.setText(null);
                ForTelefone1.setText(null);
                TxtResposavel.setText(null);
                ForCpfResposanvel.setText(null);
                TxtEmailResposavel.setText(null);
                ForTelefoneResposanvel.setText(null);
                TxtEndereco.setText(null);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Matrícula Inválida!");
            //System.out.println(e);

            TxtMatricula.setText(null);
            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);

        } catch (HeadlessException e2) {
            JOptionPane.showMessageDialog(this, e2);
            //System.out.println(e2);

            TxtMatricula.setText(null);
            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);
        }
        //System.out.println(e2);

    }

    //Esse metedo altera os dados de um aluno.
    private void Alterar() {
        String alterando = "update alunos set situacao =?, nome = ?, nascimento =?,"
                + " cpf =?, email =?, telefone =?,"
                + "responsavel =?, CPF_responsavel = ?, email_responsavel =?,"
                + " telefone_responsavel =?, endereco =? where matricula =?;";
        String comcluido = "Dados do aluno foram alterados!";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String dataString = ForNascimento.getText();
            Date data = sdf.parse(dataString);
            st = conn.prepareStatement(alterando);

            st.setString(1, CbSituacao.getSelectedItem().toString());
            st.setString(2, TxtNome.getText().trim());
            st.setDate(3, new java.sql.Date(data.getTime()));
            st.setString(4, ForCpf1.getText().trim());
            st.setString(5, TxtEmail.getText().trim());
            st.setString(6, ForTelefone1.getText().trim());
            st.setString(7, TxtResposavel.getText().trim());
            st.setString(8, ForCpfResposanvel.getText().trim());
            st.setString(9, TxtEmailResposavel.getText().trim());
            st.setString(10, ForTelefoneResposanvel.getText().trim());
            st.setString(11, TxtEndereco.getText().trim());
            st.setString(12, TxtMatricula.getText().trim());

            if ((TxtNome.getText().isEmpty())
                    || (ForNascimento.getText().isEmpty()) || (ForCpf1.getText().isEmpty())
                    || (TxtEmail.getText().isEmpty()) || (TxtEndereco.getText().isEmpty())) {
                String informacao2 = "Preencha os campos obrigatórios!";
                JOptionPane.showMessageDialog(this, informacao2);

            } else {
                st.executeUpdate();
                JOptionPane.showMessageDialog(this, comcluido);

                TxtMatricula.setText(null);
                CbSituacao.setSelectedItem(null);
                TxtNome.setText(null);
                ForNascimento.setText(null);
                ForCpf1.setText(null);
                TxtEmail.setText(null);
                ForTelefone1.setText(null);
                TxtResposavel.setText(null);
                ForCpfResposanvel.setText(null);
                TxtEmailResposavel.setText(null);
                ForTelefoneResposanvel.setText(null);
                TxtEndereco.setText(null);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
            //System.out.println(e);

            TxtMatricula.setText(null);
            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);

        } catch (HeadlessException e2) {
            JOptionPane.showMessageDialog(this, e2);
            //System.out.println(e2);

            TxtMatricula.setText(null);
            CbSituacao.setSelectedItem(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);
        } catch (ParseException e3) {
            JOptionPane.showMessageDialog(this, "Os campos estão vazios.");
            //System.out.println(e3);
            CbSituacao.setSelectedItem(null);
            TxtMatricula.setText(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);
        }

    }

    //Esse metedo deleta o aluno.
    private void Deletar() {
        String confirmando = "Deseja deletar esse Aluno?";
        String confirmando2 = "Atenção";
        int confirmar = JOptionPane.showConfirmDialog(null, confirmando, confirmando2, JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            String deletando = "delete from alunos where matricula=?;";

            try {
                st = conn.prepareStatement(deletando);
                st.setString(1, TxtMatricula.getText().trim());

                if (TxtMatricula.getText().isEmpty()) {
                    String informacao = "Preencha o campo matrícula, para excluir o aluno!";
                    JOptionPane.showMessageDialog(this, informacao);

                } else {
                    String comcluido = "Aluno excluído com sucesso!";
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(this, comcluido);

                    BtnCriar.setEnabled(true);
                    CbSituacao.setSelectedItem(null);
                    TxtMatricula.setText(null);
                    TxtNome.setText(null);
                    ForNascimento.setText(null);
                    ForCpf1.setText(null);
                    TxtEmail.setText(null);
                    ForTelefone1.setText(null);
                    TxtResposavel.setText(null);
                    ForCpfResposanvel.setText(null);
                    TxtEmailResposavel.setText(null);
                    ForTelefoneResposanvel.setText(null);
                    TxtEndereco.setText(null);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e);
                //System.out.println(e);

                CbSituacao.setSelectedItem(null);
                TxtMatricula.setText(null);
                TxtNome.setText(null);
                ForNascimento.setText(null);
                ForCpf1.setText(null);
                TxtEmail.setText(null);
                ForTelefone1.setText(null);
                TxtResposavel.setText(null);
                ForCpfResposanvel.setText(null);
                TxtEmailResposavel.setText(null);
                ForTelefoneResposanvel.setText(null);
                TxtEndereco.setText(null);

            }

        } else {
            JOptionPane.showMessageDialog(null, "O aluno não foi excluído.");

            CbSituacao.setSelectedItem(null);
            TxtMatricula.setText(null);
            TxtNome.setText(null);
            ForNascimento.setText(null);
            ForCpf1.setText(null);
            TxtEmail.setText(null);
            ForTelefone1.setText(null);
            TxtResposavel.setText(null);
            ForCpfResposanvel.setText(null);
            TxtEmailResposavel.setText(null);
            ForTelefoneResposanvel.setText(null);
            TxtEndereco.setText(null);

        }

    }

    //Esse metedo limpa os campos.
    private void Limpar() {
        String comcluido = "Os campos foram limpos!!";
        JOptionPane.showMessageDialog(this, comcluido);

        BtnCriar.setEnabled(true);
        TxtMatricula.setText(null);
        TxtNome.setText(null);
        CbSituacao.setSelectedItem(null);
        ForNascimento.setText(null);
        ForCpf1.setText(null);
        TxtEmail.setText(null);
        ForTelefone1.setText(null);
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
        CbSituacao = new javax.swing.JComboBox<>();
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
        BtnBuscar = new javax.swing.JButton();
        BtnCriar = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();
        BtnDeletar = new javax.swing.JButton();
        BtnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LblCamposObrigatorios = new javax.swing.JLabel();
        ForNascimento = new javax.swing.JFormattedTextField();
        ForCpfResposanvel = new javax.swing.JFormattedTextField();
        ForTelefoneResposanvel = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LogoBranco = new javax.swing.JLabel();
        ForTelefone1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        ForCpf1 = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Aluno");

        jPanel1.setBackground(new java.awt.Color(6, 47, 79));

        LblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        LblMatricula.setText("Matricula #");

        TxtMatricula.setEditable(false);
        TxtMatricula.setBackground(new java.awt.Color(231, 223, 221));
        TxtMatricula.setForeground(new java.awt.Color(0, 0, 0));

        LblSituacao.setForeground(new java.awt.Color(255, 255, 255));
        LblSituacao.setText("Situação *");

        CbSituacao.setBackground(new java.awt.Color(204, 0, 204));
        CbSituacao.setForeground(new java.awt.Color(0, 0, 0));
        CbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprovado", "Concluiu", "Cursando", "Desistiu", "Recuperação", "Trancou" }));
        CbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSituacaoActionPerformed(evt);
            }
        });

        LblNascimento.setForeground(new java.awt.Color(255, 255, 255));
        LblNascimento.setText("Nascimento *");

        LblEmail.setForeground(new java.awt.Color(255, 255, 255));
        LblEmail.setText("Email *");

        TxtEmail.setBackground(new java.awt.Color(231, 223, 221));
        TxtEmail.setForeground(new java.awt.Color(0, 0, 0));

        LblNome.setForeground(new java.awt.Color(255, 255, 255));
        LblNome.setText("Aluno *");

        TxtNome.setBackground(new java.awt.Color(231, 223, 221));
        TxtNome.setForeground(new java.awt.Color(0, 0, 0));

        LblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefone.setText("Telefone");

        LblResposavel.setForeground(new java.awt.Color(255, 255, 255));
        LblResposavel.setText("Responsável ");

        TxtResposavel.setBackground(new java.awt.Color(231, 223, 221));
        TxtResposavel.setForeground(new java.awt.Color(0, 0, 0));

        LblCpfResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        LblCpfResponsavel.setText("CPF Res ");

        LblTelefoneResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        LblTelefoneResponsavel.setText("Telefone Res");

        LblEmailResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        LblEmailResponsavel.setText("Email Res ");

        TxtEmailResposavel.setBackground(new java.awt.Color(231, 223, 221));
        TxtEmailResposavel.setForeground(new java.awt.Color(0, 0, 0));

        LblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        LblEndereco.setText("Endereço *");

        TxtEndereco.setBackground(new java.awt.Color(231, 223, 221));

        BtnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        BtnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscar.setText("Buscar");
        BtnBuscar.setToolTipText("Busca um aluno.");
        BtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnCriar.setBackground(new java.awt.Color(0, 204, 0));
        BtnCriar.setForeground(new java.awt.Color(0, 0, 0));
        BtnCriar.setText("Criar");
        BtnCriar.setToolTipText("Cadastra um novo aluno.");
        BtnCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCriarActionPerformed(evt);
            }
        });

        BtnAlterar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAlterar.setForeground(new java.awt.Color(0, 0, 0));
        BtnAlterar.setText("Alterar");
        BtnAlterar.setToolTipText("Altera os dados de um aluno.");
        BtnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });

        BtnDeletar.setBackground(new java.awt.Color(255, 0, 0));
        BtnDeletar.setForeground(new java.awt.Color(0, 0, 0));
        BtnDeletar.setText("Deletar");
        BtnDeletar.setToolTipText("Cuidado!! Deleta o aluno.");
        BtnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeletarActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Campos automáticos #");

        LblCamposObrigatorios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblCamposObrigatorios.setForeground(new java.awt.Color(255, 255, 255));
        LblCamposObrigatorios.setText("Campos obrigatórios *");

        ForNascimento.setBackground(new java.awt.Color(231, 223, 221));
        ForNascimento.setForeground(new java.awt.Color(0, 0, 0));

        ForCpfResposanvel.setBackground(new java.awt.Color(231, 223, 221));
        ForCpfResposanvel.setForeground(new java.awt.Color(0, 0, 0));
        ForCpfResposanvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForCpfResposanvelActionPerformed(evt);
            }
        });

        ForTelefoneResposanvel.setBackground(new java.awt.Color(231, 223, 221));
        ForTelefoneResposanvel.setForeground(new java.awt.Color(0, 0, 0));
        ForTelefoneResposanvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ForTelefoneResposanvelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("--------------------------------------------  Área caso aluno seja menor de idade  --------------------------------------------");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Res = Responsável");

        LogoBranco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco.png"))); // NOI18N

        ForTelefone1.setBackground(new java.awt.Color(231, 223, 221));
        ForTelefone1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CPF*");

        ForCpf1.setBackground(new java.awt.Color(231, 223, 221));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblResposavel)
                                    .addComponent(LblEmailResponsavel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtEmailResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(BtnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BtnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblNome)
                                    .addComponent(LblTelefone)
                                    .addComponent(LblMatricula))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(ForTelefone1))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(LblCpfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblNascimento)
                                            .addComponent(LblSituacao))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LblTelefoneResponsavel)
                                            .addComponent(LblEndereco))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ForCpfResposanvel, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                    .addComponent(ForTelefoneResposanvel))
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(LblCamposObrigatorios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(TxtEndereco)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(ForNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(CbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(28, 28, 28)
                                                        .addComponent(LblEmail)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                            .addComponent(ForCpf1)))))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                                .addComponent(LogoBranco)
                                .addGap(15, 15, 15))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblMatricula)
                            .addComponent(TxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblSituacao)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ForCpf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNascimento)
                            .addComponent(ForNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNome)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblEmail)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTelefone)
                    .addComponent(LblEndereco)
                    .addComponent(TxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ForTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblResposavel)
                            .addComponent(TxtResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblCpfResponsavel)
                            .addComponent(jLabel2)
                            .addComponent(ForCpfResposanvel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LblCamposObrigatorios)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtEmailResposavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblEmailResponsavel)
                        .addComponent(LblTelefoneResponsavel)
                        .addComponent(ForTelefoneResposanvel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnBuscar)
                        .addComponent(BtnCriar)
                        .addComponent(BtnAlterar)
                        .addComponent(BtnDeletar)
                        .addComponent(BtnLimpar))
                    .addComponent(LogoBranco, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
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

    private void CbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSituacaoActionPerformed

    }//GEN-LAST:event_CbSituacaoActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCriarActionPerformed
        Criar();
    }//GEN-LAST:event_BtnCriarActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
        Alterar();
    }//GEN-LAST:event_BtnAlterarActionPerformed

    private void BtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeletarActionPerformed
        Deletar();
    }//GEN-LAST:event_BtnDeletarActionPerformed

    private void BtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparActionPerformed
        Limpar();
    }//GEN-LAST:event_BtnLimparActionPerformed

    private void ForTelefoneResposanvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForTelefoneResposanvelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForTelefoneResposanvelActionPerformed

    private void ForCpfResposanvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ForCpfResposanvelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ForCpfResposanvelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton BtnAlterar;
    javax.swing.JButton BtnBuscar;
    javax.swing.JButton BtnCriar;
    javax.swing.JButton BtnDeletar;
    javax.swing.JButton BtnLimpar;
    javax.swing.JComboBox<String> CbSituacao;
    javax.swing.JFormattedTextField ForCpf1;
    javax.swing.JFormattedTextField ForCpfResposanvel;
    javax.swing.JFormattedTextField ForNascimento;
    javax.swing.JFormattedTextField ForTelefone1;
    javax.swing.JFormattedTextField ForTelefoneResposanvel;
    javax.swing.JLabel LblCamposObrigatorios;
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
    javax.swing.JTextField TxtEmail;
    javax.swing.JTextField TxtEmailResposavel;
    javax.swing.JTextField TxtEndereco;
    javax.swing.JTextField TxtMatricula;
    javax.swing.JTextField TxtNome;
    javax.swing.JTextField TxtResposavel;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
