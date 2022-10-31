package org.fstt.service;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import javax.validation.Valid;

import org.fstt.system.exception.UserAlreadyExistException;
import org.fstt.entities.UserData;
import org.fstt.metier.UserMetier;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.requests.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class AuthenticationRestService  {

	@Autowired
	private UserMetier userMetier;
	
	@RequestMapping(value = "/auth/register", method = RequestMethod.POST)
	public String register(@RequestBody RegistrationRequest request) throws UserAlreadyExistException{
		return userMetier.register(request);
	}
	
	@GetMapping("/auth/userinfo")
	public ResponseEntity<?> getUserInfo(Principal user){
		return userMetier.getUserInfo(user);
	}
	
	@PostMapping("/auth/login")
	public String login(@RequestBody AuthenticationRequest authenticationRequest){
	    return userMetier.login(authenticationRequest);
	}
	
}
