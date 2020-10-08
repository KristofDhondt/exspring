package be.abis.exercise.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.services.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAbisCourseService {
	
	@Autowired
	CourseService courseService;
	
	@Test
	public void findCourseWithId7900() {
		Course course = courseService.findCourse(7900);
		assertEquals("WORKSHOP SQL",course.getShortTitle().toUpperCase());
	}
	
	@Test
	public void checkIfPriceCourse7900Higher400() {
		Course course = courseService.findCourse(7900);
		assertThat(course.getPricePerDay(),greaterThan(400.0));
	}
}
