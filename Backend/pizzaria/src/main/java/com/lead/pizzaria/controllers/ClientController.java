package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Endereco;
import com.lead.pizzaria.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzaria-lead")
public class ClientController {

    @Autowired //trata injeção de dependências
    public ClientRepository clientRepository;

    //select de todos os clients
    @GetMapping("/client")
    public ResponseEntity<List<Client>> getClients() {
        try {
            List<Client> clients = clientRepository.findAll();
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //abstração do salvar no banco
    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client_recebido) {
        try{
            Client client = clientRepository.save(new Client (client_recebido.getCpf(),
                    client_recebido.getNome(), client_recebido.getEmail(), client_recebido.getTel()));
            return new ResponseEntity<>(client, HttpStatus.CREATED); //se tudo der certo vai retornar no navegador 201
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    //busca pelo id do client
    @GetMapping("/client/{id}")
    public Optional<Optional<Client>> buscar(@PathVariable Long id) {

        Optional<Client> cli = clientRepository.findById(id);
        return Optional.ofNullable(cli);

    }

}
