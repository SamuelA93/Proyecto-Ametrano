package Grafica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOSocio;

public class Controlador_Socio {
	
	public Controlador_Socio(){}
	
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
	public void LitaSocios(long ref, int x ) throws SQLException{
		Fachada f = new Fachada();
		//System.out.println("contrAgre");
		f.LitaSocios(ref, x);
	}
	public void ActuaLizarSocios(long ref, int x ) throws SQLException{
		Fachada f = new Fachada();
		//System.out.println("contrAgre");
		f.ActuaLizarSocios(ref, x);
	}
	public ArrayList Socio_ref() throws SQLException{
		Fachada f = new Fachada();
		return f.Socios_Ref();
	}
	public long obtener_Existencia_de_Socio( long id) throws SQLException{
		Fachada f = new Fachada();
		return f.obtener_Existencia_de_Socio(id);
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
	
	public int registros(long ref) throws SQLException{
		
		Fachada f= new Fachada();
		return f.Socio_Cantidad_Reg(ref);
			
	}
	
	public VOSocio ObtenerFechas(long ref) throws SQLException{
		Fachada f= new Fachada();
		return f.Socio_Fechas(ref);
	}
	public void eliminarSocio(long identificacion) throws SQLException
	{
		Fachada f = new Fachada();
		f.eliminarSocio(identificacion);
	}
	public boolean esSocioAmadeo(long rut) throws SQLException
	{
		boolean salida;
		Fachada f = new Fachada();
		salida = f.esSocio(rut) ==rut;
		return (salida);
	}

}
