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
    public class Flujo_cajaCDN
    {
        private Date dia;
        private int ingresos;
        private int egresos;
        private int total_facturado;

        public Date getDia()
        {
            return this.dia;
        }

        public void setDia(Date dia)
        {
            this.dia = dia;
        }

        public int getIngresos()
        {
            return this.ingresos;
        }

        public void setIngresos(int ingresos)
        {
            this.ingresos = ingresos;
        }

        public int getEgresos()
        {
            return this.egresos;
        }

        public void setEgresos(int egresos)
        {
            this.egresos = egresos;
        }

        public int getTotal_facturado()
        {
            return this.total_facturado;
        }

        public void setTotal_facturado(int total_facturado)
        {
            this.total_facturado = total_facturado;
        }


    }

