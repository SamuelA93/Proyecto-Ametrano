package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Nueva_Tarea {
	
	public Controlador_Nueva_Tarea(){}
	
	public void nuevo(int trabajo, int encargado, String fecha, String hora, String comentario) throws SQLException{
		
		Fachada f = new Fachada();
		f.Nueva_Tarea(trabajo, encargado, fecha, hora, comentario);
		
	}

}
