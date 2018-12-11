package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Farmaco {
	
	@Id
	private String id;
	private String nome;
	
	public Farmaco(String nome) {
		super();
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
