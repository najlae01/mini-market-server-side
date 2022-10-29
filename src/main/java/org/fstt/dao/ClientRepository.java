package org.fstt.dao;

import org.fstt.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>  {

}
