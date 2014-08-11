package Grafica.Controladores;

import java.sql.SQLException;
import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Modificar_Empleado {
	
	public Controlador_Modificar_Empleado(){}
	
	public void modificar (String modi,int ced) throws SQLException{
		Fachada a = new Fachada();
		a.ModificarEmpleado(modi,ced);
	}

		
}
