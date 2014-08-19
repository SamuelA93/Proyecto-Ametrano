package Logica_Persistencia.Fachada;

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
	
	public boolean getLeapYear(){
		if(a.isLeapYear(getYear())){
			return true;
		}else{
			return false;
		}
	}
}
