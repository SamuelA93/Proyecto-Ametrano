package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import Grafica.Controladores.Controlador_Cliente;
import Grafica.Controladores.Controlador_Empleado;
import Grafica.Controladores.Controlador_Empresa;
import Grafica.Controladores.Controlador_Particular;
import Grafica.Controladores.Controlador_Socio;
import Grafica.Controladores.Controlador_Tarea;
import Grafica.Controladores.Controlador_Trabajo;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTrabajo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.*;

import org.apache.poi.ss.usermodel.Sheet;

import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class export_Particulares extends JFrame {

	private JPanel contentPane;
	private JTable table= new JTable();
	private Controlador_Socio control_socios = new Controlador_Socio();
	private Controlador_Particular control_particulares = new Controlador_Particular();
	private Controlador_Empresa control_empresas = new Controlador_Empresa();
	private Controlador_Cliente control_clientes = new Controlador_Cliente();
	private Controlador_Trabajo control_trabajo = new Controlador_Trabajo();
	private Controlador_Tarea control_tarea = new Controlador_Tarea();
	private Controlador_Empleado control_empleados = new Controlador_Empleado();
	private List<VOParticular> particulares = null;
	private List<VOEmpresa> empresas = null;
	private List<VOCliente> clientes = null;
	private List<VOCliente> Socios = null;
	private List<VOTrabajo> trabajos = null;
	private List<VOTarea> tareas = null;
	private List<VOEmpleado> empleados = null;
	private List socios = null;
	private List exporta = null;
	pruebaFechas f = new pruebaFechas();
	private int versionDOC=0;
	private 	JFrame frame = new JFrame("Exito");
	Workbook wb;
	private ArrayList<String> caracterEspecial = new ArrayList();
	
	//private enum caracteresEspe {<, NICKLE, DIME, QUARTER};
	
	JCheckBox parti = new JCheckBox("Particulares");
	JCheckBox empre = new JCheckBox("Empresas");
	JCheckBox emple = new JCheckBox("Empleados");
	JCheckBox trabajo = new JCheckBox("Trabajos");
	JCheckBox soci = new JCheckBox("Socios");
	JCheckBox cli = new JCheckBox("Clientes");
	
	private ArrayList hojas = new ArrayList();
	public DefaultTableModel modelo = new DefaultTableModel(){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private DefaultTableModel modelo_Empresa = new DefaultTableModel(){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private DefaultTableModel modelo_trabajo = new DefaultTableModel(){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private DefaultTableModel modelo_Socios = new DefaultTableModel(){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private DefaultTableModel modelo_Empleado = new DefaultTableModel(){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
private DefaultTableModel modelo_Clientes= new DefaultTableModel(){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTable tabla_empresas;
	private JTable tabla_Clientes;
	private JTable tabla_empleados;
	private JTable tabla_socios;
	private JTable tabla_trabajos;
	private JTextField archivoNombre;
	private JTextField nombreC;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					export_Particulares frame = new export_Particulares();
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
	public void Hojas(String tipo){
		if (hojas.contains(tipo)) {
			hojas.remove(tipo);
		} else {
			hojas.add(tipo);
		}
		if (hojas.size()>0) {
			for (int i = 0; i <hojas.size(); i++) {
				//System.out.println(hojas.get(i));
			}
		
		}else{
			//System.out.println("nada");
		}
		
	}
	
	public void cargartablaTrabajos(){
		modelo_trabajo.addColumn("Nombre");
		modelo_trabajo.addColumn("Referencia");
		modelo_trabajo.addColumn("Monto");
		modelo_trabajo.addColumn("Cuotas");
		modelo_trabajo.addColumn("Estado");
		modelo_trabajo.addColumn("id Trabajo");
		List<VOCliente> clienteT = null;
		try {
			trabajos = control_trabajo.Listar_Trabajos();
			clienteT = control_clientes.ListarClientes();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Error al cargar empresas");
		}
	
		if (empleados.size() > 0){	
			Iterator<VOTrabajo> iterT = trabajos.iterator();
			while (iterT.hasNext()){
				VOTrabajo trabaj = iterT.next();
				Object[] fila = new Object[6];
				Iterator<VOCliente> CLiT = clienteT.iterator();
				while (CLiT.hasNext()){
					VOCliente OK = CLiT.next();
					
					//System.out.println(OK.getReferencia()+" == "+trabaj.getReferencia());
					if (OK.getReferencia() == trabaj.getReferencia()) {
						fila[0] = OK.getNombre();
						fila[1] = trabaj.getReferencia();
					}
				}	
				fila[2] = trabaj.getMontoTotal();
				fila[3] = trabaj.getCuotas();
				fila[4] = trabaj.getEstado();
				fila[5] = trabaj.getId();
				modelo_trabajo.addRow(fila);
			}		
		}
		tabla_trabajos.setModel(modelo_trabajo);
		//table.getColumnModel().getColumn(6).setCellRenderer(new RenderSocio());
	}
	public void cargartablaEmpeados(){
		modelo_Empleado.addColumn("Nombre");
		modelo_Empleado.addColumn("Contacto");
		modelo_Empleado.addColumn("RUT");
		modelo_Empleado.addColumn("Dirección");
		modelo_Empleado.addColumn("Tel.1");
		modelo_Empleado.addColumn("Tel.2");
		
		try {
			empleados = control_empleados.listarEmpleados();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Error al cargar empresas");
		}
	
		if (empleados.size() > 0){	
			Iterator<VOEmpleado> iterT = empleados.iterator();
			while (iterT.hasNext()){
				VOEmpleado emple = iterT.next();
				Object[] fila = new Object[6];
				fila[0] = emple.getNombre();
				fila[1] = emple.getApellido();
				fila[2] = emple.getCedula();
				fila[3] = emple.getDireccion();
				fila[4] = emple.getTelefono();
				fila[5] = emple.getTelefono2();
				
				modelo_Empleado.addRow(fila);
			}		
		}
		tabla_empleados.setModel(modelo_Empleado);
		//table.getColumnModel().getColumn(6).setCellRenderer(new RenderSocio());
	}
	public void cargartablaEmpresas(){
		modelo_Empresa.addColumn("Nombre");
		modelo_Empresa.addColumn("Contacto");
		modelo_Empresa.addColumn("RUT");
		modelo_Empresa.addColumn("Dirección");
		modelo_Empresa.addColumn("Tel.1");
		modelo_Empresa.addColumn("Tel.2");
		modelo_Empresa.addColumn("Socio");
		try {
			empresas = control_empresas.Listar_Empresas();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Error al cargar empresas");
		}
		try {
			socios = control_socios.Socio_ref();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (particulares.size() > 0){	
			Iterator<VOEmpresa> iterT = empresas.iterator();
			while (iterT.hasNext()){
				VOEmpresa empre = iterT.next();
				Object[] fila = new Object[7];
				fila[0] = empre.getNombre();
				fila[1] = empre.getContacto();
				fila[2] = empre.getRut();
				fila[3] = empre.getDireccion();
				fila[4] = empre.getTelefono();
				fila[5] = empre.getTelefono2();
				if (!socios.isEmpty() && socios.contains(empre.getRut())) {
					fila[6] = "si";
				} else {
					fila[6] = "no";
				}
				modelo_Empresa.addRow(fila);
			}		
		}
		tabla_empresas.setModel(modelo_Empresa);
		//table.getColumnModel().getColumn(6).setCellRenderer(new RenderSocio());
	}
	
	public void cargartablaClientes(){
		modelo_Clientes.addColumn("Nombre");
		modelo_Clientes.addColumn("RUT");
		modelo_Clientes.addColumn("Dirección");
		modelo_Clientes.addColumn("Tel1");
		modelo_Clientes.addColumn("Tel2");
		modelo_Clientes.addColumn("Socio");
		try {
			clientes = control_clientes.ListarClientes();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Error al cargar empresas");
		}
		try {
			socios = control_socios.Socio_ref();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (clientes.size() > 0){	
			Iterator<VOCliente> iterT = clientes.iterator();
			while (iterT.hasNext()){
				VOCliente client = iterT.next();
				Object[] fila = new Object[7];
				fila[0] = client.getNombre();
				
				fila[1] = client.getReferencia();
				fila[2] = client.getDir();
				fila[3] = client.getTel();
				fila[4] = client.getTel2();
				if (!socios.isEmpty() && socios.contains(client.getReferencia())) {
					fila[5] = "si";
				} else {
					fila[5] = "no";
				}
				modelo_Clientes.addRow(fila);
			}		
		}
		tabla_Clientes.setModel(modelo_Clientes);
		//table.getColumnModel().getColumn(6).setCellRenderer(new RenderSocio());
	}
	public void cargartablaSocios(){
		modelo_Socios.addColumn("Nombre");
		modelo_Socios.addColumn("Referencia");
		modelo_Socios.addColumn("Dirección");
		modelo_Socios.addColumn("Tel");
		modelo_Socios.addColumn("Tel2");
		try {
			Socios = control_clientes.ListarClientes();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.println("Error al cargar empresas");
		}
		try {
			socios = control_socios.Socio_ref();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Socios.size() > 0){	
			Iterator<VOCliente> iterT = Socios.iterator();
			while (iterT.hasNext()){
			 
				VOCliente client = iterT.next();

				if (!socios.isEmpty() && socios.contains(client.getReferencia())) {
				Object[] fila = new Object[5];
				fila[0] = client.getNombre();
				fila[1] = client.getReferencia();
				fila[2] = client.getDir();
				fila[3] = client.getTel();
				fila[4] = client.getTel2();
				modelo_Socios.addRow(fila);
				}
				
			}		
		}
		tabla_socios.setModel(modelo_Socios);
		//table.getColumnModel().getColumn(6).setCellRenderer(new RenderSocio());
	}
	public void cargartabla(){
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("C.I.");
		modelo.addColumn("Dirección");
		modelo.addColumn("Tel.1");
		modelo.addColumn("Tel.2");
		modelo.addColumn("Socio");
		particulares = control_particulares.listarParticulares();
		try {
			socios = control_socios.Socio_ref();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (particulares.size() > 0){	
			Iterator<VOParticular> iterT = particulares.iterator();
			while (iterT.hasNext()){
				VOParticular parti = iterT.next();
				Object[] fila = new Object[7];
				fila[0] = parti.getNombre();
				fila[1] = parti.getApellido();
				fila[2] = parti.getCedula();
				fila[3] = parti.getDireccion();
				fila[4] = parti.getTelefono();
				fila[5] = parti.getTelefono2();
				if (!socios.isEmpty() && socios.contains(parti.getCedula())) {
					fila[6] = "si";
				} else {
					fila[6] = "no";
				}
				modelo.addRow(fila);
			}		
		}
		table.setModel(modelo);
		//table.getColumnModel().getColumn(6).setCellRenderer(new RenderSocio());
	}
	public  Sheet particulares(JTable table,String T){
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Sheet sheet = wb.createSheet(T);
		Row row = null;
		Cell cell = null;
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 4000);
		sheet.setColumnWidth(6, 4000);
		CellStyle styleSocio = wb.createCellStyle();
		CellStyle styleHeader = wb.createCellStyle();
		styleSocio.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		styleSocio.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleHeader.setAlignment(CellStyle.ALIGN_CENTER);
		styleHeader.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		styleHeader.setBorderBottom(CellStyle.BORDER_THIN);
		styleHeader.setBorderTop(CellStyle.BORDER_THIN);
		Font fontheader = wb.createFont();
		fontheader.setBoldweight(Font.BOLDWEIGHT_BOLD);
		styleHeader.setFont(fontheader);
			row = sheet.createRow(2);
			for (int j=1;j<dtm.getColumnCount()+1;j++) {
				
				cell = row.createCell(j);
				cell.setCellValue(""+table.getColumnName(j-1));
				cell.setCellStyle(styleHeader);
				cell.getRow().setHeightInPoints(20);
			}
		for (int i=3;i<dtm.getRowCount()+3;i++) {
			row = sheet.createRow(i);
			for (int j=1;j<dtm.getColumnCount()+1;j++) {
				
				cell = row.createCell(j);
				cell.setCellValue(""+dtm.getValueAt(i-3, j-1));
				if (dtm.getValueAt(i-3, j-1).equals("si")) {
					cell.setCellStyle(styleSocio);
				}
			}
		}
		return sheet;
	}
	
	/*public void exportar(JTable table){
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			Workbook wb = new XSSFWorkbook();
			CreationHelper createhelper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet("new sheet");
			Row row = null;
			Cell cell = null;
			sheet.setColumnWidth(4, 5000);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6, 4000);
			CellStyle styleSocio = wb.createCellStyle();
			CellStyle styleHeader = wb.createCellStyle();
			styleSocio.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
			styleSocio.setFillPattern(CellStyle.SOLID_FOREGROUND);
			styleHeader.setAlignment(CellStyle.ALIGN_CENTER);
			
			styleHeader.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			styleHeader.setBorderBottom(CellStyle.BORDER_THIN);
			styleHeader.setBorderTop(CellStyle.BORDER_THIN);
			Font fontheader = wb.createFont();
			fontheader.setBoldweight(Font.BOLDWEIGHT_BOLD);
			styleHeader.setFont(fontheader);
				row = sheet.createRow(2);
				
				for (int j=1;j<dtm.getColumnCount()+1;j++) {
					
					cell = row.createCell(j);
					cell.setCellValue(""+table.getColumnName(j-1));
					cell.setCellStyle(styleHeader);
					cell.getRow().setHeightInPoints(20);
				}
			
			for (int i=3;i<dtm.getRowCount()+3;i++) {
				row = sheet.createRow(i);
				for (int j=1;j<dtm.getColumnCount()+1;j++) {
					
					cell = row.createCell(j);
					cell.setCellValue(""+dtm.getValueAt(i-3, j-1));
					if (dtm.getValueAt(i-3, j-1).equals("si")) {
						cell.setCellStyle(styleSocio);
					}
				}
			}


			FileOutputStream out = new FileOutputStream("workbook.xlsx");
			wb.write(out);
			out.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
 */
	public void CargarNombreArchivo(String txt){
		//nombreC.setText(txt);
		if (txt.trim().equals("")) {
			nombreC.setText("Datos MTS "+f.fechaActualDate2());
		} else {
			nombreC.setText(WorkbookUtil.createSafeSheetName(txt)+" "+f.fechaActualDate2());
		}
		
	}
	
	public export_Particulares() {
		caracterEspecial.add("<");
		caracterEspecial.add(">");
		caracterEspecial.add("?");
		caracterEspecial.add("|");
		caracterEspecial.add("¿");
		setTitle("Exportar Datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cargartabla();
		JButton btnExportar = new JButton("Exportar ");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 wb = new XSSFWorkbook();
				ArrayList<Sheet> pag= new ArrayList();
				if(hojas.size()>0){
					int i = 0;
					while(i<hojas.size()){
						switch ((String)hojas.get(i)) {
						case "Particulares": pag.add(particulares(table,"Particulares"));
							
							break;
						case "Empresas":  pag.add(particulares(tabla_empresas,"Empresas"));
						
							break;	
						case "Clientes": pag.add(particulares(tabla_Clientes,"Clientes"));

							break;
						case "Socios": pag.add(particulares(tabla_socios,"Socios"));

							break;
						case "Trabajos": pag.add(particulares(tabla_trabajos,"Trabajos"));

							break;
						case "Empleados": pag.add(particulares(tabla_empleados,"Empleados"));

							break;
						default:
							break;
						}
						i++;
					}
					try{
						String ext = ".xlsx";
						String tirar = nombreC.getText()+ext;
						FileOutputStream out = new FileOutputStream(tirar);
						wb.write(out);
						out.close();
						JOptionPane.showMessageDialog(frame, "Se a exportado con exito.");
					} catch (FileNotFoundException ex) {
						Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, ex);
					} catch (IOException ex) {
						Logger.getLogger(ExportToExcel.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				//exportar(table);
				/*File test = new File("casa.xls");
				try {
					exportTable(table, test);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});
		
		JLabel lblHojasExcel = new JLabel("Hojas Excel");
		lblHojasExcel.setBounds(10, 4, 127, 14);
		contentPane.add(lblHojasExcel);
		btnExportar.setBounds(598, 488, 89, 23);
		contentPane.add(btnExportar);
		
		JLabel lblFormatoDeLas = new JLabel("Formato de las tablas ");
		lblFormatoDeLas.setBounds(10, 62, 127, 14);
		contentPane.add(lblFormatoDeLas);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 708, 21);
		contentPane.add(menuBar);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 58, 710, 21);
		contentPane.add(menuBar_1);
		
		
		parti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hojas("Particulares");
				
			}
		});
		parti.setBounds(10, 28, 97, 23);
		contentPane.add(parti);
		empre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hojas("Empresas");
				
			}
		});
		
		
		empre.setBounds(125, 28, 97, 23);
		contentPane.add(empre);
		cli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hojas("Clientes");
			}
		});
		
		
		cli.setBounds(241, 28, 97, 23);
		contentPane.add(cli);
		emple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hojas("Empleados");
			}
		});
		
		
		emple.setBounds(355, 28, 97, 23);
		contentPane.add(emple);
		trabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hojas("Trabajos");
			}
		});
		
	
		trabajo.setBounds(590, 28, 97, 23);
		contentPane.add(trabajo);
		soci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hojas("Socios");
			}
		});
		
		
		soci.setBounds(486, 28, 97, 23);
		contentPane.add(soci);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 91, 708, 315);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Particulares", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 703, 286);
		panel.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Empresas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 703, 287);
		panel_1.add(scrollPane_1);
		
		tabla_empresas = new JTable();
		cargartablaEmpresas();
		scrollPane_1.setViewportView(tabla_empresas);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Clientes", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 703, 287);
		panel_2.add(scrollPane_2);
		tabla_empleados = new JTable();
		tabla_Clientes = new JTable();
		cargartablaClientes();
		cargartablaEmpeados();
		
		scrollPane_2.setViewportView(tabla_Clientes);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Empleados", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 703, 287);
		panel_3.add(scrollPane_3);
		
		
		scrollPane_3.setViewportView(tabla_empleados);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Socios", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 703, 287);
		panel_4.add(scrollPane_4);
		
		tabla_socios = new JTable();
		cargartablaSocios();
		scrollPane_4.setViewportView(tabla_socios);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Trabajos", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 0, 703, 287);
		panel_5.add(scrollPane_5);
		
		tabla_trabajos = new JTable();
		cargartablaTrabajos();
		scrollPane_5.setViewportView(tabla_trabajos);
		
		JLabel lblNombreDelArchivo = new JLabel("Nombre del Archivo :");
		lblNombreDelArchivo.setBounds(10, 433, 127, 14);
		contentPane.add(lblNombreDelArchivo);
		
		archivoNombre = new JTextField();
		archivoNombre.setText("Datos MTS "+f.fechaActualDate2());
		archivoNombre.addKeyListener(new KeyAdapter() {
			StringBuffer txt = new StringBuffer();
			
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();	
					if (caracter == KeyEvent.VK_BACK_SPACE){
						e.consume();	
						if (txt.length() >=1){
							txt.setLength(txt.length()-1);
							String k = txt.toString();
							StringBuilder m = new StringBuilder(txt.toString());
							for(int i = 0;i<k.length();i++){
								if(caracterEspecial.contains(k.charAt(i)+"")){
								m.setCharAt(i, ' ');
								}
							}
							
								CargarNombreArchivo(m.toString());
							
						}
					}else{
						txt.append(caracter);	
						String k = txt.toString();
						StringBuilder m = new StringBuilder(txt.toString());
						for(int i = 0;i<k.length();i++){
							if(caracterEspecial.contains(k.charAt(i)+"")){
							m.setCharAt(i, ' ');
							}
						}
						if(m.toString().length()>0){
							//System.out.println(m.toString());
							CargarNombreArchivo(m.toString());
						}
						/*String k = txt.toString().charAt(txt.length()-1)+"";
						if(caracterEspecial.contains(k)){
							//System.out.println(txt.toString().substring(0, txt.length()-2)+"8");
							StringBuilder m = new StringBuilder(txt.toString());
							m.setCharAt(txt.length()-1, ' ');
							System.out.println(m.toString());
							//CargarNombreArchivo(m.toString());
						}else{
							//System.out.println(txt.toString());
							System.out.println(txt.toString());
							//CargarNombreArchivo(txt.toString());
						}*/
						//CargarNombreArchivo(txt.toString());
					}
				
			}
		});
		archivoNombre.setBounds(275, 430, 155, 20);
		contentPane.add(archivoNombre);
		archivoNombre.setColumns(10);
		
		JLabel lblCorreccionDeCaracteres = new JLabel("Correcci\u00F3n de caracteres inv\u00E1lidos :");
		lblCorreccionDeCaracteres.setBounds(10, 458, 257, 14);
		contentPane.add(lblCorreccionDeCaracteres);
		
		nombreC = new JTextField();
		nombreC.setText("Datos MTS "+f.fechaActualDate2());
		nombreC.setEditable(false);
		nombreC.setBounds(275, 455, 155, 20);
		contentPane.add(nombreC);
		nombreC.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(0, 58, 708, 471);
		contentPane.add(editorPane);
	}
}
