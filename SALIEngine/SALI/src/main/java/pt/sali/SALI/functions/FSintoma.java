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
		
		if (u.isPresent()) {
			for (Sintoma rl: iSintoma.findAll()) {
				if (rl.getNome().equals(s.getNome())){ 
					return 2;
				}else {
					return 1;
				}
			}
		}
		return 0;
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
