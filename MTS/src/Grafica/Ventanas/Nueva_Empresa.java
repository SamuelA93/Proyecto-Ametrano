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


import Grafica.Controladores.Controlador_Verificar;
import Grafica.Controladores.Verificar_Ci;
import Grafica.Controladores.Verificar_Rut;
import Grafica.Controladores.Verificar_Tel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Nueva_Empresa extends JFrame {

	private JPanel contentPane;
	private JTextField Text_Rut;
	private JTextField Text_Nombre;
	private JTextField Text_Contacto;
	private JTextField Text_Direccion;
	private JTextField Text_Telefono;
	private JTextField Text_Celular;
	private boolean error = true;
	private Controlador_Empresa control = new Controlador_Empresa();
	//
	Controlador_Verificar verificar = new Controlador_Verificar(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nueva_Empresa frame = new Nueva_Empresa();
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
	public Nueva_Empresa() {
		setTitle("Nueva Empresa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Rut");
		label1.setBounds(29, 66, 46, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Nombre");
		label2.setBounds(29, 34, 70, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Contacto");
		label3.setBounds(29, 97, 70, 14);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Direccion");
		label4.setBounds(29, 126, 70, 14);
		contentPane.add(label4);
		
		JLabel label5 = new JLabel("Telefono fijo");
		label5.setBounds(29, 155, 96, 14);
		contentPane.add(label5);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(29, 184, 96, 14);
		contentPane.add(lblCelular);
		
		Text_Rut = new JTextField();
		Text_Rut.setBounds(116, 66, 173, 20);
		contentPane.add(Text_Rut);
		Text_Rut.setColumns(10);
		
		Text_Nombre = new JTextField();
		Text_Nombre.setBounds(116, 34, 173, 20);
		contentPane.add(Text_Nombre);
		Text_Nombre.setColumns(10);
		
		Text_Contacto = new JTextField();
		Text_Contacto.setBounds(116, 97, 173, 20);
		contentPane.add(Text_Contacto);
		Text_Contacto.setColumns(10);
		
		Text_Direccion = new JTextField();
		Text_Direccion.setBounds(116, 126, 173, 20);
		contentPane.add(Text_Direccion);
		Text_Direccion.setColumns(10);
		
		Text_Telefono = new JTextField();
		Text_Telefono.setBounds(116, 155, 173, 20);
		contentPane.add(Text_Telefono);
		Text_Telefono.setColumns(10);
		
		Text_Celular = new JTextField();
		Text_Celular.setBounds(116, 184, 173, 20);
		contentPane.add(Text_Celular);
		Text_Celular.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String rutText   = Text_Rut.getText();
				String nombre    = Text_Nombre.getText();
				String contacto  = Text_Contacto.getText();
				String direccion = Text_Direccion.getText();
				String telefono  = Text_Telefono.getText(); 
				String celular   = Text_Celular.getText();

				//Controlador_Nueva_Empresa controlador = new Controlador_Nueva_Empresa();
				//Verificar_Rut verificador = new Verificar_Rut();
				//int rut = Integer.parseInt(rutText);
				javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
				
				
				//Control de los campos
				if( control.verificador.verificarRut(rutText) ){
					Text_Rut.setBorder(BorderFactory.createLineBorder(Color.green));
					
					if(verificar.verificarExistencia(nombre.trim())){
						
							if(nombre.trim().length()<=45){
								
									if(nombre.trim().length()>2){
										
										Text_Nombre.setBorder(BorderFactory.createLineBorder(Color.green));
										if(verificar.verificarExistencia(contacto.trim())){
											
											if(verificar.SoloString_O_Espacios(contacto.trim())){
												
												if(contacto.trim().length()>2){
													
													if(contacto.trim().length()<45){
														
														Text_Contacto.setBorder(BorderFactory.createLineBorder(Color.green));
														if(verificar.verificarExistencia(direccion.trim())){
															
															if(direccion.trim().length()>6){
																
																if(direccion.trim().length()<45){
																	
																	Text_Direccion.setBorder(BorderFactory.createLineBorder(Color.green));
																	//verifico si existe telefono y celular
																	if(verificar.verificarExistencia(telefono.trim()) && verificar.verificarExistencia(celular.trim())){
																		
																		if(verificar.SoloNumeros_O_Espacios(telefono.trim())){
																			
																			if(telefono.trim().length()>=8){
																				
																				Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.green));
																				if(verificar.SoloNumeros_O_Espacios(celular.trim())){
																					
																					Text_Celular.setBorder(BorderFactory.createLineBorder(Color.green));
																					error=false;
																				}else{
																					mensaje.showMessageDialog(null, "El Celular solo debe contener numeros.", "Atención!!!", mensaje.ERROR_MESSAGE);
																					Text_Celular.setBorder(BorderFactory.createLineBorder(Color.red));
																					error=true;
																				}
																			}else{
																				mensaje.showMessageDialog(null, "El telefono es muy chico.", "Atención!!!", mensaje.ERROR_MESSAGE);
																				Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.red));
																				error=true;
																			}
																		}else{
																			mensaje.showMessageDialog(null, "El telefono solo debe contener numeros.", "Atención!!!", mensaje.ERROR_MESSAGE);
																			Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.red));
																			error=true;
																		}
																	}else{
																		//hay telefono o celular, o ninguno de los dos
																		if(verificar.verificarExistencia(telefono.trim())){
																			if(verificar.SoloNumeros_O_Espacios(telefono.trim())){
																				if(telefono.trim().length()>=8){
																					//Envia telefono pero no celular
																					Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.green));
																					celular="";
																					error =false;
																				}else{
																					mensaje.showMessageDialog(null, "El numero de telefono es muy chico.", "Atención!!!", mensaje.ERROR_MESSAGE);
																					Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.red));
																					error=true;
																				}
																			}else{
																				mensaje.showMessageDialog(null, "El telefono solo debe contener numeros.", "Atención!!!", mensaje.ERROR_MESSAGE);
																				Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.red));
																				error=true;
																			}
																		}else{
																			if(verificar.verificarExistencia(celular.trim())){
																				if(verificar.SoloNumeros_O_Espacios(celular.trim())){
																					if(celular.trim().length()>=8){
																						//Envio Celular pero no telefono
																						Text_Celular.setBorder(BorderFactory.createLineBorder(Color.green));
																						telefono="";
																						error =false;
																					}else{
																						mensaje.showMessageDialog(null, "El numero de celular es muy chico.", "Atención!!!", mensaje.ERROR_MESSAGE);
																						Text_Celular.setBorder(BorderFactory.createLineBorder(Color.red));
																						error=true;
																					}
																				}else{
																					mensaje.showMessageDialog(null, "El celular solo debe contener numeros.", "Atención!!!", mensaje.ERROR_MESSAGE);
																					Text_Celular.setBorder(BorderFactory.createLineBorder(Color.red));
																					error=true;
																				}
																			}else{
																				//no hay telefono ni celular
																				mensaje.showMessageDialog(null, "Debe ingresar un telefono o celular.", "Atención!!!", mensaje.ERROR_MESSAGE);
																				Text_Telefono.setBorder(BorderFactory.createLineBorder(Color.red));
																				Text_Celular.setBorder(BorderFactory.createLineBorder(Color.red));
																				error=true;
																			}
																		}
																	}
																}else{
																	mensaje.showMessageDialog(null, "La Direccion es muy larga.", "Atención!!!", mensaje.ERROR_MESSAGE);
																	Text_Direccion.setBorder(BorderFactory.createLineBorder(Color.red));
																	error=true;
																}
															}else{
																mensaje.showMessageDialog(null, "La Direccion es muy corta.", "Atención!!!", mensaje.ERROR_MESSAGE);
																Text_Direccion.setBorder(BorderFactory.createLineBorder(Color.red));
																error=true;
															}
														}else{
															mensaje.showMessageDialog(null, "Ingresar Direccion.", "Atención!!!", mensaje.ERROR_MESSAGE);
															Text_Direccion.setBorder(BorderFactory.createLineBorder(Color.red));
															error=true;
														}
													}else{
														mensaje.showMessageDialog(null, "El nombre de Contracto es muy largo.", "Atención!!!", mensaje.ERROR_MESSAGE);
														Text_Contacto.setBorder(BorderFactory.createLineBorder(Color.red));
														error=true;
													}
												}else{
													mensaje.showMessageDialog(null, "El nombre de Contracto es muy corto.", "Atención!!!", mensaje.ERROR_MESSAGE);
													Text_Contacto.setBorder(BorderFactory.createLineBorder(Color.red));
													error=true;
												}
											}else{
												mensaje.showMessageDialog(null, "El contacto solo puede contener letras.", "Atención!!!", mensaje.ERROR_MESSAGE);
												Text_Contacto.setBorder(BorderFactory.createLineBorder(Color.red));
												error=true;
											}
										}else{
											mensaje.showMessageDialog(null, "Ingresar nombre de Contacto.", "Atención!!!", mensaje.ERROR_MESSAGE);
											Text_Contacto.setBorder(BorderFactory.createLineBorder(Color.red));
											error=true;
										}
									}else{
										mensaje.showMessageDialog(null, "El nombre es muy corto.", "Atención!!!", mensaje.ERROR_MESSAGE);
										Text_Nombre.setBorder(BorderFactory.createLineBorder(Color.red));
										error= true;
									}
							}else{
								Text_Nombre.setBorder(BorderFactory.createLineBorder(Color.red));
								mensaje.showMessageDialog(null, "El nombre es muy largo.", "Atención!!!", mensaje.ERROR_MESSAGE);
								error= true;
							}
					}else{
						Text_Nombre.setBorder(BorderFactory.createLineBorder(Color.red));
						mensaje.showMessageDialog(null, "Ingresar nombre de la Empresa.", "Atención!!!", mensaje.ERROR_MESSAGE);
						error= true;
					}
				}else{
						Text_Rut.setBorder(BorderFactory.createLineBorder(Color.red));
						mensaje.showMessageDialog(null, "El rut no es correcto.", "Atención!!!", mensaje.ERROR_MESSAGE);
						error= true;
					}
				///////////////////
				/*
				System.out.println("Control de datos");
				System.out.println("rut       :"+rutText+"length : "+ rutText.length());
				System.out.println("Nombre    :"+nombre + "length : "+ nombre.length());
				System.out.println("Contacto  :"+contacto+ "length : "+ contacto.length());
				System.out.println("Direccion :"+direccion+ "length : "+ direccion.length());
				System.out.println("Telefono  :"+telefono+ "length : "+ telefono.length());
				System.out.println("Celular   :"+celular+ "length : "+ celular.length());
				*/
				if(!error){
					try {
						control.nuevaEmpresa(rutText,nombre,contacto,direccion,telefono,celular);
					} catch (SQLException e) {
						mensaje.showMessageDialog(null, "El rut esta ingresado en el sistema.", "Atención!!!", mensaje.ERROR_MESSAGE);
						Text_Rut.setBorder(BorderFactory.createLineBorder(Color.red));
						e.printStackTrace();
					}
					}
				}	
		});
		btnNewButton.setBounds(200, 215, 89, 23);
		contentPane.add(btnNewButton);
		

		
		
	}
}