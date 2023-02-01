import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ContatoreLikesComponent } from './components/contatore-likes/contatore-likes.component';
import { ContenitoreFotoComponent } from './components/contenitore-foto/contenitore-foto.component';

@NgModule({
  declarations: [
    AppComponent,
    ContatoreLikesComponent,
    ContenitoreFotoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
