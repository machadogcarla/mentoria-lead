import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InserirPizzaComponent } from './_pages/inserir-pizza/inserir-pizza.component';
import { PageNotFoundComponent } from './_pages/page-not-found/page-not-found.component';
import { SearchPizzasComponent } from './_pages/search-pizzas/search-pizzas.component';

const routes: Routes = [
  {path:'', redirectTo: '/searchPizza', pathMatch:'full'},
  {path: 'searchPizza', component: SearchPizzasComponent},
  {path: 'inserirPizza', component: InserirPizzaComponent},
  {path: '**', component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
