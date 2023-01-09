import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PrimoComponentComponent } from './components/primo-component/primo-component.component';
import { SecondoComponentComponent } from './components/secondo-component/secondo-component.component';
import { TerzoComponentComponent } from './components/terzo-component/terzo-component.component';

@NgModule({
  declarations: [
    AppComponent,
    PrimoComponentComponent,
    SecondoComponentComponent,
    TerzoComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
