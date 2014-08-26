package Logica_Persistencia.Value_Object;
///***
public class VOTrabajosClientes {
	private int idTrabajos;
	private int cuotasTotales;
	private String fecha;
	private int monto;
	private String estado;
	private String referencia;
	private String cliente;
	private long id;
	
	
	public VOTrabajosClientes(){};
	
	public VOTrabajosClientes(int idTrabajos, int cuotasTotales, String fecha,
			int monto, String estado, String referencia, String cliente, long id) {
		super();
		this.idTrabajos = idTrabajos;
		this.cuotasTotales = cuotasTotales;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
		this.referencia = referencia;
		this.cliente = cliente;
		this.id = id;
	}
	public int getIdTrabajos() {
		return idTrabajos;
	}
	public void setIdTrabajos(int idTrabajos) {
		this.idTrabajos = idTrabajos;
	}
	public int getCuotasTotales() {
		return cuotasTotales;
	}
	public void setCuotasTotales(int cuotasTotales) {
		this.cuotasTotales = cuotasTotales;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
