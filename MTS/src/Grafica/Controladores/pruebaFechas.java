package Grafica.Controladores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class pruebaFechas {

	public  String fechaJAVA(String fechaSQL){
		SimpleDateFormat formatoDeFechaJAVA = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoDeFechaSQL = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha =null;
		try {

			 fecha = formatoDeFechaSQL.parse(fechaSQL);

			} catch (ParseException ex) {

			//ex.printStackTrace();
				return "No fecha";
			}
		String fecha2 = formatoDeFechaJAVA.format(fecha);
		return fecha2;
	}
	
	public  String fechaSQL(String fechaJAVA){
		SimpleDateFormat formatoDeFechaJAVA = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatoDeFechaSQL = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha =null;
		try {

			 fecha = formatoDeFechaJAVA.parse(fechaJAVA);

			} catch (ParseException ex) {

			//ex.printStackTrace();
				return "No fecha";
			}
		String fecha2 = formatoDeFechaSQL.format(fecha);
		return fecha2;
	}
	public  Date dateJAVA(String fechaJAVA){
		SimpleDateFormat formatoDeFechaJAVA = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha =null;
		try { 
			fecha = formatoDeFechaJAVA.parse(fechaJAVA);
			 return fecha;
			} catch (ParseException ex) {
			//ex.printStackTrace();
				return null;
			}
	} 
	public String fechaJAVAstring(Date fechaJAVA){
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		return formatoDeFecha.format(fechaJAVA);
		
	}
	public int reciente(Date f1,Date f2){
		return f1.compareTo(f2);
			
		
	}
	/*public String intervalo(String fecha){
		
		int i=0;
		while(i){
			}
		}*/
	public boolean esFecha(String fecha){
		try{
			Date fechDate= dateJAVA(fecha);
			String fech =fechaJAVAstring(fechDate); 
			/*if(fechDate.compareTo(dateJAVA("05/01/1980"))>=0){
				System.out.println("ok");
			}*/
			//return true;
		}catch(Exception e){
			return false;
		}
		return true;
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2014-08-05";
		String ss = "05/08/2014";
		System.out.println(fechaJAVA( s));
		System.out.println(fechaSQL( ss));
		/*Date now = new Date();
		DateFormat df =  DateFormat.getDateInstance();
		DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat df2 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG);
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);
		String s =  df.format(now);
		String s1 = df1.format(now);
		String s2 = df2.format(now);
		String s3 = df3.format(now);
		String s4 = df4.format(now);
		
		System.out.println("(Default) Hoy es:" + s);
		System.out.println("(SHORT)   Hoy es:" + s1);
		System.out.println("(MEDIUM)  Hoy es:" + s2);
		System.out.println("(LONG)    Hoy es:" + s3);
		System.out.println("(FULL)    Hoy es:" + s4);
		
		Calendar calendario = GregorianCalendar.getInstance();
		Date fecha = calendario.getTime();
		System.out.println(fecha);
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatoDeFecha.format(fecha));
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = "2007-12-25";
		SimpleDateFormat formatoDelTexto2 = new SimpleDateFormat("M");
		Date fecha2 = null;
		try {

		fecha2 = formatoDelTexto.parse(strFecha);

		} catch (ParseException ex) {

		ex.printStackTrace();

		}

		System.out.println(fecha2.toString()+" "+strFecha+" "+formatoDelTexto2.format(fecha2));
		
		Date date = new Date();
	//Caso 1: obtener la hora y salida por pantalla con formato:
	DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
	System.out.println("Hora: "+hourFormat.format(date));
	//Caso 2: obtener la fecha y salida por pantalla con formato:
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println("Fecha: "+dateFormat.format(date));
	//Caso 3: obtenerhora y fecha y salida por pantalla con formato:
	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	System.out.println("Hora y fecha: "+hourdateFormat.format(date));
		
	}*/
	public Date horaDate(String hora) throws ParseException{

		Date date ;
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		date= hourFormat.parse(hora); 
		
		return date;
		//System.out.println("Hora: "+hourFormat.format(date));
	}
	public String horaString(Date hora) throws ParseException{
		
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		return hourFormat.format(hora);
		
		//System.out.println("Hora: "+hourFormat.format(date));
	}
	public boolean esHora(String hora){
		
		try{
			Date ho = horaDate(hora);
			
			//System.out.println(horaString(ho));
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public String fechaActualDate(){
		Calendar calendario = GregorianCalendar.getInstance();
		Date fecha = calendario.getTime();
		
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println(formatoDeFecha.format(fecha));
		return formatoDeFecha.format(fecha);
	}
	public boolean validH(String fech){
		
		java.text.DateFormat df = java.text.DateFormat.getInstance(); 
		try { 
			//java.text.DateFormat formatter = java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT); 
			DateFormat hourFormat = new SimpleDateFormat("HH:mm");
			
			hourFormat.setLenient(false); 
			java.util.Date date = hourFormat.parse(fech); 
			return true;
		} catch (ParseException ex) { 
			
			javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
			mensaje.showMessageDialog(null, "La hora ingresada no es valida", "Atención!!!", mensaje.ERROR_MESSAGE); 
			return false;
		} 
		
		
	}
public boolean validF(String fech){
		
		java.text.DateFormat df = java.text.DateFormat.getInstance(); 
		try { 
			java.text.DateFormat formatter = java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT); 
			formatter.setLenient(false); 
			java.util.Date date = formatter.parse(fech); 
			return true;
		} catch (ParseException ex) { 
			
			javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
			mensaje.showMessageDialog(null, "La fecha ingresada no es valida", "Atención!!!", mensaje.ERROR_MESSAGE); 
			return false;
		}
	}
}
