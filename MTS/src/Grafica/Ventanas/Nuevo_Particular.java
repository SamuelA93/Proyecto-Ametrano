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

import Grafica.Controladores.Controlador_Nuevo_Particular;
import Grafica.Controladores.Verificar_Ci;
import Grafica.Controladores.Verificar_Tel;

public class Nuevo_Particular extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField ci;
	private JTextField tel;
	private JTextField dir;

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
		
		JLabel lblTel = new JLabel("Tel. / Cel.");
		lblTel.setBounds(43, 132, 65, 14);
		contentPane.add(lblTel);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(43, 166, 65, 14);
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
		dir.setBounds(107, 163, 173, 20);
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
				
				Controlador_Nuevo_Particular controlador = new Controlador_Nuevo_Particular();
				if(Verificar_Ci.verificar(ciP) && Verificar_Tel.veri(telP)){
					controlador.nuevoParticular(nombreP,apellidoP,dirP,telP,Verificar_Ci.numeroCi(ciP));
					ci.setBorder(BorderFactory.createLineBorder(Color.green));
					tel.setBorder(BorderFactory.createLineBorder(Color.green));
				}else{
					if( Verificar_Ci.verificar(ciP) ){
						ci.setBorder(BorderFactory.createLineBorder(Color.green));
					}else{
						ci.setBorder(BorderFactory.createLineBorder(Color.red));
					}
					if( Verificar_Ci.verificar(telP) ){
						tel.setBorder(BorderFactory.createLineBorder(Color.green));
					}else{
						tel.setBorder(BorderFactory.createLineBorder(Color.red));
					}
				}
				
				
				
			}
		});
		btnNewButton.setBounds(188, 208, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}

}
