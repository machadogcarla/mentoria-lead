package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository <Pizza, Integer> {
}
