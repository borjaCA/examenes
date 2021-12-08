package entidades;

public class Atleta extends Participante {

	private long idAtleta;
	private float altura;
	private float peso;

	public Atleta(Participante p, long idAtleta, float altura, float peso) {
		super();
		this.id = idAtleta;
		this.altura = altura;
		this.peso = peso;

	}

	public long getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(long idAtleta) {
		this.idAtleta = idAtleta;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Atleta [idAtleta=" + idAtleta + ", altura=" + altura + ", peso=" + peso + "]";
	}

}
