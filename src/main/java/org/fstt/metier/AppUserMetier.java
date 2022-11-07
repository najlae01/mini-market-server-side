package org.fstt.metier;

import java.time.LocalDateTime;

import java.util.UUID;

import org.fstt.dao.AuthorityRepository;
import org.fstt.dao.UserDetailsRepository;
import org.fstt.entities.Authority;
import org.fstt.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	
	public User signUp(User user, String role) {
		
		String encodedPassword = passwordEncoder().encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		Authority authorityFrns = authorityRepository.findById((long) 3).get();
		
		Authority authorityClient = authorityRepository.findById((long) 2).get();
		
		Authority authoritySociete = authorityRepository.findById((long) 1).get();
		
		if(role.equalsIgnoreCase("fournisseur")) {
			user.addAuthority(authorityFrns);
		}else if(role.equalsIgnoreCase("societe")) {
			user.addAuthority(authoritySociete);
		}else {
			user.addAuthority(authorityClient);
		}
		String token = UUID.randomUUID().toString();
		
		user.setToken(token);
		
		userDetailsRepository.save(user);
		
		return user;
	}
	
	public User signIn(User user) {
		String token = UUID.randomUUID().toString();
		
		user.setToken(token);
		
		userDetailsRepository.save(user);
		
		return user;
	}

}
