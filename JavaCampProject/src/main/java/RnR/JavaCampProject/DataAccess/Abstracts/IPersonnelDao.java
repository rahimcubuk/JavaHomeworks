package RnR.JavaCampProject.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import RnR.JavaCampProject.Entities.Concretes.Personnel;

public interface IPersonnelDao extends JpaRepository<Personnel, Integer> {

}
