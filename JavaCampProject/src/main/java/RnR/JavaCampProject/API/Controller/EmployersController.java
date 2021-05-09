package RnR.JavaCampProject.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RnR.JavaCampProject.Business.Abstracts.IEmployerService;
import RnR.JavaCampProject.Entities.Concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private IEmployerService service;
	
	@Autowired
	public EmployersController(IEmployerService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public List<Employer> getAll(){
		return service.getAll();
	}
}
