import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JokesComponent} from './jokes';

const routes: Routes = [
  { path: 'jokes', component: JokesComponent },
  { path: '**', redirectTo: 'jokes' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
