package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import modelo.Ticket;
import modelo.TicketEmpleadoPretenso;
import paquete.Empleador;

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;

public class VentanaEmpleadoPretenso extends JFrame implements IVistaEmpleadoPretenso, KeyListener, MouseListener
{
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFormattedTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JFormattedTextField textField_8;
	private JTextField textField_9;
	private ActionListener actionListener;
	private JButton loginButton;
	private JButton registroButton;
	private JTabbedPane tabbedPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					VentanaEmpleadoPretenso frame = new VentanaEmpleadoPretenso();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEmpleadoPretenso()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(30, 144, 255));
		tabbedPane.setBorder(new TitledBorder(null, "Empleado Pretenso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_Login = new JPanel();
		tabbedPane.addTab("Login", null, panel_Login, "Login");
		panel_Login.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panelColumna_1 = new JPanel();
		panelColumna_1.setPreferredSize(new Dimension(180, 720));
		panelColumna_1.setBackground(new Color(30, 144, 255));
		panel_Login.add(panelColumna_1);
		
		JPanel panelColumna_2 = new JPanel();
		panelColumna_2.setPreferredSize(new Dimension(360, 720));
		panelColumna_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColumna_2.setBackground(new Color(30, 144, 255));
		panel_Login.add(panelColumna_2);
		panelColumna_2.setLayout(new GridLayout(8, 0, 0, 0));
		
		JLabel cartelBienvenido = new JLabel("Bienvenido");
		cartelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		cartelBienvenido.setForeground(Color.WHITE);
		cartelBienvenido.setFont(new Font("Dialog", Font.BOLD, 18));
		panelColumna_2.add(cartelBienvenido);
		
		JLabel titulo = new JLabel("Sistema de Gestión de Búsquedas Laborales");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(titulo);
		
		JPanel panel_Usuario = new JPanel();
		panelColumna_2.add(panel_Usuario);
		panel_Usuario.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Usuario.add(usuarioLabel);
		
		JPanel panel_1 = new JPanel();
		panel_Usuario.add(panel_1);
		
		textField = new JTextField();
		textField.setToolTipText("Usuario");
		textField.setColumns(20);
		this.textField.addKeyListener(this);
		panel_1.add(textField);
		
		JPanel panel_Contrasena = new JPanel();
		panelColumna_2.add(panel_Contrasena);
		panel_Contrasena.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel contrasenaLabel = new JLabel("Contraseña");
		contrasenaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Contrasena.add(contrasenaLabel);
		
		JPanel panel_2 = new JPanel();
		panel_Contrasena.add(panel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Contraseña");
		passwordField.setColumns(20);
		this.passwordField.addKeyListener(this);
		panel_2.add(passwordField);
		
		JPanel panel_Boton = new JPanel();
		panelColumna_2.add(panel_Boton);
		
		this.loginButton = new JButton("Entrar");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(2);
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setEnabledAt(3, true);
				tabbedPane.setEnabledAt(4, true);
				tabbedPane.setEnabledAt(5, true);
			}
		});
		loginButton.setToolTipText("Entrar");
		panel_Boton.add(loginButton);
		this.loginButton.setEnabled(false);
		
		JLabel contrasenaOlvidada = new JLabel("¿Olvidaste la contraseña?");
		contrasenaOlvidada.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2.add(contrasenaOlvidada);
		
		JPanel panel_BotonRegistrate = new JPanel();
		panel_BotonRegistrate.setBackground(new Color(30, 144, 255));
		panelColumna_2.add(panel_BotonRegistrate);
		panel_BotonRegistrate.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel nuevoUsuario = new JLabel("¿Nuevo usuario?");
		panel_BotonRegistrate.add(nuevoUsuario);
		nuevoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel_Boton_2 = new JPanel();
		panel_Boton_2.setBackground(new Color(30, 144, 255));
		panel_BotonRegistrate.add(panel_Boton_2);
		
		JButton registrarseButton = new JButton("¡Registrate!");
		registrarseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		registrarseButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Boton_2.add(registrarseButton);
		registrarseButton.setToolTipText("¡Registrate!");
		registrarseButton.setEnabled(true);
		
		JPanel panelColumna_3 = new JPanel();
		panelColumna_3.setPreferredSize(new Dimension(180, 720));
		panelColumna_3.setBackground(new Color(30, 144, 255));
		panel_Login.add(panelColumna_3);
		
		JPanel panel_Registro = new JPanel();
		tabbedPane.addTab("Registro", null, panel_Registro, "Registro");
		panel_Registro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelColumna_1_1 = new JPanel();
		panelColumna_1_1.setPreferredSize(new Dimension(100, 10));
		panelColumna_1_1.setBackground(new Color(30, 144, 255));
		panel_Registro.add(panelColumna_1_1, BorderLayout.WEST);
		
		JPanel panelColumna_2_1 = new JPanel();
		panelColumna_2_1.setPreferredSize(new Dimension(360, 720));
		panelColumna_2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Registro.add(panelColumna_2_1, BorderLayout.CENTER);
		panelColumna_2_1.setLayout(new GridLayout(10, 0, 0, 0));
		
		JPanel panel_NombreNuevo = new JPanel();
		panelColumna_2_1.add(panel_NombreNuevo);
		panel_NombreNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NombreNuevo.add(nombreLabel);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_NombreNuevo.add(panel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Nombre");
		textField_2.setColumns(30);
		this.textField_2.addKeyListener(this);
		panel_1_1_1.add(textField_2);
		
		JPanel panel_ApellidoNuevo = new JPanel();
		panelColumna_2_1.add(panel_ApellidoNuevo);
		panel_ApellidoNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel apellidoLabel = new JLabel("Apellido:");
		apellidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ApellidoNuevo.add(apellidoLabel);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_ApellidoNuevo.add(panel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Apellido");
		panel_2_1_1.add(textField_3);
		textField_3.setColumns(30);
		this.textField_3.addKeyListener(this);
		
		JPanel panel_NombreNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_NombreNuevo_1);
		panel_NombreNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel nombreLabel_1 = new JLabel("Edad:");
		nombreLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_NombreNuevo_1.add(nombreLabel_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_NombreNuevo_1.add(panel_1_1_1_1);
		
		textField_4 = new JFormattedTextField();
		textField_4.setToolTipText("Edad");
		textField_4.setColumns(5);
		this.textField_4.addKeyListener(this);
		panel_1_1_1_1.add(textField_4);
		
		JPanel panel_DireccionNueva = new JPanel();
		panelColumna_2_1.add(panel_DireccionNueva);
		panel_DireccionNueva.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel direccionLabel = new JLabel("Dirección:");
		direccionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_DireccionNueva.add(direccionLabel);
		
		JPanel panel_Direccion = new JPanel();
		panel_DireccionNueva.add(panel_Direccion);
		panel_Direccion.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_Direccion.add(panel_5);
		
		textField_5 = new JTextField();
		panel_5.add(textField_5);
		textField_5.setToolTipText("Calle");
		textField_5.setColumns(15);
		this.textField_5.addKeyListener(this);
		
		JPanel panel_6 = new JPanel();
		panel_Direccion.add(panel_6);
		
		textField_8 = new JFormattedTextField();
		panel_6.add(textField_8);
		textField_8.setToolTipText("Número");
		textField_8.setColumns(5);
		this.textField_8.addKeyListener(this);
		
		JPanel panel_7 = new JPanel();
		panel_Direccion.add(panel_7);
		
		textField_9 = new JTextField();
		panel_7.add(textField_9);
		textField_9.setToolTipText("Descripción");
		textField_9.setColumns(10);
		this.textField_9.addKeyListener(this);
		
		JPanel panel_UsuarioNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_UsuarioNuevo_1);
		panel_UsuarioNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel usuarioLabel_1_1 = new JLabel("Teléfono:");
		usuarioLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_UsuarioNuevo_1.add(usuarioLabel_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_UsuarioNuevo_1.add(panel_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Teléfono");
		textField_6.setColumns(30);
		this.textField_6.addKeyListener(this);
		panel_1_1_2.add(textField_6);
		
		JPanel panel_ContrasenaNuevo_1 = new JPanel();
		panelColumna_2_1.add(panel_ContrasenaNuevo_1);
		panel_ContrasenaNuevo_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel contrasenaLabel_1_1 = new JLabel("e-Mail:");
		contrasenaLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ContrasenaNuevo_1.add(contrasenaLabel_1_1);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_ContrasenaNuevo_1.add(panel_2_1_2);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("e-Mail");
		panel_2_1_2.add(textField_7);
		textField_7.setColumns(30);
		this.textField_7.addKeyListener(this);
		
		JPanel panel_UsuarioNuevo = new JPanel();
		panelColumna_2_1.add(panel_UsuarioNuevo);
		panel_UsuarioNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel usuarioLabel_1 = new JLabel("Nombre de Usuario:");
		usuarioLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_UsuarioNuevo.add(usuarioLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_UsuarioNuevo.add(panel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Usuario");
		textField_1.setColumns(30);
		this.textField_1.addKeyListener(this);
		panel_1_1.add(textField_1);
		
		JPanel panel_ContrasenaNuevo = new JPanel();
		panelColumna_2_1.add(panel_ContrasenaNuevo);
		panel_ContrasenaNuevo.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel contrasenaLabel_1 = new JLabel("Contraseña:");
		contrasenaLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ContrasenaNuevo.add(contrasenaLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_ContrasenaNuevo.add(panel_2_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Contraseña");
		passwordField_1.setColumns(30);
		this.passwordField_1.addKeyListener(this);
		panel_2_1.add(passwordField_1);
		
		JLabel textoEnBlanco = new JLabel("");
		textoEnBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		panelColumna_2_1.add(textoEnBlanco);
		
		JPanel panel_Boton_1 = new JPanel();
		panelColumna_2_1.add(panel_Boton_1);
		
		this.registroButton = new JButton("Registrarse");
		registroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(2);
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setEnabledAt(3, true);
				tabbedPane.setEnabledAt(4, true);
				tabbedPane.setEnabledAt(5, true);
			}
		});
		registroButton.setToolTipText("Registrarse");
		panel_Boton_1.add(registroButton);
		this.registroButton.setEnabled(false);
		
		JPanel panelColumna_3_1 = new JPanel();
		panelColumna_3_1.setPreferredSize(new Dimension(100, 10));
		panelColumna_3_1.setBackground(new Color(30, 144, 255));
		panel_Registro.add(panelColumna_3_1, BorderLayout.EAST);
		
		JPanel panel_Ticket = new JPanel();
		panel_Ticket.setVisible(false);
		panel_Ticket.setToolTipText("Ticket");
		tabbedPane.addTab("Ticket", null, panel_Ticket, "Ticket");
		panel_Ticket.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_Ticket.add(panel_3, BorderLayout.CENTER);
		
		JList<TicketEmpleadoPretenso> listaDeTicketsEmpleadoPretenso = new JList<TicketEmpleadoPretenso>();
		listaDeTicketsEmpleadoPretenso.setVisible(false);
		panel_3.add(listaDeTicketsEmpleadoPretenso);
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(8, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Locación:");
		panel_4.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Home Office");
		buttonGroup.add(rdbtnNewRadioButton);
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Presencial");
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_4.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Indistinto");
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel_4.add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Remuneración:");
		panel_4.add(lblNewLabel_1);
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Hasta V1");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		
		panel_4.add(rdbtnNewRadioButton_3);
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Entre V1 y V2");
		buttonGroup_1.add(rdbtnNewRadioButton_1_1);
		
		panel_4.add(rdbtnNewRadioButton_1_1);
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Más de V2");
		buttonGroup_1.add(rdbtnNewRadioButton_2_1);
		
		panel_4.add(rdbtnNewRadioButton_2_1);
		JLabel lblNewLabel_2 = new JLabel("Carga Horaria:");
		panel_4.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Media");
		buttonGroup_2.add(rdbtnNewRadioButton_4);
		panel_4.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("Completa");
		buttonGroup_2.add(rdbtnNewRadioButton_1_2);
		panel_4.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_2_2 = new JRadioButton("Extendida");
		buttonGroup_2.add(rdbtnNewRadioButton_2_2);
		panel_4.add(rdbtnNewRadioButton_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Puesto:");
		panel_4.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Júnior");
		buttonGroup_3.add(rdbtnNewRadioButton_5);
		panel_4.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("Sénior");
		buttonGroup_3.add(rdbtnNewRadioButton_1_3);
		panel_4.add(rdbtnNewRadioButton_1_3);
		
		JRadioButton rdbtnNewRadioButton_2_3 = new JRadioButton("Managment");
		buttonGroup_3.add(rdbtnNewRadioButton_2_3);
		panel_4.add(rdbtnNewRadioButton_2_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rango Etario:");
		panel_4.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Menos de 40");
		buttonGroup_4.add(rdbtnNewRadioButton_6);
		panel_4.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_1_4 = new JRadioButton("Entre 40 y 50");
		buttonGroup_4.add(rdbtnNewRadioButton_1_4);
		panel_4.add(rdbtnNewRadioButton_1_4);
		
		JRadioButton rdbtnNewRadioButton_2_4 = new JRadioButton("Más de 50");
		buttonGroup_4.add(rdbtnNewRadioButton_2_4);
		panel_4.add(rdbtnNewRadioButton_2_4);
		
		JLabel lblNewLabel_5 = new JLabel("Experiencia previa:");
		panel_4.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Nada");
		buttonGroup_5.add(rdbtnNewRadioButton_7);
		panel_4.add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_1_5 = new JRadioButton("Media");
		buttonGroup_5.add(rdbtnNewRadioButton_1_5);
		panel_4.add(rdbtnNewRadioButton_1_5);
		
		JRadioButton rdbtnNewRadioButton_2_5 = new JRadioButton("Mucha");
		buttonGroup_5.add(rdbtnNewRadioButton_2_5);
		panel_4.add(rdbtnNewRadioButton_2_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estudios Cursados:");
		panel_4.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Primario");
		buttonGroup_6.add(rdbtnNewRadioButton_8);
		panel_4.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_1_6 = new JRadioButton("Secundario");
		buttonGroup_6.add(rdbtnNewRadioButton_1_6);
		panel_4.add(rdbtnNewRadioButton_1_6);
		
		JRadioButton rdbtnNewRadioButton_2_6 = new JRadioButton("Universitario");
		buttonGroup_6.add(rdbtnNewRadioButton_2_6);
		panel_4.add(rdbtnNewRadioButton_2_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_4.add(lblNewLabel_8);
		
		JButton btnNewButton_2 = new JButton("Crear ticket");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton_2);
		
		JLabel lblNewLabel_9 = new JLabel("");
		panel_4.add(lblNewLabel_9);
		tabbedPane.setEnabledAt(2, false);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(150, 10));
		panel_Ticket.add(panel, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Ver mis tickets");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDeTicketsEmpleadoPretenso.setVisible(true);
				panel_4.setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear nuevo ticket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDeTicketsEmpleadoPretenso.setVisible(false);
				panel_4.setVisible(true);
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				buttonGroup_3.clearSelection();
				buttonGroup_4.clearSelection();
				buttonGroup_5.clearSelection();
				buttonGroup_6.clearSelection();
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_ListaEmpleadores = new JPanel();
		panel_ListaEmpleadores.setVisible(false);
		panel_ListaEmpleadores.setToolTipText("Lista de Empleadores");
		tabbedPane.addTab("Lista de Empleadores", null, panel_ListaEmpleadores, "Lista de Empleadores");
		tabbedPane.setEnabledAt(3, false);
		
		JList<Empleador> list = new JList<Empleador>();
		panel_ListaEmpleadores.add(list);
		
		JPanel panel_RondaEleccion = new JPanel();
		panel_RondaEleccion.setToolTipText("Ronda de Elección");
		tabbedPane.addTab("Ronda de Elección", null, panel_RondaEleccion, "Ronda de Elección");
		tabbedPane.setEnabledAt(4, false);
		
		JPanel panel_Resultado = new JPanel();
		panel_Resultado.setVisible(false);
		panel_Resultado.setToolTipText("Resultado");
		tabbedPane.addTab("Resultado", null, panel_Resultado, "Resultado");
		tabbedPane.setEnabledAt(5, false);
		
		JPanel panel_Publicidad = new JPanel();
		contentPane.add(panel_Publicidad, BorderLayout.SOUTH);
	}

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.loginButton.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e){}

	@Override
	public void keyReleased(KeyEvent e)
	{
		String usuario = this.textField.getText();
		String contrasena = this.passwordField.getText();
		String nombre = this.textField_2.getText();
		String apellido = this.textField_3.getText();
		String edad = this.textField_4.getText();
		String direccion = this.textField_5.getText();
		String telefono = this.textField_6.getText();
		String email = this.textField_7.getText();
		String nuevoUsuario = this.textField_1.getText();
		String nuevaContrasena = this.passwordField_1.getText();
		this.loginButton.setEnabled(!(usuario.isBlank() || contrasena.isBlank()));
		this.registroButton.setEnabled(!(nombre.isBlank() || apellido.isBlank() || edad.isBlank() || direccion.isBlank() || telefono.isBlank() || email.isBlank() || nuevoUsuario.isBlank() || nuevaContrasena.isBlank()));
	}

	public JTabbedPane getTabbedPane()
	{
		return tabbedPane;
	}

	public JTextField getTextField()
	{
		return textField;
	}

	public JPasswordField getPasswordField()
	{
		return passwordField;
	}

	public JTextField getTextField_1()
	{
		return textField_1;
	}

	public JPasswordField getPasswordField_1()
	{
		return passwordField_1;
	}

	public JTextField getTextField_2()
	{
		return textField_2;
	}

	public JTextField getTextField_3()
	{
		return textField_3;
	}

	public JFormattedTextField getTextField_4()
	{
		return textField_4;
	}

	public JTextField getTextField_5()
	{
		return textField_5;
	}

	public JTextField getTextField_6()
	{
		return textField_6;
	}

	public JTextField getTextField_7()
	{
		return textField_7;
	}

	public JFormattedTextField getTextField_8()
	{
		return textField_8;
	}
	
	public JTextField getTextField_9()
	{
		return textField_9;
	}
	
	public ButtonGroup getButtonGroup()
	{
		return buttonGroup;
	}

	public ButtonGroup getButtonGroup_1()
	{
		return buttonGroup_1;
	}

	public ButtonGroup getButtonGroup_2()
	{
		return buttonGroup_2;
	}

	public ButtonGroup getButtonGroup_3()
	{
		return buttonGroup_3;
	}

	public ButtonGroup getButtonGroup_4()
	{
		return buttonGroup_4;
	}

	public ButtonGroup getButtonGroup_5()
	{
		return buttonGroup_5;
	}

	public ButtonGroup getButtonGroup_6()
	{
		return buttonGroup_6;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
