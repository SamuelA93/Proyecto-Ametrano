package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import Grafica.Controladores.Controlador_Obtener_Cliente_Ref_Dir_Tel;
import Grafica.Controladores.Controlador_Obtener_Fechas_Socio;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOSocio;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ver_Socios extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelo=null; 
	DefaultTableModel modelo2=null;
	private JTextField textField;
	List<VOCliente> listCli= null;
	int MAX,MIN;
	JButton menos;
	JButton mas;
	private Controlador_Obtener_Cliente_Ref_Dir_Tel control= new Controlador_Obtener_Cliente_Ref_Dir_Tel();
	private JTable linea;
	Controlador_Obtener_Fechas_Socio dato_fechas= new Controlador_Obtener_Fechas_Socio() ;
	VOSocio socio = new VOSocio();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Socios frame = new Ver_Socios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			} catch (Exception e) {
			  }*/
	}

	/**
	 * Create the frame.
	 */
	public Object[] indices(int largo,int palanca){
		Object[] indices= new Object[3];
		if (palanca==2){
			indices[0]=largo-5;
			indices[1]=largo;
			
		}else{
			if (palanca==1){
				if(MIN>0){
					indices[1]=MAX-1;
					indices[0]=MIN-1;
				}else{
					indices[1]=MAX;
					indices[0]=MIN;
				}
			}else{
				if (palanca==0){
					if( MAX<largo){
						indices[1]=MAX+1;
						indices[0]=MIN+1;
					}else{
						indices[1]=MAX;
						indices[0]=MIN;
					}
			}
		}
		}
		
		return indices;
	}
	public void cargarLineaPagos( VOCliente cliente, int pal){
		try {
			socio = dato_fechas.ObtenerFechas(cliente.getReferencia());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		
		pruebaFechas auxiliar = new pruebaFechas();
		Date cancelado=auxiliar.dateJAVA("01/01/2000");
		int j= socio.Largo();
		 modelo = new DefaultTableModel(){
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			
			Object[] indi = indices(socio.Largo(),pal);
			MIN=(int) indi[0];
			MAX=(int) indi[1];
			Date pendiente = auxiliar.dateJAVA("09/09/2009");
			/*System.out.println(MIN+" "+MAX);
			System.out.println(auxiliar.fechaJAVAstring(socio.getLista().get(socio.getLista().size()-1).getF1()));
			System.out.println(socio.Largo());
			System.out.println(socio.getLista().size());*/
			
			
		for (int i = MIN ; i<MAX ; i++){
			//System.out.println(i);
			if (!socio.getLista().get(i).getF2().equals(cancelado)){
				
				if(socio.getLista().get(i).getF2().equals(pendiente)){
					modelo.addColumn(auxiliar.fechaJAVAstring(socio.getLista().get(i).getF2())+" - PENDIENTE");
					
					System.out.println("entra");
				}else{
					modelo.addColumn(auxiliar.fechaJAVAstring(socio.getLista().get(i).getF1())+" - "+auxiliar.fechaJAVAstring(socio.getLista().get(i).getF2()));
					
				}
			}else{
				modelo.addColumn("CANCELADO");
				
				
			}
			
		}
		
		linea.setModel(modelo);
	}
	public void cargarTabla(){
		
		 listCli =  control.obtenerLista();
		 modelo2 = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		modelo2.addColumn("Cliente");
		modelo2.addColumn("CI/RUT");
		modelo2.addColumn("Direccion");
		modelo2.addColumn("Telefono");
		if (listCli.size() > 0){	
			Iterator<VOCliente> iterT = listCli.iterator();
			while (iterT.hasNext()){
				VOCliente Tarea = iterT.next();
				Object[] fila = new Object[4];
				fila[0] = Tarea.getNombre();
				fila[1] = Tarea.getReferencia();
				fila[2] = Tarea.getDir();
				fila[3] = Tarea.getTel();
				modelo2.addRow(fila);
			}		
		}	
		table.setModel(modelo2);
		
	}
	public Ver_Socios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 468);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		JMenu mnCancelar = new JMenu("Cancelar");
		menuBar.add(mnCancelar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 771, 295);
		contentPane.add(scrollPane);
		
		 
		
		modelo = new DefaultTableModel();
		
		/*modelo.addColumn("Cliente");
		modelo.addColumn("CI/RUT");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");*/
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				cargarLineaPagos(listCli.get(table.getSelectedRow()),2);
				mas.setEnabled(true);
				menos.setEnabled(true);
			}
		});
		cargarTabla();
		scrollPane.setViewportView(table);
		
		JButton btnMes = new JButton("+ 1 Mes");
		btnMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMes.setHorizontalAlignment(SwingConstants.LEFT);
		btnMes.setBounds(795, 11, 98, 23);
		contentPane.add(btnMes);
		
		JButton btnMeses = new JButton("+ 2 Meses");
		btnMeses.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeses.setBounds(795, 45, 98, 23);
		contentPane.add(btnMeses);
		
		JButton btnMeses_1 = new JButton("+ 3 Meses");
		btnMeses_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeses_1.setBounds(795, 79, 98, 23);
		contentPane.add(btnMeses_1);
		
		textField = new JTextField();
		textField.setBounds(795, 110, 23, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Meses");
		btnNewButton.setBounds(820, 110, 72, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAo = new JButton("+ 1 A\u00F1o");
		btnAo.setBounds(795, 140, 98, 23);
		contentPane.add(btnAo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(787, 5, 113, 166);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(55, 329, 796, 23);
		contentPane.add(scrollPane_2);
		
		linea = new JTable();
		scrollPane_2.setViewportView(linea);
		Dimension d = linea.getPreferredScrollableViewportSize();

		d.height = 200;
		
		linea.setPreferredScrollableViewportSize(d);
		
		JLabel lblSeguimientoDePagos = new JLabel("Seguimiento de pagos de CUOTA SOCIOS");
		lblSeguimientoDePagos.setBounds(5, 308, 321, 14);
		contentPane.add(lblSeguimientoDePagos);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 304, 910, 21);
		contentPane.add(menuBar_1);
		
		 menos = new JButton("<");
		 menos.setEnabled(false);
		menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarLineaPagos(listCli.get(table.getSelectedRow()),1);
			}
		});
		menos.setBounds(5, 329, 48, 23);
		contentPane.add(menos);
		
		 mas = new JButton(">");
		 mas.setEnabled(false);
		mas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarLineaPagos(listCli.get(table.getSelectedRow()),0);
			}
		});
		mas.setBounds(852, 329, 48, 23);
		contentPane.add(mas);
	}
}
