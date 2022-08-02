package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.Ticket;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.Empleador;
import vista.IVistaEmpleador;
import vista.VentanaEmpleador;

public class ControladorEmpleador implements ActionListener
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaEmpleador vista;
	private String usuario;
	private int i;
	
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

	public String getUsuario()
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public int getI()
	{
		return i;
	}

	public void setI(int i)
	{
		while (i < Agencia.getInstance().getEmpleadores().size() && !Agencia.getInstance().getEmpleadores().get(i).getNombUsuario().equals(this.usuario))
			i++;
		this.i = i;
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
			setUsuario(this.vista.getTextField_1().getText());
			setI(0);
			Agencia.getInstance().agregarEmpleador(empleador);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Entrar"))
		{
			try
			{
				Agencia.getInstance().login(this.vista.getTextField().getText(), this.vista.getPasswordField().getText());
				setUsuario(this.vista.getTextField().getText());
				setI(0);
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
			//Agencia.getInstance().getEmpleadores().get(i).setTicket(new TicketEmpleador(new FormularioBusqueda(this.vista.getButtonGroup().getSelection().getActionCommand(), this.vista.getButtonGroup_1().getSelection().getActionCommand(), this.vista.getButtonGroup_2().getSelection().getActionCommand(), this.vista.getButtonGroup_3().getSelection().getActionCommand(), this.vista.getButtonGroup_4().getSelection().getActionCommand(), this.vista.getButtonGroup_5().getSelection().getActionCommand(), this.vista.getButtonGroup_6().getSelection().getActionCommand(), this.vista.getButtonGroup_8().getSelection().getActionCommand()), new Date(2022, 06, 28), 1, 0));
			//falta setTicket
		}else if (e.getActionCommand().equalsIgnoreCase("Ver ticket")) {
			try
			{
				Ticket ticket = Agencia.getInstance().getEmpleadores().get(this.i).getTicket();
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
				int j=0;
				while (j < Agencia.getInstance().getListaCoincidencias().size() && !Agencia.getInstance().getListaCoincidencias().get(j).getEmpleador().getNombUsuario().equals(this.usuario))
					j++;
				try
				{
					this.vista.getTable().setValueAt(Agencia.getInstance().getListaCoincidencias().get(j).getListEmpleadosPretensos().size(), 11, 1);
					if (!Agencia.getInstance().getListaCoincidencias().get(j).getListEmpleadosPretensos().isEmpty())
						this.vista.getTable().setValueAt("\u00c9xito", 12, 1);
					else
						this.vista.getTable().setValueAt("Fracaso", 12, 1);
				} catch (Exception e1)
				{
					this.vista.getTable().setValueAt(0, 11, 1);
					this.vista.getTable().setValueAt("Todavía no hubo ronda", 12, 1);
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Necesita crear un ticket.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Mostrar lista")) {
			try
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				this.vista.getList().setModel(listModel);
				for(int j=0; j<Agencia.getInstance().getListAsignacionEmpleador().get(this.i).getListEmpleadosPretensos().size(); j++) {
				    listModel.addElement(Agencia.getInstance().getListAsignacionEmpleador().get(this.i).getListEmpleadosPretensos().get(j).getNombre() + " " + Agencia.getInstance().getListAsignacionEmpleador().get(this.i).getListEmpleadosPretensos().get(j).getApellido());
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Lista vac\u00eda.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Elegir")) {
			String empleadoElegido, nombre[];
			int j=0, l=0;
			empleadoElegido = this.vista.getList().getSelectedValue();
			nombre = empleadoElegido.split(" ");
			while (j < Agencia.getInstance().getEmpleadosPretensos().size() && !Agencia.getInstance().getEmpleadosPretensos().get(j).getNombre().equals(nombre[0]))
				j++;
			while (l < Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().size() && !Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().get(l).getNombre().equals(nombre[0]))
				l++;
			if (l==Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().size())
				Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().add(l, Agencia.getInstance().getEmpleadosPretensos().get(j));
			else
				JOptionPane.showMessageDialog(null, "Empleado ya elegido.");
		}
		else if (e.getActionCommand().equalsIgnoreCase("Mostrar elecci\u00f3n")) {
			try
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				this.vista.getList_1().setModel(listModel);
				for(int j=0; j<Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().size(); j++) {
				    listModel.addElement(Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().get(j).getNombre() + " " + Agencia.getInstance().getListEleccionEmpleador().get(this.i).getListEmpleadosPretensos().get(j).getApellido());
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Lista vac\u00eda.");
			}
		}
	}
}
