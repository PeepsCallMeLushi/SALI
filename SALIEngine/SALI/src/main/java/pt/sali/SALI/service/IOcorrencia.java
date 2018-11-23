package pt.sali.SALI.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Ocorrencia;

public interface IOcorrencia extends MongoRepository<Ocorrencia, String>{

}
