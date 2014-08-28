package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Actualizar_Empresa extends JFrame implements ActionListener {

	private JPanel contentPane;
	final JButton btnAceptar = new JButton("Aceptar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actualizar_Empresa frame = new Actualizar_Empresa();
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
	public Actualizar_Empresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 255, 199, -242);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("No debe haber campos vacios.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 87, 223, 87);
		contentPane.add(lblNewLabel);
		btnAceptar.addActionListener(this);
		
		btnAceptar.setBounds(179, 185, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==btnAceptar)
		{
			dispose();
		}
		
	
	
	}
	
}
