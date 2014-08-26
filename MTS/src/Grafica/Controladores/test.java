package Grafica.Controladores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import Grafica.Ventanas.AutoCompletion;
import Logica_Persistencia.Value_Object.VOEmpleado;

public class test {
	Controlador_Trabajo control_trabajo = new Controlador_Trabajo();
  	Controlador_Cliente control_cliente = new Controlador_Cliente();
  	static Controlador_Empleado control_empleado = new Controlador_Empleado();
  	private List<Object[]> list = null;
  	private static List<VOEmpleado> listE = null;
  	
  	
  	public static void actualizarEmpleado(){
		
  		pruebaFechas f = new pruebaFechas();
  		System.out.println(f.horaActualDate());
  		System.out.println(f.horaActualDate());
		/*try {
			
			 listE = control_empleado.listarEmpleados();
			 for (int i=0; i<listE.size();i++){						
					System.out.println(listE.get(i).getNombre()+" "+listE.get(i).getApellido());
					//System.out.println(list.get(i)[0]);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
  	public static void inici(){
		
	
			
			
			/*try {
					listE = control_empleado.listarEmpleados();
				 for (int i=0; i<listE.size();i++){		
					System.out.println( listE.get(i).getNombre()+" "+listE.get(i).getApellido());
					
					
				}
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}	*/
		
  	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//actualizarEmpleado();
		//inici();
		actualizarEmpleado();
	}

}
