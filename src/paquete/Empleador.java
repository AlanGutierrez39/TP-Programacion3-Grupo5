package paquete;

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

	@Override
	public void run() 
	{
		//cada empleador genera 3 puestos de trabajo (tickets simplificados)
		//notifica cada vez que agrega un nuevo ticket
		
		/* */
		TicketSimplificado ts1 = new TicketSimplificado("Salud","Presencial", this);
		Agencia.getInstance().agregarTicketSimplificado(ts1);
		Util.espera();
		
		TicketSimplificado ts2 = new TicketSimplificado("Comercio Internacional","Indistinto", this);
		Agencia.getInstance().agregarTicketSimplificado(ts2);
		Util.espera();
		
		TicketSimplificado ts3 = new TicketSimplificado("Comercio Local","HomeOffice", this);
		Agencia.getInstance().agregarTicketSimplificado(ts3);
		Util.espera();
		
		/*
		/*
		
		por qué con el nofityAll() tira error de ejecución??
		 
		TicketSimplificado ts1 = new TicketSimplificado("Salud","Presencial", this);
		Agencia.getInstance().agregarTicketSimplificado(ts1);
		notifyAll();
		Util.espera();
		
		TicketSimplificado ts2 = new TicketSimplificado("Comercio Internacional","Indistinto", this);
		Agencia.getInstance().agregarTicketSimplificado(ts2);
		notifyAll();
		Util.espera();
		
		TicketSimplificado ts3 = new TicketSimplificado("Comercio Local","HomeOffice", this);
		Agencia.getInstance().agregarTicketSimplificado(ts3);
		notifyAll();
		Util.espera();
		/**/
	}
	
	
}
