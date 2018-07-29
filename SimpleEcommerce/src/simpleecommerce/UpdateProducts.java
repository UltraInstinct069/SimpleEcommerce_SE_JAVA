package simpleecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Abrar Abir
 */
public class UpdateProducts extends javax.swing.JFrame {
    /*====================================================================
    Database connection Variable
    ======================================================================*/
    private Connection con;
    private PreparedStatement statement;
    private Statement st;
    private ResultSet rs;
    
    //getting the ID of the data which is clicked on the table
    String clicked;
    
    
    /*====================================================================
    Default constructor
    ======================================================================*/
    public UpdateProducts() {
        initComponents();
        updateTable(); //load the databse into table at the begining
    }
    
    /*====================================================================
    Storing textfield data into variables
    ======================================================================*/
    private String Name;
    private String ProductType;
    private float Price;
    private float Profit; 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        updateTableView = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        updateName = new javax.swing.JTextField();
        updatePrice = new javax.swing.JTextField();
        updateProfit = new javax.swing.JTextField();
        updateProdType = new javax.swing.JComboBox();
        updateButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        updateTableView.setModel(new javax.swing.table.DefaultTableModel(
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
        updateTableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTableViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(updateTableView);

        jLabel1.setText("Name :");

        jLabel2.setText("Product Type :");

        jLabel3.setText("Price :");

        jLabel4.setText("Profit Percentage:");

        updateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNameActionPerformed(evt);
            }
        });

        updateProdType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RAM", "MOTHERBOARD", "GRAPHICS CARD" }));

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Products information :");

        jLabel6.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(54, 54, 54)
                                        .addComponent(updateName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateProdType, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateButton)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(62, 62, 62)
                                        .addComponent(updatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(updateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(updateProdType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(updatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(updateProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNameActionPerformed
    
    /*====================================================================
    Showing the data on the table
    ======================================================================*/
    public void updateTable(){ 
        try{
        //Database connection
        DBConnect databaseConnection=new DBConnect();
        con=databaseConnection.getCon();
        st=con.createStatement();
        
        //Selection Query
        String query="select ID,Name,ProductType,Price,ProfitPercentage from product";
        rs=st.executeQuery(query);
        
        //Putting result into the table
        updateTableView.setModel(DbUtils.resultSetToTableModel(rs));
                   
        //closing all connection     
        st.close();
        con.close();
        }catch(Exception e){
            //In case database doesnot load
            JOptionPane.showMessageDialog(rootPane,"Failed to load the database");
            System.out.println(e);
        }
    
    }
    
    /*====================================================================
    When a row is selected in the table the corresponding information abount
    that row is loaded on the textfield using this function
    ======================================================================*/
    private void updateTableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateTableViewMouseClicked
        //getting the selected row
        int row=updateTableView.getSelectedRow();
        clicked=(updateTableView.getModel().getValueAt(row, 0).toString());
        
        try{
         //database Connection   
         DBConnect databaseConnection=new DBConnect();
         con=databaseConnection.getCon();
        
         //Query 
         String sql="select Name,ProductType,Price,ProfitPercentage from product where ID='"+clicked+"'";
         st=con.prepareCall(sql);
         rs=st.executeQuery(sql);
        
         //Setting the product type in the combo box
         int comboxIndex=0;
         
         if(rs.next()){
            updateName.setText(rs.getString("Name"));
            if(rs.getString("ProductType").equals("RAM"))
                comboxIndex=0;
            else if(rs.getString("ProductType").equals("MOTHERBOARD"))
                comboxIndex=1;
            else if(rs.getString("ProductType").equals("GRAPHICS CARD"))
                comboxIndex=2;
            
            updateProdType.setSelectedIndex(comboxIndex);
            
            updatePrice.setText(rs.getString("Price"));
            
            //perform the conversion from percentage to float value
            Profit=Float.parseFloat(rs.getString("ProfitPercentage"))*100;
            updateProfit.setText(Float.toString(Profit));
            
        }
         }catch( Exception e){ 
             System.out.println("Error");
         }
        
        
    }//GEN-LAST:event_updateTableViewMouseClicked

    /*====================================================================
    After selecting the data if we make any change in any field 
    then the database will be updated using this event
    ======================================================================*/
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // getting updated info
        Name=updateName.getText();
        ProductType=updateProdType.getSelectedItem().toString();
        Price=Float.parseFloat(updatePrice.getText());
        Profit=Float.parseFloat(updateProfit.getText())/100;
        try{
         //Database Connecction
         DBConnect databaseConnection=new DBConnect();
         con=databaseConnection.getCon();
         
         //query and perform operation
         String sql="update product set Name='"+Name+"',ProductType='"+ProductType+"',Price='"+Price+"',ProfitPercentage='"+Profit+"' where ID='"+clicked+"'";          
         st=con.prepareCall(sql);            
         st.execute(sql);
         
         //If any update happend then load the table again with updated information
         updateTable();
         JOptionPane.showMessageDialog(null,"Updated");
            
         }catch( Exception e){
             //In case update failed for invalid input
             JOptionPane.showMessageDialog(null,"Update Failed");
         }
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField updateName;
    private javax.swing.JTextField updatePrice;
    private javax.swing.JComboBox updateProdType;
    private javax.swing.JTextField updateProfit;
    private javax.swing.JTable updateTableView;
    // End of variables declaration//GEN-END:variables
}
