package Adaptors;

import Entities.User;

public interface IPersonCheckService {
	boolean checkIfRealPerson(User user);
}
