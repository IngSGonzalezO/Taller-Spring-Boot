package sv.gob.mined.interfaces;

import sv.gob.mined.modelo.OperacionModelo;
import sv.gob.mined.modelo.Respuesta;

/**
 * Interfaz que contiene los metodos abtractos para el ejercicio.
 */
public interface EjercicioInterfaz {

	/**
	 * Metodo encargado de saludar a la persona.
	 * @param nombre Nombre de la persona.
	 * @param edad Edad de la persona.
	 * @return Retorna un saludo personalizado al usuario.
	 */
	public Respuesta saludarPersona(String nombre, Integer edad);
	
	/**
	 * Metodo que realiza las operaciones aritmeticas de suma, multiplicacion y division.
	 * @param operacion Objecto con los campos para realizar la operacion matematica.
	 * @return Retorna el resultado de la operacion. 
	 */
	public Respuesta operacionMatematica(OperacionModelo operacion);
	
}
