package be.abis.exercise.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Login {
	
	@NotBlank(message="Email Address is required")
	@Email(message="Email Address has an invalid format")
	private String email;
	@NotBlank(message="Password is required")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}