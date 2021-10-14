/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca_entidades;

import Capa_De_Negocio.*;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Aspire3
 */
    public class Boleta
    {
        private int id_boleta;
        private Date fecha_boleta;
        private Time hora_boleta;
        private int id_pedido;

        public int getId_boleta()
        {
            return this.id_boleta;
        }

        public void setId_boleta(int id_boleta)
        {
            this.id_boleta = id_boleta;
        }

        public Date getFecha_boleta()
        {
            return this.fecha_boleta;
        }

        public void setFecha_boleta(Date fecha_boleta)
        {
            this.fecha_boleta = fecha_boleta;
        }

        public Time getHora_boleta()
        {
            return this.hora_boleta;
        }

        public void setHora_boleta(Time hora_boleta)
        {
            this.hora_boleta = hora_boleta;
        }

        public int getId_pedido()
        {
            return this.id_pedido;
        }

        public void setId_pedido(int id_pedido)
        {
            this.id_pedido = id_pedido;
        }


        public Boleta()
        {
        }



    }
