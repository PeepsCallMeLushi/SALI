package pt.sali.SALI.service;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Freguesia;

public interface IFreguesia extends MongoRepository<Freguesia, String> {

	Optional<Freguesia> findById (String id);
}
