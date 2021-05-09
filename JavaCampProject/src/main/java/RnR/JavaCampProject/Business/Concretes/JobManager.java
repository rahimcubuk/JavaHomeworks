package RnR.JavaCampProject.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RnR.JavaCampProject.Business.Abstracts.IJobService;
import RnR.JavaCampProject.DataAccess.Abstracts.IJobDao;
import RnR.JavaCampProject.Entities.Concretes.Job;

@Service
public class JobManager implements IJobService {

	private IJobDao jobDao;

	@Autowired
	public JobManager(IJobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public List<Job> getAll() {
		// TODO Auto-generated method stub
		return jobDao.findAll();
	}

}
