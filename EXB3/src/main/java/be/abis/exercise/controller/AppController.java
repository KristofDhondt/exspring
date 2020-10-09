package be.abis.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	@PostMapping("/personadmin")
	public String personadmin (Model model, Login loginUser) {
		return "redirect:/changepassword";
	} 
	@GetMapping("/personadmin")
	public String personadminscreen(Model model){
		return "personadmin";
	}
	
	
	@GetMapping("/logout")
	public String logout(){
		return "redirect:/";
	}
	
	@GetMapping("/back")
	public String back(){
		return "redirect:/";
	}
	
}
