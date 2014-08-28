package Grafica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Logica_Persistencia.Fachada.Fachada;
import Logica_Persistencia.Value_Object.VOParticular;

public class Controlador_Particular {
	
	public Controlador_Particular(){}
	
	
	/////////////////
	
	// Intancio el verificador de la Ci para usarlo desde la Ventana Nuevo_Particular
	public Verificar_Ci verificar = new Verificar_Ci();
	public Verificar_Tel verificarT = new Verificar_Tel();
	// Envia los datos a la fachada 
	
	public void nuevoParticular(String nombre, String apellido, String dir, ArrayList telefonos, String ci) throws SQLException{
		int cedula = Integer.parseInt(ci);
		Fachada f= new Fachada();
		
		f.nuevoParticular(nombre, apellido, dir, cedula);
		
		if (!(telefonos.isEmpty()) ) {
			/////   Controlos si se ingreso 1 o 2 telefonos 
				if (telefonos.size()>1) {
					//System.out.println(telefonos.get(0));	
					//System.out.println(telefonos.get(1));
					try {
						f.nuevos_2_Telefonos(telefonos, cedula);
					} catch (Exception e) {
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "Error al guardar los telefonos, edite estos en  Ver > Empleados ", "Atención!!!", mensaje.ERROR_MESSAGE);
					}
				}else{
					System.out.println(telefonos.get(0));
					try {
						f.nuevoTelefono((String) telefonos.get(0), cedula);
					} catch (Exception e) {
						javax.swing.JOptionPane mensaje = new javax.swing.JOptionPane(); 
						mensaje.showMessageDialog(null, "Error al guardar el telefono, edite el mismo en  Ver > Empleados", "Atención!!!", mensaje.ERROR_MESSAGE);
					}
				}
			}
	}
	
	//////////////
	
	public List<VOParticular> listarParticulares() {
		Fachada a = new Fachada();
		return a.listarParticulares();
	}
	
	/////////////
	
	public void modificar (String modi,long l) throws SQLException{
		Fachada a = new Fachada();
		a.ModificarParticular(modi,l);
	}
	public void Eliminar_Particular (int l) throws SQLException{
		Fachada a = new Fachada();
		a.Eliminar_Particular(l);
	}
	
	
}
