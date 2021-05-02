package Business;

import Entities.Trainer;

public class TrainerManager implements ITrainerService{

	@Override
	public void add(Trainer entity) {
		System.out.println(entity.getName() + " adl� e�itmen listeye eklenmi�tir.");		
	}

	@Override
	public void update(Trainer entity) {
		System.out.println(entity.getName() + " adl� e�itmen verileri g�ncellenmi�tir.");	
	}

	@Override
	public void delete(Trainer entity) {
		System.out.println(entity.getName() + " adl� e�itmen verileri silinmi�tir.");	
	}

	@Override
	public void getDetail(Trainer entity) {
		System.out.println("E�itmenin Id'si: " + entity.getId());
		System.out.println("E�itmenin Ad�: " + entity.getName());
		System.out.println("E�itmenin B�l�m�: " + entity.getDepartment());
		System.out.println("E�itmenin Kodu: " + entity.getCampId());
	}

	@Override
	public void list(Trainer[] entities) {
		System.out.println("E�itmen Listesi: ");
		for(Trainer trainer : entities) {
			System.out.println(trainer.getName());
		}	
	}

}
