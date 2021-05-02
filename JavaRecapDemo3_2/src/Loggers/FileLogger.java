package Loggers;

public class FileLogger implements ILogger {

	@Override
	public void log(String message) {
		System.out.println("Logged in File. Message: " + message);
	}

}
