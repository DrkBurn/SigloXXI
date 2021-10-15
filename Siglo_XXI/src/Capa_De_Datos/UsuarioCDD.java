/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Biblioteca_entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aspire3
 */
public class UsuarioCDD {

    String mensaje = "";
    //ingresa datos a la base de datos
    public String crear(Connection conn, Usuario u) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "INSERT INTO usuario (id_usuario,nombre,ap_pat,ap_mat,correo,nro_telefono,id_tipo) VALUES "
                + "(?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, u.getId_usuario());
            pst.setInt(6, u.getNro_telefono());
            pst.setInt(7, u.getId_tipo());
            pst.setString(2, u.getNombre());
            pst.setString(3, u.getAp_pat());
            pst.setString(4, u.getAp_mat());
            pst.setString(5, u.getCorreo());

            pst.execute();
            pst.close();
            mensaje = "Operacion Exitosa";
        } catch (Exception e) {
            mensaje = "Error: " + e;
        }
        return mensaje;
    }
    //leer datos para una tabla
    public void leerTabla(Connection conn, JTable tbl) {
        DefaultTableModel model;
        String[] columnas = {"Rut", "Nombre", "Apellido paterno", "Apellido materno", "Correo", "Nro telefonico", "Tipo de usuario"};
        model = new DefaultTableModel(null, columnas);
        String sql = "Select * from usuario order by id_usuario";
        String[] fila = new String[7];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                model.addRow(fila);
            }
            tbl.setModel(model);
        } catch (Exception e) {
        }

    }
    //devuelve arreglo de datos
    public Usuario[] leer(Connection conn) {
        String sql = "Select count(id_usuario) from usuario order by id_usuario";
        Usuario u = new Usuario();
        Statement st = null;
        ResultSet rs = null;
        int n_arreglo = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);      
            while (rs.next()) {
                n_arreglo = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        sql = "Select * from usuario order by id_usuario";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Usuario data[] = new Usuario[n_arreglo];
            int posicion = 0;
            while (rs.next()) {
                
                data[posicion]=new Usuario();
                data[posicion].setId_usuario(Integer.parseInt(rs.getString(1)));
                data[posicion].setNombre(rs.getString(2));
                data[posicion].setAp_pat(rs.getString(3));
                data[posicion].setAp_mat(rs.getString(4));
                data[posicion].setCorreo(rs.getString(5));
                data[posicion].setNro_telefono(Integer.parseInt(rs.getString(6)));
                data[posicion].setId_tipo(Integer.parseInt(rs.getString(7)));
                posicion ++;
            }
            
            return data;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }

    }
    //Buscar especifico
    public Usuario BuscarId(Connection conn, String id) {
        String sql = "Select count(id_usuario) from usuario where id_usuario = '"+id+"' order by id_usuario";
        Statement st = null;
        ResultSet rs = null;
        
        sql = "Select * from usuario where id_usuario = '"+id+"' order by id_usuario";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Usuario u =new Usuario();
            while (rs.next()) {
                
                
                u.setId_usuario(Integer.parseInt(rs.getString(1)));
                u.setNombre(rs.getString(2));
                u.setAp_pat(rs.getString(3));
                u.setAp_mat(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setNro_telefono(Integer.parseInt(rs.getString(6)));
                u.setId_tipo(Integer.parseInt(rs.getString(7)));  
            }
            return u;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }

    }
    //modifica datos especificos 
    public String modificar(Connection conn, Usuario u) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "UPDATE usuario SET nombre = ?,ap_pat = ?, ap_mat = ?,correo = ?, nro_telefono = ?, id_tipo = ? WHERE id_usuario = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(7, u.getId_usuario());
            pst.setInt(5, u.getNro_telefono());
            pst.setInt(6, u.getId_tipo());
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getAp_pat());
            pst.setString(3, u.getAp_mat());
            pst.setString(4, u.getCorreo());

            pst.execute();
            pst.close();
            mensaje = "Operacion Exitosa";
        } catch (Exception e) {
            mensaje = "Error: " + e;
        }
        return mensaje;
    }
    //elimina datos de la base de datos
    public String eliminar(Connection conn, int id) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();
            pst.close();
            mensaje = "Operacion Exitosa";
        } catch (Exception e) {
            mensaje = "Error: " + e;
        }
        return mensaje;
    }
}
