package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Pergunta {
	
	@Id
	private String id;
	private String pergunta;
	private String tipoDeResposta;
	private ArrayList<String> resposta;
	
	public Pergunta(String pergunta, String tipoDeResposta) {
		super();
		this.id = null;
		this.pergunta = pergunta;
		this.tipoDeResposta = tipoDeResposta;
		this.resposta = new ArrayList<>();
	}

	public Pergunta() {
		super();
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getTipoDeResposta() {
		return tipoDeResposta;
	}

	public void setTipoDeResposta(String tipoDeResposta) {
		this.tipoDeResposta = tipoDeResposta;
	}

	public ArrayList<String> getResposta() {
		return resposta;
	}

	public void setResposta(ArrayList<String> resposta) {
		this.resposta = resposta;
	}

	public String getId() {
		return id;
	}

}
