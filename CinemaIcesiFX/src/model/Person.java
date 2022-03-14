package model;

import java.io.Serializable;

public class Person implements Serializable {


	private String name;
	private String id;

	public Person() {

	}

	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

}
