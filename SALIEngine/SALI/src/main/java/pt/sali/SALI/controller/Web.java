package pt.sali.SALI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
import pt.sali.SALI.service.IUtilizador;

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
	
	@Autowired
	IUtilizador iUtilizador;
	
	/*
	 * ERRO 1 = Password ou user name errados
	 * ERRO 2 = Duplicado
	 * 
	 * ERRO 10 = Sucesso
	 *  
	 *  
	 *  TODO - NO TOKEN
	 *  return "pages-error-403.html";
	 * */
	
	@GetMapping("/")
	public String home(Model m,@RequestParam (value="tok",defaultValue="0") String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		
		if (u.isPresent()) {
			m.addAttribute("tok",tok);
			return "index.html";
		}else
			return "pages-error-403.html";
	}
	
// LOGIN ///////////////////////////////////////////////////////////////


	@GetMapping("/authentication/login")
	public String login (Model m,@RequestParam(value="erro",defaultValue="0") String erro) {
		if(erro.equals("1")) {
			m.addAttribute("mensagemerro","Username ou Password Inválidos");
		}
        return "login.html";
    }
	
	@PostMapping("/authentication")
	public String login (@RequestParam ("username") String username, 
                        @RequestParam ("password") String password, 
                        Model m) {
       if(futilizador.login(username, password) == null) {
    	   return "redirect:/authentication/login?erro=1";
       }else {
    	   return "redirect:/?tok="+futilizador.login(username, password).getToken().getToken();
       }
    }
    
    // LOGIN ///////////////////////////////////////////////////////////////
		
	
	// UTILIZADORES ////////////////////////////////////////////////////////
	
	@GetMapping("/addUT")
	public String formADD (Model m, Utilizador u,
			@RequestParam("tok") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		if(erro.equals("2")) {
			m.addAttribute("mensagemerro","Utilizador já registado");
		}else if(erro.equals("10")) {
			m.addAttribute("mensagemsucess","Utilizador registado com sucesso !");
		}
		m.addAttribute("tok",tok);
		m.addAttribute("roles",frole.listarRole(tok));
		return "adduser.html";
	}
	
	@PostMapping("/addUT/add")
	public String addUT (@RequestParam("tok") String tok,
			@ModelAttribute("user") Utilizador u,
			Model m) {
		int reposta = futilizador.saveUtilizador(u, tok);
		
		if (reposta == 0) {	
			return "pages-error-403.html"; //Erro Token
		}else if (reposta == 1) {
			return "redirect:/addUT?tok="+tok+"&erro=10"; //Sucesso
		}else {
			return "redirect:/addUT?tok="+tok+"&erro=2"; //Duplicado
		}
	}
	
	@GetMapping("/listUTs")
	public String listUTs (Model m, @RequestParam("tok") String tok) {
		m.addAttribute("tok",tok);
		m.addAttribute("roles",frole.listarRole(tok));
		m.addAttribute("users", futilizador.listarAllUtilizador(tok));
		
		return "listausers.html";
	}
	
	@GetMapping("/updateUTs")
	public String updateUTs (Model m,  @RequestParam("tok") String tok, Utilizador u) {
		
		m.addAttribute("", futilizador.updateUtilizador(u, tok));
		
		if (futilizador.updateUtilizador(u, tok)) {		// SUCESSO
			return ".html"; 
		}
		return ".html";		// TOKEN NÃO PRESENTE
	}
	
	@GetMapping("/deleteUTs")
	public String deleteUTs (Model m,  @RequestParam("tok") String tok, Utilizador u) {
		
		m.addAttribute("", futilizador.deleteUtilizador(u, tok));
		
		return ".html";
	}
	// UTILIZADORES ////////////////////////////////////////////////////////
	
	
	// FARMACO /////////////////////////////////////////////////////////////
	@GetMapping("/addFarmaco")
	public String addFarmaco (Model m, String tok, Farmaco f) {
		
		m.addAttribute("", ffarmaco.saveFarmaco(f, tok));
		
		if (ffarmaco.saveFarmaco(f, tok) == 0) {		//	TOKEN NÃO PRESENTE
			
		}else if (ffarmaco.saveFarmaco(f, tok) == 1) {	//	SUCESSO
			
		}
		return ".html";		// JÁ EXISTE
	}
	
	@GetMapping("/listFarmaco")
	public String listFarmaco (Model m, String tok) {
		
		m.addAttribute("", ffarmaco.listarFarmaco(tok));
		
		return ".html";
	}
	
	@GetMapping("/updateFarmaco")
	public String updateFarmaco (Model m, String tok, Farmaco f) {
		
		m.addAttribute("", ffarmaco.updateFarmaco(f, tok));
		
		if (ffarmaco.updateFarmaco(f, tok)) {	// SUCESSO
			return ".html";
		}
		return ".html";		// TOKEN NÃO PRESENTE
	}
	
	@GetMapping("/deleteFarmaco")
	public String deleteFarmaco (Model m, String tok, Farmaco f) {
		
		m.addAttribute("", ffarmaco.deleteFarmaco(f, tok));
		
		if (ffarmaco.deleteFarmaco(f, tok)) {	// SUCESSO
			return ".html";
		}
		return ".html";		// TOKEN NÃO PRESENTE
	}
	// FARMACO /////////////////////////////////////////////////////////////
	
	
	// FREGUESIA ///////////////////////////////////////////////////////////
	@GetMapping("/addFreguesia")													
	public String addFreguesia (Model m, String tok, Freguesia f) {     
																		
		m.addAttribute("", ffreguesia.saveFreguesia(f, tok));			
																		
		return ".html";													
	}																	
																		
	@GetMapping("/listFreguesia")													
	public String listFreguesia (Model m, String tok) {					
																		
		m.addAttribute("", ffreguesia.listarFreguesia(tok));			
																		
		return ".html";													
	}																	
																		
	@GetMapping("/updateFreguesia")													
	public String updateFreguesia (Model m, String tok, Freguesia f) {	
																		
		//m.addAttribute("", ffreguesia.updateFreguesia(f, tok));
		
		if (ffreguesia.updateFreguesia(f, tok)) {
			return ".html";
		}
		return ".html";													
	}																	
																		
	@GetMapping("/deleteFreguesia")													
	public String deleteFreguesia (Model m, String tok, Freguesia f) {	
																		
		m.addAttribute("", ffreguesia.deleteFreguesia(f, tok));			
																		
		return ".html";													
	}																	
	// FREGUESIA /////////////////////////////////////////////////////////
	
	
	// ROLE //////////////////////////////////////////////////////////////
	@GetMapping("/addRole")													
	public String addRole (Model m, String tok, Role r) {     			
																		
		m.addAttribute("", frole.saveRole(r, tok));						
																		
		return ".html";													
	}																	
																		
	@GetMapping("/listRole")													
	public String listRole (Model m, String tok) {						
																		
		m.addAttribute("", frole.listarRole(tok));						
																		
		return ".html";											
	}																	
																		
	@GetMapping("/updateRole")													
	public String updateRole (Model m, String tok, Role r) {			
																		
		m.addAttribute("", frole.updateRole(r, tok));					
																		
		return ".html";													
	}																	
																		
	@GetMapping("/deleteRole")													
	public String deleteRole (Model m, String tok, Role r) {			
																		
		m.addAttribute("", frole.deleteRole(r, tok));					
																		
		return ".html";													
	}																	
	// ROLE //////////////////////////////////////////////////////////////
	
	
	// SINTOMA ///////////////////////////////////////////////////////////
	@GetMapping("/addSintoma")												
	public String addSintoma (Model m, String tok, Sintoma s) {     	
																		
		m.addAttribute("", fsintoma.saveSintoma(s, tok));				
																		
		return ".html";													
	}																	
																		
	@GetMapping("/listSintoma")													
	public String listSintoma (Model m, String tok) {					
																		
		m.addAttribute("", fsintoma.listarSintoma(tok));				
																		
		return ".html";													
	}																	
																		
	@GetMapping("/updateSintoma")													
	public String updateSintoma (Model m, String tok, Sintoma s) {		
																		
		m.addAttribute("", fsintoma.updateSintoma(s, tok));				
																		
		return ".html";													
	}																	
																		
	@GetMapping("/deleteSintoma")													
	public String deleteSintoma (Model m, String tok, Sintoma s) {		
																		
		m.addAttribute("", fsintoma.deleteSintoma(s, tok));				
																		
		return ".html";													
	}																	
	// SINTOMA ///////////////////////////////////////////////////////////
	
	
	// OCORRENCIA ////////////////////////////////////////////////////////
	@GetMapping("/addOcorrencia")													
	public String addOcorrencia (Model m, String tok, Ocorrencia o) {   
																		
		m.addAttribute("", focorrencia.saveOcorrencia(o, tok));			
																		
		return ".html";													
	}																	
																		
	@GetMapping("/listOcorrencia")													
	public String listOcorrencia (Model m, String tok) {				
																		
		m.addAttribute("", focorrencia.listarOcorrencia(tok));			
																		
		return ".html";													
	}																	
																		
	@GetMapping("/updateOcorrencia")													
	public String updateOcorrencia (Model m, String tok, Ocorrencia o) {
																		
		m.addAttribute("", focorrencia.updateOcorrencia(o, tok));		
																		
		return ".html";													
	}																	
																		
	@GetMapping("/deleteOcorrencia")													
	public String deleteOcorrencia (Model m, String tok, Ocorrencia o) {
																		
		m.addAttribute("", focorrencia.deleteOcorrencia(o, tok));		
																		
		return ".html";													
	}		
	
	@GetMapping("/dynamic")
	public String dynamicquery (@RequestParam ("json") String json, @RequestParam ("tok") String tok) {
		
		if (focorrencia.dynamicQueryJ(json, tok) != null) {
			return ".html";
		}
		return ".html";
	}
	// OCORRENCIA ////////////////////////////////////////////////////////
}
