package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Agregar_meses {
	
	public Controlador_Agregar_meses(){}
	
	
	public void agregar_Un_Mes(long ref, String fecha) throws SQLException{
		Fachada f = new Fachada();
		System.out.println("contrAgre");
		f.agregar_Un_Mes(ref, fecha);
	}
	public void agregar_dos_Mes(long ref, String fecha) throws SQLException{
		Fachada f = new Fachada();
		System.out.println("contrAgre");
		f.agregar_dos_Mes(ref, fecha);
	}
	public void agregar_tres_Mes(long ref, String fecha) throws SQLException{
		Fachada f = new Fachada();
		System.out.println("contrAgre");
		f.agregar_tres_Mes(ref, fecha);
	}
	public void agregar_anio_Mes(long ref, String fecha) throws SQLException{
		Fachada f = new Fachada();
		System.out.println("contrAgre");
		f.agregar_anio_Mes(ref, fecha);
	}
	public void agregar_x_Mes(long ref, String fecha,int x) throws SQLException{
		Fachada f = new Fachada();
		System.out.println("contrAgre");
		f.agregar_X_Mes(ref, fecha, x);
	}
	public void Nuevo_Socio(long ref) throws SQLException{
		Fachada f = new Fachada();
		f.NuevoSocio(ref);;
	}
	public void Cancelar(long ref, String fecha) throws SQLException{
		Fachada f = new Fachada();
		f.Cancelar(ref,fecha);
	}

}
