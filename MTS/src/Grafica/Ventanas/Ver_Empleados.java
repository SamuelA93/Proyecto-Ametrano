package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Grafica.Controladores.Controlador_listarEmpleados;
//import Grafica.Controladores.Controlador_listarParticulares;
import Logica_Persistencia.Value_Object.VOEmpleado;
//import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOParticular;


public class Ver_Empleados extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList listEmpleados;
	private JLabel nombre;
	private JLabel cedula;
	private JLabel direccion;
	private JLabel telefono;
	private List<VOEmpleado> empleados;
	Controlador_listarEmpleados controlador = new Controlador_listarEmpleados();
	List<VOEmpleado> guia= null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Empleados frame = new Ver_Empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void filtrarTuplasParticulares(String [] tuplasPart, String subCadena,List<VOEmpleado> emples){
		// Dado un array de tuplas de pacientes y una subcadena, va filtrando los nombres del jList
			boolean hayQueFiltrar = false;
			DefaultListModel modeloSocios = new DefaultListModel();
			guia= new ArrayList<VOEmpleado>();
			for (int i=0; i<tuplasPart.length;i++){			
				
				if (tuplasPart[i].toUpperCase().startsWith(subCadena.toUpperCase())){
					hayQueFiltrar = true;
					guia.add(emples.get(i));
					modeloSocios.addElement(tuplasPart[i]);
				}
			}
			if (hayQueFiltrar){
				listEmpleados.setModel(modeloSocios);			
			}		
		}
	
	public String[] EmpleadosToString() {
		
		List<VOEmpleado> empleados = controlador.listarEmpleados();
		guia= new ArrayList<VOEmpleado>();
			String[] tuplas = new String[empleados.size()];
			int i = 0;
			for (VOEmpleado emple : empleados){
				guia.add(emple);
				tuplas[i] =  emple.getNombre() + " " + emple.getApellido();
				i++;
			}		
			return tuplas;
		}
	
	public Ver_Empleados() {
		setTitle("Ver Empleados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 394);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		menuBar.add(mnEliminar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			StringBuffer txt = new StringBuffer();
			@Override
			public void keyTyped(KeyEvent e) {
				List<VOEmpleado> empleados = controlador.listarEmpleados();
				char caracter = e.getKeyChar();								
				if (caracter == KeyEvent.VK_BACK_SPACE){
					e.consume();	
					if (txt.length() >=1){
						txt.setLength(txt.length()-1);
						filtrarTuplasParticulares(EmpleadosToString(),txt.toString(),empleados);
					}
				}else{
					txt.append(caracter);					
					filtrarTuplasParticulares(EmpleadosToString(),txt.toString(),empleados);
				}
				
			}
		});
		textField.setBounds(59, 11, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 165, 270);
		contentPane.add(scrollPane);
		
		listEmpleados = new JList(this.EmpleadosToString());
		listEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nombre.setText(guia.get(listEmpleados.getSelectedIndex()).getNombre());
				cedula.setText(""+guia.get(listEmpleados.getSelectedIndex()).getCedula());
			}
		});
		
		scrollPane.setViewportView(listEmpleados);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 14, 54, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("NOMBRE:");
		lblNombre_1.setBounds(210, 44, 73, 14);
		contentPane.add(lblNombre_1);
		
		JLabel lblCedula = new JLabel("CEDULA:");
		lblCedula.setBounds(210, 80, 73, 14);
		contentPane.add(lblCedula);
		
		JLabel lblDireccion = new JLabel("DIRECCION:");
		lblDireccion.setBounds(210, 118, 73, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(210, 154, 73, 14);
		contentPane.add(lblTelefono);
		
		nombre = new JLabel("");
		nombre.setBounds(293, 44, 97, 14);
		contentPane.add(nombre);
		
		cedula = new JLabel("");
		cedula.setBounds(293, 80, 97, 14);
		contentPane.add(cedula);
		
		direccion = new JLabel("");
		direccion.setBounds(293, 118, 97, 14);
		contentPane.add(direccion);
		
		telefono = new JLabel("");
		telefono.setBounds(293, 154, 97, 14);
		contentPane.add(telefono);
	}
}
