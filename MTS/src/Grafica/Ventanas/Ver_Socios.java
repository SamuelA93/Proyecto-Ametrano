package Grafica.Ventanas;

import java.awt.BorderLayout;
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
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private Controlador_Obtener_Cliente_Ref_Dir_Tel control= new Controlador_Obtener_Cliente_Ref_Dir_Tel();
	private JTable linea;
	

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
	public void cargarLineaPagos( VOCliente socio){
		
		
		
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
		setBounds(100, 100, 694, 468);
		
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
		scrollPane.setBounds(5, 5, 543, 295);
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
				
				cargarLineaPagos(listCli.get(table.getSelectedRow()));
				
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
		btnMes.setBounds(563, 11, 98, 23);
		contentPane.add(btnMes);
		
		JButton btnMeses = new JButton("+ 2 Meses");
		btnMeses.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeses.setBounds(563, 45, 98, 23);
		contentPane.add(btnMeses);
		
		JButton btnMeses_1 = new JButton("+ 3 Meses");
		btnMeses_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnMeses_1.setBounds(563, 79, 98, 23);
		contentPane.add(btnMeses_1);
		
		textField = new JTextField();
		textField.setBounds(563, 110, 23, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Meses");
		btnNewButton.setBounds(588, 110, 72, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAo = new JButton("+ 1 A\u00F1o");
		btnAo.setBounds(563, 140, 98, 23);
		contentPane.add(btnAo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(555, 5, 113, 166);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(5, 329, 668, 74);
		contentPane.add(scrollPane_2);
		
		linea = new JTable();
		scrollPane_2.setViewportView(linea);
		
		JLabel lblSeguimientoDePagos = new JLabel("Seguimiento de pagos de CUOTA SOCIOS");
		lblSeguimientoDePagos.setBounds(5, 308, 321, 14);
		contentPane.add(lblSeguimientoDePagos);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 304, 680, 21);
		contentPane.add(menuBar_1);
	}
}
