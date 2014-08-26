package Grafica.Controladores;

import java.sql.SQLException;
import java.util.List;

import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Empresa {
	
	public Controlador_Empresa(){}
	
	// transformo el tipo de datos de cuotas y cedula a integer
	public Verificar_Rut verificador = new Verificar_Rut();
	public void nuevaEmpresa(String rutTexto,String nombre, String contacto,String direccion, String telefono, String celular)throws SQLException
	{
		//System.out.println(rutTexto);
				long rut = Long.parseLong(rutTexto);
				//////////// Aca solo modifique esto////////////////
				Fachada f = new Fachada();
				f.nuevaEmpresa(rut, nombre, contacto, direccion);
				
				if(!telefono.equals("")){
					f.nuevoTelefono(telefono, rut);
				}
				if(!celular.equals("")){
					f.nuevoTelefono(celular, rut);
				}
				///////////////////////////
		
	}
	public List<VOEmpresa> Listar_Empresas() throws SQLException{
		Fachada f = new Fachada();
		return f.ListarEmpresas();
	}
	///////////////////////
	
	

	
}
