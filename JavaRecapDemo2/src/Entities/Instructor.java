package Entities;

public class Instructor extends User{
	
	private String department;

	public Instructor() {
		super();
	}

	public Instructor(int id, String name, String surname, String email, String password, String department, String role, boolean status) {
		super(id, name, surname, email, password, role, status);
		this.setDepartment(department);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
