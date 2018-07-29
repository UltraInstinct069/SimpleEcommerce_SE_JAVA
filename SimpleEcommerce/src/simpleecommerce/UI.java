package simpleecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Abrar Abir
 */
public class UI extends javax.swing.JFrame {
    private Connection con;
    private PreparedStatement statement;
    private Statement st;
    private ResultSet rs;
    
    /*====================================================================
    Default constructor
    ======================================================================*/
    public UI() {
        initComponents();
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logInName = new javax.swing.JTextField();
        logInPassword = new javax.swing.JPasswordField();
        logInButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        aboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name :");

        jLabel2.setText("Password :");

        logInButton.setText("Log In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        aboutMenu.setText("About");
        aboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logInButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logInName)
                            .addComponent(logInPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logInName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(logInPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(logInButton)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        /*====================================================================
        Log In related Code
        ======================================================================*/
        try{
        //Database Coonection
        DBConnect databaseConnection=new DBConnect();
        
        con=databaseConnection.getCon();
        st=con.createStatement();
        
        //Fetch ans store data In variables
        String Name=logInName.getText();
        String Enterdpassword=String.valueOf(logInPassword.getPassword());;
       
        String password="";
        String query="select Password from login where Name='"+Name+"'";
        rs=st.executeQuery(query);
        
        //Password Matching Code
        if(rs.next()){
            password=rs.getString("Password");
            
            if(password.equals(Enterdpassword)){
                new Functions().setVisible(true);
                this.setVisible(false);
            }
            else 
                JOptionPane.showMessageDialog(rootPane,"Password does not match with user");         
        }
        else 
            JOptionPane.showMessageDialog(rootPane,"Invalid username");     
        //Close all connection            
        st.close();
        con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"Failed to load the database");
            System.out.println(e);
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void aboutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMenuMouseClicked
        // Goto About Frame
        new About().setVisible(true);
    }//GEN-LAST:event_aboutMenuMouseClicked
    public void CloseFrame(){
        super.dispose();
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField logInName;
    private javax.swing.JPasswordField logInPassword;
    // End of variables declaration//GEN-END:variables
}
