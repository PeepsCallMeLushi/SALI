package pt.sali.SALI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pt.sali.SALI.functions.FUtilizador;
import pt.sali.SALI.model.Utilizador;

@Controller
public class Web {
	
	@Autowired
	FUtilizador futilizador;
	
	@GetMapping("/")
	public String home() {
		
		return "index.html";
	}
	
	@GetMapping("/")
	public String addUT (Model m, Utilizador u, String tok) {
		
		m.addAttribute("", futilizador.saveUtilizador(u, tok));
		
		return "adduser.html";
	}
	
	@GetMapping("/")
	public String listUTs (Model m, String tok) {
		
		m.addAttribute("", futilizador.listarAllUtilizador(tok));
		
		return "listusers.html";
	}
	
	@GetMapping("/")
	public String updateUTs (Model m, String tok, Utilizador u) {
		
		m.addAttribute("", futilizador.updateUtilizador(u, tok));
		
		return "updateuser.html";
	}
	
	@GetMapping("/")
	public String deleteUTs (Model m, String tok, Utilizador u) {
		
		m.addAttribute("", futilizador.deleteUtilizador(u, tok));
		
		return "deluser.html";
	}
}
