package pt.sali.SALI.controller;

import java.util.Date;
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

import pt.sali.SALI.functions.FOcorrencia;
import pt.sali.SALI.model.Atuacao;
import pt.sali.SALI.model.Avaliacao;
import pt.sali.SALI.model.Dano;
import pt.sali.SALI.model.Equipa;
import pt.sali.SALI.model.Estado;
import pt.sali.SALI.model.FarmaFluido;
import pt.sali.SALI.model.Farmaco;
import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.model.Glasgow;
import pt.sali.SALI.model.Idade;
import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Ocorrencia;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.model.Transporte;
import pt.sali.SALI.model.Utente;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IFreguesia;
import pt.sali.SALI.service.IOcorrencia;
import pt.sali.SALI.service.ISintoma;

@RestController
@RequestMapping("/Ocorrencia")
public class HCOcorrencia {
	
	@Autowired
	IOcorrencia iOcorrencia;
	@Autowired
	IFreguesia iFreguesia;
	@Autowired
	ISintoma iSintoma;
	@Autowired
	FOcorrencia focorrencia;
	
	@PostMapping("/add")
	public String addOcorrencia(@RequestBody Ocorrencia o, @RequestParam ("tok") String tok) {
		
		if (focorrencia.saveOcorrencia(o, tok) == 1) {
			return "Sucesso";
		}
		return "Token";
	}
	
	@GetMapping("list")
	public ResponseEntity<?> listarAllOcorrencias (@RequestParam ("tok") String tok){
		
		List<Ocorrencia> o = focorrencia.listarOcorrencia(tok); 
		if(o != null) {
			return new ResponseEntity<>(o, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateOcorrencia(@RequestBody Ocorrencia o, @RequestParam ("tok") String tok) {
		
		if (focorrencia.updateOcorrencia(o, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}

	@PostMapping("/delete")
	public ResponseEntity<?> deleteOcorrencia(@RequestBody Ocorrencia o, @RequestParam ("tok") String tok) {
		
		if (focorrencia.deleteOcorrencia(o, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}

	@GetMapping("/dynamic")
	public ResponseEntity<?> dynamicQuery(@RequestParam ("json") String json, @RequestParam ("tok") String tok) { 
		
		if (focorrencia.dynamicQueryJ(json, tok) != null) {
			return new ResponseEntity<>(focorrencia.dynamicQueryJ(json, tok), HttpStatus.OK);
		}
		return new ResponseEntity<String>("No match", HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void addo(){
		Date d = new Date();
		Freguesia f = new Freguesia();

		for (Freguesia fr : iFreguesia.findAll()) {
			if (fr.getNome().compareTo("Santiago")==0) {
				f = fr;
			}
		}
		
		Role ro = new Role("Enfermeiro");
		Login lo= new Login("ola", "ola");
		Utilizador e = new Utilizador("Joao", ro, "69", "Pediatra", lo, "");
		Equipa eq = new Equipa(e, e);
		System.out.println(f.getNome());
		Ocorrencia o = new Ocorrencia("Carro", d, 2, 
				"Santiago",
				f, eq, "PENDENTE");
		Idade ida = new Idade("11", "1");
		
		//AVALIAÇÃO - BEGIN ---------------------------------
		Avaliacao ava = new Avaliacao();
		
		Sintoma s = new Sintoma();
		for (Sintoma si : iSintoma.findAll()) {
			if (si.getNome().compareTo("DOI BUE") == 0) {
				s = si;
			}
		}
		ava.getSintomas().add(s);
		
		ava.getAntecedentesPessoais().add("fiambre");
		ava.getAntecedentesPessoais().add("paio");
		
		Farmaco farma = new Farmaco("benuron");
		Farmaco farmac = new Farmaco("benuron");
		ava.getHabitosFarmacologicos().add(farma);
		ava.getHabitosFarmacologicos().add(farmac);
		
		Estado esta = new Estado("3:40", 2.5, 2.5, 2.5, 2.5,
				"A", "B", "C", "D", 2.5, 2.5);
		Glasgow gla = new Glasgow();
		gla.getOlhos().add("2");
		gla.getMotor().add("3");
		gla.getVerbal().add("4");
		esta.getGlasgow().add(gla);
		ava.getEstado().add(esta);
		
		Dano dano = new Dano("pila");
		dano.getEstados().add("partida");
		dano.getEstados().add("dobrada");
		ava.getDanos().add(dano);
		// AVALIAÇÃO - END ---------------------------------
		
		// ATUAÇÃO - BEGIN ---------------------------------
		Transporte trans = new Transporte(true, true);
		Atuacao atu = new Atuacao(trans, "ceu", "sim", "dead", true);
		atu.getAcao().add("croissant");
		atu.getAcao().add("baguete");
		
		FarmaFluido ff = new FarmaFluido("4:60", "5", "5", "5");
		FarmaFluido fff = new FarmaFluido("4:61", "4", "2", "3");
		atu.getAdministrados().add(ff);
		atu.getAdministrados().add(fff);
		// ATUAÇÃO - END ---------------------------------
		
		Utente u = new Utente("muito", ida, ava, atu, "obs");
		u.getHipotesesDiagnostivas().add("Diarreia");
		u.getHipotesesDiagnostivas().add("ExtraQueijo");
		
		o.getUtentes().add(u);
		o.getIncidente().add("O vlad nasceu");
		iOcorrencia.save(o);
	}
}
