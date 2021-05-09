package RnR.JavaCampProject.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RnR.JavaCampProject.Business.Abstracts.IJobseekerService;
import RnR.JavaCampProject.Entities.Concretes.Jobseeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobseekersControllers {

	private IJobseekerService service;
	
	@Autowired
	public JobseekersControllers(IJobseekerService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public List<Jobseeker> getAll(){
		return service.getAll();
	}
}
