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
    public class Detalle_boleta
    {
        private int id_boleta;
        private String producto;
        private int valor;

        public int getId_boleta()
        {
            return this.id_boleta;
        }

        public void setId_boleta(int id_boleta)
        {
            this.id_boleta = id_boleta;
        }

        public String getProducto()
        {
            return this.producto;
        }

        public void setProducto(String producto)
        {
            this.producto = producto;
        }

        public int getValor()
        {
            return this.valor;
        }

        public void setValor(int valor)
        {
            this.valor = valor;
        }

    }

