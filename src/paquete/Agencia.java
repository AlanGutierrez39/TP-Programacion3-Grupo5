package paquete;

import java.util.ArrayList;

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;
	/* agregar otros tributos, ver cuales! */

	private ArrayList<TipoPersona> personas = new ArrayList<TipoPersona>();

	private Agencia()
	{

	}

	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();

		return instancia;
	}

	public ArrayList<TipoPersona> getPersonas()
	{
		return personas;
	}

	public void altaPersona(TipoPersona persona)
	{
		this.personas.add(persona);
	}

	public void bajaPersona(TipoPersona persona)
	{
		this.personas.remove(persona);
	}
}
