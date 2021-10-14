/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Biblioteca_entidades.Detalle_boleta;
import Capa_De_Negocio.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aspire3
 */
public class Detalle_boletaCDD {

    String mensaje = "";

    //ingresa datos a la base de datos
    public String crear(Connection conn, Detalle_boleta db) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "INSERT INTO detalle_boleta (id_boleta,producto,valor) VALUES "
                + "(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, db.getId_boleta());
            pst.setString(2, db.getProducto());
            pst.setInt(3, db.getValor());

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
    public Detalle_boleta[] leer(Connection conn) {
        String sql = "Select count(id_boleta) from detalle_boleta";
        Detalle_boleta db = new Detalle_boleta();
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
            System.out.println("Error: " + e);
        }
        sql = "Select * from detalle_boleta order by id_boleta";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Detalle_boleta data[] = new Detalle_boleta[n_arreglo];
            int posicion = 0;
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("hh:mm a");
            while (rs.next()) {

                data[posicion] = new Detalle_boleta();
                data[posicion].setId_boleta(Integer.parseInt(rs.getString(1)));
                data[posicion].setProducto(rs.getString(2));
                data[posicion].setValor(Integer.parseInt(rs.getString(3)));

                posicion++;
            }

            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //Buscar especifico
    public Detalle_boleta BuscarId(Connection conn, int id) {
        String sql;
        Statement st = null;
        ResultSet rs = null;

        sql = "Select * from detalle_boleta where id_boleta = '" + id + "' order by id_boleta";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Detalle_boleta db = new Detalle_boleta();
            while (rs.next()) {

                db.setId_boleta(Integer.parseInt(rs.getString(1)));
                db.setProducto(rs.getString(2));
                db.setValor(Integer.parseInt(rs.getString(3)));

            }
            return db;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //modifica datos especificos 
    public String modificar(Connection conn, Detalle_boleta db) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "UPDATE detalle_boleta SET producto = ?, valor = ?, id_pedido = ? WHERE id_boleta = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(3, db.getId_boleta());
            pst.setString(1, db.getProducto());
            pst.setInt(2, db.getValor());

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
        String sql = "DELETE FROM detalle_boleta WHERE id_boleta = ?";
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
