package pt.sali.SALI.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import pt.sali.SALI.model.Role;

public interface IRole extends MongoRepository<Role, String> {

}
