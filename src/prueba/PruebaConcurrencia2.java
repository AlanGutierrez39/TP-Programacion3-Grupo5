package prueba;

import java.sql.Date;

import modelo.FormularioBusqueda;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import modelo.TicketSimplificado;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import paquete.ValoracionAspecto;
import util.Util;

public class PruebaConcurrencia2 {

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
		
				
		
		Thread hilo1 = new Thread(empleador1);
		Thread hilo2 = new Thread(empleador2);
		Thread hilo3 = new Thread(empleador3);
		
		Thread hilo4 = new Thread(empleadoPretenso1);
		Thread hilo5 = new Thread(empleadoPretenso2);
		Thread hilo6 = new Thread(empleadoPretenso3);
		Thread hilo7 = new Thread(empleadoPretenso4);
		Thread hilo8 = new Thread(empleadoPretenso5);
		
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		hilo6.start();
		hilo7.start();
		hilo8.start();
		
		
		Agencia.getInstance().generarUsusariosActivos();
		
		Agencia.getInstance().activarRondaEncuentrosLaborales();

		
		/*
		Util.espera();
		Agencia.getInstance().actualizacionPuntajeUsuario();
		Agencia.getInstance().setSaldoAgencia(Agencia.getInstance().getListaCoincidencias());
		
		
		System.out.println("Saldo de la agencia $"+Agencia.getInstance().getSaldoAgencia());
		
		System.out.println(Agencia.getInstance().getBolsaDeEmpleo().size());
		*/
	}
}

