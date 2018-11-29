package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Role {
	
	@Id
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

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
