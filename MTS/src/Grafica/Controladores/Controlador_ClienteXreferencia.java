package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOEmpresa;
import Logica_Persistencia.Value_Object.VOParticular;

public class Controlador_ClienteXreferencia {
	
	public Controlador_ClienteXreferencia(){}
	
	public boolean esCedula(int referencia){
		String num = String.valueOf(referencia);
		if ( num.length()==7 ){
			return true;
		}else{
			return false;
		}
	}
	
	public VOParticular ParticularXcedula(int cedula) throws SQLException{
		Fachada obtener = new Fachada();
		return obtener.particularXcedula(cedula);
	}
	public VOEmpresa EmpresaXcedula(int cedula) throws SQLException{
		Fachada obtener = new Fachada();
		return obtener.empresaXrut(cedula);
	}

}
