package Utils;

import Loggers.ILogger;

public class LoggerAspect {
	public static void run(String message, ILogger... loggers) {
		for (ILogger logger : loggers) {
			logger.log(message);
		}
	}
}
