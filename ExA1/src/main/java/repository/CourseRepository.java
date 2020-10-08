package repository;

import java.util.List;

import model.Course;

public interface CourseRepository {

	public List<Course> findAllCourses();
	public Course findCourse(int id);
	public Course findCourse(String shortTitle);
		
}
