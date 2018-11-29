package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Utilizador {
	
	@Id
	private String id;
	private String nome;
	private String login;
	private String password;
	private Role role;
	private String identificador;
	private Token token;
	private String especializacao;
	
	public Utilizador(String nome, String login, String password, Role role, String identificador, String especializacao) {
		super();
		this.id = null;
		this.nome = nome;
		this.login = login;
		this.password = password;
		this.role = role;
		this.identificador = identificador;
		this.token = null;
		this.especializacao = especializacao;
	}

	public Utilizador() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
}
