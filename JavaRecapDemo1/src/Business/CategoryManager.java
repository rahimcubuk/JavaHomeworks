package Business;

import Entities.Category;

public class CategoryManager implements ICategoryService {
	
	@Override
	public void add(Category entity) {
		System.out.println(entity.getName() + " adl� kategori listeye eklenmi�tir.");
	}

	@Override
	public void update(Category entity) {
		System.out.println(entity.getName() + " adl� kategori verileri g�ncellenmi�tir.");
	}

	@Override
	public void delete(Category entity) {
		System.out.println(entity.getName() + " adl� kategori verileri silinmi�tir.");
	}

	@Override
	public void getDetail(Category entity) {
		System.out.println("Kategori Id: " + entity.getId());
		System.out.println("Kategori Ad�: " + entity.getName());
	}

	@Override
	public void list(Category[] entities) {
		System.out.println("Kategory Listesi: ");
		for (Category category : entities) {
			System.out.println(category.getName());
		}
	}
}
