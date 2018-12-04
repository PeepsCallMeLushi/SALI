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

import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.service.IFreguesia;

@RestController
@RequestMapping("/Freguesia")
public class HCFreguesia {
	
	@Autowired
	IFreguesia iFreguesia;
	
	@PostMapping("/add")
	public String addFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Freguesia fg: iFreguesia.findAll()) {
			if (fg.getNome().compareToIgnoreCase(f.getNome())==0){ 
				jaExiste = true;
			}
		}
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				if (jaExiste == true) {
					answer = "Freguesia já existente";
				}else if (jaExiste == false){
					iFreguesia.save(f);
					answer = "Freguesia gravada com sucesso";
				}
//			}else{
//				answer = "Erro";
//			}
//		}
		
		
		
		return answer;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllFreguesias (
//			@RequestParam ("tok") String tok
			){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				return new ResponseEntity<List<Freguesia>>(iFreguesia.findAll(), HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateFreguesia(@RequestBody Freguesia f
//			, @RequestParam ("tok") String tok
														){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iFreguesia.save(f);
				return new ResponseEntity<Freguesia>(f, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteFreguesias(@RequestBody Freguesia f
//			, @RequestParam ("tok") String tok
														){
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iFreguesia.delete(f);
				return new ResponseEntity<Freguesia>(f, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);	
	}
}
