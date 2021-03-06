package com.rprandt.apievents.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rprandt.apievents.domain.Event;
import com.rprandt.apievents.repositories.EventRepository;
import com.rprandt.apievents.services.exception.ObjectNotFoundException;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repo;
	
	public Event findEvent(String id) {
		Optional<Event> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public void saveEvent(Event obj) {
		if(obj == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		
		repo.save(obj);
	}
	
	public List<Event> findAllEvents(){
		List<Event> list = repo.findAll();
		return list;
	}

}
