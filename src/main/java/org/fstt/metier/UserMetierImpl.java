package org.fstt.metier;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.fstt.config.JWTTokenHelper;
import org.fstt.dao.UserDetailsRepository;
import org.fstt.entities.User;
import org.fstt.entities.UserData;
import org.fstt.requests.AuthenticationRequest;
import org.fstt.responses.LoginResponse;
import org.fstt.responses.RegisterResponse;
import org.fstt.responses.UserInfo;
import org.fstt.system.exception.UserAlreadyExistException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	private AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenHelper jWTTokenHelper;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void register(UserData user) throws UserAlreadyExistException {
		if(checkIfUserExist(user.getEmail())) {
			throw new UserAlreadyExistException("Username already exists.");
		}
		User userEntity = new User();
		BeanUtils.copyProperties(user, userEntity);
		encodePassword(userEntity, user);
		userDetailsRepository.save(userEntity);
	}


	@Override
	public ResponseEntity<?> login(AuthenticationRequest authenticationRequest)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user=(User)authentication.getPrincipal();
		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response=new LoginResponse();
		response.setToken(jwtToken);
		

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<?> getUserInfo(Principal user) {
		User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
		
		UserInfo userInfo=new UserInfo();
		userInfo.setRoles(userObj.getAuthorities().toArray());
		
		
		return ResponseEntity.ok(userInfo);	
		
	}
	
	@Override
    public boolean checkIfUserExist(String email) {
        return userDetailsRepository.findByUsername(email) !=null ? true : false;
    }

    private void encodePassword( User userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
