import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchPizzasComponent } from './_pages/search-pizzas/search-pizzas.component';
import { PageNotFoundComponent } from './_pages/page-not-found/page-not-found.component';
import { CardComponent } from './_components/card/card.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InserirPizzaComponent } from './_pages/inserir-pizza/inserir-pizza.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchPizzasComponent,
    PageNotFoundComponent,
    CardComponent,
    InserirPizzaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
