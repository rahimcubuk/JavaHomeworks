package Adaptors;

import java.rmi.RemoteException;

import Entities.User;

public interface IPersonCheckService {
	boolean checkIfRealPerson(User user) throws NumberFormatException, RemoteException;
}
