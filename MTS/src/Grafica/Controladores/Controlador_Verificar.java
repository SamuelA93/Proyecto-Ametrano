package Grafica.Controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador_Verificar {

	public Controlador_Verificar(){}
	
	//////////////// retorna  true si una variable String es "  " o es solo letras 
	public boolean SoloString_O_Espacios(String texto){
		
	    if (Pattern.matches("[[a-zA-Z]|\\s]+",texto.trim()) || Pattern.matches("\\s",texto.trim())) {
			return true;
		}else{
			return false;
		} 
	}
	public static boolean espacios(String texto){
		Pattern pat = Pattern.compile(" *");
		Matcher mat = pat.matcher(texto.trim());
		if (mat.matches()) {
			return true;
		}else{
			return false;
		}	
	}
	//////////////// retorna  true si una variable String  es solo letras 
	public boolean SoloString(String texto){
		Pattern pat = Pattern.compile("[a-zA-Z]+");
		Matcher mat = pat.matcher(texto.trim());
		if (mat.matches()) {
			return true;
		}else{
			return false;
		} 
	}
	
	////////////////  retorna true si una variable String es "   " o es solo numeros 
	public boolean SoloNumeros_O_Espacios(String texto){
		
		if (Pattern.matches("[0-9]+",texto.trim()) || Pattern.matches("\\s",texto.trim())) {
			return true;
		}else{
			return false;
		} 
	}
	
	////////////////  retorna true si una variable String es solo numeros 
	public boolean SoloNumeros(String texto){
		Pattern pat = Pattern.compile("[0-9]+");
		Matcher mat = pat.matcher(texto.trim());
		if (mat.matches()) {
			return true;
		}else{
			return false;
		} 
	}
	
	/////////////////
	
	public static boolean esNumero(String dato){
		return dato.matches("[-+]?\\d+(\\.\\d+)?");
	}
	
	///////////////
	
	public static boolean verificarExistencia(String dato){
		if(dato.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
/*	public static void main(String[] args) {
		String d = "";
		/*if (Pattern.matches("[[a-zA-Z]|\\s]+",d.trim()) || Pattern.matches("\\s",d.trim())) {
			System.out.println("1");
		}else{
			System.out.println("2");
		}
		System.out.println(espacios(d));
	}*/
	
}
