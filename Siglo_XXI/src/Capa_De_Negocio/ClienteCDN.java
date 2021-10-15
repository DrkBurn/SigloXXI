/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Cliente;
import Capa_De_Datos.ClienteCDD;
import Capa_De_Datos.Conexion;
import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
    public class ClienteCDN
    {
        private String mensaje = "";
    private  ClienteCDD ocdd = new  ClienteCDD();

    public String crear( Cliente u) {
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

    public  Cliente[] leer() {
        Connection conn = Conexion.getConnection();
         Cliente data[]=ocdd.leer(conn);
        return data;
    }
    
    public  Cliente buscarId(int id) {
        Connection conn = Conexion.getConnection();
         Cliente data=ocdd.BuscarId(conn, id);
        return data;
    }

    public String modificar( Cliente u) {
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
