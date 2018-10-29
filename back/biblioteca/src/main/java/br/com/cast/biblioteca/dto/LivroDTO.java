package br.com.cast.biblioteca.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.biblioteca.entity.Livro;

public class LivroDTO {

	private String id;
	
	private String titulo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("data_publicacao")
	private Date dataPublicacao;
	
	@JsonProperty("autor")
	private AutorDTO autorDTO;
	
	@JsonProperty("categoria")
	private CategoriaDTO categoriaDTO;

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

	public String getDataPublicacao() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataPublicacao);
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public static LivroDTO fromEntidade(Livro l) {
		if (l == null)
			return null;

		LivroDTO dto = new LivroDTO();
		dto.setId(l.getId());
		dto.setTitulo(l.getTitulo());
		dto.setDataPublicacao(l.getDataPublicacao());
		dto.setAutorDTO(AutorDTO.fromEntidade(l.getAutor()));
		dto.setCategoriaDTO(CategoriaDTO.fromEntidade(l.getCategoria()));

		return dto;

	}
}
