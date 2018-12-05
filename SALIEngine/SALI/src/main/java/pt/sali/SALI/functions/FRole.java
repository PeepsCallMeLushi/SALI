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
	
	public String saveRole (Role r, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		boolean jaExiste = false;
		
		
		if (u.isPresent()) {
			for (Role rl: iRole.findAll()) {
				if (rl.getNome().compareToIgnoreCase(r.getNome())==0){ 
					jaExiste = true;
				}
			}
			if (jaExiste == true) {
				answer = "Role já existente";
			}else if (jaExiste == false){
				iRole.save(r);
				answer = "Role gravado com sucesso";
			}
		}
		return answer;
	}
	
	public List<Role> listarRole (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		
		if (u.isPresent()) {
			return iRole.findAll();
		}else {
			return null;
		}
	}
	
	public String updateRole (Role r, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iRole.save(r);
			answer = "Atualizado com sucesso";
		}
		
		return answer;
	}
	
	public String deleteRole (Role r, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iRole.delete(r);
			answer = "Apagado com sucesso";
		}
		
		return answer;
	}
}
