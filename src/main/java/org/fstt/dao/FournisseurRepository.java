package org.fstt.dao;

import java.util.Optional;


import org.fstt.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
	public Optional<Fournisseur> findByUserIdId(Long userId);
}
