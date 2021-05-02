package Entities;

public class User implements IEntity {
	private int id;
	private String firtName;
	private String lastName;
	private String nationalId;
	private String yearOfBirth;
	private boolean status;
	
	public User(int id, String firtName, String lastName, String nationalId, String yearOfBirth, boolean status) {
		super();
		this.id = id;
		this.firtName = firtName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.yearOfBirth = yearOfBirth;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
