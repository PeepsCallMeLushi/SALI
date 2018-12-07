package pt.sali.SALI.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@Service("futilizador")
public class FUtilizador {
	
	@Autowired
	IUtilizador iUtilizador;
	
	public int saveUtilizador (Utilizador u, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken(tok);
		int answer = 0;
		boolean jaExiste = false;
		
		
		if (ut.isPresent()) {
			for (Utilizador uti: iUtilizador.findAll()) {
				if (uti.getIdentificador().compareToIgnoreCase(u.getIdentificador()) == 0){
					jaExiste = true;
				}
			}
			if (jaExiste == true) {
				answer = 2;
				return answer;
			}else if (jaExiste == false){
				
				/*Define o username e a password por default para a cedula inserida*/
				Login log = new Login(u.getIdentificador(), u.getIdentificador());
				u.setLogin(log);
				/***************/
				
				iUtilizador.save(u);
				answer = 1;
				return answer;
			}
		}
		return answer;
	}
	
	public List<Utilizador> listarAllUtilizador (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		
		if (u.isPresent()) {
			ArrayList<Utilizador> aux = new ArrayList<>();
			
			for (Utilizador ut : iUtilizador.findAll()) {
				if (ut.getEstado().equals("Ativo")) {
					ut.getLogin().setPassword("oi");
					ut.getToken().setToken("oi");
					aux.add(ut);
				}
			}
			return aux;
		}else {
			return null;
		}
	}
	
	public List<Utilizador> listarUtilizadorByRole (@RequestParam ("role") String role, @RequestParam ("tok") String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
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
	
	public boolean updateUtilizador (Utilizador u, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (ut.isPresent()) {
			iUtilizador.save(u);
			answer = true;
		}
		return answer;
	}
	
	public boolean deleteUtilizador (String id, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (ut.isPresent()) {
			for (Utilizador u : iUtilizador.findAll()) {
				if (u.getId().equals(id)) {
					iUtilizador.delete(u);
				}
			}
			answer = true;
		}
		return answer;
	}
	public boolean changeEstadoUtilizador (String id, String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (ut.isPresent()) {
			for (Utilizador u : iUtilizador.findAll()) {
				if (u.getId().equals(id)) {
					u.setEstado("Inativo");
				}
			}
			answer = true;
		}
		return answer;
	}
	
	/*public String loginSpring (@RequestParam ("username") String username, 
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
	}*/
	
	public Utilizador login (@RequestParam ("username") String username, 
			@RequestParam ("password") String password) {

		Optional<Utilizador> u = null;

		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getLogin().getLogin().compareTo(username) == 0) {
				if (ut.getLogin().getPassword().compareTo(password) == 0) {
					
					UUID idtoken = UUID.randomUUID();
					ut.getToken().setToken(idtoken.toString());
					iUtilizador.save(ut);
					
					//TODO
					u = iUtilizador.findById(ut.getId());
					
					u.get().getLogin().setPassword("porra");
					
					return u.get();
				}
			}
		}
		return null;
	}
}
