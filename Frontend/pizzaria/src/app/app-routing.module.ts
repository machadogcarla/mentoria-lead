import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InserirPizzaComponent } from './_pages/inserir-pizza/inserir-pizza.component';
import { PageNotFoundComponent } from './_pages/page-not-found/page-not-found.component';
import { ListPizzasComponent } from './_pages/list-pizzas/list-pizzas.component';
import { AlterarPizzaComponent } from './_pages/alterar-pizza/alterar-pizza.component';

const routes: Routes = [
  {path:'', redirectTo: '/listPizza', pathMatch:'full'},
  {path: 'listPizza', component: ListPizzasComponent},
  {path: 'inserirPizza', component: InserirPizzaComponent},
  /*{path: '**', component: PageNotFoundComponent},*/
 {path: 'alterarPizza/:id', component: ListPizzasComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
