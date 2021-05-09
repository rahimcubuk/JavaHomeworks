package RnR.JavaCampProject.Business.Abstracts;

import java.util.List;

import RnR.JavaCampProject.Entities.Concretes.Personnel;

public interface IPersonnelService {

	List<Personnel> getAll();
}
