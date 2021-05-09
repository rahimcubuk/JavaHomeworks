package RnR.JavaCampProject.Entities.Concretes;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "employers")
@Data
public class Employer {

	@Id
	@Column(name = "employer_id")
	private int employerId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_address")
	private String webAddress;
	@Column(name = "phone_number")
	private String phoneNumber;
}
