package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.sali.SALI.model.Contacto;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IContacto;
import pt.sali.SALI.service.IUtilizador;

@Service("fcontacto")
public class FContacto {
	
	@Autowired
	IContacto iContacto;	
	@Autowired
	IUtilizador iUtilizador;
	
	public int saveContacto (Contacto r, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean isEqual = false;
		
		if (ur.isPresent() || us.isPresent()) {
			for (Contacto rl: iContacto.findAll()) {
				if (rl.getNome().compareToIgnoreCase(r.getNome()) == 0){ 
					isEqual = true;
				}
			}
			if (isEqual) {
				return 2;
			}else {
				iContacto.save(r);
				return 1;
			}
		}
		return 0;
	}
	
	public List<Contacto> listarContacto (String tok) {
	
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ur.isPresent() || us.isPresent()) {
			return iContacto.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateContacto (Contacto r, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iContacto.save(r);
			answer = true;
		}
		
		return answer;
	}
	
	public boolean deleteContacto (String id, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iContacto.deleteById(id);
			answer = true;
		}
		
		return answer;
	}
}
