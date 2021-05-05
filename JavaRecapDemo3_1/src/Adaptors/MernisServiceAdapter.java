package Adaptors;

import java.rmi.RemoteException;

//Bu kod Safa Orhan tarafýndan github.com sitesinde paylaþýlmýþtýr.
//https://gist.github.com/safaorhan/89790733fef96a31e23be50e3054bb2c

import Abstract.IPersonCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements IPersonCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) throws RemoteException {
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		
		return proxy.TCKimlikNoDogrula(
				Long.parseLong(customer.getNationaltyId()), 
				customer.getFirstName().toUpperCase(), 
				customer.getLastName(), 
				customer.getDateOfBirth()
				);
	}

}
