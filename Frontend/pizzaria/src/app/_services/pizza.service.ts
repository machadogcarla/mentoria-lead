import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { PizzaDto } from '../_dtos/pizza-dto';


@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  private pizzaDto = new PizzaDto();

  constructor(
    private http: HttpClient,
  ) { }

  getAllPizzas() {
    const url = 'http://localhost:8080/pizzaria-lead/pizza';
    return this.http.get(url).pipe(
      map(
        (res : any)=> {
          //console.log(res.data);
          //return res;
          //console.log('Response', res) // vem todas as requisiçõesS
          let data = res.data;
          //map para tratar a lista, percorrer analisar elemento por elemento
          let newData = data.map((e : any) => {
            return this.pizzaDto.convertResponseToPizza(e) //converte so para os atributos que eu quero
          });
          return newData;
        }
      )
    )
;  }
}
