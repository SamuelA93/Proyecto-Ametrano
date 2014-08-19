package Grafica.Ventanas;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import Grafica.Controladores.Controlador_Particular;
import Grafica.Controladores.Verificar_Ci;

import Grafica.Controladores.Verificar_Tel;

public class Nuevo_Particular extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField ci;
	private JTextField tel;
	private JTextField dir;
	private JTextField celu;
	private JLabel lblCel;
	private Controlador_Particular control = new Controlador_Particular();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nuevo_Particular frame = new Nuevo_Particular();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*try {
			  UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			} catch (Exception e) {
			  }*/
			
	}

	/**
	 * Create the frame.
	 */
	public Nuevo_Particular() {
		setTitle("Nuevo Particular");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 292);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 32, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(43, 64, 65, 14);
		contentPane.add(lblApellido);
		
		JLabel lblCi = new JLabel("CI.");
		lblCi.setBounds(43, 97, 65, 14);
		contentPane.add(lblCi);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setBounds(43, 132, 65, 14);
		contentPane.add(lblTel);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(43, 192, 65, 14);
		contentPane.add(lblDireccin);
		
		nombre = new JTextField();
		nombre.setBounds(107, 29, 173, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(107, 61, 173, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		ci = new JTextField();
		ci.setForeground(new Color(0, 0, 0));
		ci.setBackground(new Color(255, 255, 255));
		ci.setBounds(107, 94, 173, 20);
		contentPane.add(ci);
		ci.setColumns(10);
		
		tel = new JTextField();
		tel.setBounds(107, 129, 173, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		dir = new JTextField();
		dir.setBounds(107, 189, 173, 20);
		contentPane.add(dir);
		dir.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombreP 		= nombre.getText();
				String apellidoP 	= apellido.getText();
				String dirP 		= dir.getText();
				String telP			= tel.getText();
				String ciP 			= ci.getText();
				String celuP 			= celu.getText();
				Object[] tels = new Object[2];
				String espa ="";
				boolean bandera = false;
				boolean bandera2 = false;
				/*if(){
					
				}else{
					
				}*/
				if(!nombreP.equals(espa) ){
					if(	Verificar_Ci.verificar(ciP) ){
						/*controlador.nuevoParticular(nombreP,apellidoP,dirP,telP,Verificar_Ci.numeroCi(ciP),celuP);*/
						ci.setBorder(BorderFactory.createLineBorder(Color.green));
						
						if(!telP.equals(espa) ){
					  
							//Controlador_Nuevo_Particular controlador = new Controlador_Nuevo_Particular();
							if(Verificar_Tel.isNumeric(telP)){
								tels[0]=telP;	
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
						
						if(!celuP.equals(espa) ){
							  
							//Controlador_Nuevo_Particular controlador = new Controlador_Nuevo_Particular();
							if(Verificar_Tel.isNumeric(celuP)){
								tels[1]=celuP;	
								bandera2 = true;
								celu.setBorder(BorderFactory.createLineBorder(Color.green));
							}else{
								celu.setBorder(BorderFactory.createLineBorder(Color.red));
								javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
								mensaje.showMessageDialog(null, "Celular incorrecto.", "Atención!!!", mensaje.ERROR_MESSAGE);
							}
									
						}else{
							tels[1]="";
							bandera2 = true;
							celu.setBorder(BorderFactory.createLineBorder(Color.green));
						}
						
						if(bandera && bandera2){
							System.out.println("ntro");
							//Controlador_Nuevo_Particular controlador = new Controlador_Nuevo_Particular();
							control.nuevoParticular(nombreP, apellidoP, dirP, (String) tels[0], Verificar_Ci.numeroCi(ciP),(String) tels[1]);
						}
						
					}else{
							ci.setBorder(BorderFactory.createLineBorder(Color.red));		
						}
				}else{
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Ingrese el nombre.", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton.setBounds(188, 220, 89, 23);
		contentPane.add(btnNewButton);
		
		celu = new JTextField();
		celu.setColumns(10);
		celu.setBounds(107, 160, 173, 20);
		contentPane.add(celu);
		
		lblCel = new JLabel("Cel.:");
		lblCel.setBounds(43, 163, 65, 14);
		contentPane.add(lblCel);
		
		
	}

}
