package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Glasgow {
	
	@Id
	private String id;
	private ArrayList<String> olhos;
	private ArrayList<String> verbal;
	private ArrayList<String> motor;
	
	public Glasgow(ArrayList<String> olhos, ArrayList<String> verbal, ArrayList<String> motor) {
		super();
		this.id = null;
		this.olhos = olhos;
		this.verbal = verbal;
		this.motor = motor;
	}
	
	public Glasgow() {
		super();
	}

	public ArrayList<String> getOlhos() {
		return olhos;
	}

	public void setOlhos(ArrayList<String> olhos) {
		this.olhos = olhos;
	}

	public ArrayList<String> getVerbal() {
		return verbal;
	}

	public void setVerbal(ArrayList<String> verbal) {
		this.verbal = verbal;
	}

	public ArrayList<String> getMotor() {
		return motor;
	}

	public void setMotor(ArrayList<String> motor) {
		this.motor = motor;
	}

	public String getId() {
		return id;
	}
		
}
