package Grafica.Controladores;

import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOTareaParticular;



public class Controlador_Tabla_Tareas_Particulares {
			
	public Controlador_Tabla_Tareas_Particulares(){}
	public List<VOTareaParticular> listarTareaParticular(){
		Fachada f = new Fachada();
		return f.listarTareaParticular();
	}
}
