package org.fstt.metier;

import java.util.List;

import org.fstt.dao.UserTokenRepository;
import org.fstt.entities.UserToken;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTokenMetierImpl implements UserTokenMetier{

	@Autowired
	private UserTokenRepository userTokenRepository;
	
	@Override
	public void saveUserToken(UserToken userToken) {
		userTokenRepository.save(userToken);
	}

	@Override
	public UserToken updateUserToken(UserToken userToken, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserToken getUserToken(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserToken(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserToken> listUserToken() {
		// TODO Auto-generated method stub
		return null;
	}

}
