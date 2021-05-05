package Business.Abstract;

import java.rmi.RemoteException;

import Entities.User;

public interface IUserService {
	void add(User user) throws NumberFormatException, RemoteException;

	void update(User user) throws NumberFormatException, RemoteException;

	void delete(User user) throws NumberFormatException, RemoteException;
}
