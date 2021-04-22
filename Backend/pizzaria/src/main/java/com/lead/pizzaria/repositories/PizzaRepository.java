package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository <Pizza, Integer> {
    Optional<Pizza> findById(Integer id);
}
