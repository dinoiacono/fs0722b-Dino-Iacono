import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, FormsModule, Validators} from '@angular/forms';
import { Eroe } from '../eroe.interface';

@Component({
	selector: 'app-reactive',
	templateUrl: './reactive.component.html',
	styleUrls: ['./reactive.component.scss']
})
export class ReactiveComponent implements OnInit {

	formEroi!: FormGroup;
	eroi: Eroe[] = [];

	constructor(private fb: FormBuilder) { }

	ngOnInit(): void {
		this.formEroi = new FormGroup({
			nome: this.fb.control(null, Validators.required),
			alter: this.fb.control(null, Validators.required),
			potere: this.fb.array([], Validators.required),
			nemico: this.fb.control(null, Validators.maxLength(10)),
			pianeta: this.fb.control(null, [Validators.required, Validators.minLength(5)]),
			debolezza: this.fb.array([])
		})
	}

	onSubmit(){
		this.eroi.push(this.formEroi.value)
	}

	addDebolezza(){
		const control= this.fb.control(null);
		(this.formEroi.get('debolezza') as FormArray).push(control);
	}

	addPotere(){
		const control= this.fb.control(null);
		(this.formEroi.get('potere') as FormArray).push(control);
	}

	getPotere(){
		return (this.formEroi.get('potere') as FormArray).controls;
	}

	getDebolezza(){
		return (this.formEroi.get('debolezza') as FormArray).controls;
	}

}
