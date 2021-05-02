package Entities;

public class User {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String role;
	private boolean status;

	public User(int id, String name, String surname, String email, String password, String role, boolean status) {
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setPassword(password);
		this.setRole(role);
		this.setStatus(status);
	}

	public User() {
		super();
	}

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
