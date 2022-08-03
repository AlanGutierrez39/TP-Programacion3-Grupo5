package prueba;

import java.util.ArrayList;

import controlador.ControladorAgencia;
import controlador.ControladorEmpleadoPretenso;
import controlador.ControladorEmpleador;
import paquete.Agencia;
import persistencia.AgenciaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;
import util.Util;

public class PruebaGeneral
{

	public static void main(String[] args)
	{
		IPersistencia idao = new PersistenciaXML();
		try
		{
		    idao.abrirInput("agencia.xml");
		    AgenciaDTO agenciaDTO = (AgenciaDTO) idao.leer();
		    Util.agenciaFromAgenciaDTO(agenciaDTO);///usa el singleton
		    idao.cerrarInput();
		} catch (Exception e)
		{
		    System.out.println("Exception " + e.getMessage());
		}
		ArrayList<Thread> hilo = new ArrayList<Thread>();
		for (int i = 0; i < Agencia.getInstance().getEmpleadores().size(); i++)
		{
			hilo.add(new Thread(Agencia.getInstance().getEmpleadores().get(i)));
		}
		for (int i = 0; i < Agencia.getInstance().getEmpleadosPretensos().size(); i++)
		{
			hilo.add(new Thread(Agencia.getInstance().getEmpleadosPretensos().get(i)));
		}
		for (int i = 0; i < hilo.size(); i++)
		{
			hilo.get(i).start();
		}
		
		ControladorAgencia controlador1 = new ControladorAgencia();
		ControladorEmpleador controlador2 = new ControladorEmpleador();
		ControladorEmpleadoPretenso controlador3 = new ControladorEmpleadoPretenso();
		
	}

}
