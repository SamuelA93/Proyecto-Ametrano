package Grafica.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Grafica.Controladores.Controlador_Cliente;
import Grafica.Controladores.Controlador_Empleado;



import Grafica.Controladores.Controlador_Tarea;
import Grafica.Controladores.Controlador_Trabajo;
import Grafica.Controladores.Controlador_Verificar;
import Grafica.Controladores.Verificar_Ci;
import Grafica.Controladores.Verificar_Rut;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Fachada.Fecha;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOParticularEmpresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;

public class Nuevo_Trabajo extends JFrame {

	private JPanel     contentPane;
	private JTextField fechaInicio;
	private JTextField montoTotal;
	private JTextField cuotas;
	private MaskFormatter mascara;
	private JComboBox comboBoxCliente = new JComboBox();
	private JComboBox comboBoxEncargado = new JComboBox();
	private Controlador_Trabajo control = new Controlador_Trabajo();
	Controlador_Tarea control_tarea = new Controlador_Tarea();
	private Controlador_Empleado empleado = new Controlador_Empleado();
	private Controlador_Cliente clientes = new Controlador_Cliente();
	List<VOCliente> lstClientes;
	List<VOEmpleado> lstEncargados;
	private 	JFrame frame = new JFrame("Exito");
	boolean banderaCliente = false;
	boolean banderaEmpleado = false;
	pruebaFechas auxiliar = new pruebaFechas();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo_Trabajo frame = new Nuevo_Trabajo();
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
	/////////////////////   Metodo es bisiesto retorna true si lo es
	public static boolean isLeapYear(int Yearb){
	if((Yearb %4==0 && Yearb%100!=0) || Yearb %400==0){
			return true;
		}else{
			return false;
		}
	}
		
	//////////////////////   Metodo devuelve cantidad de dias del mes dependiendo del mes/a�o
	public static int countDaysMonth(int Day, int Year){
		int daysMonth;
		
		switch(Day){
		case 1: daysMonth = 31;
		break;
		case 2: if(isLeapYear(Year)){daysMonth = 29;}else{daysMonth = 28;}// si es bisiesto 29d sino 28d
		break;
		case 3: daysMonth = 31;
		break;
		case 4: daysMonth = 30;
		break;
		case 5: daysMonth = 31;
		break;
		case 6: daysMonth = 30;
		break;
		case 7: daysMonth = 31;
		break;
		case 8: daysMonth = 31;
		break;
		case 9: daysMonth = 30;
		break;
		case 10:daysMonth = 31;
		break;
		case 11:daysMonth = 30;
		break;
		case 12:daysMonth = 31;
		break;
		default:daysMonth = 31;
		break;
		}
			
			return daysMonth;
		}
	
	////////////////  
	public void Cargar_Lista_Clientes(){
		
		Iterator<VOCliente> iterClientes;
		try {
			lstClientes = clientes.ListarClientes();
			iterClientes = clientes.ListarClientes().iterator();
			while(iterClientes.hasNext()){
				VOCliente datoCliente = iterClientes.next();
				comboBoxCliente.addItem(datoCliente.getNombre());
				//System.out.println(datoCliente.getReferencia());
			}
			comboBoxCliente.setSelectedIndex(-1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String error = "No se puedo cargar lista";
			comboBoxCliente.addItem(error);
		}
	}
	
	/////////////////
	
	public void Cargar_Lista_Empleados(){
		
		Iterator<VOEmpleado> iterClientes;
		try {
			lstEncargados = empleado.listarEmpleados();
			iterClientes = empleado.listarEmpleados().iterator();
			while(iterClientes.hasNext()){
				VOEmpleado datoCliente = iterClientes.next();
				comboBoxEncargado.addItem(datoCliente.getNombre());
			}
			comboBoxEncargado.setSelectedIndex(-1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String error = "No se puedo cargar lista";
			comboBoxEncargado.addItem(error);
		}
	}
	
	public Nuevo_Trabajo() {
		
		try{
			
			 mascara =new MaskFormatter("##:##");
				mascara.setPlaceholderCharacter('_');
			
		}catch(Exception E){
			
		}
		setTitle("Nuevo Trabajo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Inicio Etiquetas
		//Etiqueta Clientes
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(10, 22, 94, 21);
		contentPane.add(lblCliente);
		
		//Etiqueta Fecha
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(10, 102, 84, 22);
		contentPane.add(lblFecha);
		
		//Etiqueta Monto Total
		JLabel lblMontoTotal = new JLabel("Monto total");
		lblMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoTotal.setBounds(10, 167, 84, 22);
		contentPane.add(lblMontoTotal);
		
		//Etirqueta Cuotas
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuotas.setBounds(10, 200, 46, 14);
		contentPane.add(lblCuotas);
		
		//Etiqueta Encargado
		JLabel lblEmpleado = new JLabel("Encargado");
		lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmpleado.setBounds(10, 54, 94, 22);
		contentPane.add(lblEmpleado);
		
		//Etiqueta Horario
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorario.setBounds(10, 137, 94, 14);
		contentPane.add(lblHorario);
		
		//Etiqueta Formato horario
		JLabel lblHhmm = new JLabel("hh:mm");
		lblHhmm.setForeground(Color.DARK_GRAY);
		lblHhmm.setBounds(169, 137, 46, 14);
		contentPane.add(lblHhmm);
		
		//Etiqueta Comentario
		JLabel lblNewLabel = new JLabel("Comentario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 235, 94, 14);
		contentPane.add(lblNewLabel);
		//Fin Etiquetas
		
		//Inicio components
		
		//Componente Clientes 
		
		comboBoxCliente.setBounds(100, 22, 260, 20);
		contentPane.add(comboBoxCliente);
		Cargar_Lista_Clientes();
		
		//Creo Lista para obtener id
		final List myList = new ArrayList();
		
		comboBoxCliente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				banderaCliente = true;
			}
		});
		//////////////////////
		//Componente Dia
		JLabel lblDia = new JLabel("Dia");
		lblDia.setForeground(Color.DARK_GRAY);
		lblDia.setBounds(100, 85, 46, 14);
		contentPane.add(lblDia);
		
		//Componente Mes
		JLabel lblMes = new JLabel("Mes");
		lblMes.setForeground(Color.DARK_GRAY);
		lblMes.setBounds(189, 85, 46, 14);
		contentPane.add(lblMes);
		
		//Componente A�o
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setForeground(Color.DARK_GRAY);
		lblAo.setBounds(278, 85, 46, 14);
		contentPane.add(lblAo);
		
		//Instancio fecha
		Fecha fecha = new Fecha();

		//Agrego items al Componente A�o
		final JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setBounds(278, 101, 82, 20);
		contentPane.add(comboBoxYear);
		for(int i= fecha.getYear();i>=2000;i--){
		comboBoxYear.addItem(i);
		}
		comboBoxYear.setSelectedIndex(0);
		
		//Agrego items al Componente Mes
		final JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(189, 101, 79, 20);
		contentPane.add(comboBoxMes);
		comboBoxMes.addItem(fecha.getMonth()+1);
		for(int i=1;i<=12;i++){
			comboBoxMes.addItem(i);
		}
		
		//Agrego items al Componente Dia
		final JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(100, 101, 79, 20);
		contentPane.add(comboBoxDia);
		int cantDias=31;
		for(int i =1;i<cantDias;i++){
			comboBoxDia.addItem(i);
		}
		comboBoxDia.setSelectedIndex(fecha.getDay()-1);
		//listener Year
		comboBoxYear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//items Selected
				int day     =(int)comboBoxDia.getItemAt(comboBoxDia.getSelectedIndex());
				int month   =(int)comboBoxMes.getItemAt(comboBoxMes.getSelectedIndex());
				int Year    =(int)comboBoxYear.getItemAt(comboBoxYear.getSelectedIndex());
				int daysMonth = countDaysMonth(month,Year);
				
				comboBoxDia.removeAllItems();
				for(int i=1;i<=daysMonth;i++){
					comboBoxDia.addItem(i);
				}//end for
				//si el dia se selecciono antes y esta dentro del rango de la cantidad de dias queda seleccionado
				if(day<=daysMonth){
					comboBoxDia.setSelectedItem(day);
				}
			}
		});
		//listener Month
		comboBoxMes.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//items Selected
					int day   =(int)comboBoxDia.getItemAt(comboBoxDia.getSelectedIndex()); 
					int month =(int)comboBoxMes.getItemAt(comboBoxMes.getSelectedIndex());
					int Year  =(int)comboBoxYear.getItemAt(comboBoxYear.getSelectedIndex());
					int daysMonth;
						
					daysMonth = countDaysMonth(month,Year);
					comboBoxDia.removeAllItems();
					for(int i=1;i<=daysMonth;i++){
						comboBoxDia.addItem(i);
					}//end for
					//si el dia se selecciono antes y esta dentro del rango de la cantidad de dias queda seleccionado
					if(day<=daysMonth){
						comboBoxDia.setSelectedItem(day);
					}
				}
		});
		//fin Selector Fecha
		
		//Componente Monto total
		montoTotal = new JTextField();
		montoTotal.setBounds(100, 165, 59, 20);
		contentPane.add(montoTotal);
		montoTotal.setColumns(10);
				
		//Componente Cuotas
		cuotas = new JTextField();
		cuotas.setBounds(100, 197, 59, 20);
		contentPane.add(cuotas);
		cuotas.setColumns(10);
		
		//Componente Encargado
		
		comboBoxEncargado.setBounds(100, 54, 168, 20);
		contentPane.add(comboBoxEncargado);
		Cargar_Lista_Empleados();

		comboBoxEncargado.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				banderaEmpleado= true;
				
			}
		});

		final JFormattedTextField horaT = new JFormattedTextField(mascara);
		horaT.setBounds(100, 134, 38, 20);
		contentPane.add(horaT);
		
		//Componente Comentario
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(0, 254, 367, 124);
		contentPane.add(textArea);
		
		//Componente Boton "Agregar Trabajo"
		JButton btnRegistrar = new JButton("Agregar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//capturo los datos de los componentes
			boolean err = false;
			String cliente = "";
			String empleado = "";
			String monto = "";
			String cuotasP = "";
			String hora="";
			String fecha 		= ""+(int)comboBoxDia.getItemAt(comboBoxDia.getSelectedIndex())+"/"+(int)comboBoxMes.getItemAt(comboBoxMes.getSelectedIndex())+"/"+(int)comboBoxYear.getItemAt(comboBoxYear.getSelectedIndex());
			long referencia = 0;
			int referenciaE = 0;	
			if(banderaCliente && banderaEmpleado) {
				 cliente = lstClientes.get(comboBoxCliente.getSelectedIndex()).getNombre();
				 empleado = lstEncargados.get(comboBoxEncargado.getSelectedIndex()).getNombre();
				 referencia = lstClientes.get(comboBoxCliente.getSelectedIndex()).getReferencia();
				 referenciaE = lstEncargados.get(comboBoxEncargado.getSelectedIndex()).getCedula();
				
				if (auxiliar.validH(horaT.getText())) {
					 hora = horaT.getText();
					Controlador_Verificar a = new Controlador_Verificar();
					if (!a.verificarExistencia(montoTotal.getText().trim()) || a.SoloNumeros_O_Espacios(montoTotal.getText().trim())) {
						if(montoTotal.getText().trim().equals("")){
							monto = ""+0;
						}else{
							monto = montoTotal.getText();
						}
						if (!a.verificarExistencia(cuotas.getText().trim()) || a.SoloNumeros_O_Espacios(cuotas.getText().trim())) {
							 
							if(cuotas.getText().trim().equals("")){
								cuotasP =""+0;
							}else{
								cuotasP = cuotas.getText();
							}
						} else {
							err = true;
							javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
							mensaje.showMessageDialog(null, "el campo Cuotas debe contener numeros o permanecer vacio.", "Atenci�n!!!", mensaje.ERROR_MESSAGE);
						}
						
					} else {
						err = true;
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "El Monto total debe contener numeros o permanecer vacio.", "Atenci�n!!!", mensaje.ERROR_MESSAGE);
					}
				} else {
					err = true;
					
				}
				
			} else {
				err = true;
				javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
				mensaje.showMessageDialog(null, "Seleccione un Encargado y Cliente.", "Atenci�n!!!", mensaje.ERROR_MESSAGE);
			}
			if (!err) {
				System.out.println("ok");
				try {
					//System.out.println(referencia);
					control.nuevoTrabajo(referencia, hora, monto, cuotasP, textArea.getText());
					try {
						int id = control.obtener_idTrabajo_X_ref(referencia);
						if (auxiliar.reciente(auxiliar.dateJAVA(fecha), auxiliar.dateJAVA(auxiliar.fechaActualDate()))<0) {
							//System.out.println("vieja");
							control_tarea.nuevo(id, referenciaE, auxiliar.fechaSQL(fecha), hora, textArea.getText(),"Atrazado");
						} else {
							System.out.println("nueva");
							control_tarea.nuevo(id, referenciaE, auxiliar.fechaSQL(fecha), hora, textArea.getText(),"Pendiente");
						}
						 JOptionPane.showMessageDialog(frame, "Se ha guardado nuevo trabajo. ");
						//control_tarea.nuevo(id, referenciaE, auxiliar.fechaSQL(fecha), hora, textArea.getText());
						dispose();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} 

 			}
		});
		btnRegistrar.setBounds(278, 385, 89, 23);
		contentPane.add(btnRegistrar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 232, 367, 21);
		contentPane.add(menuBar);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 378, 367, 50);
		contentPane.add(menuBar_1);
		
	}
	private List ArrayList() {
		// TODO Auto-generated method stub
		return null;
	}
}

