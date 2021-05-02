import Business.ITrainerService;
import Business.ICategoryService;
import Business.TrainerManager;
import Business.CategoryManager;
import Entities.Trainer;
import Entities.Category;

public class Main {

	public static void main(String[] args) {
		/********************************************************\
		 * 	Trainers
		\********************************************************/
		Trainer trainer1 = new Trainer(1,"XX1","C# Eðitmeni");
		Trainer trainer2 = new Trainer(2,"XX2","Java Eðitmeni");
		Trainer trainer3 = new Trainer(3,"XX3", "MsSQL Eðitmeni");
		trainer3.setDepartment("Veritabaný Eðitmeni");
				
		Trainer[] trainers = {trainer1, trainer2, trainer3};
		
		/********************************************************\
		 * 	Categories
		\********************************************************/
		Category category1 = new Category(1,"Programlama");
		Category category2 = new Category(2,"Tasarým");
		Category category3 = new Category(3,"Test Otomasyon");
		
		Category[] categories = {category1, category2, category3};
				
		/********************************************************\
		 * 	Methods
		\********************************************************/
		ITrainerService trainerManager 	= new TrainerManager();
		ICategoryService categoryManager 	= new CategoryManager();
		
		trainerManager.list(trainers);
		System.out.println();
		categoryManager.list(categories);
	}

}
