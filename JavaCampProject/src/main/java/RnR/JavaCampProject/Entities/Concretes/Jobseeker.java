package RnR.JavaCampProject.Entities.Concretes;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "jobseekers")
@Data
public class Jobseeker {

	@Id
	@Column(name = "jobseeker_id")
	private int jobseekerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "nationality_id")
	private String nationalityId;
	@Column(name = "birthday")
	private String birthday;
}
