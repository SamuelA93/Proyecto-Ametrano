package Logica_Persistencia.Value_Object;

public class VOTarea {
	private int empleado_cedula;
	private int trabajo;
	private String fecha;
	private String encanombre;
	private String hora;
	private String horas;
	private String comentario;
	public VOTarea(){}
	public VOTarea(int empleado_cedula, int trabajo, String fecha, String hora,
			String horas, String comentario) {
		this.empleado_cedula = empleado_cedula;
		this.trabajo = trabajo;
		this.fecha = fecha;
		this.hora = hora;
		this.horas = horas;
		this.comentario = comentario;
	}
	public int getEmpleado_cedula() {
		return empleado_cedula;
	}
	public void setEmpleado_cedula(int empleado_cedula) {
		this.empleado_cedula = empleado_cedula;
	}
	public int getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}
	
	public String getEncanombre() {
		return encanombre;
	}
	public void setEncanombre(String encanombre) {
		this.encanombre = encanombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
