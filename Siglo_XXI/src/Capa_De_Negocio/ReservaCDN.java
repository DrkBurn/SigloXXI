/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

import java.sql.Date;

/**
 *
 * @author Aspire3
 */
    public class ReservaCDN
    {
        private int numero_de_mesa;
        private Date fecha_hora;
        private String correo_cliente;


        public int getNumero_de_mesa()
        {
            return this.numero_de_mesa;
        }

        public void setNumero_de_mesa(int numero_de_mesa)
        {
            this.numero_de_mesa = numero_de_mesa;
        }

        public Date getFecha_hora()
        {
            return this.fecha_hora;
        }

        public void setFecha_hora(Date fecha_hora)
        {
            this.fecha_hora = fecha_hora;
        }

        public String getCorreo_cliente()
        {
            return this.correo_cliente;
        }

        public void setCorreo_cliente(String correo_cliente)
        {
            this.correo_cliente = correo_cliente;
        }

    }

