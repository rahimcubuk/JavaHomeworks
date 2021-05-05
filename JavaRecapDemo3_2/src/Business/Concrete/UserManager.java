package Business.Concrete;

import Business.Abstract.IUserService;

import java.rmi.RemoteException;

import Adaptors.IPersonCheckService;
import Entities.User;
import Loggers.ILogger;
import Utils.BusinessRules;
import Utils.LoggerAspect;
import Utils.Result;

public class UserManager implements IUserService {

	private IPersonCheckService checkService;
	private ILogger[] loggers;

	public UserManager(IPersonCheckService checkService, ILogger... loggers) {
		this.checkService = checkService;
		this.loggers = loggers;
	}

	/*
	 * BUSINESS RULES
	 */
	private Result CheckIfRealPerson(User user) throws NumberFormatException, RemoteException {
		if (!checkService.checkIfRealPerson(user)) {
			return new Result("Oyuncu bilgileri hatalýdýr.", false);
		}
		return new Result("Satýlabilir.", true);
	}

	/*
	 * BUSINESS Methods
	 */
	@Override
	public void add(User user) throws NumberFormatException, RemoteException {

		Result result = BusinessRules.Run(CheckIfRealPerson(user));

		if (result == null) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu sisteme kaydedildi.");
			LoggerAspect.run(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu sisteme kaydedildi.",
					loggers);
		} else {
			System.out.println(result.getMessage());
			LoggerAspect.run(result.getMessage(), loggers);
		}
	}

	@Override
	public void update(User user) throws NumberFormatException, RemoteException {
		Result result = BusinessRules.Run(CheckIfRealPerson(user));

		if (result == null) {
			System.out
					.println(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.");
			LoggerAspect.run(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.",
					loggers);
		} else {
			System.out.println(result.getMessage());
			LoggerAspect.run(result.getMessage(), loggers);
		}
	}

	@Override
	public void delete(User user) throws NumberFormatException, RemoteException {
		Result result = BusinessRules.Run(CheckIfRealPerson(user));

		if (result == null) {
			user.setStatus(false);
			System.out
					.println(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.");
			LoggerAspect.run(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.",
					loggers);
		} else {
			System.out.println(result.getMessage());
			LoggerAspect.run(result.getMessage(), loggers);
		}
	}
}
