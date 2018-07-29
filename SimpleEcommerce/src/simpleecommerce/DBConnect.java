package simpleecommerce;

/**
 *
 * @author Abrar Abir
 */
import java.sql.*;
public class DBConnect {
    private Connection con;
    
    
    /*====================================================================
    Default constructor
    ======================================================================*/
    public DBConnect() {
        try{
            this.con= DriverManager.getConnection("jdbc:mysql://localhost/ecom","root","");
            
            
        }catch(Exception ex){
            System.out.println(ex);
            
        }
    }
    /*====================================================================
    Returning the connection
    ======================================================================*/
    public Connection getCon(){
        return this.con;
    }
}
