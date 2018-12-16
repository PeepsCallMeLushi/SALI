package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public int saveOcorrencia (Ocorrencia o, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ur.isPresent() || us.isPresent()) {
			iOcorrencia.save(o);
			return 1;
		}
		return 0;
	}
	
	public List<Ocorrencia> listarOcorrencia (String tok) {
	
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ur.isPresent() || us.isPresent()) {
			return iOcorrencia.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateOcorrencia (Ocorrencia o, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iOcorrencia.save(o);
			answer = true;
		}
		return answer;
	}
	
	public boolean deleteOcorrencia (String id, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iOcorrencia.deleteById(id);
			answer = true;
		}
		
		return answer;
	}
	
	public List<Ocorrencia> dynamicQueryJ(String json, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ur.isPresent() || us.isPresent()) {
			Document document = new Document();
		    document = Document.parse(json);
		    List<Ocorrencia> ocorrencias = iOcorrencia.find(document);
		    
		    return ocorrencias;
		}
		return null;  
	}
}
