package Adaptors;

//Bu kod Safa Orhan taraf�ndan github.com sitesinde payla��lm��t�r.
//https://gist.github.com/safaorhan/89790733fef96a31e23be50e3054bb2c

import Entities.User;

public class MernisCheckManager implements IPersonCheckService {
	
	@Override
	public boolean checkIfRealPerson(User user) {
		String nationalId = user.getNationalId();
		if (nationalId == null) return false;

	      if (nationalId.length() != 11) return false;

	      char[] chars = nationalId.toCharArray();
	      int[] a = new int[11];
	  
	      for(int i=0; i<11; i++) {
	          a[i] = chars[i] - '0';
	      }

	      if(a[0] == 0) return false;
	      if(a[10] % 2 == 1) return false;

	      if(((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 - (a[1] + a[3] + a[5] + a[7])) % 10 != a[9]) return false;

	      if((a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]) % 10 != a[10]) return false;

	      return true;
	}
}