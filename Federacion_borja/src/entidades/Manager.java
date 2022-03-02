package entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import utils.Datos;
import utils.Utilidades;
import validaciones.Validador;

public class Manager {
	private long id;
	private String telefono;
	private String direccion;
	private String nombre;

	private DatosPersona persona;

	public Manager() {

	}

	public Manager(long id, String telefono, String direccion) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Manager(long id, String telefono, String direccion, DatosPersona dp) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.persona = dp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}

	public long getId() {
		return id;
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

	public DatosPersona getPersona() {
		return this.persona;
	}

	// EJERCICIO 4 EXAMEN 5 NUEVO MANAGER
	public static Manager nuevoManager() {
		Manager ret = null;
		long id = -1;
		String telefono = "";
		String direccion = "";
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo mánager:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			in = new Scanner(System.in);
			System.out.println("Introduzca el telefono de empresa del nuevo mánager");
			telefono = in.nextLine();
			valido = Validador.validarTelefono(telefono);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el teéfono no es válido.");
		} while (!valido);

		valido = false;
		do {
			in = new Scanner(System.in);
			System.out.println("Introduzca la dirección del nuevo mánager:");
			direccion = in.next();
			valido = Validador.validarDireccion(direccion);
			if (!valido)
				System.out.println("ERROR: El valor introducido para la dirección no es válido.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Manager(id, telefono, direccion, dp);
		return ret;
	}

	@Override
	public String toString() {
		return id + persona.getNombre() + "(" + persona.getNifnie() + ") del año " + persona.getFechaNac() + ", tfno1 :"
				+ telefono + "tfno2 :" + persona.getTelefono();
	}

	public String data() {
		String ret = "";
		ret = persona.getId() + "|" + persona.getNombre() + "|" + persona.getNifnie() + "|" + persona.getFechaNac()
				+ "|" + persona.getTelefono() + "|" + this.id + "|" + this.telefono + "|" + this.direccion;
		return ret;
	}

	public static void exportamanagers() {
		System.out.println("Guardamos los datos en managers.txt");

		File fOut = new File("managers.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		String data;

		try {
			fw = new FileWriter(fOut);
			bw = new BufferedWriter(fw);
			// importando desde la clase datos
			for (int i = 0; i < Datos.MANAGERS.length; i++) {
				Manager m = new Manager();
				m = Datos.MANAGERS[i];
				bw.write(m.data() + "\n");
				bw.close();

			}
		} catch (IOException e) {
			{
				e.printStackTrace();
			}

		} finally {

		}

		System.out.println("------------------------");
	}
}
