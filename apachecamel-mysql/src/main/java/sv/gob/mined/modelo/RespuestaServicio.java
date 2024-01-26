package sv.gob.mined.modelo;

import java.util.List;

import sv.gob.mined.entidad.Empleados;

public class RespuestaServicio {

	private String estado;
	private String mensaje;
	private Empleados dato;
	private List<Empleados> listaDato;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Empleados getDato() {
		return dato;
	}
	public void setDato(Empleados dato) {
		this.dato = dato;
	}
	public List<Empleados> getListaDato() {
		return listaDato;
	}
	public void setListaDato(List<Empleados> listaDato) {
		this.listaDato = listaDato;
	}
	
	
	
}
