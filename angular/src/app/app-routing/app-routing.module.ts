import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from '../main-view/main-view.component';
import { QuestionsComponent } from '../questions/questions.component';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {path: 'start', component: MainViewComponent,
    children: [
      {path: 'questions', component: QuestionsComponent},
    ]
}
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule { }
