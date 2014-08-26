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

import Grafica.Controladores.pruebaFechas;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOParticularEmpresa;
import Logica_Persistencia.Value_Object.VOSocio;
import Logica_Persistencia.Value_Object.VOSocio_Fechas;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;
import Logica_Persistencia.Value_Object.VOTrabajo;
import Logica_Persistencia.Value_Object.VOTrabajosClientes;
import Logica_Persistencia.Value_Object.VOUnTrabajo;




public class AccesoDB {
	
	private String driver;
	private String username;
	private String pass;
	private String url;
	private String base;
	pruebaFechas auxiliar =new pruebaFechas();
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
	
	public void Socio_Un_Mes_Mas(long ref, String fecha ) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Agregar_un_mes();
			//System.out.println("acceso");
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.setString(2, fecha);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Socio_dos_Mes_Mas(long ref, String fecha ) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Agregar_dos_mes();
			//System.out.println("acceso");
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.setString(2, fecha);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Socio_tres_Mes_Mas(long ref, String fecha ) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Agregar_tres_mes();
			//System.out.println("acceso");
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.setString(2, fecha);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Socio_Anio_Mes_Mas(long ref, String fecha ) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Agregar_tres_mes();
			//System.out.println("acceso");
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.setString(2, fecha);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Socio_x_Mes_Mas(long ref, String fecha,int x ) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Agregar_X_mes(x);
		//	System.out.println("acceso");
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.setString(2, fecha);
			
			
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Cancelar_Socio(long ref, String fecha ) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Cancelar_Socio();
		//	System.out.println("acceso");
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.setString(2, fecha);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Nuevo_Socio(long ref) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.nuevoSocio();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1,ref);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void Eliminar_Telefono(String tel,long ref) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.EliminarTelefono();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1,tel);
			pstmt.setLong(2,ref);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
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
	public void nuevaTarea(int trabajo, int encargado, String fecha, String hora,String comentario) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.NuevaTarea();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(2, trabajo);
			pstmt.setInt(1, encargado);
			pstmt.setString(3, fecha);
			pstmt.setString(4, hora);
			//pstmt.setInt(5, horas);
			pstmt.setString(5, comentario);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	
	public void Eliminar_Tarea(int trabajo, long l, String fecha) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.Eliminar_Tarea();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(2, trabajo);
			pstmt.setLong(1, l);
			pstmt.setString(3, fecha);
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
			pstmt.setString(1, tel);
			pstmt.setInt(2, referencia);
			
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
	public void nuevos_2_Telefonos( ArrayList tel, int referencia) throws SQLException{
		// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.nuevoCel_Y_Tel();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, (String) tel.get(0));
			pstmt.setInt(2, referencia);
			pstmt.setString(3, (String) tel.get(1));
			pstmt.setInt(4, referencia);
			
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
				
				pstmt.setInt(2, montoTotal);
				pstmt.setString(3, estado);
				pstmt.setLong(4, cedulaRut);
				
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
		
		public ArrayList Socios_ref() throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String strIdMutualista = consultas.Socios_ref();
			PreparedStatement pstmt = con.prepareStatement (strIdMutualista);
			ResultSet rs = pstmt.executeQuery ();
			ArrayList socios = new  ArrayList();
			
			    while(rs.next()){
			    	socios.add(rs.getLong("referencia"));
			    	//System.out.println(rs.getLong("referencia"));
			    }
				
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return socios;
		}
		
		public int obtener_idTrabajo_X_ref(long ref) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String strIdMutualista = consultas.obtener_idTrabajo_X_Referecncia();
			PreparedStatement pstmt = con.prepareStatement (strIdMutualista);
			pstmt.setLong (1, ref);
			ResultSet rs = pstmt.executeQuery ();		 	        
		    rs.next();
		    int Id  = rs.getInt("id");		
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return Id;
		}
		// Modificar Particulares 
		public void Modificar_Particular(String modi,long l) throws SQLException{	
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.ModificarParticulares(modi);	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setLong(1, l);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
		// Modificar telefono 
				public void Modificar_Tel(String modi,String viejo,int ci) throws SQLException{	
					Connection con = this.conectarBD();	
					Consultas consultas = new Consultas();
					String insert = consultas.ModificarTel(modi,viejo);	
					PreparedStatement pstmt;
					pstmt = con.prepareStatement(insert);
					
					/*pstmt.setString(1, modi);
					pstmt.setString(2, viejo);*/
					pstmt.setInt(1, ci);
					//System.out.println(insert);
					pstmt.executeUpdate ();			
					pstmt.close();					
					this.desconectarBD(con);
				}
		// Traer Trabajo segun idTrabajo
		public VOTrabajo obtenerTrabajoXid(int id) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String strTrabajoXid = consultas.TrabajoXid();
			PreparedStatement pstmt = con.prepareStatement (strTrabajoXid);
			//System.out.println(id);
			pstmt.setInt (1, id);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	long	 referencia = rs.getLong("referencia");
	    	//System.out.println(referencia);
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
		
		public int obtenerCantiadXref_Socio(long ref) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String strTrabajoXid = consultas.Cantidad_Registros_Socio_Ref();
			PreparedStatement pstmt = con.prepareStatement (strTrabajoXid);
			//System.out.println(id);
			pstmt.setLong (1, ref);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	int	 cantidad = rs.getInt("cantidad");
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return cantidad;
		}
		// Obtener de empleado nombre y apellido por la cedula
		public String obtenerEmpleadoXcedula(long id) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String empleadoXcedula = consultas.empleadoXcedula();
			PreparedStatement pstmt = con.prepareStatement (empleadoXcedula);
			//System.out.println(id);
			pstmt.setLong (1, id);
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
		public VOParticular obtenerParticularXcedula(long cedula) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String particularXcedula = consultas.particularXcedula();
			PreparedStatement pstmt = con.prepareStatement (particularXcedula);
			//System.out.println(cedula);
			pstmt.setLong (1, cedula);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
	    	String	 nombre = rs.getString("nombre");
	    	String	 apellido = rs.getString("apellido");
	    	String	 direccion = rs.getString("dir");
	    	//System.out.println(referencia);
	    	Object[] telefono=obtenerTelXreferencia(cedula);
	    	VOParticular cliente = new VOParticular(cedula, nombre, apellido, direccion,(String) telefono[0],(String)telefono[1]);
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return cliente;
		}
		public VOEmpresa obtenerEmpresaXrut(long rut) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String empresaXrut = consultas.empresaXrut();
			PreparedStatement pstmt = con.prepareStatement (empresaXrut);
			//System.out.println(rut);
			//System.out.println(rut);
			pstmt.setLong (1, rut);
			ResultSet rs = pstmt.executeQuery ();
			 rs.next();
			Object[] telefono= obtenerTelXreferencia(rut);
		    
	    	String	 nombre = rs.getString("nombre");
	    	String	 contacto = rs.getString("contacto");
	    	String dir = rs.getString("direccion");
	    	
	    	//System.out.println((String) telefono[0]);
	    	//System.out.println((String) telefono[1]);
	    	VOEmpresa cliente = new VOEmpresa(rut, nombre, contacto, dir,(String) telefono[0],(String) telefono[1]);
	    	//System.out.println(referencia);
	    	
		    rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return cliente;
		}
		
		
		public VOSocio obtenerSocioX_Ref(long ref) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String fechasXref = consultas.Socio_Fechas();
			PreparedStatement pstmt = con.prepareStatement (fechasXref);
			pstmt.setLong (1, ref);
			ResultSet rs = pstmt.executeQuery ();
			ArrayList<VOSocio_Fechas> fechas = new ArrayList();
			pruebaFechas conv = new pruebaFechas();
			 while (rs.next()){
				 VOSocio_Fechas dato = new  VOSocio_Fechas();
				 String f1 = conv.fechaJAVA(rs.getString("f1"));
				 dato.setF1(conv.dateJAVA(f1));
				 try{
					 String f2 = conv.fechaJAVA(rs.getString("f2"));
					 dato.setF2(conv.dateJAVA(f2));
				 }catch(Exception e){
					 dato.setF2(conv.dateJAVA("01/01/2000"));
					 //dato.setF2(null);
				 }
				 
				 
				 fechas.add(dato);
			 }
			 	/*VOSocio_Fechas nueva = new VOSocio_Fechas();
				pruebaFechas auxiliar = new pruebaFechas();
				java.util.Date cancelado =  auxiliar.dateJAVA("01/01/2000");
				java.util.Date pendiente =  auxiliar.dateJAVA("09/09/2009");
				if (!fechas.get(fechas.size()-1).getF2().equals(cancelado)){
					nueva.setF1(fechas.get(fechas.size()-1).getF2());
					nueva.setF2(pendiente);	
				}
				fechas.add(nueva);*/
			VOSocio socio = new VOSocio(fechas, ref);
			rs.close();
		    pstmt.close();
			this.desconectarBD(con);
			return socio;
		}
		
		// Listar tareas
		
		public List<VOTarea> ListarTareas(){	 
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
		
		public List<VOTrabajo> Listar_Trabajos(){	 
			Connection con = null;				
			con = this.conectarBD();
			List<VOTrabajo> lstTrabajos = null;		
			/*  */
			Statement stmt;
			try {
				stmt = con.createStatement();			
				Consultas consultas = new Consultas();
				String strTrabajo = consultas.Trabajos_Lista();
				ResultSet rs = stmt.executeQuery(strTrabajo);					
				lstTrabajos= new ArrayList<VOTrabajo>();			
				while (rs.next()) {
					
					int id_Trabajo = rs.getInt("trabajo");
					long ci_cliente = rs.getLong("referencia");
					float monto = rs.getFloat("monto");
					int cuotas = rs.getInt("cuotas");
					String estado = rs.getString("estado");
					
					VOTrabajo trabaj =new VOTrabajo(id_Trabajo, cuotas, monto, estado, ci_cliente);
					
					lstTrabajos.add(trabaj);			
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			this.desconectarBD(con);
			return lstTrabajos;
		}
		public Object[] obtenerTelXreferencia(long referencia) throws SQLException{	
			Connection con = null;				
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String telXreferencia = consultas.TelXreferencia();
			PreparedStatement pstmt = con.prepareStatement (telXreferencia);
			//System.out.println(referencia);
			pstmt.setLong (1, referencia);
			ResultSet rs = pstmt.executeQuery ();
			Object[] tels = new Object[2];
			 try{
				 
				if(rs.next()){
					tels[0]= rs.getString("telefono");
				}else{
					tels[0]= "No ingresado";
				}
				if(rs.next()){
					tels[1]= rs.getString("telefono");
				}else{
					tels[1]= "No ingresado";
				}
				System.out.println(tels[0]+" "+tels[1]+" desde telefono");
				 rs.close();
				 pstmt.close();
				 this.desconectarBD(con);
				//System.out.println(tel);
				 return tels;
			 }catch(SQLException e){
				 return tels;
			 }
	    	//System.out.println(referencia);
		    
		}
		
		public List<Object[]> obtenerClientes_Referecia() throws SQLException{	
			List<Object[]> lstClientes = null;	
			Connection con = null;	
			con = this.conectarBD();	
			Consultas consultas = new Consultas ();
			String Cliente_Referencia = consultas.obtenerClientes_Referencias();
			PreparedStatement pstmt = con.prepareStatement (Cliente_Referencia);
			//System.out.println(entradaNombre);
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
		public void nuevaEmpresa(long rut, String nombre, String contacto, String direccion) throws SQLException{
			// Ingresa una nueva actividad al sistema
			//System.out.println(rut);
				Connection con = this.conectarBD();	
				Consultas consultas = new Consultas();
				String insert = consultas.nuevaEmpresa();	
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(insert);
				pstmt.setLong(1, rut);
				pstmt.setString(2, nombre);
				pstmt.setString(3, contacto);
				pstmt.setString(4, direccion);
				pstmt.executeUpdate ();			
				pstmt.close();					
				this.desconectarBD(con);
			}
			
			
			public void nuevoTelefono( String tel, long referencia) throws SQLException{
			// Ingresa una nueva actividad al sistema
				Connection con = this.conectarBD();	
				Consultas consultas = new Consultas();
				String insert = consultas.nuevoCelTel();	
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(insert);
				pstmt.setLong(1, referencia);
				pstmt.setString(2, tel);
				pstmt.executeUpdate ();			
				pstmt.close();					
				this.desconectarBD(con);
			}
			
			public List<VOParticular> listarParticulares(){
				// devuelve un listado de los datos de los particulares		 
					Connection con = null;				
					con = this.conectarBD();
					VOParticular particular = null;
					List<VOParticular> lstParticulares = null;		
					// creo un Statement para listar todas las actividades 
					Statement stmt;
					try {
						stmt = con.createStatement();			
						Consultas consultas = new Consultas();
						String strParticulares = consultas.listarParticulares();
						ResultSet rs = stmt.executeQuery(strParticulares);					
						lstParticulares = new ArrayList<VOParticular>();			
						while (rs.next()) {
							int cedula = rs.getInt("cedula");
							String nombre = rs.getString("nombre");
							//System.out.println(nombre);
							String apellido = rs.getString("apellido");
							String direccion = rs.getString("dir");	
							//String telefono = "";
							Object[]	 telefono = obtenerTelXreferencia(cedula);
							particular = new VOParticular(cedula, nombre, apellido, direccion,(String) telefono[0],(String)telefono[1]);
							lstParticulares.add(particular);			
						}
						rs.close();
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					this.desconectarBD(con);
					return lstParticulares;
				} 
			public List<VOEmpresa> listarEmpresas(){
				// devuelve un listado de los datos de los particulares		 
					Connection con = null;				
					con = this.conectarBD();
					VOEmpresa empresa = null;
					List<VOEmpresa> lstEmpresas = null;		
					// creo un Statement para listar todas las actividades 
					Statement stmt;
					try {
						stmt = con.createStatement();			
						Consultas consultas = new Consultas();
						String strEmpresas = consultas.ListarEmpresas();
						ResultSet rs = stmt.executeQuery(strEmpresas);					
						lstEmpresas = new ArrayList<VOEmpresa>();			
						while (rs.next()) {
							long rut = rs.getLong("rut");
							String nombre = rs.getString("nombre");
							//System.out.println(nombre);
							String contacto = rs.getString("contacto");
							String direccion = rs.getString("direccion");	
							//String telefono = "";
							Object[]	 telefono = obtenerTelXreferencia(rut);
							//System.out.println(telefono[0]+" "+telefono[1]+" comprobacion ");
							empresa = new VOEmpresa(rut, nombre, contacto, direccion,(String) telefono[0],(String)telefono[1]);
							lstEmpresas.add(empresa);			
						}
						rs.close();
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					this.desconectarBD(con);
					return lstEmpresas;
				}
			public List<VOEmpleado> listarEmpleados(){
				// devuelve un listado de los datos de los particulares		 
					Connection con = null;				
					con = this.conectarBD();
					VOEmpleado empleado = null;
					List<VOEmpleado> lstEmpleados = null;		
					// creo un Statement para listar todas las actividades 
					Statement stmt;
					try {
						stmt = con.createStatement();			
						Consultas consultas = new Consultas();
						String strEmpleados = consultas.listarEmpleados();
						ResultSet rs = stmt.executeQuery(strEmpleados);					
						lstEmpleados = new ArrayList<VOEmpleado>();			
						while (rs.next()) {
							int cedula = rs.getInt("cedula");
							String nombre = rs.getString("nombre");
							//System.out.println("estoy");
							String apellido = rs.getString("apellido");
							String direccion = rs.getString("direccion");	
							//String telefono = "";
							Object[]	 telefono = obtenerTelXreferencia(cedula);
							//System.out.println(telefono[0]+" "+(String ) telefono[1]);
							empleado = new VOEmpleado(cedula, nombre, apellido, direccion, (String ) telefono[0],  (String ) telefono[1]);
							lstEmpleados.add(empleado);			
						}
						rs.close();
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					this.desconectarBD(con);
					return lstEmpleados;
				} 
			
			public List<VOCliente> ListarClientes(){
				// 	 
					Connection con = null;				
					con = this.conectarBD();
					VOCliente cliente = null;
					List<VOCliente> lstClientes = null;		
					// creo un Statement para listar todas las actividades 
					Statement stmt;
					try {
						stmt = con.createStatement();			
						Consultas consultas = new Consultas();
						String strClientes = consultas.Clientes_Dir_Ref();
						ResultSet rs = stmt.executeQuery(strClientes);					
						lstClientes = new ArrayList<VOCliente>();			
						while (rs.next()) {
							long referencia = rs.getLong("referencia");
							String nombre = rs.getString("nombre");
							//System.out.println(nombre);
							String dir = rs.getString("dir");	
							//String telefono = "";
							//System.out.println(telefono+"listado");
							Object[]	 telefono = obtenerTelXreferencia(referencia);
							cliente = new VOCliente(referencia, dir, (String)telefono[0], nombre);
							cliente.setTel2( (String)telefono[1]);
							lstClientes.add(cliente);			
						}
						rs.close();
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
					this.desconectarBD(con);
					return lstClientes;
				} 
			public List<VOCliente> ListarClientes_Dir_Tel_Ref(){	 
				Connection con = null;				
				con = this.conectarBD();
				List<VOCliente> lstCliente = null;		
				/*  */
				Statement stmt;
				try {
					stmt = con.createStatement();			
					Consultas consultas = new Consultas();
					String strTarea = consultas.Clientes_Dir_Ref_union_socios();
					ResultSet rs = stmt.executeQuery(strTarea);					
					lstCliente= new ArrayList<VOCliente>();		
					VOCliente Tarea;
					while (rs.next()) {
						long ref = rs.getLong("referencia");
						String dir = rs.getString("dir");
						String nombre = rs.getString("nombre");
						Object[]	 telefono = obtenerTelXreferencia(ref);
						//System.out.println(nombre);
						if(telefono[0]=="No ingresado" && telefono[1]=="No ingresado"){
							 Tarea =new VOCliente(ref, dir, "No ingresado", nombre);
							//System.out.println("No ingresado");
						}else{
							if(telefono[0]!="No ingresado" && telefono[1]=="No ingresado"){
								 Tarea =new VOCliente(ref, dir, (String ) telefono[0], nombre);
								//System.out.println((String ) telefono[0]);
							}else{
								if(telefono[0]=="No ingresado" && telefono[1]!="No ingresado"){
									 Tarea =new VOCliente(ref, dir, (String ) telefono[1], nombre);
									//System.out.println( (String ) telefono[1]);
								}else{
									 Tarea =new VOCliente(ref, dir, (String ) telefono[1]+" / "+telefono[0], nombre);
									//System.out.println( (String ) telefono[1]+"/"+telefono[0]);
								}
							}
						}
						//VOCliente Tarea =new VOCliente(ref, dir, (String ) telefono[0]+" / "+telefono[1], nombre);
						
						lstCliente.add(Tarea);			
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				this.desconectarBD(con);
				return lstCliente;
			}
			// Modificar Empleados
						public void Modificar_Empleado(String modi,int ced) throws SQLException{	
							Connection con = this.conectarBD();	
							Consultas consultas = new Consultas();
							String insert = consultas.ModificarEmpleados(modi);	
							PreparedStatement pstmt;
							pstmt = con.prepareStatement(insert);
							pstmt.setInt(1, ced);
							pstmt.executeUpdate ();			
							pstmt.close();					
							this.desconectarBD(con);
						}
						
						public void Modificar_Tarea(String modi,VOTarea tarea) throws SQLException{	
							Connection con = this.conectarBD();	
							Consultas consultas = new Consultas();
							String insert = consultas.actualizarTarea(modi);	
							PreparedStatement pstmt;
							pstmt = con.prepareStatement(insert);
							pstmt.setInt(1, (int) tarea.getEmpleado_cedula());
							pstmt.setString(2, (String) auxiliar.fechaSQL(tarea.getFecha()));
							pstmt.setInt(3, (int) tarea.getTrabajo());
							pstmt.executeUpdate ();			
							pstmt.close();					
							this.desconectarBD(con);
						}
						// Guardar los datos del nuevo empleado 
		public void nuevoEmpleado(String nombre, String apellido, String direccion, int cedula) throws SQLException{
			// Ingresa una nueva actividad al sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String insert = consultas.nuevoEmpleado();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, cedula);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setString(4, direccion);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		}
		
		///////////////////////////////////////////////// ivan 
		
		//Guardo los Trabajos y tareas
				public void nuevoTrabajo(long referencia,String fecha, int montoTotal, int cuotas,String encargado,String hora, String comentario,String estado) throws SQLException{
						// Ingresa una nueva actividad al sistema
						Connection con = this.conectarBD();	
						Consultas consultas = new Consultas();
						String insert = consultas.nuevoTrabajo();	
						PreparedStatement pstmt;
						pstmt = con.prepareStatement(insert);
						pstmt.setInt(1, cuotas);
						pstmt.setString(2, fecha);
						pstmt.setInt(3, montoTotal);
						pstmt.setString(4,estado);
						pstmt.setLong(5, referencia);
						pstmt.executeUpdate ();			
						pstmt.close();					
						this.desconectarBD(con);
						
						//Obtener id del ultimo trabajo
						Connection con1 = null;
						con1 =this.conectarBD();
						Consultas selecId = new Consultas();
						String strIdTrabajo= selecId.idUltimoTrabajo();
						PreparedStatement pstmt1 =con1.prepareStatement(strIdTrabajo);
						ResultSet rs1 = pstmt1.executeQuery();
						rs1.next();
						//recupero ultimo id de la tabla trabajos (incluido el registrado anteriormente)
						String ultimoId = rs1.getString(1);
						rs1.close();
						this.desconectarBD(con1);
						
						
						Connection con2 = null;
						con2 = this.conectarBD();
						Consultas guardarTarea = new Consultas();
						String conGuardarTarea = guardarTarea.nuevaTarea();
						PreparedStatement pstmtTarea;
						pstmtTarea = con2.prepareStatement(conGuardarTarea);
						pstmtTarea.setLong(1,referencia);
						pstmtTarea.setString(2,ultimoId);
						pstmtTarea.setString(3, fecha);
						pstmtTarea.setString(4, hora);
						pstmtTarea.setString(5, comentario);
						pstmtTarea.executeUpdate();
						pstmtTarea.close();
						this.desconectarBD(con2);
						
						System.out.println("ULTIMO ID"+ultimoId);
				}


			//Listado de Encargados/Empleados
					public List <VOEmpleado> listarEncargados(){
						Connection con = null;
						con = this.conectarBD();
						VOEmpleado encargado = null;
						List<VOEmpleado> lstEncargados=null;
						//creo un Statement para listar todos los Encargados
						Statement stmt ;
						try {
							stmt = con.createStatement();
							Consultas consultas = new Consultas();
							String strEncargados = consultas.ListarEncargados();
							ResultSet  rs = stmt.executeQuery(strEncargados);
							lstEncargados = new ArrayList<VOEmpleado>();
							while(rs.next()){
								encargado = new VOEmpleado(rs.getInt("cedula"),rs.getString("nombre"),"","","","");
								lstEncargados.add(encargado);
							}
							rs.close();
							stmt.close();
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.desconectarBD(con);
						return lstEncargados;
						}

		//listado Clientes union de Particular Empresas
					public List <VOParticularEmpresa> listarClientes(){
						Connection con = null;
						con = this.conectarBD();
						VOParticularEmpresa cliente = null;
						List<VOParticularEmpresa> lstClientes=null;
						//creo un Statement para listar todos los clientes
						Statement stmt ;
						try {
							stmt = con.createStatement();
							Consultas consultas = new Consultas();
							String strClientes = consultas.ListarParticularEmpresa();
							ResultSet  rs = stmt.executeQuery(strClientes);
							lstClientes = new ArrayList<VOParticularEmpresa>();
							while(rs.next()){
								cliente = new VOParticularEmpresa(rs.getLong("id"),rs.getString("cliente"));
								lstClientes.add(cliente);
							}
							rs.close();
							stmt.close();
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.desconectarBD(con);
						return lstClientes;
						
					}
					
					////////////////////////////////// ivan 25
					
					//VO Trabajos + particularEmpresa
					public List <VOTrabajosClientes> listarTrabajosClientes(){
						Connection con = null;
						con = this.conectarBD();
						VOTrabajosClientes trabajos = null;
						List<VOTrabajosClientes> lstTrabajos=null;
						//creo un Statement para listar todos los clientes
						Statement stmt ;
						try {
							stmt = con.createStatement();
							Consultas consultas = new Consultas();
							String strTrabajosClientes = consultas.ListarTrabajos();
							ResultSet  rs = stmt.executeQuery(strTrabajosClientes);
							lstTrabajos = new ArrayList<VOTrabajosClientes>();
							while(rs.next()){
								trabajos = new VOTrabajosClientes(rs.getInt("idTrabajos"),rs.getInt("cuotas_Totales"), rs.getString("fecha_inicio"), rs.getInt("monto_total"),rs.getString("estado"),rs.getString("referencia"),rs.getString("cliente"),rs.getLong("id"));
								lstTrabajos.add(trabajos);
							}

							rs.close();
							stmt.close();
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.desconectarBD(con);
						return lstTrabajos;
						
					}
					//***
					//Editar trabajos.
					public void editarTrabajo(int cuotas,String estado,float monto,long id) throws SQLException{
						Connection con = this.conectarBD();
						Consultas consultas = new Consultas();
						String update = consultas.editarTrabajos();
						PreparedStatement pstmt;
						pstmt = con.prepareStatement(update);
						pstmt.setInt(1,cuotas);
						pstmt.setString(2, estado);
						pstmt.setFloat(3, monto);
						pstmt.setLong(4, id);
						pstmt.executeUpdate();
						pstmt.close();
						this.desconectarBD(con);
					}
					//***
					//ver 1 trabajo en particular
					public VOUnTrabajo verTrabajo(int id){
						Connection con = null;
						con = this.conectarBD();
						VOUnTrabajo trabajo = null;
						//creo un Statement para listar todos los trabajos
						
						try {
							Consultas consultas = new Consultas();
							String strTrabajo = consultas.verTrabajo();
							PreparedStatement pstmt  = con.prepareStatement(strTrabajo);
							pstmt.setInt(1,id);
							ResultSet  rs = pstmt.executeQuery();
							rs.next();
							trabajo = new VOUnTrabajo(rs.getInt("idTrabajos"),rs.getInt("cuotas_totales"),rs.getFloat("monto_total"),rs.getLong("referencia"),rs.getString("fecha_inicio"),rs.getString("estado"));
							rs.close();
							pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.desconectarBD(con);
						return trabajo;
					}
					
					
}
