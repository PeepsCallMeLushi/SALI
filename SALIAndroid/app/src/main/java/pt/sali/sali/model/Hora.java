package pt.sali.sali.model;

public class Hora {

	private String id;
	private String chegada;
	private String local;
	private String saida;
	private String establecimento;
	private String disponivel;
	
	public Hora(String chegada, String local, String saida, String establecimento, String disponivel) {
		super();
		this.id = null;
		this.chegada = chegada;
		this.local = local;
		this.saida = saida;
		this.establecimento = establecimento;
		this.disponivel = disponivel;
	}
	
	public Hora() {
		super();
	}

	public String getChegada() {
		return chegada;
	}

	public void setChegada(String chegada) {
		this.chegada = chegada;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getEstablecimento() {
		return establecimento;
	}

	public void setEstablecimento(String establecimento) {
		this.establecimento = establecimento;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}

	public String getId() {
		return id;
	}
	
}
