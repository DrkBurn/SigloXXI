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
    public class Stock_producto
    {
        private int id_producto;
        private int stock_disponible;

        public int getId_producto()
        {
            return this.id_producto;
        }

        public void setId_producto(int id_producto)
        {
            this.id_producto = id_producto;
        }

        public int getStock_disponible()
        {
            return this.stock_disponible;
        }

        public void setStock_disponible(int stock_disponible)
        {
            this.stock_disponible = stock_disponible;
        }


    }

