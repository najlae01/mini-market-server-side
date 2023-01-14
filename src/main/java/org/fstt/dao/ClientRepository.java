package org.fstt.dao;

import java.util.Optional;

import org.fstt.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {
	public Optional<Client> findByUserIdId(Long userId);

}
