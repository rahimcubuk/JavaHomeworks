package DataAccess.Concretes;

import java.util.List;

import DataAccess.Abstracts.IUserDao;
import Entities.Concretes.User;

public class JUserDao implements IUserDao {

	private List<User> users;
	public JUserDao(List<User> users) {
		this.users = users;
	}
	
	@Override
	public void register(User user) {
		users.add(user);
	}

	@Override
	public void delete(User user) {
		int index = users.indexOf(user);
		users.remove(index);
	}

	@Override
	public void update(User user) {
		int index = 0;
		for (User oldUser : users) {
			if(oldUser.getEmail() == user.getEmail()) {
				break;
			}
			index++;
		}
		users.add(index, user);
	}

	@Override
	public User login(String email, String password) {
		int index = 0;
		for (User userData : users) {
			if(userData.getEmail() == email && userData.getPassword() == password) {
				return users.get(index);
			}
			index++;
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for (User user : users) {
			if(user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}
}
