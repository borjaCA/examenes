package entidades;

public class Equipo extends Participante {
	private long idEquipo;
	private int anioinscripcion;
	private Manager manager;
	private Atleta[] atletas;

	public Equipo() {
		super();
	}
	public Equipo(long id) {
		super();
		this.idEquipo=id;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Atleta[] getAtletas() {
		return atletas;
	}
	public void setAtletas(Atleta[] atletas) {
		this.atletas = atletas;
	}
	public Equipo (Participante p, long id) {
		
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
