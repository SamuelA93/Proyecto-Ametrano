package Grafica.Controladores;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOParticularEmpresa;
import Logica_Persistencia.Value_Object.VOTrabajo;

public class Controlador_Trabajo {
	
	public Controlador_Trabajo(){}
	
	//////////////////////
	/*public void nuevoTrabajo(String cliente,String fecha, String montoTotal, String cuotas,String encargado,String hora, String comentario,String estado){

		Fachada f = new Fachada();
		long clienteT= Long.valueOf( cliente).longValue();
		int montoTotalT = Integer.parseInt(montoTotal);
		int cuotasT = Integer.parseInt(cuotas);
		f.nuevoTrabajo(clienteT,fecha,montoTotalT,cuotasT,encargado,hora,comentario,estado);
	
	}*/
	
	////////////////////
	
	public List<VOParticularEmpresa> listarClientes(){
		Fachada f = new Fachada();
		return f.listarClientes();
	}
	
	//////////////////////
	public List<VOEmpleado> listarEncargados(){
		Fachada f = new Fachada();
		return f.listarEncargados();
	}
	
	/////////////////////
	
	public void nuevoTrabajo(long cedulaRut,String fechaInicio, String montoTotal, String cuotas, String comentario) throws SQLException{
		// transformo el tipo de datos de cuotas y cedula a integer
		int cuotasF= Integer.parseInt(cuotas);
		int montoTotalF= Integer.parseInt(montoTotal);
		
		Fachada f = new Fachada();
		f.nuevoTrabajo(cedulaRut,fechaInicio,montoTotalF,cuotasF,comentario,"Activo");
	}
	
	/////////////////////
	
	public int obtener_idTrabajo_X_ref(long cedulaRut) throws SQLException{
		Fachada f = new Fachada();
		return f.obtener_idTrabajo_X_ref(cedulaRut);
	}
	
	////////////////////
	
	public List<Object[]> obtener_TrabajoId_Titulo(long a) throws SQLException{
		Fachada f =new Fachada();
		return f.obtenerTrabajo_TituloXReferencia(a);
	}
	
	//////////////////////
	
	public VOTrabajo obtenerTrabajoXid(int id) throws SQLException{
		Fachada a = new Fachada();
		return a.trabajoXid(id);
	}
}
