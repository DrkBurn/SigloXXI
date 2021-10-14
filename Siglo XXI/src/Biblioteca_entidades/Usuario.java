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
    public class Usuario
    {
        private int id_usuario;
        private String nombre;
        private String ap_pat;
        private String ap_mat;
        private String correo;
        private int nro_telefono;
        private int id_tipo;

    
    
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", ap_pat=" + ap_pat + ", ap_mat=" + ap_mat + ", correo=" + correo + ", nro_telefono=" + nro_telefono + ", id_tipo=" + id_tipo + '}';
    }
        
        public int getId_usuario()
        {
            return this.id_usuario;
        }

        public void setId_usuario(int id_usuario)
        {
            this.id_usuario = id_usuario;
        }

        public String getNombre()
        {
            return this.nombre;
        }

        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }

        public String getAp_pat()
        {
            return this.ap_pat;
        }

        public void setAp_pat(String ap_pat)
        {
            this.ap_pat = ap_pat;
        }

        public String getAp_mat()
        {
            return this.ap_mat;
        }

        public void setAp_mat(String ap_mat)
        {
            this.ap_mat = ap_mat;
        }

        public String getCorreo()
        {
            return this.correo;
        }

        public void setCorreo(String correo)
        {
            this.correo = correo;
        }

        public int getNro_telefono()
        {
            return this.nro_telefono;
        }

        public void setNro_telefono(int nro_telefono)
        {
            this.nro_telefono = nro_telefono;
        }

        public int getId_tipo()
        {
            return this.id_tipo;
        }

        public void setId_tipo(int id_tipo)
        {
            this.id_tipo = id_tipo;
        }


    }
