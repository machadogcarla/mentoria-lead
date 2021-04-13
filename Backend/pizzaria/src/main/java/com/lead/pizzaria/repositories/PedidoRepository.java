package com.lead.pizzaria.repositories;

import com.lead.pizzaria.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
