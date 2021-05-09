package RnR.JavaCampProject.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RnR.JavaCampProject.Business.Abstracts.IUserService;
import RnR.JavaCampProject.DataAccess.Abstracts.IUserDao;
import RnR.JavaCampProject.Entities.Concretes.User;

@Service
public class UserManager implements IUserService {

	private IUserDao userDao;

	@Autowired
	public UserManager(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

}
