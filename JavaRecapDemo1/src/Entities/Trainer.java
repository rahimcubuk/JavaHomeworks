package Entities;

public class Trainer implements IEntity {
	
	/********************************************************\
	 * 	properties
	\********************************************************/
	
	private int id;
	private String name;
	private String campId;
	private String department;

	/********************************************************\
	 * 	constructors
	\********************************************************/
	
	public Trainer() {	}

	public Trainer(int id, String name, String department) {
		this.setId(id);
		this.setName(name);
		this.setDepartment(department);
	}

	/********************************************************\
	 * 	encapsulation
	\********************************************************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCampId() {
		this.campId = getName().substring(0,1) + String.valueOf(id);   
		return campId;
	}

	/********************************************************/
	
}
