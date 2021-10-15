/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_CDN;

import Biblioteca_entidades.Usuario;
import Capa_De_Datos.UsuarioCDD;
import Capa_De_Negocio.UsuarioCDN;

/**
 *
 * @author Aspire3
 */
public class test {
    Usuario u= new Usuario();
    UsuarioCDN ucdn = new UsuarioCDN();
    UsuarioCDD ucdd;
    
    static String nombre="testUser";
    static String apPat = "testAp";
    static String apMat ="testAm";
    static String correo = "Test@email.test";
    static int id=1234;
    static int nroTelefono = 111111111;
    static int id_tipo = 0;
    static String msj = "";
    
    public void crearTest(){
        u.setId_usuario(id);
        u.setNombre(nombre);
        u.setAp_pat(apPat);
        u.setAp_mat(apMat);
        u.setCorreo(correo);
        u.setNro_telefono(nroTelefono);
        u.setId_tipo(id_tipo);
        
        msj = ucdn.crear(u);
        System.out.println(msj);
    }
    public void eliminarTest(){
        msj = ucdn.eliminar(id);
        System.out.println(msj);
    }
    public void modificarTest(){
        u.setAp_pat(apPat+" Modificado");
        msj = ucdn.modificar(u);
    }
    
    public static void main(String[] args) {
        UsuarioCDN us = new UsuarioCDN();
        
        test t = new test();
        Usuario lista[] = us.leer();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i].toString());
        }
        try {
            //t.crearTest(); 
            //t.modificarTest();
            
            
            //t.eliminarTest();
            
            
        } catch (NullPointerException e) {
            System.out.println("Error: "+e);
        }
        
    }
}
