package paquete;

public class Persona
{
	private String nombre;
	private String apellido;
	private String telefono;
	private String fechaNac; // DD/MM/AAAA
	private String calle;    //ver si agregar clase direccion!
	private int numCalle;
	
	
	
	public Persona(String nombre, String apellido, String telefono, String fechaNac, String calle, int numCalle) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.calle = calle;
		this.numCalle = numCalle;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public String getTelefono() {
		return telefono;
	}



	public String getFechaNac() {
		return fechaNac;
	}



	public String getCalle() {
		return calle;
	}



	public int getNumCalle() {
		return numCalle;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public void setNumCalle(int numCalle) {
		this.numCalle = numCalle;
	}
	
	
	
	
}
