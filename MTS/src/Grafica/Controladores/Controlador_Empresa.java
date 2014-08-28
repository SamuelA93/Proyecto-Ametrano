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
	
	public void actualizarEmpresa(String rutTexto, String nombreNuevo, String contactoNuevo, String direccionNueva, String telefonoi1, String telefonoi2, boolean socio, String telefonoViejo1, String telefonoViejo2){
		Fachada f= new Fachada();
		long ruti;
		ruti = Long.parseLong(rutTexto);
		
		f.actualizarEmpresa(ruti, nombreNuevo, contactoNuevo, direccionNueva, telefonoi1, telefonoi2, socio, telefonoViejo1, telefonoViejo2);
		
	}		

	public void borrarEmpresa(long unRut){
		Fachada f= new Fachada();
		f.borrarEmpresa(unRut);
	}	
	/*
	public void nuevaEmpresa(String rutTexto,String nombre, String contacto,String direccion, String telefono, String celular)
	{

		Verificar_Rut verificador = new Verificar_Rut();//Validar el rut antes de invocar el controlador
		
		
		//System.out.println(rutTexto);
		long rut = Long.parseLong(rutTexto);
		
		Fachada f = new Fachada();
		try {
			f.nuevaEmpresa(rut, nombre, contacto, direccion);
			f.nuevoTelefonoXRUT(telefono, rut);
			f.nuevoTelefonoXRUT(celular, rut);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
	public List<VOEmpresa> listarEmpresas() throws SQLException{
		Fachada f = new Fachada();
		return f.listarEmpresas();
	}	
	

	
}
