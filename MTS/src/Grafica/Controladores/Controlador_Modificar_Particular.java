package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Modificar_Particular {
	
	public Controlador_Modificar_Particular(){}
	
	
	public void modificar (String modi,long l) throws SQLException{
		Fachada a = new Fachada();
		a.ModificarParticular(modi,l);
	}
}
