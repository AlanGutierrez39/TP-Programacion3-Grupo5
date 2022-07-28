package prueba;

import java.util.Date;

import controlador.ControladorAgencia;
import controlador.ControladorEmpleadoPretenso;
import controlador.ControladorEmpleador;
import modelo.FormularioBusqueda;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import paquete.ValoracionAspecto;

public class CargaDatos {

	public static void main(String[] args) 
	{

		TicketEmpleador ticketEmpleador1 = new TicketEmpleador(new FormularioBusqueda("HomeOffice", "V1", "Completa", "Junior", "Menos de 40", "NADA", "Secundario", "Comercio Local"), new Date(2022, 8, 23), 2, 0);
		TicketEmpleador ticketEmpleador2 = new TicketEmpleador(new FormularioBusqueda("Indistinto", "V2", "Extendida", "Managment", "40 a 50", "MUCHA", "Terciario", "Salud"), new Date(2022, 10, 5), 1, 0);
		TicketEmpleador ticketEmpleador3 = new TicketEmpleador(new FormularioBusqueda("Presencial", "V3", "Media", "Senior", "Mas de 50", "MEDIA", "Secundario", "Comercio Internacional"), new Date(2022, 7, 12), 3, 0);
		
		Empleador empleador1 = new Empleador(new Domicilio("Juramento", 256, "Casa"), "22356971", "joseyasociados@gmail.com", "JoseyAsociados", "123456789", "Jose y Asociados S.A.", "Comercio Local", ticketEmpleador1 , new ValoracionAspecto(1, 10, 10, 10, 10, 10, 10)); //juridica
		Empleador empleador2 = new Empleador(new Domicilio("Alvear", 2978, "9 H"), "7895630", "juana@gmail.com", "JuanaGonzalez", "987456", "Juana", "Gonzalez", 45, "Salud", ticketEmpleador2, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10)); //fisica
		Empleador empleador3 = new Empleador(new Domicilio("Luro", 560, "1 A"), "65892150", "raul@gmail.com", "RaulMartinez", "5555555", "Raul", "Martinez", 50, "Comercio Internacional", ticketEmpleador3, new ValoracionAspecto(5, 5, 5, 5, 5, 5, 5)); //fisica
			
		
		TicketEmpleadoPretenso ticketEmpleadoPretenso1 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "V1", "Completa", "Senior", "Menos de 40", "MUCHA", "Secundario", "Comercio Internacional"), new Date(2022, 5, 2));
		TicketEmpleadoPretenso ticketEmpleadoPretenso2 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "V2", "Media", "Managment", "40 a 50", "MEDIA", "Terciario", "Salud"), new Date(2022, 8, 9));
		TicketEmpleadoPretenso ticketEmpleadoPretenso3 = new TicketEmpleadoPretenso(new FormularioBusqueda("Indistinto", "V1", "Extendida", "Junior", "Mas de 50", "NADA", "Primario", "Comercio Local"), new Date(2022, 11, 7));
		TicketEmpleadoPretenso ticketEmpleadoPretenso4 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "V3", "Extendida", "Managment", "Menos de 40", "MUCHA", "Terciario", "Salud"), new Date(2022, 10, 5));
		TicketEmpleadoPretenso ticketEmpleadoPretenso5 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "V1", "Completa", "Senior", "40 a 50", "MEDIA", "Primario", "Comercio Local"), new Date(2022, 6, 20));
		
		
		EmpleadoPretenso empleadoPretenso1 = new EmpleadoPretenso(new Domicilio("Saavedra", 5842, "Casa"), "552564", "paola@hyty.com", "PaolaArgento", "hola1256", "Paola", "Argento", 34, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso(new Domicilio("Mateu", 4563, "7 A"), "999999", "celeste@gmail.com", "CelesteRodriguez", "contrasenia", "Celeste", "Rodriguez", 48, ticketEmpleadoPretenso2);
		EmpleadoPretenso empleadoPretenso3 = new EmpleadoPretenso(new Domicilio("San Luis", 23, "5 F"), "56215", "tatiana@outlook.com", "TatianaAguirre", "asdfasdf", "Tatiana", "Aguirre", 56, ticketEmpleadoPretenso3);
		EmpleadoPretenso empleadoPretenso5 = new EmpleadoPretenso(new Domicilio("Santiago del Estero", 666, "3 I"), "08004556666", "lautaro@gmail.com", "LautaroLazuli", "holahola", "Lautaro", "Lazuli", 28, ticketEmpleadoPretenso4);
		EmpleadoPretenso empleadoPretenso4 = new EmpleadoPretenso(new Domicilio("Calle Falsa", 123, "Casa"), "1565156", "camila@adf.com", "CamilaLopez", "nosequeponer", "Camila", "Lopez", 46, ticketEmpleadoPretenso5);
		
		
		
		System.out.println("Empleadores:");
		Agencia.getInstance().mostrarEmpleadores(Agencia.getInstance().getEmpleadores());
		System.out.println("Empleados pretensos:");
		Agencia.getInstance().mostrarEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensos());
			
		Agencia.getInstance().generarUsusariosActivos();
		
		System.out.println("____________________________________________________");
		System.out.println("Empleadores activos:");
		Agencia.getInstance().mostrarEmpleadores(Agencia.getInstance().getEmpleadoresActivos());
		
		System.out.println("Empleados Pretensos activos:");
		Agencia.getInstance().mostrarEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensosActivos());
		
		
		Agencia.getInstance().activarRondaEncuentrosLaborales();

		
		System.out.println("____________________________________________________");
		System.out.println("Empleados pretensos asignados:");
		for(int i=0; i<Agencia.getInstance().getListAsignacionEmpleador().size(); i++) {
			if (Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().isPersonaJuridica())
				System.out.println("Lista de asignacion de " + Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getNomRazonS() + ":");
			else
				System.out.println("Lista de asignacion de " + Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getNombre()+Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getApellido() + ":");
			
			for(int j=0; j < Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
				System.out.println(Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre()+Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
			}
		}
		
		
		System.out.println("____________________________________________________");
		System.out.println("Empleadores asignados:");
		for(int i=0; i<Agencia.getInstance().getListAsignacionEmpleadoPretensos().size(); i++) {
			System.out.println("Lista de asignacion de " + Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getEmpleadoPretenso().getNombre()+Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getEmpleadoPretenso().getApellido() + ":");
			
			for(int j=0; j < Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().size(); j++) {
				if (Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).isPersonaJuridica())
					System.out.println(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNomRazonS());
				else
					System.out.println(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNombre()+Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getApellido());
				
			}
		}
		
		
		
		System.out.println("____________________________________________________");
		System.out.println("Empleadores elegidos:");
		for(int i=0; i<Agencia.getInstance().getListEleccionEmpleadoPretensos().size(); i++) {
			System.out.println(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getEmpleadoPretenso().getNombre()+Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getEmpleadoPretenso().getApellido() + " eligió a :");
			
			for(int j=0; j < Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().size(); j++) {
				if (Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).isPersonaJuridica())
					System.out.println(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNomRazonS());
				else
					System.out.println(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNombre()+Agencia.getInstance().getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getApellido());
				
			}
		}
		
		
		System.out.println("____________________________________________________");
		System.out.println("Empleados pretensos elegidos:");
		for(int i=0; i<Agencia.getInstance().getListEleccionEmpleador().size(); i++) {
			if (Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().isPersonaJuridica())
				System.out.println("Lista de empleados pretensos elegidos por " + Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getNomRazonS() + ":");
			else
				System.out.println("Lista de empleados pretensos elegidos por " + Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getNombre()+Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getApellido() + ":");
			
			for(int j=0; j < Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
				System.out.println(Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre()+Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
			}
		}
		
		
		
		System.out.println("____________________________________________________");
		System.out.println("Lista de asignaciones:");
		for(int i=0; i<Agencia.getInstance().getListaCoincidencias().size(); i++) {
			if (Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().isPersonaJuridica())
				System.out.println("Lista de asignación de " + Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().getNomRazonS() + ":");
			else
				System.out.println("Lista de asignación de " +Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().getNombre()+Agencia.getInstance().getListaCoincidencias().get(i).getEmpleador().getApellido() + ":");
			
			for(int j=0; j < Agencia.getInstance().getListaCoincidencias().get(i).getListEmpleadosPretensos().size(); j++) {
				System.out.println(Agencia.getInstance().getListaCoincidencias().get(i).getListEmpleadosPretensos().get(j).getNombre()+Agencia.getInstance().getListaCoincidencias().get(i).getListEmpleadosPretensos().get(j).getApellido());
			}
		}
		
		Agencia.getInstance().actualizacionPuntajeUsuario();
		Agencia.getInstance().setSaldoAgencia(Agencia.getInstance().getListaCoincidencias());
		
		System.out.println("Saldo de la agencia $"+Agencia.getInstance().getSaldoAgencia());
	}

}
