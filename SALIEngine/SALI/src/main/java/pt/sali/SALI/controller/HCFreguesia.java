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

import pt.sali.SALI.functions.FFreguesia;
import pt.sali.SALI.model.Freguesia;

@RestController
@RequestMapping("/Freguesia")
public class HCFreguesia {
	
	@Autowired
	FFreguesia ffreguesia;
	
	@PostMapping("/add")
	public String addFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
			
		return ffreguesia.saveFreguesia(f, tok);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllFreguesias (@RequestParam ("tok") String tok){
		
		List<Freguesia> f = ffreguesia.listarFreguesia(tok); 
		if(f != null) {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token não está presente", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(ffreguesia.updateFreguesia(f, tok), HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteFreguesias(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(ffreguesia.deleteFreguesia(f, tok), HttpStatus.OK);	
	}
}
