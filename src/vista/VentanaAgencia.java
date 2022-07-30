package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import controlador.ControladorAgencia;
import paquete.Persona;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import java.awt.Dimension;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;

public class VentanaAgencia extends JFrame implements IVistaAgencia, MouseListener
{
	private JPanel contentPane;
	private JPanel panel2;
	private JPanel panel3;
	private JButton btnNewButton2;
	private JList<String> list1;
	private JList list2;
	private JButton btnNewButton3;
	private JList list3;
	private boolean rondaELActivada = false;
	private boolean rondaContratacionActivada = false;
	private ActionListener actionListener;
	private JLabel lblNewLabel;
	
	/**
	 * Create the frame.
	 */
	public VentanaAgencia()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setVisible(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(new Color(255, 51, 51));
		tabbedPane.setBorder(new TitledBorder(null, "Agencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_VisualizacionDatos = new JPanel();
		panel_VisualizacionDatos.setToolTipText("Visualizaci\u00F3n de datos");
		tabbedPane.addTab("Visualizaci\u00F3n de datos", null, panel_VisualizacionDatos, "Visualizaci\u00F3n de datos");
		panel_VisualizacionDatos.setLayout(new BorderLayout(0, 0));
		
		list1 = new JList<String>();
		panel_VisualizacionDatos.add(list1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_VisualizacionDatos.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Empleadores");
		btnNewButton_1.setActionCommand("Empleadores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
			}
		});
		btnNewButton_1.setToolTipText("Empleadores");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Solicitud empleadores");
		btnNewButton_2.setActionCommand("Solicitud empleadores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
			}
		});
		btnNewButton_2.setToolTipText("Solicitud empleadores");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Empleados");
		btnNewButton_3.setActionCommand("Empleados");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
			}
		});
		btnNewButton_3.setToolTipText("Empleados");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Solicitud empleados");
		btnNewButton_4.setActionCommand("Solicitud empleados");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
			}
		});
		btnNewButton_4.setToolTipText("Solicitud empleados");
		panel_1.add(btnNewButton_4);
		
		JPanel panel_Rondas = new JPanel();
		panel_Rondas.setToolTipText("Rondas");
		tabbedPane.addTab("Rondas", null, panel_Rondas, "Ronda de Encuentros Laborales");
		panel_Rondas.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Botones = new JPanel();
		panel_Rondas.add(panel_Botones, BorderLayout.WEST);
		panel_Botones.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_Botones.add(panel_2);
		
		JToggleButton rondaELButton = new JToggleButton("Activar Ronda de Encuentros Laborales");
		panel_2.add(rondaELButton);
		rondaELButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
				if (!isRondaELActivada()) {
					rondaELButton.setText("Desactivar Ronda de Encuentros Laborales");
					setRondaELActivada(true);
				} else {
					rondaELButton.setText("Activar Ronda de Encuentros Laborales");
					setRondaELActivada(false);
				}
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_Botones.add(panel_3);
		
		JToggleButton rondaContratacionButton = new JToggleButton("Activar Ronda de Contrataci\u00F3n");
		panel_3.add(rondaContratacionButton);
		rondaContratacionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
				if (!isRondaContratacionActivada()) {
					rondaContratacionButton.setText("Desactivar Ronda de Contrataci\u00F3n");
					setRondaContratacionActivada(true);
				} else {
					rondaContratacionButton.setText("Activar Ronda de Contrataci\u00F3n");
					setRondaContratacionActivada(false);
				}
			}
		});
		
		JPanel panel_Listas = new JPanel();
		panel_Rondas.add(panel_Listas, BorderLayout.CENTER);
		panel_Listas.setLayout(new GridLayout(2, 0, 0, 0));
		
		JList list_RondaEL = new JList();
		panel_Listas.add(list_RondaEL);
		
		JList list_RondaContratacion = new JList();
		panel_Listas.add(list_RondaContratacion);
		
		JPanel panel_Comisiones = new JPanel();
		panel_Comisiones.setPreferredSize(new Dimension(200, 10));
		panel_Comisiones.setBorder(new TitledBorder(null, "Comisiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Rondas.add(panel_Comisiones, BorderLayout.EAST);
		panel_Comisiones.setLayout(new GridLayout(2, 0, 0, 0));
		
		JTextPane txtpnSaldoDeLa = new JTextPane();
		txtpnSaldoDeLa.setFont(new Font("Arial", Font.ITALIC, 18));
		txtpnSaldoDeLa.setBackground(new Color(240, 240, 240));
		txtpnSaldoDeLa.setText("Saldo de la Agencia");
		panel_Comisiones.add(txtpnSaldoDeLa);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		panel_Comisiones.add(lblNewLabel);
		
		JPanel panel_Publicidad = new JPanel();
		contentPane.add(panel_Publicidad, BorderLayout.SOUTH);
	}

	public boolean isRondaELActivada() {
		return rondaELActivada;
	}

	public void setRondaELActivada(boolean rondaELActivada) {
		this.rondaELActivada = rondaELActivada;
	}

	public boolean isRondaContratacionActivada() {
		return rondaContratacionActivada;
	}

	public void setRondaContratacionActivada(boolean rondaContratacionActivada) {
		this.rondaContratacionActivada = rondaContratacionActivada;
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

	@Override
	public void setActionListener(ActionListener actionListener)
	{
		this.actionListener = actionListener;
	}

	@Override
	public JList<String> getList1()
	{
		// TODO Auto-generated method stub
		return list1;
	}

	@Override
	public void setList1(JList<String> list1)
	{
		this.list1 = list1;
	}

	public JList getList2()
	{
		return list2;
	}

	public void setList2(JList list2)
	{
		this.list2 = list2;
	}

	public JList getList3()
	{
		return list3;
	}

	public void setList3(JList list3)
	{
		this.list3 = list3;
	}

	@Override
	public JLabel getLblNewLabel()
	{
		return lblNewLabel;
	}

}
