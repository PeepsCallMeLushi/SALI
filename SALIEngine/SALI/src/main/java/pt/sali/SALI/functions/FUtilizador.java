package pt.sali.SALI.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Token;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@Service("futilizador")
public class FUtilizador {

	@Autowired
	IUtilizador iUtilizador;

	public int saveUtilizador (Utilizador u, String tok) {

		Optional<Utilizador> ur = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean isEqual = false;

		if (ur.isPresent() || us.isPresent()) {
			for (Utilizador uti: iUtilizador.findAll()) {
				if (uti.getIdentificador().compareToIgnoreCase(u.getIdentificador()) == 0){
					isEqual = true;
				}
			}
			if (isEqual) {
				return 2;
			} else {
				/*Define o username e a password por default para a cedula inserida*/
				Login log = new Login(u.getIdentificador(), u.getIdentificador());
				u.setLogin(log);
				u.setEstado("Ativo");
				/***************/

				iUtilizador.save(u);
				return 1;
			}
		}
		return 0;
	}

	public List<Utilizador> listarAllUtilizador (String tok) {

		Optional<Utilizador> u = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);

		if (u.isPresent() || us.isPresent()) {
			ArrayList<Utilizador> aux = new ArrayList<>();

			for (Utilizador ut : iUtilizador.findAll()) {
					ut.getLogin().setPassword("oi");
					ut.getTokenRest().setTokenName("oi");
					ut.getTokenSpring().setTokenName("oi");
					aux.add(ut);
			}
			return aux;
		}else {
			return null;
		}
	}

	public List<Utilizador> listarActiveUtilizador (String tok) {

		Optional<Utilizador> u = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);

		if (u.isPresent() || us.isPresent()) {
			ArrayList<Utilizador> aux = new ArrayList<>();
			for (Utilizador ut : iUtilizador.findAll()) {
				if (ut.getEstado().compareToIgnoreCase("Ativo") == 0) {
					ut.getLogin().setPassword("oi");
					ut.getTokenRest().setTokenName("oi");
					ut.getTokenSpring().setTokenName("oi");
					aux.add(ut);
				}
			}
			return aux;
		}else {
			return null;
		}
	}

	public List<Utilizador> listarUtilizadorByRole (@RequestParam ("role") String role,
							@RequestParam ("tok") String tok) {

		Optional<Utilizador> u = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		ArrayList<Utilizador> aux = new ArrayList<>();

		if (u.isPresent() || us.isPresent()) {
			for (Utilizador ut : iUtilizador.findAll()) {
				if (ut.getRole().getNome().compareTo(role) == 0
						&& ut.getEstado().equals("Ativo")) {
					ut.getLogin().setPassword("oi");
					ut.getTokenRest().setTokenName("oi");
					ut.getTokenSpring().setTokenName("oi");
					aux.add(ut);
				}
			}
			return aux;
		}
		return null;
	}
	
	public Utilizador listarUTbyId (@RequestParam ("id") String id, 
							@RequestParam ("tok") String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (u.isPresent() || us.isPresent()) {
			Optional<Utilizador> user = iUtilizador.findById(id);
			return user.get();
		}
		return null;
	}

	public boolean updateUtilizador (Utilizador u, String tok) {

		Optional<Utilizador> ut = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		boolean answer = false;

		if (ut.isPresent() || us.isPresent()) {
			iUtilizador.save(u);
			answer = true;
		}
		return answer;
	}

	public boolean deleteUtilizador (String id, String tok) {

		Optional<Utilizador> ut = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);

		if (ut.isPresent() || us.isPresent()) {
			iUtilizador.deleteById(id);
			return true;
		}
		return false;
	}
	public boolean changeEstadoUtilizador (String id, String tok) {

		Optional<Utilizador> ut = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		Optional<Utilizador> uti = iUtilizador.findById(id);

		if (ut.isPresent() || us.isPresent()) {
			if (uti.isPresent()) {
				uti.get().setEstado("Inativo");
				iUtilizador.save(uti.get());
			}
			return true;
		}
		return false;
	}
	
	public Utilizador UTbyToken (String tok) {
		
		Optional<Utilizador> ut = iUtilizador.findByTokenRestTokenName(tok);
		Optional<Utilizador> us = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (ut.isPresent() || us.isPresent()) {
			return us.get();
		}else {
			return null;
		}
	}

	public Utilizador loginSpring (@RequestParam ("username") String username,
			@RequestParam ("password") String password) {

		Optional<Utilizador> u = null;
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getLogin().getLogin().compareToIgnoreCase(username) == 0) {
				if (ut.getLogin().getPassword().compareTo(password) == 0) {
					UUID idtoken = UUID.randomUUID();
					ut.getTokenSpring().setTokenName(idtoken.toString());
					iUtilizador.save(ut);
					u = iUtilizador.findById(ut.getId());
					u.get().getLogin().setPassword("porra");

					return u.get();
				}
			}
		}
		return null;
	}
	
	public Utilizador loginRest (@RequestParam ("username") String username,
			@RequestParam ("password") String password) {

		Optional<Utilizador> u = null;
		
		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getLogin().getLogin().compareToIgnoreCase(username) == 0) {
				if (ut.getLogin().getPassword().compareTo(password) == 0) {
					UUID idtoken = UUID.randomUUID();
					ut.getTokenRest().setTokenName(idtoken.toString());
					iUtilizador.save(ut);
					u = iUtilizador.findById(ut.getId());
					u.get().getLogin().setPassword("porra");

					return u.get();
				}
			}
		}
		return null;
	}
	
	public int loginValidacao (@RequestParam ("username") String username,
			@RequestParam ("password") String password) {

		int res = 0;

		for (Utilizador ut : iUtilizador.findAll()) {
			if (ut.getLogin().getLogin().compareTo(username) == 0) {
				if (ut.getLogin().getPassword().compareTo(password) == 0) {
					return 1;
				}
				res = 2;
			}
		}
		return res;
	}
	
	public void logoutRest (String id) {
		
		Optional<Utilizador> u = iUtilizador.findById(id);
		
		u.get().setTokenRest(new Token (null, 0));
		iUtilizador.save(u.get());
	}
	
	public void logoutSpring (String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenSpringTokenName(tok);
		
		u.get().setTokenSpring(new Token (null, 0));
		iUtilizador.save(u.get());
	}
	
	public int alterarPassSpring (String pass, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenSpringTokenName(tok);
		
		if (u.isPresent()) {
			u.get().getLogin().setPassword(pass);
			iUtilizador.save(u.get());
			return 1;
		}
		return 2;
	}
}
