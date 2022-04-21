package paquete;

public class PersonaFisica extends Persona
{
	private String nomUsuario;
	private String contrasenia;

	/**
	 * Necesito un constructor para @param nomUsuario para que no se pueda cambiar.
	 * En cambio con el setter se puede cambiar más de una vez y no es mi idea.
	 */
	public PersonaFisica(String nombre, String apellido, String telefono, String fechaNac, String calle, int numCalle,
			String nomUsuario)
	{
		super(nombre, apellido, telefono, fechaNac, calle, numCalle);
		this.nomUsuario = nomUsuario;
		// TODO Auto-generated constructor stub
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
