package sv.gob.mined.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sv.gob.mined.entidad.Empleados;

/**
 * Interfaz centrada en mantener los metodos para los objecto de acceso de datos.
 * @author Oliver Gonzalez
 */
public interface EmpleadoDao extends JpaRepository<Empleados, Long>{

	/**
	 * Metodo que realiza la consulta a la base de datos para obtener los empleados por identificador.
	 * @param id Identificador del empleado.
	 * @return Retorna un objecto de la entidad con los valores solicitados.
	 */
	@Query(value="SELECT * FROM EMPLEADOS WHERE IDENTIFICADOR = :id", nativeQuery=true)
	public Empleados obtenerEmpleadoPorId(@Param("id") Long id );
	
	/**
	 * Metodo que realiza la actualizacion a la base de datos para la direccion del empleado por identificador.
	 * @param id Identificador del empleado.
	 * @param direccion Campo de la direccion del empleado a actualizar.
	 * @return Retorna el numero de filas actualizadas.
	 */
	@Modifying
	@Query(value="UPDATE Empleados emp SET emp.direccion = :direccion WHERE emp.identificador = :id")
	int actualizarEmpleado(@Param("direccion") String direccion, @Param("id") Long id );
	
	
}
