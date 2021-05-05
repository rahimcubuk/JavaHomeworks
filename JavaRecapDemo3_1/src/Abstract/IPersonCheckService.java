package Abstract;

import java.rmi.RemoteException;

import Entities.Customer;

public interface IPersonCheckService {
	boolean checkIfRealPerson(Customer customer) throws RemoteException;
}
