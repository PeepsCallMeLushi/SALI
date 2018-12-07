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
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		int answer = 0;
		boolean jaExiste = false;
		
		if (u.isPresent()) {
			for (Sintoma rl: iSintoma.findAll()) {
				if (rl.getNome().compareToIgnoreCase(s.getNome())==0){ 
					jaExiste = true;
				}
			}
			if (jaExiste == true) {
				answer = 2;
			}else if (jaExiste == false){
				iSintoma.save(s);
				answer = 1;
			}
		}
		return answer;
	}
	
	public List<Sintoma> listarSintoma (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		
		if (u.isPresent()) {
			return iSintoma.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateSintoma (Sintoma s, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iSintoma.save(s);
			answer = true;
		}
		return answer;
	}
	
	public boolean deleteSintoma (Sintoma s, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iSintoma.delete(s);
			answer = true;
		}
		return answer;
	}
}
