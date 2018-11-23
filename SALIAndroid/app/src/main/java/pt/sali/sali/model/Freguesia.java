package pt.sali.sali.model;

public class Freguesia {

	private String id;
	private String nome;
	public Freguesia( String nome) {
		super();
		this.id = null;
		this.nome = nome;
	}
	public Freguesia() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}

}
