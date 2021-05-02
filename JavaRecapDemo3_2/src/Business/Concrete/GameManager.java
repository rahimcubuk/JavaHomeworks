package Business.Concrete;

import Business.Abstract.IGameService;
import Entities.Game;
import Loggers.ILogger;

public class GameManager implements IGameService {

	private ILogger[] loggers;

	public GameManager(ILogger... loggers) {
		this.loggers = loggers;
	}

	@Override
	public void add(Game game) {
		System.out.println(game.getName() + " isimli oyun sisteme kaydedildi.");
		for (ILogger logger : loggers) {
			logger.log(game.getName() + " isimli oyun sisteme kaydedildi.");
		}
	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName() + " isimli oyun bilgileri güncellendi.");
		for (ILogger logger : loggers) {
			logger.log(game.getName() + " isimli oyun bilgileri güncellendi.");
		}
	}

	@Override
	public void delete(Game game) {
		game.setStatus(false);
		System.out.println(game.getName() + " isimli oyun sistemden kaldýrýldý.");
		for (ILogger logger : loggers) {
			logger.log(game.getName() + " isimli oyun sistemden kaldýrýldý.");
		}
	}
}
