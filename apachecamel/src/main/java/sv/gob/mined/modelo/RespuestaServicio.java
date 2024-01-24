package sv.gob.mined.modelo;

public class RespuestaServicio {

	private String mensaje;

	public RespuestaServicio() {
	}
	
	public RespuestaServicio(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
