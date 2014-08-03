package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Modificar_Tel {

	
public Controlador_Modificar_Tel(){}
	
	
	public void modificar (String modi,String viejo,int ci) throws SQLException{
		Fachada a = new Fachada();
		if( viejo== "No igresado"){
			a.nuevoTelefono(modi, ci);
		}else{
			a.ModificarTel(modi,viejo,ci);
		}
		
	}
}
