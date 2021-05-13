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
  id: number;
  constructor
  (
    private pizzaService : PizzaService
  ) { }

  ngOnInit(): void {
    this.loadPizzas();

  }
  loadPizzas(){
    this.pizzaService.getAllPizzas().subscribe((res: any) => {
      this.pizzas = res;
      console.log('Retorno do map do rxjs:', res);
    });
  }
  alterarPizza(){

  }

  excluirPizza(id:number){
    console.log("fui clicado")
    console.log(id);
    if(confirm('Você deseja excluir essa pizza?')){
      this.pizzaService.excluirPizza(id).subscribe(res=>{
          this.loadPizzas();
      });
    }
  }


}
