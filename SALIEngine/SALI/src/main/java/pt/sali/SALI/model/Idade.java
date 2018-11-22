package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Idade {
	
	@Id
	private String id;
	private String quantidade;
	private String tipoDeIdade;
	
	public Idade(String quantidade, String tipoDeIdade) {
		super();
		this.id = null;
		this.quantidade = quantidade;
		this.tipoDeIdade = tipoDeIdade;
	}
	
	public Idade() {
		super();
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipoDeIdade() {
		return tipoDeIdade;
	}

	public void setTipoDeIdade(String tipoDeIdade) {
		this.tipoDeIdade = tipoDeIdade;
	}

	public String getId() {
		return id;
	}

}
