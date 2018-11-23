package pt.sali.SALI.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Freguesia;

public interface IFreguesia extends MongoRepository<Freguesia, String> {

}
