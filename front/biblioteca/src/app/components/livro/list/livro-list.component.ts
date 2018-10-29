import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Livro } from '../../model/livro.model';
import { LivroService } from '../../service/livro.service';

@Component({
  selector: 'app-livro-list',
  templateUrl: './livro-list.component.html',
  styleUrls: ['./livro-list.component.css']
})
export class LivroListComponent implements OnInit {

  public livros: Observable<Array<Livro>>;

  constructor(private router: Router,
    private livroService: LivroService) { }

  ngOnInit() {
    this.getFilmes();
  }

  public excluir(id: string): void {
    if (confirm('Deseja excluir o registro selecionado?')) {
      this.livroService.excluir(id).subscribe(() => this.getFilmes());
    }
  }

  private getFilmes(): void {
    this.livros = this.livroService.get();
  }


}
