package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Eliminar_Tarea {
	
	public Controlador_Eliminar_Tarea(){}
	public void eliminar (int trabajo, long l, String fecha) throws SQLException{
		
		Fachada eliminar = new Fachada();
		eliminar.EliminarTarea(trabajo, l, fecha);
		
	}

}
