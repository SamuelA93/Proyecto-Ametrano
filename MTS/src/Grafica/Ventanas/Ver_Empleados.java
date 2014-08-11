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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Grafica.Controladores.Controlador_Modificar_Empleado;
import Grafica.Controladores.Controlador_Modificar_Tel;
import Grafica.Controladores.Controlador_listarEmpleados;
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
	//private List<VOEmpleado> empleados;
	 private Controlador_listarEmpleados controlador = new Controlador_listarEmpleados();
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
	public void setEditableCampos(boolean bandera){
		 boolean clip = (!listEmpleados.isSelectionEmpty() && (bandera));
		if (clip){
			GuardarCambios.setVisible(true);
			//System.out.println("si");
			agregarNombre.setEditable(clip);
			agregarApellido.setEditable(clip);
			agregarDireccion.setEditable(clip);
			//agregarCedula.setEditable(clip);
			agregarTelefono.setEditable(clip);
			agregarTelefono2.setEditable(clip);
		}else{
			//System.out.println("no");
			agregarTelefono2.setEditable(clip);
			agregarNombre.setEditable(clip);
			agregarApellido.setEditable(clip);
			//agregarApellido.setText(guia.get(listParticulares.getSelectedIndex()).getApellido());
			agregarDireccion.setEditable(clip);
			//agregarDireccion.setText(guia.get(listParticulares.getSelectedIndex()).getDireccion()); 
			//agregarCedula.setEditable(clip);
			//agregarCedula.setText(""+guia.get(listParticulares.getSelectedIndex()).getCedula());
			agregarTelefono.setEditable(clip);
			//agregarTelefono.setText(guia.get(listParticulares.getSelectedIndex()).getTelefono());
		}
	}
	
	public void filtrarTuplasEmpleados(String [] tuplasEmpl, String subCadena,List<VOEmpleado> emples){
		// Dado un array de tuplas de pacientes y una subcadena, va filtrando los nombres del jList
			boolean hayQueFiltrar = false;
			DefaultListModel modeloSocios = new DefaultListModel();
			guia= new ArrayList<VOEmpleado>();
			for (int i=0; i<tuplasEmpl.length;i++){			
				if (tuplasEmpl[i].toUpperCase().startsWith(subCadena.toUpperCase())){
					guia.add(emples.get(i));
					hayQueFiltrar = true;
					modeloSocios.addElement(tuplasEmpl[i]);
				}
			}
			if (hayQueFiltrar){
				listEmpleados.setModel(modeloSocios);			
			}		
		}
	
	public String[] EmpleadosToString() {
		// Retorna un array de empleados en el cual cada tupla esta formada por nombre y apellido
		// Este array luego se le pasa al jlist de empleados
		
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
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
				List<VOEmpleado> empleados = controlador.listarEmpleados();
				char caracter = e.getKeyChar();								
				if (caracter == KeyEvent.VK_BACK_SPACE){
					e.consume();	
					if (txt.length() >=1){
						txt.setLength(txt.length()-1);
						filtrarTuplasEmpleados(EmpleadosToString(),txt.toString(),empleados);
					}
				}else{
					txt.append(caracter);					
					filtrarTuplasEmpleados(EmpleadosToString(),txt.toString(),empleados);
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
				/*nombre.setText(guia.get(listEmpleados.getSelectedIndex()).getNombre());
				cedula.setText(""+guia.get(listEmpleados.getSelectedIndex()).getCedula());
				telefono.setText(""+guia.get(listEmpleados.getSelectedIndex()).getTelefono());*/
				setEditableCampos(false);
				GuardarCambios.setVisible(false);
				agregarNombre.setText(guia.get(listEmpleados.getSelectedIndex()).getNombre());
				agregarApellido.setText(guia.get(listEmpleados.getSelectedIndex()).getApellido());
				agregarDireccion.setText(guia.get(listEmpleados.getSelectedIndex()).getDireccion()); 
				agregarCedula.setText(""+guia.get(listEmpleados.getSelectedIndex()).getCedula());
				agregarTelefono.setText(guia.get(listEmpleados.getSelectedIndex()).getTelefono());
				agregarTelefono2.setText(guia.get(listEmpleados.getSelectedIndex()).getTelefono2());
				//System.out.println(guia.get(listEmpleados.getSelectedIndex()).getTelefono2()+" "+guia.get(listEmpleados.getSelectedIndex()).getTelefono());
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
				String espa ="";
			
				if(!agregarNombre.getText().equals(espa)){
					modif = new ArrayList<String>();
					modifT = new ArrayList<Object[]>();
					
					if( Verificar_Tel.veri(agregarTelefono2.getText()) && !agregarTelefono2.getText().trim().toUpperCase().contentEquals(guia.get(listEmpleados.getSelectedIndex()).getTelefono2().trim().toUpperCase()) ){
						//System.out.println("igual");
						//modifT.add("`dir`="+"'"+agregarTelefono2.getText().trim());
						Object[] rec = new Object[2];
						rec[0]= agregarTelefono2.getText().trim();
						rec[1]= guia.get(listEmpleados.getSelectedIndex()).getTelefono2();
						modifT.add(rec);
						
					
					}
					
					if(  Verificar_Tel.veri(agregarTelefono.getText()) && !agregarTelefono.getText().trim().toUpperCase().contentEquals(guia.get(listEmpleados.getSelectedIndex()).getTelefono().trim().toUpperCase())){
						//System.out.println("igual");
						//modifT.add(agregarTelefono.getText().trim());
						Object[] rec = new Object[2];
						rec[0]= agregarTelefono.getText().trim();
						rec[1]= guia.get(listEmpleados.getSelectedIndex()).getTelefono();
						modifT.add(rec);
					}
					if( !agregarNombre.getText().trim().toUpperCase().contentEquals(guia.get(listEmpleados.getSelectedIndex()).getNombre().trim().toUpperCase())){
						//System.out.println(agregarNombre.getText());
						modif.add("`nombre`="+"'"+agregarNombre.getText().trim()+"'");
						//modif.add(agregarNombre.getText()+"");
					}
					if( !agregarDireccion.getText().trim().toUpperCase().contentEquals(guia.get(listEmpleados.getSelectedIndex()).getDireccion().trim().toUpperCase())){
						//System.out.println("igual");
						modif.add("`dir`="+"'"+agregarDireccion.getText().trim()+"'");
					}
					if( !agregarApellido.getText().trim().toUpperCase().contentEquals(guia.get(listEmpleados.getSelectedIndex()).getApellido().trim().toUpperCase())){
						//System.out.println("igual");
						modif.add("`apellido`="+"'"+agregarApellido.getText().trim()+"'");
					}
					String agregar="";
					int i=1;
					//System.out.println(modif.size());
					if(modif.size()>0 ){
					agregar = agregar+""+modif.get(0);
					}
					//System.out.println(agregar);
					while( i< modif.size()){
						agregar = agregar+","+modif.get(i);
						//System.out.println(agregar);
						i++;
						}
					//agregar = agregar+""+modif.get(modif.size()+1);
					//System.out.println(agregar);
					Controlador_Modificar_Empleado ModiPart = new Controlador_Modificar_Empleado();
					Controlador_Modificar_Tel modiTel = new Controlador_Modificar_Tel();
					try {
						//System.out.println(guia.get(listParticulares.getSelectedIndex()).getCedula());
						if(agregar!=""){
							ModiPart.modificar(agregar, guia.get(listEmpleados.getSelectedIndex()).getCedula());
						}
						
						if(modifT.size()>0){
							modiTel.modificar( (String) modifT.get(0)[0],  (String) modifT.get(0)[1], (int) guia.get(listEmpleados.getSelectedIndex()).getCedula());
							//System.out.println((String) modifT.get(0)[0]);
						}
						if(modifT.size()>1){
							modiTel.modificar( (String) modifT.get(1)[0],  (String) modifT.get(1)[1], (int) guia.get(listEmpleados.getSelectedIndex()).getCedula());
							//System.out.println((String) modifT.get(1)[0]);
						}
						
					} catch (SQLException e) {
						//System.out.println("Error");
						e.printStackTrace();
						
					}
					
					setEditableCampos(false);
					List<VOEmpleado> empleado1 = controlador.listarEmpleados();
					filtrarTuplasEmpleados(EmpleadosToString(),"",empleado1);
					GuardarCambios.setVisible(false);
				}else{
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Ingrese el nombre.", "Atención!!!", mensaje.ERROR_MESSAGE);
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
