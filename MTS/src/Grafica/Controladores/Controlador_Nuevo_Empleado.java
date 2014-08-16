package Grafica.Controladores;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Nuevo_Empleado {
	
	// Intancio el verificador de la Ci para usarlo desde la Ventana Nuevo_Empleado
	public Verificar_Ci verificar = new Verificar_Ci();
	public Verificar_Tel verificarT = new Verificar_Tel();
	// Envia los datos a la fachada 
	public void nuevoEmpleado(String nombre, String apellido, String direccion, String telefono, String cedula, String celu){
		int ced = Integer.parseInt(cedula);
		Fachada f= new Fachada();
		/*System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(direccion);
		System.out.println(telefono);
		System.out.println(cedula);
		System.out.println(celu);*/

		/*f.nuevoEmpleado(nombre, apellido, direccion, telefono , ced);
		f.nuevoTelefono(telefono, ced );
		f.nuevoTelefono(celu, ced );*/
		try {
			
			//f.nuevoEmpleado(nombre, apellido, direccion, telefono , ced);
			f.nuevoTelefono("6666", 6666 );
			f.nuevoTelefono("5555", 6666 );
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
}
