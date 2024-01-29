package sv.gob.mined.modelo;

/**
 * Clase EmpleadoModelo donde se estructura los atributos para estructurar los campos entrantes.
 * @author Oliver González
 * 
 */
public class EmpleadoModelo {

	private Long identificador;
	private String nombre;
	private String direccion;
	
	public Long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
