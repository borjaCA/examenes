package entidades;

public class Equipo extends Participante {
	private long idEquipo;
	private int anioinscripcion;

	public Equipo() {

	}

	public long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getAnioinscripcion() {
		return anioinscripcion;
	}

	public void setAnioinscripcion(int anioinscripcion) {
		this.anioinscripcion = anioinscripcion;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", anioinscripcion=" + anioinscripcion + "]";
	}

}
