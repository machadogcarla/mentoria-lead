package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Pedido;
import com.lead.pizzaria.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
