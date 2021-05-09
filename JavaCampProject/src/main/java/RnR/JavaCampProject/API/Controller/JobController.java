package RnR.JavaCampProject.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RnR.JavaCampProject.Business.Abstracts.IJobService;
import RnR.JavaCampProject.Entities.Concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	private IJobService service;
	
	@Autowired
	public JobController(IJobService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public List<Job> getAll(){
		return service.getAll();
	}
}
