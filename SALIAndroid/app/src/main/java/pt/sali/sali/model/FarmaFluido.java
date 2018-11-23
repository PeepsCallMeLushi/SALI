package pt.sali.sali.model;

public class FarmaFluido {

	private String id;
	private String hora;
	private String fluido;
	private String dose;
	private String via;
	
	public FarmaFluido(String hora, String fluido, String dose, String via) {
		super();
		this.id = null;
		this.hora = hora;
		this.fluido = fluido;
		this.dose = dose;
		this.via = via;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFluido() {
		return fluido;
	}

	public void setFluido(String fluido) {
		this.fluido = fluido;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getId() {
		return id;
	}

}
