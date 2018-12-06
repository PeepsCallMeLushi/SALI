package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import pt.sali.SALI.model.Ocorrencia;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IOcorrencia;
import pt.sali.SALI.service.IUtilizador;

@Service("focorrencia")
public class FOcorrencia {
	
	@Autowired
	IOcorrencia iOcorrencia;
	
	@Autowired
	IUtilizador iUtilizador;
	
	public String saveOcorrencia (Ocorrencia o, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iOcorrencia.save(o);
		}
		
		return answer;
	}
	
	public List<Ocorrencia> listarOcorrencia (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		
		if (u.isPresent()) {
			return iOcorrencia.findAll();
		}else {
			return null;
		}
	}
	
	public String updateOcorrencia (Ocorrencia o, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iOcorrencia.save(o);
			answer = "Atualizado com sucesso";
		}
		
		return answer;
	}
	
	public String deleteOcorrencia (Ocorrencia o, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iOcorrencia.delete(o);
			answer = "Apagado com sucesso";
		}
		
		return answer;
	}
	
	public ResponseEntity<?> dynamicQuery(@RequestParam ("json") String json, @RequestParam ("tok") String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		
		if (u.isPresent()) {
			Document document = new Document();
		    document = Document.parse(json);
		    List<Ocorrencia> ocorrencias = iOcorrencia.find(document);
		    
		    return new ResponseEntity<>(ocorrencias, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Erro", HttpStatus.OK);  
	}
}
