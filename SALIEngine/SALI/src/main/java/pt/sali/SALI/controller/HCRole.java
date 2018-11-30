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

import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IRole;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Role")
public class HCRole {
	
	@Autowired
	IRole iRole;
	@Autowired
	IUtilizador iUtilizador;
	
	@PostMapping("/add")
	public String addRole (@RequestBody Role r
//			, @RequestParam ("tok") String tok
							) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Role rl: iRole.findAll()) {
			if (rl.getNome().compareToIgnoreCase(r.getNome())==0){ 
				jaExiste = true;
			}
		}
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				if (jaExiste == true) {
					answer = "Role já existente";
				}else if (jaExiste == false){
					iRole.save(r);
					answer = "Role gravado com sucesso";
				}
//			}else{
//				answer = "Erro";
//			}
//		}
				
		return answer;
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllRoles (
//			@RequestParam ("tok") String tok
			){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				return new ResponseEntity<List<Role>>(iRole.findAll(), HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<List<Role>>(iRole.findAll(), HttpStatus.OK);
//		return new ResponseEntity<String>("oi", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateRole(@RequestBody Role r
//			, @RequestParam ("tok") String tok
											){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iRole.save(r);
				return new ResponseEntity<Role>(r, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
		
	}

	@PostMapping("/delete")
	public ResponseEntity<?> deleteRole(@RequestBody Role r
//			, @RequestParam ("tok") String tok
											){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iRole.delete(r);
				return new ResponseEntity<Role>(r, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
}
