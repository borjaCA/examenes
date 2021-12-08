package entidades;

import java.time.LocalDateTime;

public class Resultado {
	private long id;
	private boolean definitivo = false;
	private LocalDateTime fecha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isDefinitivo() {
		return definitivo;
	}

	public void setDefinitivo(boolean definitivo) {
		this.definitivo = definitivo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Resultado [id=" + id + ", definitivo=" + definitivo + ", fecha=" + fecha + "]";
	}

}
