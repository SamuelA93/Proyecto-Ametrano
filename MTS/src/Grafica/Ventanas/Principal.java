package Grafica.Ventanas;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Grafica.Controladores.Controlador_Auxiliares;
import Grafica.Controladores.Controlador_ClienteXreferencia;
import Grafica.Controladores.Controlador_Eliminar_Tarea;
import Grafica.Controladores.Controlador_Tabla_Tareas;
import Grafica.Controladores.Controlador_TrabajoXid;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;
import Logica_Persistencia.Value_Object.VOTrabajo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.JTextField;

import com.sun.jndi.toolkit.ctx.PartialCompositeContext;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;


public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table= new JTable();
	public Controlador_Tabla_Tareas controlador = new Controlador_Tabla_Tareas();
	//public table = new JTable();
	List<VOTarea> lstTareas=null;
	private 	JFrame frame2 = new JFrame("Exito");
	public DefaultTableModel modelo = new DefaultTableModel(){

	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};

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
	public void actualizar_Tabla(){
		 lstTareas = controlador.listarTareas();
		//System.out.println("sfgahg");
		DefaultTableModel modelo = new DefaultTableModel(){
			
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		if (lstTareas.size() > 0){	
			Iterator<VOTarea> iterT = lstTareas.iterator();
			while (iterT.hasNext()){
				VOTarea Tarea = iterT.next();
				Object[] fila = new Object[2];
				fila[0] = Tarea.getFecha();
				fila[1] = Tarea.getHora();
				modelo.addRow(fila);
			}		
		}	
		table.setModel(modelo);
		
	}
	public Principal() {
		setTitle("Administracion ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 452);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mntmEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nueva_Empresa empresa = new Nueva_Empresa();
				empresa.setVisible(true);
			}
		});
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
		mntmSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ver_Socios ventanaSocios = new Ver_Socios();
				ventanaSocios.setVisible(true);
			}
		});
		mnVer.add(mntmSocios);
		
		JMenuItem mntmClientes = new JMenuItem("Particulares");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ver_Particulares parti = new Ver_Particulares();
				parti.setVisible(true);
				
			}
		});
		mnVer.add(mntmClientes);
		
		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mnVer.add(mntmEmpresas);
		
		JMenuItem mntmTrabajos = new JMenuItem("Trabajos");
		mnVer.add(mntmTrabajos);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ver_Empleados empleados_ver = new Ver_Empleados();
				empleados_ver.setVisible(true);
			}
		});
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
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton actualizar = new JButton("Actualizar");
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar_Tabla();
				
			}
		});
		
		
		actualizar.setBackground(SystemColor.control);
		actualizar.setBounds(180, 19, 102, 21);
		contentPane.add(actualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 45, 277, 207);
		contentPane.add(scrollPane);
		
		
		/*modelo.addColumn("Fecha");
		modelo.addColumn("Hora");*/
		
		/* lstTareas = controlador.listarTareas();
		if (lstTareas.size() > 0){	
			Iterator<VOTarea> iterT = lstTareas.iterator();
			while (iterT.hasNext()){
				VOTarea Tarea = iterT.next();
				Object[] fila = new Object[2];
				fila[0] = Tarea.getFecha();
				fila[1] = Tarea.getHora();
				modelo.addRow(fila);
			}		
		}	*/
		table = new JTable();
		actualizar_Tabla();
		//table.setModel(modelo);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 281, 277, 108);
		contentPane.add(scrollPane_1);
		final JTextPane comentarioP = new JTextPane();
		comentarioP.setEditable(false);
		//comentarioP.setText("Este es un comentario de un trabajo a realizar de la lista de arriba");
		scrollPane_1.setViewportView(comentarioP);
		final JLabel estado = new JLabel("");
		estado.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel monto = new JLabel("");
		monto.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel cuotas = new JLabel("");
		cuotas.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel encargado = new JLabel("");
		encargado.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel cliente = new JLabel("");
		cliente.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel contacto = new JLabel("");
		contacto.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel lblEncargado = new JLabel("ENCARGADO : ");
		final JLabel referencia = new JLabel("");
		referencia.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel direccion = new JLabel("");
		direccion.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel tel = new JLabel("");
		tel.setFont(new Font("Arial", Font.PLAIN, 13));
		final JLabel lblContacto = new JLabel("CONTACTO : ");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				comentarioP.setText( lstTareas.get(row).getComentario());
				Controlador_TrabajoXid trabajoXid = new  Controlador_TrabajoXid();
				//System.out.println(lstTareas.get(row).getTrabajo());
				try {
					//System.out.println(lstTareas.get(row).getTrabajo());
					VOTrabajo trabajo = trabajoXid.obtenerTrabajoXid(lstTareas.get(row).getTrabajo());
					
					estado.setText(trabajo.getEstado());
					monto.setText(""+trabajo.getMontoTotal());
					cuotas.setText(trabajo.getCuotas()+"");
					Controlador_Auxiliares empleadoNombre = new Controlador_Auxiliares();
					//empleadoNombre.empleadoXcedula(lstTareas.get(row).getEmpleado_cedula());
					
					encargado.setText(empleadoNombre.empleadoXcedula(lstTareas.get(row).getEmpleado_cedula()));
					Controlador_ClienteXreferencia control = new Controlador_ClienteXreferencia();
					//System.out.println(trabajo.getReferencia());
					if (control.esCedula(trabajo.getReferencia())){
						VOParticular particular = new VOParticular();
						particular = control.ParticularXcedula(trabajo.getReferencia());
						cliente.setText(particular.getNombre());
						lblContacto.setText("APELLIDO : ");
						contacto.setText(particular.getApellido());
						referencia.setText(""+particular.getCedula());
						direccion.setText(particular.getDireccion());
						tel.setText(particular.getTelefono()+" / "+particular.getTelefono2());
					}else{
						VOEmpresa empresa = new VOEmpresa();
						empresa = control.EmpresaXcedula(trabajo.getReferencia());
						cliente.setText(empresa.getNombre());
						lblContacto.setText("CONTACTO : ");
						contacto.setText(empresa.getContacto());
						referencia.setText(""+empresa.getRut());
						direccion.setText(empresa.getDireccion());
						tel.setText(empresa.getTelefono()+" / "+empresa.getTelefono2());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		JLabel lblComentario = new JLabel("COMENTARIO");
		lblComentario.setBounds(8, 259, 80, 14);
		contentPane.add(lblComentario);
		
		JLabel lblInformacionDelCliente = new JLabel("INFORMACION DEL CLIENTE  ");
		lblInformacionDelCliente.setBounds(290, 24, 214, 14);
		contentPane.add(lblInformacionDelCliente);
		
		JLabel lblEstadoDePago = new JLabel("INFORMACION DE PAGO");
		lblEstadoDePago.setBounds(290, 259, 203, 14);
		contentPane.add(lblEstadoDePago);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		menuBar_1.setBounds(0, 256, 600, 21);
		contentPane.add(menuBar_1);
		
		JMenuBar bar_sub1 = new JMenuBar();
		bar_sub1.setBounds(0, 20, 570, 21);
		contentPane.add(bar_sub1);
		
		JMenu mnNuevo_1 = new JMenu("Nuevo");
		mnNuevo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Administrar_tareas tareaNueva = new Administrar_tareas();
				tareaNueva.setVisible(true);
				
			}
		});
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
		mnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row = table.getSelectedRow();
				pruebaFechas aux = new pruebaFechas();
				Controlador_Eliminar_Tarea eli = new Controlador_Eliminar_Tarea();
				
				try {
					System.out.println(lstTareas.get(row).getTrabajo());
					System.out.println(lstTareas.get(row).getEmpleado_cedula());
					System.out.println(aux.fechaSQL(lstTareas.get(row).getFecha()));
					eli.eliminar(lstTareas.get(row).getTrabajo(), lstTareas.get(row).getEmpleado_cedula(),aux.fechaSQL(lstTareas.get(row).getFecha()) );
					actualizar_Tabla();
					
				} catch (SQLException e) {
					 //TODO Auto-generated catch block
					e.printStackTrace();
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Error al eliminar.", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
				/*JOptionPane.showMessageDialog(frame2,
				        "Se elimino correctamente. ");*/
				
			}
		});
		mnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		bar_sub1.add(mnEliminar);
		
		JLabel lblParticulares = new JLabel("Tareas pendientes");
		lblParticulares.setBounds(5, 2, 193, 14);
		contentPane.add(lblParticulares);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 0, 575, 21);
		contentPane.add(menuBar_3);
		
		
		encargado.setBounds(400, 56, 108, 21);
		contentPane.add(encargado);
		
		
		lblEncargado.setBounds(299, 60, 108, 14);
		contentPane.add(lblEncargado);
		
		
		cliente.setBounds(400, 86, 108, 21);
		contentPane.add(cliente);
		
		JLabel lblCliente = new JLabel("CLIENTE : ");
		lblCliente.setBounds(299, 90, 108, 14);
		contentPane.add(lblCliente);
		
		
		contacto.setBounds(400, 116, 108, 21);
		contentPane.add(contacto);
		
		
		lblContacto.setBounds(299, 120, 108, 14);
		contentPane.add(lblContacto);
		
		
		referencia.setBounds(400, 146, 108, 21);
		contentPane.add(referencia);
		
		JLabel lblRutCi = new JLabel("RUT / CI : ");
		lblRutCi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRutCi.setBounds(292, 150, 59, 14);
		contentPane.add(lblRutCi);
		
		
		direccion.setBounds(400, 176, 108, 21);
		contentPane.add(direccion);
		
		JLabel lblDireccion = new JLabel("DIRECCION : ");
		lblDireccion.setBounds(299, 180, 108, 14);
		contentPane.add(lblDireccion);
		
		
		tel.setBounds(400, 206, 160, 21);
		contentPane.add(tel);
		
		JLabel lblTelefono = new JLabel("TELEFONO : ");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setBounds(299, 210, 108, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblMontoTotal = new JLabel("MONTO TOTAL : ");
		lblMontoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblMontoTotal.setBounds(300, 295, 108, 14);
		contentPane.add(lblMontoTotal);
		
		
		monto.setHorizontalAlignment(SwingConstants.LEFT);
		monto.setBounds(400, 295, 108, 14);
		contentPane.add(monto);
		
		
		cuotas.setHorizontalAlignment(SwingConstants.LEFT);
		cuotas.setBounds(400, 320, 108, 14);
		contentPane.add(cuotas);
		
		JLabel lblCuotas = new JLabel("CUOTAS : ");
		lblCuotas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuotas.setBounds(300, 320, 108, 14);
		contentPane.add(lblCuotas);
		
		
		estado.setHorizontalAlignment(SwingConstants.LEFT);
		estado.setBounds(400, 345, 108, 14);
		contentPane.add(estado);
		
		JLabel lblEstado = new JLabel("ESTADO : ");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setBounds(300, 345, 108, 14);
		contentPane.add(lblEstado);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(287, 45, 279, 206);
		contentPane.add(scrollPane_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane_2.setViewportView(editorPane);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(287, 281, 279, 108);
		contentPane.add(scrollPane_3);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		scrollPane_3.setViewportView(editorPane_1);
		//
		DefaultTableModel modeloEmpresa = new DefaultTableModel(){

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
	}
}
