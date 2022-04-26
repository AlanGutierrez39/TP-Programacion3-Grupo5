package paquete;

import java.util.GregorianCalendar;

public class PersonaJuridica extends Decorator
{
	private Persona persona;
	private String nombreRazonSocial;
	private String telefono;
	private String email;
	private GregorianCalendar fechaFundacion; // DD/MM/AAAA
	private Domicilio domicilio;
	private String nomUsuario;
	private String contrasenia;

	public PersonaJuridica(Persona persona, String nombreRazonSocial, String telefono, String email,
			GregorianCalendar fechaFundacion, Domicilio domicilio, String nomUsuario)
	{
		super();
		this.persona = persona;
		this.nombreRazonSocial = nombreRazonSocial;
		this.telefono = telefono;
		this.email = email;
		this.fechaFundacion = fechaFundacion;
		this.domicilio = domicilio;
		this.nomUsuario = nomUsuario;
	}

	public String getTelefono()
	{
		return telefono;
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

	public String getContrasenia()
	{
		return contrasenia;
	}

	public void setContrasenia(String contrasenia)
	{
		this.contrasenia = contrasenia;
	}

	public String getNombreRazonSocial()
	{
		return nombreRazonSocial;
	}

	public String getEmail()
	{
		return email;
	}

	public GregorianCalendar getFechaFundacion()
	{
		return fechaFundacion;
	}

	public String getNomUsuario()
	{
		return nomUsuario;
	}

}
