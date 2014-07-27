package Logica_Persistencia.Value_Object;

import java.util.Date;

public class VOTrabajo {
	private int id;
	private int cuotas;
	private Date fechaInicio;
	private float montoTotal;
	private String estado;
	private String comentario;
	private int referencia;
	public VOTrabajo(int id, int cuotas, Date fechaInicio, float montoTotal,
			String estado, String comentario, int referencia) {
		this.id = id;
		this.cuotas = cuotas;
		this.fechaInicio = fechaInicio;
		this.montoTotal = montoTotal;
		this.estado = estado;
		this.comentario = comentario;
		this.referencia = referencia;
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	

}
