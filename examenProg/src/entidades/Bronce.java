package entidades;

public class Bronce {
	private long id;
	private float pureza;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPureza() {
		return pureza;
	}

	public void setPureza(float pureza) {
		this.pureza = pureza;
	}

	@Override
	public String toString() {
		return "Oro [id=" + id + ", pureza=" + pureza + "]";
	}
}
