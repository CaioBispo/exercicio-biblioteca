import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LivroListComponent } from './list/livro-list.component';
import { LivroFormComponent } from './form/livro-form.component';

const routes: Routes = [
  { path: '', component: LivroListComponent },
  { path: 'create', component: LivroFormComponent },
  { path: 'create/:id', component: LivroFormComponent }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LivroRoutingModule { }
