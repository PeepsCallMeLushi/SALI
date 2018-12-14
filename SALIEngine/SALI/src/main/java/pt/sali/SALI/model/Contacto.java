package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Contacto {

	@Id
	private String id;
	private String contacto;
	private String nome;
	
	public Contacto(String nome, String contacto) {
		super();
		this.nome = nome;
		this.contacto = contacto;
	}
	
	public Contacto() {
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
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}
