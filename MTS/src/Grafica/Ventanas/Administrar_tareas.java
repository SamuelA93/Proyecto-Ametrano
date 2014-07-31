package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JButton;

import Grafica.Controladores.Controlador_Obtener_Clientes_Referencia;
import Grafica.Controladores.Controlador_Tabla_Tareas;
import Grafica.Controladores.Controlador_Trabajo_TituloXreferencia;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrar_tareas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	 private List<Object[]> list = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrar_tareas frame = new Administrar_tareas();
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
	
	
	
	
	public Administrar_tareas() {
		setTitle("Nueva Tarea");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente ");
		lblCliente.setBounds(14, 35, 46, 14);
		contentPane.add(lblCliente);
		String entradaNombre ="a%";
		String entradareferencia="4%";
	
		 //Creo comboBox new JComboBox();  po.comboBox;
		 final JComboBox opcionCliente = new JComboBox(new Object[] {"Ester", "Jordi", "Jordina", "Jorge", "Sergi"});
		 Controlador_Obtener_Clientes_Referencia list_cont= new Controlador_Obtener_Clientes_Referencia();
		   
		 
		try {
			 list = list_cont.obtenerClientes(entradaNombre, entradareferencia);
			
			DefaultComboBoxModel modelo = new DefaultComboBoxModel();
			for (int i=0; i<list.size();i++){						
					modelo.addElement(list.get(i)[0]);
					//System.out.println(list.get(i)[0]);
			}
			opcionCliente.setModel(modelo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		 
		 AutoCompletion.enable(opcionCliente);
		 
		 //configuro para que sea editable
		opcionCliente.setEditable(true);
		
		opcionCliente.setBounds(70, 33, 167, 19);
		contentPane.add(opcionCliente);
		
		JLabel lblTrabajos = new JLabel("Trabajos");
		lblTrabajos.setBounds(14, 76, 79, 14);
		contentPane.add(lblTrabajos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 74, 167, 273);
		contentPane.add(scrollPane);
		
		final JList list_1 = new JList();
		opcionCliente.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				   
				// cargar lista de trabajos por el cliente elegido en jcombobox
					Controlador_Trabajo_TituloXreferencia  T =new Controlador_Trabajo_TituloXreferencia ();
					//int ref= (int) list.get(opcionCliente.getSelectedIndex())[1];
					long a= Long.parseLong((String) list.get(opcionCliente.getSelectedIndex())[1]);
					List<Object[]> listT=null;
					DefaultListModel modeloT = new DefaultListModel();
					try {
						listT = T.obtener_TrabajoId_Titulo(a);
						System.out.println(a);
						for (int i=0; i<listT.size();i++){			
							modeloT.addElement(listT.get(i)[0]);
							
						}
						list_1.setModel(modeloT);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			   }
		});
		
		
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(list_1);
		
		
		
		JLabel lblNewLabel = new JLabel("Encargado");
		lblNewLabel.setBounds(270, 90, 93, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(350, 85, 167, 19);
		contentPane.add(comboBox_2);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(270, 120, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(270, 150, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(270, 180, 77, 14);
		contentPane.add(lblComentario);
		
		textField = new JTextField();
		textField.setBounds(350, 115, 77, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(350, 145, 77, 20);
		contentPane.add(textField_1);
		
		JLabel lblDdmmaaaa = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa.setForeground(Color.GRAY);
		lblDdmmaaaa.setBounds(454, 120, 88, 14);
		contentPane.add(lblDdmmaaaa);
		
		JLabel lblHhmmss = new JLabel("hh/mm/ss");
		lblHhmmss.setForeground(Color.GRAY);
		lblHhmmss.setBounds(454, 150, 88, 14);
		contentPane.add(lblHhmmss);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(350, 183, 173, 153);
		contentPane.add(scrollPane_3);
		
		JTextArea textArea = new JTextArea();
		scrollPane_3.setViewportView(textArea);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(247, 74, 295, 273);
		contentPane.add(scrollPane_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(454, 369, 89, 23);
		contentPane.add(btnGuardar);
		
	}
}
