package pt.sali.SALI.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Ocorrencia {
	
	@Id
	private String id;
	private String tipoViaturaAssistencia;
	private Date data;
	private ArrayList<String> incidente;
	private int nmrVitimas;
	private String local;
	private String freguesia;
	private Utente utente;

}
