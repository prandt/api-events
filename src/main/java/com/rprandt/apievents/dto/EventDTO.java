package com.rprandt.apievents.dto;

import java.io.Serializable;
import java.util.Date;

import com.rprandt.apievents.domain.Event;

import lombok.Data;

@Data
public class EventDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Date date;
	
	public EventDTO(Event obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.date = obj.getDate();
	}
	
}
