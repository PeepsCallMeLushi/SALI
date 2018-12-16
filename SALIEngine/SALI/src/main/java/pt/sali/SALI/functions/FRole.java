package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IRole;
import pt.sali.SALI.service.IUtilizador;

@Service("frole")
public class FRole {

	@Autowired
	IRole iRole;
	@Autowired
	IUtilizador iUtilizador;
	
	public int saveRole (Role r, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean isEqual = false;
		
		if (ur.isPresent() || us.isPresent()) {
			for (Role rl: iRole.findAll()) {
				if (rl.getNome().compareToIgnoreCase(r.getNome()) == 0){ 
					isEqual = true;
				}
			}
			if (isEqual) {
				return 2;
			}else {
				iRole.save(r);
				return 1;
			}
		}
		return 0;
	}
	
	public List<Role> listarRole (String tok) {
	
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ur.isPresent() || us.isPresent()) {
			return iRole.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateRole (Role r, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iRole.save(r);
			answer = true;
		}
		
		return answer;
	}
	
	public boolean deleteRole (String id, String tok) {
		
		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;
		
		if (ur.isPresent() || us.isPresent()) {
			iRole.deleteById(id);
			answer = true;
		}
		
		return answer;
	}
}
