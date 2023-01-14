package org.fstt.metier;

import java.security.Principal;
import java.time.LocalDateTime;

import java.util.UUID;

import org.fstt.dao.AuthorityRepository;
import org.fstt.dao.UserDetailsRepository;
import org.fstt.entities.Authority;
import org.fstt.entities.User;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.requests.ProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserMetier implements UserDetailsService{

	
	private final static String USER_NOT_FOUND_MSG = "User with username %s not found";
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDetailsRepository.findByUsername(username)
				.orElseThrow(()->
						new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)))
				;
	}
	
	public User getProfile(Long id) {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getPrincipal().toString();
		System.out.println(username);
		User user = userDetailsRepository.findByUsername(username).get();*/
		User user = userDetailsRepository.findById(id).get();
		return user;
		
	}
	
	public User updateProfile(User existUser, ProfileRequest request) {
		if(request.getUsername() != null) {
			existUser.setUsername(request.getUsername());
		}
		
		if(request.getPassword() != null) {
			String encodedPassword = passwordEncoder().encode(request.getPassword());
			existUser.setPassword(encodedPassword);	
		}
		
		
		return userDetailsRepository.save(existUser);
	}
	
	public User signUp(User user, String role) {
		
		String encodedPassword = passwordEncoder().encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		Authority authorityFrns = authorityRepository.findById((long) 2).get();
		
		Authority authorityClient = authorityRepository.findById((long) 1).get();
		
		
		if(role.equals("isFournisseur")) {
			user.addAuthority(authorityFrns);
			user.setFournisseur(true);
		}else {
			user.addAuthority(authorityClient);
			user.setFournisseur(false);
		}
		String token = UUID.randomUUID().toString();
		
		user.setToken(token);
		
		userDetailsRepository.save(user);
		
		return user;
	}
	
	public User signIn( AuthenticationRequest request) {
		User userExisting = userDetailsRepository.findByUsername(request.getUsername()).get();
		boolean isPasswordMatch = passwordEncoder().matches(request.getPassword(), userExisting.getPassword());
		if(!isPasswordMatch) {
			throw new IllegalStateException("Invalid Password");
		}
		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user=(User)authentication.getPrincipal();	
		String token = UUID.randomUUID().toString();
		
		user.setToken(token);
		
		userDetailsRepository.save(user);
		
		return user;
	}

}
