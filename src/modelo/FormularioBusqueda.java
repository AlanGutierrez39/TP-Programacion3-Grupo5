package modelo;

import java.io.Serializable;

public class FormularioBusqueda implements Serializable{
	
	private	String locacion;
	private String remuneracion;
	private String cargaHoraria;
	private String tipoPuesto;
	private String rangoEtario;
	private String experienciaPrevia;
	private String estudiosCursados;
	private String tipoTrabajo; //Salud - Comercio Local - Comercio Internacional
	


	public FormularioBusqueda(String locacion, String remuneracion, String cargaHoraria, String tipoPuesto,
			String rangoEtario, String experienciaPrevia, String estudiosCursados, String tipoTrabajo) {
		super();
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		this.cargaHoraria = cargaHoraria;
		this.tipoPuesto = tipoPuesto;
		this.rangoEtario = rangoEtario;
		this.experienciaPrevia = experienciaPrevia;
		this.estudiosCursados = estudiosCursados;
		this.tipoTrabajo = tipoTrabajo;
	}


	public String getLocacion() {
		return locacion;
	}


	public String getRemuneracion() {
		return remuneracion;
	}


	public String getCargaHoraria() {
		return cargaHoraria;
	}


	public String getTipoPuesto() {
		return tipoPuesto;
	}


	public String getRangoEtario() {
		return rangoEtario;
	}


	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}


	public String getEstudiosCursados() {
		return estudiosCursados;
	}


	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}


	public void setRemuneracion(String remuneracion) {
		this.remuneracion = remuneracion;
	}


	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public void setTipoPuesto(String tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}


	public void setRangoEtario(String rangoEtario) {
		this.rangoEtario = rangoEtario;
	}


	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}


	public void setEstudiosCursados(String estudiosCursados) {
		this.estudiosCursados = estudiosCursados;
	}


	public String getTipoTrabajo() {
		return tipoTrabajo;
	}


	public FormularioBusqueda()
	{
		super();
	}
	
	
	
}
