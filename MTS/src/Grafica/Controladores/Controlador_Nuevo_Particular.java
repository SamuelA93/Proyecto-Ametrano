package Grafica.Controladores;

import java.sql.SQLException;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Nuevo_Particular {
	
	// Intancio el verificador de la Ci para usarlo desde la Ventana Nuevo_Particular
	public Verificar_Ci verificar = new Verificar_Ci();
	public Verificar_Tel verificarT = new Verificar_Tel();
	// Envia los datos a la fachada 
	public void nuevoParticular(String nombre, String apellido, String dir, String tel, String ci,String celu){
		int cedula = Integer.parseInt(ci);
		Fachada f= new Fachada();
		f.nuevoParticular(nombre, apellido, dir, tel , cedula);
		try {
			f.nuevoTelefono(tel, cedula );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			f.nuevoTelefono(celu, cedula );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
