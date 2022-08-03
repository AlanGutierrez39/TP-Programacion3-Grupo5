package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.FormularioBusqueda;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import vista.IVistaEmpleadoPretenso;
import vista.VentanaEmpleadoPretenso;

public class ControladorEmpleadoPretenso implements ActionListener
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaEmpleadoPretenso vista;
	private Empleador empleadorElegido;
	private String usuario;
	private int i;

	public ControladorEmpleadoPretenso()
	{
		this.vista = new VentanaEmpleadoPretenso();
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

	public IVistaEmpleadoPretenso getVista()
	{
		return vista;
	}

	public void setVista(IVistaEmpleadoPretenso vista)
	{
		this.vista = vista;
		this.vista.setActionListener(this);
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
		while (i < Agencia.getInstance().getEmpleadosPretensos().size() && !Agencia.getInstance().getEmpleadosPretensos().get(i).getNombUsuario().equals(this.usuario))
			i++;
		this.i = i;
	}

	public Empleador getEmpleadorElegido()
	{
		return empleadorElegido;
	}

	public void setEmpleadorElegido(Empleador empleadorElegido)
	{
		this.empleadorElegido = empleadorElegido;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equalsIgnoreCase("Registrarse"))
		{
			EmpleadoPretenso empleado = new EmpleadoPretenso(new Domicilio(this.vista.getTextField_5().getText(), Integer.parseInt(this.vista.getTextField_8().getText()), this.vista.getTextField_9().getText()) , this.vista.getTextField_6().getText(), this.vista.getTextField_7().getText(), this.vista.getTextField_1().getText(), this.vista.getPasswordField_1().getText(), this.vista.getTextField_2().getText(), this.vista.getTextField_3().getText(), Integer.parseInt(this.vista.getTextField_4().getText()), null);
			setUsuario(this.vista.getTextField_1().getText());
			setI(0);
			Thread hilo = new Thread(Agencia.getInstance().getEmpleadosPretensos().get(this.i));
			hilo.start();
			//Agencia.getInstance().agregarEmpleadoPretenso(empleado);
		}
		else if (e.getActionCommand().equalsIgnoreCase("Entrar"))
		{
			try
			{
				Agencia.getInstance().login(this.vista.getTextField().getText(), this.vista.getPasswordField().getText());
				setUsuario(this.vista.getTextField().getText());
				setI(0);
				Thread hilo = new Thread(Agencia.getInstance().getEmpleadosPretensos().get(this.i));
				hilo.start();
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
			Agencia.getInstance().getEmpleadosPretensos().get(this.i).setTicket(new TicketEmpleadoPretenso(new FormularioBusqueda(this.vista.getButtonGroup().getSelection().getActionCommand(), this.vista.getButtonGroup_1().getSelection().getActionCommand(), this.vista.getButtonGroup_2().getSelection().getActionCommand(), this.vista.getButtonGroup_3().getSelection().getActionCommand(), this.vista.getButtonGroup_4().getSelection().getActionCommand(), this.vista.getButtonGroup_5().getSelection().getActionCommand(), this.vista.getButtonGroup_6().getSelection().getActionCommand(), this.vista.getButtonGroup_7().getSelection().getActionCommand()), new Date(2022, 06, 28)));
			Agencia.getInstance().getEmpleadosPretensos().get(this.i).getPuntajeUsuario();
		}
		else if (e.getActionCommand().equalsIgnoreCase("Ver ticket")) {
			try
			{
				TicketEmpleadoPretenso ticket = Agencia.getInstance().getEmpleadosPretensos().get(this.i).getTicket();
				this.vista.getTable().setValueAt(ticket.getFbTicket().getLocacion(), 0, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getRemuneracion(), 1, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getCargaHoraria(), 2, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getTipoPuesto(), 3, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getRangoEtario(), 4, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getExperienciaPrevia(), 5, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getEstudiosCursados(), 6, 1);
				this.vista.getTable().setValueAt(ticket.getFbTicket().getTipoTrabajo(), 7, 1);
				this.vista.getTable().setValueAt(ticket.getFechaTicket(), 8, 1);
				this.vista.getTable().setValueAt(ticket.getEstado().toString(), 9, 1);
				int j=0;
				while (j < Agencia.getInstance().getListaCoincidencias().size() && !Agencia.getInstance().getListaCoincidencias().get(j).getEmpleador().equals(this.empleadorElegido))
					j++;
				try
				{
					if (Agencia.getInstance().getListaCoincidencias().get(j).getListEmpleadosPretensos().get(0).getNombUsuario().equals(this.usuario))
						this.vista.getTable().setValueAt("\u00c9xito", 10, 1);
					else
						this.vista.getTable().setValueAt("Fracaso", 10, 1);
				} catch (Exception e1)
				{
					this.vista.getTable().setValueAt("Todavía no hubo ronda", 10, 1);
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Necesita crear un ticket.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Mostrar lista")) {
			try
			{
				Agencia.getInstance().actualizacionPuntajeUsuario();
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				this.vista.getList().setModel(listModel);
				for(int j=0; j<Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(this.i).getListEmpleadores().size(); j++) {
					if (Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).isPersonaJuridica())
						listModel.addElement(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).getNomRazonS());
					else
						listModel.addElement(Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).getNombre() + " " + Agencia.getInstance().getListAsignacionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).getApellido());
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Lista vac\u00eda.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Elegir")) {
			String nombreEmpleadorElegido, nombre[];
			int j=0;
			nombreEmpleadorElegido = this.vista.getList().getSelectedValue();
			nombre = nombreEmpleadorElegido.split(" ");
			while (j < Agencia.getInstance().getEmpleadores().size() && (!(Agencia.getInstance().getEmpleadores().get(j).getNombre() == null) && !Agencia.getInstance().getEmpleadores().get(j).getNombre().equals(nombre[0]) || !(Agencia.getInstance().getEmpleadores().get(j).getNomRazonS() == null) && !Agencia.getInstance().getEmpleadores().get(j).getNomRazonS().contentEquals(nombre[0])))
				j++;
			if (Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().isEmpty() || Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores() == null)
			{
				setEmpleadorElegido(Agencia.getInstance().getEmpleadores().get(j));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No puede elegir m\u00e1s empleadores.");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Mostrar elecci\u00f3n")) {
			try
			{
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				this.vista.getList_1().setModel(listModel);
				for(int j=0; j<Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().size(); j++) {
					if (Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).isPersonaJuridica())
						listModel.addElement(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).getNomRazonS());
					else
						listModel.addElement(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).getNombre() + " " + Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j).getApellido());
					setEmpleadorElegido(Agencia.getInstance().getListEleccionEmpleadoPretensos().get(this.i).getListEmpleadores().get(j));
				}
			} catch (Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Lista vac\u00eda.");
			}
		}
	}
}
