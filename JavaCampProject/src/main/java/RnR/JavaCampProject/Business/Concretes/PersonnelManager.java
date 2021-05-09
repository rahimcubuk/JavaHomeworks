package RnR.JavaCampProject.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RnR.JavaCampProject.Business.Abstracts.IPersonnelService;
import RnR.JavaCampProject.DataAccess.Abstracts.IPersonnelDao;
import RnR.JavaCampProject.Entities.Concretes.Personnel;

@Service
public class PersonnelManager implements IPersonnelService {

	private IPersonnelDao personnelDao;

	@Autowired
	public PersonnelManager(IPersonnelDao personnelDao) {
		this.personnelDao = personnelDao;
	}

	@Override
	public List<Personnel> getAll() {
		// TODO Auto-generated method stub
		return personnelDao.findAll();
	}

}
