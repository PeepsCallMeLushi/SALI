package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Role {
	
	@Id
	private String id;
	private String nome;
	private String descricao;
	
	public Role(String nome, String descricao) {
		super();
		this.id = null;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
