package sv.gob.mined.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sv.gob.mined.entidades.Empleado;
import sv.gob.mined.intefaces.EmpleadoInterfaces;
import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

/**
 * Clase principal que contiene todos los EndPoint para este laboratorio.
 * @author Oliver González
 */
@RestController
@RequestMapping("/api/primer-endpoint")
@Tag(name = "Laboratorio", description = "Laboratorio-01 API")
public class PrimerEndPoint {
	
	@Autowired
	@Qualifier("EmpleadoServicios")
	EmpleadoInterfaces empleadoServicio;
	
	@Autowired
	ObjectMapper mapper;
	
	RespuestaServicio respuesta = new RespuestaServicio();
	
	/**
	 * Metodo Ejemplo del uso de varios Path y la anotacion PutMapping.
	 * @return Retorna una cadena "Hola Mundo"
	 */
	@Operation(summary="Primer Ejemplos de EndPoint", description="EndPoint ejemplo práctico del uso de la anotación PutMapping y diversos path",
			tags = "Método Put")
	@PutMapping(path={"/index","/", ""})
	public String primerEndpoint() {
		return "Hola Mundo ";
	}
	
	/**
	 * Metodo encargado de obtener todos los empleados existentes.
	 * @return Retorna un objeto con las solicitud realizada.
	 */
	@Operation(summary = "Se utiliza para obtener todos los empleados existentes.",
		      description = "Obtiene todos los empleados.",
		      tags = "Método Get")
	@GetMapping(path="/obtenerEmpleados")
	public RespuestaServicio obtenerEmpleados() {
		return empleadoServicio.obtenerEmpleados();
	}
	
	/**
	 * Metodo encargado de obtener el empleado existente por identificador.
	 * @param id Identificador del empleado.
	 * @return Retorna un objeto con el registro del empleado solicitado.
	 */
	@Operation(summary = "Se utiliza para obtener el empleado por identificador.",
		      description = "Obtiene el empleado por identificador.",
		      tags = "Método Get")
	@GetMapping(path="/obtenerEmpleadoPorId/{id}")
	public RespuestaServicio obtenerEmpleadoPorId(@PathVariable("id") Long id) {
		return empleadoServicio.obtenerEmpleadoPorIdentificador(id);
	}
	
	/**
	 * Metodo encargado de obtener el empleado existente por nombre.
	 * @param nombre Nombre del empleado.
	 * @return Retorna un objeto con el registro del empleado solicitado.
	 */
	@Operation(summary = "Se utiliza para obtener el empleado obtenido por nombre.",
		      description = "Obtiene el empleado por Nombre.",tags = "Método Get")
	@GetMapping(path="/obtenerEmpleadoPorNombre")
	public RespuestaServicio obtenerEmpleadoPorNombre(@RequestParam("nombre") String nombre) {
		return empleadoServicio.obtenerEmpleadoPorNombre(nombre);
	}
	
	/**
	 * Metodo encargado de crear un empleado nuevo en la base de datos.
	 * @param crearEmpleado Objecto con los atributos del empleado a crear.
	 * @return Retorna un objeto con el registro ingresado a la base de datos.
	 */
	@Operation(summary="Crear un empleado", description="Se utiliza para crear un empleado nuevo",
			tags = "Método Post")
	@PostMapping(path="/crearEmpleado", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaServicio> crearEmpleado(@RequestBody EmpleadoModelo crearEmpleado) {
		try {
			return empleadoServicio.crearEmpleado(mapper.readValue(mapper.writeValueAsBytes(crearEmpleado), Empleado.class));
		}catch(Exception ex) {
			respuesta.setEstado("Error");
			respuesta.setMensaje(ex.getMessage());
			respuesta.setDato(null);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(respuesta);
		}
	}
	
	/**
	 * Metodo encargado de actualizar un empleado existente en la base de datos.
	 * @param actualizadoEmpleado Objecto con los atributos del empleado a actualizar.
	 * @return Retorna un objeto con el registro actualizado a la base de datos.
	 */
	@Operation(summary="Actualizar un empleado", description="Se utiliza para actualizar un empleado existente",
			tags = "Método Put")
	@PutMapping(path="/actualizarEmpleado", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public RespuestaServicio actualizarEmpleado(@RequestBody EmpleadoModelo actualizadoEmpleado) {
		
		try {
			return empleadoServicio.actualizarEmpleado(mapper.readValue(mapper.writeValueAsBytes(actualizadoEmpleado), Empleado.class));
		}catch(Exception ex){
			respuesta.setEstado("Error");
			respuesta.setMensaje(ex.getMessage());
			respuesta.setDato(null);
			
			return respuesta;
		}
		
	}
	
	/**
	 * Metodo encargado de eliminar el empleado existente por identificador.
	 * @param id Identificador del empleado.
	 * @return Retorna un objeto con las solicitud realizada.
	 */
	@Operation(summary="Elimina un empleado", description="Se utiliza para eliminar un empleado existente.",
			tags = "Método Delete")
	@DeleteMapping(path="/eliminarEmpleadoPorId/{id}")
	public RespuestaServicio eliminarEmpleadoPorId(@PathVariable("id") Long id) {
		return empleadoServicio.eliminarEmpleado(id);
	}
	
	
	
}
