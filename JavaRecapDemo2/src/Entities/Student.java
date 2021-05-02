package Entities;

public class Student extends User {
	private String address;
	private String imagePath;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String surname, String email, String password, String address, String imagePath, String role, boolean status) {
		super(id, name, surname, email, password, role, status);
		this.setAddress(address);
		this.setImagePath(imagePath);
	}
		
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
