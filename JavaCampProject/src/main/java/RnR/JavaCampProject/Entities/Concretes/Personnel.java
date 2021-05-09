package RnR.JavaCampProject.Entities.Concretes;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "personnels")
@Data
public class Personnel {

	@Id
	@Column(name = "personnel_id")
	private int personnelId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "nationality_id")
	private String nationalityId;
	@Column(name = "salary")
	private double salary;
}
