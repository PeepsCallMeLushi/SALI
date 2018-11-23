package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Atuacao {
	
	@Id
	private String id;
	private ArrayList<String> acao;
	private Transporte transporte;
	private String Destino;
	private String naoTransporte;
	private String evolucao;
		
}
