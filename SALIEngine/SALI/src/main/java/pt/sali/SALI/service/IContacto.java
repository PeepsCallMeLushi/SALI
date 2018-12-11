package pt.sali.SALI.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Contacto;

public interface IContacto extends MongoRepository<Contacto, String> {

}
