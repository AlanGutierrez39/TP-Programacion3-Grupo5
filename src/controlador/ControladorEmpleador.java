package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.FormularioBusqueda;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import vista.IVistaEmpleador;
import vista.VentanaEmpleador;

public class ControladorEmpleador implements ActionListener
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
	{
		if (e.getActionCommand().equalsIgnoreCase("Registrarse"))
		{
			Empleador empleador;
			if (this.vista.getGroup().getSelection().getActionCommand().equalsIgnoreCase("F\u00edsica"))
				empleador = new Empleador(new Domicilio(this.vista.getTextField_5().getText(), 0, null) , this.vista.getTextField_6().getText(), this.vista.getTextField_7().getText(), this.vista.getTextField_1().getText(), this.vista.getPasswordField_1().getText(), this.vista.getTextField_2().getText(), this.vista.getTextField_3().getText(), Integer.parseInt(this.vista.getTextField_4().getText()), this.vista.getButtonGroup_7().getSelection().getActionCommand(), null, null);
			else
				empleador = new Empleador(new Domicilio(this.vista.getTextField_5().getText(), 0, null) , this.vista.getTextField_6().getText(), this.vista.getTextField_7().getText(), this.vista.getTextField_1().getText(), this.vista.getPasswordField_1().getText(), this.vista.getTextField_2().getText(), this.vista.getButtonGroup_7().getSelection().getActionCommand(), null, null);
			Agencia.getInstance().agregarEmpleador(empleador);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Entrar"))
		{
			try
			{
				Agencia.getInstance().login(this.vista.getTextField().getText(), this.vista.getPasswordField().getText());
				this.vista.getTabbedPane().setEnabledAt(0, false);
				this.vista.getTabbedPane().setEnabledAt(1, false);
				this.vista.getTabbedPane().setSelectedIndex(2);
				this.vista.getTabbedPane().setEnabledAt(2, true);
				this.vista.getTabbedPane().setEnabledAt(3, true);
				this.vista.getTabbedPane().setEnabledAt(4, true);
			} catch (NombreDeUsuarioIncorrectoException e1)
			{
				JOptionPane.showMessageDialog(null, "Nombre de usuario incorrecto");
			} catch (ContrasenaIncorrectaException e1)
			{
				JOptionPane.showMessageDialog(null, "Contrase\u00f1a incorrecta");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Crear ticket")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getEmpleadores().size() && !Agencia.getInstance().getEmpleadores().get(i).getNombUsuario().equals(usuario))
				i++;
			//Agencia.getInstance().getEmpleadores().get(i).setTicket(new TicketEmpleador(new FormularioBusqueda(this.vista.getButtonGroup().getSelection().getActionCommand(), this.vista.getButtonGroup_1().getSelection().getActionCommand(), this.vista.getButtonGroup_2().getSelection().getActionCommand(), this.vista.getButtonGroup_3().getSelection().getActionCommand(), this.vista.getButtonGroup_4().getSelection().getActionCommand(), this.vista.getButtonGroup_5().getSelection().getActionCommand(), this.vista.getButtonGroup_6().getSelection().getActionCommand(), this.vista.getButtonGroup_8().getSelection().getActionCommand()), new Date(2022, 06, 28), 1, 0));
			//falta setTicket
		}else if (e.getActionCommand().equalsIgnoreCase("Ver ticket")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getEmpleadores().size() && !Agencia.getInstance().getEmpleadores().get(i).getNombUsuario().equals(usuario))
				i++;
			try
			{
				Ticket ticket = Agencia.getInstance().getEmpleadores().get(i).getTicket();
				this.vista.getTable().setValueAt(ticket.getFbTicket().getLocacion(), 0, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getRemuneracion(), 1, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getCargaHoraria(), 2, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getTipoPuesto(), 3, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getRangoEtario(), 4, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getExperienciaPrevia(), 5, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getEstudiosCursados(), 6, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getTipoTrabajo(), 7, 1);
				this.vista.getTable().setValueAt(ticket.getFechaTicket(), 8, 1);
				this.vista.getTable().setValueAt(ticket.getEstado().ticketDisponible(), 9, 1);
				//this.vista.getTable().setValueAt(Agencia.getInstance().getEmpleadores().get(i)., 10, 1);
				//this.vista.getTable().setValueAt(ticket.getEstadoTicket(), 11, 1);
				//this.vista.getTable().setValueAt(Agencia.getInstance().getEmpleadores().get(i)., 12, 1);//AC\u00c1 MOSTRAR\u00cdA EL RESULTADO.
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Necesita crear un ticket.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Mostrar lista")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getListAsignacionEmpleador().size() && !Agencia.getInstance().getListAsignacionEmpleador().get(i).getEmpleador().getNombUsuario().equals(usuario))
				i++;
			try
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				this.vista.getList().setModel(listModel);
				for(int j=0; j<Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
				    listModel.addElement(Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre() + " " + Agencia.getInstance().getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Lista vac\u00eda.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Mostrar elecci\u00f3n")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getListEleccionEmpleador().size() && !Agencia.getInstance().getListEleccionEmpleador().get(i).getEmpleador().getNombUsuario().equals(usuario))
				i++;
			try
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				this.vista.getList().setModel(listModel);
				for(int j=0; j<Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
				    listModel.addElement(Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre() + " " + Agencia.getInstance().getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Lista vac\u00eda.");
			}
		}
	}

}
