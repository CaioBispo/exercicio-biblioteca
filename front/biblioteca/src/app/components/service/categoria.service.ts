import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Categoria } from '../model/categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private URL_API = 'http://localhost:8080/categoria';

  constructor(private http: HttpClient) { }

  public get(): Observable<Array<Categoria>> {
    return this.http.get<Array<Categoria>>(this.URL_API);
  }

}
