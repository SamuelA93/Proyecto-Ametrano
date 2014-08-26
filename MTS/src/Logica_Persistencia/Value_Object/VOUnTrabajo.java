package Logica_Persistencia.Value_Object;

public class VOUnTrabajo {
	private int id;
	private int cuotas;
	private float monto;
	private long referencia;
	private String fecha;
	private String estado;
	public VOUnTrabajo() {
		super();
	}
	public VOUnTrabajo(int id, int cuotas, float monto,long referencia, String fecha,String estado) {
		super();
		this.id = id;
		this.cuotas = cuotas;
		this.monto = monto;
		this.fecha = fecha;
		this.referencia = referencia;
		this.estado= estado;
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
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public long getReferencia() {
		return referencia;
	}
	public void setReferencia(long referencia) {
		this.referencia = referencia;
	}
	public String getestado() {
		return estado;
	}
	public void setestado(String estado) {
		this.estado = estado;
	}
	
}
