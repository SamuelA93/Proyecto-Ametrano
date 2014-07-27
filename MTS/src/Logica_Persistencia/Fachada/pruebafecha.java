package Logica_Persistencia.Fachada;

import java.sql.SQLException;
import java.util.Date;

import Logica_Persistencia.AccesoDB.AccesoDB;

public class pruebafecha {
	
	public static String sacarFecha(int id)throws SQLException{
		AccesoDB a = new AccesoDB();
		String fecha = a.obtenerFecha(id);
		return fecha;
	}
	public static String ordenarFecha(String fecha){
		int i=0;
		String anio,dia,mes;
		anio= (String) fecha.subSequence(0,4);
		dia= (String) fecha.subSequence(8, 10);
		mes= (String) fecha.subSequence(5, 7);
		return dia+'/'+mes+'/'+anio;
	}
	public static void main(String[] args) throws SQLException{
		int id = 1;
		
		
		System.out.println(sacarFecha( id));
		//System.out.println(ordenarFecha( sacarFecha( id)));
		
		
		
	}

}
