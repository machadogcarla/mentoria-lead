package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository <Endereco, String> {
    Optional<Endereco> findByCep(String cep);

}
