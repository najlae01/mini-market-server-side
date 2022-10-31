package org.fstt.dao;

import java.util.Optional;

import org.fstt.entities.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long>{
	public Optional<UserToken> findByToken(String token);
}
