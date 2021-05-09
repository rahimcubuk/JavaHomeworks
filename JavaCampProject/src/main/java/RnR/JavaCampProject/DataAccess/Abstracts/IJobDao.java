package RnR.JavaCampProject.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import RnR.JavaCampProject.Entities.Concretes.Job;

public interface IJobDao extends JpaRepository<Job, Integer> {

}
