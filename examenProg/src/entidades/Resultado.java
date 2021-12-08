package entidades;

import java.time.LocalDateTime;

public class Resultado {
	private long id;
	private boolean definitivo = false;
	private LocalDateTime fecha;
	private Oro oro;
	private Plata plata;
	private Bronce bronce;

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

	
	public Oro getOro() {
		return oro;
	}

	public void setOro(Oro oro) {
		this.oro = oro;
	}

	public Plata getPlata() {
		return plata;
	}

	public void setPlata(Plata plata) {
		this.plata = plata;
	}

	public Bronce getBronce() {
		return bronce;
	}

	public void setBronce(Bronce bronce) {
		this.bronce = bronce;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Resultado [id=" + id + ", definitivo=" + definitivo + ", fecha=" + fecha + "]";
	}

}
