package Grafica.Controladores;

public class Verificar_Tel {
	
	public static boolean noVacio(String tel){
		if(tel!="" && tel!=null){
			return true;
		}else{
			return false;
		}		
	}
	public static boolean isNumeric(String inputData) {
		  return inputData.matches("[-+]?\\d+(\\.\\d+)?");
		}
	
	public static String varTrim(String tel){
		String telefono=tel.trim();
		return telefono;
		
	}
	
	public static boolean veri(String tel){
		String letras = varTrim(tel);
		if(!noVacio(letras)){
			return false;
		}else{
			if(isNumeric(letras)){
				return true;
			}else{
				return false;
			}
		}	
	}
	//public static void main(String[] args){
		//String tel="";
		//System.out.print(veri(tel)+"");
		/*System.out.print(varTrim(tel)+"");
		System.out.print(isNumeric(varTrim(tel))+"");*/
		/*System.out.print(noVacio(tel)+"");*/	
	//}
}
