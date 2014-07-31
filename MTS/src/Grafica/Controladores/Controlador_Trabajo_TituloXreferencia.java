package Grafica.Controladores;

import java.sql.SQLException;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Trabajo_TituloXreferencia {
	
	public Controlador_Trabajo_TituloXreferencia(){}
	
	public List<Object[]> obtener_TrabajoId_Titulo(long a) throws SQLException{
		Fachada f =new Fachada();
		return f.obtenerTrabajo_TituloXReferencia(a);
	}
}
