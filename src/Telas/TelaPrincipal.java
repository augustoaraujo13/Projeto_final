package Telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.Timer;
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

        horaAtual.start();
    }
    
    JLabel lblHora = new JLabel();
    
    Thread horaAtual = new Thread(new Runnable() { //cria uma thread
        public void run() {
            while(true) { //roda indefinidamente
                Date data = Calendar.getInstance().getTime();
                DateFormat d = DateFormat.getDateInstance();
                DateFormat h = DateFormat.getTimeInstance();
                LblHoraAtual.setText(h.format(data));     
                try {
                    Thread.sleep(1000); //espera 1 segundo para fazer a nova evolução
                } catch(InterruptedException ex){
                    System.out.println("Erro ao buscra hora atual");
                }
            }
        }
    }); 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelPrincipal = new javax.swing.JPanel();
        PainelDeSaudacao = new javax.swing.JPanel();
        LblData = new javax.swing.JLabel();
        LblDataAtual = new javax.swing.JLabel();
        LblHora = new javax.swing.JLabel();
        LblHoraAtual = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icones/Fundo.png"));
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
        MenuOpcoes = new javax.swing.JMenu();
        MenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout PainelDeSaudacaoLayout = new javax.swing.GroupLayout(PainelDeSaudacao);
        PainelDeSaudacao.setLayout(PainelDeSaudacaoLayout);
        PainelDeSaudacaoLayout.setHorizontalGroup(
            PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeSaudacaoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(LblData)
                .addGap(18, 18, 18)
                .addComponent(LblDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblHora)
                .addGap(18, 18, 18)
                .addComponent(LblHoraAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(463, Short.MAX_VALUE))
        );
        PainelDeSaudacaoLayout.setVerticalGroup(
            PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDeSaudacaoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(PainelDeSaudacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblData)
                    .addComponent(LblDataAtual)
                    .addComponent(LblHora)
                    .addComponent(LblHoraAtual))
                .addContainerGap())
        );

        javax.swing.GroupLayout AreaTrabalhoLayout = new javax.swing.GroupLayout(AreaTrabalho);
        AreaTrabalho.setLayout(AreaTrabalhoLayout);
        AreaTrabalhoLayout.setHorizontalGroup(
            AreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        AreaTrabalhoLayout.setVerticalGroup(
            AreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
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
                .addComponent(PainelDeSaudacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AreaTrabalho)
                .addContainerGap())
        );

        MenuCadastro.setText("Cadastro");

        MenuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        MenuUsuario.setText("Usuário");
        MenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuarioActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuUsuario);

        MenuAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        MenuAluno.setText("Aluno");
        MenuCadastro.add(MenuAluno);

        MenuPrincipal.add(MenuCadastro);

        MenuTurma.setText("Turma");
        MenuPrincipal.add(MenuTurma);

        MenuOpcoes.setText("Opções");
        MenuPrincipal.add(MenuOpcoes);

        MenuSobre.setText("Sobre");
        MenuPrincipal.add(MenuSobre);

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

        setSize(new java.awt.Dimension(761, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuarioActionPerformed
      TelaUsuario tu = new TelaUsuario();
      tu.setVisible(true);
      AreaTrabalho.add(tu);
    }//GEN-LAST:event_MenuUsuarioActionPerformed

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
    javax.swing.JMenuItem MenuAluno;
    javax.swing.JMenu MenuCadastro;
    javax.swing.JMenu MenuOpcoes;
    javax.swing.JMenuBar MenuPrincipal;
    javax.swing.JMenu MenuSobre;
    javax.swing.JMenu MenuTurma;
    javax.swing.JMenuItem MenuUsuario;
    javax.swing.JPanel PainelDeSaudacao;
    javax.swing.JPanel PainelPrincipal;
    // End of variables declaration//GEN-END:variables
}
