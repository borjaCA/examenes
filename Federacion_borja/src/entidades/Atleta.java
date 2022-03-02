package entidades;
//esto no importa
import java.io.Serializable;
import java.util.Scanner;

import utils.Datos;
import utils.Utilidades;
import validaciones.Validador;

public class Atleta extends Participante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idAtleta;
	private float altura;
	private float peso;

	private DatosPersona persona;

	public Atleta() {
		super();
	}

	public Atleta(long idAtleta, float altura, float peso) {
		this.idAtleta = id;
		this.altura = altura;
		this.peso = peso;
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(idAtleta, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
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

	public DatosPersona getPersona() {
		return this.persona;
	}

	/**
	 * EJERCICIO 5 EXAMEN 5 CREACION DE UN NUEVO ATLETA PARA METERLO EN EL SWITCH Y
	 * ASI PEDIR AL USUARIO TODOS LOS DATOS DEL ATLETA PARA INTRODUCIRLOS
	 * 
	 * @return
	 */
	public static Atleta nuevoAtleta() {
		Atleta ret = null;
		long idAtleta = -1;
		float altura = (float) 0.0;
		float peso = (float) 0.0;
		Scanner in;
		boolean valido = false;
		boolean correcion = false;
		// se le mete un validador al id para que siempre sea mayot de 0
		do {
			do {
				System.out.println("introduzca un id  >0");
				in = new Scanner(System.in);
				idAtleta = in.nextLong();
				if (idAtleta > 0)
					valido = true;
				else
					System.out.println("introduce un id mayor que cero");

			} while (!valido);
			// hacemos el validador de la direccion
			valido = false;
			do {
				System.out.println("introdice una altura con mas de 1.00 m de altura");
				altura = in.nextFloat();
				if (altura > 1.00)
					valido = true;
				else
					System.out.println("introduce una altura con más de 1.00 m de altura");
			} while (!valido);
			valido = false;
			// validamos el numero de telefono a traves de los nuevos validadores que
			// hicimosh
			do {
				System.out.println("introduce un peso mayor que  30.0 kg");
				peso = in.nextFloat();
				if (peso > 30.0)
					valido = true;
				else
					System.out.println("introduce un peso mayor que 30.0");

			} while (!valido);

			ret = new Atleta(idAtleta, altura, peso);

			System.out.println("es correcto estos datos");
			correcion = Utilidades.leerBoolean();

		} while (!correcion);
		return ret;
	}

	@Override
	public String toString() {
		return persona.getNombre() + "(" + persona.getNifnie() + ") del año " + persona.getFechaNac() + "\t" + peso
				+ "kgs." + altura + "m.";
	}

	public String data() {
		String ret = "";
		ret = this.getId() + "|" + persona.getNombre();
		return ret;
	}
}
