package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOSocio;

public class Controlador_Obtener_Fechas_Socio {
	
	public Controlador_Obtener_Fechas_Socio(){}
	public VOSocio ObtenerFechas(long ref) throws SQLException{
		Fachada f= new Fachada();
		return f.Socio_Fechas(ref);
	}

}
