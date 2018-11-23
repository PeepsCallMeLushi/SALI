package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.service.IFreguesia;

@RestController
@RequestMapping("/Freguesia")
public class HCFreguesia {
	
	@Autowired
	IFreguesia iFreguesia;
	
	@PostMapping("/add")
	public String addFreguesia(@RequestBody Freguesia f) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Freguesia fg: iFreguesia.findAll()) {
			if (fg.getNome().compareToIgnoreCase(f.getNome())==0){ 
				jaExiste = true;
			}
		}
		
		if (jaExiste == true) {
			answer = "Freguesia já existente";
		}else if (jaExiste == false){
			iFreguesia.save(f);
			answer = "Freguesia gravada com sucesso";
		}
		
		return answer;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Freguesia>> listarAllFreguesias (){
		
		return new ResponseEntity<List<Freguesia>>(iFreguesia.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Freguesia> updateFreguesia(@RequestBody Freguesia f){
		iFreguesia.save(f);
		return new ResponseEntity<Freguesia>(f, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Freguesia> deleteFreguesias(@RequestBody Freguesia f){
		iFreguesia.delete(f);
		return new ResponseEntity<Freguesia>(f, HttpStatus.OK);
	}
}
