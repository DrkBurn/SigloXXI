/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Biblioteca_entidades.Stock_producto;
import Capa_De_Negocio.*;
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
public class Stock_productoCDD {

    String mensaje = "";

    //ingresa datos a la base de datos
    public String crear(Connection conn, Stock_producto sp) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "INSERT INTO stock_producto (id_producto,stock_disponible) VALUES "
                + "(?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, sp.getId_producto());
            pst.setInt(2, sp.getStock_disponible());

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
    public Stock_producto[] leer(Connection conn) {
        String sql = "Select count(id_producto) from stock_producto";
        Stock_producto sp = new Stock_producto();
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
        sql = "Select * from stock_producto order by id_producto";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Stock_producto data[] = new Stock_producto[n_arreglo];
            int posicion = 0;
            while (rs.next()) {

                data[posicion] = new Stock_producto();
                data[posicion].setId_producto(Integer.parseInt(rs.getString(1)));
                data[posicion].setStock_disponible(Integer.parseInt(rs.getString(2)));

                posicion++;
            }

            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //Buscar especifico
    public Stock_producto BuscarId(Connection conn, String id) {
        String sql;
        Statement st = null;
        ResultSet rs = null;

        sql = "Select * from stock_producto where id_producto = '" + id + "' order by id_producto";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Stock_producto sp = new Stock_producto();
            while (rs.next()) {

                sp.setId_producto(Integer.parseInt(rs.getString(1)));
                sp.setStock_disponible(Integer.parseInt(rs.getString(2)));
            }
            return sp;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //modifica datos especificos 
    public String modificar(Connection conn, Stock_producto sp) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "UPDATE stock_producto SET stock_disponible = ? WHERE id_producto = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(2, sp.getId_producto());
            pst.setInt(1, sp.getStock_disponible());

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
        String sql = "DELETE FROM stock_producto WHERE id_producto = ?";
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
