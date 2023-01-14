package org.fstt.dao;

import java.util.List;
import java.util.Optional;

import org.fstt.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	public List<Commande> findAllByClientCodeClient(Long clientId);
}
