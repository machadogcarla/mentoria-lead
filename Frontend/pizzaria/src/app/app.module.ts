import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchPizzasComponent } from './_pages/search-pizzas/search-pizzas.component';
import { PageNotFoundComponent } from './_pages/page-not-found/page-not-found.component';
import { CardComponent } from './_components/card/card.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SearchPizzasComponent,
    PageNotFoundComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
