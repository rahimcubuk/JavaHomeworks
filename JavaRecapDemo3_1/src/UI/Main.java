package UI;

import Abstract.BaseCustomerManager;
import Concrete.NeroCustomerManager;
import Concrete.PersonCheckManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new PersonCheckManager());

		Customer customer1 = new Customer(1, "Rahim", "1994", "21260425136");
		Customer customer2 = new Customer(1, "Elif", "1995", "32771095060");
		
		starbucksCustomerManager.save(customer1);
		starbucksCustomerManager.save(customer2);
		
		neroCustomerManager.save(customer2);
	}

}
