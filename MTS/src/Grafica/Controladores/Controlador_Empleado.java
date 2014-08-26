package Grafica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOEmpleado;

public class Controlador_Empleado {
	
	public Controlador_Empleado(){}
	
	//////////////////  Modificar los Datos de un Empleado identificado por Integer => cedula
	public void modificar(String modi,int ced) throws SQLException{
		Fachada a = new Fachada();
		a.ModificarEmpleado(modi,ced);
	}
	
	/////////////////   Listar todos los datos de los Empleados en una lista compuesta de  VOEmpleado
	public List<VOEmpleado> listarEmpleados() throws SQLException{
		
		Fachada a = new Fachada();
		return a.listarEmpleados();
	}
	
	////////////////    Agregar nuevo Empleado a la DataBase
	public void nuevoEmpleado(String nombre, String apellido, String direccion, String cedula, ArrayList telefonos) throws SQLException{
		int ced = Integer.parseInt(cedula);
		Fachada f= new Fachada();
		//////  Si da error f.nuevoEmpleado() no sigue ejecutando codigo 
		f.nuevoEmpleado(nombre, apellido, direccion,ced);
		/////   Controlos si se ingreso algun telefono
		if (!(telefonos.isEmpty()) ) {
		/////   Controlos si se ingreso 1 o 2 telefonos 
			if (telefonos.size()>1) {
				//System.out.println(telefonos.get(0));	
				//System.out.println(telefonos.get(1));
				try {
					f.nuevos_2_Telefonos(telefonos, ced);
				} catch (Exception e) {
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Error al guardar los telefonos, edite estos en  Ver > Empleados ", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
			}else{
				//System.out.println(telefonos.get(0));
				try {
					f.nuevoTelefono((String) telefonos.get(0), ced);
				} catch (Exception e) {
					javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
					mensaje.showMessageDialog(null, "Error al guardar el telefono, edite el mismo en  Ver > Empleados", "Atención!!!", mensaje.ERROR_MESSAGE);
				}
			}
		}	
	}
	
	/////////////////////
	
	public String empleadoXcedula(long cedula) throws SQLException{
		Fachada obtener = new Fachada();
		return obtener.empleadoXcedula(cedula);
	}
}
