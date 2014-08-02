package Logica_Persistencia.Value_Object;

public class VOEmpresa {
	private int rut;
	private  String nombre ;
	private  String contacto;
	private  String direccion;
	private  String telefono;
	public VOEmpresa(){}
	public VOEmpresa(int rut, String nombre, String contacto, String direccion,
			String telefono) {
		this.rut = rut;
		this.nombre = nombre;
		this.contacto = contacto;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
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
