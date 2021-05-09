package RnR.JavaCampProject.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import RnR.JavaCampProject.Entities.Concretes.Jobseeker;

public interface IJobseekerDao extends JpaRepository<Jobseeker, Integer> {

}
