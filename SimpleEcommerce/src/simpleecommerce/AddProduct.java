package simpleecommerce;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Abrar Abir
 */
public class AddProduct extends javax.swing.JFrame {
    /*====================================================================
    Product information variables
    ======================================================================*/
    private String prodName;
    private String prodType;
    private float prodPrice;
    private float prodProfit;
    
    /*====================================================================
    Database connection variables
    ======================================================================*/
    private Connection con;
    private PreparedStatement statement;
    private Statement st;
    private ResultSet rs;
    
    
    /*====================================================================
    Default constructor
    ======================================================================*/
    public AddProduct() {
        initComponents();
        updateTable();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productProfit = new javax.swing.JTextField();
        buttonAddProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        productType = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Name :");

        jLabel2.setText("Product Type :");

        jLabel3.setText("Price :");

        jLabel4.setText("Profit Percentage:");

        buttonAddProduct.setText("Add Product");
        buttonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProductActionPerformed(evt);
            }
        });

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableProduct);

        productType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RAM", "MOTHERBOARD", "GRAPHICS CARD" }));

        jLabel5.setText("Please Enter all the information");

        jLabel6.setText("%");

        jLabel7.setText("Products");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAddProduct)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(productName)
                                        .addComponent(productPrice)
                                        .addComponent(productProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addComponent(productType, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(productProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addComponent(buttonAddProduct)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*====================================================================
    Adding new Product to database
    ======================================================================*/
    private void buttonAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProductActionPerformed
        
    /*====================================================================
    Getting Input from Textfields
    ======================================================================*/
        prodName=productName.getText();
        if(prodName.isEmpty())
            JOptionPane.showMessageDialog(rootPane,"Please Enter the name"); //Check if the textfield is empty or not
        
        try{ 
        prodType=productType.getSelectedItem().toString();
        }catch(Exception e){  
            JOptionPane.showMessageDialog(rootPane,"Please Enter correct price value");
        }
        
        try{  
        prodPrice=Float.parseFloat(productPrice.getText());
        }catch(Exception e){  
            JOptionPane.showMessageDialog(rootPane,"Please Enter correct price value");
        }
        try{
        prodProfit=Float.parseFloat(productProfit.getText());
        }catch(Exception e){  
            JOptionPane.showMessageDialog(rootPane,"Please Enter correct percentage value");
        }
        prodProfit=prodProfit/100;
        
        prodName=productName.getText();
        
        if(!prodName.isEmpty()){
        try{
        //Database Connection
        DBConnect databaseConnection=new DBConnect();
        con=databaseConnection.getCon();
        
        //Database query to insert data
        statement=con.prepareStatement("insert into product (Name,ProductType,Price,ProfitPercentage) values (?,?,?,?)");
        statement.setString(1, prodName);
        statement.setString(2, prodType);
        statement.setFloat(3, prodPrice);
        statement.setFloat(4, prodProfit);
        statement.executeUpdate();
        statement.close();
        con.close();
        }catch(Exception e){
            //In case of fail to insert the data
            JOptionPane.showMessageDialog(rootPane,"Failed to insert Product Information");
            System.out.println(e);
        }
        /*====================================================================
        Update the table after inserting any data.
        ======================================================================*/
        updateTable();
    }//GEN-LAST:event_buttonAddProductActionPerformed
    }
    
    /*====================================================================
    To show data on the table
    ======================================================================*/
    public void updateTable()
    {
    try{
        // Database connection
        DBConnect databaseConnection=new DBConnect();
        con=databaseConnection.getCon();
        st=con.createStatement();
        
        // Selection query
        String query="select Name,ProductType,Price,ProfitPercentage from product";
        rs=st.executeQuery(query);
        
        //Putting the results of the query on table
        tableProduct.setModel(DbUtils.resultSetToTableModel(rs));
        
        //close all connection
        st.close();
        con.close();
        }catch(Exception e){
            //If cant retrieve data from the database
            JOptionPane.showMessageDialog(rootPane,"Failed to load the database");
            System.out.println(e);
        }
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
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduct().setVisible(true);
                
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField productPrice;
    private javax.swing.JTextField productProfit;
    private javax.swing.JComboBox productType;
    private javax.swing.JTable tableProduct;
    // End of variables declaration//GEN-END:variables
}
