package DataAccess.Abstracts;

import java.util.List;

import Entities.Concretes.User;

public interface IUserDao {
	void register(User user);
	void delete(int index);
	void update(User user);
	User login(String email, String password);
}
