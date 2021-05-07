package MainUserinterface;

import java.util.*;

import Business.Abstracts.*;
import Business.Concretes.UserManager;
import Core.Concretes.GoogleAccountVerificationAdaptor;
import Core.Concretes.JUserValidatateManager;
import DataAccess.Concretes.JUserDao;
import Entities.Concretes.User;

public class Main {

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		IUserService userService = new UserManager(new JUserDao(users), new JUserValidatateManager(), users);

		User validUser = new User(1,"Rahim","Çubuk","rahimcubuk@gmail.com","123456");
		User invalidUser = new User(2,"Rahim","Ç","rahimgmail.com","1256");

		System.out.println("Geçerli bilgiler ile kullanýcý kaydý: ");
		userService.register(validUser); // kullanýcý kaydý
		
		System.out.println("*************************************");
		System.out.println("Hatalý bilgiler ile kullanýcý kaydý: ");
		userService.register(validUser); // kayýtlý mail ile kullanýcý kaydý
		userService.register(invalidUser); // hatalý bilgiler ile kullanýcý kaydý

		System.out.println("*************************************");
		System.out.println("Kullanýcý kaydý silme: ");
		userService.delete(validUser); // kullanýcýyý silme
		userService.register(validUser); // kullanýcý kaydý

		System.out.println("*************************************");
		System.out.println("Geçerli bilgiler ile giriþ iþlemi: ");
		userService.login("rahimcubuk@gmail.com","123456"); // email ve þifre ile giriþ iþlemi
		
		System.out.println("*************************************");
		System.out.println("Hatalý bilgiler ile giriþ iþlemi: ");
		userService.login("rahimcubuk@gmail.com","1234567"); // hatalý email ve þifre ile giriþ iþlemi
	}

}
