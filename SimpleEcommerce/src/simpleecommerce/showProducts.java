package simpleecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Abrar Abir
 */
public class showProducts extends javax.swing.JFrame {
    
    /*====================================================================
    Database Connection Variable
    ======================================================================*/
    private Connection con;
    private PreparedStatement statement;
    private Statement st;
    private ResultSet rs;
    
    //Getting the row number which is clicked onthe table
    private static String Table_click;
    
    
    /*====================================================================
    Default constructor
    ======================================================================*/
    public showProducts() {
        initComponents();
        showProductTable();
        
    }
       
     /*====================================================================
    Displaying product with a delete buttuon on a table
    ======================================================================*/  
    
    public void showProductTable(){
        try{
        //Database connection    
        DBConnect databaseConnection=new DBConnect();
        con=databaseConnection.getCon();
        st=con.createStatement();
        
        //Selection Query
        String query="select * from product";
        rs=st.executeQuery(query);
        
        //putting data on the table
        tableShowProduct.setModel(DbUtils.resultSetToTableModel(rs));
        
        //Creating delete button on the table
        tableShowProduct.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());;
        tableShowProduct.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));        
                    
        //Closing the connection
        st.close();
        con.close();
        }catch(Exception e){
            //Handling if database doesnot load
            JOptionPane.showMessageDialog(rootPane,"Failed to load the database");
            System.out.println(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableShowProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableShowProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableShowProduct);

        jLabel1.setText("Products Information :");

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRefresh, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*====================================================================
    Select a particular row in table
    ======================================================================*/
    private void tableShowProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowProductMouseClicked
        // getting the selected row
        int row=tableShowProduct.getSelectedRow();
        String clicked=(tableShowProduct.getModel().getValueAt(row, 0).toString());
        
        Table_click=clicked;
        System.out.println(clicked);
        try{
         //For testing correct data is fetching or not   
         DBConnect databaseConnection=new DBConnect();
         con=databaseConnection.getCon();
        
         String sql="select * from product where ID='"+clicked+"'";
         st=con.prepareCall(sql);
         rs=st.executeQuery(sql);
        
        if(rs.next()){
            System.out.println(rs.getString("Name"));
        }
         }catch( Exception e){ 
            System.out.println("Error");
         }
        showProductTable();
    }//GEN-LAST:event_tableShowProductMouseClicked

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        showProductTable();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    //A static method to pass the information of selected row.
    public static String getRow(){
        System.out.println(Table_click);
        return Table_click;
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
            java.util.logging.Logger.getLogger(showProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new showProducts().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableShowProduct;
    // End of variables declaration//GEN-END:variables
}
