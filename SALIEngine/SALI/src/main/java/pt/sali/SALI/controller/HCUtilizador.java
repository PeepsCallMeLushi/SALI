package pt.sali.SALI.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Role;
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
	
	@GetMapping("/listall")
	public ResponseEntity<List<Utilizador>> listarAllUtilizadores (){
		
		return new ResponseEntity<List<Utilizador>>(iUtilizador.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/listMedico")
	public ResponseEntity<List<Utilizador>> listarMedico (){
		
		ArrayList<Utilizador> aux = new ArrayList<>();
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getRole().getNome().compareTo("Medico") == 0) {
				aux.add(ut);
			}
		}
			
		return new ResponseEntity<List<Utilizador>>(aux, HttpStatus.OK);
	}
	
	@GetMapping("/listEnfermeiro")
	public ResponseEntity<List<Utilizador>> listarEnfermeiro (){
		ArrayList<Utilizador> aux = new ArrayList<>();
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getRole().getNome().compareTo("Medico") == 0) {
				aux.add(ut);
			}
		}
			
		return new ResponseEntity<List<Utilizador>>(aux, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Utilizador> updateUtilizador(@RequestBody Utilizador u){
		
		iUtilizador.save(u);
		
		return new ResponseEntity<Utilizador>(u, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Utilizador> deleteUtilizador(@RequestBody Utilizador u){
		iUtilizador.delete(u);
		return new ResponseEntity<Utilizador>(u, HttpStatus.OK);
	}
	
	@GetMapping("deleteall")
	public ResponseEntity<List<Utilizador>> deleteallUtilizador(){
		iUtilizador.deleteAll();
		return new ResponseEntity<List<Utilizador>>(iUtilizador.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void mock() {
		
		Role ro = new Role("Enfermeiro", "Vacinas");
		Utilizador e = new Utilizador("Joao", "69", "69",
				ro, "69");
		
		iUtilizador.save(e);
	}
}
