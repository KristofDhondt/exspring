package be.abis.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.services.TrainingService;

@Controller
public class AppController {
	
	@Autowired
	TrainingService trainingService;
	
	Person loggedInUser;
	Person removedPerson;
	Person addedPerson;
			
	List<Person> listPersons;
	
	@GetMapping("/")
	public String login(Model model) {
		Login loginID = new Login();
		model.addAttribute("login", loginID);
		return "login";
	}
	
	@PostMapping("/")
	public String welcome (Model model, Login loginUser) {
		loggedInUser = trainingService.findPerson(loginUser.getEmail(),loginUser.getPassword());
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String welcomeScreen(Model model){
		model.addAttribute("person", loggedInUser);
		return "welcome";
	}
	
	@GetMapping("/personadmin")
	public String personAdminScreen(Model model){
		return "personadmin";
	}
	
	@GetMapping("/changepassword")
	public String changePasswordScreen(Model model){
		model.addAttribute("person",loggedInUser);
		return "changepassword";
	}
	
	@GetMapping("/searchperson")
	public String searchpersonsScreen(Model model){
		model.addAttribute("person", new Person());
		return "searchperson";
	}
	
	@GetMapping("/addperson")
	public String addPersonScreen(Model model){
		model.addAttribute("person", new Person());
		return "addperson";
	}
	
	@GetMapping("/removeperson")
	public String removePersonScreen(Model model){
		model.addAttribute("person", new Person());
		return "removeperson";
	}
	
	@GetMapping("/showpersons")
	public String showPersons(Model model){
		model.addAttribute("persons", listPersons);
		return "showpersons";
	}
	
	@GetMapping("/personList")
	public String personList(){
		listPersons = trainingService.getAllPersons();	
		return "redirect:/showpersons";
	}
	
	@GetMapping("/logout")
	public String logout(){
		return "redirect:/";
	}
		
	@PostMapping("/changePassword")
	public String postChangePassword(Model model, Person person) {
		try {
			trainingService.changePassword(loggedInUser, person.getPassword());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@PostMapping("/removePersonById")
	public String removePersonById(Person person){
		removedPerson=trainingService.findPerson(person.getPersonId());
		trainingService.deletePerson(person.getPersonId());	
		return "redirect:/personadmin";
	}
	
	@PostMapping("/addPerson")
	public String addPerson(Person person){	
		try {
			addedPerson = trainingService.findPerson(person.getPersonId());
			trainingService.addPerson(person);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return "redirect:/personadmin";
	}
		
	@PostMapping("/findPersonById")
	public String findPersonById(Person person){
		Person personById = trainingService.findPerson(person.getPersonId());	
		listPersons = new ArrayList<Person>();
		if (personById != null) {
			listPersons.add(personById);
		}	
		return "redirect:/showpersons";
	}
}
