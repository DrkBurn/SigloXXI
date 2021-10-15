/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Producto;
import Capa_De_Datos.ProductoCDD;
import Capa_De_Datos.Conexion;
import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
    public class ProductoCDN
    {
        private String mensaje = "";
    private  ProductoCDD ocdd = new  ProductoCDD();

    public String crear( Producto u) {
        Connection conn = Conexion.getConnection();
        try {
            
            mensaje = ocdd.crear(conn, u);

        } catch (Exception e) {
            mensaje = mensaje + " " + e;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e;
            }
        }
        return mensaje;
    }

    public  Producto[] leer() {
        Connection conn = Conexion.getConnection();
         Producto data[]=ocdd.leer(conn);
        return data;
    }
    
    public  Producto buscarId(int id) {
        Connection conn = Conexion.getConnection();
         Producto data=ocdd.BuscarId(conn, id);
        return data;
    }

    public String modificar( Producto u) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ocdd.modificar(conn, u);
            conn.commit();
        } catch (Exception e) {
            mensaje = mensaje + " " + e;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e;
            }
        }
        return mensaje;
    }

    public String eliminar(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ocdd.eliminar(conn, id);
            conn.commit();
        } catch (Exception e) {
            mensaje = mensaje + " " + e;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e;
            }
        }
        return mensaje;
    }
    }
