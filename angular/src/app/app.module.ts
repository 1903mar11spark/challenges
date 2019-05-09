import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { MainViewComponent } from './main-view/main-view.component';
import { QuestionsComponent } from './questions/questions.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import {QuestionService} from './questions/questoins.service';

@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    QuestionsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [QuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }