package Business.Concrete;

import java.rmi.RemoteException;

import Adaptors.IPersonCheckService;
import Business.Abstract.IOrderService;
import Entities.Game;
import Entities.Order;
import Entities.User;
import Loggers.ILogger;
import Utils.BusinessRules;
import Utils.LoggerAspect;
import Utils.Result;

public class OrderManager implements IOrderService {

	private IPersonCheckService checkService;
	private ILogger[] loggers;

	public OrderManager(IPersonCheckService checkService, ILogger... loggers) {
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

	private Result CheckGameStatus(Game game) {
		if (!game.isStatus()) {
			return new Result("Oyun satýþa kapalýdýr.", false);
		}
		return new Result("Satýlabilir.", true);
	}

	@Override
	public void add(Order order) throws NumberFormatException, RemoteException {
		User user = order.getUser();
		Game game = order.getGame();

		Result result = BusinessRules.Run(CheckIfRealPerson(user), CheckGameStatus(game));

		if (result == null) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu " + game.getName()
					+ " oyununu satýn aldý.");
			LoggerAspect.run(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu " + game.getName()
			+ " oyununu satýn aldý.", loggers);
		} else {
			System.out.println(result.getMessage());
			LoggerAspect.run(result.getMessage(), loggers);
		}
	}

	@Override
	public void delete(Order order) throws NumberFormatException, RemoteException {
		User user = order.getUser();
		Game game = order.getGame();

		Result result = BusinessRules.Run(CheckIfRealPerson(user), CheckGameStatus(game));

		if (result == null) {
			System.out.println(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu " + game.getName()
					+ " oyununu iade etti.");
			LoggerAspect.run(user.getFirstName() + " " + user.getLastName() + " isimli oyuncu " + game.getName()
			+ " oyununu iade etti.", loggers);
		} else {
			System.out.println(result.getMessage());
			LoggerAspect.run(result.getMessage(), loggers);
		}
	}

	@Override
	public void update(Order order) throws NumberFormatException, RemoteException {
		User user = order.getUser();
		Result result = BusinessRules.Run(CheckIfRealPerson(user));

		if (result == null) {
			System.out.println("Sipariþ detaylarý güncellendi.");
			LoggerAspect.run("Sipariþ detaylarý güncellendi.", loggers);
		} else {
			System.out.println(result.getMessage());
			LoggerAspect.run(result.getMessage(), loggers);
		}
	}

}
