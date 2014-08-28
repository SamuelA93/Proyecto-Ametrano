
package Grafica.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.ListModel;


//import Grafica.Controladores.Controlador_Actualizar_Empresa;
import Grafica.Controladores.Controlador_Socio;
import Grafica.Controladores.Controlador_Empresa;
//import Grafica.Controladores.Controlador_Es_Socio;
//import Grafica.Controladores.Controlador_Nueva_Empresa;
//import Grafica.Controladores.Controlador_Nuevo_Socio;
//import Grafica.Controladores.Controlador_Tabla_Empresas;
import Grafica.Controladores.Controlador_Tarea;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOTarea;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Ver_Empresas extends JFrame  {

	private JPanel contentPane;
	private JTable table;
	boolean opcion;	
	JList list = new JList();
	final Controlador_Empresa controladorTabla = new Controlador_Empresa();	
	List<VOEmpresa> lstEmpresas = controladorTabla.listarEmpresas();	
	JMenu mnEliminar = new JMenu("Eliminar");
	JMenu mnEditar = new JMenu("Editar");
	JMenu mnNuevo = new JMenu("Nuevo");

	protected Ver_Empresas prueba=this;	
	private JTextField txtRut;
	final JTextField txtNombre;
	final JTextField txtContacto;
	final JTextField txtDireccion;
	final JTextField txtTelefono1;
	
	final JCheckBox checkboxSocio = new JCheckBox("SOCIO");	
	JButton btnGuardarEditar = new JButton("Guardar cambios");
	DefaultListModel modelo = new DefaultListModel(){};
	String telefonoViejo1;
	String telefonoViejo2;
	boolean controlSocio;
	final JTextField txtTelefono2;
	
	/**
	 * Launch the application.
	 */
	
	public void setOpcion(boolean valor){
		opcion=valor;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Empresas frame = new Ver_Empresas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Ver_Empresas() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 372);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*txtRut.setEditable(true);
				txtNombre.setEditable(true);
				txtContacto.setEditable(true);
				txtDireccion.setEditable(true);
				txtTelefono.setEditable(true);
				btnGuardarNuevo.setVisible(true);*/
				btnGuardarEditar.setVisible(false);
				try {
					Ver_Empresas prueba = new Ver_Empresas();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				prueba.setVisible(false);
				
				Nueva_Empresa nueva = new Nueva_Empresa(/*prueba*/);
				nueva.setVisible(true);
				
				/*mnEliminar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						//this.setVisible(false);
						try {
							Ver_Empresas prueba = new Ver_Empresas();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						prueba.setVisible(false);
						Eliminar_Empresa eliminar = new Eliminar_Empresa(prueba);
						eliminar.setVisible(true);				
						
						
						
					}
				});*/				
				
				
				
				
				
				/*Nueva_Empresa nueva = new Nueva_Empresa();
				nueva.setVisible(true);*/
				
				
				
				
				
				
			}
			
		});
		
		menuBar.add(mnNuevo);

		
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				getTxtRut().setEditable(false);
				txtNombre.setEditable(true);
				txtContacto.setEditable(true);
				txtDireccion.setEditable(true);
				txtTelefono1.setEditable(true);
				btnGuardarEditar.setVisible(true);
				txtTelefono2.setEditable(true);
				//btnGuardarNuevo.setVisible(false);
				checkboxSocio.setEnabled(true);
			}
		});
		

		menuBar.add(mnEditar);
		mnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//this.setVisible(false);
				try {
					Ver_Empresas prueba = new Ver_Empresas();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//prueba.setVisible(false);
				/*Eliminar_Empresa eliminar = new Eliminar_Empresa(prueba);
				eliminar.setVisible(true);			*/	
				
				
				
			}
		});
		
	
		//mnEliminar.addActionListener(this);
		menuBar.add(mnEliminar);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 55, 150, 200);
		contentPane.add(scrollPane_1);
		final DefaultListModel modelo = new DefaultListModel(){};

			  //  @Override
			    /*public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }*/
			
			//modelo.addColumn("Nombre");
			 


			
			if (lstEmpresas.size() > 0){	
				Iterator<VOEmpresa> iterT = lstEmpresas.iterator();
				while (iterT.hasNext()){
					VOEmpresa Empresa = iterT.next();
					Object[] fila = new Object[1];
					fila[0] = Empresa.getNombre();
					//System.out.println(Empresa.getNombre());
					modelo.addElement(fila[0]);
				}		
			}
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					
				}
			});
			
			list.setModel(modelo);		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				txtNombre.setText( (String) list.getSelectedValue()  );
				getTxtRut().setText(Long.toString((lstEmpresas.get( list.getSelectedIndex() ).getRut())));
				txtContacto.setText(lstEmpresas.get(list.getSelectedIndex()).getContacto());
				txtDireccion.setText(lstEmpresas.get(list.getSelectedIndex()).getDireccion());
				txtTelefono1.setText(lstEmpresas.get(list.getSelectedIndex()).getTelefono());
				txtTelefono2.setText(lstEmpresas.get(list.getSelectedIndex()).getTelefono2());
				
				telefonoViejo1 = txtTelefono1.getText();//---->minar bien telefono y celular
				telefonoViejo2 = txtTelefono2.getText();
			
				txtRut.setEditable(false);
				txtNombre.setEditable(false);
				txtContacto.setEditable(false);
				txtDireccion.setEditable(false);
				txtTelefono1.setEditable(false);
				btnGuardarEditar.setVisible(false);
				txtTelefono2.setEditable(false);
				//btnGuardarNuevo.setVisible(false);
				checkboxSocio.setEnabled(false);
				
				
				Controlador_Socio controladorSocio = new Controlador_Socio();
				

						//checkboxSocio.set
				
				
					try {
						checkboxSocio.setSelected( controladorSocio.esSocioAmadeo( (lstEmpresas.get( list.getSelectedIndex() ).getRut()) ) );
						
						controlSocio = checkboxSocio.isSelected();
						System.out.println(controlSocio);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
		});
	
		scrollPane_1.setViewportView(list);
		
		JLabel lblRut = new JLabel("RUT:");
		lblRut.setForeground(Color.BLACK);
		lblRut.setBounds(179, 55, 46, 14);
		contentPane.add(lblRut);
		
		JLabel lblContacto = new JLabel("NOMBRE: ");
		lblContacto.setBounds(179, 90, 78, 14);
		contentPane.add(lblContacto);
		
		JLabel lblDireccion = new JLabel("CONTACTO:");
		lblDireccion.setBounds(179, 125, 78, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblDireccion_1 = new JLabel("DIRECCION:");
		lblDireccion_1.setBounds(179, 160, 78, 14);
		contentPane.add(lblDireccion_1);
		
		JLabel lblTelefono1 = new JLabel("TELEFONO 1:");
		lblTelefono1.setBounds(179, 195, 78, 14);
		contentPane.add(lblTelefono1);
		
		JLabel lblEmpresas = new JLabel("EMPRESAS");
		lblEmpresas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmpresas.setBounds(55, 30, 67, 14);
		contentPane.add(lblEmpresas);
		
		JLabel lblInformacion = new JLabel("INFORMACION");
		lblInformacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformacion.setBounds(260, 30, 86, 14);
		contentPane.add(lblInformacion);
		
		setTxtRut(new JTextField());
		getTxtRut().setEditable(false);
		getTxtRut().setBounds(260, 55, 150, 20);
		contentPane.add(getTxtRut());
		getTxtRut().setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(260, 90, 150, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtContacto = new JTextField();
		txtContacto.setEditable(false);
		txtContacto.setBounds(260, 125, 150, 20);
		contentPane.add(txtContacto);
		txtContacto.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(260, 160, 150, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono1 = new JTextField();
		txtTelefono1.setEditable(false);
		txtTelefono1.setBounds(260, 195, 150, 20);
		contentPane.add(txtTelefono1);
		txtTelefono1.setColumns(10);
		
		txtTelefono2 = new JTextField();
		txtTelefono2.setEditable(false);
		txtTelefono2.setBounds(260, 226, 150, 20);
		contentPane.add(txtTelefono2);
		txtTelefono2.setColumns(10);
		
		btnGuardarEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtNombre.getText().isEmpty() || txtContacto.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtTelefono1.getText().isEmpty() || txtTelefono2.getText().isEmpty())
				{
					Actualizar_Empresa actualizar = new Actualizar_Empresa();
					actualizar.setVisible(true);
				}
				else
				{	
					
					txtNombre.setEditable(false);
					getTxtRut().setEditable(false);
					txtContacto.setEditable(false);
					txtDireccion.setEditable(false);
					txtTelefono1.setEditable(false);
					txtTelefono2.setEditable(false);
					btnGuardarEditar.setVisible(false);
					checkboxSocio.setEnabled(false);

					//System.out.println(txtNombre.getText());
					Controlador_Empresa controladorActualizar = new Controlador_Empresa();
					controladorActualizar.actualizarEmpresa(getTxtRut().getText(), txtNombre.getText(), txtContacto.getText(), txtDireccion.getText(), txtTelefono1.getText(), txtTelefono2.getText(), checkboxSocio.isSelected(), telefonoViejo1, telefonoViejo2 );
					if( (controlSocio) && (!checkboxSocio.isSelected()) )
					{
						Controlador_Socio controladorEliminar = new Controlador_Socio();
						try {
							System.out.println("hasta aca llega");
							controladorEliminar.eliminarSocio(Long.parseLong(getTxtRut().getText()));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if( (!controlSocio) && (checkboxSocio.isSelected()))
						{
							Controlador_Socio controladorNuevo = new Controlador_Socio();
							try {
								controladorNuevo.Nuevo_Socio(Long.parseLong(getTxtRut().getText()));
							} catch (NumberFormatException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					
					
					try {
						lstEmpresas = controladorTabla.listarEmpresas();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//list.removeAll();
					modelo.removeAllElements();
					list.setModel(modelo);
					if (lstEmpresas.size() > 0){	
						Iterator<VOEmpresa> iterT = lstEmpresas.iterator();
						while (iterT.hasNext()){
							VOEmpresa Empresa = iterT.next();
							Object[] fila = new Object[1];
							fila[0] = Empresa.getNombre();
							//list.add(Empresa)
							//System.out.println(Empresa.getNombre());
							modelo.addElement(fila[0]);
						}		
					}
					
					list.setModel(modelo);
				
				
				}
			}
		});
		

		btnGuardarEditar.setVisible(false);
		btnGuardarEditar.setBounds(260, 285, 150, 23);
		contentPane.add(btnGuardarEditar);
		
		
		checkboxSocio.setBounds(260, 255, 97, 23);
		checkboxSocio.setEnabled(false);
		contentPane.add(checkboxSocio);
		
		JLabel lblTelefono2 = new JLabel("TELEFONO 2:");
		lblTelefono2.setBounds(179, 230, 78, 14);
		contentPane.add(lblTelefono2);
		
		table = new JTable();

		
		
		
		
		
	}

	public JTextField getTxtRut() {
		return txtRut;
	}

	public void setTxtRut(JTextField txtRut) {
		this.txtRut = txtRut;
	}
}

