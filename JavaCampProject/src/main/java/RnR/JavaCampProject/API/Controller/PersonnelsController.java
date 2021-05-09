package RnR.JavaCampProject.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RnR.JavaCampProject.Business.Abstracts.IPersonnelService;
import RnR.JavaCampProject.Entities.Concretes.Personnel;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelsController {

	private IPersonnelService service;
	
	@Autowired
	public PersonnelsController(IPersonnelService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public List<Personnel> getAll(){
		return service.getAll();
	}
}
