package pt.sali.sali.model;

public class Token {

	private String id;
	private String token;
	private int expiracao;
	
	public Token(String token, int expiracao) {
		super();
		this.id = null;
		this.token = token;
		this.expiracao = expiracao;
	}
	
	public Token() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(int expiracao) {
		this.expiracao = expiracao;
	}

	public String getId() {
		return id;
	}

}
