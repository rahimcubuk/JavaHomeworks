package Core.Abstracts;

import java.util.List;

import Entities.Concretes.User;

public interface IVerificationService {
	List<String> validate(User user);
}
