package modelo;

import java.util.Observable;

import paquete.Empleador;

public class TicketSimplificado extends Observable
{
	private String tipoTrabajo; //Salud - Comercio Local - Comercio Internacional
	private String locacion; // HomeOffice - Presencial - Indistinto
	private Empleador empleador;
	private String estado; //Autorizado - Bloqueado - Contratado
	
	/*
	Autorizado: cualquier empleado pretenso puede acceder a él para su análisis
	Bloqueado: el ticket pasa a ser analizado por el empleado pretenso
	Contratado: si hubo éxito en la ronda de encuentro
	
	Si hubo éxito el ticket pasa a estar en poder del empleado pretenso, sino vuelve a autorizado
	*/
	
	
	
	public TicketSimplificado(String tipoTrabajo, String locacion, Empleador empleador) 
	{
		super();
		this.tipoTrabajo = tipoTrabajo;
		this.locacion = locacion;
		this.empleador = empleador;
		this.estado = "Autorizado";
	}



	public Empleador getEmpleador() {
		return empleador;
	}

	public String getLocacion() {
		return locacion;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	
	
	
	
}
