package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Endereco;
import com.lead.pizzaria.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")

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
            Client client = clientRepository.save(new Client (
                    client_recebido.getNome(), client_recebido.getEmail(), client_recebido.getTel()));
            return new ResponseEntity<>(client, HttpStatus.CREATED); //se tudo der certo vai retornar no navegador 201
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
/*    //busca pelo id do client
    @GetMapping("/client/{id}")
    public Optional<Optional<Client>> buscar(@PathVariable Long id) {
        try{
            Optional<Client> cli = clientRepository.findById(id);
            return Optional.ofNullable(cli);
        }catch(Exception e){
            return Optional.empty();
        }
    }*/

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientsById(@PathVariable Long id){
        Optional<Client> clientData = clientRepository.findById(id);
        if(clientData.isPresent()){
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK); //converte de optional pro client
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/clientbyName")
    public ResponseEntity<Client> getClientByName(@RequestParam String nome){
        Client clientData = clientRepository.findByNome(nome.toLowerCase());
        //  .findByName(nome.toLowerCase());
        if(clientData != null){
            return new ResponseEntity<>(clientData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    //Deletar cliente.
    @DeleteMapping("/client/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id) {
        try{
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Edição
    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client){
        Optional<Client> clientData = clientRepository.findById(id);

        if(clientData.isPresent()){
            Client client_temp = clientData.get();

            client_temp.setNome(client.getNome());
            client_temp.setTel(client.getTel());
            client_temp.setEmail(client.getEmail());

            return new ResponseEntity<>(clientRepository.save(client_temp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
