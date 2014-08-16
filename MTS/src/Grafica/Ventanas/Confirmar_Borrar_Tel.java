package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Confirmar_Borrar_Tel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmar_Borrar_Tel frame = new Confirmar_Borrar_Tel();
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
	public Confirmar_Borrar_Tel() {
		setTitle("Borrar Tel\u00E9fono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 141);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstaSeguroDe = new JLabel("Esta seguro de que quiere eliminar el tel\u00E9ono?");
		lblEstaSeguroDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstaSeguroDe.setBounds(44, 29, 310, 23);
		contentPane.add(lblEstaSeguroDe);
		
		JButton btnSi = new JButton("Continuar");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSi.setBounds(208, 62, 102, 23);
		contentPane.add(btnSi);
	}
}
