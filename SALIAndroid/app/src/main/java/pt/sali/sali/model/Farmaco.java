package pt.sali.sali.model;

public class Farmaco {

	private String id;
	private String nome;
	
	public Farmaco(String nome) {
		super();
		this.id = null;
		this.nome = nome;
	}

	public Farmaco() {
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
