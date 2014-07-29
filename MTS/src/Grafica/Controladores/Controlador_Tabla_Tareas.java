package Grafica.Controladores;

import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOTarea;
import Logica_Persistencia.Value_Object.VOTareaParticular;



public class Controlador_Tabla_Tareas {
			
	public Controlador_Tabla_Tareas(){}
	public List<VOTarea> listarTareas(){
		Fachada f = new Fachada();
		return f.listarTareas();
	}
}
