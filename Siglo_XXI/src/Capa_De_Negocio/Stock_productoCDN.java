/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Stock_producto;
import Capa_De_Datos.Conexion;
import Capa_De_Datos.Stock_productoCDD;

import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
    public class Stock_productoCDN
    {
        private String mensaje = "";
    private Stock_productoCDD spcdd = new Stock_productoCDD();

    public String crear(Stock_producto sp) {
        Connection conn = Conexion.getConnection();
        try {
            
            mensaje = spcdd.crear(conn, sp);

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

    public Stock_producto[] leer() {
        Connection conn = Conexion.getConnection();
        Stock_producto data[]=spcdd.leer(conn);
        return data;
    }
    
    public Stock_producto buscarId(String id) {
        Connection conn = Conexion.getConnection();
        Stock_producto data=spcdd.BuscarId(conn, id);
        return data;
    }

    public String modificar(Stock_producto sp) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = spcdd.modificar(conn, sp);
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
            mensaje = spcdd.eliminar(conn, id);
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

