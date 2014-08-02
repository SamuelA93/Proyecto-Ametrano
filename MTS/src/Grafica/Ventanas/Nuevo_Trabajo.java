package Grafica.Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Grafica.Controladores.Controlador_Nuevo_Trabajo;
import Grafica.Controladores.Verificar_Ci;
import Grafica.Controladores.Verificar_Existencia;
import Grafica.Controladores.Verificar_Rut;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Nuevo_Trabajo extends JFrame {

	private JPanel contentPane;
	private JTextField cedulaRut;
	private JTextField fechaInicio;
	private JTextField montoTotal;
	private JTextField cuotas;

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
	public Nuevo_Trabajo() {
		setBackground(Color.WHITE);
		setTitle("Nuevo Trabajo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedularut = new JLabel("Cedula/RUT");
		lblCedularut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCedularut.setBounds(10, 11, 94, 34);
		contentPane.add(lblCedularut);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaInicio.setBounds(10, 52, 74, 22);
		contentPane.add(lblFechaInicio);
		
		JLabel lblMontoTotal = new JLabel("Monto total");
		lblMontoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontoTotal.setBounds(10, 85, 84, 22);
		contentPane.add(lblMontoTotal);
		
		JLabel lblCuotas = new JLabel("Cuotas");
		lblCuotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuotas.setBounds(10, 118, 46, 14);
		contentPane.add(lblCuotas);
		
		cedulaRut = new JTextField();
		cedulaRut.setBounds(130, 20, 267, 20);
		contentPane.add(cedulaRut);
		cedulaRut.setColumns(10);
		
		fechaInicio = new JTextField();
		fechaInicio.setBounds(130, 55, 267, 20);
		contentPane.add(fechaInicio);
		fechaInicio.setColumns(10);
		
		montoTotal = new JTextField();
		montoTotal.setBounds(130, 88, 267, 20);
		contentPane.add(montoTotal);
		montoTotal.setColumns(10);
		
		cuotas = new JTextField();
		cuotas.setBounds(130, 117, 267, 20);
		contentPane.add(cuotas);
		cuotas.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Comentario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 159, 94, 14);
		contentPane.add(lblNewLabel);
		
	    final JTextArea comentarioTexto = new JTextArea();
		comentarioTexto.setBounds(130, 148, 267, 155);
		contentPane.add(comentarioTexto);
		/*Creo un objeto Scroll para el text area*/
		JScrollPane scrollpane1 = new JScrollPane(comentarioTexto);    
        scrollpane1.setBounds(130, 148, 267, 155);
        getContentPane().add(scrollpane1);
		
		JButton btnRegistrar = new JButton("Agregar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedulaRutT   = cedulaRut.getText();
				String fechaInicioT = fechaInicio.getText();
				String montoTotalT  = montoTotal.getText();
				String cuotasT      = cuotas.getText();
				String comentarioT  = comentarioTexto.getText();
				
				boolean error=false;
				String rojo ="setBorder(BorderFactory.createLineBorder(Color.red)";
				Verificar_Existencia a = new Verificar_Existencia();
				
				if(a.verificarExistencia(cedulaRutT)){
					if(cedulaRutT.trim().length()==12){
						//es Rut
						Verificar_Rut b = new Verificar_Rut();
						if(!b.verificarRut(cedulaRutT)){
							error = true;
							cedulaRut.setBorder(BorderFactory.createLineBorder(Color.red));
						}else{
							cedulaRut.setBorder(BorderFactory.createLineBorder(Color.green));
						}
						
					}else{
						if(cedulaRutT.trim().length()==9){
							//es cedula
							Verificar_Ci c= new Verificar_Ci();
							if(!c.verificar(cedulaRutT)){
								error = true;
								cedulaRut.setBorder(BorderFactory.createLineBorder(Color.red));
							}else{
								cedulaRut.setBorder(BorderFactory.createLineBorder(Color.green));
							}
						}else{
							cedulaRut.setBorder(BorderFactory.createLineBorder(Color.red));
							error=true;
						}
					}
				}else{
					cedulaRut.setBorder(BorderFactory.createLineBorder(Color.red));
					error=true;
				}// end verificar cedulaRut
				
				if(a.verificarExistencia(fechaInicioT)){
					fechaInicio.setBorder(BorderFactory.createLineBorder(Color.green));
				}else{
					fechaInicio.setBorder(BorderFactory.createLineBorder(Color.red));
					error=true;
				}
				
				if(a.verificarExistencia(montoTotalT)&& a.esNumero(montoTotalT)){
					montoTotal.setBorder(BorderFactory.createLineBorder(Color.green));
				}else{
					montoTotal.setBorder(BorderFactory.createLineBorder(Color.red));
					error=true;
				}
				
				if(a.verificarExistencia(cuotasT) && a.esNumero(cuotasT)){
					cuotas.setBorder(BorderFactory.createLineBorder(Color.green));
				}else{
					cuotas.setBorder(BorderFactory.createLineBorder(Color.red));
					error=true;
				}
				
				if(!error){
					Controlador_Nuevo_Trabajo controlador = new Controlador_Nuevo_Trabajo(); 
					controlador.nuevoTrabajo(cedulaRutT,fechaInicioT,montoTotalT,cuotasT,comentarioT);
				}
 			}
		});
		btnRegistrar.setBounds(314, 314, 89, 23);
		contentPane.add(btnRegistrar);
	}
}