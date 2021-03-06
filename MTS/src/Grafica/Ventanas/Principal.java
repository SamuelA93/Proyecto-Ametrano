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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Grafica.Controladores.Controlador_Auxiliares;
import Grafica.Controladores.Controlador_Cliente;
import Grafica.Controladores.Controlador_Empleado;
import Grafica.Controladores.Controlador_Tarea;
import Grafica.Controladores.Controlador_Trabajo;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;
import Logica_Persistencia.Value_Object.VOTrabajo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Grafica.Ventanas.Editar_Tarea;

import javax.swing.JEditorPane;
import javax.swing.JTextField;

import com.sun.jndi.toolkit.ctx.PartialCompositeContext;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;


public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable table= new JTable();
	public Controlador_Tarea controlador = new Controlador_Tarea();
	//public table = new JTable();
	List<VOTarea> lstTareas=null;
	private 	JFrame frame2 = new JFrame("Exito");
	Controlador_Trabajo control_trabajo = new Controlador_Trabajo();
	Controlador_Empleado control_empleado = new Controlador_Empleado();
	Controlador_Cliente control = new Controlador_Cliente();
	private int row = -2;
	ArrayList<VOTarea> todo=new ArrayList();
	JCheckBox realiza;
	private String etapa = "";
	private boolean banderaEditable= false;
	private VOEmpresa empresa = new VOEmpresa();
	JCheckBox cancela;
	private VOParticular particular = new VOParticular();
	private long refEditar;
	private VOTrabajo trabajo = new  VOTrabajo();
	pruebaFechas fech_Aux = new pruebaFechas();
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
		 todo = new ArrayList<>();
		 ArrayList<Object[]> pend=new ArrayList();
		 ArrayList<Object[]> atra=new ArrayList();
		 
		 ArrayList<VOTarea> todo1=new ArrayList();
		 ArrayList<VOTarea> todo2=new ArrayList();
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
		modelo.addColumn("Trabajo");
		pruebaFechas aux = new pruebaFechas();
		if (lstTareas.size() > 0){	
			Iterator<VOTarea> iterT = lstTareas.iterator();
			while (iterT.hasNext()){
				VOTarea Tarea = iterT.next();
				Object[] fila = new Object[3];
				if (!(aux.reciente(aux.dateJAVA(Tarea.getFecha()), aux.dateJAVA("28/08/2014"))<0)) {
					fila[0] = Tarea.getFecha();
					fila[1] = Tarea.getHora();
					fila[2] = Tarea.getTrabajo();
					//System.out.println(Tarea.getFecha());
					//modelo.addRow(fila);
					pend.add(fila);
					todo1.add(Tarea);
				} else {
					//System.out.println(Tarea.getFecha());
					fila[0] = Tarea.getFecha();
					fila[1] = Tarea.getHora();
					fila[2] = Tarea.getTrabajo();
					//modelo2.addRow(fila);
					atra.add(fila);
					todo2.add(Tarea);
				}
			}
		}	
		for(int i = 0;i<todo1.size();i++){
			todo.add(todo1.get(i));
		}
		for(int i = 0;i<todo2.size();i++){
			todo.add(todo2.get(i));
		}
		//System.out.println(pend.get(0)[0]);
		for(int i = 0;i<pend.size();i++	){
			modelo.addRow( pend.get(i) );
		}
		
		for(int i = 0;i<atra.size();i++	){
			modelo.addRow( atra.get(i));
		}
		table.setModel(modelo);
		//table.setDefaultRenderer(Object.class, new CustomCellTabla());
		table.setDefaultRenderer(Object.class, new CustonRowTable());
	}
	public Principal() {
		setTitle("Administracion ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 478);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Nuevo_Empleado emple = new Nuevo_Empleado();
				emple.setVisible(true);
			}
		});
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
		mntmTrabajos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ver_Trabajo verTrabajo = new Ver_Trabajo();
				verTrabajo.setVisible(true);
			}
		});
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
		
		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mntmExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export_Particulares ex = new export_Particulares();
				ex.setVisible(true);
			}
		});
		mnInformes.add(mntmExportar);
		
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
		
		JButton btnNewButton = new JButton("Modificar Etapa");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow()>= 0){
					try {
						/*System.out.println(etapa);
						System.out.println(todo.get(table.getSelectedRow()).getEmpleado_cedula());
						System.out.println(todo.get(table.getSelectedRow()).getTrabajo());
						System.out.println(fech_Aux.fechaSQL(todo.get(table.getSelectedRow()).getFecha()));  */               
						if(cancela.isSelected() && !realiza.isSelected()){
							controlador.modificar_etapa("Cancelada", todo.get(table.getSelectedRow()).getEmpleado_cedula(), todo.get(table.getSelectedRow()).getTrabajo(), fech_Aux.fechaSQL(todo.get(table.getSelectedRow()).getFecha()));
						}
						if(realiza.isSelected() && !cancela.isSelected()){
							controlador.modificar_etapa("Hecha", todo.get(table.getSelectedRow()).getEmpleado_cedula(), todo.get(table.getSelectedRow()).getTrabajo(), fech_Aux.fechaSQL(todo.get(table.getSelectedRow()).getFecha()));
						}
						
					    cancela.setSelected(false);
					    realiza.setSelected(false);
					    actualizar_Tabla();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(650, 0, 152, 19);
		contentPane.add(btnNewButton);
		
		
		actualizar.setBackground(SystemColor.control);
		actualizar.setBounds(180, 19, 102, 21);
		contentPane.add(actualizar);
		
		 realiza = new JCheckBox("Hecho");
		realiza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("r");
				if (cancela.isSelected()) {
					cancela.setSelected(false);
				} 
				//realiza.setSelected(true);
				//etapa="Hecho";
				
			}
		});
		realiza.setBackground(SystemColor.inactiveCaptionBorder);
		realiza.setBounds(450, 0, 97, 19);
		contentPane.add(realiza);
		
	 cancela = new JCheckBox("Cancelada");
		cancela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				if (realiza.isSelected()) {
					realiza.setSelected(false);
				} 
				//cancela.setSelected(true);
				//etapa="Cancelada";
				//System.out.println(etapa);
			}
		});
		cancela.setBackground(SystemColor.inactiveCaptionBorder);
		cancela.setBounds(550, 0, 97, 19);
		contentPane.add(cancela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				cancela.setSelected(false);
				realiza.setSelected(false);
			}
		});
		scrollPane.setBounds(5, 45, 277, 368);
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
		//table = new JTable();
		
		actualizar_Tabla();
		//table.setModel(modelo);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(287, 281, 277, 132);
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
				row = table.getSelectedRow();
				//System.out.println( todo.get(row).getComentario()+" "+todo.get(row).getEmpleado_cedula()+" "+todo.get(row).getEncanombre());
				//System.out.println(todo.get(row).getEtapa()+" "+todo.get(row).getTrabajo());
				banderaEditable = true;
				estado.setText(todo.get(row).getEtapa());
				comentarioP.setText( todo.get(row).getComentario());
				String empleado;
				try {
					empleado = control_empleado.empleadoXcedula(todo.get(row).getEmpleado_cedula());
					encargado.setText(empleado);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				try {
					/////////  cargo datos de pago segun la row seleccionada
					System.out.println(todo.get(row).getTrabajo());
					trabajo = control_trabajo.obtenerTrabajoXid(todo.get(row).getTrabajo());
					monto.setText(""+trabajo.getMontoTotal());
					cuotas.setText(trabajo.getCuotas()+"");
					
					///////////  cargar cliente 
					
					if (control.esCedula(trabajo.getReferencia())){
						
						particular = control.ParticularXcedula(trabajo.getReferencia());
						cliente.setText(particular.getNombre());
						lblContacto.setText("APELLIDO : ");
						contacto.setText(particular.getApellido());
						refEditar=particular.getCedula();
						referencia.setText(""+particular.getCedula());
						direccion.setText(particular.getDireccion());
						tel.setText(particular.getTelefono()+" / "+particular.getTelefono2());
					}else{
						
						empresa = control.EmpresaXrut(trabajo.getReferencia());
						cliente.setText(empresa.getNombre());
						lblContacto.setText("CONTACTO : ");
						contacto.setText(empresa.getContacto());
						refEditar=empresa.getRut();
						referencia.setText(""+empresa.getRut());
						direccion.setText(empresa.getDireccion());
						tel.setText(empresa.getTelefono()+" / "+empresa.getTelefono2());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*banderaEditable= true;
				row = table.getSelectedRow();
				comentarioP.setText( todo.get(row).getComentario());
				System.out.println(todo.get(row).getComentario());
				try {
					//System.out.println(lstTareas.get(row).getTrabajo());
					 trabajo = control_trabajo.obtenerTrabajoXid(todo.get(row).getTrabajo());
					
					estado.setText(todo.get(row).getEtapa());
					monto.setText(""+trabajo.getMontoTotal());
					cuotas.setText(trabajo.getCuotas()+"");
					encargado.setText(control_empleado.empleadoXcedula(todo.get(row).getEmpleado_cedula()));
					//System.out.println(trabajo.getReferencia());
					if (control.esCedula(trabajo.getReferencia())){
						particular = control.ParticularXcedula(trabajo.getReferencia());
						cliente.setText(particular.getNombre());
						lblContacto.setText("APELLIDO : ");
						contacto.setText(particular.getApellido());
						refEditar=particular.getCedula();
						referencia.setText(""+particular.getCedula());
						direccion.setText(particular.getDireccion());
						tel.setText(particular.getTelefono()+" / "+particular.getTelefono2());
					}else{
						
						empresa = control.EmpresaXrut(trabajo.getReferencia());
						cliente.setText(empresa.getNombre());
						lblContacto.setText("CONTACTO : ");
						contacto.setText(empresa.getContacto());
						refEditar=empresa.getRut();
						referencia.setText(""+empresa.getRut());
						direccion.setText(empresa.getDireccion());
						tel.setText(empresa.getTelefono()+" / "+empresa.getTelefono2());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			}
		});
		scrollPane.setViewportView(table);
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(290, 259, 80, 14);
		contentPane.add(lblComentario);
		
		JLabel lblInformacionDelCliente = new JLabel("Informaci\u00F3n del cliente  ");
		lblInformacionDelCliente.setBounds(290, 24, 214, 14);
		contentPane.add(lblInformacionDelCliente);
		
		JLabel lblEstadoDePago = new JLabel("Informaci\u00F3n de pago");
		lblEstadoDePago.setBounds(571, 259, 203, 14);
		contentPane.add(lblEstadoDePago);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setToolTipText("");
		menuBar_1.setBounds(290, 256, 512, 21);
		contentPane.add(menuBar_1);
		
		JMenuBar bar_sub1 = new JMenuBar();
		bar_sub1.setBounds(0, 20, 813, 21);
		contentPane.add(bar_sub1);
		
		JMenu mnNuevo_1 = new JMenu("Nuevo");
		mnNuevo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Administrar_tareas tareaNueva = new Administrar_tareas();
				tareaNueva.setVisible(true);
				
			}
		});
		
		bar_sub1.add(mnNuevo_1);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(banderaEditable){
					Editar_Tarea editarTarea = new Editar_Tarea(refEditar,todo.get(row).getTrabajo(),todo.get(row).getEmpleado_cedula(),todo.get(row));
					editarTarea.setVisible(true);
				}else{
					//System.out.println(row);
				}
				
			}
		});
		
		bar_sub1.add(mnEditar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int row = table.getSelectedRow();
				pruebaFechas aux = new pruebaFechas();
				//Controlador_Eliminar_Tarea eli = new Controlador_Eliminar_Tarea();
				
				try {
					//System.out.println(lstTareas.get(row).getTrabajo());
					//System.out.println(lstTareas.get(row).getEmpleado_cedula());
					//System.out.println(aux.fechaSQL(lstTareas.get(row).getFecha()));
					controlador.eliminar(lstTareas.get(row).getTrabajo(), lstTareas.get(row).getEmpleado_cedula(),aux.fechaSQL(lstTareas.get(row).getFecha()) );
					actualizar_Tabla();
					
				} catch (SQLException e) {
					 //TODO Auto-generated catch block
					e.printStackTrace();
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Error al eliminar.", "Atenci�n!!!", mensaje.ERROR_MESSAGE);
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
		menuBar_3.setBounds(0, 0, 812, 21);
		contentPane.add(menuBar_3);
		
		
		encargado.setBounds(400, 56, 214, 21);
		contentPane.add(encargado);
		
		
		lblEncargado.setBounds(299, 60, 108, 14);
		contentPane.add(lblEncargado);
		
		
		cliente.setBounds(400, 86, 233, 21);
		contentPane.add(cliente);
		
		JLabel lblCliente = new JLabel("CLIENTE : ");
		lblCliente.setBounds(299, 90, 108, 14);
		contentPane.add(lblCliente);
		
		
		contacto.setBounds(400, 116, 233, 21);
		contentPane.add(contacto);
		
		
		lblContacto.setBounds(299, 120, 108, 14);
		contentPane.add(lblContacto);
		
		
		referencia.setBounds(400, 146, 170, 21);
		contentPane.add(referencia);
		
		JLabel lblRutCi = new JLabel("RUT / CI : ");
		lblRutCi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRutCi.setBounds(292, 150, 59, 14);
		contentPane.add(lblRutCi);
		
		
		direccion.setBounds(400, 176, 402, 21);
		contentPane.add(direccion);
		
		JLabel lblDireccion = new JLabel("DIRECCION : ");
		lblDireccion.setBounds(299, 180, 108, 14);
		contentPane.add(lblDireccion);
		
		
		tel.setBounds(400, 206, 328, 21);
		contentPane.add(tel);
		
		JLabel lblTelefono = new JLabel("TELEFONO : ");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setBounds(299, 210, 108, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblMontoTotal = new JLabel("MONTO TOTAL : ");
		lblMontoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblMontoTotal.setBounds(580, 295, 108, 14);
		contentPane.add(lblMontoTotal);
		
		
		monto.setHorizontalAlignment(SwingConstants.LEFT);
		monto.setBounds(700, 295, 66, 14);
		contentPane.add(monto);
		
		
		cuotas.setHorizontalAlignment(SwingConstants.LEFT);
		cuotas.setBounds(700, 320, 59, 14);
		contentPane.add(cuotas);
		
		JLabel lblCuotas = new JLabel("CUOTAS : ");
		lblCuotas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuotas.setBounds(580, 320, 108, 14);
		contentPane.add(lblCuotas);
		
		
		estado.setHorizontalAlignment(SwingConstants.LEFT);
		estado.setBounds(699, 390, 85, 14);
		contentPane.add(estado);
		
		JLabel lblEstado = new JLabel("ESTADO : ");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setBounds(580, 390, 108, 14);
		contentPane.add(lblEstado);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(287, 45, 515, 206);
		contentPane.add(scrollPane_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane_2.setViewportView(editorPane);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(569, 281, 233, 71);
		contentPane.add(scrollPane_3);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		scrollPane_3.setViewportView(editorPane_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(569, 382, 233, 31);
		contentPane.add(scrollPane_4);
		
		JEditorPane editorPane_2 = new JEditorPane();
		scrollPane_4.setViewportView(editorPane_2);
		
		JLabel lblEtapaDeTarea = new JLabel("Etapa de tarea");
		lblEtapaDeTarea.setBounds(580, 358, 97, 14);
		contentPane.add(lblEtapaDeTarea);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(569, 356, 235, 21);
		contentPane.add(menuBar_2);
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
