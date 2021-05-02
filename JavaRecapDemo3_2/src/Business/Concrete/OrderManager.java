package Business.Concrete;

import Adaptors.IPersonCheckService;
import Business.Abstract.IOrderService;
import Entities.Game;
import Entities.Order;
import Entities.User;
import Loggers.ILogger;
import Utils.BusinessRules;
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
	 * */
	private Result CheckIfRealPerson(User user){
		if(!checkService.checkIfRealPerson(user)) {
			return new Result("Oyuncu bilgileri hatal�d�r.", false);
		}
		return new Result("Sat�labilir.",true);
	}
	
	private Result CheckGameStatus(Game game){
		if(!game.isStatus()) {
			return new Result("Oyun sat��a kapal�d�r.", false);
		}
		return new Result("Sat�labilir.",true);
	}
	
	@Override
	public void add(Order order) {
		User user = order.getUser();
		Game game = order.getGame();
		
		Result result = BusinessRules.Run(CheckIfRealPerson(user), CheckGameStatus(game));
		
		if (result == null) {
			System.out.println(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu " + game.getName() + " oyununu sat�n ald�.");
			for (ILogger logger : loggers) {
				logger.log(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu " + game.getName() + " oyununu sat�n ald�.");
			}
		} else {
			System.out.println(result.getMessage());
			for (ILogger logger : loggers) {
				logger.log(result.getMessage());
			}
		}
	}

	@Override
	public void delete(Order order) {
		User user = order.getUser();
		Game game = order.getGame();

		Result result = BusinessRules.Run(CheckIfRealPerson(user), CheckGameStatus(game));
		
		if (result == null)  {
			System.out.println(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu " + game.getName() + " oyununu iade etti.");
			for (ILogger logger : loggers) {
				logger.log(user.getFirtName() + " " + user.getLastName() + " isimli oyuncu " + game.getName() + " oyununu iade etti.");
			}
		} else {
			System.out.println(result.getMessage());
			for (ILogger logger : loggers) {
				logger.log(result.getMessage());
			}
		}
	}

	@Override
	public void update(Order order) {
		User user = order.getUser();
		Result result = BusinessRules.Run(CheckIfRealPerson(user));
		
		if (result == null) {
			System.out.println("Sipari� detaylar� g�ncellendi.");
			for (ILogger logger : loggers) {
				logger.log("Sipari� detaylar� g�ncellendi.");
			}
		} else {
			System.out.println(result.getMessage());
			for (ILogger logger : loggers) {
				logger.log(result.getMessage());
			}
		}
	}

}
