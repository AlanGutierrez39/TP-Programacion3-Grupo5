package paquete;

import java.util.ArrayList;

public class Sistema 
{
	private boolean nombreDeUsuarioDisponible = true;
	private boolean LargoDeContrasena = true;
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private ArrayList<Empleado> empleadosPretensos = new ArrayList<Empleado>();

	public ArrayList<Empleador> getEmpleadores()
	{
		return empleadores;
	}

	public void altaEmpleador(Empleador empleador)
	{
		this.empleadores.add(empleador);
	}

	public void bajaEmpleador(Empleador empleador)
	{
		this.empleadores.remove(empleador);
	}

	public ArrayList<Empleado> getEmpleadosPretensos()
	{
		return empleadosPretensos;
	}

	public void altaEmpleado(Empleado empleado)
	{
		this.empleadosPretensos.add(empleado);
	}

	public void bajaEmpleado(Empleado empleado)
	{
		this.empleadosPretensos.remove(empleado);
	}
}
