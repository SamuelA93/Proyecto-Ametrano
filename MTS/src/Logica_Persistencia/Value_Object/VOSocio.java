package Logica_Persistencia.Value_Object;

import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import Grafica.Controladores.pruebaFechas;

public class VOSocio  {
	
	private List<VOSocio_Fechas> lista ;
	private long ref;
	pruebaFechas auxiliar = new pruebaFechas();
	pruebaFechas auxiliar2 = new pruebaFechas();
	public VOSocio(){
		
		
	}
	public VOSocio(List<VOSocio_Fechas> lista, long ref) {
		Date cancelado=auxiliar.dateJAVA("01/01/2000");
		Date pendiente=auxiliar2.dateJAVA("09/09/2009");
		if(lista.get(lista.size()-1).getF2().equals(cancelado)){
			this.lista = lista;
		}else{
			VOSocio_Fechas dato = new  VOSocio_Fechas();
			dato.setF1(lista.get(lista.size()-1).getF2());
			dato.setF2(pendiente);
			lista.add(dato);
			this.lista = lista;
		}
		
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
