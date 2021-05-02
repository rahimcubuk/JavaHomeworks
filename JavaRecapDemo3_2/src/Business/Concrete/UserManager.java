package Business.Concrete;

import Business.Abstract.IUserService;
import Adaptors.IPersonCheckService;
import Entities.User;
import Loggers.ILogger;
import Utils.BusinessRules;
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
	 * */
	private Result CheckIfRealPerson(User user){
		if(!checkService.checkIfRealPerson(user)) {
			return new Result("Oyuncu bilgileri hatalýdýr.", false);
		}
		return new Result("Satýlabilir.",true);
	}
	
	@Override
	public void add(User user) {
		
		Result result = BusinessRules.Run(CheckIfRealPerson(user));
		
		if (result == null) {
			System.out.println(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu sisteme kaydedildi.");
			for (ILogger logger : loggers) {
				logger.log(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu sisteme kaydedildi.");
			}
		} else {
			System.out.println(result.getMessage());
			for (ILogger logger : loggers) {
				logger.log(result.getMessage());
			}
		}
	}

	@Override
	public void update(User user) {
		Result result = BusinessRules.Run(CheckIfRealPerson(user));
		
		if (result == null) {
			System.out.println(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.");
			for (ILogger logger : loggers) {
				logger.log(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.");
			}
		} else {
			System.out.println(result.getMessage());
			for (ILogger logger : loggers) {
				logger.log(result.getMessage());
			}
		}
	}

	@Override
	public void delete(User user) {
		Result result = BusinessRules.Run(CheckIfRealPerson(user));
		
		if (result == null) {
			user.setStatus(false);
			System.out.println(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.");
			for (ILogger logger : loggers) {
				logger.log(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu bilgileri güncellendi.");
			}
		} else {
			System.out.println(result.getMessage());
			for (ILogger logger : loggers) {
				logger.log(result.getMessage());
			}
		}
	}
}
