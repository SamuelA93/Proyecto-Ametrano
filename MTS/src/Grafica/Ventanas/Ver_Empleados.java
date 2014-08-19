package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Grafica.Controladores.Controlador_Empleado;



import Grafica.Controladores.Controlador_Telefono;

import Grafica.Controladores.Controlador_Verificar;

import Grafica.Controladores.Verificar_Tel;
//import Grafica.Controladores.Controlador_listarParticulares;
import Logica_Persistencia.Value_Object.VOEmpleado;
//import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOParticular;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;


public class Ver_Empleados extends JFrame {

	 private JPanel contentPane;
	 private JTextField textField;
	 private JList listEmpleados;
	// private Controlador_listarEmpleados controlador = new Controlador_listarEmpleados();
	 private List<VOEmpleado> guia= null;
	 private JTextField agregarNombre;
	 private JTextField agregarApellido;
	 private JTextField agregarCedula;
	 private JTextField agregarDireccion;
	 private JTextField agregarTelefono;
	 private JTextField agregarTelefono2;
	 private boolean editer=false;
	 JButton GuardarCambios = new JButton("Guardar cambios");
	 private final Action action = new SwingAction();
	 private ArrayList<String> modif ;
	 private ArrayList<Object[]> modifT ;
	 private Controlador_Empleado control = new Controlador_Empleado();
	 private Controlador_Telefono control_tel = new Controlador_Telefono();
	 private Controlador_Verificar verificador = new Controlador_Verificar();
	 //private Controlador_Telefonos config_telefonos = new Controlador_Telefonos();
	 List<VOEmpleado> empleados;
	 private 	JFrame frame = new JFrame("Exito");
		
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
	
	/*
	 *  Activo o desactivo los campos del empleado para la edicion 
	 */
	public void setEditableCampos(boolean bandera){
		 boolean clip = (!listEmpleados.isSelectionEmpty() && (bandera));
		if (clip){
			GuardarCambios.setVisible(clip);
			agregarNombre.setEditable(clip);
			agregarApellido.setEditable(clip);
			agregarDireccion.setEditable(clip);
			agregarTelefono.setEditable(clip);
			agregarTelefono2.setEditable(clip);
		}else{
			agregarTelefono2.setEditable(clip);
			agregarNombre.setEditable(clip);
			agregarApellido.setEditable(clip);
			agregarDireccion.setEditable(clip);
			agregarTelefono.setEditable(clip);
		}
	}
	
	
	 /////////////////////// Filtra un array de acuerdo a lo que se este buscando en el textField y carga lo filtrado en jList
	 
	public void filtrarTuplasEmpleados(String [] tuplasEmpl, String subCadena){
		// Dado un array de tuplas de pacientes y una subcadena, va filtrando los nombres del jList
			boolean hayQueFiltrar = false;
			DefaultListModel modeloSocios = new DefaultListModel();
			guia = new ArrayList<VOEmpleado>();
			for (int i=0; i<tuplasEmpl.length;i++){			
				if (tuplasEmpl[i].toUpperCase().startsWith(subCadena.toUpperCase())){
					guia.add(empleados.get(i));
					hayQueFiltrar = true;
					modeloSocios.addElement(tuplasEmpl[i]);
				}
			}
			if (hayQueFiltrar){
				listEmpleados.setModel(modeloSocios);			
			}		
		}
	
	//////////////////////// Devuelve una List<VOEmpleado> para manter actualizada la ventana 
	
	public void Listar() throws SQLException{
			empleados = control.listarEmpleados();
	}
	
	
	//////////////////////// devuelve un array con nombres de empleados  apartir de List<VOEmpleado>
	
	public String[] EmpleadosToString() {
		
		try {
			Listar();
			// Retorna un array de empleados en el cual cada tupla esta formada por nombre y apellido
			// Este array luego se le pasa al jlist de empleados
			
			//List<VOEmpleado> empleados = control.listarEmpleados();
			guia = new ArrayList<VOEmpleado>();
			String[] tuplas = new String[empleados.size()];
			int i = 0;
			for (VOEmpleado emple : empleados){
				guia.add(emple);
				tuplas[i] =  emple.getNombre() + " " + emple.getApellido();
				i++;
			}		
				return tuplas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String[] tupla = new String[1];
			tupla[0] = "Error";	
			return  tupla;
		}
		
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
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				////////////  Al seleccionar el modo edicion se habilita la edicion de los campos del empleado
				setEditableCampos(true);
			}
		});
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
							filtrarTuplasEmpleados(EmpleadosToString(),txt.toString());
						}
					}else{
						txt.append(caracter);					
						filtrarTuplasEmpleados(EmpleadosToString(),txt.toString());
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
				////////////////   Activa campos para la edicion y carga los datos del empleado y activa el boton "guardar"
					setEditableCampos(false);
					GuardarCambios.setVisible(false);
					agregarNombre.setText(guia.get(listEmpleados.getSelectedIndex()).getNombre());
					agregarApellido.setText(guia.get(listEmpleados.getSelectedIndex()).getApellido());
					agregarDireccion.setText(guia.get(listEmpleados.getSelectedIndex()).getDireccion()); 
					agregarCedula.setText(""+guia.get(listEmpleados.getSelectedIndex()).getCedula());
					agregarTelefono.setText(guia.get(listEmpleados.getSelectedIndex()).getTelefono());
					agregarTelefono2.setText(guia.get(listEmpleados.getSelectedIndex()).getTelefono2());
			}
		});
		
		scrollPane.setViewportView(listEmpleados);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 14, 54, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("NOMBRE:");
		lblNombre_1.setBounds(210, 60, 73, 14);
		contentPane.add(lblNombre_1);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(210, 99, 73, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCedula = new JLabel("CEDULA:");
		lblCedula.setBounds(210, 134, 73, 14);
		contentPane.add(lblCedula);
		
		JLabel lblDireccion = new JLabel("DIRECCION:");
		lblDireccion.setBounds(210, 172, 73, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel 1:");
		lblTelefono.setBounds(210, 208, 73, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblTel = new JLabel("Tel 2:");
		lblTel.setBounds(210, 244, 73, 14);
		contentPane.add(lblTel);
		
		agregarNombre = new JTextField();
		agregarNombre.setEditable(false);
		agregarNombre.setBounds(293, 57, 116, 20);
		contentPane.add(agregarNombre);
		agregarNombre.setColumns(10);
		
		agregarApellido = new JTextField();
		agregarApellido.setEditable(false);
		agregarApellido.setColumns(10);
		agregarApellido.setBounds(293, 96, 116, 20);
		contentPane.add(agregarApellido);
		
		agregarCedula = new JTextField();
		agregarCedula.setEditable(false);
		agregarCedula.setColumns(10);
		agregarCedula.setBounds(293, 131, 116, 20);
		contentPane.add(agregarCedula);
		
		agregarDireccion = new JTextField();
		agregarDireccion.setEditable(false);
		agregarDireccion.setColumns(10);
		agregarDireccion.setBounds(293, 169, 116, 20);
		contentPane.add(agregarDireccion);
		
		agregarTelefono = new JTextField();
		agregarTelefono.setEditable(false);
		agregarTelefono.setColumns(10);
		agregarTelefono.setBounds(293, 205, 116, 20);
		contentPane.add(agregarTelefono);
		
		agregarTelefono2 = new JTextField();
		agregarTelefono2.setEditable(false);
		agregarTelefono2.setColumns(10);
		agregarTelefono2.setBounds(293, 241, 116, 20);
		contentPane.add(agregarTelefono2);
		GuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				///////////  Obtengo datos  de entrada 
				String nombre 		= agregarNombre.getText();
				String apellido 	= agregarApellido.getText();
				String direccion 	= agregarDireccion.getText();
				String tel1			= agregarTelefono.getText();
				String tel2 		= agregarTelefono2.getText();
				String ci 			= agregarCedula.getText();
				//////////////////////////
				boolean error = false;
				
				///////////////////////// Verifico que todos los campos esten con datos correctos
				if (verificador.SoloString_O_Espacios(nombre)) {
					if( verificador.SoloString_O_Espacios(apellido) || apellido.equals("")){
						if( verificador.SoloNumeros(tel1) || tel1.equals("") || tel1.equals("No ingresado")){
							if( verificador.SoloNumeros(tel2) || tel2.equals("") || tel2.equals("No ingresado") ){	
							}else{
								error = true;
								javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
								mensaje.showMessageDialog(null, "tel2 incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
							}
						}else{
							error = true;
							javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
							mensaje.showMessageDialog(null, "Telefono incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
						}
					}else{
						error = true;
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "Apellido incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
					}
					
				} else {
					error = true;
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Nombre incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
				//////////////////////////  Control si no se hallo errores
				if (!error) {
					////  modif  es una lista con los cambios a realizar
					modif = new ArrayList<String>();
					////   modifT es una lista con los cambios a realizar rn telefonos
					modifT = new ArrayList<Object[]>();
					if (!nombre.trim().toUpperCase().equals(guia.get(listEmpleados.getSelectedIndex()).getNombre().trim().toUpperCase())){
						modif.add("`nombre`="+"'"+nombre.trim()+"'");
					}
					if (!apellido.trim().toUpperCase().equals(guia.get(listEmpleados.getSelectedIndex()).getApellido().trim().toUpperCase())){
						modif.add("`apellido`="+"'"+apellido.trim()+"'");
					}
					if (!direccion.trim().toUpperCase().equals(guia.get(listEmpleados.getSelectedIndex()).getDireccion().trim().toUpperCase())){
						modif.add("`direccion`="+"'"+direccion+"'");
					}
					//////   agregar va a hacer la variable que tenga concatenado los cambios, menos los de telefonos
					String agregar="";
					int i=1;
					if(modif.size()>0 ){
						agregar = agregar+""+modif.get(0);
						while( i < modif.size()){
							agregar = agregar+","+modif.get(i);
							i++;
						}
					}
					/////////////  rec es un objeto que guarda el nuevo numero y el viejo
					if ( !tel1.equals("") && !tel1.equals("No ingresado") && !tel1.trim().toUpperCase().equals(guia.get(listEmpleados.getSelectedIndex()).getTelefono().trim().toUpperCase()) ){
						Object[] rec = new Object[2];
						rec[0]= tel1.trim();
						rec[1]= guia.get(listEmpleados.getSelectedIndex()).getTelefono();
						modifT.add(rec);
					}
					if (!tel2.equals("") && !tel2.equals("No ingresado") && !tel2.trim().toUpperCase().equals(guia.get(listEmpleados.getSelectedIndex()).getTelefono2().trim().toUpperCase())){
						Object[] rec = new Object[2];
						rec[0]= tel2.trim();
						rec[1]= guia.get(listEmpleados.getSelectedIndex()).getTelefono2();
						modifT.add(rec);
					}
					try {
						///////  se modifica la db solo si existen cambios en los datos del empleado
						if (!agregar.equals("")) {
							System.out.println(agregar);
							control.modificar(agregar, (int) guia.get(listEmpleados.getSelectedIndex()).getCedula());
						} 
						try {
							if(modifT.size()>0){
								control_tel.modificar( (String) modifT.get(0)[0],  (String) modifT.get(0)[1], (int) guia.get(listEmpleados.getSelectedIndex()).getCedula());
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						try {
							if(modifT.size()>1){
								control_tel.modificar( (String) modifT.get(1)[0],  (String) modifT.get(1)[1], (int) guia.get(listEmpleados.getSelectedIndex()).getCedula());
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						//////  desabilitar camor para la edicion
						setEditableCampos(false);
						////// actualizar lista 
						filtrarTuplasEmpleados(EmpleadosToString(), "");
						/////////  esconder el boton de guardar cambios
						GuardarCambios.setVisible(false);
						
						JOptionPane.showMessageDialog(frame, "Se ah modificado  Empleado.");
					} catch (Exception e) {
						// TODO: handle exception
					}
				} 
				
			}
		});
		
		GuardarCambios.setBounds(236, 277, 138, 23);
		contentPane.add(GuardarCambios);
		GuardarCambios.setVisible(false);
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(185, 42, 239, 270);
		contentPane.add(editorPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
