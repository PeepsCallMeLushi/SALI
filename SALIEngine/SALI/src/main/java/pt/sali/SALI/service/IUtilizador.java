package pt.sali.SALI.service;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Utilizador;

public interface IUtilizador extends MongoRepository<Utilizador, String> {
	
	Optional<Utilizador> findByTokenRestTokenName(String token);
	Optional<Utilizador> findByTokenSpringTokenName(String token);
	Optional<Utilizador> findById(String id);
	Optional<Utilizador> findByLoginLogin(String user);
	Optional<Utilizador> findByLoginPassword(String pass);

}
