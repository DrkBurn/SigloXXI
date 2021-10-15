/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Biblioteca_entidades.Cliente;
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
public class ClienteCDD {

    String mensaje = "";

    //ingresa datos a la base de datos
    public String crear(Connection conn, Cliente c) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "INSERT INTO cliente (correo_cliente,nombre_cliente,apellidos_cliente, contrasena) VALUES "
                + "(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, c.getCorreo_cliente());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getApellidos());
            pst.setString(4, c.getContraseñA());
            
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
    public Cliente[] leer(Connection conn) {
        String sql = "Select count(correo_cliente) from cliente";
        Cliente c = new Cliente();
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
        sql = "Select * from cliente order by correo_cliente";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Cliente data[] = new Cliente[n_arreglo];
            int posicion = 0;
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("hh:mm a");
            while (rs.next()) {

                data[posicion] = new Cliente();
                data[posicion].setCorreo_cliente(rs.getString(1));
                data[posicion].setNombre(rs.getString(2));
                data[posicion].setApellidos(rs.getString(3));
                data[posicion].setContraseñA(rs.getString(4));
                posicion++;
            }

            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //Buscar especifico
    public Cliente BuscarId(Connection conn, int id) {
        String sql;
        Statement st = null;
        ResultSet rs = null;

        sql = "Select * from cliente where correo_cliente = '" + id + "' order by correo_cliente";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Cliente c = new Cliente();
            while (rs.next()) {

                c.setCorreo_cliente(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setContraseñA(rs.getString(4));

            }
            return c;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //modifica datos especificos 
    public String modificar(Connection conn, Cliente c) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "UPDATE cliente SET nombre_cliente = ?, valor = ?, id_pedido = ? WHERE correo_cliente = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, c.getCorreo_cliente());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getApellidos());
            pst.setString(4, c.getContraseñA());

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
        String sql = "DELETE FROM cliente WHERE correo_cliente = ?";
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
