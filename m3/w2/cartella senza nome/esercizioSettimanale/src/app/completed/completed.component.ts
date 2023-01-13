import { Component, OnInit } from '@angular/core';
import { TodosService } from '../todos.service';
import { Todo } from '../todo.interface';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss']
})
export class CompletedComponent implements OnInit {

  show:boolean = false
  list: Todo[] = []
  completed: Todo[] = []

  constructor(private tdServ: TodosService) { }


  ngOnInit(): void {
    setTimeout(() => {
      this.show = true
    }, 2000);
    this.list = this.tdServ.getTodo()
    this.list.forEach(element => {
      if (element.completed) {
        this.completed.push(element)
      }
    });
  }

  remove(id:number){
    this.tdServ.remove(id)
    this.completed = this.completed.filter(p=>p.id!=id)
  }

  reset(id: number){
    this.tdServ.editTodo(id)
    this.completed = this.completed.filter(p=>p.id!=id)
  }


}
