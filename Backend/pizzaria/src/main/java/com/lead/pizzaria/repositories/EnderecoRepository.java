package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, String> {

}
