package paquete;

import java.util.ArrayList;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;
	/* agregar otros tributos, ver cuales! */

	private ArrayList<Persona> personas = new ArrayList<Persona>();

	private Agencia()
	{

	}

	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();

		return instancia;
	}

	public ArrayList<Persona> getPersonas()
	{
		return personas;
	}

	public void altaPersona(Persona persona)
	{
		this.personas.add(persona);
	}

	public void bajaPersona(Persona persona)
	{
		this.personas.remove(persona);
	}
}
