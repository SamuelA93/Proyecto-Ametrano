package Logica_Persistencia.Value_Object;

public class VOEmpresa {
	private long rut;
	private  String nombre ;
	private  String contacto;
	private  String direccion;
	private  String telefono;
	private  String telefono2;
	public VOEmpresa(){}
	public VOEmpresa(long rut, String nombre, String contacto, String direccion,
			String telefono,String telefono2) {
		this.rut = rut;
		this.nombre = nombre;
		this.contacto = contacto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.telefono2 = telefono2;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public long getRut() {
		return rut;
	}
	public void setRut(long rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
