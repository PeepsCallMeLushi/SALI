package pt.sali.SALI.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@Service("futilizador")
public class FUtilizador {
	
	@Autowired
	IUtilizador iUtilizador;
	
	public String saveUtilizador (Utilizador u, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		boolean jaExiste = false;
		
		
		if (ut.isPresent()) {
			for (Utilizador uti: iUtilizador.findAll()) {
				if (uti.getNome().compareToIgnoreCase(u.getNome())==0){ 
					jaExiste = true;
				}
			}
			if (jaExiste == true) {
				answer = "Role já existente";
			}else if (jaExiste == false){
				iUtilizador.save(u);
				answer = "Role gravado com sucesso";
			}
		}
		return answer;
	}
	
	public List<Utilizador> listarAllUtilizador (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		
		if (u.isPresent()) {
			ArrayList<Utilizador> aux = new ArrayList<>();
			
			for (Utilizador ut : iUtilizador.findAll()) {
				ut.getLogin().setPassword("oi");
				ut.getToken().setToken("oi");
				aux.add(ut);
			}
			return aux;
		}else {
			return null;
		}
	}
	
	public List<Utilizador> listarUtilizadorByRole (@RequestParam ("role") String role, @RequestParam ("tok") String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken("tok");
		ArrayList<Utilizador> aux = new ArrayList<>();
		
		if (u.isPresent()) {
			for (Utilizador ut : iUtilizador.findAll()) {
				if (ut.getRole().getNome().compareTo(role) == 0) {
					ut.getLogin().setPassword("oi");
					ut.getToken().setToken("oi");
					aux.add(ut);
				}
			}
			return aux;
		}
		
		return aux;
	}
	
	public String updateUtilizador (Utilizador u, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (ut.isPresent()) {
			iUtilizador.save(u);
			answer = "Atualizado com sucesso";
		}
		
		return answer;
	}
	
	public String deleteUtilizador (Utilizador u, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken("tok");
		String answer = "Token não está presente";
		
		if (ut.isPresent()) {
			iUtilizador.delete(u);
			answer = "Apagado com sucesso";
		}
		
		return answer;
	}
	
	public String login (@RequestParam ("username") String username, 
							@RequestParam ("password") String password) {
		
		String answer = "Falhou";
		Utilizador u = new Utilizador();
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getLogin().getLogin().compareTo(username) == 0) {
				if (ut.getLogin().getPassword().compareTo(password) == 0) {
					u = ut;
					u.getLogin().setPassword("oi");
					
					UUID idtoken = UUID.randomUUID();
					ut.getToken().setToken(idtoken.toString());
					iUtilizador.save(ut);
					
					answer = idtoken.toString();
				}
			}
		}
		return answer;
		
	}
}
