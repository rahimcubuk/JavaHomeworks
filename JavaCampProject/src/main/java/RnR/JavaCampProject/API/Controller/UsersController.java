package RnR.JavaCampProject.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RnR.JavaCampProject.Business.Abstracts.IUserService;
import RnR.JavaCampProject.Entities.Concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private IUserService service;

	@Autowired
	public UsersController(IUserService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public List<User> getAll(){
		return service.getAll();
	}
}
