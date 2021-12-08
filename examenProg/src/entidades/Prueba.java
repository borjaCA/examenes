package entidades;

import java.time.LocalDateTime;

public class Prueba {
	private long id;
	private String nombre;
	private LocalDateTime fecha;
	private boolean individual;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	@Override
	public String toString() {
		return "Prueba [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", individual=" + individual + "]";
	}

}
