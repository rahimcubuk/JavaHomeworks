package DataAccess.Abstracts;

import Entities.Concretes.User;

public interface IUserDao {
	void register(User user);
	void delete(User user);
	void update(User user);
	User login(String email, String password);
	User getByEmail(String email);
}
