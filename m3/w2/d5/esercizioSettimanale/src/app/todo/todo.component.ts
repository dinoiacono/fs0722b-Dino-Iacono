import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { TodosService } from '../todos.service';
import { Todo } from '../todo.interface';


@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  show:boolean = false
  list: Todo[] = []
  todo: Todo[] = []

  constructor(private tdServ: TodosService) { }


  ngOnInit(): void {
    setTimeout(() => {
      this.show = true
    }, 2000);
    this.list = this.tdServ.getTodo()
    this.list.forEach(element => {
      if (!element.completed) {
        this.todo.push(element)
      }
    });

  }

  todoDelete(id: number){
    this.tdServ.editTodo(id)
    this.todo = this.todo.filter(p=>p.id!=id)
    alert('TASK FATTA!')
  }


}
