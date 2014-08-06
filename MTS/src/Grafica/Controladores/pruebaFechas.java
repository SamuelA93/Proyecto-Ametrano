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
		try { fecha = formatoDeFechaJAVA.parse(fechaJAVA);
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
	public boolean reciente(Date f1,Date f2){
		if (f1.after(f2)){
			return true;
		}else{
			return false;
		}
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
		
	}*/

}
