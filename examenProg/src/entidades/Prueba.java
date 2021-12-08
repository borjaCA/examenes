package entidades;

import java.time.LocalDateTime;

public class Prueba {
	private long id;
	private String nombre;
	private LocalDateTime fecha;
	private boolean individual;
	private Participante[] participantes;
	private Lugar lugar;
	private Competicion competicion;

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

	public Participante[] getParticipantes() {
		return participantes;
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	
	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}

	public void setParticipantes(Participante[] participantes) {
		this.participantes = participantes;
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
