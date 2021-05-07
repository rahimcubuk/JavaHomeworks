package Business.Abstracts;

import Entities.Concretes.User;

public interface IUserService {
	void register(User user);
	void delete(User user);
	void update(User user);
	User login(String email, String password);
	void verificationCode(String code);
}
