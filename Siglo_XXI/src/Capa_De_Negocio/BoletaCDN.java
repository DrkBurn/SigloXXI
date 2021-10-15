/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades. Boleta;
import Capa_De_Datos.Conexion;
import Capa_De_Datos. BoletaCDD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Aspire3
 */
    public class BoletaCDN
    {
        private String mensaje = "";
    private  BoletaCDD ocdd = new  BoletaCDD();

    public String crear( Boleta u) {
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

    public  Boleta[] leer() {
        Connection conn = Conexion.getConnection();
         Boleta data[]=ocdd.leer(conn);
        return data;
    }
    
    public  Boleta buscarId(int id) {
        Connection conn = Conexion.getConnection();
         Boleta data=ocdd.BuscarId(conn, id);
        return data;
    }

    public String modificar( Boleta u) {
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
