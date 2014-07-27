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
		/*String consulta= " SELECT empleados_tiene_trabajos.fecha as fecha,"
				            + "	  empleados_tiene_trabajos.hora as hora,"
				            + "	  p.nombre as nombre ,"
							+ "	  p.cedula as ci,"
							+ "   p.dir as direccion,p.apellido,"
							+ "   t.telefono as telefono, "
							+ "   empleados.nombre as Encargado,"
							+ "   empleados.cedula as emcedula,"
							+ "   empleados_tiene_trabajos.comentario as comentario,empleados_tiene_trabajos.horas as horas,"
							+ "   empleados_tiene_trabajos.Trabajos_idTrabajos as trabajo"
							+ "FROM empleados_tiene_trabajos JOIN empleados ON empleados_tiene_trabajos.Empleados_cedula = empleados.cedula"
							+ "JOIN trabajos ON empleados_tiene_trabajos.Trabajos_idTrabajos = trabajos.idTrabajos"
							+ "JOIN particulares p on trabajos.referencia = p.cedula"
							+ "JOIN telefonos t on p.cedula = t.referencia; ";*/
		return consulta;
	}
	
	public String DatosTareaEmpresas(){
		String consulta = "SELECT empleados_tiene_trabajos.fecha as fecha, empleados_tiene_trabajos.hora as hora, e.nombre as nombre , e.rut as rut,e.direccion as direccion,e.contacto,t.telefono as telefono, empleados.nombre as Encargado, empleados.cedula as emcedula,empleados_tiene_trabajos.comentario as comentario,empleados_tiene_trabajos.horas as horas, empleados_tiene_trabajos.Trabajos_idTrabajos as trabajo FROM empleados_tiene_trabajos JOIN empleados ON empleados_tiene_trabajos.Empleados_cedula = empleados.cedula JOIN trabajos ON empleados_tiene_trabajos.Trabajos_idTrabajos = trabajos.idTrabajos JOIN empresa e on trabajos.referencia = e.rut JOIN telefonos t on e.rut = t.referencia";
		return consulta;
	}
	
}
