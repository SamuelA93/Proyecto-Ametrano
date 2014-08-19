package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import Grafica.Controladores.Controlador_Empleado;



import Grafica.Controladores.Verificar_Ci;
import Grafica.Controladores.Verificar_Tel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


import Grafica.Controladores.Controlador_Verificar;

public class Nuevo_Empleado extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField cedula;
	private JTextField direccion;
	private JTextField telefono;
	private JTextField celuE;
	private Controlador_Verificar control = new Controlador_Verificar();
	private ArrayList<String> telefonos ;
	private Controlador_Empleado Empleado = new Controlador_Empleado();
	private 	JFrame frame = new JFrame("Exito");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo_Empleado frame = new Nuevo_Empleado();
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
	public Nuevo_Empleado() {
		setTitle("Nuevo Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 33, 89, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(33, 68, 64, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCedula = new JLabel("Ci.:");
		lblCedula.setBounds(33, 102, 64, 14);
		contentPane.add(lblCedula);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(33, 199, 73, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel.:");
		lblTelefono.setBounds(33, 133, 64, 14);
		contentPane.add(lblTelefono);
		
		nombre = new JTextField();
		nombre.setBounds(121, 30, 197, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(121, 65, 197, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		cedula = new JTextField();
		cedula.setBounds(121, 99, 197, 20);
		contentPane.add(cedula);
		cedula.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(121, 196, 197, 20);
		contentPane.add(direccion);
		direccion.setColumns(10);
		
		telefono = new JTextField();
		telefono.setBounds(121, 130, 197, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				///////////  Obtengo datos  de entrada 
				String nombreE 		= nombre.getText();
				String apellidoE 	= apellido.getText();
				String direccionE 	= direccion.getText();
				String telefonoE	= telefono.getText();
				String cedulaE 		= cedula.getText();
				String celularE 	= celuE.getText();
				////////////////////////////////////////////  
				
				
				telefonos= new ArrayList<String>();
				boolean error = false;
				if( control.SoloString_O_Espacios(nombreE)){
					if( Verificar_Ci.verificar(cedulaE) ){
						cedula.setBorder(BorderFactory.createLineBorder(Color.green));
						if( control.SoloString_O_Espacios(apellidoE) || apellidoE.equals("")){
							if( control.SoloNumeros(telefonoE) || telefonoE.equals("")){
								if(!telefonoE.equals("")){
									telefonos.add(telefonoE);
								}
								if( control.SoloNumeros(celularE) || celularE.equals("")){
									if(!celularE.equals("")){
										telefonos.add(celularE);
									}	
								}else{
									error = true;
									javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
									mensaje.showMessageDialog(null, "Celular incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
								}
							}else{
								error = true;
								javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
								mensaje.showMessageDialog(null, "Telefono incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
							}
						}else{
							error = true;
							javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
							mensaje.showMessageDialog(null, "Apellido incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
						}	
					}else{
						error = true;
						cedula.setBorder(BorderFactory.createLineBorder(Color.red));
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "Cedula ingresada incorrecta.", "Atención!!!", mensaje.ERROR_MESSAGE);
					}	
				}else{
					error = true;
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Nombre incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
				////////  la variable booleana error detecta si no se cumple algun requerimiento con las inputs
				if (!error) {
					try {
						 Empleado.nuevoEmpleado(nombreE, apellidoE, direccionE,Verificar_Ci.numeroCi(cedulaE), telefonos);
						 nombre.setText("");
						 apellido.setText("");
						 direccion.setText("");
						 telefono.setText("");
						 cedula.setText("");
						 celuE.setText("");
						 cedula.setBorder(BorderFactory.createLineBorder(Color.gray));
						 JOptionPane.showMessageDialog(frame, "Se ah agregado un nuevo Empleado, edite sus datos en Ver > Empleados ");
					} catch (Exception e2) {
						//e2.printStackTrace();
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						cedula.setBorder(BorderFactory.createLineBorder(Color.red));
						mensaje.showMessageDialog(null, "Ya existe usuario con la cedula "+cedula.getText(), "Atención!!!", mensaje.ERROR_MESSAGE);
					}	
				} else {
					//System.out.println("no");
				}
				
				
			}
		});
		btnConfirmar.setBounds(209, 227, 109, 23);
		contentPane.add(btnConfirmar);
		
		celuE = new JTextField();
		celuE.setColumns(10);
		celuE.setBounds(121, 165, 197, 20);
		contentPane.add(celuE);
		
		JLabel lblCel = new JLabel("Cel.:");
		lblCel.setBounds(33, 168, 64, 14);
		contentPane.add(lblCel);
	}
}
