package Core.Concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import Core.Abstracts.IVerificationService;
import Entities.Concretes.User;

public class JUserValidatateManager implements IVerificationService {

	@Override
	public List<String> validate(User user) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);

		List<String> result = new ArrayList<String>();
		if (user.getPassword().length() < 6) {
			result.add("Parola en az 6 karakterden olu�mal�d�r.");
		}
		if (user.getEmail() == null || !pat.matcher(user.getEmail()).matches()) {
			result.add("L�tfen ge�erli bir email adresi giriniz.");
		}
		if (user.getFirstName().length() < 2) {
			result.add("�sim en az 2 karakterden olu�mal�d�r.");
		}
		if (user.getLastName().length() < 2) {
			result.add("Soyisim en az 2 karakterden olu�mal�d�r.");
		}

		return result;
	}
}
