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
	private ArrayList<Utente> utentes;
	private Equipa equipa;
	
	public Ocorrencia(String tipoViaturaAssistencia, Date data, int nmrVitimas,
			String local, String freguesia, Equipa equipa) {
		super();
		this.id = null;
		this.tipoViaturaAssistencia = tipoViaturaAssistencia;
		this.data = data;
		this.incidente = new ArrayList<>();
		this.nmrVitimas = nmrVitimas;
		this.local = local;
		this.freguesia = freguesia;
		this.utentes = new ArrayList<>();
		this.equipa = equipa;
	}

	public Ocorrencia() {
		super();
	}

	public String getTipoViaturaAssistencia() {
		return tipoViaturaAssistencia;
	}

	public void setTipoViaturaAssistencia(String tipoViaturaAssistencia) {
		this.tipoViaturaAssistencia = tipoViaturaAssistencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ArrayList<String> getIncidente() {
		return incidente;
	}

	public void setIncidente(ArrayList<String> incidente) {
		this.incidente = incidente;
	}

	public int getNmrVitimas() {
		return nmrVitimas;
	}

	public void setNmrVitimas(int nmrVitimas) {
		this.nmrVitimas = nmrVitimas;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(String freguesia) {
		this.freguesia = freguesia;
	}

	public ArrayList<Utente> getUtentes() {
		return utentes;
	}

	public void setUtentes(ArrayList<Utente> utentes) {
		this.utentes = utentes;
	}

	public Equipa getEquipa() {
		return equipa;
	}

	public void setEquipa(Equipa equipa) {
		this.equipa = equipa;
	}

	public String getId() {
		return id;
	}

}