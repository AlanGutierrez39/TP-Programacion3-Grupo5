package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.FormularioBusqueda;
import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Persona;
import vista.IVistaEmpleadoPretenso;
import vista.VentanaEmpleadoPretenso;

public class ControladorEmpleadoPretenso implements ActionListener
{
	private Agencia agencia = Agencia.getInstance();
	private IVistaEmpleadoPretenso vista;

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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getActionCommand().equalsIgnoreCase("Registrarse"))
		{
			EmpleadoPretenso empleado = new EmpleadoPretenso(new Domicilio(this.vista.getTextField_5().getText(), Integer.parseInt(this.vista.getTextField_8().getText()), this.vista.getTextField_9().getText()) , this.vista.getTextField_6().getText(), this.vista.getTextField_7().getText(), this.vista.getTextField_1().getText(), this.vista.getPasswordField_1().getText(), this.vista.getTextField_2().getText(), this.vista.getTextField_3().getText(), Integer.parseInt(this.vista.getTextField_4().getText()), null);
			Agencia.getInstance().agregarEmpleadoPretenso(empleado);
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
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
			}
		}
		else if (e.getActionCommand().equalsIgnoreCase("Crear ticket")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getEmpleadosPretensos().size() && !Agencia.getInstance().getEmpleadosPretensos().get(i).getNombUsuario().equals(usuario))
				i++;
			Agencia.getInstance().getEmpleadosPretensos().get(i).setTicket(new TicketEmpleadoPretenso(new FormularioBusqueda(this.vista.getButtonGroup().getSelection().getActionCommand(), this.vista.getButtonGroup_1().getSelection().getActionCommand(), this.vista.getButtonGroup_2().getSelection().getActionCommand(), this.vista.getButtonGroup_3().getSelection().getActionCommand(), this.vista.getButtonGroup_4().getSelection().getActionCommand(), this.vista.getButtonGroup_5().getSelection().getActionCommand(), this.vista.getButtonGroup_6().getSelection().getActionCommand(), this.vista.getButtonGroup_7().getSelection().getActionCommand()), new Date(2022, 05, 23)));
		}
		else if (e.getActionCommand().equalsIgnoreCase("Ver ticket")) {
			String usuario;
			if (!this.vista.getTextField().getText().isBlank())
				usuario = this.vista.getTextField().getText();
			else
				usuario = this.vista.getTextField_1().getText();
			int i = 0;
			while (i < Agencia.getInstance().getEmpleadosPretensos().size() && !Agencia.getInstance().getEmpleadosPretensos().get(i).getNombUsuario().equals(usuario))
				i++;
			Ticket ticket = Agencia.getInstance().getEmpleadosPretensos().get(i).getTicket();
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
			//this.vista.getTable().setValueAt(Agencia.getInstance().getEmpleadosPretensos().get(i)., 10, 1);//ACA MOSTRARIA EL RESULTADO.
		}
	}
}
