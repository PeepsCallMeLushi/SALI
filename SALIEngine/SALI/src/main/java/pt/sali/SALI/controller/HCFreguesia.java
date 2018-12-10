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

@RestController
@RequestMapping("/Freguesia")
public class HCFreguesia {
	
	@Autowired
	FFreguesia ffreguesia;
	
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
	
	@GetMapping("/mock")
	public ResponseEntity<?> mockFreg() {
		ffreguesia.saveFreguesia(new Freguesia("ALCACER DO SAL (SANTA MARIA DO CASTELO)", "ALCACER DO SAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTA SUSANA", "ALCACER DO SAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALCACER DO SAL (SANTIAGO)", "ALCACER DO SAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("TORRÃO", "ALCACER DO SAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. MARTINHO", "ALCACER DO SAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("COMPORTA", "ALCACER DO SAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALCOCHETE", "ALCOCHETE", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SAMOUCO", "ALCOCHETE", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. FRANCISCO", "ALCOCHETE", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALMADA", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CAPARICA", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("COSTA DA CAPARICA", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("COVA DA PIEDADE", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("TRAFARIA", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CACILHAS", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("PRAGAL", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SOBREDA", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CHARNECA DE CAPARICA", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("LARANJEIRO", "ALMADA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("FEIJO", "ALMADA", ""), "SETUBAL");
		ffreguesia.saveFreguesia(new Freguesia("BARREIRO", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("LAVRADIO", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("PALHAIS", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTO ANDRE", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("VERDERENA", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALTO DO SEIXALINHO", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTO ANTONIO DA CHARNECA", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("COINA", "BARREIRO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("AZINHEIRA DOS BARROS E S. MAMEDE DO SADÃO", "GRANDOLA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("GRANDOLA", "GRANDOLA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("MELIDES", "GRANDOLA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTA MARGARIDA DA SERRA", "GRANDOLA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CARVALHAL", "GRANDOLA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALHOS VEDROS", "MOITA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("BAIXA DA BANHEIRA", "MOITA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("MOITA", "MOITA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("GAIO-ROSARIO", "MOITA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SARILHOS PEQUENOS", "MOITA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("VALE DA AMOREIRA", "MOITA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CANHA", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("MONTIJO", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTO ISIDRO DE PEGÕES", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SARILHOS GRANDES", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALTO-ESTANQUEIRO-JARDIA", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("PEGÕES", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ATALAIA", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("AFONSOEIRO", "MONTIJO", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("MARATECA", "PALMELA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("PALMELA", "PALMELA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("PINHAL NOVO", "PALMELA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("QUINTA DO ANJO", "PALMELA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("POCEIRÃO", "PALMELA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ABELA", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALVALADE", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CERCAL", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ERMIDAS-SADO", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTA CRUZ", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTIAGO DO CACEM", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SANTO ANDRE", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. BARTOLOMEU DA SERRA", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. DOMINGOS", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. FRANCISCO DA SERRA", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("VALE DE ÁGUA", "SANTIAGO DO CACEM", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ALDEIA DE PAIO PIRES", "SEIXAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("AMORA", "SEIXAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("ARRENTELA", "SEIXAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SEIXAL", "SEIXAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("CORROIOS", "SEIXAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("FERNAO FERRO", "SEIXAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SESIMBRA (CASTELO)", "SESIMBRA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SESIMBRA (SANTIAGO)", "SESIMBRA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("QUINTA DO CONDE", "SESIMBRA", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SETUBAL (NOSSA SENHORA DA ANUNCIADA)", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SETUBAL (SANTA MARIA DA GRAÇA)", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SETUBAL (S. JULIÃO)", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. LOURENÇO", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SETUBAL (S. SEBASTIÃO)", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("S. SIMÃO", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("GAMBIA-PONTES-ALTO DA GUERRA", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SADO", "SETUBAL", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("SINES", "SINES", "SETUBAL"), "");
		ffreguesia.saveFreguesia(new Freguesia("PORTO COVO", "SINES", "SETUBAL"), "");
		return new ResponseEntity<String>("freguesias up", HttpStatus.OK);
	}
}
