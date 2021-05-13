import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PizzaDto } from '../_dtos/pizza-dto';
import { Pizza } from '../_models/pizza';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  private pizzaDto = new PizzaDto();
  id: number;

  constructor(
    private http: HttpClient,
  ) { }

  inserirPizza(pizza: Pizza) {
    const url = 'http://localhost:8080/pizzaria-lead/pizza';
    return this.http.post(url, pizza);
  }

  getAllPizzas() {
    const url = 'http://localhost:8080/pizzaria-lead/pizzas';
    return this.http.get(url).pipe(map((res:any) => {
      console.log('Resposta da API:', res);
      let novaResposta = res.map(i => {
        console.log('Mapeando resposta:', i);
        return i;
      });
      return novaResposta;
    }));
  }

  excluirPizza(id:number){
    const url = 'http://localhost:8080/pizzaria-lead/pizza/';
    return this.http.delete<Pizza>(url+id);
  }

}
