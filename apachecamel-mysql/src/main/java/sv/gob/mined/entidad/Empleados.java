package sv.gob.mined.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Empleados donde se estructura los atributos para la entidad.
 * @author Oliver González
 * 
 */
@Entity
@Table(name="Empleados")
public class Empleados {

	@Id
	@Column(name="Identificador")
	private Long identificador;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Direccion")
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
