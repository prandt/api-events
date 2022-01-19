package com.rprandt.apievents.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rprandt.apievents.domain.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{

}
