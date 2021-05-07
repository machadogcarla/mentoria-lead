import { Component, OnInit } from '@angular/core';
import { Pizza } from 'src/app/_models/pizza';
import { PizzaService } from 'src/app/_services/pizza.service';

@Component({
  selector: 'app-search-pizzas',
  templateUrl: './search-pizzas.component.html',
  styleUrls: ['./search-pizzas.component.scss']
})
export class SearchPizzasComponent implements OnInit {
  pizzas: Pizza[];

  constructor
  (private pizzaService : PizzaService
  ) { }

  ngOnInit(): void {
    this.loadPizzas();

  }
  loadPizzas(){
  //nao to conseguindo pegar resultado do vetor
    console.log("load pizzas");
    console.log(this.pizzas);

    this.pizzaService.getAllPizzas().subscribe((res) =>
    {
      this.pizzas = res;
    });
}

}
