package pt.sali.sali.model;

public class Role {

	private String id;
	private String nome;
	private String decricao;
	
	public Role(String nome, String decricao) {
		super();
		this.id = null;
		this.nome = nome;
		this.decricao = decricao;
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

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public String getId() {
		return id;
	}

}
