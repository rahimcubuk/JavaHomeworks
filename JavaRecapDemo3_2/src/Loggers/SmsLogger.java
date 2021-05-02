package Loggers;

public class SmsLogger implements ILogger {

	@Override
	public void log(String message) {
		System.out.println("Logged in Sms. Message: " + message);
	}

}
