package org.fstt.metier;

import java.time.LocalDateTime;
import java.util.UUID;

import org.fstt.dao.AuthorityRepository;
import org.fstt.dao.UserDetailsRepository;
import org.fstt.dao.UserTokenRepository;
import org.fstt.entities.Authority;
import org.fstt.entities.User;
import org.fstt.entities.UserToken;
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
	private UserTokenRepository userTokenRepository;
	
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
	
	public String signUp(User user, boolean isFournisseur) {
		boolean userExists = userDetailsRepository.findByUsername(user.getUsername()).isPresent();
		if(userExists) {
			throw new IllegalStateException("Username already exists");
		}
		
		String encodedPassword = passwordEncoder().encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		Authority authorityFrns = authorityRepository.findById((long) 3).get();
		
		Authority authorityClient = authorityRepository.findById((long) 2).get();
		
		if(isFournisseur) {
			user.addAuthority(authorityFrns);
		}else {
			user.addAuthority(authorityClient);
		}
		userDetailsRepository.save(user);
		
		String token = UUID.randomUUID().toString();
		
		UserToken userToken = new UserToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(180),
				user
				);
		userTokenRepository.save(userToken);
		return token;
	}
	
	public String signIn(User user) {
		boolean userExists = userDetailsRepository.findByUsername(user.getUsername()).isPresent();
		if(!userExists) {
			throw new IllegalStateException("Username doesn't exist");
		}
String token = UUID.randomUUID().toString();
		
		UserToken userToken = new UserToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(180),
				user
				);
		userTokenRepository.save(userToken);
		return token;
	}

}
