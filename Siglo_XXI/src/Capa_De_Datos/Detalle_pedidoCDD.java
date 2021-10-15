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
    public class Detalle_pedidoCDD
    {
        private int id_pedido;
        private int id_receta;
        private String detalles_del_pedido;


        public int getId_pedido()
        {
            return this.id_pedido;
        }

        public void setId_pedido(int id_pedido)
        {
            this.id_pedido = id_pedido;
        }

        public int getId_receta()
        {
            return this.id_receta;
        }

        public void setId_receta(int id_receta)
        {
            this.id_receta = id_receta;
        }

        public String getDetalles_del_pedido()
        {
            return this.detalles_del_pedido;
        }

        public void setDetalles_del_pedido(String detalles_del_pedido)
        {
            this.detalles_del_pedido = detalles_del_pedido;
        }

    }

