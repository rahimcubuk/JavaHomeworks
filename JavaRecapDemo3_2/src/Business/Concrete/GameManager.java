package Business.Concrete;

import Business.Abstract.IGameService;
import Entities.Game;
import Loggers.ILogger;
import Utils.LoggerAspect;

public class GameManager implements IGameService {

	private ILogger[] loggers;

	public GameManager(ILogger... loggers) {
		this.loggers = loggers;
	}

	@Override
	public void add(Game game) {
		System.out.println(game.getName() + " isimli oyun sisteme kaydedildi.");
		LoggerAspect.run(game.getName() + " isimli oyun sisteme kaydedildi.", loggers);
	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName() + " isimli oyun bilgileri güncellendi.");
		LoggerAspect.run(game.getName() + " isimli oyun bilgileri güncellendi.", loggers);
	}

	@Override
	public void delete(Game game) {
		game.setStatus(false);
		System.out.println(game.getName() + " isimli oyun sistemden kaldýrýldý.");
		LoggerAspect.run(game.getName() + " isimli oyun sistemden kaldýrýldý.", loggers);
	}
}
