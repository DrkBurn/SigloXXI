/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Datos;

import Capa_De_Negocio.*;

/**
 *
 * @author Aspire3
 */
    public class Detalle_recetaCDD
    {
        private int detalle_receta;
        private int id_producto;
        private int cantidad;

        public int getDetalle_receta()
        {
            return this.detalle_receta;
        }

        public void setDetalle_receta(int detalle_receta)
        {
            this.detalle_receta = detalle_receta;
        }

        public int getId_producto()
        {
            return this.id_producto;
        }

        public void setId_producto(int id_producto)
        {
            this.id_producto = id_producto;
        }

        public int getCantidad()
        {
            return this.cantidad;
        }

        public void setCantidad(int cantidad)
        {
            this.cantidad = cantidad;
        }


    }

