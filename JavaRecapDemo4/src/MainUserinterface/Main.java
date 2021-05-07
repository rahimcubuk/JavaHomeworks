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

		User validUser = new User(1,"Rahim","�ubuk","rahimcubuk@gmail.com","123456");
		User invalidUser = new User(2,"Rahim","�","rahimgmail.com","1256");

		System.out.println("Ge�erli bilgiler ile kullan�c� kayd�: ");
		userService.register(validUser); // kullan�c� kayd�
		
		System.out.println("*************************************");
		System.out.println("Hatal� bilgiler ile kullan�c� kayd�: ");
		userService.register(validUser); // kay�tl� mail ile kullan�c� kayd�
		userService.register(invalidUser); // hatal� bilgiler ile kullan�c� kayd�

		System.out.println("*************************************");
		System.out.println("Kullan�c� kayd� silme: ");
		userService.delete(validUser); // kullan�c�y� silme
		userService.register(validUser); // kullan�c� kayd�

		System.out.println("*************************************");
		System.out.println("Ge�erli bilgiler ile giri� i�lemi: ");
		userService.login("rahimcubuk@gmail.com","123456"); // email ve �ifre ile giri� i�lemi
		
		System.out.println("*************************************");
		System.out.println("Hatal� bilgiler ile giri� i�lemi: ");
		userService.login("rahimcubuk@gmail.com","1234567"); // hatal� email ve �ifre ile giri� i�lemi
	}

}
