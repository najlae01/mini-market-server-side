package org.fstt.metier;

import java.util.List;

import org.fstt.entities.UserToken;

public interface UserTokenMetier {
	public void saveUserToken(UserToken userToken);
	
	public UserToken updateUserToken(UserToken userToken, Long id);
	
	public UserToken getUserToken(Long id);
	
	public void deleteUserToken(Long id);
	
	public List<UserToken> listUserToken();
}
