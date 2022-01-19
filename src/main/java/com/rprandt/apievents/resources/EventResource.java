package com.rprandt.apievents.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.apievents.domain.Event;
import com.rprandt.apievents.services.EventService;

@RestController
@RequestMapping("/events")
public class EventResource {
	
	@Autowired
	private EventService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> findEvent(@PathVariable String id) {
		Event obj = service.findEvent(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> saveEvent(@RequestBody Event obj) {
		service.saveEvent(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Event>> findAllEvents(){
		List<Event> list = service.findAllEvents();
		return ResponseEntity.ok().body(list);
	}

}
