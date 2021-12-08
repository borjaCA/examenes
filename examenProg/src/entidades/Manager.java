package entidades;

public class Manager {
	private long id;
	private String telefono;
	private String direccion;
	private Equipo equipo;
	// Constructor por defecto
	public Manager() {

	}

	public long getId() {
		return id;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

}
