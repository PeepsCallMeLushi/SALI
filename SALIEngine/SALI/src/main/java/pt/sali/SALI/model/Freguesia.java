package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Freguesia {
	
	@Id
	private String id;
	private String nome;
	private String concelho;
	private String cidade;
	
	public Freguesia( String nome, String concelho, String cidade) {
		super();
		this.nome = nome;
		this.concelho = concelho;
		this.cidade = cidade;
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
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getConcelho() {
		return concelho;
	}
	
	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}
}
