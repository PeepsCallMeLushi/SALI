package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.sali.SALI.model.Sintoma;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.ISintoma;
import pt.sali.SALI.service.IUtilizador;

@Service("fsintoma")
public class FSintoma {
	
	@Autowired
	ISintoma iSintoma;
	@Autowired
	IUtilizador iUtilizador;
	
	public int saveSintoma (Sintoma s, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean isEqual = false;
		
		if (ur.isPresent() || us.isPresent()) {
			for (Sintoma rl: iSintoma.findAll()) {
				if (rl.getNome().compareToIgnoreCase(s.getNome()) == 0){ 
					isEqual = true;
				}
			}
			if (isEqual) {
				return 2;
			}else {
				iSintoma.save(s);
				return 1;
			}
		}
		return 0;
	}
	
	public List<Sintoma> listarSintoma (String tok) {
	
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ur.isPresent() || us.isPresent()) {
			return iSintoma.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateSintoma (Sintoma s, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iSintoma.save(s);
			answer = true;
		}
		return answer;
	}
	
	public boolean deleteSintoma (String id, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iSintoma.deleteById(id);
			answer = true;
		}
		return answer;
	}
}
