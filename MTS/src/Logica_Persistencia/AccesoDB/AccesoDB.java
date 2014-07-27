package Logica_Persistencia.AccesoDB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;




public class AccesoDB {
	
	private String driver;
	private String username;
	private String pass;
	private String url;
	private String base;
	
	public Connection conectarBD() {
		// Cargo los datos desde el archivo de configuracion y conecto al servidor de BD
		Connection con = null;
		try
		{
			Properties p = new Properties();		
			try {
				p.load(new FileInputStream("config/parametros.txt"));
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			driver = p.getProperty("driver");
			username = p.getProperty("usuario");
			pass = p.getProperty("password");
			url = p.getProperty("url");
			base = p.getProperty("bdatos");
			Class.forName(driver);
	
			con = DriverManager.getConnection(url + base, username, pass);
	
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e){
			e.printStackTrace();
		}	
	return con;
	}
	
	public void desconectarBD(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	// Guardar los datos del nuevo particular 
	public void nuevoParticular(String nombre, String apellido, String dir, int ci) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.nuevoParticular();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, ci);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setString(4, dir);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	
	//
	public void nuevoTelefono( String tel, int referencia) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.nuevoCelTel();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, referencia);
			pstmt.setString(2, tel);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}

	//Guardo los Trabajos
		public void nuevoTrabajo(long cedulaRut,String fechaInicio, int montoTotal, int cuotas, String comentario,String estado) throws SQLException{
				// Ingresa una nueva actividad al sistema
				Connection con = this.conectarBD();	
				Consultas consultas = new Consultas();
				String insert = consultas.nuevoTrabajo();	
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(insert);
				pstmt.setInt(1, cuotas);
				pstmt.setString(2, fechaInicio);
				pstmt.setInt(3, montoTotal);
				pstmt.setString(4, estado);
				pstmt.setString(5, comentario);
				pstmt.setLong(6, cedulaRut);
				pstmt.executeUpdate ();			
				pstmt.close();					
				this.desconectarBD(con);
		}
		
		public String obtenerFecha(int id) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String strIdMutualista = consultas.fechaTarea();
			PreparedStatement pstmt = con.prepareStatement (strIdMutualista);
			pstmt.setInt (1, id);
			ResultSet rs = pstmt.executeQuery ();		 	        
		    rs.next();
		    String IdMutualista  = rs.getString(1);		
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return IdMutualista;
		}
		
		// retorna una lista de tareas para particulares
		
		public List<VOTareaParticular> ListarTareaParticular(){
			// 		 
				Connection con = null;				
				con = this.conectarBD();
				
				List<VOTareaParticular> lstTareaParticular = null;		
				/*  */
				Statement stmt;
				try {
					stmt = con.createStatement();			
					Consultas consultas = new Consultas();
					String strTareaParticular = consultas.DatosTareaParticulares();
					ResultSet rs = stmt.executeQuery(strTareaParticular);					
					lstTareaParticular= new ArrayList<VOTareaParticular>();			
					while (rs.next()) {
						VOTareaParticular TareaParticular = new VOTareaParticular();
						String cedula = rs.getString("ci");
						String nombre = rs.getString("nombre");
						String apellido = rs.getString("apellido");
						String direccion = rs.getString("direccion");
						String telefono = rs.getString("telefono");	
						String empleado_cedula = rs.getString("emcedula");
						String trabajo = rs.getString("trabajo");
						String fecha = rs.getString("fecha");
						String anio,dia,mes;
						anio= (String) fecha.subSequence(0,4);
						dia= (String) fecha.subSequence(8, 10);
						mes= (String) fecha.subSequence(5, 7);
						fecha= dia+'/'+mes+'/'+anio;
						String encanombre = rs.getString("Encargado");
						String hora = rs.getString("hora");//System.out.println(hora);
						String horas = rs.getString("horas");
						String comentario = rs.getString("comentario");
						TareaParticular.construir(cedula, nombre, apellido, direccion, telefono, empleado_cedula,encanombre, trabajo, fecha, hora, horas, comentario);
						lstTareaParticular.add(TareaParticular);			
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				this.desconectarBD(con);
				return lstTareaParticular;
			}
		
		// retorna una lista de tareas para empresas
		
		public List<VOTareaEmpresa> ListarTareaEmpresas(){
			// 		 
				Connection con = null;				
				con = this.conectarBD();
				
				List<VOTareaEmpresa> lstTareaEmpresa = null;		
				/*  */
				Statement stmt;
				try {
					stmt = con.createStatement();			
					Consultas consultas = new Consultas();
					String strTareaEmpresa = consultas.DatosTareaEmpresas();
					ResultSet rs = stmt.executeQuery(strTareaEmpresa);					
					lstTareaEmpresa= new ArrayList<VOTareaEmpresa>();			
					while (rs.next()) {
						VOTareaEmpresa TareaEmpresa = new VOTareaEmpresa();
						int rut = rs.getInt("rut");
						String nombre = rs.getString("nombre");
						String contacto = rs.getString("contacto");
						String direccion = rs.getString("direccion");
						String telefono = rs.getString("telefono");	
						String empleado_cedula = rs.getString("emcedula");
						String trabajo = rs.getString("trabajo");
						String fecha = rs.getString("fecha");
						String anio,dia,mes;
						anio= (String) fecha.subSequence(0,4);
						dia= (String) fecha.subSequence(8, 10);
						mes= (String) fecha.subSequence(5, 7);
						fecha= dia+'/'+mes+'/'+anio;
						String encanombre = rs.getString("Encargado");
						String hora = rs.getString("hora");//System.out.println(hora);
						String horas = rs.getString("horas");
						String comentario = rs.getString("comentario");
						TareaEmpresa.construir(rut, nombre, contacto, direccion, telefono, empleado_cedula, encanombre, trabajo, fecha, hora, horas, comentario);
						
						lstTareaEmpresa.add(TareaEmpresa);			
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				this.desconectarBD(con);
				return lstTareaEmpresa;
			}
}
