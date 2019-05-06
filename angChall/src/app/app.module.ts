import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import{ FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { QuoteComponent } from './components/quote/quote.component';
import { HouseComponent } from './components/house/house.component';
import { CharactersComponent } from './components/characters/characters.component';
import { PotterComponent } from './services/potter/potter.component';
import { HeadersComponent } from './components/layout/headers/headers.component';
import { HoodComponent } from './components/hood/hood.component';
import { AboutComponent } from './components/pages/about/about.component';
import { AddHoodComponent } from './components/add-hood/add-hood.component';
import { HoodItemComponent } from './components/hood-item/hood-item.component';

@NgModule({
  declarations: [
    AppComponent,
    QuoteComponent,
    HouseComponent,
    CharactersComponent,
    PotterComponent,
    HeadersComponent,
    HoodComponent,
    AboutComponent,
    AddHoodComponent,
    HoodItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
