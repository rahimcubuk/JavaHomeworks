package Business.Concretes;

import java.util.List;
import java.util.Scanner;

import Business.Abstracts.IUserService;
import DataAccess.Abstracts.IUserDao;
import Entities.Concretes.User;
import Utils.BusinessRules;
import Utils.Result;
import Core.Abstracts.*;

public class UserManager implements IUserService {

	private IUserDao userDao;
	private IVerificationService verificationService;
	private Scanner read;
	public UserManager(IUserDao userDao, IVerificationService verificationService) {
		this.userDao = userDao;
		this.verificationService = verificationService;
	}

	/*
	 * BUSINESS RULES
	 */
	private Result CheckIfUserExistByEmail(String email) {
		var user = userDao.getByEmail(email);
		if(user == null) {
			return new Result("Bu mail adresi ile kay�tl� bir kullan�c� yok.", true);
		}
		else {
			return new Result("Bu mail adresi ba�ka bir kullan�c� taraf�ndan kullan�lmakta.", false);
		}
	}

	/*
	 * BUSINESS Methods
	 */
	@Override
	public void register(User user) {
		List<String> validateResults = verificationService.validate(user);
		Result businessRulesResult = BusinessRules.Run(CheckIfUserExistByEmail(user.getEmail()));
		if (validateResults.isEmpty() && businessRulesResult == null) {
			this.verificationCode(user.getEmail());
			userDao.register(user);
			System.out.println("Kay�t i�lemi ba�ar�l�.");
		} else {
			for (String validateResult : validateResults) {
				System.out.println(validateResult);
			}
			if (businessRulesResult != null)
				System.out.println(businessRulesResult.getMessage());
		}
	}

	@Override
	public void delete(User user) {
		Result businessRulesResult = BusinessRules.Run(CheckIfUserExistByEmail(user.getEmail()));
		if (businessRulesResult != null) {
			userDao.delete(user);
			System.out.println("Kullan�c� bilgileri silindi.");
		} else {
			System.out.println("Kullan�c� bilgileri hatal�.");
		}
	}

	@Override
	public void update(User user) {
		List<String> validateResults = verificationService.validate(user);
		Result businessRulesResult = BusinessRules.Run(CheckIfUserExistByEmail(user.getEmail()));
		if (validateResults == null && businessRulesResult != null) {
			userDao.update(user);
			System.out.println("Kullan�c� bilgileri g�ncellendi.");
		} else {
			for (String validateResult : validateResults) {
				System.out.println(validateResult);
			}
			System.out.println(businessRulesResult.getMessage());
		}
	}

	@Override
	public void verificationCode(String email) {
		this.read = new Scanner(System.in);
		int code = 100000 + (int) (Math.random() * 899999);
		int userCode;
		System.out.println(email + " adresine g�nderilen 6 haneli kodu girin.");
		while(true) {
			System.out.print(code + " = ");
			userCode = read.nextInt();
			if(userCode == code) {
				break;
			}
			System.out.println();
		}
	}

	@Override
	public User login(String email, String password) {
		var user = userDao.login(email, password);
		if (user == null) {
			System.out.println("Kullan�c� Bulunamad�.");
		} else {
			System.out.println("Ba�ar�yla Giri� Yapt�n�z.");
		}
		return user;
	}

}
