import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DrivenFormComponent } from './td/td.component';
import { ReactiveComponent } from './reactive/reactive.component';

const routes: Routes = [
  {
    path : 'driven-form',
    component : DrivenFormComponent
  },
  {
    path : 'reactive-form',
    component : ReactiveComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
