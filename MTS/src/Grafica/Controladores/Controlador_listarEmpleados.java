package Grafica.Controladores;

import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOEmpleado;
import Logica_Persistencia.Value_Object.VOParticular;

public class Controlador_listarEmpleados {
	public List<VOEmpleado> listarEmpleados() {
		//System.out.println("adfasdgdfga");
		Fachada a = new Fachada();
		return a.listarEmpleados();
	}
}
