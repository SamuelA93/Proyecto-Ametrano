package Grafica.Controladores;

import java.util.List;

import Logica_Persistencia.AccesoDB.AccesoDB;
import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOParticular;

public class Controlador_listarParticulares {
	
	public List<VOParticular> listarParticulares() {
		Fachada a = new Fachada();
		return a.listarParticulares();
	}
}
