package entidades;

public class Lugar {
	private String nombre;
	private String ubicacion;
	private boolean airelibre;
	private Prueba[] prueba;

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

	public Prueba[] getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba[] prueba) {
		this.prueba = prueba;
	}

	public void setAirelibre(boolean airelibre) {
		this.airelibre = airelibre;
	}

	@Override
	public String toString() {
		return "Lugar [nombre=" + nombre + ", ubicacion=" + ubicacion + ", airelibre=" + airelibre + "]";
	}

}
