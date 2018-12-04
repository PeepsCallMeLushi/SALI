package pt.sali.SALI.service;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Utilizador;

public interface IUtilizador extends MongoRepository<Utilizador, String> {
	
	Optional<Utilizador> findByTokenToken(String token);

}
