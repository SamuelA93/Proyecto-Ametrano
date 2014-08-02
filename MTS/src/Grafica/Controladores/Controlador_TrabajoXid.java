package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOTrabajo;

public class Controlador_TrabajoXid {
	
	public Controlador_TrabajoXid(){}
	
	public VOTrabajo obtenerTrabajoXid(int id) throws SQLException{
		
		Fachada a = new Fachada();
		return a.trabajoXid(id);
		
	}

}
