package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Pizza;
import com.lead.pizzaria.repositories.PizzaRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pizzaria-lead")
public class PizzaController {

    @Autowired
    public PizzaRepository pizzaRepository;


    //select de todos os clients
    @GetMapping("/pizzas")
    public ResponseEntity<List<Pizza>> getPizzas() {
        try {
            List<Pizza> pizzas = pizzaRepository.findAll();
            return new ResponseEntity<>(pizzas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //salvar pizzas
    @PostMapping("/pizza")
    public ResponseEntity<Pizza> createClient(@RequestBody Pizza pizza_recebido) {
        try {
            Pizza pizza = pizzaRepository.save(new Pizza(pizza_recebido.getSabor(), pizza_recebido.getTamanho()));
            return new ResponseEntity<>(pizza, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //busca pela id da pizza
    @GetMapping("/pizza/{id}")
    public Optional<Optional<Pizza>> buscar(@PathVariable Integer id) {
        try{
            Optional<Pizza> pizza = pizzaRepository.findById(id);
            return Optional.ofNullable(pizza);
        }catch(Exception e){
            return Optional.empty();
        }

    }

    /*@GetMapping("/pizza/{id}")
    public ResponseEntity<Pizza> buscar(@PathVariable Integer id) {
        try {
            Optional<Pizza> obj = pizzaRepository.findById(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return null;
    }*/

    //Deletar pizza.
    @DeleteMapping("/pizza/{id}")
    public ResponseEntity<HttpStatus> deletePizza(@PathVariable("id") int id) {
        try{
            pizzaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Edição
    @PutMapping("/pizza/{id}")
    public ResponseEntity<Pizza> updateClient(@PathVariable("id") int id, @RequestBody Pizza pizza){
        Optional<Pizza> pizzaData = pizzaRepository.findById(id);

        if(pizzaData.isPresent()){
            Pizza pizza_temp = pizzaData.get();
            pizza_temp.setSabor(pizza.getSabor());
            pizza.setTamanho(pizza.getTamanho());

            return new ResponseEntity<>(pizzaRepository.save(pizza_temp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
