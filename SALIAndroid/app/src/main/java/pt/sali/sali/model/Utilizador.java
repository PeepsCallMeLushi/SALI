package pt.sali.sali.model;

public class Utilizador {

	private String id;
	private String login;
	private String password;
	private Role role;
	private String identificador;
	private Token token;
	
	public Utilizador(String login, String password, Role role, String identificador) {
		super();
		this.id = null;
		this.login = login;
		this.password = password;
		this.role = role;
		this.identificador = identificador;
		this.token = null;
	}

	public Utilizador() {
		super();
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
}
