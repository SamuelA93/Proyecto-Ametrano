package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Telefonos {
	
	public Controlador_Telefonos(){}
	
	public void modificar (String modi,String viejo,int ci) throws SQLException{
		Fachada a = new Fachada();
		String s = "No ingresado";
		if( viejo.toUpperCase().equals(s.toUpperCase())){
			a.nuevoTelefono(modi, ci);
		}else{
			a.ModificarTel(modi,viejo,ci);
			//System.out.println(modi+" "+viejo);
		}
	}
	
	public void EliminarNumero(String tel,int ci) throws SQLException{
		Fachada a = new Fachada();
		a.EliminarTelefono(tel, ci);
	}

}
