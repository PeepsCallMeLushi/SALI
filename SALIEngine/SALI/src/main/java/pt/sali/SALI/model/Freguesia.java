package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Freguesia {
	
	@Id
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
