/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Mesa;
import Capa_De_Datos.MesaCDD;
import Capa_De_Datos.Conexion;
import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
    public class MesaCDN
    {
        private String mensaje = "";
    private  MesaCDD ocdd = new  MesaCDD();

    public String crear( Mesa u) {
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

    public  Mesa[] leer() {
        Connection conn = Conexion.getConnection();
         Mesa data[]=ocdd.leer(conn);
        return data;
    }
    
    public  Mesa buscarId(int id) {
        Connection conn = Conexion.getConnection();
         Mesa data=ocdd.BuscarId(conn, id);
        return data;
    }

    public String modificar( Mesa u) {
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

