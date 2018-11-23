package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Utilizador")
public class HCUtilizador {
	
	@Autowired
	IUtilizador iUtilizador;
	
	@PostMapping("/add")
	public String addUtilizador(@RequestBody Utilizador u) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Utilizador ut: iUtilizador.findAll()) {
			if (ut.getIdentificador().compareToIgnoreCase(u.getIdentificador())==0){ 
				jaExiste = true;
			}
		}
		
		if (jaExiste == true) {
			answer = "Nome de utilizador já existente";
		}else if (jaExiste == false){
			iUtilizador.save(u);
			answer = "Utilizador gravado com sucesso";
		}
		
		return answer;
	}
	
	public ResponseEntity<List<Utilizador>> listarAllUtilizadores (){
		
		return new ResponseEntity<List<Utilizador>>(iUtilizador.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Utilizador> updateUtilizador(@RequestBody Utilizador u){
		
		iUtilizador.save(u);
		
		return new ResponseEntity<Utilizador>(u, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Utilizador> deleteUsers(@RequestBody Utilizador u){
		iUtilizador.delete(u);
		return new ResponseEntity<Utilizador>(u, HttpStatus.OK);
	}
}
