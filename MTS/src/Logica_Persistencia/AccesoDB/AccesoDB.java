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

import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;
import Logica_Persistencia.Value_Object.VOTrabajo;




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
	// Ingresar nueva Tarea
	public void nuevaTarea(int trabajo, int encargado, String fecha, String hora, int horas,String comentario) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.NuevaTarea();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, trabajo);
			pstmt.setInt(2, encargado);
			pstmt.setString(3, fecha);
			pstmt.setString(4, hora);
			pstmt.setInt(5, horas);
			pstmt.setString(6, comentario);
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
		// Traer Trabajo segun idTrabajo
		public VOTrabajo obtenerTrabajoXid(int id) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String strTrabajoXid = consultas.TrabajoXid();
			PreparedStatement pstmt = con.prepareStatement (strTrabajoXid);
			System.out.println(id);
			pstmt.setInt (1, id);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	int	 referencia = rs.getInt("referencia");
	    	System.out.println(referencia);
	    	float	 monto = rs.getFloat("monto");
	    	int	 cuotas = rs.getInt("cuotas");
	    	String	estado = rs.getString("estado");	
	    	int	idd= rs.getInt("idTrabajos");
		  	VOTrabajo trabajo = new VOTrabajo(idd, cuotas, monto, estado, referencia);
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return trabajo;
		}
		// Obtener de empleado nombre y apellido por la cedula
		public String obtenerEmpleadoXcedula(int id) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String empleadoXcedula = consultas.empleadoXcedula();
			PreparedStatement pstmt = con.prepareStatement (empleadoXcedula);
			System.out.println(id);
			pstmt.setInt (1, id);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	String	 nombre = rs.getString("nombre");
	    	//System.out.println(referencia);
	    	String	 apellido = rs.getString("apellido");
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return nombre+" "+apellido;
		}
		
		// obtener particular por ci 
		public VOParticular obtenerParticularXcedula(int cedula) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String particularXcedula = consultas.particularXcedula();
			PreparedStatement pstmt = con.prepareStatement (particularXcedula);
			System.out.println(cedula);
			pstmt.setInt (1, cedula);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	String	 nombre = rs.getString("nombre");
	    	String	 apellido = rs.getString("apellido");
	    	String	 direccion = rs.getString("dir");
	    	//System.out.println(referencia);
	    	String tel=obtenerTelXreferencia(cedula);
	    	VOParticular cliente = new VOParticular(cedula, nombre, apellido, direccion, tel);
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return cliente;
		}
		public VOEmpresa obtenerEmpresaXrut(int rut) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String empresaXrut = consultas.empresaXrut();
			PreparedStatement pstmt = con.prepareStatement (empresaXrut);
			System.out.println(rut);
			pstmt.setInt (1, rut);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
			String tel= obtenerTelXreferencia(rut);
		    
	    	String	 nombre = rs.getString("nombre");
	    	String	 contacto = rs.getString("contacto");
	    	String dir = rs.getString("direccion");
	    	VOEmpresa cliente = new VOEmpresa(rut, nombre, contacto, dir, tel);
	    	//System.out.println(referencia);
	    	
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return cliente;
		}
		
		
		
		
		// Listar tareas
		
		public List<VOTarea> ListarTareas(){
			// 		 
				Connection con = null;				
				con = this.conectarBD();
				
				List<VOTarea> lstTareas = null;		
				/*  */
				Statement stmt;
				try {
					stmt = con.createStatement();			
					Consultas consultas = new Consultas();
					String strTarea = consultas.DatosTareas();
					ResultSet rs = stmt.executeQuery(strTarea);					
					lstTareas= new ArrayList<VOTarea>();			
					while (rs.next()) {
						
						int id_Trabajo = rs.getInt("Trabajos_idTrabajos");
						int ci_encargado = rs.getInt("Empleados_cedula");
						String fecha = rs.getString("fecha");
						String anio,dia,mes;
						anio= (String) fecha.subSequence(0,4);
						dia= (String) fecha.subSequence(8, 10);
						mes= (String) fecha.subSequence(5, 7);
						fecha= dia+'/'+mes+'/'+anio;
						String hora = rs.getString("hora");//System.out.println(hora);
						String horas = rs.getString("horas");
						String comentario = rs.getString("comentario");
						VOTarea Tarea =new VOTarea(ci_encargado, id_Trabajo, fecha, hora, horas, comentario);
						
						lstTareas.add(Tarea);			
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				this.desconectarBD(con);
				return lstTareas;
			}
		public String obtenerTelXreferencia(int referencia) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String telXreferencia = consultas.TelXreferencia();
			PreparedStatement pstmt = con.prepareStatement (telXreferencia);
			//System.out.println(referencia);
			pstmt.setInt (1, referencia);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	String	 tel = rs.getString("telefono");
	    	//System.out.println(referencia);
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return tel;
		}
		
		public List<Object[]> obtenerClientes_Referecia(String entradaNombre,String entradareferencia) throws SQLException{	
			List<Object[]> lstClientes = null;	
			Connection con = null;	
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String Cliente_Referencia = consultas.obtenerClientes_Referencias();
			PreparedStatement pstmt = con.prepareStatement (Cliente_Referencia);
			System.out.println(entradaNombre);
			ResultSet rs = pstmt.executeQuery ();
			lstClientes= new ArrayList<Object[]>();	
			 while(rs.next()){
				 Object[] fila = new Object[2];
				 fila[0] = rs.getString("nombre");
				 fila[1] = rs.getString("referencia");
				 lstClientes.add(fila);
			 }
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return lstClientes;
		}
		
		// obtener idtranajo y titulo por la referencia 
		public List<Object[]> obtenerTrabajos_Referecia(long a2) throws SQLException{	
			List<Object[]> lstTrabajos = null;	
			Connection con = null;	
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String Trabajo_Referencia = consultas.obtenerTrabajos_id();
			PreparedStatement pstmt = con.prepareStatement (Trabajo_Referencia);
			pstmt.setLong (1, a2);
			ResultSet rs = pstmt.executeQuery ();
			lstTrabajos= new ArrayList<Object[]>();	
			 while(rs.next()){
				 Object[] fila = new Object[2];
				 fila[0] = rs.getString("trabajo");
				 fila[1] = rs.getString("estado");
				 lstTrabajos.add(fila);
			 }
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return lstTrabajos;
		}
}
