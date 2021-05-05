package Business.Abstract;

import java.rmi.RemoteException;

import Entities.Order;

public interface IOrderService {
	void add(Order order) throws NumberFormatException, RemoteException;

	void delete(Order order) throws NumberFormatException, RemoteException;

	void update(Order order) throws NumberFormatException, RemoteException;
}
