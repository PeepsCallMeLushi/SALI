package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Farmaco;
import pt.sali.SALI.service.IFarmaco;

@RestController
@RequestMapping("/Farmaco")
public class HCFarmaco {
	
	@Autowired
	IFarmaco iFarmaco;
	
	@PostMapping("/add")
	public String addFarmaco(@RequestBody Farmaco f) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Farmaco fm: iFarmaco.findAll()) {
			if (fm.getNome().compareToIgnoreCase(f.getNome())==0){ 
				jaExiste = true;
			}
		}
		
		if (jaExiste == true) {
			answer = "Fármaco já existente";
		}else if (jaExiste == false){
			iFarmaco.save(f);
			answer = "Fármaco gravado com sucesso";
		}
		
		return answer;
	}
	
	@RequestMapping("/list")
	public ResponseEntity<List<Farmaco>> listarAllFarmacos (){
		
		return new ResponseEntity<List<Farmaco>>(iFarmaco.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Farmaco> updateFarmaco(@RequestBody Farmaco f){
		iFarmaco.save(f);
		return new ResponseEntity<Farmaco>(f, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<Farmaco> deleteUsers(@RequestBody Farmaco f){
		iFarmaco.delete(f);
		return new ResponseEntity<Farmaco>(f, HttpStatus.OK);
	}
}
