package Grafica.Controladores;



import java.util.Calendar;
import java.util.GregorianCalendar;



public class Fecha {
	
	GregorianCalendar a = new GregorianCalendar();

	int year  = a.get(Calendar.YEAR);
	int month = a.get(Calendar.MONTH);
	int day   = a.get(Calendar.DAY_OF_MONTH);
	
	int hour    = a.get(Calendar.HOUR);
	int minutes = a.get(Calendar.MINUTE);
	int seconds = a.get(Calendar.SECOND);
	
	
	public int getSeconds(){
		return this.seconds;
	}
	public int getMinutes(){
		return this.minutes;
	}
	public int getHour(){
		return this.hour;
	}
	public int getDay(){
		return this.day;
	}
	public int getMonth(){
		return this.month;
	}
	public int getYear(){
		return this.year;
	}
	
	public boolean getBisiesto(){
		if(a.isLeapYear(getYear())){
			return true;
		}else{
			return false;
		}
	}
}
//La idea que que el select de los combobox  este en String y cada string tiene un numero
//ejemplo 3 12 1999
//serian 3 string separados que hay que juntarlos y ordenarlos para que se guarden en el formato de la base de datos
//
