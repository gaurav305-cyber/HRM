package com.test.model.External;


public class Department {
	private String id;
    private String name;
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
		if(name==null) {
			this.name="Payment";
		}
		else {
			this.name = name;
		}
		
		
	}
}
