package br.com.cast.biblioteca.dto;

import br.com.cast.biblioteca.entity.Autor;

public class AutorDTO {

	private String id;
	private String nome;
	private String pseudonimo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	public static AutorDTO fromEntidade(Autor a) {
		if (a == null) return null;
		
		AutorDTO dto = new AutorDTO();
		dto.setId(a.getId());
		dto.setNome(a.getNome());
		dto.setPseudonimo(a.getPseudonimo());
		
		return dto;
	}
}
