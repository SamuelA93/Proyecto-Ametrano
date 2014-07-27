package Grafica.Ventanas;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Grafica.Controladores.Controlador_Tabla_Tareas_Empresas;
import Grafica.Controladores.Controlador_Tabla_Tareas_Particulares;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Administracion ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 488);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mnNuevo.add(mntmEmpresa);
		
		JMenuItem mntmParticular = new JMenuItem("Particular");
		mntmParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Nuevo_Particular particular= new Nuevo_Particular();
				particular.setVisible(true);
				
				
			}
		});
		mnNuevo.add(mntmParticular);
		
		JMenuItem mntmTrabajo = new JMenuItem("Trabajo");
		mntmTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Nuevo_Trabajo trabajo= new Nuevo_Trabajo();
				trabajo.setVisible(true);
				
			}
		});
		mnNuevo.add(mntmTrabajo);
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mnNuevo.add(mntmEmpleado);
		
		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		JMenuItem mntmSocios = new JMenuItem("Socios");
		mnVer.add(mntmSocios);
		
		JMenuItem mntmClientes = new JMenuItem("Particulares");
		mnVer.add(mntmClientes);
		
		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mnVer.add(mntmEmpresas);
		
		JMenuItem mntmTrabajos = new JMenuItem("Trabajos");
		mnVer.add(mntmTrabajos);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mnVer.add(mntmEmpleados);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mnAyuda.add(mntmManual);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAyuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 556, 207);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel modelo = new DefaultTableModel(){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Contacto");
		modelo.addColumn("Telefono");
		modelo.addColumn("Ci.");
		modelo.addColumn("Dirección");
		modelo.addColumn("Encargado");
		
		Controlador_Tabla_Tareas_Particulares controlador = new Controlador_Tabla_Tareas_Particulares();
		final List<VOTareaParticular> lstParticularTarea = controlador.listarTareaParticular();
		if (lstParticularTarea.size() > 0){	
			Iterator<VOTareaParticular> iterPacientes = lstParticularTarea.iterator();
			while (iterPacientes.hasNext()){
				VOTareaParticular dataPaciente = iterPacientes.next();
				Object[] fila = new Object[7];
				fila[0] = dataPaciente.tarea.getFecha();
				
				fila[1] = dataPaciente.tarea.getHora();System.out.println(dataPaciente.tarea.getHora());
				fila[2] = dataPaciente.particular.getNombre();
				fila[3] = dataPaciente.particular.getTelefono();
				
				
				// cambio el formato de la fecha de pago
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//fila[4] = sdf.format(dataPaciente.getFechNac());
				fila[4] =dataPaciente.particular.getCedula();
				fila[5] = dataPaciente.particular.getDireccion();
				fila[6] = dataPaciente.tarea.getEncanombre();
				modelo.addRow(fila);
			}		
			
		}	
		table.setModel(modelo);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 268, 556, 95);
		contentPane.add(scrollPane_1);
		final JTextPane comentarioP = new JTextPane();
		//comentarioP.setText("Este es un comentario de un trabajo a realizar de la lista de arriba");
		scrollPane_1.setViewportView(comentarioP);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				comentarioP.setText( lstParticularTarea.get(row).tarea.getComentario());
				
				
			}
		});
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha", "Hora", "Contacto", "Telefono", "Ci/Rut", "Direcci\u00F3n", "Encargado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});*/
		scrollPane.setViewportView(table);
		
		
		
		
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(8, 250, 80, 14);
		contentPane.add(lblComentario);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		menuBar_1.setBounds(0, 247, 556, 21);
		contentPane.add(menuBar_1);
		
		JMenuBar bar_sub1 = new JMenuBar();
		bar_sub1.setBounds(0, 20, 570, 21);
		contentPane.add(bar_sub1);
		
		JMenu mnNuevo_1 = new JMenu("Nuevo");
		mnNuevo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bar_sub1.add(mnNuevo_1);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bar_sub1.add(mnEditar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bar_sub1.add(mnEliminar);
		
		JLabel lblParticulares = new JLabel("Trabajos a Particulares");
		lblParticulares.setBounds(5, 2, 193, 14);
		contentPane.add(lblParticulares);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 0, 556, 21);
		contentPane.add(menuBar_3);
		
		JScrollPane list2 = new JScrollPane();
		list2.setBounds(566, 40, 641, 207);
		contentPane.add(list2);
		
		table_1 = new JTable();
		
		list2.setViewportView(table_1);
		//
		DefaultTableModel modeloEmpresa = new DefaultTableModel(){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		modeloEmpresa.addColumn("Fecha");
		modeloEmpresa.addColumn("Hora");
		modeloEmpresa.addColumn("Empresa");
		modeloEmpresa.addColumn("RUT");
		modeloEmpresa.addColumn("Contacto");
		modeloEmpresa.addColumn("Telefono");
		modeloEmpresa.addColumn("Dirección");
		modeloEmpresa.addColumn("Encargado");
		
		Controlador_Tabla_Tareas_Empresas controlador2 = new Controlador_Tabla_Tareas_Empresas();
		final List<VOTareaEmpresa> lstEmpresaTarea = controlador2.listarTareaEmpresa();
		if (lstEmpresaTarea.size() > 0){	
			Iterator<VOTareaEmpresa> iterEmpresas = lstEmpresaTarea.iterator();
			while (iterEmpresas.hasNext()){
				VOTareaEmpresa dataPaciente = iterEmpresas.next();
				Object[] fila = new Object[8];
				fila[0] = dataPaciente.tarea.getFecha();
				
				fila[1] = dataPaciente.tarea.getHora();//System.out.println(dataPaciente.tarea.getHora());
				fila[2] = dataPaciente.empresa.getNombre();
				fila[3] = dataPaciente.empresa.getRut();
				
				
				// cambio el formato de la fecha de pago
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//fila[4] = sdf.format(dataPaciente.getFechNac());
				fila[4] =dataPaciente.empresa.getContacto();
				fila[5] = dataPaciente.empresa.getTelefono();
				fila[6] = dataPaciente.empresa.getDireccion();
				fila[7] = dataPaciente.tarea.getEncanombre();
				modeloEmpresa.addRow(fila);
			}		
			
		}	
		table_1.setModel(modeloEmpresa);
		
		JMenuBar bar_sub2 = new JMenuBar();
		bar_sub2.setBounds(566, 20, 641, 21);
		contentPane.add(bar_sub2);
		
		JMenu mnNuevo_2 = new JMenu("Nuevo");
		mnNuevo_2.setHorizontalAlignment(SwingConstants.CENTER);
		bar_sub2.add(mnNuevo_2);
		
		JMenu mnNewMenu = new JMenu("Editar");
		bar_sub2.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Eliminar");
		bar_sub2.add(mnNewMenu_1);
		
		JLabel label = new JLabel("Comentario");
		label.setBounds(576, 250, 80, 14);
		contentPane.add(label);
		
		JMenuBar bar_com2 = new JMenuBar();
		bar_com2.setToolTipText("");
		bar_com2.setBounds(550, 247, 659, 21);
		contentPane.add(bar_com2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(566, 268, 641, 95);
		contentPane.add(scrollPane_3);
		
		final JTextPane comentarioE = new JTextPane();
		scrollPane_3.setViewportView(comentarioE);
		
		JLabel lblTrabajosAEmpresas = new JLabel("Trabajos a Empresas");
		lblTrabajosAEmpresas.setBounds(570, 2, 193, 14);
		contentPane.add(lblTrabajosAEmpresas);
		
		JMenuBar bar_tit2 = new JMenuBar();
		bar_tit2.setBounds(550, 0, 656, 21);
		contentPane.add(bar_tit2);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row2 = table_1.getSelectedRow();
				comentarioE.setText( lstEmpresaTarea.get(row2).tarea.getComentario());
				
			}
		});
	}
}
