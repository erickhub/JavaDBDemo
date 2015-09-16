/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javadbdemo;
import java.sql.*;

/**
 *
 * @author 
 */
public class JavaDBDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try{
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TestDerby", "test", "test");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COLLEAGUES");

            while (rs.next()) {
            String first = rs.getString("firstName");
            String last = rs.getString("lastName");
            String email = rs.getString("email");
            System.out.println(first + " " + last + " " + email);
        }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
}
