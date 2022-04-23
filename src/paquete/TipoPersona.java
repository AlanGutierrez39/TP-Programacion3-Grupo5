package paquete;

import java.util.GregorianCalendar;

import interfaces.Persona;

public class TipoPersona implements Persona
{
	private String nombre;
	private String apellido;
	private String telefono;
	private GregorianCalendar fechaNac; // DD/MM/AAAA
	private Domicilio domicilio; // ver si agregar clase direccion!

	/**
	 * 
	 * Para @param fechaNac uso la clase GregorianCalendar, mientras que para @param
	 * domicilio uso la clase Domicilio como una relación de agregación.
	 */

	public TipoPersona(String nombre, String apellido, String telefono, GregorianCalendar fechaNac, Domicilio domicilio)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.setDomicilio(domicilio);
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public GregorianCalendar getFechaNac()
	{
		return fechaNac;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public Domicilio getDomicilio()
	{
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio)
	{
		this.domicilio = domicilio;
	}

}
