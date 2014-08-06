package Logica_Persistencia.Value_Object;

import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import Grafica.Controladores.pruebaFechas;

public class VOSocio  {
	
	private List<VOSocio_Fechas> lista ;
	private long ref;
	public VOSocio(){}
	public VOSocio(List<VOSocio_Fechas> lista, long ref) {
		this.lista = lista;
		this.ref = ref;
	}
	public int Largo(){
		Date cancelado;
		pruebaFechas aux = new pruebaFechas();
		cancelado= aux.dateJAVA("01/01/2000");
		if (lista.get(lista.size()).getF2().equals(cancelado)){
			return lista.size();
		}else{
			return lista.size()+1;
		}
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
