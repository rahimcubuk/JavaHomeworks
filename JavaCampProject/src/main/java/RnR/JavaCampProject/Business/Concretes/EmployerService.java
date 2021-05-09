package RnR.JavaCampProject.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RnR.JavaCampProject.Business.Abstracts.IEmployerService;
import RnR.JavaCampProject.DataAccess.Abstracts.IEmployerDao;
import RnR.JavaCampProject.Entities.Concretes.Employer;

@Service
public class EmployerService implements IEmployerService {

	private IEmployerDao employerDao;

	@Autowired
	public EmployerService(IEmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public List<Employer> getAll() {
		// TODO Auto-generated method stub
		return employerDao.findAll();
	}

}
