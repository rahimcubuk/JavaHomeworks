package Business;

import Entities.Student;
import Entities.User;
import Logger.Logger;

public class StudentManager extends UserManager {

	private Logger logger;
	public StudentManager(Logger logger) {
		super(logger);
		this.logger = logger;
	}

	@Override
	public void add(User entity) {
		super.add(entity);
		System.out.println("Öðrenci Sisteme Eklendi.");
	}

	@Override
	public void delete(User entity) {
		super.delete(entity);
		System.out.println("Öðrenci Sistemden Kaldýrýldý.");
	}

	@Override
	public void update(User entity) {
		super.update(entity);
		System.out.println("Öðrenci Güncellendi.");
	}

	@Override
	public void list(User... users) {
		super.list(users);
		System.out.println("Öðrenci Listesi.");
	}

	public void addAddress(Student entity, String address) {
		entity.setAddress(address);
		System.out.println("Öðrenci için yeni adres: " + entity.getAddress() + " olarak eklendi.");
		logger.log();
	}

}
