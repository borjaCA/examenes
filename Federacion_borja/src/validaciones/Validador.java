package validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.NIF;

public class Validador {
		public static boolean validarNombre(String nombre) {
			// regEx general para cadena de caracteres con longitud entre 1 y 50 caracteres,
			// aceptando dígitos, letras MAYUS y minúsculas, con tildes, diréresis y
			// diferentes símbolos especiales
			// Pattern patron = Pattern.compile("[
			// 0-9A-Za-zñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜ¡!¿?@#$%()=+-€/.,]{1,50}");
			Pattern patron = Pattern.compile("[ A-Za-zñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜ-]{3,50}");
			Matcher comprobacion = patron.matcher(nombre);
			return comprobacion.matches();//
		}

		public static boolean validarTelefono(String tfn) {
			return tfn.trim().chars().allMatch(Character::isDigit);
		}

		public static boolean validarNIE(String nie) {
			boolean esValido = false;
			int i = 1;
			int caracterASCII = 0;
			char letra = ' ';
			int miNIE = 0;
			int resto = 0;
			char[] asignacionLetra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
					'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

			if (nie.length() == 9 && Character.isLetter(nie.charAt(8)) && nie.substring(0, 1).toUpperCase().equals("X")
					|| nie.substring(0, 1).toUpperCase().equals("Y") || nie.substring(0, 1).toUpperCase().equals("Z")) {

				do {
					caracterASCII = nie.codePointAt(i);
					esValido = (caracterASCII > 47 && caracterASCII < 58);
					i++;
				} while (i < nie.length() - 1 && esValido);
			}

			if (esValido && nie.substring(0, 1).toUpperCase().equals("X")) {
				nie = "0" + nie.substring(1, 9);
			} else if (esValido && nie.substring(0, 1).toUpperCase().equals("Y")) {
				nie = "1" + nie.substring(1, 9);
			} else if (esValido && nie.substring(0, 1).toUpperCase().equals("Z")) {
				nie = "2" + nie.substring(1, 9);
			}

			if (esValido) {
				letra = Character.toUpperCase(nie.charAt(8));
				miNIE = Integer.parseInt(nie.substring(0, 8));
				resto = miNIE % 23;
				esValido = (letra == asignacionLetra[resto]);
			}

			return esValido;
		}

		private static boolean validarNIF(String nif) {
			boolean ret = false;
			if (nif.length() != 9)
				ret = false;
			if (!Character.isLetter(nif.charAt(nif.length() - 1)))
				ret = false;
			// Usamos validador de AEAT --> valnif.jar
			Validador val = new Validador();
			ret = (val.checkNif(nif) > 0 ? true : false);
			return ret;
		}

		private int checkNif(String nif) {
			// TODO Auto-generated method stub
			return 0;
		}


	}

