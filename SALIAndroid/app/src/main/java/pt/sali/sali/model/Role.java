package pt.sali.sali.model;

public class Role {

	private String id;
	private String nome;
	
	public Role(String nome) {
		super();
		this.id = null;
		this.nome = nome;
	}

	public Role() {
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
