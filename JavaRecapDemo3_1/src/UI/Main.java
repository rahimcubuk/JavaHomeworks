package UI;

import java.rmi.RemoteException;

import Abstract.BaseCustomerManager;
import Adaptors.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.PersonCheckManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());

		Customer customer1 = new Customer(1, "Rahim", "Çubuk", 1994, "21260425136");
		Customer customer2 = new Customer(1, "Elif", "Dilsizoðlu", 1995, "12345678999");
		
		try {
			starbucksCustomerManager.save(customer1);
			starbucksCustomerManager.save(customer2);
			neroCustomerManager.save(customer2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
