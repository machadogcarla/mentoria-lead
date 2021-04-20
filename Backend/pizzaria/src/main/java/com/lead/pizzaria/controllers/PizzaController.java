package com.lead.pizzaria.controllers;

import com.lead.pizzaria.entities.Client;
import com.lead.pizzaria.entities.Pizza;
import com.lead.pizzaria.repositories.PizzaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzaria-lead")
public class PizzaController {

    @Autowired
    public PizzaRepository pizzaRepository;
    /*public Pizza findId(Integer id) {
        Optional<Pizza> obj = pizzaRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!");

    }
    /*
    //visualizar pizza pela id
    @GetMapping(value = "/pizza/{cpf}")
    public ResponseEntity<Pizza> buscarId(@PathVariable Integer id){
        try{
            Optional<Pizza> obj = pizzaRepository.findById(id);
            return new ResponseEntity<>(pizzas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }*/

    //select de todos os clients
    @GetMapping("/pizza")
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
        try{
            Pizza pizza = pizzaRepository.save(new Pizza (pizza_recebido.getSabor(), pizza_recebido.getTamanho()
            ));
            return new ResponseEntity<>(pizza, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
/*
    @RequestMapping(value="/pizza/{Id}")
    public List<Pizza> getfindByPizzaId(Integer Id){
        return pizzaRepository.findByPizzaId(Id);
    }
*/
}
