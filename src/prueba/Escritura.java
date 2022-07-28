package prueba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import modelo.FormularioBusqueda;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.ValoracionAspecto;
import persistencia.AgenciaDTO;

import persistencia.IPersistencia;
import persistencia.PersistenciaXML;
import util.Util;

public class Escritura
{

    public static void main(String[] args)
    {
	IPersistencia idao = new PersistenciaXML();

	
	
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
	
	
	ArrayList<Empleador> emp = new ArrayList<Empleador>();
	emp.add(empleador1);
	emp.add(empleador2);
	emp.add(empleador3);
	
	
	
	
	ArrayList<	EmpleadoPretenso> empresa = new ArrayList<	EmpleadoPretenso>();
	empresa.add(empleadoPretenso1);
	empresa.add(empleadoPretenso2);
	empresa.add(empleadoPretenso3);
	empresa.add(empleadoPretenso4);
	empresa.add(empleadoPretenso5);
	

	Agencia.getInstance().setEmpleadosPretensos(empresa);
	Agencia.getInstance().setEmpleadores(emp);
	


	
	try
    {
		idao.abrirOutput("agencia.xml");
        System.out.println("Crea archivo escritura");
        AgenciaDTO edto=Util.agenciaDTOfromAgencia();
        
        idao.escribir(edto);
        
        
        System.out.println("grabada exitosamente");
        idao.cerrarOutput();
        System.out.println("Archivo cerrado");
    } catch (IOException e)
    {
        // TODO Auto-generated catch block
        System.out.println(e.getLocalizedMessage());
    }


    }
}
