package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import paquete.Agencia;
import vista.IVistaAgencia;
import vista.VentanaAgencia;

public class ControladorAgencia implements ActionListener
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaAgencia vista;
	
	public ControladorAgencia()
	{
		super();
		this.vista = new VentanaAgencia();
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

	public IVistaAgencia getVista()
	{
		return vista;
	}

	public void setVista(IVistaAgencia vista)
	{
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equalsIgnoreCase("Empleadores"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadores().size(); i++) {
			    listModel.addElement(Agencia.getInstance().getEmpleadores().get(i).getNombUsuario());
			}
			
		} else if (e.getActionCommand().equalsIgnoreCase("Solicitud empleadores"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadoresActivos().size(); i++) {
			    listModel.addElement(Agencia.getInstance().getEmpleadoresActivos().get(i).getNombUsuario());
			}
			//Agencia.getInstance().mostrarEmpleadores(Agencia.getInstance().getEmpleadoresActivos());
		} else if (e.getActionCommand().equalsIgnoreCase("Empleados"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadosPretensos().size(); i++) {
			    listModel.addElement(Agencia.getInstance().getEmpleadosPretensos().get(i).getNombUsuario());
			}
			//Agencia.getInstance().mostrarEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensos());
		} else if (e.getActionCommand().equalsIgnoreCase("Solicitud empleados"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadosPretensosActivos().size(); i++) {
			    listModel.addElement(Agencia.getInstance().getEmpleadosPretensosActivos().get(i).getNombUsuario());
			}
			//Agencia.getInstance().mostrarEmpleadosPretensos(Agencia.getInstance().getEmpleadosPretensosActivos());
		}else if (e.getActionCommand().equalsIgnoreCase("Activar Ronda de Encuentros Laborales"))
		{
			Agencia.getInstance().activarRondaEncuentrosLaborales();
		} else if (e.getActionCommand().equalsIgnoreCase("Activar Ronda de Contratación"))
		{
			Agencia.getInstance().activarRondaEleccion();
			this.vista.getLblNewLabel().setText("$" + Agencia.getInstance().getSaldoAgencia());
		}
	}
}
