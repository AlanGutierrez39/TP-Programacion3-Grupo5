package paquete;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import interfaces.IPersona;
import modelo.ListAsignacionEmpleador;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketSimplificado;
import util.Util;

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
	
	public void agregarObservable(TicketSimplificado ts)
	{
		ts.addObserver(this);
		this.observados.add(ts);
	}
	
	public void eliminarObservable(TicketSimplificado ts)
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
			Util.espera();
		}
	}

	@Override
	public void update(Observable obs, Object arg) 
	{
		// TODO Auto-generated method stub

		TicketSimplificado ts = (TicketSimplificado) obs;
		
		String estado = (String) arg;
		
		if (observados.contains(obs))
		{
			switch (estado)
			{
				 
				/*
				El empleado pretenso puede analizar el ticket simplificado
				si se encuentra en estado Autorizado, comprueba si puede quedarse con el ticket
				 */
				case "Autorizado" :
				{
					if ((this.ticketSimplificado == null) && (this.cantBusquedas < 10))
					{
						this.setCantBusquedas(1);
						
						if (ts.getTipoTrabajo().equals(this.ticket.getFbTicket().getTipoTrabajo())) 
						{
							ts.setEstado("Bloqueado");
							//Util.espera(); //simula el envio de mensaje al empleador
							
							if (ts.getLocacion().equals(this.ticket.getFbTicket().getLocacion()))
							{
								if (ts.getEmpleador().getTicket().getCantEmpleadosObtenidos() < ts.getEmpleador().getTicket().getCantEmpleadosSolicitados())
								{
									//hay contratación
									
									ts.getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
									ts.setEstado("Contratado");
									this.setTicketSimplificado(ts);
									Agencia.getInstance().emilinarTicketSimplificado(ts);
									
									
									//actualiza lista de coincidencia
									ListAsignacionEmpleador nodoE = new ListAsignacionEmpleador();
									nodoE.setEmpleador(ts.getEmpleador());
									nodoE.getListEmpleadosPretensos().add(this);
								}
							}
							ts.setEstado("Autorizado");
						}
					}
				}
				break;
				
				/*
				El empleado pretenso no realiza nada si el ticket simplificado se
				encuentra en estado Bloqueado, lo sigue observando
				 */
				
				
				/*
				El empleado pretenso ya fue contratado y no requiere seguir observando
				dicho ticket simplificado
				 */
				case "Contratado":
				{
					eliminarObservable(ts);
				}
				break;
			}
			
		}
		
	}
    
    
}
