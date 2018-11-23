package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class NomeParaSerAlterado {
	
	@Id
	private String id;
	private String hora;
	private String esteNomeEstaMeADarDoresDeCabeca;
	private String dose;
	private String via;
	
	public NomeParaSerAlterado(String hora, String esteNomeEstaMeADarDoresDeCabeca, String dose,
			String via) {
		super();
		this.id = null;
		this.hora = hora;
		this.esteNomeEstaMeADarDoresDeCabeca = esteNomeEstaMeADarDoresDeCabeca;
		this.dose = dose;
		this.via = via;
	}

	public NomeParaSerAlterado() {
		super();
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEsteNomeEstaMeADarDoresDeCabeca() {
		return esteNomeEstaMeADarDoresDeCabeca;
	}

	public void setEsteNomeEstaMeADarDoresDeCabeca(String esteNomeEstaMeADarDoresDeCabeca) {
		this.esteNomeEstaMeADarDoresDeCabeca = esteNomeEstaMeADarDoresDeCabeca;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getVisa() {
		return via;
	}

	public void setVisa(String via) {
		this.via = via;
	}

	public String getId() {
		return id;
	}

}
