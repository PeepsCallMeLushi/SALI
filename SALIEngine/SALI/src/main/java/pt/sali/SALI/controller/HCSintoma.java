package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.service.ISintoma;

@RestController
@RequestMapping("/Sintoma")
public class HCSintoma {
	
	@Autowired
	ISintoma iSintoma;
	
	@PostMapping("/add")
	public String addSintoma(@RequestBody Sintoma s) {
		
		iSintoma.save(s);
		return "";
	}
	
	public ResponseEntity<List<Sintoma>> listarAllSintomas (){
		
		return new ResponseEntity<List<Sintoma>>(iSintoma.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Sintoma> updateSintoma(@RequestBody Sintoma s){
		iSintoma.save(s);
		return new ResponseEntity<Sintoma>(s, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<Sintoma> deleteUsers(@RequestBody Sintoma s){
		iSintoma.delete(s);
		return new ResponseEntity<Sintoma>(s, HttpStatus.OK);
	}
}
