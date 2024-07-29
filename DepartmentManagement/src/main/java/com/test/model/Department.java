package com.test.model;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document
public class Department {

	@Id
	private String id;
    private String name;
    
    public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
