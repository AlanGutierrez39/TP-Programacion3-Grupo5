package paquete;

public class DomicilioConDepartamento extends Domicilio
{
	private int piso;
	private char departamento;

	public DomicilioConDepartamento(String calle, int numero, int piso, char departamento)
	{
		super(calle, numero);
		this.piso = piso;
		this.departamento = departamento;
	}

	public int getPiso()
	{
		return piso;
	}

	public void setPiso(int piso)
	{
		this.piso = piso;
	}

	public char getDepartamento()
	{
		return departamento;
	}

	public void setDepartamento(char departamento)
	{
		this.departamento = departamento;
	}
}
