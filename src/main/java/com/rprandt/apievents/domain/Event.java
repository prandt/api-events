package com.rprandt.apievents.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event{

	@Id
	private String id;
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;
	
}
