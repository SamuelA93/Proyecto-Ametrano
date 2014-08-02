package Logica_Persistencia.AccesoDB;

public class Consultas {
	
	// Retorna la sentencia SQL para registrar un nuevo Particular
	public String nuevoParticular(){
		String consulta = "INSERT INTO particulares (cedula,nombre, apellido,dir) VALUES (?,?,?,?);";
		return consulta;
	}
	public String nuevoCelTel(){
		String consulta = "INSERT INTO Telefonos (referencia,telefono) VALUES (?,?);";
		return consulta;
	}
	// 
	public String nuevoTrabajo(){
		String consulta="INSERT INTO trabajos(cuotas_totales,fecha_inicio,monto_total,estado,comentario,referencia) VALUES(?,?,?,?,?,?)";
		return consulta;
	}
	public String fechaTarea(){
		String consulta="SELECT id FROM `prueba` WHERE id=?;";
		return consulta;
	}
	
	public String DatosTareaParticulares(){
		String consulta= " SELECT empleados_tiene_trabajos.fecha as fecha, empleados_tiene_trabajos.hora as hora, p.nombre as nombre , p.cedula as ci,p.dir as direccion,p.apellido,t.telefono as telefono, empleados.nombre as Encargado, empleados.cedula as emcedula,empleados_tiene_trabajos.comentario as comentario,empleados_tiene_trabajos.horas as horas, empleados_tiene_trabajos.Trabajos_idTrabajos as trabajo FROM empleados_tiene_trabajos JOIN empleados ON empleados_tiene_trabajos.Empleados_cedula = empleados.cedula JOIN trabajos ON empleados_tiene_trabajos.Trabajos_idTrabajos = trabajos.idTrabajos JOIN particulares p on trabajos.referencia = p.cedula JOIN telefonos t on p.cedula = t.referencia;";
		
		return consulta;
	}
	
	public String DatosTareaEmpresas(){
		String consulta = "SELECT empleados_tiene_trabajos.fecha as fecha, empleados_tiene_trabajos.hora as hora, e.nombre as nombre , e.rut as rut,e.direccion as direccion,e.contacto,t.telefono as telefono, empleados.nombre as Encargado, empleados.cedula as emcedula,empleados_tiene_trabajos.comentario as comentario,empleados_tiene_trabajos.horas as horas, empleados_tiene_trabajos.Trabajos_idTrabajos as trabajo FROM empleados_tiene_trabajos JOIN empleados ON empleados_tiene_trabajos.Empleados_cedula = empleados.cedula JOIN trabajos ON empleados_tiene_trabajos.Trabajos_idTrabajos = trabajos.idTrabajos JOIN empresa e on trabajos.referencia = e.rut JOIN telefonos t on e.rut = t.referencia";
		return consulta;
	}
	public String DatosTareas(){
		String consulta = "SELECT* FROM `empleados_tiene_trabajos` ORDER BY `fecha` ;";
		return consulta;
	}
	public String TrabajoXid(){
		String consulta = "SELECT idTrabajos,cuotas_totales as cuotas, monto_total as monto,estado, referencia FROM trabajos WHERE idTrabajos=?;";
		return consulta;
	}
	public String empleadoXcedula(){
		String consulta = "SELECT nombre,apellido FROM `empleados` WHERE `cedula`=?;";
		return consulta;
	}
	public String particularXcedula(){
		String consulta = "SELECT* FROM `particulares` WHERE `cedula`=?;";
		return consulta;
	}
	public String empresaXrut(){
		String consulta = "SELECT* FROM `empresa` WHERE `rut`=?;";
		return consulta;
	}
	public String TelXreferencia(){
		String consulta = "SELECT telefono,referencia FROM `telefonos` WHERE `referencia`=?;";
		return consulta;
	}
	public String NuevaTarea(){
		String consulta = "INSERT INTO `devlopteam mts`.`empleados_tiene_trabajos` (`Empleados_cedula`, `Trabajos_idTrabajos`, `fecha`, `hora`, `horas`, `comentario`) VALUES (?,?,?,?,?,?);";
		return consulta;
	}
	public String obtenerClientes_Referencias(){
		
		String consulta = "Select CONCAT(nombre,' ',apellido) as nombre, cedula as referencia from particulares  union select nombre, rut from empresa ;";
		return consulta;
	}
	public String obtenerTrabajos_id(){
			
			String consulta = "select idTrabajos as trabajo, estado from trabajos where referencia =?";
			return consulta;
		}
	public String obtenerCliente_Referencia(String entradaNombre,String entradareferencia){
			
			String consulta = "Select CONCAT(nombre,' ',apellido) as nombre, cedula as referencia from particulares Where CONCAT(nombre,' ',apellido) like '"+entradaNombre+"' or cedula like '"+entradareferencia+"' union select nombre, rut from empresa Where nombre like '"+entradaNombre+"' or rut like '"+entradareferencia+"';";
			return consulta;
		}
	public String listarParticulares(){
		String consulta = "SELECT * FROM particulares";
		return consulta;
	}
	public String nuevaEmpresa(){
		String consulta = "INSERT INTO empresa (rut,nombre,contacto,direccion) VALUES (?,?,?,?);";
		return consulta;
	}
	public String listarEmpleados(){
		String consulta = "SELECT * FROM empleados";
		return consulta;
	}
	
}
