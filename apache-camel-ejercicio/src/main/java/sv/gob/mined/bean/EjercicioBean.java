package sv.gob.mined.bean;

import org.springframework.stereotype.Component;

import sv.gob.mined.interfaces.EjercicioInterfaz;
import sv.gob.mined.modelo.OperacionModelo;
import sv.gob.mined.modelo.Respuesta;

/**
 * Clase con la lógica para los metodos abstractos del ejercicio.
 */

@Component
public class EjercicioBean implements EjercicioInterfaz{

	/**
	 * Metodo encargado de saludar a la persona dependiendo si proporciona la edad o no.
	 * @param nombre Nombre de la persona
	 * @param edad Edad de la persona
	 * @return Retorna el slaudo personalizado.
	 */
	@Override
	public Respuesta saludarPersona(String nombre, Integer edad) {
		
		if(edad != null)
			return new Respuesta("Hola ".concat(nombre).concat(" su edad es: ".concat(edad.toString())));
		else
			return new Respuesta("Hola ".concat(nombre).concat(", no suministro la edad"));
		
	}

	/**
	 * Metodo encargado de realizar la operacion matematica de suma, multiplicacion y division.
	 * @param operacion Objecto con los campos para realizar la operacion.
	 * @return Retorna la respuesta de la operacion realizada.
	 */
	@Override
	public Respuesta operacionMatematica(OperacionModelo operacion) {
		
		try {
			int resultado;
			
			switch(operacion.getOperacion().toUpperCase()) {
			
				case "SUMA":
					resultado = operacion.getOperador1() + operacion.getOperador2();
					return new Respuesta("El resultado es: ".concat("" + resultado));
				
				case "MULTIPLICACION":
					resultado = operacion.getOperador1() * operacion.getOperador2();
					return new Respuesta("El resultado es: ".concat("" + resultado));
					
				case "DIVISION":
					resultado = operacion.getOperador1() / operacion.getOperador2();
					return new Respuesta("El resultado es: ".concat("" + resultado));
					
				default:
					return new Respuesta("La operacion: ".concat(operacion.getOperacion()).concat(" es invalida."));
			
			}
		} catch (ArithmeticException e) {
			
			return new Respuesta("No se pudo realizar la operacion porque: ".concat(e.getMessage()));
			
		}
		
	}

}
