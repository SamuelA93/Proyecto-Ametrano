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

import Grafica.Controladores.Controlador_listarParticulares;
import Logica_Persistencia.Value_Object.VOParticular;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Ver_Particulares extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList listParticulares;
	private int j=0;
	Controlador_listarParticulares controlador = new Controlador_listarParticulares();
	List<VOParticular> guia= null;
	private JTextField agregarNombre;
	private JTextField agregarApellido;
	private JTextField agregarCedula;
	private JTextField agregarDireccion;
	private JTextField agregarTelefono;
	private boolean editer=false;
	JButton GuardarCambios = new JButton("Guardar Cambios");
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
			System.out.println("si");
			agregarNombre.setEditable(clip);
			agregarApellido.setEditable(clip);
			agregarDireccion.setEditable(clip);
			agregarCedula.setEditable(clip);
			agregarTelefono.setEditable(clip);
		}else{
			System.out.println("no");
			agregarNombre.setEditable(clip);
			
			//System.out.println(listParticulares.getSelectedIndex());
			//agregarNombre.setText(guia.get(listParticulares.getSelectedIndex()).getNombre());
			//System.out.println(guia.get(listParticulares.getSelectedIndex()).getNombre());
			
			
			agregarApellido.setEditable(clip);
			//agregarApellido.setText(guia.get(listParticulares.getSelectedIndex()).getApellido());
			agregarDireccion.setEditable(clip);
			//agregarDireccion.setText(guia.get(listParticulares.getSelectedIndex()).getDireccion()); 
			agregarCedula.setEditable(clip);
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
			
			List<VOParticular> particulares = controlador.listarParticulares();
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
					GuardarCambios.setVisible(true);
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
				List<VOParticular> particulares = controlador.listarParticulares();
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
		scrollPane.setBounds(10, 42, 165, 270);
		contentPane.add(scrollPane);
		
		 listParticulares = new JList(this.particularesToString());
		listParticulares.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setEditableCampos(false);
				GuardarCambios.setVisible(false);
				agregarNombre.setText(guia.get(listParticulares.getSelectedIndex()).getNombre());
				agregarApellido.setText(guia.get(listParticulares.getSelectedIndex()).getApellido());
				agregarDireccion.setText(guia.get(listParticulares.getSelectedIndex()).getDireccion()); 
				agregarCedula.setText(""+guia.get(listParticulares.getSelectedIndex()).getCedula());
				agregarTelefono.setText(guia.get(listParticulares.getSelectedIndex()).getTelefono());
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
		
		JLabel label = new JLabel("TELEFONO:");
		label.setBounds(194, 210, 73, 14);
		contentPane.add(label);
		
		agregarNombre = new JTextField();
		agregarNombre.setEditable(false);
		agregarNombre.setBounds(277, 57, 116, 20);
		contentPane.add(agregarNombre);
		agregarNombre.setColumns(10);
		
		agregarApellido = new JTextField();
		agregarApellido.setEditable(false);
		agregarApellido.setColumns(10);
		agregarApellido.setBounds(277, 93, 116, 20);
		contentPane.add(agregarApellido);
		
		agregarCedula = new JTextField();
		agregarCedula.setEditable(false);
		agregarCedula.setColumns(10);
		agregarCedula.setBounds(277, 131, 116, 20);
		contentPane.add(agregarCedula);
		
		agregarDireccion = new JTextField();
		agregarDireccion.setEditable(false);
		agregarDireccion.setColumns(10);
		agregarDireccion.setBounds(277, 167, 116, 20);
		contentPane.add(agregarDireccion);
		
		agregarTelefono = new JTextField();
		agregarTelefono.setEditable(false);
		agregarTelefono.setColumns(10);
		agregarTelefono.setBounds(277, 207, 116, 20);
		contentPane.add(agregarTelefono);
		GuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("sfgadgadfgh");
			}
		});
		
		GuardarCambios.setVisible(false);
		GuardarCambios.setBounds(194, 276, 199, 23);
		contentPane.add(GuardarCambios);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(179, 42, 245, 270);
		contentPane.add(editorPane);
	}
}
