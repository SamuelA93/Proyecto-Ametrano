package Grafica.Controladores;

import java.sql.SQLException;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOTarea;

public class Controlador_Tarea {

		public Controlador_Tarea(){}
		
		public void eliminar (int trabajo, long l, String fecha) throws SQLException{
			
			Fachada eliminar = new Fachada();
			eliminar.EliminarTarea(trabajo, l, fecha);
			
		}
		
		public void nuevo(int trabajo, int encargado, String fecha, String hora, String comentario) throws SQLException{
			
			Fachada f = new Fachada();
			f.Nueva_Tarea(trabajo, encargado, fecha, hora, comentario);
			
		}
		
		public List<VOTarea> listarTareas(){
			Fachada f = new Fachada();
			return f.listarTareas();
		}
		
		public void ActualizarTarea(String modi, VOTarea tarea) throws SQLException{
			Fachada f = new Fachada();
			 f.ActualizarTarea(modi, tarea);
		}
}
