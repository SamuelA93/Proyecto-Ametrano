package Logica_Persistencia.Fachada;
import java.sql.SQLException;
import java.util.List;














import Logica_Persistencia.AccesoDB.AccesoDB;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOSocio;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;
import Logica_Persistencia.Value_Object.VOTareaParticular;
import Logica_Persistencia.Value_Object.VOTrabajo;


public class Fachada {

	// Contructor por defecto
	public Fachada(){}
	
	// Envia los datos del Nuevo Particular al AccesoDB mediante un metodo adecuado
	public void nuevoParticular(String nombre, String apellido, String dir, String tel, int ci){
		AccesoDB a = new AccesoDB();
		try {
			a.nuevoParticular(nombre, apellido, dir, ci);
			//a.nuevoTelefono(tel, ci);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	public void nuevoTelefono( String tel, int referencia){
		AccesoDB a = new AccesoDB();
		try {
			a.nuevoTelefono(tel,referencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		public String empleadoXcedula(long id) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerEmpleadoXcedula(id);
		}
		public VOParticular particularXcedula(long cedula) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerParticularXcedula(cedula);
		}
		public VOEmpresa empresaXrut(long rut) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerEmpresaXrut(rut);
		}
		public List<Object[]> obtenerClientes_Nombre_Referencia(String entradaNombre,String entradareferencia) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerClientes_Referecia(entradaNombre, entradareferencia);
		}
		public List<Object[]> obtenerTrabajo_TituloXReferencia(long a2) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a. obtenerTrabajos_Referecia(a2);
		}
		
		public void nuevaEmpresa(long rut, String nombre, String contacto, String direccion) throws SQLException
		{
			AccesoDB a = new AccesoDB();
			a.nuevaEmpresa(rut, nombre, contacto, direccion);
			

		}
		
		public void nuevoTelefono( String tel, long referencia){
			AccesoDB a = new AccesoDB();
			try {
				a.nuevoTelefono(tel,referencia);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public List<VOParticular> listarParticulares(){
			AccesoDB a = new AccesoDB();
			return a.listarParticulares();
		}
		public List<VOCliente> listarClientes_Dir_Tel_Ref(){
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
		public void ModificarTel(String modi,String viejo , int ci) throws SQLException{
			AccesoDB a = new AccesoDB();
			//System.out.println("adfasdgdfga");
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
		public void NuevoSocio(long ref) throws SQLException{
			AccesoDB a = new AccesoDB();
			a.Nuevo_Socio(ref);
		}
		public void Cancelar(long ref,String fecha) throws SQLException{
			AccesoDB a = new AccesoDB();
			System.out.println("fach");
			a.Cancelar_Socio(ref, fecha);
			
		}
		
		
}
