/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca_entidades;

import Capa_De_Negocio.*;

/**
 *
 * @author Aspire3
 */
    public class Producto
    {
        private int id_producto;
        private String nombre_producto;

        public int getId_producto()
        {
            return this.id_producto;
        }

        public void setId_producto(int id_producto)
        {
            this.id_producto = id_producto;
        }

        public String getNombre_producto()
        {
            return this.nombre_producto;
        }

        public void setNombre_producto(String nombre_producto)
        {
            this.nombre_producto = nombre_producto;
        }


    }
