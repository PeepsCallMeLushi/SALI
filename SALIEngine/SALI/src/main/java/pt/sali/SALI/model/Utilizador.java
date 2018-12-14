package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Utilizador {
	
	@Id
	private String id;
	private String nome;
	private Role role;
	private String identificador;
	private Token tokenRest;
	private Token tokenSpring;
	private String especializacao;
	private Login login;
	private String foto;
	@JsonProperty
	private boolean firstLogin;
	private String estado;
	
	public Utilizador(String nome, Role role, String identificador, Token tokenRest, Token tokenSpring,
			String especializacao, Login login, String foto, boolean firstLogin, String estado) {
		super();
		this.nome = nome;
		this.role = role;
		this.identificador = identificador;
		this.tokenRest = new Token();
		this.tokenSpring = new Token();
		this.especializacao = especializacao;
		this.login = login;
		this.foto = foto;
		this.firstLogin = true;
		this.estado = estado;
	}

	public Utilizador() {
		super();
		this.tokenRest = new Token();
		this.tokenSpring = new Token();
		this.firstLogin = true;
		this.estado = "Ativo";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Token getTokenRest() {
		return tokenRest;
	}

	public void setTokenRest(Token tokenRest) {
		this.tokenRest = tokenRest;
	}

	public Token getTokenSpring() {
		return tokenSpring;
	}

	public void setTokenSpring(Token tokenSpring) {
		this.tokenSpring = tokenSpring;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}
}
