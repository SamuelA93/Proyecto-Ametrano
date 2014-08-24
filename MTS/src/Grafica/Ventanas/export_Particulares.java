package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import Grafica.Controladores.Controlador_Cliente;
import Grafica.Controladores.Controlador_Empresa;
import Grafica.Controladores.Controlador_Particular;
import Grafica.Controladores.Controlador_Socio;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class export_Particulares extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private Controlador_Socio control_socios = new Controlador_Socio();
	private Controlador_Particular control_particulares = new Controlador_Particular();
	private Controlador_Empresa control_empresas = new Controlador_Empresa();
	private Controlador_Cliente control_clientes = new Controlador_Cliente();
	private List<VOParticular> particulares = null;
	private List socios = null;
	public static enum Socio {
        si, no;
    }
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
	public export_Particulares() {
		
		setTitle("Exportar Particulares");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por :");
		lblOrdenarPor.setBounds(21, 15, 94, 19);
		contentPane.add(lblOrdenarPor);
		
		 comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		comboBox.setBounds(110, 14, 141, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 617, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		cargartabla();
		JButton btnExportar = new JButton("Exportar ");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnExportar.setBounds(538, 13, 89, 23);
		contentPane.add(btnExportar);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(0, 0, 637, 325);
		contentPane.add(editorPane);
	}
}
