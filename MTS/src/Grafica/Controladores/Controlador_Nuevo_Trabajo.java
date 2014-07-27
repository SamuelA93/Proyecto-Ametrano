package Grafica.Controladores;

import Logica_Persistencia.Fachada.Fachada;

public class Controlador_Nuevo_Trabajo {

	
	public void nuevoTrabajo(String cedulaRut,String fechaInicio, String montoTotal, String cuotas, String comentario){
		// transformo el tipo de datos de cuotas y cedula a integer
		int cuotasF= Integer.parseInt(cuotas);
		int montoTotalF= Integer.parseInt(montoTotal);

		//Si es en una cuota el estado del trabajo es finalizado si hay mas de una el estado es pendiente
		String estado;
		if(cuotasF==1){
			estado="Finalizado";
		}else{
			estado="Pendiente";
		}
		
		if(cedulaRut.trim().length()==12){
			//cadulaRut es Rut
			long cedulaRutF = Long.parseLong(cedulaRut);
			Fachada f = new Fachada();
			f.nuevoTrabajo(cedulaRutF,fechaInicio,montoTotalF,cuotasF,comentario,estado);
		}else{
			//cadulaRut es cedula
			Verificar_Ci a = new Verificar_Ci();
			String cedula = a.numeroCi(cedulaRut);
			long cedulaRutF = Long.parseLong(cedula);
			Fachada f = new Fachada();
			f.nuevoTrabajo(cedulaRutF,fechaInicio,montoTotalF,cuotasF,comentario,estado);
		}
	}
}