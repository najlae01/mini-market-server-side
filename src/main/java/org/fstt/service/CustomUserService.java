package org.fstt.service;

import org.fstt.dao.UserDetailsRepository;
import org.fstt.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDetailsRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username+" not found");
		}
		return user;
	}

}
