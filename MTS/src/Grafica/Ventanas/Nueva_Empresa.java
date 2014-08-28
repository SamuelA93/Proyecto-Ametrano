package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Grafica.Controladores.Controlador_Empresa;
import Grafica.Ventanas.Nueva_Empresa;
//import Grafica.Controladores.Controlador_Nuevo_Socio;
import Grafica.Controladores.Controlador_Socio;
//import Grafica.Controladores.Controlador_Tabla_Empresas;
import Grafica.Controladores.Verificar_Rut;
import Grafica.Controladores.Verificar_Tel;
import Logica_Persistencia.Value_Object.VOEmpresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JCheckBox;

public class Nueva_Empresa extends JFrame {

	private JPanel contentPane;
	private JTextField rut;
	private JTextField nombre;
	private JTextField contacto;
	private JTextField direccion;
	private JTextField tel;
	private JTextField cel;
	final Controlador_Empresa controladorTabla = new Controlador_Empresa();	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Nueva_Empresa frame = new Nueva_Empresa();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Nueva_Empresa(/*final Ver_Empresas ver*/) {
		setTitle("Nueva Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 341, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Rut:");
		label1.setBounds(18, 73, 46, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Nombre:");
		label2.setBounds(18, 15, 70, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Contacto:");
		label3.setBounds(18, 44, 70, 14);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Direccion:");
		label4.setBounds(18, 160, 70, 14);
		contentPane.add(label4);
		
		rut = new JTextField();
		rut.setBounds(114, 73, 177, 20);
		contentPane.add(rut);
		rut.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(114, 15, 177, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		contacto = new JTextField();
		contacto.setBounds(114, 44, 177, 20);
		contentPane.add(contacto);
		contacto.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(114, 160, 177, 20);
		contentPane.add(direccion);
		direccion.setColumns(10);
		final JCheckBox checkboxSocio = new JCheckBox("SOCIO");
		checkboxSocio.setBounds(114, 185, 97, 23);
		contentPane.add(checkboxSocio);
		
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String rutE = 		rut.getText();
				String nombreE = 	nombre.getText();
				String contactoE = 	contacto.getText();
				String direccionE = direccion.getText();
				String telefonoE = 	tel.getText(); 
				String celularE = 	cel.getText();
				boolean esSocio =   checkboxSocio.isSelected();

				/*Controlador_Nueva_Empresa controlador = new Controlador_Nueva_Empresa();
				//Verificar_Rut verificador = new Verificar_Rut();
				//int rut = Integer.parseInt(rutText);
				
				
				if( controlador.verificador.verificarRut(rutText) ){
					controlador.nuevaEmpresa(rutText,nombre,contacto,direccion,telefono,celular);
					Text_Rut.setBorder(BorderFactory.createLineBorder(Color.green));
				}else{
						Text_Rut.setBorder(BorderFactory.createLineBorder(Color.red));
					}*/
				
				//////////////////////////////////////////////////////////////  12/8/2014 Rafaela
				Object[] tels = new Object[2];
				String espa ="";
				boolean bandera = false;
				boolean bandera2 = false;
				
				if(!nombreE.equals(espa) ){
					if(	Verificar_Rut.verificarRut(rutE) ){
						/*controlador.nuevoParticular(nombreP,apellidoP,dirP,telP,Verificar_Ci.numeroCi(ciP),celuP);*/
						rut.setBorder(BorderFactory.createLineBorder(Color.green));
						
						if(!telefonoE.equals(espa) ){
					  
							//Controlador_Nuevo_Particular controlador = new Controlador_Nuevo_Particular();
							if(Verificar_Tel.isNumeric(telefonoE)){
								tels[0]=telefonoE;
								//System.out.println(tels[0]);
								tel.setBorder(BorderFactory.createLineBorder(Color.green));
								bandera = true;
							}else{
								tel.setBorder(BorderFactory.createLineBorder(Color.red));
								javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
								mensaje.showMessageDialog(null, "Telefono incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
							}
									
						}else{
							tels[0]="";
							bandera = true;
							tel.setBorder(BorderFactory.createLineBorder(Color.green));
						}
						
						if(!celularE.equals(espa) ){
							  
							//Controlador_Nuevo_Particular controlador = new Controlador_Nuevo_Particular();
							if(Verificar_Tel.isNumeric(celularE)){
								tels[1]=celularE;
								//System.out.println(tels[1]);
								bandera2 = true;
								cel.setBorder(BorderFactory.createLineBorder(Color.green));
							}else{
								cel.setBorder(BorderFactory.createLineBorder(Color.red));
								javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
								mensaje.showMessageDialog(null, "Celular incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
							}
									
						}else{
							tels[1]="";
							bandera2 = true;
							cel.setBorder(BorderFactory.createLineBorder(Color.green));
						}
						
						if(bandera && bandera2){
							Controlador_Empresa controlador = new Controlador_Empresa();
							try {
								controlador.nuevaEmpresa(rutE, nombreE, contactoE, direccionE, (String) tels[0],(String) tels[1]);
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							if (esSocio)//aqui nuevo socio-------!!!!!!!!!!!!!!!!!!!!!!
							{
								Controlador_Socio controladorNuevo = new Controlador_Socio();
								try {
									controladorNuevo.Nuevo_Socio(Long.parseLong(rut.getText()));
								} catch (NumberFormatException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}
							
							Ver_Empresas v;
							try {
								v = new Ver_Empresas();
								v.setVisible(true);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						/*	
							ver.modelo.removeAllElements();
							ver.list.setModel(ver.modelo);

							*/
							/*VOEmpresa empresaNueva = new VOEmpresa();
							 
							
							if (ver.lstEmpresas.size() > 0){	
								Iterator<VOEmpresa> iterT = ver.lstEmpresas.iterator();
								while (iterT.hasNext()){
									VOEmpresa Empresa = iterT.next();
									Object[] fila = new Object[1];
									fila[0] = Empresa.getNombre();
									//list.add(Empresa)
									//System.out.println(Empresa.getNombre());
									ver.modelo.addElement(fila[0]);
								}		
							}
							
							ver.list.setModel(ver.modelo);*/
							
							
						/*	try {
								ver.lstEmpresas = controladorTabla.listarEmpresas();
								if (ver.lstEmpresas.size() > 0){	
									Iterator<VOEmpresa> iterT = ver.lstEmpresas.iterator();
									while (iterT.hasNext()){
										VOEmpresa Empresa = iterT.next();
										Object[] fila = new Object[1];
										fila[0] = Empresa.getNombre();
										//list.add(Empresa)
										//System.out.println(Empresa.getNombre());
										ver.modelo.addElement(fila[0]);
									}		
								}
								
								ver.list.setModel(ver.modelo);
								
								
								
								
								
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							dispose();
							ver.setVisible(true);
*/
						}
						
					}else{
							rut.setBorder(BorderFactory.createLineBorder(Color.red));		
						}
				}else{
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Ingrese el nombre.", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
				
				////////////////////////////////////////////////////////////////////
				}
		});
		btnNewButton.setBounds(192, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label5 = new JLabel("Tel.:");
		label5.setBounds(18, 102, 96, 14);
		contentPane.add(label5);
		
		tel = new JTextField();
		tel.setBounds(114, 102, 177, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JLabel lblCelular = new JLabel("Cel.:");
		lblCelular.setBounds(18, 131, 96, 14);
		contentPane.add(lblCelular);
		
		cel = new JTextField();
		cel.setBounds(114, 131, 177, 20);
		contentPane.add(cel);
		cel.setColumns(10);
		
	}
}
