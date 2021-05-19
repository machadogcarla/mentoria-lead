package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Endereco;
import com.lead.pizzaria.entities.Pedido;
import com.lead.pizzaria.entities.Pizza;
import com.lead.pizzaria.repositories.EnderecoRepository;
import com.lead.pizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")

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

    //busca pelo cep
    @GetMapping("/end/{cep}")
    public Optional<Optional<Endereco>> buscar(@PathVariable String cep) {
        try{
            Optional<Endereco> end = endRepository.findByCep(cep);
            return Optional.ofNullable(end);
        }catch(Exception e){
            return Optional.empty();
        }
    }


    //Deletar pedido.
    @DeleteMapping("/end/{id}")
    public ResponseEntity<HttpStatus> deleteEnd(@PathVariable("id") int id) {
        try{
            endRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Edição
    @PutMapping("/end/{id}")
    public ResponseEntity<Endereco> updateEnd(@PathVariable("id") int id, @RequestBody Endereco endereco){
        Optional<Endereco> endData = endRepository.findById(id);

        if(endData.isPresent()){
            Endereco end_temp = endData.get();
            end_temp.setCep(endereco.getCep());
            end_temp.setLogradouro(endereco.getLogradouro());
            end_temp.setNumero(endereco.getNumero());
            end_temp.setComplemento(endereco.getComplemento());
            end_temp.setPonto_referencia(endereco.getPonto_referencia());
            end_temp.setBairro(endereco.getBairro());
            end_temp.setCidade(endereco.getCidade());
            return new ResponseEntity<>(endRepository.save(end_temp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
