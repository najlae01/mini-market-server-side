package org.fstt.metier;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.fstt.entities.UserData;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.system.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserMetier {
	public void register(UserData user) throws UserAlreadyExistException;
	
	public boolean checkIfUserExist(String username);
	
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException;
	
	public ResponseEntity<?> getUserInfo(Principal user);
}
