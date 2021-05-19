import { Component, OnInit } from '@angular/core';
import { Pizza } from 'src/app/_models/pizza';
import { PizzaService } from 'src/app/_services/pizza.service';

@Component({
  selector: 'app-inserir-pizza',
  templateUrl: './inserir-pizza.component.html',
  styleUrls: ['./inserir-pizza.component.scss']
})
export class InserirPizzaComponent implements OnInit {

  pizza: Pizza;
  mensagem: boolean;

  constructor(private pizzaService: PizzaService) { }

  ngOnInit(): void {
    this.initPizza();
  }

  initPizza() {
    this.pizza = new Pizza();
  }

  inserirPizza() {

      this.mensagem = true;
      this.pizzaService.inserirPizza(this.pizza).subscribe((res) => {
        console.table(res);
        //this.initPizza();
      }
      );
      console.log(this.mensagem);

  }

}
