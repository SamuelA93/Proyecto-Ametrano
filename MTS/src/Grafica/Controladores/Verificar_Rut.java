package Grafica.Controladores;

public class Verificar_Rut {
	
	//Verifico si esta vacio el campo
	public static boolean verificarRut(String rut){
		//compruebo que no este vacio
		if(rut.isEmpty()){
			return false;
		}else{
			rut=eliminarEspacios(rut);
			if(esNumero(rut) && tamano(rut)){
				return true;
			}else{
				return false;
			}
		}
	}
	
	//Elimino espacios
	public static String eliminarEspacios(String rut){
		return rut.trim();
	}
	
	//Verifico si es numerico
	public static boolean esNumero(String rut) {
		  return rut.matches("[-+]?\\d+(\\.\\d+)?");
	}
	//Verifico el tamano
	public static boolean tamano(String rut){
		if(rut.length()==12){
			return true;
		}else{
			return false;
		}
	}
}