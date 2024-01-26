package sv.gob.mined.bean;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import sv.gob.mined.dao.EmpleadoDao;
import sv.gob.mined.entidad.Empleados;
import sv.gob.mined.interafeces.EmpleadosInterfaz;
import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class EmpleadoBean implements EmpleadosInterfaz{

	@Autowired
	EmpleadoDao empleadoDao;
	
	Logger logger = Logger.getLogger(EmpleadoBean.class.getName());
	
	@Override
	public RespuestaServicio obtenerEmpleados() {
		
		RespuestaServicio respuesta = new RespuestaServicio();
		
		try {
			
			List<Empleados> listaEmpleados = empleadoDao.findAll();
			
			respuesta.setEstado("Exito");
			respuesta.setMensaje("Empleados encontrados");
			respuesta.setListaDato(listaEmpleados);
			respuesta.setDato(null);
			
			return respuesta;
			
		}catch(Exception e) {
			
			logger.severe(e.getMessage());
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no encontrado");
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
		}
		
	}

	@Override
	public RespuestaServicio obtenerEmpleadoPorId(Long id) {
		
		RespuestaServicio respuesta = new RespuestaServicio();
		
		try {
			
			respuesta.setEstado("Exito");
			respuesta.setMensaje("Empleado encontrado");
			respuesta.setListaDato(null);
			respuesta.setDato(empleadoDao.obtenerEmpleadoPorId(id));
			
			return respuesta;
			
		}catch(Exception e) {
			
			logger.severe(e.getMessage());
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no encontrado");
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
		}
		
	}

	@Override
	public RespuestaServicio crearEmpleado(EmpleadoModelo crearEmpleado) {
		
		RespuestaServicio respuesta = new RespuestaServicio();
		
		try {
			
			Empleados nuevoEmpleado = new Empleados();
			
			if(empleadoDao.obtenerEmpleadoPorId(crearEmpleado.getIdentificador()) != null ) {
				
				respuesta.setEstado("Error");
				respuesta.setMensaje("Empleado existente");
				respuesta.setListaDato(null);
				respuesta.setDato(null);
				
				return respuesta;
			}
			
			nuevoEmpleado.setIdentificador(crearEmpleado.getIdentificador());
			nuevoEmpleado.setNombre(crearEmpleado.getNombre());
			nuevoEmpleado.setDireccion(crearEmpleado.getDireccion());
			
			
			respuesta.setEstado("Exito");
			respuesta.setMensaje("Empleado creado de forma exitosa");
			respuesta.setListaDato(null);
			respuesta.setDato(empleadoDao.save(nuevoEmpleado));
			
			return respuesta;
				
			
			
		}catch(Exception e) {
			
			logger.severe(e.getMessage());
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no encontrado");
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
		}
		
	}

	@Override
	public RespuestaServicio actualizarEmpleado(EmpleadoModelo actualizarEmpleado) {
		
		RespuestaServicio respuesta = new RespuestaServicio();
		
		try {
			
			Empleados actualizaEmpleado = new Empleados();
			
			if(empleadoDao.obtenerEmpleadoPorId(actualizarEmpleado.getIdentificador()) != null ) {
				
				actualizaEmpleado.setIdentificador(actualizarEmpleado.getIdentificador());
				actualizaEmpleado.setNombre(actualizarEmpleado.getNombre());
				actualizaEmpleado.setDireccion(actualizarEmpleado.getDireccion());
				
				
				respuesta.setEstado("Exito");
				respuesta.setMensaje("Empleado actualizado de forma exitosa");
				respuesta.setListaDato(null);
				respuesta.setDato(empleadoDao.save(actualizaEmpleado));
				
				return respuesta;
				
			}
			
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no exite");
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
			
		}catch(Exception e) {
			
			logger.severe(e.getMessage());
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no encontrado");
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
		}
		
	}

	@Transactional
	@Override
	public RespuestaServicio actualizarDireccionEmpleado(EmpleadoModelo actulizarDireccion) {
		
		RespuestaServicio respuesta = new RespuestaServicio();
		
		try {
			
			String direccion = actulizarDireccion.getDireccion();
			Long id = actulizarDireccion.getIdentificador();
			
			
			int filasActualizadas = empleadoDao.actualizarEmpleado(direccion, id);
			
			if(filasActualizadas > 0) {
				respuesta.setEstado("Exito");
				respuesta.setMensaje("Dirección actualizada del empleado");
				respuesta.setListaDato(null);
				respuesta.setDato(empleadoDao.obtenerEmpleadoPorId(id));
			}else {
				respuesta.setEstado("Error");
				respuesta.setMensaje("No se pudo realizar la actualización");
				respuesta.setListaDato(null);
				respuesta.setDato(null);
			}
			
			return respuesta;
			
		}catch(Exception e) {
			
			logger.severe(e.getMessage());
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
		}
		
	}

	@Override
	public RespuestaServicio eliminarEmpleado(Long id) {
		
		RespuestaServicio respuesta = new RespuestaServicio();
		
		try {
			
			if(empleadoDao.obtenerEmpleadoPorId(id) != null ) {
				
				empleadoDao.deleteById(id);
				
				respuesta.setEstado("Exito");
				respuesta.setMensaje("Empleado eliminado de forma exitosa");
				respuesta.setListaDato(null);
				respuesta.setDato(null);
				
				return respuesta;
			}
			
			respuesta.setEstado("Error");
			respuesta.setMensaje("Empleado no exite");
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
			
			
		}catch(Exception e) {
			
			logger.severe(e.getMessage());
			respuesta.setEstado("Error");
			respuesta.setMensaje(e.getMessage());
			respuesta.setListaDato(null);
			respuesta.setDato(null);
			
			return respuesta;
			
		}
		
	}

}
