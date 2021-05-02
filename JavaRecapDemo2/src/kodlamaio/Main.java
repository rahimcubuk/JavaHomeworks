package kodlamaio;

import Business.StudentManager;
import Business.InstructorManager;
import Entities.Instructor;
import Entities.Student;
import Logger.DatabaseLogger;
import Logger.FileLogger;

public class Main {

	public static void main(String[] args) {
		StudentManager studentManager = new StudentManager(new FileLogger());
		InstructorManager instructorManager = new InstructorManager(new DatabaseLogger());

		Student student1 = new Student(1, "Rahim1", "bir", "bir@gmail.com", "12346", "Manisa", "photoPath", "Student", true);
		Student student2 = new Student(2, "Rahim2", "iki", "iki@gmail.com", "12346", "Kocaeli", "photoPath", "Student", true);
		Student student3 = new Student(3, "Rahim3", "üç", "üç@gmail.com", "12346", "Ýzmir", "photoPath", "Student", true);
		Student student4 = new Student(4, "Rahim4", "dört", "dört@gmail.com", "12346", "Ankara", "photoPath", "Student", true);

		Instructor instructor1 = new Instructor(2, "Engin", "Demiroð", "engin@gmail.com", "123456", "Programing", "Instructor", true);
		Instructor instructor2 = new Instructor(2, "Salih", "Demiroð", "engin@gmail.com", "123456", "Programing", "Instructor", true);
		
		addStudent(studentManager, student1);
		
		addInstructor(instructorManager, instructor1);

		addAddress(studentManager, student4);

		studentManager.list(student1,student2,student3,student4);
		System.out.println();
		instructorManager.list(instructor1,instructor2);
	}

	private static void addAddress(StudentManager studentManager, Student student4) {
		System.out.println("Öðrencinin Adresini Güncelleme Metodu");
		studentManager.addAddress(student4, "Akhisar");
		System.out.println(student4.getName() + " adlý öðrencinin adresi: " + student4.getAddress());
		System.out.println();
	}

	private static void addInstructor(InstructorManager instructorManager, Instructor instructor1) {
		System.out.println("Eðitmen Ekleme Metodu: ");
		instructorManager.add(instructor1);
		System.out.println();
	}

	private static void addStudent(StudentManager studentManager, Student student1) {
		System.out.println("Öðrenci Ekleme Metodu: ");
		studentManager.add(student1);
		System.out.println();
	}

}
