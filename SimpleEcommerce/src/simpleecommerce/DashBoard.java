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
public class DashBoard extends javax.swing.JFrame {
    /*====================================================================
    Database Connection varibales
    ======================================================================*/
    private Connection con;
    private PreparedStatement statement;
    private Statement st;
    private ResultSet rs;
    
    /*====================================================================
    Default constructor
    ======================================================================*/
    
    public DashBoard() {
        initComponents();
        updateTable(); // Update the top 5 product table
        updateSoldProductTable(); // Update the sold product table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTopProducts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSoldProducts = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        CountSoldProducts = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Top 5 products :");

        tableTopProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableTopProducts);

        jLabel2.setText("Sold Products:");

        tableSoldProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableSoldProducts);

        jLabel3.setText("Total Product sales: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CountSoldProducts)
                        .addGap(157, 157, 157))))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(533, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CountSoldProducts))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*====================================================================
    Getting the top 5 profitable product
    ======================================================================*/
    public void updateTable(){
        try{
        //Database Connection    
        DBConnect databaseConnection=new DBConnect();
        con=databaseConnection.getCon();
        st=con.createStatement();
        
        //query for getting top 5 product
        String query="SELECT Name,ProductType,Price,ProfitPercentage*Price AS \"Profit\" FROM product ORDER by ProfitPercentage*Price DESC LIMIT 5";
        rs=st.executeQuery(query);
        
        //putting the result into the table
        tableTopProducts.setModel(DbUtils.resultSetToTableModel(rs));                    
        
        //closing the connection
        st.close();
        con.close();
        }catch(Exception e){
            //If database cant load
            JOptionPane.showMessageDialog(rootPane,"Failed to load the database");
            System.out.println(e);
        }
    }
    
    /*====================================================================
    Sold Products information
    ======================================================================*/
    public void updateSoldProductTable(){
        try{
        //Database Connection
        DBConnect databaseConnection=new DBConnect();
        con=databaseConnection.getCon();
        st=con.createStatement();
        
        
        /*====================================================================
        getting the number of product sold and show them on bottom
        ======================================================================*/
        String query="select count(*) AS \"Count\"  from productsolds";
        rs=st.executeQuery(query);
        int count=0;
        if(rs.next())
        count = Integer.parseInt(rs.getString("Count")) ;
        
        System.out.println(count);
        CountSoldProducts.setText(Integer.toString(count));
        
        /*====================================================================
        getting the information of sold products
        ======================================================================*/
        query="SELECT Name,ProductType,Price,Profit FROM productsolds";
        rs=st.executeQuery(query);
        
        //putting result on the table
        tableSoldProducts.setModel(DbUtils.resultSetToTableModel(rs));                    
        
        //closing the connection
        st.close();
        con.close();
        
        }catch(Exception e){
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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CountSoldProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableSoldProducts;
    private javax.swing.JTable tableTopProducts;
    // End of variables declaration//GEN-END:variables
}
