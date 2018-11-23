package pt.sali.sali.model;

public class Idade {

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
