package RnR.JavaCampProject.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import RnR.JavaCampProject.Entities.Concretes.Employer;

public interface IEmployerDao extends JpaRepository<Employer, Integer> {

}
