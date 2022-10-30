package org.fstt.dao;

import org.fstt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
}
