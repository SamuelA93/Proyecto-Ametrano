package Logica_Persistencia.Value_Object;

import java.util.Date;

public class VOSocio_Fechas {
	
	
	private Date f1;
	private Date f2;
	public VOSocio_Fechas(){}
	public VOSocio_Fechas(Date f1, Date f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	public Date getF1() {
		return f1;
	}
	public void setF1(Date f1) {
		this.f1 = f1;
	}
	public Date getF2() {
		return f2;
	}
	public void setF2(Date f2) {
		this.f2 = f2;
	}

}
