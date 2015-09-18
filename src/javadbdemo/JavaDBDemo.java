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

    public static boolean initConnection(){
        try{
             //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             return true;
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(initConnection()){
            try{
                JavaDBCreate createDB = new JavaDBCreate();
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TestDerby", "test", "test");
                Statement stmt = con.createStatement();
                
                createDB.dropTable(stmt);
                createDB.createTable(stmt);
                createDB.insertData(stmt, "INSERT INTO PERSON VALUES (1001, 'Juan Carlos Garcia')");
                createDB.insertData(stmt, "INSERT INTO PERSON VALUES (1002, 'Jerson Gomez')");
                createDB.insertData(stmt, "INSERT INTO PERSON VALUES (1003, 'Juana Lopez')");
                createDB.showAllData(stmt);
                createDB.updateData(stmt, "UPDATE PERSON SET NAME='Jhon Montez' WHERE CI=1002");
                createDB.showAllData(stmt);
                
            }catch(SQLException e){
                System.err.println("ERROR: " + e);
            }
        }
    }
    
}
