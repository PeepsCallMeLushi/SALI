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

import pt.sali.SALI.functions.FUtilizador;
import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Token;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Utilizador")
public class HCUtilizador {
	
	@Autowired
	FUtilizador futilizador;
	@Autowired
	IUtilizador iUtilizador;		// SOMENTE PARA MOCK UP DATA
	
	@PostMapping("/add")
	public String addUtilizador(@RequestBody Utilizador u, @RequestParam ("tok") String tok) {
		
		int status = futilizador.saveUtilizador(u, tok);
		
		if (status == 0) {
			return "Token";
		}else if (status == 1) {
			return "Sucesso";
		}
		return "Existente";
	}
	
	@GetMapping("/listactive")
	public ResponseEntity<?> listarAactiveUtilizadores (@RequestParam ("tok") String tok) {
		
		List<Utilizador> u = futilizador.listarActiveUtilizador(tok); 
		
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<?> listarAllUtilizadores (@RequestParam ("tok") String tok) {
		
		List<Utilizador> u = futilizador.listarAllUtilizador(tok); 
		
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/listByRole")
	public ResponseEntity<?> listarMedico (@RequestParam ("role") String role, @RequestParam ("tok") String tok){
		
		if (futilizador.listarUtilizadorByRole(role, tok) == null) {
			return new ResponseEntity<String> ("No match", HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Utilizador>> (futilizador.listarUtilizadorByRole(role, tok), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUtilizador(@RequestBody Utilizador u, @RequestParam ("tok") String tok) {
		
		if (futilizador.updateUtilizador(u, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteUtilizador(@RequestParam("id") String id,@RequestParam ("tok") String tok) {
		
		if (futilizador.deleteUtilizador(id, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login (@RequestParam ("username") String username, 
										@RequestParam ("password") String password){
		
		int res = futilizador.loginValidacao(username, password);
		
		if (res == 1) {
			return new ResponseEntity<Utilizador>(futilizador.loginRest(username, password), HttpStatus.OK);
		} else if (res == 2) {
			return new ResponseEntity<String>("Login", HttpStatus.OK); // Não tem pass ou user correto
		}
		return new ResponseEntity<String>("Conta", HttpStatus.OK); // Não existe user
	}
	
	@GetMapping("logout")
	public ResponseEntity<String> logout (@RequestParam ("id") String id) {
		
		futilizador.logoutRest(id);
		
		return new ResponseEntity<String>("Sucesso", HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void mock() {
		
		Role ro = new Role("Enfermeiro");
		Login lo= new Login("ola", "ola");
		Utilizador e = new Utilizador("Joao", ro, "69", new Token("1", 1), new Token("1", 1), "Pediatra", lo, "", "Ativo");
		iUtilizador.save(e);
	}
}
