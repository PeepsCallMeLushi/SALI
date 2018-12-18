package pt.sali.SALI.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pt.sali.SALI.functions.FFarmaco;
import pt.sali.SALI.functions.FFreguesia;
import pt.sali.SALI.functions.FOcorrencia;
import pt.sali.SALI.functions.FRole;
import pt.sali.SALI.functions.FSintoma;
import pt.sali.SALI.functions.FUtilizador;
import pt.sali.SALI.functions.FileHandler;
import pt.sali.SALI.functions.FileHandler.UploadFileResponse;
import pt.sali.SALI.model.Equipa;
import pt.sali.SALI.model.Farmaco;
import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Ocorrencia;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@Controller
public class Web {
	
	@Autowired
	FileHandler Filehandler;
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
	 * ERRO 3 = Passords nao correspondem
	 * 
	 * ERRO 10 = Sucesso
	 * ERRO 11 = Removido com Sucesso
	 * ERRO 12 = Modificado com Sucesso
	 * ...
	 * ERRO 19 = Logout Efectuado com Sucesso
	 * 
	 *  DONT FORGET - NO TOKEN
	 *  return "pages-error-403.html";
	 * */
	
	@GetMapping("/")
	public String home(Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (u.isPresent()) {
			if(u.get().isFirstLogin()){
				m.addAttribute("tok",tok);
				  return "redirect:/authentication/firstlogin?tok="+tok;
			}
			m.addAttribute("tok",tok);
			m.addAttribute("user",futilizador.UTbyToken(tok));
			return "index.html";
		}else
			return "pages-error-403.html";
	}
	
	// LOGIN ///////////////////////////////////////////////////////////////
	
	@GetMapping("/authentication/firstlogin")
	public String fl(Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (u.isPresent()) {
			if(u.get().isFirstLogin()){
				m.addAttribute("tok",tok);
				m.addAttribute("user",futilizador.UTbyToken(tok));
				
				if(erro.equals("3")) {
					m.addAttribute("mensagemerro","Passwords nao correspondem");
				}
				
				return "firstlogin.html";
			}
		}
		
		return "pages-error-403.html";
	}
	
	@PostMapping("/authentication/fl")
	public String changepwfl (@RequestParam ("pass1") String password1, 
                        @RequestParam ("pass2") String password2,
                        @RequestParam(value="tok", required=false,defaultValue="0") String tok,
                        Model m) {
		
       if(password1.equals(password2)) {
    	   
    	   Utilizador u = futilizador.UTbyToken(tok);

    	   u.getLogin().setPassword(password1);
    	   u.setFirstLogin(false);
    	   
    	   futilizador.updateUtilizador(u, tok);
    	   
    	   return "redirect:/?tok="+tok;
    	   
       }else {
    	   return "redirect:/authentication/firstlogin?tok="+tok+"&erro=3";
       }
    }
	
	@GetMapping("/authentication/login")
	public String login (Model m,@RequestParam(value="erro",defaultValue="0") String erro) {
		if(erro.equals("1")) {
			m.addAttribute("mensagemerro","Username ou Password inválidos");
		}else if(erro.equals("19")) {
			m.addAttribute("mensagemsucess","Logout efectuado com sucesso");
		}
        return "login.html";
    }
	
	@PostMapping("/authentication")
	public String login (@RequestParam ("username") String username, 
                        @RequestParam ("password") String password, 
                        Model m) {
       if(futilizador.loginSpring(username, password) == null) {
    	   return "redirect:/authentication/login?erro=1";
       }else {
    	   return "redirect:/?tok="+futilizador.loginSpring(username, password).getTokenSpring().getTokenName();
       }
    }
	
	@GetMapping("/authentication/logout")
	public String logout (Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok) {
		
		futilizador.logoutSpring(tok);
		return "redirect:/authentication/login?erro=19";
    }
	// LOGIN ///////////////////////////////////////////////////////////////
		
	
	// UTILIZADORES ////////////////////////////////////////////////////////
	@GetMapping("/addUT")
	public String formADD (Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		
		Utilizador u = futilizador.UTbyToken(tok);
		
		if (u != null) {
			if(erro.equals("2")) {
				m.addAttribute("mensagemaviso","Utilizador já registado");
			}else if(erro.equals("10")) {
				m.addAttribute("mensagemsucess","Utilizador registado com sucesso !");
			}
			m.addAttribute("tok",tok);
			m.addAttribute("user",u);
			m.addAttribute("roles",frole.listarRole(tok));
			return "adduser.html";
		}else
			return "pages-error-403.html";
		
		
	}
	
	@PostMapping("/addUT/add")
	public String addUT (@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@ModelAttribute("user") Utilizador u,
			Model m,
			@RequestParam("file") MultipartFile img) {
		
		if(img.getSize() > 1) {
		UploadFileResponse uplo = Filehandler.saveFile(img);
		u.setFoto(uplo.getFileDownloadUri());
		}
		
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
	public String listUTs (Model m, 
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		m.addAttribute("tok",tok);
		m.addAttribute("user",futilizador.UTbyToken(tok));
		
		if(futilizador.listarActiveUtilizador(tok)==null) {
			return "pages-error-403.html"; //Erro Token
		}
			
		m.addAttribute("users", futilizador.listarActiveUtilizador(tok));
		
		if(erro.equals("11")) {
			m.addAttribute("mensagemsucess","Utilizador removido com sucesso !");
		} else if(erro.equals("12")) {
			m.addAttribute("mensagemaviso","Utilizador modificado com sucesso !");
		}
		return "listausers.html";
	}

	
	@GetMapping("/updateUTs")
	public String updateUTs (Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro,
			@RequestParam("idusr") String id) {
		
		
		Utilizador user = futilizador.listarUTbyId(id, tok);
	
		if(user == null) {
			System.out.println("User null");
			return "pages-error-403.html"; // TOKEN NÃO PRESENTE
		}else {
			m.addAttribute("tok",tok);
			
			//User com login efectuado
			m.addAttribute("user",futilizador.UTbyToken(tok));
			
			//User a ser editado
			m.addAttribute("useredit", user);
			
			m.addAttribute("roles", frole.listarRole(tok));
			if(erro.equals("12")) {
				m.addAttribute("mensagemaviso","Utilizador modificado com sucesso !");
			}
			return "edituser.html";		
		}
	}
	
	@PostMapping("/updateUTs/update")
	public String updateUT (Model m,
			@ModelAttribute("user") Utilizador u,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok) {
		
		/*Isto á partida matem o login e password do user assim como os tokens e fotos*/
		Utilizador modelo = futilizador.listarUTbyId(u.getId(), tok);
		u.setLogin(modelo.getLogin());
		u.setTokenRest(modelo.getTokenRest());
		u.setTokenSpring(modelo.getTokenSpring());
		u.setFoto(modelo.getFoto());
		
		
		if(futilizador.updateUtilizador(u, tok)) {
			return "redirect:/updateUTs?tok="+tok+"&erro=12&idusr="+modelo.getId();
		}else {
			return "pages-error-403.html";	
		}
		
	}
	
	@PostMapping("/deleteUTs")
	public String deleteUTs (Model m, 
		@RequestParam(value="tok", required=false,defaultValue="0") String tok,
		@RequestParam("id") String id) {
		
		if(futilizador.deleteUtilizador(id, tok)) {
			return "redirect:/listUTs?tok="+tok+"&erro=11"; //Sucesso
		}else {
			return "pages-error-403.html";	
		}
		
		
	}
	// UTILIZADORES ////////////////////////////////////////////////////////
	
	
	// FARMACO /////////////////////////////////////////////////////////////
	@PostMapping("/addFarmaco")
	public String addFarmaco (@ModelAttribute("farmaco") Farmaco f,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok) {
		
		int awnser =  ffarmaco.saveFarmaco(f, tok);
			
		if (awnser == 0) {		//	TOKEN NÃO PRESENTE
			return "pages-error-403.html";	
		}else if (awnser == 1) {	//	SUCESSO
			return "redirect:/listFarmaco?tok="+tok+"&erro=10";	
		}
		return "redirect:/listFarmaco?tok="+tok+"&erro=2"; // JÁ EXISTE
	}
	
	@GetMapping("/listFarmaco")
	public String listFarmaco (Model m,  
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		
		m.addAttribute("tok",tok);
		m.addAttribute("user",futilizador.UTbyToken(tok));
		
		if(ffarmaco.listarFarmaco(tok) == null) {
			return "pages-error-403.html";
		}else {
			m.addAttribute("farmacos", ffarmaco.listarFarmaco(tok));
			if(erro.equals("2")) {
				m.addAttribute("mensagemaviso","Fármaco já se encontra registado");
			}else if(erro.equals("10")) {
				m.addAttribute("mensagemsucess","Fármaco registado com sucesso !");
			}else if (erro.equals("11")) {
				m.addAttribute("mensagemsucess","Fármaco removido com sucesso !");
			}
			return "listfarmaco.html";
		}
	}
		
	@PostMapping("/deleteFarmaco")
	public String deleteFarmaco (Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam("id") String id) {
				
		if (ffarmaco.deleteFarmaco(id, tok)) {	// SUCESSO
			return "redirect:/listFarmaco?tok="+tok+"&erro=11";
		}else {
			return "pages-error-403.html";		// TOKEN NÃO PRESENTE
		}
	}
	// FARMACO /////////////////////////////////////////////////////////////
	
	
	// FREGUESIA ///////////////////////////////////////////////////////////
	/*@GetMapping("/addFreguesia")													
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
	public String deleteFreguesia (Model m, String tok, String id) {	
																		
		m.addAttribute("", ffreguesia.deleteFreguesia(id, tok));			
																		
		return ".html";													
	}*/												
	// FREGUESIA /////////////////////////////////////////////////////////
	
	
	// ROLE //////////////////////////////////////////////////////////////
	/*@GetMapping("/addRole")													
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
	public String deleteRole (Model m, String tok, String id) {			
																		
		m.addAttribute("", frole.deleteRole(id, tok));					
																		
		return ".html";													
	}							*/										
	// ROLE //////////////////////////////////////////////////////////////
	
	
	// INCIDENTE  ///////////////////////////////////////////////////////////
	@GetMapping("/addSintoma")												
	public String addSintoma (Model m,  
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		
		Utilizador u = futilizador.UTbyToken(tok);
		
		if (u != null) {
			if(erro.equals("2")) {
				m.addAttribute("mensagemaviso","Incidente já se encotnra registado");
			}else if(erro.equals("10")) {
				m.addAttribute("mensagemsucess","Incidente registado com sucesso !");
			}
			
			m.addAttribute("tok",tok);
			m.addAttribute("user",u);
																			
			return "inserirIncidente.html";
		}else
			return "pages-error-403.html";
		
		
	}
	
	@PostMapping("/addSintoma/add")												
	public String addS(Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@ModelAttribute("sintoma") Sintoma s) {
		
		int reposta = fsintoma.saveSintoma(s, tok);
		
		if (reposta == 0) {	
			return "pages-error-403.html"; //Erro Token
		}else if (reposta == 1) {
			return "redirect:/addSintoma?tok="+tok+"&erro=10"; //Sucesso
		}else {
			return "redirect:/addSintoma?tok="+tok+"&erro=2"; //Duplicado
		}
																									
	}	
																		
	@GetMapping("/listSintoma")													
	public String listSintoma (Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		
		if(fsintoma.listarSintoma(tok)==null) {
			return "pages-error-403.html"; //Erro Token
		}else {
			if (erro.equals("11")) {
				m.addAttribute("mensagemsucess","Incidente removido com sucesso !");
			}
			m.addAttribute("incidentes", fsintoma.listarSintoma(tok));				
			m.addAttribute("user",futilizador.UTbyToken(tok));
			m.addAttribute("tok",tok);
			return "listaIncidente.html";
		}
	}																	
																		
	/*@GetMapping("/updateSintoma")													
	public String updateSintoma (Model m, String tok, Sintoma s) {		
																		
		m.addAttribute("", fsintoma.updateSintoma(s, tok));				
																		
		return ".html";													
	}*/																	
																		
	@PostMapping("/deleteSintoma")													
	public String deleteSintoma (Model m,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam("id") String id) {
		
		if (fsintoma.deleteSintoma(id, tok)) {	// SUCESSO
			return "redirect:/listSintoma?tok="+tok+"&erro=11";
		}else {
			return "pages-error-403.html";		// TOKEN NÃO PRESENTE
		}
																												
	}																	
	// INCIDENTE ///////////////////////////////////////////////////////////
	
	
	// OCORRENCIA ////////////////////////////////////////////////////////
	@GetMapping("/addOcorrencia")													
	public String addOcorrencia (Model m,  
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam(value="erro",defaultValue="0") String erro) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenSpringTokenName(tok);
		
		if ( u.isPresent()) {
			
			String role = "";
			if(u.get().getRole().getNome().compareToIgnoreCase("Médico")==0) {
				role = "Enfermeiro";
			}else {
				role = "Médico";
			}
			
			m.addAttribute("tok",tok);
			m.addAttribute("user",futilizador.UTbyToken(tok));
			m.addAttribute("parceiros",futilizador.listarUtilizadorByRole(role, tok));
			m.addAttribute("freguesias",ffreguesia.listarFreguesia(tok));
			m.addAttribute("farmacos",ffarmaco.listarFarmaco(tok));
			
			if(erro.equals("10")) {
				m.addAttribute("mensagemsucess","Ocorrência registada com sucesso !");
			}
			
			return "addOcorrencia.html";
		}else
			return "pages-error-403.html";
		
	}
	
	@PostMapping("/addOcorrencia/add")													
	public String addOc (Model m, Ocorrencia oc,
			@RequestParam(value="tok", required=false,defaultValue="0") String tok,
			@RequestParam("idequipambm2") String idequipambm2,
			@RequestParam("ocdata") String ocdate,
			@RequestParam("acfreguesia") String acfreguesia) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenSpringTokenName(tok);
		
		if ( u.isPresent()) {
			
			Equipa eq = new Equipa();
			if(u.get().getRole().getNome().equals("Médico")){
				eq.setMedico(futilizador.UTbyToken(tok));
				eq.setEnfermeiro(futilizador.listarUTbyId(idequipambm2, tok));
			}else {
				eq.setMedico(futilizador.listarUTbyId(idequipambm2, tok));
				eq.setEnfermeiro(futilizador.UTbyToken(tok));
			}
			
			oc.setEquipa(eq);
			try {

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = formatter.parse(ocdate);
				oc.setData(date);

	        } catch (Exception e) {
	        	oc.setData(null);
	        	System.out.println(e);
	        }
			/*Isto vai buscar a freguesia inteira*/
			oc.setFreguesia(ffreguesia.listarFreguesiaID(acfreguesia, tok));
			
			focorrencia.saveOcorrencia(oc, tok);
			return "redirect:/addOcorrencia?tok="+tok+"&erro=10";
		}else
			return "pages-error-403.html";
		
	}	
																		
	@GetMapping("/listOcorrencia")													
	public String listOcorrencia (Model m, @RequestParam("tok") String tok) {				
																		
		m.addAttribute("ocorrencias", focorrencia.listarOcorrencia(tok));			
																		
		return ".html";		
	}																	
																		
	/*@GetMapping("/updateOcorrencia")													
	public String updateOcorrencia (Model m, String tok, Ocorrencia o) {
																		
		m.addAttribute("", focorrencia.updateOcorrencia(o, tok));		
																		
		return ".html";													
	}*/																	
																		
	@GetMapping("/deleteOcorrencia")													
	public String deleteOcorrencia (Model m, String tok, String id) {
																		
		m.addAttribute("", focorrencia.deleteOcorrencia(id, tok));		
																		
		return ".html";													
	}		
	
	/*@GetMapping("/dynamic")
	public String dynamicquery (@RequestParam ("json") String json, @RequestParam ("tok") String tok) {
		
		if (focorrencia.dynamicQueryJ(json, tok) != null) {
			return ".html";
		}
		return ".html";
	}*/
	// OCORRENCIA ////////////////////////////////////////////////////////
}
