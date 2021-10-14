/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siglo.xxi;

import java.util.LinkedList;

/**
 *
 * @author Aspire3
 */
public class SigloXXI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        
        
        
        
        try{
            Conexion query = new Conexion();
            String consulta = "SELECT * FROM RESTAURANT.USUARIO";
            LinkedList<String> resultado = query.query(consulta);
            
            for (int i = 0; i < resultado.size(); i++) {
                System.out.println(resultado.get(i));
            }
        
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
