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
		public void modificar_etapa(String etapa , long emple, int trabajo, String fecha) throws SQLException{
			Fachada f = new Fachada();
			
			
			f.CambiarEtapaDeTrarea(etapa ,emple,  trabajo, fecha);
		}
		public void nuevo(int trabajo, int encargado, String fecha, String hora, String comentario,String etapa) throws SQLException{
			
			Fachada f = new Fachada();
			f.Nueva_Tarea(trabajo, encargado, fecha, hora, comentario,etapa);
			
		}
		
		public List<VOTarea> listarTareas(){
			Fachada f = new Fachada();
			return f.listarTareas();
		}
		public void ActualizarTarea(String modi, VOTarea tarea) throws SQLException{
			Fachada f = new Fachada();
			 f.ActualizarTarea(modi, tarea);
		}
		public void Hecha_O_Cancelada_GENERAL(String etapa, long id) throws SQLException{
			Fachada f = new Fachada();
			 f.Hecha_O_Cancelada_GENERAL(etapa, id);
		}
}
