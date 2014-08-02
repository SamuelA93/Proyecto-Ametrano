package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import Logica_Persistencia.Value_Object.VOEmpleado;


public class Ver_Empleados extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList listEmpleados;
	private JLabel nombre;
	private JLabel cedula;
	private JLabel direccion;
	private JLabel telefono;
	private List<VOEmpleado> empleados;
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
	
	public void filtrarTuplasParticulares(String [] tuplasPart, String subCadena){
		// Dado un array de tuplas de pacientes y una subcadena, va filtrando los nombres del jList
			boolean hayQueFiltrar = false;
			DefaultListModel modeloSocios = new DefaultListModel();
			for (int i=0; i<tuplasPart.length;i++){			
				if (tuplasPart[i].toUpperCase().startsWith(subCadena.toUpperCase())){
					hayQueFiltrar = true;			
					modeloSocios.addElement(tuplasPart[i]);
				}
			}
			if (hayQueFiltrar){
				listEmpleados.setModel(modeloSocios);			
			}		
		}
	
	public String[] EmpleadosToString() {
		// Retorna un array de pacientes en el cual cada tupla esta formada por nombre y apellido
		// Este array luego se le pasa al jlist de pacientes
		Controlador_listarEmpleados controlador = new Controlador_listarEmpleados();
		//System.out.println("adfasdgdfga");
			 empleados = controlador.listarEmpleados();
			String[] tuplas = new String[empleados.size()];
			int i = 0;
			for (VOEmpleado emple : empleados){
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
				
				char caracter = e.getKeyChar();								
				if (caracter == KeyEvent.VK_BACK_SPACE){
					e.consume();	
					if (txt.length() >=1){
						txt.setLength(txt.length()-1);
						filtrarTuplasParticulares(EmpleadosToString(),txt.toString());
					}
				}else{
					txt.append(caracter);					
					filtrarTuplasParticulares(EmpleadosToString(),txt.toString());
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
				nombre.setText((String) listEmpleados.getSelectedValue());
				cedula.setText( empleados.get(listEmpleados.getSelectedIndex()).getCedula()+"");
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
