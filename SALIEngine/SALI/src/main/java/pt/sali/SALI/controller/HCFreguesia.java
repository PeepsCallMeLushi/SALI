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

import pt.sali.SALI.functions.FFreguesia;
import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.service.IFreguesia;

@RestController
@RequestMapping("/Freguesia")
public class HCFreguesia {
	
	@Autowired
	FFreguesia ffreguesia;
	@Autowired
	IFreguesia iFreguesia;
	
	@PostMapping("/add")
	public String addFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		int status = ffreguesia.saveFreguesia(f, tok);
		
		if (status == 0) {
			return "Token";
		}else if (status == 2) {
			return "Sucesso";
		}
		return "Existente";
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllFreguesias (@RequestParam ("tok") String tok){
		
		List<Freguesia> f = ffreguesia.listarFreguesia(tok);
		
		if(f != null) {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		if (ffreguesia.updateFreguesia(f, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteFreguesias(@RequestParam ("id") String id, @RequestParam ("tok") String tok) {
		
		if (ffreguesia.deleteFreguesia(id, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/delall")
	public ResponseEntity<?> delall (String tok) {
		for (Freguesia f : ffreguesia.listarFreguesia(tok)) {
			ffreguesia.deleteFreguesia(f.getId(), tok);
		}
		return new ResponseEntity<String> ("sucess", HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public ResponseEntity<?> mockFreg() {
		iFreguesia.save(new Freguesia("ALCACER DO SAL (SANTA MARIA DO CASTELO)", "ALCACER DO SAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTA SUSANA", "ALCACER DO SAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALCACER DO SAL (SANTIAGO)", "ALCACER DO SAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("TORRÃO", "ALCACER DO SAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. MARTINHO", "ALCACER DO SAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("COMPORTA", "ALCACER DO SAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALCOCHETE", "ALCOCHETE", "SETUBAL"));
		iFreguesia.save(new Freguesia("SAMOUCO", "ALCOCHETE", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. FRANCISCO", "ALCOCHETE", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALMADA", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("CAPARICA", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("COSTA DA CAPARICA", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("COVA DA PIEDADE", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("TRAFARIA", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("CACILHAS", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("PRAGAL", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("SOBREDA", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("CHARNECA DE CAPARICA", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("LARANJEIRO", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("FEIJO", "ALMADA", "SETUBAL"));
		iFreguesia.save(new Freguesia("BARREIRO", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("LAVRADIO", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("PALHAIS", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTO ANDRE", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("VERDERENA", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALTO DO SEIXALINHO", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTO ANTONIO DA CHARNECA", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("COINA", "BARREIRO", "SETUBAL"));
		iFreguesia.save(new Freguesia("AZINHEIRA DOS BARROS E S. MAMEDE DO SADÃO", "GRANDOLA", "SETUBAL"));
		iFreguesia.save(new Freguesia("GRANDOLA", "GRANDOLA", "SETUBAL"));
		iFreguesia.save(new Freguesia("MELIDES", "GRANDOLA", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTA MARGARIDA DA SERRA", "GRANDOLA", "SETUBAL"));
		iFreguesia.save(new Freguesia("CARVALHAL", "GRANDOLA", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALHOS VEDROS", "MOITA", "SETUBAL"));
		iFreguesia.save(new Freguesia("BAIXA DA BANHEIRA", "MOITA", "SETUBAL"));
		iFreguesia.save(new Freguesia("MOITA", "MOITA", "SETUBAL"));
		iFreguesia.save(new Freguesia("GAIO-ROSARIO", "MOITA", "SETUBAL"));
		iFreguesia.save(new Freguesia("SARILHOS PEQUENOS", "MOITA", "SETUBAL"));
		iFreguesia.save(new Freguesia("VALE DA AMOREIRA", "MOITA", "SETUBAL"));
		iFreguesia.save(new Freguesia("CANHA", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("MONTIJO", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTO ISIDRO DE PEGÕES", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("SARILHOS GRANDES", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALTO-ESTANQUEIRO-JARDIA", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("PEGÕES", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("ATALAIA", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("AFONSOEIRO", "MONTIJO", "SETUBAL"));
		iFreguesia.save(new Freguesia("MARATECA", "PALMELA", "SETUBAL"));
		iFreguesia.save(new Freguesia("PALMELA", "PALMELA", "SETUBAL"));
		iFreguesia.save(new Freguesia("PINHAL NOVO", "PALMELA", "SETUBAL"));
		iFreguesia.save(new Freguesia("QUINTA DO ANJO", "PALMELA", "SETUBAL"));
		iFreguesia.save(new Freguesia("POCEIRÃO", "PALMELA", "SETUBAL"));
		iFreguesia.save(new Freguesia("ABELA", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALVALADE", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("CERCAL", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("ERMIDAS-SADO", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTA CRUZ", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTIAGO DO CACEM", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("SANTO ANDRE", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. BARTOLOMEU DA SERRA", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. DOMINGOS", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. FRANCISCO DA SERRA", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("VALE DE ÁGUA", "SANTIAGO DO CACEM", "SETUBAL"));
		iFreguesia.save(new Freguesia("ALDEIA DE PAIO PIRES", "SEIXAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("AMORA", "SEIXAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("ARRENTELA", "SEIXAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SEIXAL", "SEIXAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("CORROIOS", "SEIXAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("FERNAO FERRO", "SEIXAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SESIMBRA (CASTELO)", "SESIMBRA", "SETUBAL"));
		iFreguesia.save(new Freguesia("SESIMBRA (SANTIAGO)", "SESIMBRA", "SETUBAL"));
		iFreguesia.save(new Freguesia("QUINTA DO CONDE", "SESIMBRA", "SETUBAL"));
		iFreguesia.save(new Freguesia("SETUBAL (NOSSA SENHORA DA ANUNCIADA)", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SETUBAL (SANTA MARIA DA GRAÇA)", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SETUBAL (S. JULIÃO)", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. LOURENÇO", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SETUBAL (S. SEBASTIÃO)", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("S. SIMÃO", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("GAMBIA-PONTES-ALTO DA GUERRA", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SADO", "SETUBAL", "SETUBAL"));
		iFreguesia.save(new Freguesia("SINES", "SINES", "SETUBAL"));
		iFreguesia.save(new Freguesia("PORTO COVO", "SINES", "SETUBAL"));
		return new ResponseEntity<String>("freguesias up", HttpStatus.OK);
	}
}
