 package br.com.cast.biblioteca.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cast.biblioteca.dto.LivroDTO;

@Entity
@Table(name = "livro", schema = "biblioteca")
public class Livro {

	@Id
	@Column(name = "id", length = 36, nullable = false)
	private String id;

	@Column(name = "titulo", length = 200, nullable = false)
	private String titulo;

	@Column(name = "data_publicacao", nullable = false)
	private Date dataPublicacao;

	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false)
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public static Livro fromDTO(LivroDTO dto) {
		if (dto == null) return null;
		
		Livro l = new Livro();
		l.setId(dto.getId());
		l.setTitulo(dto.getTitulo());
		l.setCategoria(Categoria.fromDTO(dto.getCategoriaDTO()));
		l.setAutor(Autor.fromDTO(dto.getAutorDTO()));
		try {
			l.setDataPublicacao(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDataPublicacao()));
		} catch (ParseException e) { }
		
		return l;
	}

}
