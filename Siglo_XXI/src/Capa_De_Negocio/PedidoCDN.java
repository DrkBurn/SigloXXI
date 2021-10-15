/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Pedido;
import Capa_De_Datos.PedidoCDD;
import Capa_De_Datos.Conexion;
import java.sql.Connection;

/**
 *
 * @author Aspire3
 */
    public class PedidoCDN
    {
        private String mensaje = "";
    private  PedidoCDD ocdd = new  PedidoCDD();

    public String crear( Pedido u) {
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

    public  Pedido[] leer() {
        Connection conn = Conexion.getConnection();
         Pedido data[]=ocdd.leer(conn);
        return data;
    }
    
    public  Pedido buscarId(int id) {
        Connection conn = Conexion.getConnection();
         Pedido data=ocdd.BuscarId(conn, id);
        return data;
    }

    public String modificar( Pedido u) {
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
