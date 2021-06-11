package Telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();

        // para chamar a hora HH:mm:ss
        // Esse codigo exibe a data do sistema
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        String atual = df.format(data);
        LblDataAtual.setText(atual);

        // faz jLabel horaAtual recber a hora, minutos e segundos em tempo real
        horaAtual.start();
    }

    JLabel lblHora = new JLabel();

    //Metodo que pega a hora em tempo real
    Thread horaAtual = new Thread(new Runnable() { //cria uma thread
        public void run() {
            while (true) { //roda indefinidamente
                Date data = Calendar.getInstance().getTime();
                DateFormat d = DateFormat.getDateInstance();
                DateFormat h = DateFormat.getTimeInstance();
                LblHoraAtual.setText(h.format(data));
                try {
                    Thread.sleep(1000); //espera 1 segundo para fazer a nova evolução
                } catch (InterruptedException ex) {
                    System.out.println("Erro ao buscra hora atual");
                }
            }
        }
    });

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        PainelPrincipal = new javax.swing.JPanel();
        PainelDeSaudacao = new javax.swing.JPanel();
        LblData = new javax.swing.JLabel();
        LblDataAtual = new javax.swing.JLabel();
        LblHora = new javax.swing.JLabel();
        LblHoraAtual = new javax.swing.JLabel();
        LblOla = new javax.swing.JLabel();
        LblNomeUsuario = new javax.swing.JLabel();
        LblLogoBranca = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icones/Fundo3.png"));
        Image image = icon.getImage();
        AreaTrabalho = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        MenuPrincipal = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        MenuUsuario = new javax.swing.JMenuItem();
        MenuAluno = new javax.swing.JMenuItem();
        MenuTurma = new javax.swing.JMenu();
        MenuAlterarDeletar = new javax.swing.JMenuItem();
        MenuAssociar = new javax.swing.JMenuItem();
        MenuBuscar = new javax.swing.JMenuItem();
        MenuCriar = new javax.swing.JMenuItem();
        MenuProfessor = new javax.swing.JMenu();
        MenuAdicionarNotas = new javax.swing.JMenuItem();
        MenuBuscarAluno = new javax.swing.JMenuItem();
        MenuSecretario = new javax.swing.JMenu();
        MenuVerAlunos = new javax.swing.JMenuItem();
        MenuVerNotas = new javax.swing.JMenuItem();
        MenuOpcoes = new javax.swing.JMenu();
        MenuAjuda = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenuItem();
        MenuSobre = new javax.swing.JMenuItem();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela principal");
        setResizable(false);

        PainelPrincipal.setBackground(new java.awt.Color(220, 199, 170));
        PainelPrincipal.setToolTipText("Tela principal");

        PainelDeSaudacao.setBackground(new java.awt.Color(40, 109, 168));

        LblData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblData.setForeground(new java.awt.Color(255, 255, 255));
        LblData.setText("Data:");

        LblDataAtual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblDataAtual.setForeground(new java.awt.Color(255, 255, 255));
        LblDataAtual.setText("------");

        LblHora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblHora.setForeground(new java.awt.Color(255, 255, 255));
        LblHora.setText("Hora:");

        LblHoraAtual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblHoraAtual.setForeground(new java.awt.Color(255, 255, 255));
        LblHoraAtual.setText("------");

        LblOla.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblOla.setForeground(new java.awt.Color(255, 255, 255));
        LblOla.setText(" Olá,");

        LblNomeUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LblNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LblNomeUsuario.setText("----------------");

        LblLogoBranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/LogoBranco2.png"))); // NOI18N

        javax.swing.GroupLayout PainelDeSaudacaoLayout = new javax.swing.GroupLayout(PainelDeSaudacao);
        PainelDeSaudacao.setLayout(PainelDeSaudacaoLayout);
        PainelDeSaudacaoLayout.setHorizontalGroup(
            PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeSaudacaoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(LblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblHoraAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LblOla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addGap(89, 89, 89)
                .addComponent(LblLogoBranca)
                .addContainerGap())
        );
        PainelDeSaudacaoLayout.setVerticalGroup(
            PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeSaudacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblData)
                        .addComponent(LblDataAtual)
                        .addComponent(LblHora)
                        .addComponent(LblHoraAtual)
                        .addComponent(LblOla)
                        .addComponent(LblNomeUsuario))
                    .addComponent(LblLogoBranca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AreaTrabalhoLayout = new javax.swing.GroupLayout(AreaTrabalho);
        AreaTrabalho.setLayout(AreaTrabalhoLayout);
        AreaTrabalhoLayout.setHorizontalGroup(
            AreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        AreaTrabalhoLayout.setVerticalGroup(
            AreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelDeSaudacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AreaTrabalho)
                .addContainerGap())
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addComponent(PainelDeSaudacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AreaTrabalho)
                .addContainerGap())
        );

        MenuCadastro.setText("Cadastro");

        MenuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        MenuUsuario.setText("Usuário");
        MenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuUsuario);

        MenuAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        MenuAluno.setText("Aluno");
        MenuAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAlunoActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuAluno);

        MenuPrincipal.add(MenuCadastro);

        MenuTurma.setText("Turma");
        MenuTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTurmaActionPerformed(evt);
            }
        });

        MenuAlterarDeletar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenuAlterarDeletar.setText("Alterar e deletar");
        MenuAlterarDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAlterarDeletarActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuAlterarDeletar);

        MenuAssociar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        MenuAssociar.setText("Associar");
        MenuAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAssociarActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuAssociar);

        MenuBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        MenuBuscar.setText("Buscar");
        MenuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBuscarActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuBuscar);

        MenuCriar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        MenuCriar.setText("Criar");
        MenuCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCriarActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuCriar);

        MenuPrincipal.add(MenuTurma);

        MenuProfessor.setText("Professor");

        MenuAdicionarNotas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        MenuAdicionarNotas.setText("Adiconar nota");
        MenuAdicionarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAdicionarNotasActionPerformed(evt);
            }
        });
        MenuProfessor.add(MenuAdicionarNotas);

        MenuBuscarAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        MenuBuscarAluno.setText("Buscar aluno");
        MenuBuscarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBuscarAlunoActionPerformed(evt);
            }
        });
        MenuProfessor.add(MenuBuscarAluno);

        MenuPrincipal.add(MenuProfessor);

        MenuSecretario.setText("Secretário");

        MenuVerAlunos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        MenuVerAlunos.setText("Ver alunos");
        MenuVerAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVerAlunosActionPerformed(evt);
            }
        });
        MenuSecretario.add(MenuVerAlunos);

        MenuVerNotas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        MenuVerNotas.setText("Ver notas");
        MenuVerNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVerNotasActionPerformed(evt);
            }
        });
        MenuSecretario.add(MenuVerNotas);

        MenuPrincipal.add(MenuSecretario);

        MenuOpcoes.setText("Opções");

        MenuAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        MenuAjuda.setText("Ajuda");
        MenuOpcoes.add(MenuAjuda);

        MenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        MenuSair.setText("Sair");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        MenuOpcoes.add(MenuSair);

        MenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        MenuSobre.setText("Sobre");
        MenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSobreActionPerformed(evt);
            }
        });
        MenuOpcoes.add(MenuSobre);

        MenuPrincipal.add(MenuOpcoes);

        customizeMenuBar(MenuPrincipal);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(951, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioActionPerformed
        TelaUsuario tu = new TelaUsuario();
        tu.setVisible(true);
        AreaTrabalho.add(tu);
    }//GEN-LAST:event_MenuUsuarioActionPerformed

    private void MenuAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlunoActionPerformed
        TelaAluno ta = new TelaAluno();
        ta.setVisible(true);
        AreaTrabalho.add(ta);

    }//GEN-LAST:event_MenuAlunoActionPerformed

    private void MenuTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTurmaActionPerformed

    }//GEN-LAST:event_MenuTurmaActionPerformed

    private void MenuCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCriarActionPerformed
        TelaCriarTurma tct = new TelaCriarTurma();
        tct.setVisible(true);
        AreaTrabalho.add(tct);
    }//GEN-LAST:event_MenuCriarActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed

        String saindo = "Tem certeza que deseja sair?";
        String titulo = "Atenção!";
        int sair = JOptionPane.showConfirmDialog(null, saindo, titulo, JOptionPane.YES_NO_OPTION);

        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuAssociarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAssociarActionPerformed
        TelaAssociar ta = new TelaAssociar();
        ta.setVisible(true);
        AreaTrabalho.add(ta);
    }//GEN-LAST:event_MenuAssociarActionPerformed

    private void MenuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBuscarActionPerformed
        TelaBuscarTurmas tbt = new TelaBuscarTurmas();
        tbt.setVisible(true);
        AreaTrabalho.add(tbt);
    }//GEN-LAST:event_MenuBuscarActionPerformed

    private void MenuBuscarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBuscarAlunoActionPerformed
        TelaBuscarAlunos tba = new TelaBuscarAlunos();
        tba.setVisible(true);
        AreaTrabalho.add(tba);
    }//GEN-LAST:event_MenuBuscarAlunoActionPerformed

    private void MenuAdicionarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAdicionarNotasActionPerformed
        TelaAdcionarNotas tan = new TelaAdcionarNotas();
        tan.setVisible(true);
        AreaTrabalho.add(tan);
    }//GEN-LAST:event_MenuAdicionarNotasActionPerformed

    private void MenuVerAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVerAlunosActionPerformed
        TelaVerAlunos tva = new TelaVerAlunos();
        tva.setVisible(true);
        AreaTrabalho.add(tva);
    }//GEN-LAST:event_MenuVerAlunosActionPerformed

    private void MenuVerNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVerNotasActionPerformed
        TelaVerNotas tvn = new TelaVerNotas();
        tvn.setVisible(true);
        AreaTrabalho.add(tvn);
    }//GEN-LAST:event_MenuVerNotasActionPerformed

    private void MenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSobreActionPerformed
        TelaSobre ts = new TelaSobre();
        ts.setVisible(true);
        AreaTrabalho.add(ts);
    }//GEN-LAST:event_MenuSobreActionPerformed

    private void MenuAlterarDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlterarDeletarActionPerformed
        TelaAlterarDeletar tad = new TelaAlterarDeletar();
        tad.setVisible(true);
        AreaTrabalho.add(tad);
    }//GEN-LAST:event_MenuAlterarDeletarActionPerformed

    //Metodo que faz o Jmenu mudar de cor
    private void customizeMenuBar(JMenuBar menuBar) {

        menuBar.setUI(new BasicMenuBarUI() {

            public void paint(Graphics g, JComponent c) {
                //[220,199,170]
                //[107,122,143]
                //[6,47,79]
                g.setColor(new java.awt.Color(6, 47, 79));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }

        });

        MenuElement[] menus = menuBar.getSubElements();

        for (MenuElement menuElement : menus) {

            JMenu menu = (JMenu) menuElement.getComponent();
            changeComponentColors(menu);
            menu.setOpaque(false);

            MenuElement[] menuElements = menu.getSubElements();

            for (MenuElement popupMenuElement : menuElements) {

                JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
                popupMenu.setBorder(null);

                MenuElement[] menuItens = popupMenuElement.getSubElements();

                for (MenuElement menuItemElement : menuItens) {

                    JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                    changeComponentColors(menuItem);
                    menuItem.setOpaque(true);

                }
            }
        }
    }

    //Metodo auxiliar que ajuda a dar cor aop Jmenu
    private void changeComponentColors(Component comp) {
        comp.setBackground(new java.awt.Color(247, 195, 49));
        comp.setForeground(Color.WHITE);
    }

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JDesktopPane AreaTrabalho;
    javax.swing.JLabel LblData;
    javax.swing.JLabel LblDataAtual;
    javax.swing.JLabel LblHora;
    javax.swing.JLabel LblHoraAtual;
    javax.swing.JLabel LblLogoBranca;
    javax.swing.JLabel LblNomeUsuario;
    javax.swing.JLabel LblOla;
    javax.swing.JMenuItem MenuAdicionarNotas;
    javax.swing.JMenuItem MenuAjuda;
    javax.swing.JMenuItem MenuAlterarDeletar;
    javax.swing.JMenuItem MenuAluno;
    javax.swing.JMenuItem MenuAssociar;
    javax.swing.JMenuItem MenuBuscar;
    javax.swing.JMenuItem MenuBuscarAluno;
    javax.swing.JMenu MenuCadastro;
    javax.swing.JMenuItem MenuCriar;
    javax.swing.JMenu MenuOpcoes;
    private javax.swing.JMenuBar MenuPrincipal;
    javax.swing.JMenu MenuProfessor;
    javax.swing.JMenuItem MenuSair;
    javax.swing.JMenu MenuSecretario;
    javax.swing.JMenuItem MenuSobre;
    javax.swing.JMenu MenuTurma;
    javax.swing.JMenuItem MenuUsuario;
    javax.swing.JMenuItem MenuVerAlunos;
    javax.swing.JMenuItem MenuVerNotas;
    javax.swing.JPanel PainelDeSaudacao;
    javax.swing.JPanel PainelPrincipal;
    javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
