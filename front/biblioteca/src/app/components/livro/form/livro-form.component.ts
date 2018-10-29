import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Autor } from '../../model/autor.model';
import { Categoria } from '../../model/categoria.model';
import { ActivatedRoute, Router } from '@angular/router';
import { LivroService } from '../../service/livro.service';
import { CategoriaService } from '../../service/categoria.service';
import { AutorService } from '../../service/autor.service';
import { Livro } from '../../model/livro.model';

@Component({
  selector: 'app-livro-form',
  templateUrl: './livro-form.component.html',
  styleUrls: ['./livro-form.component.css']
})
export class LivroFormComponent implements OnInit {

  public autores: Array<Autor>;
  public categorias: Array<Categoria>;
  public formCadastro: FormGroup;

  constructor(private form: FormBuilder,
    private livroService: LivroService,
    private categoriaService: CategoriaService,
    private autorService: AutorService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {

    this.formCadastro = this.form.group({
      id: [null, []],
      titulo: [null, [
        Validators.required,
        Validators.maxLength(200)
      ]],
      data_publicacao: [null, [
        Validators.required,
        Validators.pattern(/^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((18|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((18|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/)
      ]],
      autor: this.form.group({
        id: ['', [Validators.required]],
        nome: [null, []],
        pseudonimo: [null, []]
      }),
      categoria: this.form.group({
        id: ['', [Validators.required]],
        descricao: [null, []]
      })
    });

    this.getAutores();
    this.getCategorias();
    
    const id = this.activatedRoute.snapshot.paramMap.get("id");
    if (id) {
      this.getLivro(id);
    }
  }

  public salvar(livro: Livro): void {
    console.log(this.formCadastro);
    if (!livro.id) {
      this.livroService.add(livro).subscribe(() => this.voltar(), 
        erro => console.log('Erro ao inserir', erro)
      );
    } else {
      this.livroService.put(livro.id, livro).subscribe(() => this.voltar(),
        erro => console.log('Erro ao alterar', erro)
      );
    }
  }

  public validarDuplicidade(titulo: string): void {
    if (!titulo) return;
    
    let id = this.formCadastro.controls.id.value;
    this.livroService.isDuplicado(id, titulo).subscribe(isDuplicado => {
      if (isDuplicado) {
        alert('Livro já existe');
        this.formCadastro.controls.titulo.reset();
      }
    });
  }

  private voltar(): void {
    this.router.navigate(['/livro/'])
  }

  private getAutores(): void {
    this.autorService.get().subscribe(autores => this.autores = autores);
  }
  
  private getCategorias(): void {
    this.categoriaService.get().subscribe(categorias => this.categorias = categorias);
  }
  
  private getLivro(id: string): void {
    this.livroService.getPorId(id).subscribe(livro => this.formCadastro.setValue(livro));
  }

}
