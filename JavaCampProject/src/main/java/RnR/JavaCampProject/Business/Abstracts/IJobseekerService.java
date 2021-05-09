package RnR.JavaCampProject.Business.Abstracts;

import java.util.List;

import RnR.JavaCampProject.Entities.Concretes.Jobseeker;

public interface IJobseekerService {
	List<Jobseeker> getAll();
}
