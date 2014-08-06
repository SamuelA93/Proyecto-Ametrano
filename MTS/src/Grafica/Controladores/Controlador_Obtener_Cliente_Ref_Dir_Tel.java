package Grafica.Controladores;

import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOCliente;

public class Controlador_Obtener_Cliente_Ref_Dir_Tel {
	
	
	public Controlador_Obtener_Cliente_Ref_Dir_Tel (){}
	public List<VOCliente> obtenerLista(){
		
		Fachada a =new Fachada();
		return a.listarClientes_Dir_Tel_Ref();
		
		
	}
	

}
