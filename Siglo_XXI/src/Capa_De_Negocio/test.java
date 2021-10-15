/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Usuario;
import Capa_De_Datos.Conexion;
import Capa_De_Datos.UsuarioCDD;
import Capa_De_Negocio.UsuarioCDN;
import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
public class test {
    Usuario u;
    UsuarioCDN ucdn;
    String msj = "";
    public void crearTest(){
        
        msj = ucdn.crear(u);
    }
    
    public static void main(String[] args) {
        
        try {
            test t = new test();
            t.crearTest();
        } catch (Exception e) {System.out.println("Error: "+e);
        }
        
    }
    
    
    
}
