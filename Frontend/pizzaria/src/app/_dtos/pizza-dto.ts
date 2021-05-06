import { Pizza } from "../_models/pizza";

export class PizzaDto {
/*conversão da api*/
  convertResponseToPizza(data: any) : Pizza{
    const newPizza = new Pizza();
    newPizza.id = data.id;
    newPizza.sabor = data.sabor;
    newPizza.tamanho = data.tamanho;

    return newPizza;
  }
}
