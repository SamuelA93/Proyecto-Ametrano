package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Nueva_Empresa {

	

		// transformo el tipo de datos de cuotas y cedula a integer
	public Verificar_Rut verificador = new Verificar_Rut();
	public void nuevaEmpresa(String rutTexto,String nombre, String contacto,String direccion, String telefono, String celular)
	{
		//System.out.println(rutTexto);
		long rut = Long.parseLong(rutTexto);
		
		Fachada f = new Fachada();
		try {
			f.nuevaEmpresa(rut, nombre, contacto, direccion);
			f.nuevoTelefono(telefono, rut);
			f.nuevoTelefono(celular, rut);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

		
		//Si es en una cuota el estado del trabajo es finalizado si hay mas de una el estado es pendiente
			
	
}