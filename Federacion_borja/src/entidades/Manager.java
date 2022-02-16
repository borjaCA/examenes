package entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import utils.Datos;
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
		String direccion = " ";
		String telefono = " ";
		Scanner in;
		boolean valido = false;
		// se le mete un validador al id para que siempre sea mayot de 0
		do {
			System.out.println("introduzca un id  >0");
			in = new Scanner(System.in);
			id = in.nextLong();
			if (id > 0)
				valido = true;
			else
				System.out.println("introduce un id mayor que cero");

		} while (!valido);
		// hacemos el validador de la direccion
		valido = false;
		do {
			System.out.println("introdice una direccion con mas de 5 letras");
			direccion = in.next();
			if (direccion.length() > 5)
				valido = true;
			else
				System.out.println("introduce una direccion con mas de 5 letras");
		} while (!valido);
		boolean validatlf = false;
		// validamos el numero de telefono a traves de los nuevos validadores que
		// hicimos
		do {
			System.out.println("introduce un telefono que sea correcro");
			telefono = in.next();
			validatlf = Validador.validarNIE(telefono);
		} while (!validatlf);
		ret = new Manager(id, direccion, telefono);
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
