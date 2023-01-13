import { Component, OnInit } from '@angular/core';
import { TodosService } from '../todos.service';

@Component({
	selector: 'app-add-todo',
	templateUrl: './add-todo.component.html',
	styleUrls: ['./add-todo.component.scss']
})
export class AddTodoComponent implements OnInit {

	constructor(private tdServ: TodosService) { }

  show:boolean = false

	ngOnInit(): void {
    setTimeout(() => {
      this.show = true
    }, 2000);
  }



	aggiungi(testo: string) {
		if (testo) this.tdServ.addTodo(testo)
        alert('TASK AGGIUNTA!')
	}

}
