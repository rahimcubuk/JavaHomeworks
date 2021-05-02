package Business;

import Entities.Trainer;

public class TrainerManager implements ITrainerService{

	@Override
	public void add(Trainer entity) {
		System.out.println(entity.getName() + " adlý eðitmen listeye eklenmiþtir.");		
	}

	@Override
	public void update(Trainer entity) {
		System.out.println(entity.getName() + " adlý eðitmen verileri güncellenmiþtir.");	
	}

	@Override
	public void delete(Trainer entity) {
		System.out.println(entity.getName() + " adlý eðitmen verileri silinmiþtir.");	
	}

	@Override
	public void getDetail(Trainer entity) {
		System.out.println("Eðitmenin Id'si: " + entity.getId());
		System.out.println("Eðitmenin Adý: " + entity.getName());
		System.out.println("Eðitmenin Bölümü: " + entity.getDepartment());
		System.out.println("Eðitmenin Kodu: " + entity.getCampId());
	}

	@Override
	public void list(Trainer[] entities) {
		System.out.println("Eðitmen Listesi: ");
		for(Trainer trainer : entities) {
			System.out.println(trainer.getName());
		}	
	}

}
