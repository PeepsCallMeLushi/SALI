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

import pt.sali.SALI.functions.FRole;
import pt.sali.SALI.model.Role;

@RestController
@RequestMapping("/Role")
public class HCRole {
	
	@Autowired
	FRole frole;
	
	@PostMapping("/add")
	public String addRole(@RequestBody Role r, @RequestParam ("tok") String tok) {
			
		return frole.saveRole(r, tok);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllRole (@RequestParam ("tok") String tok){
		
		List<Role> r = frole.listarRole(tok); 
		if(r != null) {
			return new ResponseEntity<>(r, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token não está presente", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateRole(@RequestBody Role r, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(frole.updateRole(r, tok), HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteRole(@RequestBody Role r, @RequestParam ("tok") String tok) {
		
		return new ResponseEntity<>(frole.deleteRole(r, tok), HttpStatus.OK);	
	}
}
