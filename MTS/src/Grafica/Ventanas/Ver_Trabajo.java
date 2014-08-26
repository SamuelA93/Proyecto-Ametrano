package Grafica.Ventanas;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;

import Grafica.Controladores.Controlador_Cliente;
import Grafica.Controladores.Controlador_Tarea;
//import Grafica.Controladores.Controlador_EditarTrabajo;
//import Grafica.Controladores.Controlador_ListarParticularEmpresa;
import Grafica.Controladores.Controlador_Trabajo;
import Grafica.Controladores.Controlador_Verificar;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTrabajo;
///import Grafica.Controladores.Controlador_VerTrabajo;
import Logica_Persistencia.Value_Object.VOTrabajosClientes;
import Logica_Persistencia.Value_Object.VOUnTrabajo;

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
import javax.swing.JComboBox;

public class Ver_Trabajo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList listClientes;
	private int j=0;
	Controlador_Trabajo control_trabajo = new Controlador_Trabajo();
	Controlador_Cliente contro_cliente = new Controlador_Cliente();
	Controlador_Verificar contro_verif = new Controlador_Verificar();
	List<VOTrabajo> guia= null;
	private JTextField agregarCliente;
	private JTextField agregarMonto;
	private JTextField agregarCuotas;
	private int agregarId;
	private String estado;
	private boolean editer=false;
	JButton GuardarCambios = new JButton("Guardar Cambios");
	JComboBox comboEstado = new JComboBox();
	private Controlador_Cliente control_clientes = new Controlador_Cliente();
	private 	JFrame frame = new JFrame("Exito");
	private Controlador_Tarea control_tarea = new Controlador_Tarea();
	private List<VOCliente> clientes = null;
	private List<VOTrabajo> trabajos = null;
	private List<VOTarea> tareas = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Trabajo frame = new Ver_Trabajo();
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
		 boolean clip = (!listClientes.isSelectionEmpty() && (bandera));
		if (clip){
			//System.out.println("si");
			agregarMonto.setEditable(clip);
			agregarCuotas.setEditable(clip);
			comboEstado.setEnabled(clip);
			GuardarCambios.setVisible(clip);
		}else{
			//System.out.println("no");
			agregarCliente.setEditable(clip);
			comboEstado.setEnabled(clip);
			GuardarCambios.setVisible(clip);
			agregarCuotas.setEditable(clip); 
			agregarMonto.setEditable(clip);
			
		}
		
	}
	public void filtrarTuplasTrabajos(String [] tuplasClien, String subCadena,List<VOTrabajo> clie){
		// Dado un array de tuplas de pacientes y una subcadena, va filtrando los nombres del jList
			boolean hayQueFiltrar = false;
			DefaultListModel modeloSocios = new DefaultListModel();
			guia= new ArrayList<VOTrabajo>();
			for (int i=0; i<tuplasClien.length;i++){			
				if (tuplasClien[i].toUpperCase().startsWith(subCadena.toUpperCase())){
					guia.add(clie.get(i));
					hayQueFiltrar = true;			
					modeloSocios.addElement(tuplasClien[i]);
				}
			}
			if (hayQueFiltrar){
				listClientes.setModel(modeloSocios);			
			}		
		}
	//function independienta lista que aparece en la lista de particulares
	public String[] trabajosToString() {
		// Retorna un array de pacientes en el cual cada tupla esta formada por nombre y apellido
		// Este array luego se le pasa al jlist de pacientes
			try {
				trabajos = control_trabajo.Listar_Trabajos();
				clientes = control_clientes.ListarClientes();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("no cargo lista trabajos");
			}
			//List<VOTrabajosClientes> trabajosCliente = contro_cliente.listarTrabajosClientes();
			guia= new ArrayList<VOTrabajo>();
			String[] tuplas = new String[trabajos.size()];
			int i = 0;
			for (VOTrabajo x : trabajos){
				guia.add(x);
				int j=0;
				while( (j<clientes.size()) && (clientes.get(j).getReferencia() != x.getReferencia()) ){
					j++;
				}
				if(j<clientes.size()){
				tuplas[i] = clientes.get(j).getNombre()+" "+ x.getId();
				}
				i++;
			}		
			return tuplas;
		}
	//finalizada el metodo particulares toString renombrada trabajosToString
	public Ver_Trabajo() {
		setTitle("Trabajos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 394);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		mnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Nuevo_Trabajo t = new Nuevo_Trabajo();
				t.setVisible(true);
			}
		});
		mnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuevo_Trabajo t = new Nuevo_Trabajo();
				t.setVisible(true);
			}
		});
		menuBar.add(mnNuevo);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

					setEditableCampos(true);
					//GuardarCambios.setVisible(true);
					//asigno valor del objeto al comboBox
					/*if(agregarEstado.getText().equals("Activo")){
						comboEstado.setSelectedIndex(0);
					}else{
						comboEstado.setSelectedIndex(1);
					}*/
}
		});
		
		menuBar.add(mnEditar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			StringBuffer txt = new StringBuffer();
			@Override
			public void keyTyped(KeyEvent e) {
				List<VOTrabajo> trabajos;
				trabajos= null;
				try {
					trabajos = control_trabajo.Listar_Trabajos();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				char caracter = e.getKeyChar();								
				if (caracter == KeyEvent.VK_BACK_SPACE){
					e.consume();	
					if (txt.length() >=1){
						txt.setLength(txt.length()-1);
						filtrarTuplasTrabajos(trabajosToString(),txt.toString(),trabajos);
					}
				}else{
					txt.append(caracter);					
					filtrarTuplasTrabajos(trabajosToString(),txt.toString(),trabajos);
				}
				
			}
		});
		textField.setBounds(59, 11, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 165, 270);
		contentPane.add(scrollPane);
		//retocada listClientes
		listClientes = new JList(this.trabajosToString());
		listClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setEditableCampos(false);
				GuardarCambios.setVisible(false);
				//control_trabajo.verTrabajo(guia.get(listClientes.getSelectedIndex()).getIdTrabajos());
				//VOUnTrabajo unTrabajo = control_trabajo.verTrabajo(guia.get(listClientes.getSelectedIndex()).getIdTrabajos());
				//aca se tiene que crear un nuevo objeto que traiga los datos nuevamente modificados
				agregarCliente.setText(""+guia.get(listClientes.getSelectedIndex()).getId());
				agregarMonto.setText(""+guia.get(listClientes.getSelectedIndex()).getMontoTotal()); 
				//agregarId=guia.get(listClientes.getSelectedIndex()).getIdTrabajos();
				//System.out.println("agregarId :"+agregarId);
				//agregarEstado.setText(unTrabajo.getestado());
				if(guia.get(listClientes.getSelectedIndex()).getEstado().equals("Activo")){
					comboEstado.setSelectedIndex(0);
				}else{
					comboEstado.setSelectedIndex(1);
				}
				agregarCuotas.setText(""+guia.get(listClientes.getSelectedIndex()).getCuotas());
				//System.out.println("estado objeto:"+ agregarEstado.getText());
			}
		});
		scrollPane.setViewportView(listClientes);
		
		JLabel lblNombre = new JLabel("Cliente");
		lblNombre.setBounds(10, 14, 54, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCliente_1 = new JLabel("TRABAJO:");
		lblCliente_1.setBounds(194, 60, 73, 14);
		contentPane.add(lblCliente_1);
		
		JLabel lblEstado = new JLabel("ESTADO:");
		lblEstado.setBounds(194, 96, 73, 14);
		contentPane.add(lblEstado);
		
		JLabel lblMonto = new JLabel("MONTO:");
		lblMonto.setBounds(194, 134, 73, 14);
		contentPane.add(lblMonto);
		
		JLabel lblCuotas = new JLabel("CUOTAS:");
		lblCuotas.setBounds(194, 170, 73, 14);
		contentPane.add(lblCuotas);
		
		agregarCliente = new JTextField();
		agregarCliente.setEditable(false);
		agregarCliente.setBounds(277, 57, 116, 20);
		contentPane.add(agregarCliente);
		agregarCliente.setColumns(10);
		
		agregarMonto = new JTextField();
		agregarMonto.setEditable(false);
		agregarMonto.setColumns(10);
		agregarMonto.setBounds(277, 131, 116, 20);
		contentPane.add(agregarMonto);
		
		agregarCuotas = new JTextField();
		agregarCuotas.setEditable(false);
		agregarCuotas.setColumns(10);
		agregarCuotas.setBounds(277, 167, 116, 20);
		contentPane.add(agregarCuotas);
		GuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//int cuotas = Integer.parseInt(agregarCuotas.getText());
				String estadofinal = estado;
				boolean err= false;
				
				if (contro_verif.espacios(agregarMonto.getText())  ) {
					
						agregarMonto.setText("0");
					
					if (contro_verif.espacios(agregarCuotas.getText()) ||contro_verif.SoloNumeros(agregarCuotas.getText())) {
						if (contro_verif.espacios(agregarCuotas.getText()) ) {
							agregarCuotas.setText("0");
						}
					} else {
						err= true;
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "En cuotas solo números.", "Atención!!!", mensaje.ERROR_MESSAGE);
					}
				} else {
					
					try {
						float k = Float.parseFloat(agregarMonto.getText());
					} catch (Exception e) {
						err= true;
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "En monto solo números.", "Atención!!!", mensaje.ERROR_MESSAGE);
					}
					
				}
				if (!err) {
					System.out.println(agregarMonto.getText());
					System.out.println(agregarCuotas.getText());
					System.out.println(comboEstado.getSelectedItem());
					System.out.println(agregarCliente.getText());
					float monto = Float.parseFloat(agregarMonto.getText());
					int id = Integer.parseInt(agregarCliente.getText());
					int cuotas = Integer.parseInt(agregarCuotas.getText());
					try {
						control_trabajo.editarTrabajo(cuotas, (String) comboEstado.getSelectedItem(), monto, id);
						JOptionPane.showMessageDialog(frame,
						        "Se ah modificado el trabajo ");
						
						trabajos = control_trabajo.Listar_Trabajos();
						setEditableCampos(false);
						////// actualizar lista 
						filtrarTuplasTrabajos(trabajosToString(), "",trabajos);
						/////////  esconder el boton de guardar cambios
						GuardarCambios.setVisible(false);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		
		GuardarCambios.setVisible(false);
		GuardarCambios.setBounds(194, 276, 199, 23);
		contentPane.add(GuardarCambios);
		
		comboEstado.setBounds(277, 93, 116, 20);
		contentPane.add(comboEstado);
		comboEstado.addItem("Activo");
		comboEstado.addItem("Finalizado");
		//comboEstado.setSelectedItem("Activo");
		comboEstado.setEnabled(false);
		
		comboEstado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//recorro las cedulas de la lista
				estado = ""+comboEstado.getSelectedItem();
			}
		});
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(179, 42, 245, 270);
		contentPane.add(editorPane);
		
		
	}
}
