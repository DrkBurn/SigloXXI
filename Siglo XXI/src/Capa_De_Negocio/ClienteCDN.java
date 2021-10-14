/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_De_Negocio;

/**
 *
 * @author Aspire3
 */
    public class ClienteCDN
    {
        private String correo_cliente;
        private String nombre;
        private String apellidos;
        private String contraseña;

        public String getCorreo_cliente()
        {
            return this.correo_cliente;
        }

        public void setCorreo_cliente(String correo_cliente)
        {
            this.correo_cliente = correo_cliente;
        }

        public String getNombre()
        {
            return this.nombre;
        }

        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }

        public String getApellidos()
        {
            return this.apellidos;
        }

        public void setApellidos(String apellidos)
        {
            this.apellidos = apellidos;
        }

        public String getContraseñA()
        {
            return this.contraseña;
        }

        public void setContraseñA(String contraseña)
        {
            this.contraseña = contraseña;
        }

    }
