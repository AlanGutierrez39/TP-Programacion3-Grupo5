package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

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
			    if (Agencia.getInstance().getEmpleadores().get(i).isPersonaJuridica())
					listModel.addElement(Agencia.getInstance().getEmpleadores().get(i).getNomRazonS());
				else
					listModel.addElement(Agencia.getInstance().getEmpleadores().get(i).getNombre() + " " + Agencia.getInstance().getEmpleadores().get(i).getApellido());
			}
		} else if (e.getActionCommand().equalsIgnoreCase("Solicitud empleadores"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadoresActivos().size(); i++) {
				if (Agencia.getInstance().getEmpleadoresActivos().get(i).isPersonaJuridica())
					listModel.addElement(Agencia.getInstance().getEmpleadoresActivos().get(i).getNomRazonS());
				else
					listModel.addElement(Agencia.getInstance().getEmpleadoresActivos().get(i).getNombre() + " " + Agencia.getInstance().getEmpleadoresActivos().get(i).getApellido());
			}
		} else if (e.getActionCommand().equalsIgnoreCase("Empleados"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadosPretensos().size(); i++) {
			    listModel.addElement(Agencia.getInstance().getEmpleadosPretensos().get(i).getNombre() + " " + Agencia.getInstance().getEmpleadosPretensos().get(i).getApellido());
			}
		} else if (e.getActionCommand().equalsIgnoreCase("Solicitud empleados"))
		{
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			this.vista.getList1().setModel(listModel);
			for(int i=0; i<Agencia.getInstance().getEmpleadosPretensosActivos().size(); i++) {
			    listModel.addElement(Agencia.getInstance().getEmpleadosPretensosActivos().get(i).getNombre() + " " + Agencia.getInstance().getEmpleadosPretensos().get(i).getApellido());
			}
		}else if (e.getActionCommand().equalsIgnoreCase("Activar Ronda de Encuentros Laborales"))
		{
			Agencia.getInstance().generarUsusariosActivos();
			Agencia.getInstance().activarRondaEncuentrosLaborales();
		} else if (e.getActionCommand().equalsIgnoreCase("Activar Ronda de Contratación"))
			Agencia.getInstance().activarRondaEleccion();
		else if (e.getActionCommand().equalsIgnoreCase("Calcular comisi\u00f3n"))
		{
				DecimalFormat df = new DecimalFormat("0.00");
				Agencia.getInstance().actualizacionPuntajeUsuario();
				Agencia.getInstance().setSaldoAgencia(Agencia.getInstance().getListaCoincidencias());
				this.vista.getLblNewLabel().setText("$" + df.format(Agencia.getInstance().getSaldoAgencia()));
		}
	}
}
