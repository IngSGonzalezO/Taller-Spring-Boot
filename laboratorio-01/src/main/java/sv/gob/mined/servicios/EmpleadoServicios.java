package sv.gob.mined.servicios;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sv.gob.mined.dao.EmpleadoDao;
import sv.gob.mined.entidades.Empleado;
import sv.gob.mined.intefaces.EmpleadoInterfaces;
import sv.gob.mined.modelo.RespuestaServicio;

/**
 * Clase que contiene la logica y implementamos los metodos de la interfaz EmpleadoInterfaces
 * @author Oliver Gonzalez
 */
@Service("EmpleadoServicios")
public class EmpleadoServicios implements EmpleadoInterfaces{

	@Autowired
	EmpleadoDao empleadoDao;
	
	Logger logger = Logger.getLogger(EmpleadoServicios.class.getName());
	
	RespuestaServicio respuesta = new RespuestaServicio();
	
	/**
	 * Metodo Ejemplo del uso de varios Path y la anotación PutMapping.
	 * @return Retorna una cadena "Hola Mundo"
	 */
	@Override
	public RespuestaServicio obtenerEmpleados() {
		
		try {
			List<Empleado> listaEmpleado = (List<Empleado>) empleadoDao.findAll();
			
			respuesta.setListaDato(listaEmpleado);
			respuesta.setEstado("Éxitoso");
			respuesta.setMensaje("Obtención éxitosa");
			
			return respuesta;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			
			return respuesta;
		}
	}
	
	/**
	 * Metodo es utilizado para obtener el empleado por identificador
	 * @param id Identificador del empleado
	 * @return Retorna un objecto con el empleado solicitado.
	 */
	@Override
	public RespuestaServicio obtenerEmpleadoPorIdentificador(Long id) {
		
		try {
			respuesta.setDato(empleadoDao.obtenerEmpleadoPorId(id));
			if(respuesta.getDato() != null) {
				respuesta.setEstado("Éxitoso");
				respuesta.setListaDato(null);
				respuesta.setMensaje("Obtención éxitosa " + id + "encontrado");
			}else {
				respuesta.setEstado("Error");
				respuesta.setListaDato(null);
				respuesta.setMensaje("Obtención no éxitosa" + id + "no encontrado");
			}
			return respuesta;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			
			return respuesta;
		}
	}
	
	/**
	 * Metodo encargado de crear un empleado nuevo en la base de datos y utilizando un respuesta personalizada
	 * para con ResponseEntity.
	 * @param crearEmpleado Objecto con los atributos del empleado a crear.
	 * @return Retorna un objeto con el registro ingresado a la base de datos y el estado de la solicitud a nivel http.
	 */
	@Override
	public ResponseEntity<RespuestaServicio> crearEmpleado(Empleado crearEmpleado){
		
		try {
			if(crearEmpleado.getIdentificador()!=0 && empleadoDao.obtenerEmpleadoPorId(crearEmpleado.getIdentificador()) != null) {
				respuesta.setDato(null);
				respuesta.setListaDato(null);
				respuesta.setEstado("Error");
				respuesta.setMensaje("Empleado ya existe");
				
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(respuesta);
			}
			
			respuesta.setDato(empleadoDao.save(crearEmpleado));
			respuesta.setEstado("Éxitoso");
			respuesta.setMensaje("Empleado creado exitosamente.");
			return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
			
		} catch (Exception e) {
			logger.severe(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(respuesta);
		}
		
		
	}
	
	/**
	 * Metodo encargado de actualizar un empleado existente en la base de datos.
	 * @param actualizadoEmpleado Objecto con los atributos del empleado a actualizar.
	 * @return Retorna un objeto con el registro actualizado a la base de datos.
	 */
	@Override
	public RespuestaServicio actualizarEmpleado(Empleado actualizarEmpleado) {
		
		try {
			if(empleadoDao.obtenerEmpleadoPorId(actualizarEmpleado.getIdentificador()) != null) {
				
				respuesta.setDato(empleadoDao.save(actualizarEmpleado));
				respuesta.setListaDato(null);
				respuesta.setEstado("Éxitoso");
				respuesta.setMensaje("Empleado actualizado exitosamente.");
				return respuesta;
			}
			
			respuesta.setDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no existe");
			return respuesta;
			
		} catch (Exception e) {
			logger.severe(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			
			return respuesta;
		}
		
	}

	/**
	 * Metodo encargado de obtener el empleado existente por nombre.
	 * @param nombre Nombre del empleado.
	 * @return Retorna un objeto con el registro del empleado solicitado.
	 */
	@Override
	public RespuestaServicio obtenerEmpleadoPorNombre(String nombre) {
		
		try {
			respuesta.setDato(empleadoDao.obtenerEmpleadoPorNombre(nombre));
			if(respuesta.getDato() != null) {
				respuesta.setEstado("Éxitoso");
				respuesta.setMensaje("Obtención éxitosa " + nombre + "encontrado");
			}else {
				respuesta.setEstado("Error");
				respuesta.setMensaje("Obtención no éxitosa" + nombre + "no encontrado");
			}
			return respuesta;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			
			return respuesta;
		}
	}

	/**
	 * Metodo encargado de eliminar el empleado existente por identificador.
	 * @param id Identificador del empleado.
	 * @return Retorna un objeto con las solicitud realizada.
	 */
	@Override
	public RespuestaServicio eliminarEmpleado(Long id) {
		
		try {
			
			if(empleadoDao.obtenerEmpleadoPorId(id) != null) {
				
				empleadoDao.deleteById(id);
				respuesta.setDato(null);
				respuesta.setListaDato(null);
				respuesta.setEstado("Éxitoso");
				respuesta.setMensaje("Empleado eliminado exitosamente");
				
				return respuesta;
				
			}
			
			respuesta.setDato(null);
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no exite");
			
			return respuesta;
			
			
			
		}catch(Exception e) {
			logger.severe(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			
			return respuesta;
		}
		
	}

	
	
}
