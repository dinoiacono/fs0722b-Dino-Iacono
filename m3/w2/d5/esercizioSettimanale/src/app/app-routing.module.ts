import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodoComponent } from './todo/todo.component';
import { CompletedComponent } from './completed/completed.component';
import { AddTodoComponent } from './add-todo/add-todo.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [  {
    path: 'home',
    component: HomeComponent
  },{
    path: 'todo',
    component: TodoComponent
  },
  {
    path: 'completed',
    component: CompletedComponent
  },

  {
    path: '**',
    component: HomeComponent
  },
  ];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
