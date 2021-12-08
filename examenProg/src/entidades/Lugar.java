package entidades;

public class Lugar {
	private String nombre;
	private String ubicacion;
	private boolean airelibre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean isAirelibre() {
		return airelibre;
	}

	public void setAirelibre(boolean airelibre) {
		this.airelibre = airelibre;
	}

	@Override
	public String toString() {
		return "Lugar [nombre=" + nombre + ", ubicacion=" + ubicacion + ", airelibre=" + airelibre + "]";
	}

}
