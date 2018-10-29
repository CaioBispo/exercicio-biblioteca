import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReactiveFormsModule } from '@angular/forms';
import { LivroRoutingModule } from './livro-routing.module';

import { LivroListComponent } from './list/livro-list.component';
import { LivroFormComponent } from './form/livro-form.component';


@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    LivroRoutingModule
  ],
  declarations: [
    LivroListComponent, 
    LivroFormComponent
  ]
})
export class LivroModule { }
