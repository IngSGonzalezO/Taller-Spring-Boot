package sv.gob.mined.interafeces;

import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

public interface EmpleadosInterfaz {

	public RespuestaServicio obtenerEmpleados();
	
	public RespuestaServicio obtenerEmpleadoPorId(Long id);
	
	public RespuestaServicio crearEmpleado(EmpleadoModelo crearEmpleado);
	
	public RespuestaServicio actualizarEmpleado(EmpleadoModelo actualizarEmpleado);
	
	public RespuestaServicio actualizarDireccionEmpleado(EmpleadoModelo actulizarDireccion);
	
	public RespuestaServicio eliminarEmpleado(Long id);
	
}
