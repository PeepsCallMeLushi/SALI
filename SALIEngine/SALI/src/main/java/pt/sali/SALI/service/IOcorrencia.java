package pt.sali.SALI.service;

import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import pt.sali.SALI.model.Ocorrencia;

public interface IOcorrencia extends MongoRepository<Ocorrencia, String>{

	@Query(value="?0")
	List<Ocorrencia> find(Document query);
}
