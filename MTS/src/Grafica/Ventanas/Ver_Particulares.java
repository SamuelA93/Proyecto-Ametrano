package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;




import Grafica.Controladores.Controlador_Particular;
import Grafica.Controladores.Controlador_Socio;
import Grafica.Controladores.Controlador_Telefono;

import Grafica.Controladores.Verificar_Tel;
import Logica_Persistencia.Value_Object.VOParticular;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class Ver_Particulares extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList listParticulares;
	private int j=0;
	//private Controlador_listarParticulares controlador = new Controlador_listarParticulares();
	private List<VOParticular> guia= null;
	private JTextField agregarNombre;
	private JTextField agregarApellido;
	private JTextField agregarCedula;
	private JTextField agregarDireccion;
	private JTextField agregarTelefono;
	private boolean editer=false;
	JButton GuardarCambios = new JButton("Guardar Cambios");
	private JTextField agregarTelefono2;
	private ArrayList<String> modif ;
	private ArrayList<Object[]> modifT ;
	//Controlador_Agregar_meses controlSocios = new Controlador_Agregar_meses();
	//Controlador_Cantidad_Registros_Socio cuenta = new Controlador_Cantidad_Registros_Socio();
	Controlador_Socio control_socio = new Controlador_Socio();
	
	JCheckBox Socio;
	private Controlador_Particular control = new Controlador_Particular();
	private Controlador_Telefono control_tel = new Controlador_Telefono();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Particulares frame = new Ver_Particulares();
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
		 boolean clip = (!listParticulares.isSelectionEmpty() && (bandera));
		if (clip){
			
			GuardarCambios.setVisible(true);
			System.out.println("si");
			agregarNombre.setEditable(clip);
			agregarApellido.setEditable(clip);
			agregarDireccion.setEditable(clip);
			//agregarCedula.setEditable(clip);
			agregarTelefono.setEditable(clip);
			agregarTelefono2.setEditable(clip);
		}else{
			System.out.println("no");
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
	public void filtrarTuplasParticulares(String [] tuplasPart, String subCadena,List<VOParticular> par){
		// Dado un array de tuplas de pacientes y una subcadena, va filtrando los nombres del jList
			boolean hayQueFiltrar = false;
			DefaultListModel modeloSocios = new DefaultListModel();
			guia= new ArrayList<VOParticular>();
			for (int i=0; i<tuplasPart.length;i++){			
				if (tuplasPart[i].toUpperCase().startsWith(subCadena.toUpperCase())){
					guia.add(par.get(i));
					hayQueFiltrar = true;			
					modeloSocios.addElement(tuplasPart[i]);
				}
			}
			if (hayQueFiltrar){
				listParticulares.setModel(modeloSocios);			
			}		
		}
	
	public String[] particularesToString() {
		// Retorna un array de pacientes en el cual cada tupla esta formada por nombre y apellido
		// Este array luego se le pasa al jlist de pacientes
			
			List<VOParticular> particulares = control.listarParticulares();
			guia= new ArrayList<VOParticular>();
			String[] tuplas = new String[particulares.size()];
			int i = 0;
			for (VOParticular parti : particulares){
				guia.add(parti);
				
				tuplas[i] =  parti.getNombre() + " " + parti.getApellido();
				i++;
			}		
			return tuplas;
		}
	
	public Ver_Particulares() {
		setTitle("Particulares");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					if(!Socio.isSelected()){
						Socio.setEnabled(true);
					}
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
				List<VOParticular> particulares = control.listarParticulares();
				char caracter = e.getKeyChar();								
				if (caracter == KeyEvent.VK_BACK_SPACE){
					e.consume();	
					if (txt.length() >=1){
						txt.setLength(txt.length()-1);
						filtrarTuplasParticulares(particularesToString(),txt.toString(),particulares);
					}
				}else{
					txt.append(caracter);					
					filtrarTuplasParticulares(particularesToString(),txt.toString(),particulares);
				}
				
			}
		});
		textField.setBounds(59, 11, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 165, 302);
		contentPane.add(scrollPane);
		
		 listParticulares = new JList(this.particularesToString());
		listParticulares.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					long refer= control_socio.registros(guia.get(listParticulares.getSelectedIndex()).getCedula());
					if (refer>0) {
						Socio.setSelected(true);
						
					}else{
						Socio.setSelected(false);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					Socio.setEnabled(false);
					e.printStackTrace();
				}
				Socio.setEnabled(false);
				GuardarCambios.setVisible(false);
				agregarNombre.setText(guia.get(listParticulares.getSelectedIndex()).getNombre());
				agregarApellido.setText(guia.get(listParticulares.getSelectedIndex()).getApellido());
				agregarDireccion.setText(guia.get(listParticulares.getSelectedIndex()).getDireccion()); 
				agregarCedula.setText(""+guia.get(listParticulares.getSelectedIndex()).getCedula());
				agregarTelefono.setText(guia.get(listParticulares.getSelectedIndex()).getTelefono());
				agregarTelefono2.setText(guia.get(listParticulares.getSelectedIndex()).getTelefono2());
			}
		});
		scrollPane.setViewportView(listParticulares);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 14, 54, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("NOMBRE:");
		lblNombre_1.setBounds(194, 60, 73, 14);
		contentPane.add(lblNombre_1);
		
		JLabel lblCedula = new JLabel("APELLIDO:");
		lblCedula.setBounds(194, 96, 73, 14);
		contentPane.add(lblCedula);
		
		JLabel lblDireccion = new JLabel("CEDULA:");
		lblDireccion.setBounds(194, 134, 73, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("DIRECCION:");
		lblTelefono.setBounds(194, 170, 73, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblTel = new JLabel("Tel 1:");
		lblTel.setBounds(194, 210, 73, 14);
		contentPane.add(lblTel);
		
		agregarNombre = new JTextField();
		agregarNombre.setEditable(false);
		agregarNombre.setBounds(277, 57, 132, 20);
		contentPane.add(agregarNombre);
		agregarNombre.setColumns(10);
		
		agregarApellido = new JTextField();
		agregarApellido.setEditable(false);
		agregarApellido.setColumns(10);
		agregarApellido.setBounds(277, 93, 132, 20);
		contentPane.add(agregarApellido);
		
		agregarCedula = new JTextField();
		agregarCedula.setEditable(false);
		agregarCedula.setColumns(10);
		agregarCedula.setBounds(277, 131, 132, 20);
		contentPane.add(agregarCedula);
		
		agregarDireccion = new JTextField();
		agregarDireccion.setEditable(false);
		agregarDireccion.setColumns(10);
		agregarDireccion.setBounds(277, 167, 132, 20);
		contentPane.add(agregarDireccion);
		
		agregarTelefono = new JTextField();
		agregarTelefono.setEditable(false);
		agregarTelefono.setColumns(10);
		agregarTelefono.setBounds(277, 207, 132, 20);
		contentPane.add(agregarTelefono);
		GuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String espa ="";
				if(Socio.isEnabled()&&Socio.isSelected()){
					try {
						control_socio.Nuevo_Socio((long) guia.get(listParticulares.getSelectedIndex()).getCedula());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println("gusrdar");
				}
				
				if(!agregarNombre.getText().equals(espa)){
					
				modif = new ArrayList<String>();
				modifT = new ArrayList<Object[]>();
				
				if( Verificar_Tel.veri(agregarTelefono2.getText()) && !agregarTelefono2.getText().trim().toUpperCase().contentEquals(guia.get(listParticulares.getSelectedIndex()).getTelefono2().trim().toUpperCase())){
					//System.out.println("igual");
					//modifT.add("`dir`="+"'"+agregarTelefono2.getText().trim());
					Object[] rec = new Object[2];
					rec[0]= agregarTelefono2.getText().trim();
					rec[1]= guia.get(listParticulares.getSelectedIndex()).getTelefono2();
					modifT.add(rec);
					
				}
				if(  Verificar_Tel.veri(agregarTelefono.getText()) && !agregarTelefono.getText().trim().toUpperCase().contentEquals(guia.get(listParticulares.getSelectedIndex()).getTelefono().trim().toUpperCase())){
					//System.out.println("igual");
					//modifT.add(agregarTelefono.getText().trim());
					Object[] rec = new Object[2];
					rec[0]= agregarTelefono.getText().trim();
					rec[1]= guia.get(listParticulares.getSelectedIndex()).getTelefono();
					modifT.add(rec);
				}
				if( !agregarNombre.getText().trim().toUpperCase().contentEquals(guia.get(listParticulares.getSelectedIndex()).getNombre().trim().toUpperCase())){
					//System.out.println(agregarNombre.getText());
					modif.add("`nombre`="+"'"+agregarNombre.getText().trim()+"'");
					//modif.add(agregarNombre.getText()+"");
				}
				if( !agregarDireccion.getText().trim().toUpperCase().contentEquals(guia.get(listParticulares.getSelectedIndex()).getDireccion().trim().toUpperCase())){
					//System.out.println("igual");
					modif.add("`dir`="+"'"+agregarDireccion.getText().trim()+"'");
				}
				if( !agregarApellido.getText().trim().toUpperCase().contentEquals(guia.get(listParticulares.getSelectedIndex()).getApellido().trim().toUpperCase())){
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
				//Controlador_Modificar_Particular ModiPart = new Controlador_Modificar_Particular();
				//Controlador_Modificar_Tel modiTel = new Controlador_Modificar_Tel();
				try {
					//System.out.println(guia.get(listParticulares.getSelectedIndex()).getCedula());
					if(agregar!=""){
						control.modificar(agregar, guia.get(listParticulares.getSelectedIndex()).getCedula());
					}
					
					if(modifT.size()>0){
						control_tel.modificar( (String) modifT.get(0)[0],  (String) modifT.get(0)[1], (int) guia.get(listParticulares.getSelectedIndex()).getCedula());
						System.out.println((String) modifT.get(0)[0]);
					}
					if(modifT.size()>1){
						control_tel.modificar( (String) modifT.get(1)[0],  (String) modifT.get(1)[1], (int) guia.get(listParticulares.getSelectedIndex()).getCedula());
						System.out.println((String) modifT.get(1)[0]);
					}
					
					
					
				} catch (SQLException e) {
					//System.out.println("Error");
					e.printStackTrace();
					
				}
				setEditableCampos(false);
				List<VOParticular> particulares = control.listarParticulares();
				filtrarTuplasParticulares(particularesToString(),"",particulares);
				GuardarCambios.setVisible(false);
				
			}else{
				javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
				mensaje.showMessageDialog(null, "Ingrese el nombre.", "Atención!!!", mensaje.ERROR_MESSAGE);
			}
				Socio.setEnabled(false);
				
			}
			
		});
		
		GuardarCambios.setVisible(false);
		
		JLabel lblTel_1 = new JLabel("Tel 2:");
		lblTel_1.setBounds(194, 246, 73, 14);
		contentPane.add(lblTel_1);
		
		agregarTelefono2 = new JTextField();
		agregarTelefono2.setEditable(false);
		agregarTelefono2.setColumns(10);
		agregarTelefono2.setBounds(277, 245, 132, 20);
		contentPane.add(agregarTelefono2);
		GuardarCambios.setBounds(194, 310, 199, 23);
		contentPane.add(GuardarCambios);
		
		Socio = new JCheckBox("Socio");
		//Socio.setSelected(true);
		Socio.setBounds(277, 276, 97, 23);
		contentPane.add(Socio);
		Socio.setEnabled(false);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(179, 42, 245, 302);
		contentPane.add(editorPane);
	}
}
