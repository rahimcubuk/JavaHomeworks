package Core.Concretes;

import java.util.List;

import Core.Abstracts.IVerificationService;
import Entities.Concretes.User;
import GoogleAccounts.GoogleAccountVerificationService;

public class GoogleAccountVerificationAdaptor implements IVerificationService {

	@Override
	public List<String> validate(User user) {
		GoogleAccountVerificationService verificationService = new GoogleAccountVerificationService();
		return verificationService.isValid(user);
	}

}
