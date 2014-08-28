package Grafica.Controladores;

import java.sql.SQLException;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOCliente;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;
import Logica_Persistencia.Value_Object.VOTrabajosClientes;

public class Controlador_Cliente {

	public Controlador_Cliente(){}
	
	///////////////////////  
	public boolean esCedula(long referencia){
		String num = String.valueOf(referencia);
		if ( num.length()==7 ){
			return true;
		}else{
			return false;
		}
	}
	
	///////////////////////   devuelve un particular identificado por la cedula
	public VOParticular ParticularXcedula(long cedula) throws SQLException{
		Fachada obtener = new Fachada();
		return obtener.particularXcedula(cedula);
	}
	
	////////////////////// 
	public VOEmpresa EmpresaXrut(long cedula) throws SQLException{
		Fachada obtener = new Fachada();
		return obtener.empresaXrut(cedula);
	}
	
	//////////////////////   devuelve una lisat de VOCliente 
	public List<VOCliente> ListarClientes()throws SQLException{
		Fachada obtener = new Fachada();
		return obtener.ListarClientes();
	}
	//////////////////////
	public List<VOCliente> obtenerListaSocios() throws SQLException{
		Fachada a =new Fachada();
		return a.listarClientes_Dir_Tel_Ref();	
	}
	
	public List<VOCliente> obtenerListaSocios2() throws SQLException{
		Fachada a =new Fachada();
		return a.listarClientes_Dir_Tel_Ref();	
	}
	///////////////////// devuelve una lista de objetos con nombre y referencia
	public List<Object[]> obtenerClientes() throws SQLException{
		Fachada f =new Fachada();
		return f.obtenerClientes_Nombre_Referencia();
	}
	
	////////////////////// ivan 25
	
	public List<VOTrabajosClientes> listarTrabajosClientes(){
		Fachada f = new Fachada();
		return f.listarTrabajosClientes();
	}
}
