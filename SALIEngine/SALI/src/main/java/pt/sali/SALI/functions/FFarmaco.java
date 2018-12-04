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
	
	
	public String saveFarmaco(Farmaco f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer="";
		boolean jaExiste = false;
		
		
		
		if (u.isPresent()) {
			for (Farmaco fm: iFarmaco.findAll()) {
				if (fm.getNome().compareToIgnoreCase(f.getNome())==0){ 
					jaExiste = true;
				}
			}
			
			if (jaExiste == true) {
				answer = "Fármaco já existente";
			}else if (jaExiste == false){
				iFarmaco.save(f);
				answer = "Fármaco gravado com sucesso";
			}
		}else {
			answer = "Token não está presente";
		}
		
		return answer;
	}
	
	public List<Farmaco> listarFarmaco (String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		
		if (u.isPresent()) {
			return iFarmaco.findAll();
		}else {
			return null;
		}
	}
	
	public String updateFarmaco (Farmaco f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer;
		
		if (u.isPresent()) {
			iFarmaco.save(f);
			answer = "Atualizado com sucesso";
		}else {
			answer = "Token não está presente";
		}
		return answer;
	}
	
	public String deleteFarmaco (Farmaco f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		String answer;
		
		if (u.isPresent()) {
			iFarmaco.delete(f);
			answer = "Apagado com sucesso";
		}else {
			answer = "Token não está presente";
		}
		
		return answer;
	}
}
