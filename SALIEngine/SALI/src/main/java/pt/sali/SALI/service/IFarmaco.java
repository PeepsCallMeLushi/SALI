package pt.sali.SALI.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Farmaco;

public interface IFarmaco extends MongoRepository<Farmaco, String> {

}
