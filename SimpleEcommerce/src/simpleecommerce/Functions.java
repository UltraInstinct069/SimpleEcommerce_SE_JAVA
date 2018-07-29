package simpleecommerce;
/**
 *
 * @author Abrar Abir
 */
import java.awt.*;
public class Functions extends javax.swing.JFrame {
    /*====================================================================
    Default constructor
    ======================================================================*/
    public Functions() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAddProducts = new javax.swing.JButton();
        buttonUpdateProd = new javax.swing.JButton();
        buttonShowProd = new javax.swing.JButton();
        buttonDashboard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAddProducts.setText("Add Products");
        buttonAddProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProductsActionPerformed(evt);
            }
        });

        buttonUpdateProd.setText("Update Products");
        buttonUpdateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateProdActionPerformed(evt);
            }
        });

        buttonShowProd.setText("Show Products");
        buttonShowProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowProdActionPerformed(evt);
            }
        });

        buttonDashboard.setText("Dashboard");
        buttonDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(buttonAddProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonShowProd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonShowProd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProductsActionPerformed
        // Goto Add Product Frame
        new AddProduct().setVisible(true);
        
        
    }//GEN-LAST:event_buttonAddProductsActionPerformed

    private void buttonUpdateProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateProdActionPerformed
        // Goto Update Products frame
        new UpdateProducts().setVisible(true);
        
    }//GEN-LAST:event_buttonUpdateProdActionPerformed

    private void buttonShowProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowProdActionPerformed
        // Goto Show Products Frame
        new showProducts().setVisible(true);
        
    }//GEN-LAST:event_buttonShowProdActionPerformed

    private void buttonDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDashboardActionPerformed
        // Goto Dashboard Frame
        new DashBoard().setVisible(true);
        
    }//GEN-LAST:event_buttonDashboardActionPerformed

    
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
            java.util.logging.Logger.getLogger(Functions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Functions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Functions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Functions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Functions().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddProducts;
    private javax.swing.JButton buttonDashboard;
    private javax.swing.JButton buttonShowProd;
    private javax.swing.JButton buttonUpdateProd;
    // End of variables declaration//GEN-END:variables
}
