package be.abis.exercise.it;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.model.Person;
import be.abis.exercise.services.CourseService;
import be.abis.exercise.services.TrainingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbisTrainingServiceTest {

	@Autowired
	TrainingService trainingService;
	
	@Test
	public void person1isJohn() {
		Person p1 = trainingService.findPerson(1);
		assertEquals("John",p1.getFirstName());
	}
}
