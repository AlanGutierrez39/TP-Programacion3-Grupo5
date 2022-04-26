package paquete;

import interfaces.Contactable;

public abstract class Decorator extends Persona
{
	public Contactable contactable;

	public Contactable getContactable()
	{
		return contactable;
	}

	public void setContactable(Contactable contactable)
	{
		this.contactable = contactable;
	}
	
}
