package pt.sali.SALI.controller;

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
import pt.sali.SALI.model.Sintoma;

@RestController
@RequestMapping("/Sintoma")
public class HCSintoma {
	
	@Autowired
	FSintoma fsintoma;
	
	@PostMapping("/add")
	public String addSintoma(@RequestBody Sintoma s, @RequestParam ("tok") String tok) {
			
		return fsintoma.saveSintoma(s, tok);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllSintoma (@RequestParam ("tok") String tok){
		
		List<Sintoma> s = fsintoma.listarSintoma(tok); 
		if(s != null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token não está presente", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateSintoma(@RequestBody Sintoma s, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(fsintoma.updateSintoma(s, tok), HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSintoma(@RequestBody Sintoma s, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(fsintoma.deleteSintoma(s, tok), HttpStatus.OK);	
	}
}
