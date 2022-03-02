package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

import entidades.*;
import utils.*;

public class Principal4 {

	public static void main(String[] args) {

//		 Ejercicio 2 examen 6
		exportatJuniors();

		Datos.cerrarResultados();
		System.out.println("INICIO");

		Scanner in;
		int elecc = -1;
		Rol rol; // Examen 4 Ejercicio 3A
		boolean correcto = false;
		while (true) {
			System.out.println("Bienvenido al programa de gestión de la FEDERACIÓN DEPORTIVA:");
			do {
				System.out.println("Seleccione el id del tipo de usuario o pulse 0 para SALIR:");
				int i = 1;
				for (Rol r : Rol.values()) {
					System.out.println(i + " " + r.getNombre());
					i++;
				}
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc == 0) {
					System.out.println("¿Está seguro de que desea SALIR?");
					if (Utilidades.leerBoolean()) {
						System.out.println("¡ADIOS!");
						return;
					}
				}
				if (elecc >= 1 && elecc <= Rol.values().length)
					correcto = true;
				else
					System.out.println("¡Valor invalido para el ROL seleccionado!");
			} while (!correcto);
			rol = Rol.values()[elecc - 1];

			Credenciales cred; // Examen 4 Ejericicio 3B
			boolean login = false;
			switch (rol.ordinal()) {
			case 0: // Rol.DIRECTIVA;
			case 1: // Rol.MANAGER
			case 2: // Rol.ATLETA;
			case 3: // Rol.COLEGIADO;
			case 4: // Rol.ADMIN;
				do {
					System.out.println("Introduzca sus credenciales de acceso.");
					System.out.println("Introduzca su nombre de usuario:");
					String usuario, password;
					usuario = in.next();
					System.out.println("Introduzca su contraseña:");
					password = in.next();
					cred = new Credenciales(usuario, password);
					login = login(cred);
					if (!login)
						System.out.println("ERROR: Usuario o password incorrectos.");
					else
						System.out.println("Login correcto con rol " + rol.getNombre());
				} while (!login);
				break;
			case 5: // Rol.INVITADO;
				System.out.println("Ha ingresado con el rol " + rol.getNombre());
			}

			mostrarMenu(rol);
		}

	} // Final del main

	/**
	 * 
	 */
	private static void exportatJuniors() {
		try {
			// TODO Auto-generated method stub
			File f = new File("juniors.dat");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Atleta a : Datos.ATLETAS) {

				DatosPersona dp = a.getPersona();
				if (dp.getFechaNac().isAfter(LocalDate.of(2000, 1, 1))) {
					oos.writeObject(a);

				}
				oos.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

	// Examen 3 Ejercicio 2 - Examen 4 Ejercicio 3C
	private static void mostrarMenu(Rol rol) {
		int elecc = -1;
		Scanner in = new Scanner(System.in);
		boolean valido = false;

		switch (rol.ordinal()) {
		case 0: // Rol.DIRECTIVA;
			do {
				mostrarMenuDirectiva();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuDirectiva(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 1: // Rol.MANAGER;
			do {
				mostrarMenuManager();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuManager(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER");
			break;
		case 2: // Rol.ATLETA
			do {
				mostrarMenuAtleta();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuAtleta(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 3: // Rol.COLEGIADO;
			do {
				mostrarMenuColegiado();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuColegiado(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 4: // Rol.ADMIN;
			do {
				mostrarMenuAdmin();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 4) {
					valido = true;
					mostrarSubmenuAdmin(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 5: // Rol.INVITADO;
			do {
				mostrarMenuInvitado();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				elecc = in.nextInt();
				if (elecc >= 0 && elecc <= 2) {
					valido = true;
					mostrarSubmenuInvitado(elecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || elecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		default:
		}

	}

	private static void mostrarSubmenuDirectiva(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		System.out.println("SUBMenús de la DIRECTIVA.");
		switch (elecc) {
		case 1:
			System.out.println("Ha seleccionado GESTIÓN de MEDALLAS.");
			do {
				mostrarMenuGestionMedallas();
				System.out.println("Seleccione una de las opciones anteriores.");
				in = new Scanner(System.in);
				subelecc = in.nextInt();
				if (subelecc >= 0 && subelecc <= 1) {
					valido = true;
					mostrarSubmenuGestionMedallas(subelecc);
				} else
					System.out.println("¡Valor seleccionado no válido!\n");
			} while (!valido || subelecc != 0);
			System.out.println("Ha elegido VOLVER.");
			break;
		case 2:
			System.out.println("Ha seleccionado GESTIÓN de COMPETICIONES y de PRUEBAS.");
			break;
		default:
		}

		System.out.println("Volviendo al menú de la DIRECTIVA...");
	}

	private static void mostrarMenuGestionMedallas() {
		System.out.println("Menú de GESTIÓN de MEDALLAS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Nueva Medalla\n" + "0. Volver");
	}

	private static void mostrarSubmenuGestionMedallas(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		System.out.println("\nGESTIÓN de MEDALLAS.");
		switch (elecc) {
		case 1: // opción 1.1.1
			do {
				System.out.println("Ha seleccionado Nueva MEDALLA.");
				System.out.println("Seleccione 1 para ORO, 2 para PLATA o 3 para BRONCE.");
				subelecc = in.nextInt();
				if (subelecc != 1 && subelecc != 2 && subelecc != 3)
					System.out.println("¡Valor seleccionado no válido!\n");
				else
					valido = true;
			} while (!valido);
			Metal nuevo;
			if (subelecc == 1) {
				System.out.println("Ha seleccionado Nuevo ORO");
				nuevo = Oro.nuevoOro();
			} else if (subelecc == 2) {
				System.out.println("Ha seleccionado Nueva PLATA");
				nuevo = (Plata) Plata.nuevoPlata();
			} else {
				System.out.println("Ha seleccionado Nuevo BRONCE");
				nuevo = (Bronce) Bronce.nuevoBronce();
			}
			System.out.println("Se ha introducido una nueva medalla correctamente.");
			System.out.println(nuevo);
			break;
//		case 2:  //opción 1.1.2
//			System.out.println("Ha seleccionado ver medallas ");
		/**
		 * le diria al usuario que eligiese que medallas o que medalla quiere ver con
		 * uno bucles if por si quiere ver mas de una medalla y con todos los bucles if
		 * y else if para poder mostrarle todo los distintos tipos de búsqueda Pero no
		 * me sale como hacerlo bien
		 */
//			break;

		default:
		}
		System.out.println("Volviendo al menú principal de gestión de medallas...");

	}

	private static void mostrarSubmenuManager(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1: // opción 2.1
			System.out.println("Ha seleccionado CONFORMAR EQUIPO.");
			Equipo eq;
			eq = Equipo.nuevoEquipo();
			redactarPrueba();

			break;
		case 2: // opción 2.2
			System.out.println("Ha seleccionado INSCRIPCIÓN de EQUIPO en PRUEBA.");
			break;
		default:
		}
		System.out.println("Volviendo al menú de MÁNAGERS...\n\n");
	}

	private static void mostrarSubmenuAtleta(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1: //// opción 3.1
			System.out.println("Ha seleccionado FEDERARSE (Nuevo ATLETA).");
			System.out.println("Introduce los elementos del nuevo atleta");
			Atleta atleta1 = new Atleta();
			atleta1 = Atleta.nuevoAtleta();
			break;
		case 2: // opción 3.2

			System.out.println("Ha seleccionado INSCRIPCIÓN de ATLETA en PRUEBA..");
			boolean confirmacion = false;
			Atleta at;
			while (confirmacion != true) {
				System.out.println("introduce el nuevo Atleta");
				at = Atleta.nuevoAtleta();
				System.out.println("El atleta introducido es:" + at.toString());
				char resp = ' ';

				System.out.println("¿Es correcto el atleta que has metido?");
				if (Utilidades.leerBoolean()) {
					confirmacion = true;
				} else
					confirmacion = false;
			}

			File fichero = new File("pruebas.txt");
			FileReader lector = null;
			BufferedReader buffer = null;
			try {
				try {
					lector = new FileReader(fichero);
					buffer = new BufferedReader(lector);
					String linea;
					while ((linea = buffer.readLine()) != null) {
						String[] campos = linea.split("\\|");
						String idPrueba = campos[0];
						String nombre = campos[1];
						String fecha = campos[2];
						String lugar = campos[3];
						String individual = campos[4];
//							if ( individual ) {
//								
//							}
					}
				} finally {
					if (buffer != null) {
						buffer.close();
					}
					if (lector != null) {
						lector.close();
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
			} catch (IOException e) {
				System.out.println("Se ha producido una IOException" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha producido una Exception" + e.getMessage());
			}

			Prueba prueba = null;
			valido = false;
			long idPrueba = -1;
			char resp = ' ';
			do {
				System.out.println("introduce el id de la prueba que quieras");
				for (Prueba p : Datos.PRUEBAS) {
					idPrueba = in.nextLong();

					if (p.isIndividual() == true && idPrueba > 0) {
						System.out.println("Quieres esta prueba");
						p.setId(idPrueba);
						prueba = Datos.PRUEBAS[(int) p.getId()];
						resp = in.next().charAt(0);
						if (resp == 's' && resp == 'S') {
							valido = true;
							File file = new File("inscrip_" + p.getId() + "_.dat");
						} else
							;

						valido = false;
					}
					valido = false;
				}
			} while (!valido);

			break;
		default:
		}
		System.out.println("Volviendo al menú de ATLETAS...\n\n");
	}

	private static void mostrarSubmenuColegiado(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1: //// opción 4.1
			System.out.println("Ha seleccionado Nuevo COLEGIADO.");
			Colegiado nuevo = Colegiado.nuevoColegiado();
			System.out.println("Se ha creado correctamente el nuevo colegiado:" + nuevo);
			break;
		case 2: //// opción 4.2
			System.out.println("Ha seleccionado INTRODUCIR RESULTADOS de PRUEBA..");
			break;
		default:
		}
		System.out.println("Volviendo al menú de COLEGIADOS...\n\n");
	}

	private static void mostrarSubmenuAdmin(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		switch (elecc) {
		case 1:
			System.out.println("Ha seleccionado Gestión de medallas, de competiciones y de pruebas.");
			break;
		case 2:
			System.out.println("Ha seleccionado Gestión de equipos.");
			break;
		case 3:
			System.out.println("Ha seleccionado Gestión de atletas.");
			break;
		case 4:
			System.out.println("Ha seleccionado Gestión de arbitrajes y resultados.");
			break;
		default:
		}
		System.out.println("Volviendo al menú de ADMINISTRADORES...\n\n");
	}

	private static void mostrarSubmenuInvitado(int elecc) {
		Scanner in = new Scanner(System.in);
		int subelecc = -1;
		boolean valido = false;
		System.out.println("SUBMenús para INVITADOS.");
		System.out.println("Volviendo al menú principal...\n\n");
	}

	private static void mostrarMenuDirectiva() {
		System.out.println("Menú de la DIRECTIVA.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Gestión de medallas\n" + "2. Gestión de competiciones y pruebas.\n" + "0. Volver");
	}

	private static void mostrarMenuManager() {
		System.out.println("Menú para los MÁNAGERS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Conformar equipo\n" + "2. Inscripcion de equipo en prueba.\n" + "0. Volver");
	}

	private static void mostrarMenuAtleta() {
		System.out.println("Menú para los ATLETAS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Federarse (nuevo Atleta)\n" + "2. Inscrcipcion de atleta en prueba.\n" + "0. Volver");

	}

	private static void mostrarMenuColegiado() {
		System.out.println("Menú para los COLEGIADOS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Nuevo Colegiado\n" + "2. Introducir resultados de prueba.\n" + "0. Volver");
	}

	private static void mostrarMenuAdmin() {
		System.out.println("Menú para los ADMINISTRADORES.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("1. Gestión de medallas, de competiciones y de pruebas\n" + "2. Gestión de equipos.\n"
				+ "3. Gestión de atletas.\n" + "4. Gestión de arbitrajes y resultados.\n" + "0. Volver");
	}

	private static void mostrarMenuInvitado() {
		System.out.println("Menú para los INVITADOS.");
		System.out.println("Seleccione una de las siguientes opciones:");
		System.out.println("" + "0. Volver");
	}

	private static boolean login(Credenciales cred) {

		boolean credencialcorrecta = false;
		ObjectInputStream ois = null;
		try {
			File f = new File("credenciales.txt");
			FileInputStream fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			while (true) {
				Credenciales ce = (Credenciales) ois.readObject();

				if (cred.getPassword() == ce.getPassword()) {
					if (cred.getUsuario() == ce.getUsuario()) {
						credencialcorrecta = true;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return credencialcorrecta;

	}

	/// Examen 7 Ejercicio 3
	private static boolean login() {
		boolean ret = false;
		File fichero = new File("managers.txt");
		FileReader lector = null;
		BufferedReader buffer = null;
		try {
			try {
				lector = new FileReader(fichero);
				buffer = new BufferedReader(lector);
				String linea;
				while ((linea = buffer.readLine()) != null) {
					String[] campos = linea.split("\\|");
					/// <DatosPersona.id>|<DatosPersona.nombre>|<DatosPersona.documentacion>|<DatosPersona.fechaNac>|<DatosPersona.telefono>
					/// |<Manager.id>|<Manager.telefono>|<Manager.direccion>
					String DatosPersona_id = campos[0];
					String DatosPersona_nombre = campos[1];
					String DatosPersona_documentacion = campos[2];
					String DatosPersona_fechaNac = campos[3];
					String datosPersona_telefono = campos[4];

					String Manager_id = campos[5];
					String Manager_telefono = campos[6];
					String Manager_direccion = campos[7];
					boolean representaEquipo = false;
					Equipo equipoRepresentado = null;
					for (Equipo e : Datos.EQUIPOS) {
						if (e.getManager().getId() == Long.valueOf(Manager_id)) {
							representaEquipo = true;
							equipoRepresentado = e;
							break;
						}
					}
					if (!representaEquipo)
						System.out.println("El manager " + DatosPersona_nombre + " de id " + Manager_id
								+ " no representa a ningún equipo.");
					else {
						String cad = "";
						cad += "D./Dña. " + DatosPersona_nombre + " con NIF:NIE " + DatosPersona_documentacion
								+ " nacido el " + DatosPersona_fechaNac + " representa al equipo "
								+ equipoRepresentado.getNombre() + " de id " + equipoRepresentado.getId()
								+ " durante el año " + equipoRepresentado.getAnioinscripcion()
								+ ", el cual está conformado por lossiguientes atletas:";
						for (Atleta a : equipoRepresentado.getAtletas())
							cad += "\t" + a.toString() + "\n";
						System.out.println(cad);
					}
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (lector != null) {
					lector.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
		return ret;
	}

//APARTADO B Y C DEL 1
	public static void redactarPrueba() {
		Scanner teclado = new Scanner(System.in);
		boolean ret = false;
		File fichero = new File("pruebas.txt");
		FileReader lector = null;
		BufferedReader buffer = null;
		int subelecc = -1;
		boolean valido = false;
		Equipo nuevo = Equipo.nuevoEquipo();
		Prueba pruebaSelecc = null;
		try {
			Prueba[] colectivas = new Prueba[256];
			int i = 0;
			try {
				lector = new FileReader(fichero);
				buffer = new BufferedReader(lector);
				String linea;
				while ((linea = buffer.readLine()) != null) {
					String[] campos = linea.split("\\|");
					long idPrueba = Long.valueOf(campos[0]);
					String nombrePrueba = campos[1];
					LocalDate fecha = LocalDate.parse(campos[2], DateTimeFormatter.ofPattern("dd/MM/YYYY"));
					String lugarString = campos[3];

					Lugar lugar = null;
					for (Lugar l : Lugar.values()) {
						if (l.name().equalsIgnoreCase(lugarString)) {
							lugar = l;
						}
					}
					boolean individual = Boolean.valueOf(campos[4]);
					Prueba pr = new Prueba(idPrueba, nombrePrueba, fecha, lugar, individual);
					if (pr.isIndividual()) {
						System.out.println("" + pr);
						colectivas[i] = pr;
						i++;
					}
				}

				do {
					System.out.println("Introduzca el id de la prueba en que desea inscribirse:");
					subelecc = teclado.nextInt();
					for (int j = 0; j < i; j++) {
						if (((Prueba) colectivas[j]).getId() == subelecc) {

							pruebaSelecc = colectivas[j];
							valido = true;
							break;
						}
					}
					if (!valido) {
						System.out.println("El valor " + subelecc
								+ " no es válido. Se le mostrarán de nuevo las pruebas colectivas:");
						for (Prueba aux : colectivas) {
							if (aux != null) {
								System.out.println("" + aux);
							}
						}
					} else {
						System.out.println("Se ha elegido la prueba de id:" + subelecc + ". ¿Es correcto?");
						if (valido = Utilidades.leerBoolean()) {
							break;
						} else {
							System.out.println("Se le mostrarán de nuevo las pruebas colectivas:");
							for (Prueba aux : colectivas) {
								if (aux != null) {
									System.out.println("" + aux);
								}
							}
						}
					}
				} while (!valido);

			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (lector != null) {
					lector.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
		valido = false;
		String path = "inscrip_" + pruebaSelecc.getId() + "_" + nuevo.getManager().getPersona().getNifnie().mostrar()
				+ ".dat";
		try {
			FileOutputStream ficheroInscrip = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(ficheroInscrip);
			escritor.writeObject((Equipo) nuevo);
			escritor.writeObject((Long) pruebaSelecc.getId());
			LocalDateTime ahora = LocalDateTime.now();
			escritor.writeObject((LocalDateTime) ahora);
			escritor.flush();
			valido = true;
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}

		if (!valido) {
			System.out.println("ERROR: No se creó el fichero con la inscripcion.");
		} else {
			try {
				File ficheroLeido = new File(path);
				FileInputStream ficheroInscrip = new FileInputStream(ficheroLeido);
				ObjectInputStream lectorFichInsc = new ObjectInputStream(ficheroInscrip);
				Equipo equipoLeido = (Equipo) lectorFichInsc.readObject();
				Long idPruebaLeido = (Long) lectorFichInsc.readObject();
				LocalDateTime fechahoraLeida = (LocalDateTime) lectorFichInsc.readObject();
				System.out.println("Se ha creado el fichero " + path + " a "
						+ fechahoraLeida.format(DateTimeFormatter.ofPattern("dd/MM/YY hh:mm:ss"))
						+ ",  que el id del  equipo " + equipoLeido.getId() + " de nombre "
						+ equipoLeido.getManager().getPersona().getNombre() + " y NIF/NIE "
						+ equipoLeido.getManager().getPersona().getNifnie().mostrar() + " queda"
						+ "inscrito en la prueba " + idPruebaLeido + " de nombre " + pruebaSelecc.getNombre()
						+ " celebrada en " + pruebaSelecc.getLugar().getNombre() + " el día "
						+ pruebaSelecc.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + ".");
				valido = true;
				lectorFichInsc.close();
			} catch (FileNotFoundException e) {
				System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
			} catch (IOException e) {
				System.out.println("Se ha producido una IOException" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha producido una Exception" + e.getMessage());
			}
		}

	}
}
