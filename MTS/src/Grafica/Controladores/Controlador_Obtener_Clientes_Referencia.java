package Grafica.Controladores;

import java.sql.SQLException;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Obtener_Clientes_Referencia {
	
	public Controlador_Obtener_Clientes_Referencia(){}
	public List<Object[]> obtenerClientes(String entradaNombre, String entradareferencia) throws SQLException{
		Fachada f =new Fachada();
		return f.obtenerClientes_Nombre_Referencia(entradaNombre, entradareferencia);
		
	}

}
