package pt.sali.sali.model;

import java.util.ArrayList;

public class Estado {

	private String horas;
	private ArrayList<Glasgow> glasgow;
	private Double freqVentil;
	private Double freqPulso;
	private Double pressArtSistolica;
	private Double pressArtDiastolica;
	private String pele;
	private String pupilas;
	private String monitor;
	private String ecg;
	private Double sao2;
	private Double glicemia;

	public Estado(String horas, Double freqVentil, Double freqPulso,
			Double pressArtSistolica, Double pressArtDiastolica, String pele, String pupilas, String monitor,
			String ecg, Double sao2, Double glicemia) {
		super();
		this.horas = horas;
		this.glasgow = new ArrayList<>();
		this.freqVentil = freqVentil;
		this.freqPulso = freqPulso;
		this.pressArtSistolica = pressArtSistolica;
		this.pressArtDiastolica = pressArtDiastolica;
		this.pele = pele;
		this.pupilas = pupilas;
		this.monitor = monitor;
		this.ecg = ecg;
		this.sao2 = sao2;
		this.glicemia = glicemia;
	}

	public Estado() {
		super();
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public ArrayList<Glasgow> getGlasgow() {
		return glasgow;
	}

	public void setGlasgow(ArrayList<Glasgow> glasgow) {
		this.glasgow = glasgow;
	}

	public Double getFreqVentil() {
		return freqVentil;
	}

	public void setFreqVentil(Double freqVentil) {
		this.freqVentil = freqVentil;
	}

	public Double getFreqPulso() {
		return freqPulso;
	}

	public void setFreqPulso(Double freqPulso) {
		this.freqPulso = freqPulso;
	}

	public Double getPressArtSistolica() {
		return pressArtSistolica;
	}

	public void setPressArtSistolica(Double pressArtSistolica) {
		this.pressArtSistolica = pressArtSistolica;
	}

	public Double getPressArtDiastolica() {
		return pressArtDiastolica;
	}

	public void setPressArtDiastolica(Double pressArtDiastolica) {
		this.pressArtDiastolica = pressArtDiastolica;
	}

	public String getPele() {
		return pele;
	}

	public void setPele(String pele) {
		this.pele = pele;
	}

	public String getPupilas() {
		return pupilas;
	}

	public void setPupilas(String pupilas) {
		this.pupilas = pupilas;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public Double getSao2() {
		return sao2;
	}

	public void setSao2(Double sao2) {
		this.sao2 = sao2;
	}

	public Double getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(Double glicemia) {
		this.glicemia = glicemia;
	}

}
