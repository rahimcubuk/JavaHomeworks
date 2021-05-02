package Business;

import Entities.User;
import Logger.Logger;

public class UserManager {

	private Logger _logger;
	public UserManager(Logger logger) {
		_logger = logger;
	}
	
	public void add(User entity) {
		System.out.println("adý: " + entity.getName() + " " + entity.getSurname());
		System.out.println("mail: " + entity.getEmail() + " þifre: " + entity.getPassword());
		_logger.log();
	}

	public void delete(User entity) {
		System.out.println("adý: " + entity.getName() + " " + entity.getSurname());
		System.out.println("mail: " + entity.getEmail() + " þifre: " + entity.getPassword());
		_logger.log();
	}

	public void update(User entity) {
		System.out.println("adý: " + entity.getName() + " " + entity.getSurname());
		System.out.println("mail: " + entity.getEmail() + " þifre: " + entity.getPassword());
		_logger.log();
	}

	public void list(User... users) {
		for (User user : users) {
			System.out.println(user.getName() + " " + user.getSurname());
		}
		_logger.log();
	}
}
