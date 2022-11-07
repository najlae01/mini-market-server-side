package org.fstt.dao;

import java.util.Optional;

import org.fstt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByToken(String token);
}
