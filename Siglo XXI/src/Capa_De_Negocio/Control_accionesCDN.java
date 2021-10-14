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
    public class Control_accionesCDN
    {
        private Date fecha_hora;
        private int id_usuario;
        private String accion;

	public Date getFecha_hora() {
		return this.fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public int getId_usuario() {
		return this.id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}


    }





