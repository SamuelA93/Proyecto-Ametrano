package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import Grafica.Controladores.Controlador_Cliente;
import Grafica.Controladores.Controlador_Empleado;
import Grafica.Controladores.Controlador_Tarea;
import Grafica.Controladores.Controlador_Trabajo;
import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Editar_Tarea extends JFrame {

	private JPanel panel;
	JComboBox SelectorCliente = new JComboBox();
	JComboBox SelectorTrabajo = new JComboBox();
	JComboBox selectorEncargado = new JComboBox();
	JEditorPane Comentario;
	Controlador_Trabajo control_trabajo = new Controlador_Trabajo();
  	Controlador_Cliente control_cliente = new Controlador_Cliente();
  	Controlador_Empleado control_empleado = new Controlador_Empleado();
  	Controlador_Tarea control_tarea = new Controlador_Tarea();
  	JFormattedTextField fecha;
  	JFormattedTextField hora;
  	MaskFormatter mascara;
  	pruebaFechas auxiliar =new pruebaFechas();
  	MaskFormatter  mascara2;
  	DefaultComboBoxModel<String> modeloClientes = new DefaultComboBoxModel<String>();
  	private List<Object[]> listClientes=null;
  	private List<Object[]> listTrabajos=null;
  	private List<VOEmpleado> listEmpleados=null;
  	private 	JFrame frame = new JFrame("Exito");
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar_Tarea frame = new Editar_Tarea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public DefaultComboBoxModel cargarClientes(){
			Controlador_Empleado control_empleado = new Controlador_Empleado();
			//DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();
			try {
				listClientes = control_cliente.obtenerClientes();
				 for (int i=0; i<listClientes.size();i++){		
					String a= (String) listClientes.get(i)[0];
					modeloClientes.addElement(a);
						//System.out.println(list.get(i)[0]);
				}
				
				return modeloClientes;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				modeloClientes.addElement("No elementos encontrados");
				return modeloClientes;
			}
	}
	
	public void SetSelectorClientes(long clienteReferencia){
		boolean bandera = false;
		int i = 0;
		while (!bandera && i < listClientes.size()){
			bandera= Long.parseLong((String) listClientes.get(i)[1])==(clienteReferencia);
			//System.out.println(listClientes.get(i)[1]);
			i++;
		}
		if (bandera){
			SelectorCliente.setSelectedIndex(i-1);
			//System.out.println("encontre");
		}
	}
	
	public void SetSelectorTrabajo(int id){
		boolean bandera = false;
		int i = 0;
		while (!bandera && i < listTrabajos.size()){
			bandera= Long.parseLong((String) listTrabajos.get(i)[0])==(id);
			//System.out.println((String) listTrabajos.get(i)[1]);
			i++;
		}
		if (bandera){
			SelectorTrabajo.setSelectedIndex(i-1);
			//System.out.println("encontre");
		}
	}
	
	public void SetSelectorEmpleados(long ci){
		boolean bandera = false;
		int i = 0;
		while (!bandera && i < listEmpleados.size()){
			bandera= listEmpleados.get(i).getCedula()==(ci);
			//System.out.println((String) listTrabajos.get(i)[1]);
			i++;
		}
		if (bandera){
			selectorEncargado.setSelectedIndex(i-1);
			//System.out.println("encontre");
		}
	}
	
	public DefaultComboBoxModel cargarTrabajo(long clienteReferencia){
		
		DefaultComboBoxModel<String> modeloTrabajos = new DefaultComboBoxModel<String>();
		
		try {
			listTrabajos = control_trabajo.obtener_TrabajoId_Titulo(clienteReferencia);
			 for (int i=0; i<listTrabajos.size();i++){		
				String a= (String) listTrabajos.get(i)[0];
				modeloTrabajos.addElement(a);
					//System.out.println(list.get(i)[0]);
			}
			
			return modeloTrabajos;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			modeloClientes.addElement("No elementos encontrados");
			return modeloTrabajos;
		}
	}
	
	public DefaultComboBoxModel cargarEmpleados(){

		DefaultComboBoxModel<String> modeloEmpleados = new DefaultComboBoxModel<String>();

		try {
			listEmpleados = control_empleado.listarEmpleados();
			for (int i=0; i<listEmpleados.size();i++){		
				String a= (String) listEmpleados.get(i).getNombre()+" "+(String) listEmpleados.get(i).getApellido();
				modeloEmpleados.addElement(a);
				//System.out.println(list.get(i)[0]);
			}

			return modeloEmpleados;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			modeloEmpleados.addElement("No elementos encontrados");
			return modeloEmpleados;
		}
	}
	/**
	 * Create the frame.
	 */
	public Editar_Tarea( long clienteReferencia,int trabajoID,long ci, final VOTarea tarea ) {
		
		try{
			 mascara =new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			 mascara2 =new MaskFormatter("##:##");
				mascara2.setPlaceholderCharacter('_');
			
		}catch(Exception E){
			
		}
		
		setTitle("Editar Tarea");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 366, 361);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 0, 60, 22);
		panel.add(lblCliente);
		
		JLabel lblTrabajos = new JLabel("Trabajo");
		lblTrabajos.setBounds(194, 0, 67, 22);
		panel.add(lblTrabajos);
		
		SelectorCliente.setModel(cargarClientes());
		SetSelectorClientes(clienteReferencia);
		SelectorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(Long.parseLong((String) listClientes.get(SelectorCliente.getSelectedIndex())[1]));
				
				SelectorTrabajo.setModel(cargarTrabajo(Long.parseLong((String) listClientes.get(SelectorCliente.getSelectedIndex())[1])));
			}
		});
		SelectorCliente.setBounds(10, 28, 164, 19);
		panel.add(SelectorCliente);
		
		SelectorTrabajo.setModel(cargarTrabajo(clienteReferencia));
		SetSelectorTrabajo(trabajoID);
		SelectorTrabajo.setBounds(194, 28, 144, 19);
		panel.add(SelectorTrabajo);
		
		JLabel lblEncargado = new JLabel("Encargado");
		lblEncargado.setBounds(10, 59, 85, 14);
		panel.add(lblEncargado);
		
		selectorEncargado.setModel(cargarEmpleados());
		SetSelectorEmpleados(ci);
		selectorEncargado.setBounds(10, 88, 164, 19);
		panel.add(selectorEncargado);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(194, 59, 67, 14);
		panel.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(292, 59, 60, 14);
		panel.add(lblHora);
		
		fecha = new JFormattedTextField(mascara);
		fecha.setText(tarea.getFecha());
		fecha.setBounds(194, 88, 68, 20);
		panel.add(fecha);
		
		 hora = new JFormattedTextField(mascara2);
		 hora.setText(tarea.getHora());
		hora.setBounds(292, 88, 38, 20);
		panel.add(hora);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(10, 120, 85, 14);
		panel.add(lblComentario);
		
		 Comentario = new JEditorPane();
		Comentario.setText(tarea.getComentario());
		Comentario.setBounds(0, 137, 352, 147);
		panel.add(Comentario);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList cambiar = new ArrayList();
				boolean error = false ;
				if ( auxiliar.validF(fecha.getText()) && auxiliar.validH(hora.getText()) ) {
					
				} else {
					error = true;
				}
				
				if (!error) {
					if (tarea.getTrabajo() != Integer.parseInt((String) listTrabajos.get(SelectorTrabajo.getSelectedIndex())[0])) {
						//System.out.println("no son iguales");
						cambiar.add("`Trabajos_idTrabajos`="+listTrabajos.get(SelectorTrabajo.getSelectedIndex())[0]);
						
					}
					if (tarea.getEmpleado_cedula() !=  listEmpleados.get(selectorEncargado.getSelectedIndex()).getCedula()) {
						System.out.println("no son iguales");
						cambiar.add("`Empleados_cedula`="+listEmpleados.get(selectorEncargado.getSelectedIndex()).getCedula());
						
					}
					System.out.println(auxiliar.fechaSQL(tarea.getFecha()));
					if (!tarea.getFecha().equals(fecha.getText())) {
						cambiar.add("`fecha`='"+auxiliar.fechaSQL(fecha.getText())+"'");
						
					}
					String h= tarea.getHora().substring(0, 5);
					//System.out.println(h+" "+hora.getText());
					if (!hora.getText().equals(h)) {
						cambiar.add("`hora`='"+hora.getText()+"' ");
						
					}
					if (!tarea.getComentario().toUpperCase().equals(Comentario.getText().toUpperCase())) {
						cambiar.add("`comentario`='"+Comentario.getText()+"'");
					
					}
					String update="";
					if (!cambiar.isEmpty()) {
						update = (String) cambiar.get(0);
					}
					int i = 1;
					while( i< cambiar.size()){
						update = update +","+cambiar.get(i);
						//System.out.println(agregar);
						i++;
					}
					System.out.println(update);
					if (!update.equals("")) {
						try {
							control_tarea.ActualizarTarea(update, tarea);
							JOptionPane.showMessageDialog(frame, "Se ah guardado con exito");
							dispose();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
							mensaje.showMessageDialog(null, "Error al guardar.", "Atención!!!", mensaje.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(frame, "No se realizo cambios");
					}
					
				} else {

				}
			}
		});
		btnGuardarCambios.setBounds(179, 295, 159, 23);
		panel.add(btnGuardarCambios);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 352, 21);
		panel.add(menuBar_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 56, 352, 21);
		panel.add(menuBar_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 117, 352, 21);
		panel.add(menuBar);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 284, 352, 40);
		panel.add(menuBar_3);
	}
}
