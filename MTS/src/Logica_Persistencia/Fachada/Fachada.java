package Logica_Persistencia.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





















import Logica_Persistencia.AccesoDB.AccesoDB;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOParticularEmpresa;
import Logica_Persistencia.Value_Object.VOSocio;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;
import Logica_Persistencia.Value_Object.VOTrabajo;
import Logica_Persistencia.Value_Object.VOTrabajosClientes;
import Logica_Persistencia.Value_Object.VOUnTrabajo;


public class Fachada {

	// Contructor por defecto
	public Fachada(){}
	
	// Envia los datos del Nuevo Particular al AccesoDB mediante un metodo adecuado
	public void nuevoParticular(String nombre, String apellido, String dir, int ci) throws SQLException{
		AccesoDB a = new AccesoDB();
			a.nuevoParticular(nombre, apellido, dir, ci);
	}
	public void EliminarTelefono(String tel, long ci) throws SQLException{
		AccesoDB a = new AccesoDB();
		a.Eliminar_Telefono(tel, ci);
	}
	public int obtener_idTrabajo_X_ref( long ci) throws SQLException{
		AccesoDB a = new AccesoDB();
		return a.obtener_idTrabajo_X_ref(ci);
	}
	//
	/*public void nuevoTelefono( String tel, int referencia){
		AccesoDB a = new AccesoDB();
		try {
			a.nuevoTelefono(tel,referencia);
			System.out.println("alli");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public void nuevos_2_Telefonos( ArrayList tel, int referencia) throws SQLException{
		AccesoDB a = new AccesoDB();
		a.nuevos_2_Telefonos(tel, referencia);
	}
	public void Hecha_O_Cancelada_GENERAL(String etapa, long id) throws SQLException{
		AccesoDB a = new AccesoDB();
		a.Hecha_O_Cancelada_GENERAL(etapa, id);
	}
	
	public void LitaSocios(long ref, int x ) throws SQLException{
		AccesoDB a = new AccesoDB();
		a.LitaSocios(ref, x);
	}
	public long obtener_Existencia_de_Socio( long id) throws SQLException{
		AccesoDB a = new AccesoDB();
		return a.obtener_Existencia_de_Socio(id);
	}
	//Envia los datos nuevo trabajo a AccesoDB
		public void nuevoTrabajo(long cedulaRut1, String fechaInicio, int montoTotal, int cuotas, String comentario, String estado){
			AccesoDB a = new AccesoDB();
			try {
				a.nuevoTrabajo(cedulaRut1, fechaInicio, montoTotal, cuotas, comentario, estado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public List<VOTarea> listarTareas(){
			AccesoDB a = new AccesoDB();
			return a.ListarTareas();
		}
		
		public VOTrabajo trabajoXid(int id) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerTrabajoXid(id);
		}
		public List<VOEmpresa> ListarEmpresas() throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.listarEmpresas();
		}
		public List<VOTrabajo> listar_Trabajos() throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.Listar_Trabajos();
		}
		public String empleadoXcedula(long id) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerEmpleadoXcedula(id);
		}
		
		public ArrayList Socios_Ref() throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.Socios_ref();
		}
		public VOParticular particularXcedula(long cedula) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerParticularXcedula(cedula);
		}
		public VOEmpresa empresaXrut(long rut) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerEmpresaXrut(rut);
		}
		public List<Object[]> obtenerClientes_Nombre_Referencia() throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerClientes_Referecia();
		}
		public List<Object[]> obtenerTrabajo_TituloXReferencia(long a2) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a. obtenerTrabajos_Referecia(a2);
		}
		public List<VOCliente> ListarClientes(){
			AccesoDB a = new AccesoDB();
			return a.ListarClientes();
		}
		public void nuevaEmpresa(long rut, String nombre, String contacto, String direccion) throws SQLException
		{
			AccesoDB a = new AccesoDB();
			a.nuevaEmpresa(rut, nombre, contacto, direccion);
			

		}
		
		public void nuevoTelefono( String tel, long referencia) throws SQLException{
			AccesoDB a = new AccesoDB();
			a.nuevoTelefono(tel,referencia);
		}
		
		public List<VOParticular> listarParticulares(){
			AccesoDB a = new AccesoDB();
			return a.listarParticulares();
		}
		public List<VOCliente> listarClientes_Dir_Tel_Ref(){
			AccesoDB a = new AccesoDB();
			return a.ListarClientes_Dir_Tel_Ref();
		}
		public List<VOCliente> listarClientes_Dir_Tel_Ref2(){
			AccesoDB a = new AccesoDB();
			return a.ListarClientes_Dir_Tel_Ref();
		}
		public List<VOEmpleado> listarEmpleados(){
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			return a.listarEmpleados();
		}
		public void ModificarParticular(String modi,long l) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			a.Modificar_Particular( modi,l);
		}
		public void ActuaLizarSocios(long ref, int x ) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			a.ActuaLizarSocios( ref,x);
		}
		public void Eliminar_Particular(int ref) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			a.Eliminar_Particular( ref);
		}
		public void ModificarTel(String modi,String viejo , int ci) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("aca");
			a.Modificar_Tel( modi,viejo,ci);
		}
		public VOSocio Socio_Fechas(long ref) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			return a.obtenerSocioX_Ref(ref);
		}
		public void agregar_Un_Mes(long ref,String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Socio_Un_Mes_Mas(ref, fecha);
			
		}
		public void agregar_dos_Mes(long ref,String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Socio_dos_Mes_Mas(ref, fecha);
			
		}
		public void agregar_tres_Mes(long ref,String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Socio_tres_Mes_Mas(ref, fecha);	
		}
		public void agregar_anio_Mes(long ref,String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Socio_Anio_Mes_Mas(ref, fecha);	
		}
		public void agregar_X_Mes(long ref,String fecha,int x) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Socio_x_Mes_Mas(ref, fecha,x);
		}
		public void NuevoSocio(long ref) throws SQLException{
			AccesoDB a = new AccesoDB();
			a.Nuevo_Socio(ref);
		}
		public void Cancelar(long ref,String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Cancelar_Socio(ref, fecha);
			
		}
		
		public void Nueva_Tarea(int trabajo, int encargado, String fecha, String hora, String comentario,String etapa) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.nuevaTarea(trabajo, encargado, fecha, hora, comentario,etapa);
			
		}
		public void EliminarTarea(int trabajo, long l, String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Eliminar_Tarea(trabajo, l, fecha);
			
		}
		
		public void ModificarEmpleado(String modi,int ced) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			a.Modificar_Empleado( modi,ced);
		}
		
		public int Socio_Cantidad_Reg(long ref) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
			return a.obtenerCantiadXref_Socio(ref);
		}
		// Envia los datos del Nuevo Empleado al AccesoDB mediante un metodo adecuado
		public void nuevoEmpleado(String nombre, String apellido, String direccion, int cedula) throws SQLException{
			AccesoDB a = new AccesoDB();
			a.nuevoEmpleado(nombre, apellido, direccion, cedula);
			//a.nuevoTelefono(telefono, cedula);
		}
		
		public void ActualizarTarea(String modi, VOTarea tarea) throws SQLException{
			AccesoDB a = new AccesoDB();
			a.Modificar_Tarea(modi, tarea);
			//a.nuevoTelefono(telefono, cedula);
		}
				
	///////////////////////////// ivan 
				
		//Envia los datos nuevo trabajo a AccesoDB
		public void nuevoTrabajo(long cliente, String fecha, int montoTotal, int cuotas,String encargado,String hora, String comentario, String estado){
			AccesoDB a = new AccesoDB();
			try {
				a.nuevoTrabajo(cliente,fecha,montoTotal,cuotas,encargado,hora,comentario,estado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//lista cliente Empresa/particular
		public List<VOParticularEmpresa> listarClientes(){
			AccesoDB a = new AccesoDB();
			return a.listarClientes();
		}
		//listar Encargados
		public List<VOEmpleado> listarEncargados(){
			AccesoDB a =  new AccesoDB();
			return a.listarEncargados();
		}
		public void CambiarEtapaDeTrarea(String etapa , long emple, int trabajo, String fecha) throws SQLException{
			AccesoDB a =  new AccesoDB();
			 a.CambiarEtapaDeTrarea( etapa , emple, trabajo,  fecha);
		}
		///////////////////////////////  ivan 25
		
		//listar Trabajos de Clientes ***
				public  List<VOTrabajosClientes> listarTrabajosClientes(){
					AccesoDB a = new AccesoDB();
					return a.listarTrabajosClientes();
				}
				//***
				public void editarTrabajo(int cuotas,String estado,long id,float monto) throws SQLException{
					AccesoDB a =new AccesoDB();
					a.editarTrabajo(cuotas, estado, monto,id);
				}
				//***
				public VOUnTrabajo verTrabajo(int id){
					AccesoDB a = new  AccesoDB();
					return a.verTrabajo(id);
				}
				
				
				
////////////////////////////////////////////////////////AMADEO////////////////////////
public void actualizarEmpresa(long ruti, String nombreNuevo, String contactoNuevo, String direccionNueva, String telefonoi1, String telefonoi2, boolean socio, String telefonoViejo1, String telefonoViejo2)
{
AccesoDB a = new AccesoDB();
try
{
a.actualizarEmpresa(ruti, nombreNuevo, contactoNuevo, direccionNueva, telefonoi1);
a.Modificar_Tel_long(telefonoi1, telefonoViejo1, ruti);
a.Modificar_Tel_long(telefonoi2, telefonoViejo2, ruti);
}catch(SQLException e)
{
e.printStackTrace();
}

}

public void borrarEmpresa(long unRut)
{
AccesoDB a = new AccesoDB();
try
{
a.borrarEmpresa(unRut);
}catch(SQLException e)
{
e.printStackTrace();
}
}

//
public void nuevoTelefonoXRUT( String tel, long rut){
AccesoDB a = new AccesoDB();
try {
a.nuevoTelefonoXRUT(tel,rut);
//System.out.println("alli");
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}




public List<VOEmpresa> listarEmpresas() throws SQLException {
AccesoDB a = new AccesoDB();
return a.ListarEmpresas();
}


public void eliminarSocio(long identificacion) throws SQLException {
AccesoDB a = new AccesoDB();
a.eliminarSocio(identificacion);

}

public long esSocio(long identificacion) throws SQLException{
AccesoDB a = new AccesoDB();
//System.out.println(a.esSocio(identificacion)+"Este es el print de la fachada.");
return a.esSocio(identificacion);
}
		
				
}
