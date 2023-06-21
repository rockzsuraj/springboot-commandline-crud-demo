package com.learn.cruddemo;

import com.learn.cruddemo.dao.StudentDAO;
import com.learn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			
//			readStudent(studentDAO);
			
//			queryForStudent(studentDAO);

//			queryStudentByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
			
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change first name to "geeky"
		myStudent.setFirstName("Suraj");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
		System.out.println(studentDAO.findById(studentId));
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {
		//get a list of student
		List<Student> theStudents = studentDAO.findByLastName("kumar");

		//display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of student
		List<Student> theStudents = studentDAO.findAll();
		
		//display list of students

		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Swati", "Kumari", "swati123@gmail.com");

		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//create 3 student object
		System.out.println("Creating 3 new student object ...");
		Student tempStudent1 = new Student("Suraj", "Kumar", "geekysuraj@gmail.com");
		Student tempStudent2 = new Student("Amit", "Kumar", "amit123@gmail.com");
		Student tempStudent3 = new Student("Shubham", "Kumar", "shubham123j@gmail.com");


		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Shubham", "Kumar", "Shubham@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student Generated id: " + tempStudent.getId());
	}

}
