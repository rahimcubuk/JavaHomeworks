package Business.Abstract;

import Entities.User;

public interface IUserService {
	void add(User user);

	void update(User user);

	void delete(User user);
}
