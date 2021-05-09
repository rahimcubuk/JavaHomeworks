package RnR.JavaCampProject.Entities.Concretes;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
}
