package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JButton;

import Grafica.Controladores.Controlador_Nueva_Tarea;
import Grafica.Controladores.Controlador_Obtener_Clientes_Referencia;
import Grafica.Controladores.Controlador_Tabla_Tareas;
import Grafica.Controladores.Controlador_Trabajo_TituloXreferencia;
import Grafica.Controladores.Controlador_listarEmpleados;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Administrar_tareas extends JFrame {

	private JPanel contentPane;
	 private List<Object[]> list = null;
	 private List<VOEmpleado> listE ;
	 String entradaNombre ="a%";
		String entradareferencia="4%";
	 JComboBox encarSelec = new JComboBox(inici("empleados"));
	 final JComboBox opcionCliente = new JComboBox(inici("clientes"));
	  JList list_1 = new JList();
	  private boolean bandera= false;
	  pruebaFechas auxiliar =new pruebaFechas();
	  JFormattedTextField fechaformat;
	  JFormattedTextField horaformat;
	  MaskFormatter mascara;
	  MaskFormatter  mascara2;
	  List<Object[]> listT=null;
	  JTextArea ComentIngre;
	  private 	JFrame frame2 = new JFrame("Exito");
	//DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();

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
	

	
	public void actualizarEmpleado(){
		Controlador_listarEmpleados empleados = new Controlador_listarEmpleados();
		try {
			DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
			 listE = empleados.listarEmpleados();
			 for (int i=0; i<list.size();i++){						
					modelo2.addElement(listE.get(i).getNombre()+" "+listE.get(i).getApellido());
					//System.out.println(list.get(i)[0]);
			}
			encarSelec.setModel(modelo2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AutoCompletion.enable(encarSelec);
	}
	
	public DefaultComboBoxModel inici(String lista){
	DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();
		if(lista=="empleados"){
			Controlador_listarEmpleados empleados = new Controlador_listarEmpleados();
			//DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();
			try {
				 listE = empleados.listarEmpleados();
				 for (int i=0; i<listE.size();i++){		
					String a= listE.get(i).getNombre()+" "+listE.get(i).getApellido();
						modelo2.addElement(a);
						//System.out.println(list.get(i)[0]);
				}
				return modelo2;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelo2.addElement("No elementos encontrados");
				return modelo2;
			}	
		}
		if(lista=="clientes"){
			 Controlador_Obtener_Clientes_Referencia list_cont= new Controlador_Obtener_Clientes_Referencia();
			 DefaultComboBoxModel modelo = new DefaultComboBoxModel();
			 try {
				 list = list_cont.obtenerClientes(entradaNombre, entradareferencia);
				 for (int i=0; i<list.size();i++){						
						modelo.addElement(list.get(i)[0]);
						//System.out.println(list.get(i)[0]);
				}
				return modelo ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelo.addElement("Error");
				return modelo;
			}
		}
		//return modelo2= null;
		modelo2.addElement("Error");
		return modelo2;
	}
	
	public Administrar_tareas() {
		try{
			 mascara =new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			 mascara2 =new MaskFormatter("##:##");
				mascara2.setPlaceholderCharacter('_');
			
		}catch(Exception E){
			
		}
		setTitle("Nueva Tarea");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(14, 30, 46, 14);
		contentPane.add(lblCliente);
		AutoCompletion.enable(opcionCliente);
		 
		 //configuro para que sea editable
		opcionCliente.setEditable(true);
		
		opcionCliente.setBounds(70, 28, 167, 19);
		contentPane.add(opcionCliente);
		
		JLabel lblTrabajos = new JLabel("Trabajos :");
		lblTrabajos.setBounds(14, 58, 79, 14);
		contentPane.add(lblTrabajos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 74, 112, 310);
		contentPane.add(scrollPane);
		
		final JList list_1 = new JList();
		opcionCliente.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent arg0) {
				   
				// cargar lista de trabajos por el cliente elegido en jcombobox
					Controlador_Trabajo_TituloXreferencia  T =new Controlador_Trabajo_TituloXreferencia ();
					//int ref= (int) list.get(opcionCliente.getSelectedIndex())[1];
					long a= Long.parseLong((String) list.get(opcionCliente.getSelectedIndex())[1]);
					
					DefaultListModel modeloT = new DefaultListModel();
					try {
						listT = T.obtener_TrabajoId_Titulo(a);
						//System.out.println(a);
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
		
		
		
		JLabel lblNewLabel = new JLabel("Encargado :");
		lblNewLabel.setBounds(150, 90, 93, 14);
		contentPane.add(lblNewLabel);
		
		
		encarSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bandera=true;
				//System.out.println("dfxbgadghadfha");
}
		});
		AutoCompletion.enable(encarSelec);
		encarSelec.setEditable(true);
		encarSelec.setBounds(230, 85, 167, 19);
		contentPane.add(encarSelec);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setBounds(150, 120, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora :");
		lblHora.setBounds(150, 150, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblComentario = new JLabel("Comentario :");
		lblComentario.setBounds(150, 180, 77, 14);
		contentPane.add(lblComentario);
		fechaformat = new JFormattedTextField(mascara);
		
		//fechaformat = new JFormattedTextField();
		fechaformat.setColumns(2);
		fechaformat.setBounds(230, 115, 70, 20);
		contentPane.add(fechaformat);
		
		JLabel lblDdmmaaaa = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa.setForeground(Color.GRAY);
		lblDdmmaaaa.setBounds(330, 120, 88, 14);
		contentPane.add(lblDdmmaaaa);
		
		horaformat = new JFormattedTextField(mascara2);
		horaformat.setBounds(230, 145, 40, 20);
		contentPane.add(horaformat);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bandera && !list_1.isSelectionEmpty()){
					//System.out.println("si");
					/*try{
						Date ho = auxiliar.horaDate(horaIngre.getText());
						
						System.out.println(auxiliar.horaString(ho));
					}catch(Exception ee){
						System.out.println("mal");
					}*/
					//auxiliar.valid(fechaformat.getText());
					
					///System.out.println(auxiliar.valid(horaformat.getText()));
					//System.out.println(auxiliar.validH(horaformat.getText()));
					//System.out.println(auxiliar.esHora("36:30"));
					if(auxiliar.validF(fechaformat.getText()) && auxiliar.validH(horaformat.getText())){
						System.out.println("bien");
						Controlador_Nueva_Tarea tareaN = new Controlador_Nueva_Tarea();
						//tareaN.nuevo(trabajo, encargado, fecha, hora, comentario);
						System.out.println(listT.get(list_1.getSelectedIndex())[0]);
						System.out.println(listE.get(encarSelec.getSelectedIndex()).getCedula()+" "+listE.get(encarSelec.getSelectedIndex()).getNombre());
						System.out.println(auxiliar.fechaSQL(fechaformat.getText()));
						System.out.println(horaformat.getText());
						System.out.println(ComentIngre.getText());
						int t = Integer.parseInt((String) listT.get(list_1.getSelectedIndex())[0]) ;
						try {
							tareaN.nuevo(  t,  listE.get(encarSelec.getSelectedIndex()).getCedula(), auxiliar.fechaSQL(fechaformat.getText()), horaformat.getText(), ComentIngre.getText());
							JOptionPane.showMessageDialog(frame2,
							        "Se guardo nueva tarea. ");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
							mensaje.showMessageDialog(null, "Error al guardar.", "Atención!!!", mensaje.ERROR_MESSAGE);
						}
					
						
						fechaformat.setText("");
						horaformat.setText("");
						ComentIngre.setText("");
					}else{
						System.out.println("mal");
					}
				}else{
					System.out.println("no");
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Seleccione un trabajo y encargado.", "Atención!!!", mensaje.ERROR_MESSAGE); 
				
				}
				
				
			}
		});
		
		btnGuardar.setBounds(305, 351, 89, 23);
		contentPane.add(btnGuardar);
		
		JLabel lblHhmmss = new JLabel("hh : mm");
		lblHhmmss.setForeground(Color.GRAY);
		lblHhmmss.setBounds(330, 150, 88, 14);
		contentPane.add(lblHhmmss);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(142, 202, 262, 138);
		contentPane.add(scrollPane_3);
		
	 ComentIngre = new JTextArea();
		ComentIngre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*try{
					Date ho = auxiliar.horaDate(horaIngre.getText());
					horaIngre.setText(auxiliar.horaString(ho));
					//System.out.println(auxiliar.horaString(ho));
				}catch(Exception ee){
					horaIngre.setText("Hora incorrecta");
				}*/
				
			}
		});
		scrollPane_3.setViewportView(ComentIngre);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(132, 74, 281, 310);
		contentPane.add(scrollPane_2);
		
	}
}
