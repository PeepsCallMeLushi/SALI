package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Ocorrencia;
import pt.sali.SALI.service.IOcorrencia;

@RestController
@RequestMapping("/Ocorrencia")
public class HCOcorrencia {
	
	@Autowired
	IOcorrencia iOcorrencia;
	
	@PostMapping("/add")
	public String addOcorrencia(@RequestBody Ocorrencia o) {
		
		iOcorrencia.save(o);
		return "";
	}
	
	public ResponseEntity<List<Ocorrencia>> listarAllOcorrencias (){
		
		return new ResponseEntity<List<Ocorrencia>>(iOcorrencia.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia o){
		iOcorrencia.save(o);
		return new ResponseEntity<Ocorrencia>(o, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<Ocorrencia> deleteUsers(@RequestBody Ocorrencia o){
		iOcorrencia.delete(o);
		return new ResponseEntity<Ocorrencia>(o, HttpStatus.OK);
	}
}
