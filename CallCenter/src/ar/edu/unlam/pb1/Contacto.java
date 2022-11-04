package ar.edu.unlam.pb1;

import java.util.Arrays;

public class Contacto {

	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * • Nombre y Apellido: No se aceptan números. • Celular: Compuesto del código
	 * de país + código de área + número de celular. • E-Mail: Debe contener al
	 * menos el símbolo ‘@’ y el caracter ‘.’. • Dirección: Valor alfanumérico. •
	 * Código Postal: Valor numérico. • Localidad: Valor alfanumérico. • Provincia.
	 * Enumerador que contenga las 23 provincias argentinas. • Es cliente (Si o No):
	 * Inicialmente se carga en “No”. • Desea ser llamado nuevamente (Si o No):
	 * Inicialmente se carga en “Si”.
	 */

	private String nombre, apellido, celular, email, direccion, localidad;
	private int codPostal;
	private Provincia provincia;
	private boolean esCliente, deseaSerLlamado;
	private Llamada llamadasRecibidas[];

	public Contacto(String nombre, String apellido, String celular, String email, String direccion, int codPostal,
			String localidad, Provincia provincia) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.esCliente = false;
		this.deseaSerLlamado = true;
		this.llamadasRecibidas = new Llamada [10];
	}

	public boolean esEmailValido(String eMail) {
		/*
		 * Evalúa si un String determinado puede ser almacenado como E-MAIL. TAMBIEN SE
		 * PODIA HACER CON CHARAT (I) Y UN FOR. O CON TOCHARARRAY.. PERO ES MAS RAPIDO
		 * ASI
		 */

		if (eMail.contains("@") && eMail.contains(".")) {
			return true;
		}

		return false;
	}

	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */

		for (int i = 0; i < llamadasRecibidas.length; i++) {
			if (llamadasRecibidas[i] == null) {
				llamadasRecibidas[i] = nueva;
				return true;
			}
		}

		return false;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public boolean isEsCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	public boolean isDeseaSerLlamado() {
		return deseaSerLlamado;
	}

	public void setDeseaSerLlamado(boolean deseaSerLlamado) {
		this.deseaSerLlamado = deseaSerLlamado;
	}

	public Llamada[] getLlamadasRecibidas() {
		return llamadasRecibidas;
	}

	public void setLlamadasRecibidas(Llamada[] llamadasRecibidas) {
		this.llamadasRecibidas = llamadasRecibidas;
		
	}

	@Override
	public String toString() {

		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro
		 * de las llamadas realizadas.
		 */
		String retorno = "";
		String deseaLlamada="";
		String esCliente1; 
		if (deseaSerLlamado) {
			deseaLlamada = " Si ";
		} else {
			deseaLlamada= " No ";
		}
		
		if ( esCliente) {
			esCliente1 = " Si ";
		} else {
			esCliente1 = " No";
		}
		
			retorno = "Contacto " + nombre + " " + apellido + "\n Celular: " + celular + "\n Email registrado: " + email
					+ "\nSu direccion: " + direccion + ", Localidad: " + localidad + ", Es cliente: " + esCliente1
					+ "\nDesea ser llamado nuevamente?" + deseaLlamada + "\n";
			for (int i = 0; i < llamadasRecibidas.length; i++) {
			if (llamadasRecibidas[i] != null) {
				retorno += "\nLas llamadas que recibió fueron las siguientes \n" + (i+1) +" " +llamadasRecibidas[i].toString();
			}

		}
		return retorno;
	}
}
