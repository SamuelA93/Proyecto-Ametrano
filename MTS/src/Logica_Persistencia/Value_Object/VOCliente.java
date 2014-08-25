package Logica_Persistencia.Value_Object;

public class VOCliente {
	
	private long referencia;
	private String dir;
	private String Tel;
	private String Tel2;
	private String nombre;
	public long getReferencia() {
		return referencia;
	}
	public void setReferencia(long referencia) {
		this.referencia = referencia;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	
	public String getTel2() {
		return Tel2;
	}
	public void setTel2(String tel) {
		Tel2 = tel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public VOCliente(long referencia, String dir, String tel, String nombre) {
		this.referencia = referencia;
		this.dir = dir;
		Tel = tel;
		this.nombre = nombre;
	}
	public VOCliente(){}
	

}
