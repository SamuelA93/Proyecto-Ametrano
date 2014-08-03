package Grafica.Controladores;

public class Verificar_Existencia {
	
	public static boolean verificarExistencia(String dato){
		if(dato.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	public static boolean esNumero(String dato){
		return dato.matches("[-+]?\\d+(\\.\\d+)?");
	}
	
}