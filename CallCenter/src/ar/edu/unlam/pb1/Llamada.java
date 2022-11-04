package ar.edu.unlam.pb1;

public class Llamada {

	private boolean fueExitosa;
	private String observaciones;

	public Llamada(boolean fueExitosa, String observaciones) {
		this.setFueExitosa(fueExitosa);
		this.setObservaciones(observaciones);
	}

	public boolean isFueExitosa() {
		return fueExitosa;
	}

	public void setFueExitosa(boolean fueExitosa) {
		this.fueExitosa = fueExitosa;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		String siFueExitosa;
		if (fueExitosa) {
			siFueExitosa = " Llamada exitosa";
		} else {
			siFueExitosa = " Llamada no fue exitosa";
		}

		return siFueExitosa + "\n Observaciones registradas: " + observaciones;
	}
}
