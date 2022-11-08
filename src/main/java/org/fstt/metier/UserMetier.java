package org.fstt.metier;

import java.security.Principal;

import org.fstt.entities.User;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.requests.ProfileRequest;
import org.fstt.requests.RegistrationRequest;
import org.fstt.system.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserMetier {
	public User register(RegistrationRequest request) throws UserAlreadyExistException;
	
	public boolean checkIfUserExist(String username);
	
	public User login(@RequestBody AuthenticationRequest request);
	
	public User getUserProfile(Long id);
	
	public User updateUserProfile(ProfileRequest request);
}
