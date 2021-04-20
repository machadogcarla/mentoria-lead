package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Endereco;
import com.lead.pizzaria.entities.Pedido;
import com.lead.pizzaria.repositories.EnderecoRepository;
import com.lead.pizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaria-lead")
public class EnderecoController {
    @Autowired
    public EnderecoRepository endRepository;

    //select de todos os endereços
    @GetMapping("/end")
    public ResponseEntity<List<Endereco>> getEnderecos() {
        try {
            List<Endereco> enderecos = endRepository.findAll();
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/end")
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco_recebido) {
        try{
            Endereco endereco = endRepository.save(new Endereco (endereco_recebido.getCep(), endereco_recebido.getLogradouro(),
                    endereco_recebido.getNumero(), endereco_recebido.getComplemento(), endereco_recebido.getPonto_referencia(),
                    endereco_recebido.getBairro(), endereco_recebido.getCidade()));
            return new ResponseEntity<>(endereco, HttpStatus.CREATED); //se tudo der certo vai retornar no navegador 201
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}