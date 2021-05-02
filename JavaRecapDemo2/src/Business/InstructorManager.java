package Business;

import Entities.Instructor;
import Entities.User;
import Logger.Logger;

public class InstructorManager extends UserManager {

	private Logger logger;
	public InstructorManager(Logger logger) {
		super(logger);
		this.logger = logger;
	}

	@Override
	public void add(User entity) {
		super.add(entity);
		System.out.println("Eðitmen Sisteme Eklendi.");
	}

	@Override
	public void delete(User entity) {
		super.delete(entity);
		System.out.println("Eðitmen Sistemden Silindi.");
	}

	@Override
	public void update(User entity) {
		super.update(entity);
		System.out.println("Eðitmen Verisi Güncellendi.");
	}

	@Override
	public void list(User... users) {
		super.list(users);
		System.out.println("Kullanýcý Listesi.");
	}
	
	public void addDepartment(Instructor entity, String department) {
		entity.setDepartment(department);
		System.out.println("Eðitmen için yeni alan: " + entity.getDepartment() + " olarak eklendi.");
		logger.log();
	}
}
