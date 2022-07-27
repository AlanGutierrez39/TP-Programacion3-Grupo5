package paquete;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import interfaces.IPersona;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketSimplificado;

public class EmpleadoPretenso extends Persona implements IPersona, Serializable, Runnable, Observer
{	
	private String nombre;
	private String apellido;
	private int edad;
	private TicketEmpleadoPretenso ticket;
	private TicketSimplificado ticketSimplificado;
	private int cantBusquedas = 0;
	
	protected HashSet<TicketSimplificado> observados = new HashSet<TicketSimplificado>();

	public EmpleadoPretenso(Domicilio domicilio, String telefono, String mail, String nombUsuario, String contrasenia,
			String nombre, String apellido, int edad, TicketEmpleadoPretenso ticket) 
	{
		super(domicilio, telefono, mail, nombUsuario, contrasenia);
		Agencia.getInstance().agregarEmpleadoPretenso(this);
		this.apellido=apellido;
		this.nombre=nombre;
		this.edad=edad;
		this.ticket = ticket;
		this.ticketSimplificado = null; //se asignará de la Bolsa de Trabajo, producto de la simulación
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

	public TicketEmpleadoPretenso getTicket() {
		return ticket;
	}

	public void setTicket(TicketEmpleadoPretenso ticket) {
		this.ticket = ticket;
	}


	public int getCantBusquedas() {
		return cantBusquedas;
	}

	public void setCantBusquedas(int cantBusquedas) {
		this.cantBusquedas += cantBusquedas;	//cuento nueva busqueda realizada
	}
	

	public TicketSimplificado getTicketSimplificado() {
		return ticketSimplificado;
	}

	public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
	}
	
	public void AgregarObservable(TicketSimplificado ts)
	{
		ts.addObserver(this);
		this.observados.add(ts);
	}
	
	public void EliminarObservable(TicketSimplificado ts)
	{
		ts.deleteObserver(this);
		this.observados.remove(ts);
	}
	
	@Override
	public String getNomRazonS() {
		return null;
	}

    
    @Override
    public double porcentComicion() {
        return 0.0;
    }

	@Override
	public void run() 
	{
		while((this.ticketSimplificado == null) && (this.cantBusquedas < 10))
		{
			Agencia.getInstance().BuscaTicketSimplificado(this);
			this.setCantBusquedas(1);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
    
    
}
