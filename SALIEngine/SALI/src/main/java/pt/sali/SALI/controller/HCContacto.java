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

import pt.sali.SALI.functions.FContacto;
import pt.sali.SALI.model.Contacto;
import pt.sali.SALI.service.IContacto;

@RestController
@RequestMapping("/Contacto")
public class HCContacto {
	@Autowired
	FContacto fcontacto;
	@Autowired
	IContacto iContacto;
	
	@PostMapping("/add")
	public String addContacto(@RequestBody Contacto r, @RequestParam ("tok") String tok) {
		
		int status = fcontacto.saveContacto(r, tok);
		
		if (status == 1) {
			return "Sucesso";
		}else if (status == 0) {
			return "Token";
		}
		return "Existe";
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAlContacto (@RequestParam ("tok") String tok){
		
		List<Contacto> r = fcontacto.listarContacto(tok); 
		
		if(r != null) {
			return new ResponseEntity<>(r, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateContacto(@RequestBody Contacto r, @RequestParam ("tok") String tok) {
		
		if (fcontacto.updateContacto(r, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteContacto(@RequestParam ("id") String id, @RequestParam ("tok") String tok) {
		
		if (fcontacto.deleteContacto(id, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}
}
