package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Utilidades;

public class Equipo extends Participante {
	private long idEquipo;
	private LocalDate anioinscripcion;
	private String nombre;
	private Manager manager;
	private Atleta[] atletas;

	public Equipo(long id, LocalDate anioinscripcion, String nombre, Manager manager, Atleta[] atletas) {
		super();
		this.idEquipo = id;
		this.anioinscripcion = anioinscripcion;
		this.nombre = nombre;
		this.manager = manager;
		this.atletas = atletas;
	}

	public Equipo(long idParticipante, Equipo e, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idEquipo = e.idEquipo;
		this.anioinscripcion = e.anioinscripcion;
		this.manager = e.manager;
		this.atletas = e.atletas;
	}

	public Equipo(int i, int j, Manager manager2, Atleta[] equipo1) {
		// TODO Auto-generated constructor stub
	}

	public static Equipo nuevoEquipo() {
		Equipo ret = null;
		long idEquipo = -1;
		String nombre = "";
		Manager m = null;

		Scanner in;
		boolean valido = false;
		boolean correcion = false;
		System.out.println("introduce el nuebo equipo");
		do {
			do {
				System.out.println("Introduce el id del equipo");
				in = new Scanner(System.in);
				idEquipo = in.nextLong();
				if (idEquipo > 0) {
					valido = true;

				} else {
					System.out.println("Introduce un id >0 para que sea valido");
				}

			} while (!valido);

			System.out.println("Introduce el año de inscripcion");
			LocalDate anioinscripcion = Utilidades.leerFecha();

			valido = false;
			do {
				System.out.println("Introduce un nombre del equipo");
				nombre = in.next();
				if (nombre.length() > 0) {
					valido = true;
				} else {
					System.out.println("nombre no valido");
				}
			} while (!valido);
			System.out.println("Introduzca por favor el manager que  comprende en el equipo y agregalos");

			m = Manager.nuevoManager();
			System.out.println(
					"introduzca por favor el numero de atletas que comprenden el equipo y sus respectivos datos");
			valido = false;
			int natletas = -1;
			do {
				System.out.println("Introduce el numero de atletas");
				natletas = in.nextInt();
				if (natletas >= 3 && natletas <= 5) {
					valido = true;
				} else {
					System.out.println("introduce un numero valido");
				}
			} while (!valido);
			System.out.println("introduce los datos de loas " + natletas + " atletas");
			Atleta[] atletas = new Atleta[natletas];
			for (int i = 0; i < natletas; i++) {
				System.out.println("Introduce los datos del " + (i + 1) + " atleta");
				atletas[i] = Atleta.nuevoAtleta();
			}
			correcion = Utilidades.leerBoolean();
			ret = new Equipo(idEquipo, anioinscripcion, nombre, m, atletas);
			return ret;

		} while (!correcion);
	}
	
	

	@Override
	public long getId() {
		return idEquipo;
	}

	public long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setId(long id) {
		this.idEquipo = id;
	}

	public LocalDate getAnioinscripcion() {
		return anioinscripcion;
	}

	public void setAnioinscripcion(LocalDate anioinscripcion) {
		this.anioinscripcion = anioinscripcion;
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

	// Ejercicio 3
	@Override
	public String toString() {
		String ret = "";
		ret += "EQ" + idEquipo + ". de " + manager.getPersona().getNombre() + " (" + manager.getDireccion() + ") "
				+ atletas.length + " componentes en el equipo:\n";
		for (Atleta a : atletas) {
			ret += a.getId() + ". " + a.getPersona().getNombre() + "("
					+ a.getPersona().getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ") "
					+ " Datos físicos:\t" + a.getPeso() + "Kgs.\t" + a.getAltura() + "m.\n";
		}
		ret += "Valido durante el " + anioinscripcion;
		return ret;
	}

}
