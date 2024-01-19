package sv.gob.mined.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sv.gob.mined.entidades.Empleado;

/**
 * Interfaz centrada en mantener los metodos para los objecto de acceso de datos.
 * @author Oliver Gonzalez
 */
public interface EmpleadoDao extends CrudRepository<Empleado, Long> {

	/**
	 * Metodo que realiza la consulta a la base de datos para obtener los empleados por identificador.
	 * @param id Identificador del empleado.
	 * @return Retorna un objecto de la entidad con los valores solicitados.
	 */
	@Query(value="SELECT * FROM EMPLEADOS WHERE IDENTIFICADOR = :id", nativeQuery = true)
	public Empleado obtenerEmpleadoPorId(@Param("id")Long id);
	
	/**
	 * Metodo que realiza la consulta a la base de datos para obtener los empleados por nombre.
	 * @param nombre Nombre del empleado.
	 * @return Retorna un objecto de la entidad con los valores solicitados.
	 */
	@Query(value="SELECT emp FROM Empleado emp WHERE emp.nombre= :nombre")
	public Empleado obtenerEmpleadoPorNombre(@Param("nombre") String nombre);
	
}
