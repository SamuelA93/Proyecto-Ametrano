package Grafica.Controladores;

import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOTareaEmpresa;


public class Controlador_Tabla_Tareas_Empresas {
	
	
	
	public Controlador_Tabla_Tareas_Empresas(){}
	public List<VOTareaEmpresa> listarTareaEmpresa(){
		Fachada f = new Fachada();
		return f.listarTareaEmpresa();
	}

}
