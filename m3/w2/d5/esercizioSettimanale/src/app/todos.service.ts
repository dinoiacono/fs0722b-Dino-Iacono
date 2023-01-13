import { Injectable } from '@angular/core';
import { Todo } from './todo.interface';

@Injectable({
  providedIn: 'root'
})
export class TodosService {

  id: number = 0

  constructor() { }

  todo: Todo[] = []

  getTodo(){
    return this.todo
  }

  editTodo(id:number){
    this.todo.forEach(element => {
      if (element.id == id) {
        element.completed = !element.completed
      }
    });
  }

  remove(id:number){
    this.todo = this.todo.filter(p=>p.id!=id)
  }

  addTodo(testo:string): void{
    if (this.todo.length > 0) this.id = this.todo[this.todo.length - 1].id + 1
    this.todo.push({id: this.id, title: testo, completed: false})
  }
}
