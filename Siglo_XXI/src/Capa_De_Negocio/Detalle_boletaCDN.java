/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Detalle_boleta;
import Capa_De_Datos.Detalle_boletaCDD;
import Capa_De_Datos.Conexion;
import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
    public class Detalle_boletaCDN
    {
        private String mensaje = "";
    private  Detalle_boletaCDD ocdd = new  Detalle_boletaCDD();

    public String crear( Detalle_boleta u) {
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

    public  Detalle_boleta[] leer() {
        Connection conn = Conexion.getConnection();
         Detalle_boleta data[]=ocdd.leer(conn);
        return data;
    }
    
    public  Detalle_boleta buscarId(int id) {
        Connection conn = Conexion.getConnection();
         Detalle_boleta data=ocdd.BuscarId(conn, id);
        return data;
    }

    public String modificar( Detalle_boleta u) {
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

