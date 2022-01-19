package com.rprandt.apievents.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rprandt.apievents.domain.Event;
import com.rprandt.apievents.dto.EventDTO;
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
	public ResponseEntity<List<EventDTO>> findAllEvents(){
		List<Event> list = service.findAllEvents();
		List<EventDTO> listDTO = list.stream().map(x -> new EventDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
