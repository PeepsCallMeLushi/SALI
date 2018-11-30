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

import pt.sali.SALI.model.Pergunta;
import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.ISintoma;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Sintoma")
public class HCSintoma {
	
	@Autowired
	ISintoma iSintoma;
	@Autowired
	IUtilizador iUtilizador;
	
	@PostMapping("/add")
	public String addSintoma(@RequestBody Sintoma s
//			, @RequestParam ("tok") String tok
								) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Sintoma st: iSintoma.findAll()) {
			if (st.getNome().compareToIgnoreCase(s.getNome())==0){ 
				jaExiste = true;
			}
		}
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				if (jaExiste == true) {
					answer = "Sintoma já existente";
				}else if (jaExiste == false){
					iSintoma.save(s);
					answer = "Sintoma gravado com sucesso";
				}
//			}else{
//				answer = "Erro";
//			}
//		}
		return answer;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllSintomas (
//			@RequestParam ("tok") String tok
			){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				return new ResponseEntity<List<Sintoma>>(iSintoma.findAll(), HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateSintoma(@RequestBody Sintoma s
//			, @RequestParam ("tok") String tok
													){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iSintoma.save(s);
				return new ResponseEntity<Sintoma>(s, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteSintoma(@RequestBody Sintoma s
//			, @RequestParam ("tok") String tok
			){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iSintoma.delete(s);
				return new ResponseEntity<Sintoma>(s, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void adds() {
		Sintoma sin;
		
		Pergunta p = new Pergunta("doi?", "seleção");
		p.getResposta().add("Não");
		p.getResposta().add("Sim");
		sin = new Sintoma("dor", "A");
		sin.getPergunta().add(p);
		iSintoma.save(sin);
	}
}
