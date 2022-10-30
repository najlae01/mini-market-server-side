package org.fstt.service;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import javax.validation.Valid;

import org.fstt.system.exception.UserAlreadyExistException;
import org.fstt.entities.UserData;
import org.fstt.metier.UserMetier;
import org.fstt.requests.AuthenticationRequest;
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

	@GetMapping("/register")
    public void register(final Model model){
        model.addAttribute("userData", new UserData());
    }
	
	@RequestMapping(value = "/auth/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
		if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
        try {
        	userMetier.register(userData);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
		return (ResponseEntity<?>) ResponseEntity.ok(userData);
	}
	
	@GetMapping("/auth/userinfo")
	public ResponseEntity<?> getUserInfo(Principal user){
		return userMetier.getUserInfo(user);
	}
	
	@PostMapping("/auth/login")
	public void login(@RequestBody AuthenticationRequest authenticationRequest){
	    try {
			userMetier.login(authenticationRequest);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
}
