package sv.gob.mined.intefaces;

import org.springframework.http.ResponseEntity;

import sv.gob.mined.entidades.Empleado;
import sv.gob.mined.modelo.RespuestaServicio;

/**
 * Interfaz que contiene los metodos abstractos para su implementación.
 * @author Oliver Gonzalez
 */
public interface EmpleadoInterfaces {

	/**
	 * Metodo Ejemplo del uso de varios Path y la anotación PutMapping.
	 * @return Retorna una cadena "Hola Mundo"
	 */
	public RespuestaServicio obtenerEmpleados();
	
	/**
	 * Metodo es utilizado para obtener el empleado por identificador
	 * @param id Identificador del empleado
	 * @return Retorna un objecto con el empleado solicitado.
	 */
	public RespuestaServicio obtenerEmpleadoPorIdentificador(Long id);
	
	/**
	 * Metodo encargado de obtener el empleado existente por nombre.
	 * @param nombre Nombre del empleado.
	 * @return Retorna un objeto con el registro del empleado solicitado.
	 */
	public RespuestaServicio obtenerEmpleadoPorNombre(String nombre);
	
	/**
	 * Metodo encargado de crear un empleado nuevo en la base de datos y utilizando un respuesta personalizada
	 * para con ResponseEntity.
	 * @param crearEmpleado Objecto con los atributos del empleado a crear.
	 * @return Retorna un objeto con el registro ingresado a la base de datos y el estado de la solicitud a nivel http.
	 */
	public ResponseEntity<RespuestaServicio> crearEmpleado(Empleado crearEmpleado);
	
	/**
	 * Metodo encargado de actualizar un empleado existente en la base de datos.
	 * @param actualizadoEmpleado Objecto con los atributos del empleado a actualizar.
	 * @return Retorna un objeto con el registro actualizado a la base de datos.
	 */
	public RespuestaServicio actualizarEmpleado(Empleado actualizarEmpleado);
	
	/**
	 * Metodo encargado de eliminar el empleado existente por identificador.
	 * @param id Identificador del empleado.
	 * @return Retorna un objeto con las solicitud realizada.
	 */
	public RespuestaServicio eliminarEmpleado(Long id);
	
	
}
