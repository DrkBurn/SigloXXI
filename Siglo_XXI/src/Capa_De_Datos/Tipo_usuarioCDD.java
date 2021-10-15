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
    public class Tipo_usuarioCDD
    {
        public int id_tipo;
        public String nombre_tipo;

        public int getId_tipo()
        {
            return this.id_tipo;
        }

        public void setId_tipo(int id_tipo)
        {
            this.id_tipo = id_tipo;
        }

        public String getNombre_tipo()
        {
            return this.nombre_tipo;
        }

        public void setNombre_tipo(String nombre_tipo)
        {
            this.nombre_tipo = nombre_tipo;
        }


    }

