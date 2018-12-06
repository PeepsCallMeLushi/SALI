package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Utilizador {
	
	@Id
	private String id;
	private String nome;
	private Role role;
	private String identificador;
	private Token token;
	private String especializacao;
	private Login login;
	private String estado;
	
	public Utilizador(String nome, Role role, String identificador, String especializacao, Login login, String estado) {
		super();
		this.nome = nome;
		this.role = role;
		this.identificador = identificador;
		this.token = new Token();
		this.especializacao = especializacao;
		this.login = login;
		this.estado = estado;
	}

	public Utilizador() {
		super();
		this.token = new Token();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
