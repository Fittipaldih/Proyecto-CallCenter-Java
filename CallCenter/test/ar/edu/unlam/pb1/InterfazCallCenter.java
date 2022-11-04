package ar.edu.unlam.pb1;

import java.util.Scanner;

public class InterfazCallCenter {

	public static void main(String args[]) {

		Empresa oesteCableColor = new Empresa("Oeste Cable Color");
		Scanner teclado = new Scanner(System.in);
		menuInicial(teclado, oesteCableColor);
	}

	private static void menuInicial(Scanner teclado, Empresa empresa) {
		int opcion;
		do {
			System.out.println("Bienvenido al callcenter");
			System.out.println("************************");
			System.out.println("Menu de opciones\n");
			System.out.println("1 - Incorporar zona de cobertura");
			System.out.println("2 - Dar de alta un nuevo contacto");
			System.out.println("3 - Realizar nueva llamada");
			System.out.println("4 - Ver información del contacto");
			System.out.println("9 - Salir");
			System.out.println("************************");

			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				incorporarZonaDeCobertura(teclado, empresa);
				break;
			case 2:
				darDeAltaNuevoContacto(teclado, empresa);
				break;
			case 3:
				realizarNuevaLlamada(teclado, empresa);
				break;
			case 4:
				verInformacionDelContacto(teclado, empresa);
				break;
			case 9:
				System.out.println("Hasta luego");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		} while (opcion != 9);
	}

	private static void incorporarZonaDeCobertura(Scanner teclado, Empresa empresa) {
		/*
		 * Se registra un nuevo código postal dentro de la zona de cobertura de la
		 * empresa
		 */

		System.out.println("Ingrese num de CP a incorporar");
		int numCP = teclado.nextInt();
		if (empresa.agregarNuevaZonaDeCobertura(numCP)) {
			System.out.println(numCP + " agregado correctamente");
		} else {
			System.out.println("No se pudo agregar, comuniquese con el tecnico");
		}

	}

	private static void darDeAltaNuevoContacto(Scanner teclado, Empresa empresa) {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		System.out.println("Ingrese nombre");
		String nombre = teclado.next();
		System.out.println("Ingrese apellido");
		String apellido = teclado.next();
		System.out.println("Ingrese celular");
		String celular = teclado.next();
		System.out.println("Ingrese email");
		String eMail = teclado.next();
		System.out.println("Ingrese direccion");
		teclado.nextLine();
		String direccion = teclado.nextLine();
		System.out.println("ingrese C. P ");
		int cp = teclado.nextInt();
		System.out.println("Ingrese localidad");
		teclado.nextLine();
		String localidad = teclado.nextLine();
		System.out.println("Ingrese provincia");

		Provincia arrayProvincias[] = Provincia.values();
		for (int i = 0; i < arrayProvincias.length; i++) {
			System.out.println("Seleccione " + (i + 1) + " ) para " + arrayProvincias[i]);
		}

		int provinciaTeclado = teclado.nextInt();
		Provincia provincia = Provincia.values()[provinciaTeclado - 1];

		Contacto contactoNuevo = new Contacto(nombre, apellido, celular, eMail, direccion, cp, localidad, provincia);

		if (contactoNuevo.esEmailValido(eMail)) {
			System.out.println("Contacto validado y añadido correctamente");
			empresa.agregarNuevoContacto(contactoNuevo);
		} else {
			System.out.println("El email no es valido, no se pudo registrar el contacto");
		}

	}

	private static void realizarNuevaLlamada(Scanner teclado, Empresa empresa) {
		/*
		 * Busca un candidato, muestra los datos del mismo, y permite almacenar el
		 * resultado de la llamada.
		 * 
		 * a. Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y
		 * no se lo debe volver a llamar). b. Si el contacto no desea ser llamado
		 * nuevamente (la llamada pudo no haber sido exitosa, pero se haga un nuevo
		 * intento en el futuro). c. Observaciones: Texto libre donde el operador deja
		 * registro de lo conversado.
		 */
		Contacto contactoALlamar = empresa.buscarCandidato();
		boolean llamadaExitosa = false, deseaSerLlamado = true;
		if (contactoALlamar != null) {
			System.out.println(contactoALlamar);

			System.out.println("La llamada fue exitosa? 1- SI   2- NO");
			int llamadaExitosaTeclado = teclado.nextInt();
						
			System.out.println("El contacto desea ser llamado nuevamente? 1-SI  2-NO");
			int deseaSerLlamadoTeclado = teclado.nextInt();
			
			System.out.println("Ingrese observaciones");
			teclado.nextLine();
			String observaciones = teclado.nextLine();

			if ( llamadaExitosaTeclado == 1) {
				llamadaExitosa = true;
				deseaSerLlamado = false;
			}
			
			if ( deseaSerLlamadoTeclado == 2) {
				deseaSerLlamado = false;
			}

			Llamada llamada = new Llamada (llamadaExitosa, observaciones);
			contactoALlamar.setDeseaSerLlamado(deseaSerLlamado);
			contactoALlamar.registrarNuevaLlamada(llamada);
			
			

		} else {
			System.out.println("No se encontro ningun contacto posible");
		}

	}

	private static void verInformacionDelContacto(Scanner teclado, Empresa empresa) {
		/*
		 * Se visualiza la información del contacto, incluso el listado de las llamadas
		 * que se le hicieron
		 */

		System.out.println("Indique nombre del contacto a buscar");
		String nombre = teclado.next();
		Contacto contactoBuscadoPorNombre = empresa.buscarContactoPorNombre(nombre);
		if (contactoBuscadoPorNombre != null) {
			System.out.println(contactoBuscadoPorNombre);

		/*	Llamada[] llamadasAlContactoBuscado = contactoBuscadoPorNombre.getLlamadasRecibidas();

			for (int i = 0; i < llamadasAlContactoBuscado.length; i++) {
				if (llamadasAlContactoBuscado[i] != null) {
					System.out.println(llamadasAlContactoBuscado[i]);
				}
			}*/
		} else {
			System.out.println("No se encontro el contacto, intente nuevamente");
		}

	}
}
