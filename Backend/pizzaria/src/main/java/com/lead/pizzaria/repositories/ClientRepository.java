package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
