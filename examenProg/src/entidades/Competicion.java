package entidades;

public class Competicion {
	private long id;
	private String nombre;
	private int anio;

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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Competicion [id=" + id + ", nombre=" + nombre + ", anio=" + anio + "]";
	}

}
