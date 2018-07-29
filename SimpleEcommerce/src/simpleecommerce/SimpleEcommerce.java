/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleecommerce;

/**
 *
 * @author Abrar Abir
 */
public class SimpleEcommerce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnect dbCon=new DBConnect();
        new UI().setVisible(true);
    }
    
}
