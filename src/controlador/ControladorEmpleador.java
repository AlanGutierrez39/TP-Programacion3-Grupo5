package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import paquete.Agencia;
import vista.IVistaEmpleador;
import vista.VentanaEmpleador;

public class ControladorEmpleador implements ActionListener, Observer
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaEmpleador vista;
	
	public ControladorEmpleador()
	{
		this.vista = new VentanaEmpleador();
		this.vista.setActionListener(this);
	}

	public Agencia getAgencia()
	{
		return agencia;
	}

	public void setAgencia(Agencia agencia)
	{
		this.agencia = agencia;
	}

	public IVistaEmpleador getVista()
	{
		return vista;
	}

	public void setVista(IVistaEmpleador vista)
	{
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{}

	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
	}

}
