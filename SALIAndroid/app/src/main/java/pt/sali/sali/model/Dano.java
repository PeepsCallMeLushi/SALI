package pt.sali.sali.model;

import java.util.ArrayList;

public class Dano {

	private String parteDanificada;
	private ArrayList<String> estados;
	
	public Dano(String parteDanificada) {
		super();
		this.parteDanificada = parteDanificada;
		this.estados = new ArrayList<>();
	}

	public Dano() {
		super();
	}

	public String getParteDanificada() {
		return parteDanificada;
	}

	public void setParteDanificada(String parteDanificada) {
		this.parteDanificada = parteDanificada;
	}

	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}

}
