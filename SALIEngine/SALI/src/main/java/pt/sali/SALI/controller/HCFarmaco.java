package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.functions.FFarmaco;
import pt.sali.SALI.model.Farmaco;

@RestController
@RequestMapping("/Farmaco")
public class HCFarmaco {
	
	@Autowired
	FFarmaco ffarmaco;
	
	@PostMapping("/add")
	public String addFarmaco(@RequestBody Farmaco f, @RequestParam ("tok") String tok) {
		
		int status = ffarmaco.saveFarmaco(f, tok);
		
		if (status == 0) {
			return "Token";
		}else if (status == 1) {
			return "Sucesso";
		}
		return "Existente";
	}
	
	@RequestMapping("/list")
	public ResponseEntity<?> listarAllFarmacos (@RequestParam ("tok") String tok){
		
		List<Farmaco> f = ffarmaco.listarFarmaco(tok); 
		if(f != null) {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateFarmaco(@RequestBody Farmaco f, @RequestParam ("tok") String tok) {
		
		if (ffarmaco.updateFarmaco(f, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<?> deleteFarmaco(@RequestBody Farmaco f, @RequestParam ("tok") String tok) {
		
		if (ffarmaco.deleteFarmaco(f, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
}
