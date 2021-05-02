package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.IPersonCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

	private IPersonCheckService checkService;

	public StarbucksCustomerManager(IPersonCheckService checkService) {
		this.checkService = checkService;
	}

	@Override
	public void save(Customer customer) {
		
		if (this.checkService.checkIfRealPerson(customer)) {
			super.save(customer);
		} else {
			System.out.println("Kullanýcý bilgileri hatalý.");
		}
		
	}
}
