package RnR.JavaCampProject.Business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RnR.JavaCampProject.Business.Abstracts.IJobseekerService;
import RnR.JavaCampProject.DataAccess.Abstracts.IJobseekerDao;
import RnR.JavaCampProject.Entities.Concretes.Jobseeker;

@Service
public class JobseekerManager implements IJobseekerService {

	private IJobseekerDao jobseekerDao;

	@Autowired
	public JobseekerManager(IJobseekerDao jobseekerDao) {
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public List<Jobseeker> getAll() {
		// TODO Auto-generated method stub
		return jobseekerDao.findAll();
	}

}
