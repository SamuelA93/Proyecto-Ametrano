package Logica_Persistencia.Value_Object;

import java.util.Date;

public class VOTrabajo {
	private int id;
	private int cuotas;

	private float montoTotal;
	private String estado;
	
	private long referencia;
	public VOTrabajo(int id, int cuotas, float montoTotal,String estado, long referencia) {
		this.id = id;
		this.cuotas = cuotas;
	
		this.montoTotal = montoTotal;
		this.estado = estado;
		
		this.referencia = referencia;
	}
	public VOTrabajo() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
	public float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getReferencia() {
		return referencia;
	}
	public void setReferencia(long referencia) {
		this.referencia = referencia;
	}
	

}
