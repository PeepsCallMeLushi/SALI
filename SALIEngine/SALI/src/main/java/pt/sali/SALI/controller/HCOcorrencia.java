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

import pt.sali.SALI.functions.FOcorrencia;
import pt.sali.SALI.model.Ocorrencia;
import pt.sali.SALI.service.IFreguesia;
import pt.sali.SALI.service.IOcorrencia;
import pt.sali.SALI.service.ISintoma;

@RestController
@RequestMapping("/Ocorrencia")
public class HCOcorrencia {
	
	@Autowired
	IOcorrencia iOcorrencia;
	@Autowired
	IFreguesia iFreguesia;
	@Autowired
	ISintoma iSintoma;
	@Autowired
	FOcorrencia focorrencia;
	
	@PostMapping("/add")
	public ResponseEntity<?> addOcorrencia(@RequestBody Ocorrencia o, @RequestParam ("tok") String tok) {
		
		if (focorrencia.saveOcorrencia(o, tok) == 1) {
			return new ResponseEntity<String>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Token", HttpStatus.OK);
	}
	
	@GetMapping("list")
	public ResponseEntity<?> listarAllOcorrencias (@RequestParam ("tok") String tok){
		
		List<Ocorrencia> o = focorrencia.listarOcorrencia(tok); 
		
		if(o != null) {
			return new ResponseEntity<>(o, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateOcorrencia(@RequestBody Ocorrencia o, @RequestParam ("tok") String tok) {
		
		if (focorrencia.updateOcorrencia(o, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}

	@PostMapping("/delete")
	public ResponseEntity<?> deleteOcorrencia(@RequestParam ("id") String id, @RequestParam ("tok") String tok) {
		
		if (focorrencia.deleteOcorrencia(id, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}

	@GetMapping("/dynamic")
	public ResponseEntity<?> dynamicQuery(@RequestParam ("json") String json, @RequestParam ("tok") String tok) { 
		
		if (focorrencia.dynamicQueryJ(json, tok) != null) {
			return new ResponseEntity<>(focorrencia.dynamicQueryJ(json, tok), HttpStatus.OK);
		}
		return new ResponseEntity<String>("No match", HttpStatus.OK);
	}
	
}
