package RnR.JavaCampProject.Business.Abstracts;

import java.util.List;

import RnR.JavaCampProject.Entities.Concretes.User;

public interface IUserService {
	List<User> getAll();
}
