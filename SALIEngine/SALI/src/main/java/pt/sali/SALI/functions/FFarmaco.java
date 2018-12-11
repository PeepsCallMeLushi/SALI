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

		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean isEqual = false;
		
		if (ur.isPresent() || us.isPresent()) {
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

		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);

		if (ur.isPresent() || us.isPresent()) {
			return iFarmaco.findAll();
		}else {
			return null;
		}
	}

	public boolean updateFarmaco (Farmaco f, String tok) {

		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;

		if (ur.isPresent() || us.isPresent()) {
			iFarmaco.save(f);
			answer = true;
		}

		return answer;
	}

	public boolean deleteFarmaco (String id, String tok) {

		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;

		if (ur.isPresent() || us.isPresent()) {
			iFarmaco.deleteById(id);
			answer = true;
		}

		return answer;
	}
}
