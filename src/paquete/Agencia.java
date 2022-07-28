package paquete;

import java.util.ArrayList;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.Comision;
import modelo.ControlEstadosTicket;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import modelo.TicketSimplificado;
import util.Util;

/**
 * @author paula
 *<br> 
 *Clase que representa una agencia dentro de un sistema de Gestiï¿½n de Bï¿½squedas Laborales.
 *<br>
 *Contiene el registro de todos los usuarios y permite logear un nuevo usuario. El sistema permite el ingreso de datos, que luego serï¿½n procesados para generar tickets. Dichos tickets permitirï¿½ analizar la contrataciï¿½n de empleados.
 */
public class Agencia
{
	private static Agencia instancia = null;

	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	private ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso> ();
		
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados

	private ArrayList<ListAsignacionEmpleador> listEleccionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();//lista que guarda las coincidencias entre empresa y empleado

	private ArrayList<TicketSimplificado> bolsaDeEmpleo = new ArrayList<TicketSimplificado>();
	
	
	private double saldoAgencia = 0;
	

	
	public static Agencia getInstancia() {
		return instancia;
	}

	public static void setInstancia(Agencia instancia) {
		Agencia.instancia = instancia;
	}

	public void setEmpleadoresActivos(ArrayList<Empleador> empleadoresActivos) {
		this.empleadoresActivos = empleadoresActivos;
	}

	public void setEmpleadosPretensosActivos(ArrayList<EmpleadoPretenso> empleadosPretensosActivos) {
		this.empleadosPretensosActivos = empleadosPretensosActivos;
	}

	public void setListAsignacionEmpleador(ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador) {
		this.listAsignacionEmpleador = listAsignacionEmpleador;
	}

	public void setListAsignacionEmpleadoPretensos(
			ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos) {
		this.listAsignacionEmpleadoPretensos = listAsignacionEmpleadoPretensos;
	}

	public void setListEleccionEmpleador(ArrayList<ListAsignacionEmpleador> listEleccionEmpleador) {
		this.listEleccionEmpleador = listEleccionEmpleador;
	}

	public void setListEleccionEmpleadoPretensos(ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos) {
		this.listEleccionEmpleadoPretensos = listEleccionEmpleadoPretensos;
	}

	public void setListaCoincidencias(ArrayList<ListAsignacionEmpleador> listaCoincidencias) {
		this.listaCoincidencias = listaCoincidencias;
	}

	public void setSaldoAgencia(double saldoAgencia) {
		this.saldoAgencia = saldoAgencia;
	}

	public void setEmpleadores(ArrayList<Empleador> empleadores) {
		this.empleadores = empleadores;
	}

	public void setEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		this.empleadosPretensos = empleadosPretensos;
	}

	public Agencia() {	}
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
	public void agregarEmpleador (Empleador empleador) {
		this.empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		this.empleadosPretensos.add(empleadoPretenso);
	}
	
	
	public double getSaldoAgencia() {
		return saldoAgencia;
	}

	
	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensos() {
		return empleadosPretensos;
	}

	public ArrayList<Empleador> getEmpleadoresActivos() {
		return empleadoresActivos;
	}

	public ArrayList<EmpleadoPretenso> getEmpleadosPretensosActivos() {
		return empleadosPretensosActivos;
	}

	public ArrayList<ListAsignacionEmpleador> getListAsignacionEmpleador() {
		return listAsignacionEmpleador;
	}

	public ArrayList<ListAsignacionEmpleadPretenso> getListAsignacionEmpleadoPretensos() {
		return listAsignacionEmpleadoPretensos;
	}
	

	public void agregarTicketSimplificado(TicketSimplificado ticket) {
		this.bolsaDeEmpleo.add(ticket);
		for (EmpleadoPretenso i: this.empleadosPretensos)
		{
			i.agregarObservable(ticket);
		}
	}
	
	public void emilinarTicketSimplificado(TicketSimplificado ticket) {
		this.bolsaDeEmpleo.remove(ticket);
	}

	public ArrayList<TicketSimplificado> getBolsaDeEmpleo() {
		return bolsaDeEmpleo;
	}

	public void setBolsaDeEmpleo(ArrayList<TicketSimplificado> bolsaDeEmpleo) {
		this.bolsaDeEmpleo = bolsaDeEmpleo;
	}
	
	public ArrayList<ListAsignacionEmpleador> getListEleccionEmpleador() {
		return listEleccionEmpleador;
	}

	public ArrayList<ListAsignacionEmpleadPretenso> getListEleccionEmpleadoPretensos() {
		return listEleccionEmpleadoPretensos;
	}

	public ArrayList<ListAsignacionEmpleador> getListaCoincidencias() {
		return listaCoincidencias;
	}
	

	/**
	 * Modifica el saldo de la agencia cuando ésta cobra una comisión.
	 * <br>
	 * <b>Pre: </b> Existe una lista de coincidencias con usuarios no nulos. Un empleado solo elije una empresa.
	 * <br>
	 * <b>Post: </b> Devuelve un único valor.
	 * @param listaCoincidencias
	 */
	public void setSaldoAgencia(ArrayList<ListAsignacionEmpleador> listaCoincidencias) {
		Comision comision = new Comision();
		this.saldoAgencia += comision.calculoComision(listaCoincidencias);
	}

	
	
	/**
	 * Genera un ArrayList con los empleados pretensos y empleadores activos.
	 * <br>
	 * <b>Pre: </b> Agencia tiene que tener al menos un empelado pretenso y un emperador.
	 * <br>
	 * <b>Post: </b> Devuelve solo los usuarios con estado de ticket activo.  
	 */
	public void generarUsusariosActivos() {
		this.empleadosPretensosActivos.addAll(ControlListasAgencia.filtroTicketActivoEmpleadosPretensos(this.empleadosPretensos));
		this.empleadoresActivos.addAll(ControlListasAgencia.filtroTicketActivoEmpleadores(this.empleadores));		
	}
	
	
	
	/**
	 * Genera las listas se asignaciï¿½n de los empleadores y los empleados pretensos.
	 * <br>
	 * <b>Pre: <b/> Las listas no pueden ser nulas y tienen que tener al menos un dato.
	 * <br>
	 * <b>Pos: <b/> Devuelve listas de asignaciï¿½n y las de coincidencia. <br> Finaliza estado ticket <br> Actualiza puntaje usuario <br>
	 *   
	 */
	public void activarRondaEncuentrosLaborales () {///metodo que genere las listas de asignacion
		
		ControlListasAgencia cla= new ControlListasAgencia();
		ControlEstadosTicket cet = new ControlEstadosTicket();
		
		
		listAsignacionEmpleador.addAll(cla.generarListAsignacionEmpleador(empleadosPretensosActivos,empleadoresActivos));
		listAsignacionEmpleadoPretensos.addAll(cla.generarListAsignacionEmpleadoPretenso(empleadosPretensosActivos,empleadoresActivos));
		
		activarRondaEleccion();
		
		
	}
	
	
	
	public void activarRondaEleccion(){
		int i ;
		ControlListasAgencia cla= new ControlListasAgencia();
		ControlEstadosTicket cet = new ControlEstadosTicket();
		
		//empleadores
		for (int j=0; j<this.listAsignacionEmpleador.size(); j++) {
			ListAsignacionEmpleador nodo = new ListAsignacionEmpleador();
			ArrayList<EmpleadoPretenso> nodoListas = new ArrayList<EmpleadoPretenso>();
			i=0;
			
			nodo.setEmpleador(this.listAsignacionEmpleador.get(j).getEmpleador());
		
			while (i < this.listAsignacionEmpleador.get(j).getListEmpleadosPretensos().size()  &&
					this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().getCantEmpleadosSolicitados() > this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().getCantEmpleadosObtenidos())
			{	
				nodoListas.add(this.listAsignacionEmpleador.get(j).getListEmpleadosPretensos().get(i));
				this.listAsignacionEmpleador.get(j).getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
				i++;
			}
			nodo.setListEmpleadosPretensos(nodoListas);
			this.listEleccionEmpleador.add(nodo);
			
			nodo=null;
		}
		
		//empleadoPretensos
		
		for (int j=0; j<listAsignacionEmpleadoPretensos.size(); j++) {
			ListAsignacionEmpleadPretenso nodoEP = new ListAsignacionEmpleadPretenso();
			ArrayList<Empleador> nodoEmpresa = new ArrayList<Empleador>();
		
			nodoEP.setEmpleadoPretenso(listAsignacionEmpleadoPretensos.get(j).getEmpleadoPretenso());
			nodoEmpresa.add(listAsignacionEmpleadoPretensos.get(j).getListEmpleadores().get(0));
			nodoEP.setListEmpleadores(nodoEmpresa);
			
			this.listEleccionEmpleadoPretensos.add(nodoEP);
		
			nodoEP=null;
		}
		
		
		listaCoincidencias.addAll(cla.ListaCoincidencias(listEleccionEmpleador, listEleccionEmpleadoPretensos));
		
	}
	

	/**
	 * Actualiza el puntaje de los usuarios
	 * <br>
	 * <b>Pre: </b> Las listas no pueden ser nulas y tienen que tener al menos un dato cargado.
	 * <br>
	 * <b>Pos: </b> Devuelve el puntaje actualizado.
	 * 
	 */
	
	public void actualizacionPuntajeUsuario()
	{
		for(int i=0; i<empleadosPretensosActivos.size(); i++)
		
		{
			
			//actualiza solo si esta finalizado/ cancelado
			empleadosPretensosActivos.get(i).getTicket().getEstado().actualizarPtj(empleadosPretensosActivos.get(i));

			
			//analizo Posicion en la listaEmpleados -> necesito un contador de elementos de la lista
			
			int posicion = 0;
			while(posicion < listAsignacionEmpleadoPretensos.size() && listAsignacionEmpleadoPretensos.get(posicion).getEmpleadoPretenso().equals(empleadosPretensosActivos.get(i)))
				posicion++;	
	
			int ult = listAsignacionEmpleadoPretensos.size();
			//como calculo la posicion?
			if(posicion == ult) //ultimo lugar
				empleadosPretensosActivos.get(i).setPuntajeUsuario(-5);
			else 
				if(posicion == 1) //primero
					empleadosPretensosActivos.get(i).setPuntajeUsuario(5);
		}
	
		for(int j=0; j<empleadoresActivos.size(); j++)
		{
			///actualiza puntaje finalizados
			empleadoresActivos.get(j).getTicket().getEstado().actualizarPtj(empleadoresActivos.get(j)); 
	
			Empleador empresaPos1 = listAsignacionEmpleador.get(1).getEmpleador();
			
			if(empresaPos1.equals(empleadoresActivos.get(j))) //en primer lugar
				empleadoresActivos.get(j).setPuntajeUsuario(10); 
			
			//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elegido
			int k = 0;
			while(k < listaCoincidencias.size() && listaCoincidencias.get(k).getEmpleador().equals(empleadoresActivos.get(j)))
				k++;
			
			if(k < listaCoincidencias.size())
				if ( listaCoincidencias.get(k).getListEmpleadosPretensos() == null)//sin elecciones
					empleadoresActivos.get(j).setPuntajeUsuario(-20); 
		}
		
		
	}

	/**
	 * Logea un usuario.
	 * <br>
	 * <b>Pre: </b> La lista de empleadores y empleados no pueden ser nula.
	 * <br>
	 * <b>Pos: </b> Que el usuario ingresa al sistema con su nombre de usuario y la contraseï¿½a, si ï¿½ste se encuentra registrado.
	 * @param nombUsuarioIngresado : Nombre de usuario a logearse
	 * @param contrasenaIngresada : Contraseï¿½a del usuario a logearse.
	 * @return : retorna si el usuario se pudo logear.
	 * @throws NombreDeUsuarioIncorrectoException : Lanza una excepcion si el usuario es incorrecto.
	 * @throws ContrasenaIncorrectaException : Lanza una excepcion si la contraseï¿½a es incorrecta.
	 */
	public boolean login(String nombUsuarioIngresado, String contrasenaIngresada) throws NombreDeUsuarioIncorrectoException, ContrasenaIncorrectaException
	{
		//de ser usuario inexistente tira una excpecion
		// de ser contraseï¿½a erronea tira otra excpecion
		
		int i = 0;
		boolean loginCorrecto = false;
		
		while (i<this.empleadores.size() && !this.empleadores.get(i).getNombUsuario().equals(nombUsuarioIngresado))
			i++;
		if (i<this.empleadores.size())
		{
			if (this.empleadores.get(i).getContrasenia().equals(contrasenaIngresada))
				loginCorrecto = true;
			else
				throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
		else
		{
			i = 0;
			while (i<this.empleadosPretensos.size() && !this.empleadosPretensos.get(i).getNombUsuario().equals(nombUsuarioIngresado))
				i++;
			if (i<this.empleadosPretensos.size())
			{
				if (this.empleadosPretensos.get(i).getContrasenia().equals(contrasenaIngresada))
					loginCorrecto = true;
				else
					throw new ContrasenaIncorrectaException("Contrasena incorrecta");
			}
			else
				throw new NombreDeUsuarioIncorrectoException("Nombre de Usuario incorrecto");
		}
		return loginCorrecto;
		
	}
	

	public void mostrarEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		for(int i = 0; i < empleadosPretensos.size(); i++) {
			System.out.println(empleadosPretensos.get(i).getNombre()+empleadosPretensos.get(i).getApellido());
		}
	}


	public void mostrarEmpleadores(ArrayList<Empleador> empleadores) {
		for (int i=0; i < empleadores.size(); i++) {
			if (empleadores.get(i).isPersonaJuridica())
				System.out.println(empleadores.get(i).getNomRazonS());
			else
				System.out.println(empleadores.get(i).getNombre()+empleadores.get(i).getApellido());
		}
		
	}
	
	
	public synchronized void BuscaTicketSimplificado(EmpleadoPretenso empleado)
	{
		while(this.bolsaDeEmpleo.isEmpty())
		{
			try
			{
				System.out.println(empleado.getNombre()+" "+empleado.getApellido()+" quiere buscar un ts pero la bolsa está vacía.");
				wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(empleado.getNombre()+" "+empleado.getApellido()+" logró acceder a la bolsa");
		notifyAll();
		
		int i = 0;
		while((i < this.getBolsaDeEmpleo().size()) && (this.bolsaDeEmpleo.get(i).getEstado().equals("Autorizado")))
		{
			//System.out.println(this.bolsaDeEmpleo.size());
			if(this.bolsaDeEmpleo.get(i).getTipoTrabajo().equals(empleado.getTicket().getFbTicket().getTipoTrabajo()))
			{
				this.bolsaDeEmpleo.get(i).setEstado("Bloqueado");
				//Util.espera(); //simula el envio de mensaje al empleador
				
				System.out.println(this.bolsaDeEmpleo.size());
				if(this.bolsaDeEmpleo.get(i).getLocacion().equals(empleado.getTicket().getFbTicket().getLocacion()))
				{
					if (this.bolsaDeEmpleo.get(i).getEmpleador().getTicket().getCantEmpleadosObtenidos() < this.bolsaDeEmpleo.get(i).getEmpleador().getTicket().getCantEmpleadosSolicitados())
					{   
						//hay contratación
						/*
						 no se llega a ejecutar esta parte del código
						 tampoco el update de empleado pretenso!
						 */
						//System.out.println(this.bolsaDeEmpleo.get(i));
						//System.out.println(this.bolsaDeEmpleo.get(i).getEmpleador().getNombre());
						System.out.println(empleado.getNombre()+" "+empleado.getApellido()+" fue contratado por "+ this.bolsaDeEmpleo.get(i).getEmpleador().getNombUsuario()+"----------");
						this.bolsaDeEmpleo.get(i).getEmpleador().getTicket().setCantEmpleadosObtenidos(1);
						this.bolsaDeEmpleo.get(i).setEstado("Contratado");
						empleado.setTicketSimplificado(this.bolsaDeEmpleo.get(i));
						this.emilinarTicketSimplificado(this.bolsaDeEmpleo.get(i));
						
						//cargar lista de coincidencia!
						ListAsignacionEmpleador nodoE = new ListAsignacionEmpleador();
						nodoE.setEmpleador(this.bolsaDeEmpleo.get(i).getEmpleador());
						nodoE.getListEmpleadosPretensos().add(empleado);
						
						/*
						  no me convence como cargar la lista de coincidencia
						  quisiera buscar a un empleador en la lista y si esta agregar el
						  empleado pretenso y, sino, agregar un nuevo empleador
						*/
					}
				}
				else 
				{
					//no hubo éxito en la locación o el empleador ya contrató a todos los empleados pretensos requeridos
					this.bolsaDeEmpleo.get(i).setEstado("Autorizado");
				}
				
				System.out.println(this.bolsaDeEmpleo.get(i).getEstado());
				this.bolsaDeEmpleo.get(i).cambio();
				this.bolsaDeEmpleo.get(i).notifyObservers(this.bolsaDeEmpleo.get(i).getEstado());
			}
			i++;
		}
	}
}
