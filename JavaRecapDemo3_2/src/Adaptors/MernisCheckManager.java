package Adaptors;

import java.rmi.RemoteException;

import Entities.User;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisCheckManager implements IPersonCheckService {

	@Override
	public boolean checkIfRealPerson(User user) throws NumberFormatException, RemoteException {
		KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();

		return proxy.TCKimlikNoDogrula(Long.parseLong(user.getNationalId()), user.getFirstName().toUpperCase(),
				user.getLastName(), Integer.parseInt(user.getYearOfBirth()));
	}
}
