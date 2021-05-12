package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Client;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //Optional<Client> findById(Long id);

    @Query("SELECT c FROM Client WHERE lower(c.nome) = :nome")
    Client findByNome(
            @Param("nome") String nome);
}
