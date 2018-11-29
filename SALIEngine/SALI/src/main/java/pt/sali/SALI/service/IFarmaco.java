package pt.sali.SALI.service;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Farmaco;

public interface IFarmaco extends MongoRepository<Farmaco, String> {

	@Override
	default Optional<Farmaco> findById(String id) {
		
		return null;
	}
	
}
