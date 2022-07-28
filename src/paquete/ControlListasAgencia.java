package paquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
import tablas.PuntajeTicket;

/**
 * @author paula
 *
 *Clase que se encarga de generar las listas que contiene la Agencia.
 */
public class ControlListasAgencia implements Serializable
{

	/**
	 * Método que 
	 * @param empleadosPretensosActivos
	 * @param empleadoresActivos
	 * @return
	 */
	public ArrayList<ListAsignacionEmpleador> generarListAsignacionEmpleador(ArrayList<EmpleadoPretenso> empleadosPretensosActivos,ArrayList<Empleador> empleadoresActivos) {
		ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();
		for (int i=0; i<empleadoresActivos.size(); i++)
			listAsignacionEmpleador.add(listasAsignacionEmpresa(empleadosPretensosActivos,empleadoresActivos.get(i)));
			
		return listAsignacionEmpleador;
	}
	
	public ArrayList<ListAsignacionEmpleadPretenso> generarListAsignacionEmpleadoPretenso(ArrayList<EmpleadoPretenso> empleadosPretensosActivos,ArrayList<Empleador> empleadoresActivos) {
		ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();
		for (int i=0; i<empleadosPretensosActivos.size(); i++)
			listAsignacionEmpleadoPretensos.add(listasAsignacionEmpleadoPretenso(empleadoresActivos, empleadosPretensosActivos.get(i)));
		return listAsignacionEmpleadoPretensos;
	}
		
	//filtro solo ticket activos
	public static ArrayList<EmpleadoPretenso> filtroTicketActivoEmpleadosPretensos(ArrayList<EmpleadoPretenso> empleadosPretensos) {
		ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso>();
		for (int i=0; i<empleadosPretensos.size();i++) {
			if (empleadosPretensos.get(i).getTicket().getEstado().ticketDisponible() != null) {
				empleadosPretensosActivos.add(empleadosPretensos.get(i));
			}
			else {
				///***** exception *********
			}
		}
		return empleadosPretensosActivos;
	}
	
	public static ArrayList<Empleador> filtroTicketActivoEmpleadores(ArrayList<Empleador> empleadores) {
		ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador>();
		for (int i=0; i<empleadores.size();i++) {
			if (empleadores.get(i).getTicket().getEstado().ticketDisponible() != null) {
				empleadoresActivos.add(empleadores.get(i));
				}
				else {
					///***** exception *********
				}
			
			}
		return empleadoresActivos;
	}
	

	///le devuelve un nodo que contiene una lista de empresas para empleadoPretenso 
	public  ListAsignacionEmpleadPretenso listasAsignacionEmpleadoPretenso(ArrayList<Empleador> empleador,  EmpleadoPretenso empleadoPretensos) {

			ListAsignacionEmpleadPretenso nuevoNodo = new ListAsignacionEmpleadPretenso();		///sigue existiendo al finalizar el metodo???
			nuevoNodo.setEmpleadoPretenso(empleadoPretensos);
			nuevoNodo.setListEmpleadores(metodoOrdenamientoEpleadoPretenso(empleadoPretensos, empleador));///traigo una lista de las empresas ordenada

			return nuevoNodo;
	}


	///el metodo me devuelve una listaOrdenada de empresas para el empleadoPretneos 
	public ArrayList<Empleador> metodoOrdenamientoEpleadoPretenso( EmpleadoPretenso empleadoPretensos, ArrayList<Empleador> listaEmpleadores) {
	
	ArrayList<Empleador> lista = new  ArrayList<Empleador>();						//lista que voy a devolver
	ArrayList<EmpleadorPuntaje> listaOrdenada = new ArrayList<EmpleadorPuntaje>();   //lista que contiene el puntaje y se ordena segun este atributo
	
	
	for (int i=0; i<listaEmpleadores.size(); i++) {///creo la lista Con Puntajes 
		EmpleadorPuntaje empleadorPuntaje = new EmpleadorPuntaje();	
		
		double ptj = new PuntajeTicket().getPuntajeCF(listaEmpleadores.get(i), empleadoPretensos.getTicket());
		
		empleadorPuntaje.setEmpleador(listaEmpleadores.get(i)); 
		empleadorPuntaje.setPuntaje(ptj); 
				//(a,b) que el (b,a) de la tabla por que si no lo es .> necisto cambiar FC a CF
	
		listaOrdenada.add(empleadorPuntaje);
		empleadorPuntaje=null;
	}
	

	Collections.sort(listaOrdenada, new Comparator<EmpleadorPuntaje>() {
	@Override
		public int compare(EmpleadorPuntaje p2, EmpleadorPuntaje p1) {
			return new Double(p2.getPuntaje()).compareTo(new Double(p1.getPuntaje()));
			}
		});
	
	for (int j = 0; j< listaOrdenada.size(); j++) 	{			///cargo lista con el orden de listaOrdenada
	
		lista.add(listaOrdenada.get(j).getEmpleador());
	}
	return lista;	
	}
	
	
	///le devuelve un nodo que tine una lista de empleadosPretensos para la empresa 
	public ListAsignacionEmpleador listasAsignacionEmpresa(  ArrayList<EmpleadoPretenso> empleadosPretensos , Empleador empleador) {
		ListAsignacionEmpleador nuevoNodo = new ListAsignacionEmpleador();	
		nuevoNodo.setEmpleador(empleador);
		nuevoNodo.setListEmpleadosPretensos(metodoOrdenamientoEmpleador(empleador , empleadosPretensos));//traigo una lista de empleadosPretensos ordenada
		
		return nuevoNodo;
	}
	
	
	///el metodo devuelve una lista ordenada por puntaje de empleadosPretensos
	public ArrayList<EmpleadoPretenso> metodoOrdenamientoEmpleador(Empleador empleador, ArrayList<EmpleadoPretenso> listaEmpleaPretenso) {
	
		ArrayList<EmpleadoPretenso> lista = new  ArrayList<EmpleadoPretenso>();						//lista que voy a devolver
		ArrayList<EmpleadPretensoPuntaje> listaOrdenada = new ArrayList<EmpleadPretensoPuntaje>();   //lista que contiene el puntaje y se ordena segun este atributo
		double puntaje;
		
		for (int i=0; i<listaEmpleaPretenso.size(); i++) {///creo la lista Con Puntajes 
			
			puntaje = new PuntajeTicket().getPuntajeCF(empleador, listaEmpleaPretenso.get(i).getTicket());
			
			EmpleadPretensoPuntaje empleadoPretensPuntaje = new EmpleadPretensoPuntaje();
			
				empleadoPretensPuntaje.setEmpleadoPretenso(listaEmpleaPretenso.get(i));
				empleadoPretensPuntaje.setPuntaje(puntaje);
				listaOrdenada.add(empleadoPretensPuntaje);
				empleadoPretensPuntaje=null;
			}
	
				
	Collections.sort(listaOrdenada, new Comparator<EmpleadPretensoPuntaje>() {
		@Override
		public int compare(EmpleadPretensoPuntaje p2, EmpleadPretensoPuntaje p1) {
				return new Double(p2.getPuntaje()).compareTo(new Double(p1.getPuntaje()));
				}
		});
	
	for (int j = 0; j< listaOrdenada.size(); j++) ///cargo lista con el orden de listaOrdenada
		{lista.add(listaOrdenada.get(j).getEmpleadoPretenso());
		
		}

	
	return lista;
	
	}
		
		
		
	 public  ArrayList<ListAsignacionEmpleador> ListaCoincidencias (ArrayList<ListAsignacionEmpleador> ListaDeEmpleadores, ArrayList<ListAsignacionEmpleadPretenso> ListaDeEmpleadosPretensos) 
	{	
			 ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();
			 int w;
			
			for(int i = 0; i < ListaDeEmpleadores.size(); i++)//Recorre el arrayList de empleadores
			{	 
				ListAsignacionEmpleador nodo = new ListAsignacionEmpleador();
				ArrayList <EmpleadoPretenso> nodoListEmpleado = new ArrayList<EmpleadoPretenso>();
				
				nodo.setEmpleador(ListaDeEmpleadores.get(i).getEmpleador());

				for (int q=0; q < ListaDeEmpleadores.get(i).getListEmpleadosPretensos().size();q++) {//recorro los pretensos del empleador
					w=0;
					
					while (w < ListaDeEmpleadosPretensos.size() && 
					!ListaDeEmpleadores.get(i).getListEmpleadosPretensos().get(q).equals(ListaDeEmpleadosPretensos.get(w).getEmpleadoPretenso()))
					{	w++; 
					}
					
					
						
							if (w < ListaDeEmpleadosPretensos.size() && 
								ListaDeEmpleadosPretensos.get(w).getListEmpleadores().get(0).equals(ListaDeEmpleadores.get(i).getEmpleador())) {//encontre el empleado
								nodoListEmpleado.add(ListaDeEmpleadosPretensos.get(w).getEmpleadoPretenso());				
								
							}
				}
					nodo.setListEmpleadosPretensos(nodoListEmpleado);
					listaCoincidencias.add(nodo);
					
					
					nodoListEmpleado=null;
					nodo = null;
			}	
		 return listaCoincidencias;
	
	 }
			
	
}
		