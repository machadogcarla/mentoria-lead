package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository <Pizza, Integer> {
   /*public List<Pizza> findByPizzaId(Integer id_pizza);*/
}
