package Concrete;

import java.rmi.RemoteException;

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
		
		try {
			if (this.checkService.checkIfRealPerson(customer)) {
				super.save(customer);
			} else {
				System.out.println("Kullanýcý bilgileri hatalý.");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
