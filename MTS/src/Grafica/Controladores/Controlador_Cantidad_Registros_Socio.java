package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Cantidad_Registros_Socio {

	public Controlador_Cantidad_Registros_Socio(){}
	public int registros(long ref) throws SQLException{
		
		Fachada f= new Fachada();
		return f.Socio_Cantidad_Reg(ref);
			
	}
}
