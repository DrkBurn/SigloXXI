/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Biblioteca_entidades.Boleta;
import Capa_De_Negocio.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aspire3
 */
public class BoletaCDD {

    String mensaje = "";

    //ingresa datos a la base de datos
    public String crear(Connection conn, Boleta b) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "INSERT INTO boleta (id_boleta,fecha_boleta,hora_boleta,id_pedido) VALUES "
                + "(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, b.getId_boleta());
            pst.setInt(4, b.getId_pedido());
            pst.setDate(2, b.getFecha_boleta());
            pst.setTime(3, b.getHora_boleta());

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
    public Boleta[] leer(Connection conn) {
        String sql = "Select count(id_boleta) from boleta";
        Boleta b = new Boleta();
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
        sql = "Select * from boleta order by id_boleta";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Boleta data[] = new Boleta[n_arreglo];
            int posicion = 0;
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("hh:mm a");
            while (rs.next()) {

                data[posicion] = new Boleta();
                data[posicion].setId_boleta(Integer.parseInt(rs.getString(1)));
                data[posicion].setFecha_boleta(rs.getDate(2));
                data[posicion].setHora_boleta(rs.getTime(3));
                data[posicion].setId_pedido(Integer.parseInt(rs.getString(4)));

                posicion++;
            }

            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //Buscar especifico
    public Boleta BuscarId(Connection conn, int id) {
        String sql;
        Statement st = null;
        ResultSet rs = null;

        sql = "Select * from boleta where id_boleta = '" + id + "' order by id_boleta";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Boleta b = new Boleta();
            while (rs.next()) {

                b.setId_boleta(Integer.parseInt(rs.getString(1)));
                b.setFecha_boleta(rs.getDate(2));
                b.setHora_boleta(rs.getTime(3));
                b.setId_pedido(Integer.parseInt(rs.getString(4)));
            }
            return b;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }

    }

    //modifica datos especificos 
    public String modificar(Connection conn, Boleta b) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "UPDATE boleta SET fecha_boleta = ?, hora_boleta = ?, id_pedido = ? WHERE id_boleta = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(4, b.getId_boleta());
            pst.setDate(1, b.getFecha_boleta());
            pst.setTime(2, b.getHora_boleta());
            pst.setInt(3, b.getId_pedido());

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
        String sql = "DELETE FROM boleta WHERE id_boleta = ?";
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
