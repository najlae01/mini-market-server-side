package org.fstt.metier;

import java.security.Principal;

import org.fstt.entities.UserData;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.requests.RegistrationRequest;
import org.fstt.responses.RegisterResponse;
import org.fstt.system.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserMetier {
	public String register(RegistrationRequest request) throws UserAlreadyExistException;
	
	public boolean checkIfUserExist(String username);
	
	public String login(@RequestBody AuthenticationRequest request);
	
	public ResponseEntity<?> getUserInfo(Principal user);
}
