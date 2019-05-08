import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule, HttpHeaders} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JokesComponent } from './jokes/jokes.component';
import { JokeService } from './joke.service';
import { JokeItemComponent } from './joke-item/joke-item.component';

@NgModule({
  declarations: [
    AppComponent,
    JokesComponent,
    JokeItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ JokeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
