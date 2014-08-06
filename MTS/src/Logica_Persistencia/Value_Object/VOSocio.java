package Logica_Persistencia.Value_Object;

import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import Grafica.Controladores.pruebaFechas;

public class VOSocio  {
	
	private List<VOSocio_Fechas> lista ;
	private long ref;
	public VOSocio(){
		
		
	}
	public VOSocio(List<VOSocio_Fechas> lista, long ref) {
		this.lista = lista;
		this.ref = ref;
	}
	public int Largo(){
		return lista.size();
	}
	
	
	public List<VOSocio_Fechas> getLista() {
		
		
		return lista;
	}
	public void setLista(List<VOSocio_Fechas> lista) {
		this.lista = lista;
	}
	public long getRef() {
		return ref;
	}
	public void setRef(long ref) {
		this.ref = ref;
	}
	
}
