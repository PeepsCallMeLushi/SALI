package pt.sali.SALI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Utilizador")
public class HCUtilizador {
	
	@Autowired
	IUtilizador iUtilizador;
	
	@PostMapping("/add")
	public String addUtilizador(@RequestBody Utilizador u
//			, @RequestParam ("tok") String tok
			) {
		
		String answer="";
		boolean jaExiste = false;
		
		for (Utilizador ut: iUtilizador.findAll()) {
			if (ut.getIdentificador().compareToIgnoreCase(u.getIdentificador())==0){ 
				jaExiste = true;
			}
		}
		
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				if (jaExiste == true) {
					answer = "Nome de utilizador já existente";
				}else if (jaExiste == false){
					iUtilizador.save(u);
					answer = "Utilizador gravado com sucesso";
//				}
//				
//				return answer;
//			}else {
//				answer = "Erro";
//			}
		}
		
		return answer;
	}
	
	@GetMapping("/listall")
	public ResponseEntity<?> listarAllUtilizadores (
//			@RequestParam ("tok") String tok
			){
		
		ArrayList<Utilizador> aux = new ArrayList<>();
		
		for (Utilizador ut : iUtilizador.findAll()) {
			ut.getLogin().setPassword("oi");
			ut.getToken().setToken("oi");
			aux.add(ut);
		}
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				return new ResponseEntity<List<Utilizador>>(aux, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@GetMapping("/listByRole")
	public ResponseEntity<?> listarMedico (@RequestParam ("role") String role
//			, @RequestParam ("tok") String tok
															){
		
		ArrayList<Utilizador> aux = new ArrayList<>();
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getRole().getNome().compareTo(role) == 0) {
				ut.getLogin().setPassword("oi");
				ut.getToken().setToken("oi");
				aux.add(ut);
			}
		}
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				return new ResponseEntity<List<Utilizador>>(aux, HttpStatus.OK);
//			}
//		}	
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUtilizador(@RequestBody Utilizador u
//			, @RequestParam ("tok") String tok
														){
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iUtilizador.save(u);
				return new ResponseEntity<Utilizador>(u, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("oi", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteUtilizador(@RequestBody Utilizador u
//			,@RequestParam ("tok") String tok
			){
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iUtilizador.delete(u);
				return new ResponseEntity<String>("successful", HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@GetMapping("deleteall")
	public ResponseEntity<?> deleteallUtilizador(
//			@RequestParam ("tok") String tok
			){
		
//		for (Utilizador ut : iUtilizador.findAll()) {
//			if (ut.getToken().getToken().compareTo(tok) == 0) {
				iUtilizador.deleteAll();
				return new ResponseEntity<List<Utilizador>>(iUtilizador.findAll(), HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<String>("Erro", HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login (@RequestParam ("username") String username, 
									@RequestParam ("password") String password){
		
		Utilizador u = new Utilizador();
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getLogin().getLogin().compareTo(username) == 0) {
				if (ut.getLogin().getPassword().compareTo(password) == 0) {
					u = ut;
					u.getLogin().setPassword("oi");
					
					UUID idtoken = UUID.randomUUID();
					ut.getToken().setToken(idtoken.toString());
					iUtilizador.save(ut);
					
					return new ResponseEntity<Utilizador>(u, HttpStatus.OK);
				}
			}
		}
		
		return new ResponseEntity<String>("Username errado ou password errada", HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void mock() {
		
		Role ro = new Role("Enfermeiro");
		Login lo= new Login("ola", "ola");
		Utilizador e = new Utilizador("Joao", ro, "69", "Pediatra", lo);
		iUtilizador.save(e);
	}
}
