package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Pedido;
import com.lead.pizzaria.entities.Pizza;
import com.lead.pizzaria.repositories.ClientRepository;
import com.lead.pizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzaria-lead")
public class PedidoController {

    @Autowired
    public PedidoRepository pedidoRepository;

    //select de todos os pedidos
    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> getPedidos() {
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido_recebido) {
        try{
            Pedido pedido = pedidoRepository.save(new Pedido (pedido_recebido.getValor_total(), pedido_recebido.getTempo_preparo(),
                    pedido_recebido.isExtrabacon(), pedido_recebido.isSem_cebola(), pedido_recebido.isBorda_recheada()));
            return new ResponseEntity<>(pedido, HttpStatus.CREATED); //se tudo der certo vai retornar no navegador 201
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //Deletar pedido.
    @DeleteMapping("/pedido/{num_pedido}")
    public ResponseEntity<HttpStatus> deletePedido(@PathVariable("num_pedido") long num_pedido) {
        try{
            pedidoRepository.deleteById(num_pedido);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Edição
    @PutMapping("/pedido/{num_pedido}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable("num_pedido") long num_pedido, @RequestBody Pedido pedido){
        Optional<Pedido> pedidoData = pedidoRepository.findById(num_pedido);

        if(pedidoData.isPresent()){
            Pedido ped_temp = pedidoData.get();
            ped_temp.setValor_total(pedido.getValor_total());
            ped_temp.setTempo_preparo(pedido.getTempo_preparo());
            ped_temp.setExtrabacon(pedido.isExtrabacon());
            ped_temp.setSem_cebola(pedido.isSem_cebola());
            ped_temp.setBorda_recheada(pedido.isBorda_recheada());
            return new ResponseEntity<>(pedidoRepository.save(ped_temp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
