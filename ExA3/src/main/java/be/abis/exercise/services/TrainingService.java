package be.abis.exercise.services;

import java.io.IOException;
import be.abis.exercise.exception.EnrollException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import be.abis.exercise.model.Person;
import be.abis.exercise.model.Course;

public interface TrainingService {
	
    ArrayList<Person> getAllPersons();
    Person findPerson(int id);
    Person findPerson(String emailAddress, String passWord);
    void addPerson(Person p) throws IOException;
    public void deletePerson(int id);
    void changePassword(Person p, String newPswd) throws IOException;
    
    public List<Course> showFollowedCourses(Person person);
	public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException;
	

}
