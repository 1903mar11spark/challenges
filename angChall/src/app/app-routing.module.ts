import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HoodComponent } from './components/hood/hood.component';
import { AboutComponent } from './components/pages/about/about.component';

const routes: Routes = [
  { path: '', component: HoodComponent },
  { path: 'about', component: AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
