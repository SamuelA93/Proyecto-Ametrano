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


import Grafica.Controladores.Verificar_Ci;
import Grafica.Controladores.Verificar_Rut;
import Grafica.Controladores.Verificar_Tel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nueva_Empresa extends JFrame {

	private JPanel contentPane;
	private JTextField Text_Rut;
	private JTextField Text_Nombre;
	private JTextField Text_Contacto;
	private JTextField Text_Direccion;
	private JTextField Text_Telefono;
	private JTextField Text_Celular;
	private Controlador_Empresa control = new Controlador_Empresa();
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Rut");
		label1.setBounds(10, 35, 46, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Nombre");
		label2.setBounds(10, 64, 70, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("Contacto");
		label3.setBounds(10, 97, 70, 14);
		contentPane.add(label3);
		
		JLabel label4 = new JLabel("Direccion");
		label4.setBounds(10, 126, 70, 14);
		contentPane.add(label4);
		
		Text_Rut = new JTextField();
		Text_Rut.setBounds(116, 35, 278, 20);
		contentPane.add(Text_Rut);
		Text_Rut.setColumns(10);
		
		Text_Nombre = new JTextField();
		Text_Nombre.setBounds(116, 64, 278, 20);
		contentPane.add(Text_Nombre);
		Text_Nombre.setColumns(10);
		
		Text_Contacto = new JTextField();
		Text_Contacto.setBounds(116, 97, 278, 20);
		contentPane.add(Text_Contacto);
		Text_Contacto.setColumns(10);
		
		Text_Direccion = new JTextField();
		Text_Direccion.setBounds(116, 126, 278, 20);
		contentPane.add(Text_Direccion);
		Text_Direccion.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String rutText = Text_Rut.getText();
				String nombre = Text_Nombre.getText();
				String contacto = Text_Contacto.getText();
				String direccion = Text_Direccion.getText();
				String telefono = Text_Telefono.getText(); 
				String celular = Text_Celular.getText();

				//Controlador_Nueva_Empresa controlador = new Controlador_Nueva_Empresa();
				//Verificar_Rut verificador = new Verificar_Rut();
				//int rut = Integer.parseInt(rutText);
				
				
				if( control.verificador.verificarRut(rutText) ){
					control.nuevaEmpresa(rutText,nombre,contacto,direccion,telefono,celular);
					Text_Rut.setBorder(BorderFactory.createLineBorder(Color.green));
				}else{
						Text_Rut.setBorder(BorderFactory.createLineBorder(Color.red));
					}
				}
							
				
				
				
			
		});
		btnNewButton.setBounds(305, 214, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label5 = new JLabel("Telefono fijo");
		label5.setBounds(10, 155, 96, 14);
		contentPane.add(label5);
		
		Text_Telefono = new JTextField();
		Text_Telefono.setBounds(116, 155, 278, 20);
		contentPane.add(Text_Telefono);
		Text_Telefono.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 184, 96, 14);
		contentPane.add(lblCelular);
		
		Text_Celular = new JTextField();
		Text_Celular.setBounds(116, 184, 278, 20);
		contentPane.add(Text_Celular);
		Text_Celular.setColumns(10);
	}
}
