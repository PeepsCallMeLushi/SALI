package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.sali.SALI.model.Farmaco;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IFarmaco;
import pt.sali.SALI.service.IUtilizador;

@Service("ffarmaco")
public class FFarmaco {
	
	@Autowired
	IFarmaco iFarmaco;
	@Autowired
	IUtilizador iUtilizador;
	
	public int saveFarmaco(Farmaco f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean isEqual = false;
			
		if (u.isPresent()) {
			for (Farmaco fm: iFarmaco.findAll()) {
				if (fm.getNome().compareToIgnoreCase(f.getNome()) == 0){ 
					isEqual = true;
				}
			}
			if (isEqual) {
				return 2;
			}else {
				iFarmaco.save(f);
				return 1;
			}
		}
		return 0;
	}
	
	public List<Farmaco> listarFarmaco (String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		
		if (u.isPresent()) {
			return iFarmaco.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateFarmaco (Farmaco f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iFarmaco.save(f);
			answer = true;
		}
		
		return answer;
	}
	
	public boolean deleteFarmaco (Farmaco f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iFarmaco.delete(f);
			answer = true;
		}
		
		return answer;
	}
}
