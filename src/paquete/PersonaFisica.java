package paquete;

import java.util.GregorianCalendar;

public class PersonaFisica extends Decorator
{
	private Persona persona;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private GregorianCalendar fechaNac; // DD/MM/AAAA
	private Domicilio domicilio; // ver si agregar clase direccion!
	private String nomUsuario;
	private String contrasenia;

	/**
	 * Para @param fechaNac uso la clase GregorianCalendar, mientras que para @param
	 * domicilio uso la clase Domicilio como una relación de agregación. Además,
	 * Necesito un constructor para @param nomUsuario para que no se pueda cambiar.
	 * En cambio con el setter se puede cambiar más de una vez y no es mi idea.
	 */
	public PersonaFisica(Persona persona, String nombre, String apellido, String telefono, String email,
			GregorianCalendar fechaNac, Domicilio domicilio, String nomUsuario)
	{
		super();
		this.persona = persona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
		this.nomUsuario = nomUsuario;
		// TODO Auto-generated constructor stub
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

	public String getEmail()
	{
		return email;
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

	public String getNomUsuario()
	{
		return nomUsuario;
	}

	public String getContrasenia()
	{
		return contrasenia;
	}

	public void setContrasenia(String contrasenia)
	{
		this.contrasenia = contrasenia;
	}

}
