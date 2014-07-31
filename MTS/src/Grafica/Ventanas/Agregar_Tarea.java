package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agregar_Tarea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar_Tarea frame = new Agregar_Tarea();
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
	public Agregar_Tarea() {
		setTitle("Agregar Tarea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Encargado");
		lblCliente.setBounds(41, 60, 81, 14);
		contentPane.add(lblCliente);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(120, 55, 180, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(40, 90, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(40, 120, 46, 14);
		contentPane.add(lblHora);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(40, 150, 82, 14);
		contentPane.add(lblComentario);
		
		textField = new JTextField();
		textField.setBounds(120, 85, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 115, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 150, 180, 128);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblDdmmaaaa = new JLabel("dd/mm/aaaa");
		lblDdmmaaaa.setForeground(Color.GRAY);
		lblDdmmaaaa.setBounds(216, 90, 81, 14);
		contentPane.add(lblDdmmaaaa);
		
		JLabel lblHhmmss = new JLabel("hh/mm/ss");
		lblHhmmss.setForeground(Color.GRAY);
		lblHhmmss.setBounds(216, 120, 84, 14);
		contentPane.add(lblHhmmss);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
		});
		btnGuardar.setBounds(211, 291, 89, 23);
		contentPane.add(btnGuardar);
	}
}
