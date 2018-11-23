package pt.sali.SALI.model;

public class Idade {
	
	private String quantidade;
	private String tipoDeIdade;
	
	public Idade(String quantidade, String tipoDeIdade) {
		super();
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
}
