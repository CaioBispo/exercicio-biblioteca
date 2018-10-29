import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Livro } from '../model/livro.model';

@Injectable({
  providedIn: 'root'
})
export class LivroService {

  private URL_API = 'http://localhost:8080/livro';

  constructor(private http: HttpClient) { }

  public get(): Observable<Array<Livro>> {
    return this.http.get<Array<Livro>>(this.URL_API);
  }

  public getPorId(id: string): Observable<Livro> {
    return this.http.get<Livro>(this.URL_API + '/' + id);
  }

  public isDuplicado(id: string, titulo: string): Observable<Livro> {
    return this.http.get<Livro>(this.URL_API + '/is-duplicado/' + id + '/' + titulo);
  }

  public add(livro: Livro): Observable<void> {
    return this.http.post<void>(this.URL_API, livro);
  }

  public put(id: string, livro: Livro): Observable<void> {
    return this.http.put<void>(this.URL_API + '/' + id, livro);
  }

  public excluir(id: string): Observable<void> {
    return this.http.delete<void>(this.URL_API + '/' + id);
  }
}
