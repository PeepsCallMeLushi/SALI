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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.functions.FSintoma;
import pt.sali.SALI.model.Pergunta;
import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.service.ISintoma;

@RestController
@RequestMapping("/Sintoma")
public class HCSintoma {
	
	@Autowired
	FSintoma fsintoma;
	@Autowired
	ISintoma iSintoma;
	
	@PostMapping("/add")
	public String addSintoma(@RequestBody Sintoma s, @RequestParam ("tok") String tok) {
		
		int status = fsintoma.saveSintoma(s, tok);
		
		if (status == 0) {
			return "Token";
		}else if (status == 1) {
			return "Sucesso";
		}
		return "Existente";
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllSintoma (@RequestParam ("tok") String tok){
		
		List<Sintoma> s = fsintoma.listarSintoma(tok); 
		
		if(s != null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateSintoma(@RequestBody Sintoma s, @RequestParam ("tok") String tok) {
		
		if (fsintoma.updateSintoma(s, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSintoma(@RequestParam ("id") String id, @RequestParam ("tok") String tok) {
		
		if (fsintoma.deleteSintoma(id, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}
	
	@GetMapping("/mock")
	public ResponseEntity<String> mockup() {
		
		Pergunta p = new Pergunta("Dói?", "1");
		Pergunta pp = new Pergunta("Onde?", "2");
		ArrayList<String> ars = new ArrayList<>();
		String s = "Sim", ss = "Não";
		ars.add(s); ars.add(ss);
		p.setResposta(ars);
		pp.setResposta(ars);
		ArrayList<Pergunta> ar = new ArrayList<>();
		ar.add(new Pergunta("Pergunta ?","Consentida"));
		Sintoma si = new Sintoma ("1", "Dor", true,ar);
		si.setPergunta(ar);
		iSintoma.save(si);
		
		return new ResponseEntity<String>("done", HttpStatus.OK);
	}
}
