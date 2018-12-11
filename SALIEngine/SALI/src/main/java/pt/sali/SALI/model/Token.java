package pt.sali.SALI.model;

public class Token {
	
	private String tokenName;
	private int expiracao;
	
	public Token(String tokenName, int expiracao) {
		super();
		this.tokenName = tokenName;
		this.expiracao = expiracao;
	}
	
	public Token() {
		super();
	}

	public int getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(int expiracao) {
		this.expiracao = expiracao;
	}

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}
}
