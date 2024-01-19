package sv.gob.mined.modelo;

import java.util.List;

import sv.gob.mined.entidades.Empleado;

/**
 * Clase RespuestaServicio donde se estructura los atributos para estructurar la respuesta.
 * @author Oliver González
 * 
 */
public class RespuestaServicio {

	private String estado;
	private Empleado dato;
	private List<Empleado> listaDato;
	private String mensaje;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Empleado getDato() {
		return dato;
	}
	public void setDato(Empleado dato) {
		this.dato = dato;
	}
	public List<Empleado> getListaDato() {
		return listaDato;
	}
	public void setListaDato(List<Empleado> listaDato) {
		this.listaDato = listaDato;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
