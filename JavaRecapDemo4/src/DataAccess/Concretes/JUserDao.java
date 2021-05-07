package DataAccess.Concretes;

import java.util.Iterator;
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
	public void delete(int index) {
		users.remove(index);
	}

	@Override
	public void update(User user) {
		int index = 0;
		User newUser = new User();
		for (User oldUser : users) {
			if(oldUser.getEmail() == user.getEmail()) {
				newUser = users.get(index);
				break;
			}
			index++;
		}
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setId(user.getId());
		newUser.setPassword(user.getPassword());
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
}
