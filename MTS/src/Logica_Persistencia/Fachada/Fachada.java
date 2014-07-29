package Logica_Persistencia.Fachada;
import java.sql.SQLException;
import java.util.List;







import Logica_Persistencia.AccesoDB.AccesoDB;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
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
		public String empleadoXcedula(int id) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerEmpleadoXcedula(id);
		}
		public VOParticular particularXcedula(int cedula) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerParticularXcedula(cedula);
		}
		public VOEmpresa empresaXrut(int rut) throws SQLException{
			AccesoDB a = new AccesoDB();
			return a.obtenerEmpresaXrut(rut);
		}
		
}
