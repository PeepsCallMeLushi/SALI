package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IFreguesia;
import pt.sali.SALI.service.IUtilizador;

@Service("ffreguesia")
public class FFreguesia {
	
	@Autowired
	IFreguesia iFreguesia;
	
	@Autowired
	IUtilizador iUtilizador;
	
	public String saveFreguesia (Freguesia f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		boolean jaExiste = false;
		
		
		if (u.isPresent()) {
			for (Freguesia fg: iFreguesia.findAll()) {
				if (fg.getNome().compareToIgnoreCase(f.getNome())==0){ 
					jaExiste = true;
				}
			}
			if (jaExiste == true) {
				answer = "Freguesia já existente";
			}else if (jaExiste == false){
				iFreguesia.save(f);
				answer = "Freguesia gravada com sucesso";
			}
		}
		return answer;
	}
	
	public List<Freguesia> listarFreguesia (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		
		if (u.isPresent()) {
			return iFreguesia.findAll();
		}else {
			return null;
		}
	}
	
	public String updateFreguesia (Freguesia f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iFreguesia.save(f);
			answer = "Atualizado com sucesso";
		}
		
		return answer;
	}
	
	public String deleteFreguesia (Freguesia f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (u.isPresent()) {
			iFreguesia.delete(f);
			answer = "Apagado com sucesso";
		}
		
		return answer;
	}
}
