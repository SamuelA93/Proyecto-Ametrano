package Logica_Persistencia.Value_Object;

public class VOParticularEmpresa {
	private long id;
	private String cliente;
	
	public VOParticularEmpresa(){
		
	}
	
	public VOParticularEmpresa(long id,String cliente){
		this.id=id;
		this.cliente=cliente;
	}
	
	public void setId(long id){
		this.id=id;
	}
	public long getId(){
		return this.id;
	}
	public void setCliente(String cliente){
		this.cliente=cliente;
	}
	public String getCliente(){
		return this.cliente;
	}
	
}
