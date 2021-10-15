/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siglo.xxi;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Aspire3
 */
public class Conexion {
    public Conexion(){
        
    }
    public Statement conn(){
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Conectando a la base de datos ");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","restaurant","1234");
            Statement statement = connection.createStatement();
            if (connection != null) {
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Error de conexion");
            }
            return statement;
        }
        catch(Exception e){
            System.out.println("Ocurrio el siguiente error: "+e);
            return null;
        }
    }
    public LinkedList<String> query(String from){
        try{
            Statement st = conn();
            ResultSet resultSet = st.executeQuery(from);
            
            LinkedList<String> result = new LinkedList();
            while(resultSet.next()){
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    result.add(resultSet.getString(i));
                }
            }
            return result;
        }
        catch(SQLException e){
            System.out.println("Error: "+e);
            return null;
        }
    }
    
}
