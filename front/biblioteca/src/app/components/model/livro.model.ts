import { Autor } from "./autor.model";
import { Categoria } from "./categoria.model";

export class Livro {
    id: string;
    titulo: string;
    data_publicacao: string;
    autor: Autor;
    categoria: Categoria;
}