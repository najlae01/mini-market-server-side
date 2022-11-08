package org.fstt.service;


import org.fstt.system.exception.UserAlreadyExistException;

import org.fstt.entities.User;
import org.fstt.metier.UserMetier;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.requests.ProfileRequest;
import org.fstt.requests.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AuthenticationRestService  {

	@Autowired
	private UserMetier userMetier;
	
	@RequestMapping(value = "/auth/register", method = RequestMethod.POST)
	public User register(@RequestBody RegistrationRequest request) throws UserAlreadyExistException{
		return userMetier.register(request);
	}
	
	@GetMapping("/auth/profile/{id}")
	public User getUserProfile(@PathVariable Long id){
		return userMetier.getUserProfile(id);
	}
	
	@RequestMapping(value = "/auth/profile", method = RequestMethod.PUT)
	public User updateUserProfile(@RequestBody ProfileRequest request){
		return userMetier.updateUserProfile(request);
	}
	
	@PostMapping("/auth/login")
	public User login(@RequestBody AuthenticationRequest authenticationRequest){
	    return userMetier.login(authenticationRequest);
	}
	
}
