/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import Biblioteca_entidades.Usuario;
import Capa_De_Datos.Conexion;
import Capa_De_Datos.UsuarioCDD;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Aspire3
 */
public class UsuarioCDN {

    private String mensaje = "";
    private UsuarioCDD ucdd = new UsuarioCDD();

    public String crear(Usuario u) {
        Connection conn = Conexion.getConnection();
        try {
            
            mensaje = ucdd.crear(conn, u);

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

    public Usuario[] leer() {
        Connection conn = Conexion.getConnection();
        Usuario data[]=ucdd.leer(conn);
        return data;
    }
    
    public Usuario buscarId(String id) {
        Connection conn = Conexion.getConnection();
        Usuario data=ucdd.BuscarId(conn, id);
        return data;
    }

    public String modificar(Usuario u) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = ucdd.modificar(conn, u);
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
            mensaje = ucdd.eliminar(conn, id);
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
