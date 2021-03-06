/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Window.java
 *
 * Created on 09/04/2009, 20:56:20
 */

package capimClient;

import java.awt.*;
import java.io.*;
import java.net.SocketException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import capimClient.Message;
import java.util.HashMap;

/**
 *
 * @author helinho
 */
public class Window extends javax.swing.JFrame {

    /** Creates new form Window */
    public Window() {
        

        initComponents();
        cards = new JPanel(new CardLayout());
        cards.add(panelLogin, LOGIN);
        cards.add(panelContacts, CONTACTS);
        panelMain.add(cards, BorderLayout.CENTER);
        showCards(LOGIN);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        buttonOK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldPass = new javax.swing.JPasswordField();
        buttonCancel = new javax.swing.JButton();
        comboStatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        panelContacts = new javax.swing.JPanel();
        button2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        panelMain = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        buttonCancel.setText("Cancel");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Online", "Ocupado", "Ausente" }));

        jLabel3.setText("Status");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(fieldPass)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel))
                    .addComponent(fieldLogin))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonOK))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        button2.setText("teste");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout panelContactsLayout = new javax.swing.GroupLayout(panelContacts);
        panelContacts.setLayout(panelContactsLayout);
        panelContactsLayout.setHorizontalGroup(
            panelContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContactsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button2))
        );
        panelContactsLayout.setVerticalGroup(
            panelContactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContactsLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setLayout(new java.awt.CardLayout());

        jMenu1.setText("Registro");

        jMenuItem1.setText("Nova Conta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        try {
            Client cl = new Client("1:" + getLogin() + ":" + getPass() + ".");
            DefaultListModel modelo = new DefaultListModel();
            jList1.setModel(modelo);
            HashMap users = new HashMap();
            users = cl.getList();
        for(int i=0;i<users.size();i++){
            //modelo.addElement(users.get(i));
        }
            showCards(CONTACTS);
        } catch (SocketException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonOKActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        showCards(LOGIN);
        
    }//GEN-LAST:event_button2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Client cl;
        try {
            cl = new Client("0:" + getLogin() + ":" + getPass() + ".");
        } catch (SocketException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void showCards(String nome){
        CardLayout card = (CardLayout) (cards.getLayout());
        card.show(cards, nome);
    }

    public String getLogin(){
        return fieldLogin.getText();
    }

    public String getPass(){
        return fieldPass.getText();
    }

    public void gravaArquivo(String arquivo) throws Exception {
        FileWriter out = new FileWriter(arquivo, true);
        out.write(getLogin()+"\t"+getPass()+"\n");
        out.close();
    }

    public boolean findContact(String contact) throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(new File(arquivo)));
        String str;
        StringTokenizer strt;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
            strt = new StringTokenizer(str);
            str = strt.nextToken();
            if (str.equals(contact)){
                return true;
            }
//            System.out.println(str);
        }
        return false;
    }

    public void setList(String user){
        
        
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
    JPanel cards; //a panel that uses CardLayout
    final static String LOGIN = "login";
    final static String CONTACTS = "contacts";
    String arquivo = "/home/helinho/svn/CapimF4/Arquivos/records.txt";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button2;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JTextField fieldLogin;
    private javax.swing.JPasswordField fieldPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelContacts;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
