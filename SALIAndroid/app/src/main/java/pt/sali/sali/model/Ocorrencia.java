package pt.sali.sali.model;

import java.util.ArrayList;
import java.util.Date;

public class Ocorrencia {

	private String id;
	private String tipoViaturaAssistencia;
	private Date data;
	private ArrayList<String> incidente;
	private int nmrVitimas;
	private String local;
	private Freguesia freguesia;
	private ArrayList<Utente> utentes;
	private Equipa equipa;
	private String estado;
	
	public Ocorrencia(String tipoViaturaAssistencia, Date data, int nmrVitimas,
			String local, Freguesia freguesia, Equipa equipa, String estado) {
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
		this.estado = estado;
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

	public Freguesia getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(Freguesia freguesia) {
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

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}