package simpleecommerce;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author Abrar Abir
 */
public class ButtonEditor extends DefaultCellEditor
{
  protected JButton btn;
   private String lbl;
   private Boolean clicked;
   private Connection con;
    
   /*====================================================================
    Database Connection variables
    ======================================================================*/
    private Statement st;
    private ResultSet rs;
    private String getRowID;
    private PreparedStatement pst=null;

    
    
    
   public ButtonEditor(JTextField txt) {
    super(txt);

    btn=new JButton();
    btn.setOpaque(true);

    //WHEN BUTTON IS CLICKED
    btn.addActionListener(new ActionListener() {

      
      public void actionPerformed(ActionEvent e) {

        fireEditingStopped();
      }
    });
  }

   //OVERRIDE A COUPLE OF METHODS
   
  public Component getTableCellEditorComponent(JTable table, Object obj,
      boolean selected, int row, int col) {

      //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
     lbl=(obj==null) ? "":obj.toString();
     btn.setText(lbl);
     clicked=true;
    return btn;
  }

  //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
   @Override
  
   /*====================================================================
    Deleting data from the database when delete button is clicked
    ======================================================================*/
   public Object getCellEditorValue() {

     if(clicked)
      {
        //get the row ID from showProducts.java
        getRowID=showProducts.getRow();        
        //testing purpose code
        System.out.println(getRowID);
        //JOptionPane.showMessageDialog(btn, lbl+" Item Deleted "+getRowID);
        try{ 
         //Database connection
         DBConnect databaseConnection=new DBConnect();
         con=databaseConnection.getCon();
        
         /*====================================================================
        when deleting a data stor the data first at soldproducts table
        ======================================================================*/       
         String Name="",ProductType="";
         float Price=0,profit=0; 
         
         //query to get selected item
         String sql="select * from product where ID=?";
         pst=con.prepareCall(sql);
         pst.setString(1, getRowID);
         rs=pst.executeQuery();
         
         //getting the information about deleting products
         if(rs.next()){ 
             Name=rs.getString("Name");
             ProductType=rs.getString("ProductType");
             Price=Float.parseFloat(rs.getString("Price"));
             profit=Float.parseFloat(rs.getString("ProfitPercentage"))*Price;
         }
         
        //Inserting data
        pst=con.prepareStatement("insert into productsolds (Name,ProductType,Price,Profit) values (?,?,?,?)");
        pst.setString(1, Name);
        pst.setString(2, ProductType);
        pst.setFloat(3, Price);
        pst.setFloat(4, profit);
        pst.executeUpdate();
        pst.close();
        
        //Deletig Data
        sql="delete from product where ID=?";
        pst=con.prepareCall(sql);
        pst.setString(1, getRowID);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(editorComponent,"Item Deleted..please refresh to see the change");
        //closing connection
        con.close();
        
         }catch( Exception e){ 
             JOptionPane.showMessageDialog(editorComponent,"Failed to delete the data");
             System.out.println(e);
         }
        new showProducts().showProductTable();
      }
    //SET IT TO FALSE NOW THAT ITS CLICKED
    clicked=false;
    return new String(lbl);
  }

   @Override
  public boolean stopCellEditing() {

         //SET CLICKED TO FALSE FIRST
      clicked=false;
    return super.stopCellEditing();
  }

   @Override
  protected void fireEditingStopped() {
    // TODO Auto-generated method stub
    super.fireEditingStopped();
  }
}
