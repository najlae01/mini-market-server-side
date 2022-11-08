package org.fstt.metier;

import java.security.Principal;

import org.fstt.dao.UserDetailsRepository;
import org.fstt.entities.Article;
import org.fstt.entities.Client;
import org.fstt.entities.User;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.requests.ProfileRequest;
import org.fstt.requests.RegistrationRequest;
import org.fstt.responses.UserInfo;
import org.fstt.system.exception.UserAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMetierImpl implements UserMetier{

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	@Autowired
	private AppUserMetier appUserMetier;
	
	
	@Override
	public User register(RegistrationRequest request) throws UserAlreadyExistException{
		if(!checkIfUserExist(request.getUsername())) {
			throw new UserAlreadyExistException("Username already exists.");
		}
		return appUserMetier.signUp(
					new User(
							request.getUsername(),
							request.getPassword()
							),
					request.getRole()
					
				);
	}


	@Override
	public User login(AuthenticationRequest request){
		boolean userExists = userDetailsRepository.findByUsername(request.getUsername()).isPresent();
		if(!userExists) {
			throw new IllegalStateException("Username doesn't exist");
		}
			

		return appUserMetier.signIn(request);
	}

	@Override
	public User getUserProfile(Long id) {
		
		return appUserMetier.getProfile(id);
		
	}
	
	@Override
    public boolean checkIfUserExist(String email) {
        return userDetailsRepository.findByUsername(email) !=null ? true : false;
    }


	@Override
	public User updateUserProfile(ProfileRequest request) {
		User existUser = userDetailsRepository.findById(request.getId()).get();
		
		return appUserMetier.updateProfile(existUser, request);
	}


}
