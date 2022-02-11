package model;

public class UniversityWalfarePerson extends Person {

	public UniversityWalfarePerson(String name, String id) {
		super(name, id);
	}
	
	public boolean logIn(String idToCheck) {
		return idToCheck.equals(this.getId());
	}

	@Override
	public void saveInfo() {
		//guarda la info de la gente de bienestar
	}
	

}
