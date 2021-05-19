import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pizza } from 'src/app/_models/pizza';
import { PizzaService } from 'src/app/_services/pizza.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-list-pizzas',
  templateUrl: './list-pizzas.component.html',
  styleUrls: ['./list-pizzas.component.scss']
})
export class ListPizzasComponent implements OnInit {
  closeResult = '';

  pizzas: Pizza[];
  id: number;

  pizzaToUpdate = {
    sabor: '',
    tamanho: ''
  }
  constructor
  (
    private pizzaService : PizzaService, private router: Router, private modalService: NgbModal
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

  excluirPizza(id:number){
    console.log("fui clicado")
    console.log(id);
    if(confirm('Você deseja excluir essa pizza?')){
      this.pizzaService.excluirPizza(id).subscribe(res=>{
          this.loadPizzas();
      });
    }
  }

  edit(pizza){
    this.pizzaToUpdate = pizza;
  }

  open(content, id:number) {
    console.log(id);

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    });
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
