package Grafica.Controladores;

public class Verificar_Ci {
	
public Verificar_Ci(){}
	
	private static boolean noVacio(String ci){
		if((ci != "") && (ci != null)&&( !ci.isEmpty() )){
			return largo(ci);
		}else{
			return false;
		}
	}
	private static boolean largo(String ci){
		if(ci.length()==9){
			return todoNumero(ci);
		}else{
			return false;
		}
	}
	private static boolean todoNumero(String ci){
		int i =0;
		while ( Character.isDigit(ci.charAt(i))&&(i<7)){
			i++;
		}
		if(i>6){
			return cuenta(ci);
		}else{
			return false;
		}
	}
	private static int ultimodigito(String ci){
		String letra= ""+ci.charAt(8);
		int last = Integer.parseInt(letra);
		return last;
	}
	private static boolean cuenta(String ci){
		int last=ultimodigito(ci);
		int[] num = {2,9,8,7,6,3,4};
		int sum=0;
		for(int i=0; i < 7; i++){
			sum = sum + num[i]*Integer.parseInt(""+ci.charAt(i));
		}
		return (sum+last)%10 == 0;
	}
	public static boolean verificar(String ci){
		return  noVacio(ci);
	}
	public static String numeroCi(String ci){
			return ci.substring(0,7);
	}
	/*  Testeando metodos desde la clase misma 
	public static void main(String[] args) {
		String ci = "4854911-1";
		System.out.println(numeroCi(ci));
	}
	*/
}
