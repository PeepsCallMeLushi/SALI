package pt.sali.SALI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pt.sali.SALI.functions.FFarmaco;
import pt.sali.SALI.functions.FFreguesia;
import pt.sali.SALI.functions.FOcorrencia;
import pt.sali.SALI.functions.FRole;
import pt.sali.SALI.functions.FSintoma;
import pt.sali.SALI.functions.FUtilizador;
import pt.sali.SALI.model.Farmaco;
import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.model.Ocorrencia;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.model.Utilizador;

@Controller
public class Web {
	
	@Autowired
	FUtilizador futilizador;
	@Autowired
	FFarmaco ffarmaco;
	@Autowired
	FFreguesia ffreguesia;
	@Autowired
	FOcorrencia focorrencia;
	@Autowired
	FRole frole;
	@Autowired
	FSintoma fsintoma;
	
	@GetMapping("/")
	public String home() {
	
		return "index.html";
	}
	
	// UTILIZADORES ////////////////////////////////////////////////////////
	@GetMapping("/")
	public String addUT (Model m, Utilizador u, String tok) {
		
		m.addAttribute("", futilizador.saveUtilizador(u, tok));
		
		return ".html";
	}
	
	@GetMapping("/")
	public String listUTs (Model m, String tok) {
		
		m.addAttribute("", futilizador.listarAllUtilizador(tok));
		
		return ".html";
	}
	
	@GetMapping("/")
	public String updateUTs (Model m, String tok, Utilizador u) {
		
		m.addAttribute("", futilizador.updateUtilizador(u, tok));
		
		return ".html";
	}
	
	@GetMapping("/")
	public String deleteUTs (Model m, String tok, Utilizador u) {
		
		m.addAttribute("", futilizador.deleteUtilizador(u, tok));
		
		return ".html";
	}
	// UTILIZADORES ////////////////////////////////////////////////////////
	
	
	// FARMACO /////////////////////////////////////////////////////////////
	@GetMapping("/")
	public String addFarmaco (Model m, String tok, Farmaco f) {
		
		m.addAttribute("", ffarmaco.saveFarmaco(f, tok));
		
		return ".html";
	}
	
	@GetMapping("/")
	public String listFarmaco (Model m, String tok) {
		
		m.addAttribute("", ffarmaco.listarFarmaco(tok));
		
		return ".html";
	}
	
	@GetMapping("/")
	public String updateFarmaco (Model m, String tok, Farmaco f) {
		
		m.addAttribute("", ffarmaco.updateFarmaco(f, tok));
		
		return ".html";
	}
	
	@GetMapping("/")
	public String deleteFarmaco (Model m, String tok, Farmaco f) {
		
		m.addAttribute("", ffarmaco.deleteFarmaco(f, tok));
		
		return ".html";
	}
	// FARMACO /////////////////////////////////////////////////////////////
	
	
	// FREGUESIA /////////////////////////////////////////////////////////
	@GetMapping("/")													//
	public String addFreguesia (Model m, String tok, Freguesia f) {     //
																		//
		m.addAttribute("", ffreguesia.saveFreguesia(f, tok));			//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String listFreguesia (Model m, String tok) {					//
																		//
		m.addAttribute("", ffreguesia.listarFreguesia(tok));			//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String updateFreguesia (Model m, String tok, Freguesia f) {	//
																		//
		m.addAttribute("", ffreguesia.updateFreguesia(f, tok));			//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String deleteFreguesia (Model m, String tok, Freguesia f) {	//
																		//
		m.addAttribute("", ffreguesia.deleteFreguesia(f, tok));			//
																		//
		return ".html";													//
	}																	//
	// FREGUESIA /////////////////////////////////////////////////////////
	
	
	// ROLE //////////////////////////////////////////////////////////////
	@GetMapping("/")													//
	public String addRole (Model m, String tok, Role r) {     			//
																		//
		m.addAttribute("", frole.saveRole(r, tok));						//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String listRole (Model m, String tok) {						//
																		//
		m.addAttribute("", frole.listarRole(tok));						//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String updateRole (Model m, String tok, Role r) {			//
																		//
		m.addAttribute("", frole.updateRole(r, tok));					//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String deleteRole (Model m, String tok, Role r) {			//
																		//
		m.addAttribute("", frole.deleteRole(r, tok));					//
																		//
		return ".html";													//
	}																	//
	// ROLE //////////////////////////////////////////////////////////////
	
	
	// SINTOMA ///////////////////////////////////////////////////////////
	@GetMapping("/")													//
	public String addSintoma (Model m, String tok, Sintoma s) {     	//
																		//
		m.addAttribute("", fsintoma.saveSintoma(s, tok));				//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String listSintoma (Model m, String tok) {					//
																		//
		m.addAttribute("", fsintoma.listarSintoma(tok));				//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String updateSintoma (Model m, String tok, Sintoma s) {		//
																		//
		m.addAttribute("", fsintoma.updateSintoma(s, tok));				//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String deleteSintoma (Model m, String tok, Sintoma s) {		//
																		//
		m.addAttribute("", fsintoma.deleteSintoma(s, tok));				//
																		//
		return ".html";													//
	}																	//
	// SINTOMA ///////////////////////////////////////////////////////////
	
	
	// OCORRENCIA ////////////////////////////////////////////////////////
	@GetMapping("/")													//
	public String addOcorrencia (Model m, String tok, Ocorrencia o) {   //
																		//
		m.addAttribute("", focorrencia.saveOcorrencia(o, tok));			//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String listOcorrencia (Model m, String tok) {				//
																		//
		m.addAttribute("", focorrencia.listarOcorrencia(tok));			//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String updateOcorrencia (Model m, String tok, Ocorrencia o) {//
																		//
		m.addAttribute("", focorrencia.updateOcorrencia(o, tok));		//
																		//
		return ".html";													//
	}																	//
																		//
	@GetMapping("/")													//
	public String deleteOcorrencia (Model m, String tok, Ocorrencia o) {//
																		//
		m.addAttribute("", focorrencia.deleteOcorrencia(o, tok));		//
																		//
		return ".html";													//
	}																	//
	// OCORRENCIA ////////////////////////////////////////////////////////
}
