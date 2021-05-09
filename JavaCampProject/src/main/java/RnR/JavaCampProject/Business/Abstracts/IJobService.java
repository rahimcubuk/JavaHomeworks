package RnR.JavaCampProject.Business.Abstracts;

import java.util.List;

import RnR.JavaCampProject.Entities.Concretes.Job;


public interface IJobService {
	List<Job> getAll();
}
