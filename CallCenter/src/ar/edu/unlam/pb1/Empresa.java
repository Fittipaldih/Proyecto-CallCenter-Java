package ar.edu.unlam.pb1;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	private int zonasDeCobertura[];
	private Contacto listaContactos[];
	private String nombre;
	private final int ZONAS_COBERTURA_MAX = 10, LISTA_CONTACTOS_MAX = 10;

	public Empresa(String nombre) {
		zonasDeCobertura = new int[ZONAS_COBERTURA_MAX];
		listaContactos = new Contacto[LISTA_CONTACTOS_MAX];
		this.nombre = nombre;
	}

	public String getNombreEmpresa() {
		/* Devuelve el nombre de la empresa */
		return this.nombre;
	}

	public boolean agregarNuevoContacto(Contacto nuevo) {

		/*
		 * Incorpora un nuevo contacto a la empresa
		 */

		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] == null) {
				listaContactos[i] = nuevo;
				return true;
			}
		}

		return false;
	}

	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican
		 * por el codigo postal)
		 */
		for (int i = 0; i < zonasDeCobertura.length; i++) {
			if (zonasDeCobertura[i] == 0) {
				zonasDeCobertura[i] = codigoPostal;
				return true;
			}
		}

		return false;
	}

	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un código postal está dentro de la zona de cobertura
		 */

		for (int i = 0; i < zonasDeCobertura.length; i++) {
			if (zonasDeCobertura[i] == codigoPostal) {
				return true;
			}
		}
		return false;
	}

	public Contacto buscarCandidato() {
		/*
		 * Para determinar qué contacto el sistema debe mostrar, se debe realizar la
		 * siguiente búsqueda: 1. El contacto NO debe ser cliente aún. 2. El contacto
		 * desea ser llamado o al menos no informó lo contrario. 3. El código postal del
		 * contacto debe existir en las zonas de cobertura existente. 4. Del conjunto de
		 * contactos resultante se debe seleccionar aleatoriamente el próximo llamado.
		 */
		Contacto listaContactosPosibles[] = new Contacto[listaContactos.length];
		Contacto contactoSeleccionado = null;
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] != null && !listaContactos[i].isEsCliente() && listaContactos[i].isDeseaSerLlamado()
					&& elCodigoPostalEstaDentroDeLaZonaDeCobertura(listaContactos[i].getCodPostal())) {

				for (int j = 0; j < listaContactosPosibles.length; j++) {
					if (listaContactosPosibles[j] == null) {
						listaContactosPosibles[j] = listaContactos[i];
					}
				}
			}
		}
		for (int i = 0; i < listaContactosPosibles.length; i++) {
			if (listaContactosPosibles != null) {
				contactoSeleccionado = listaContactosPosibles[(int) (Math.random() * listaContactosPosibles.length)];
			}
		}

		return contactoSeleccionado;
	}

	public Contacto buscarContactoPorNombre(String nombre2) {
		for (int i = 0; i < listaContactos.length; i++) {
			if (listaContactos[i] != null && listaContactos[i].getNombre().equalsIgnoreCase(nombre2)) {
				return listaContactos[i];
			}
		}
		return null;
	}
}
