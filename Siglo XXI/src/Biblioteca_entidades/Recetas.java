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
    public class Recetas
    {
        private int id_receta;
        private String nombre_receta;
        private String descripcion_cliente;
        private String instrucciones;
        private int tiempo_estimado;
        private int valor;

        public int getId_receta()
        {
            return this.id_receta;
        }

        public void setId_receta(int id_receta)
        {
            this.id_receta = id_receta;
        }

        public String getNombre_receta()
        {
            return this.nombre_receta;
        }

        public void setNombre_receta(String nombre_receta)
        {
            this.nombre_receta = nombre_receta;
        }

        public String getDescripcion_cliente()
        {
            return this.descripcion_cliente;
        }

        public void setDescripcion_cliente(String descripcion_cliente)
        {
            this.descripcion_cliente = descripcion_cliente;
        }

        public String getInstrucciones()
        {
            return this.instrucciones;
        }

        public void setInstrucciones(String instrucciones)
        {
            this.instrucciones = instrucciones;
        }

        public int getTiempo_estimado()
        {
            return this.tiempo_estimado;
        }

        public void setTiempo_estimado(int tiempo_estimado)
        {
            this.tiempo_estimado = tiempo_estimado;
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
