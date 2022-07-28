package paquete;

import java.util.Random;

import interfaces.IPersona;
import modelo.TicketEmpleador;
import modelo.TicketSimplificado;
import util.Util;

public class Empleador extends Persona implements  IPersona, Runnable
{
	private  boolean personaJuridica;
	private String nomRazonS;
	private String nombre;
	private String apellido;
	private int edad;
	private String rubro; //Salud - Comercio Local - Comercio Internacional
	private  TicketEmpleador ticket;
	private  ValoracionAspecto listaPesos;                
	
	
	//Tipo jurídico
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nomRazonS, String rubro, TicketEmpleador ticket, ValoracionAspecto listaPesos)
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		Agencia.getInstance().agregarEmpleador(this);
		this.personaJuridica = true;
		this.nomRazonS = nomRazonS;
		this.nombre = null;
		this.apellido = null;
		this.edad = 0;
		this.rubro = rubro;
		this.ticket = ticket;
		this.listaPesos = listaPesos;
	}

	//Tipo física
	public Empleador(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, String rubro, TicketEmpleador ticket, ValoracionAspecto listaPesos)
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		Agencia.getInstance().agregarEmpleador(this);
		this.personaJuridica = false;
		this.nomRazonS = null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.rubro = rubro;
		this.ticket = ticket;
		this.listaPesos = listaPesos;
	}

	
	public boolean isPersonaJuridica() {
		return personaJuridica;
	}

	public String getNomRazonS() {
		return nomRazonS;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getRubro() {
		return rubro;
	}

	public TicketEmpleador getTicket() {
		return ticket;
	}

	public ValoracionAspecto getListaPesos() {
		return listaPesos;
	}

	@Override
	public double porcentComicion() {
		return 0;
	}

	
	/**
	 * Cada empleador generaá 3 puestos de trabajo.
	 */
	@Override
	public void run() 
	{	
		Random r = new Random();
		int i;
		String locacion = null;
		
		for (int j = 0; j < 3; j++)
		{
			
			i = r.nextInt(4);
		
			switch(i)
			{
			case 1:
				locacion = "HomeOffice";
				break;
			case 2:
				locacion = "Presencial";
				break;
			case 3:
				locacion = "Indistinto";
				break;
			}
		
			TicketSimplificado ts = new TicketSimplificado(this.getRubro(), locacion, this);
			Agencia.getInstance().agregarTicketSimplificado(ts);
			System.out.println(this.getNombUsuario()+" agrego un nuevo ts");
		}
		
	}
	
	
}
