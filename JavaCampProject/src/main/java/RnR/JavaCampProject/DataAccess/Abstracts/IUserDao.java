package RnR.JavaCampProject.DataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import RnR.JavaCampProject.Entities.Concretes.User;

public interface IUserDao extends JpaRepository<User, Integer> {

}
