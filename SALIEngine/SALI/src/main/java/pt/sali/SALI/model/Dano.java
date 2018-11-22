package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Dano {
	
	@Id
	private String id;
	private String parteDanificada;
	private ArrayList<String> estados;
	
	public Dano(String parteDanificada, ArrayList<String> estados) {
		super();
		this.id = null;
		this.parteDanificada = parteDanificada;
		this.estados = estados;
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

	public String getId() {
		return id;
	}

}
