package model;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String id;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void saveInfo () {
		//guarda la info de los espectadores
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	
}
