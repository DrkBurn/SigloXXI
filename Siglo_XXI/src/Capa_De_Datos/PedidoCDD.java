/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Biblioteca_entidades.Pedido;
import Biblioteca_entidades.Pedido;
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
    public class PedidoCDD
    {
       String mensaje = "";
    //ingresa datos a la base de datos
    public String crear(Connection conn, Pedido sp) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "INSERT INTO pedido (id_pedido,numero_mesa) VALUES "
                + "(?,?)";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, sp.getId_pedido());
            pst.setInt(2, sp.getNumero_mesa());
           

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
    public Pedido[] leer(Connection conn) {
        String sql = "Select count(id_pedido) from pedido";
        Pedido pe = new Pedido();
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
        sql = "Select * from pedido order by id_pedido";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Pedido data[] = new Pedido[n_arreglo];
            int posicion = 0;
            while (rs.next()) {
                
                data[posicion]=new Pedido();
                data[posicion].setId_pedido(Integer.parseInt(rs.getString(1)));
                data[posicion].setNumero_mesa(Integer.parseInt(rs.getString(2)));
                
                posicion ++;
            }
            
            return data;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }

    }
    //Buscar especifico
    public Pedido BuscarId(Connection conn, int id) {
        String sql ;
        Statement st = null;
        ResultSet rs = null;
        
        sql = "Select * from pedido where id_pedido = '"+id+"' order by id_pedido";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Pedido sp =new Pedido();
            while (rs.next()) {
                
                
                sp.setId_pedido(Integer.parseInt(rs.getString(1)));
                sp.setNumero_mesa(Integer.parseInt(rs.getString(2))); 
            }
            return sp;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }

    }
    //modifica datos especificos 
    public String modificar(Connection conn, Pedido sp) {
        mensaje = "";
        PreparedStatement pst = null;
        String sql = "UPDATE pedido SET numero_mesa = ? WHERE id_pedido = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(2, sp.getId_pedido());
            pst.setInt(1, sp.getNumero_mesa());
            

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
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
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
