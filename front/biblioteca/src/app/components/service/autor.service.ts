import { Injectable } from '@angular/core';
import { Autor } from '../model/autor.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  private URL_API = 'http://localhost:8080/autor';

  constructor(private http: HttpClient) { }

  public get(): Observable<Array<Autor>> {
    return this.http.get<Array<Autor>>(this.URL_API);
  }

}
