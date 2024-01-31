package sv.gob.mined.modelo;

/**
 * Clase que contiene la estructura con los campos recibido del JSON.
 */
public class OperacionModelo {

	private Integer operador1;
	private Integer operador2;
	private String operacion;
	
	public Integer getOperador1() {
		return operador1;
	}
	public void setOperador1(Integer operador1) {
		this.operador1 = operador1;
	}
	public Integer getOperador2() {
		return operador2;
	}
	public void setOperador2(Integer operador2) {
		this.operador2 = operador2;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
	
}
