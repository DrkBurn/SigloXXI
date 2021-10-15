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
    public class Pedido
    {
        private int id_pedido;
        private int numero_mesa;

        public int getId_pedido()
        {
            return this.id_pedido;
        }

        public void setId_pedido(int id_pedido)
        {
            this.id_pedido = id_pedido;
        }

        public int getNumero_mesa()
        {
            return this.numero_mesa;
        }

        public void setNumero_mesa(int numero_mesa)
        {
            this.numero_mesa = numero_mesa;
        }


    }
