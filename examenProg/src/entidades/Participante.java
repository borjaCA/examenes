package entidades;

public class Participante {
	protected long id;
	protected int dorsal;
	protected char calle;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", dorsal=" + dorsal + ", calle=" + calle + "]";
	}

}
