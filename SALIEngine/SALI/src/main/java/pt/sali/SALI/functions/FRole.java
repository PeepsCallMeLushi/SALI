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
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		int answer = 0;
		boolean jaExiste = false;
		
		
		if (u.isPresent()) {
			for (Role rl: iRole.findAll()) {
				if (rl.getNome().compareToIgnoreCase(r.getNome())==0){ 
					jaExiste = true;
				}
			}
			if (jaExiste == true) {
				answer = 2;
			}else if (jaExiste == false){
				iRole.save(r);
				answer = 1;
			}
		}
		return answer;
	}
	
	public List<Role> listarRole (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		
		if (u.isPresent()) {
			return iRole.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateRole (Role r, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iRole.save(r);
			answer = true;
		}
		
		return answer;
	}
	
	public boolean deleteRole (Role r, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iRole.delete(r);
			answer = true;
		}
		
		return answer;
	}
}
