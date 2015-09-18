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
public class JavaDBCreate {
    
    public void dropTable(Statement stmt){
        try{
            String query = "  DROP TABLE PERSON";
            
            stmt.executeUpdate(query);
        }catch(SQLException e){
            System.err.println("Drop ERROR: " + e);
        }
    }
    
    public void createTable(Statement stmt){
        try{
            String query = "  CREATE TABLE PERSON(" +
                           "  \"CI\" INTEGER not null primary key," +
                           "  \"NAME\" VARCHAR(100) not null)";
            
            stmt.executeUpdate(query);
        }catch(SQLException e){
            System.err.println("Create ERROR: " + e);
        }
    }
    
    public void insertData(Statement stmt, String query){
        try{
            stmt.executeUpdate(query);
        }catch(SQLException e){
            System.err.println("Insert ERROR: " + e);
        }
    }
    
    public void updateData(Statement stmt, String query){
        try{
            stmt.executeUpdate(query);
        }catch(SQLException e){
            System.err.println("Update ERROR: " + e);
        }
    }
    
    public void showAllData(Statement stmt){
        try{
            ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON");
            System.out.println("===================================");
            
            while (rs.next()) {
                String ci = rs.getString("ci");
                String name = rs.getString("name");
                System.out.println(ci + " " + name);
            }
        }catch(SQLException e){
            System.err.println("Show Data ERROR: " + e);
        }
    }
}
