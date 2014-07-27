package Logica_Persistencia.Value_Object;

public class VOTareaParticular {

		public VOParticular particular = new VOParticular();
		public VOTarea tarea = new VOTarea();
		public void construir( 	String cedula,String nombre,String apellido,String direccion,String telefono, 
				String empleado_cedula,String encanombre, String trabajo, String fecha, String hora,String horas, String comentario){
			particular.setNombre(nombre);
			particular.setCedula(cedula);
			particular.setDireccion(direccion);
			particular.setTelefono(telefono);
			particular.setApellido(apellido);
			tarea.setFecha(fecha);
			tarea.setEmpleado_cedula(empleado_cedula);
			tarea.setHora(hora);
			tarea.setHoras(horas);
			tarea.setTrabajo(trabajo);
			tarea.setComentario(comentario);
			tarea.setEncanombre(encanombre);
		}
		
		
		
		
}
