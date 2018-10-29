package br.com.cast.biblioteca.dto;

import br.com.cast.biblioteca.entity.Categoria;

public class CategoriaDTO {

	private String id;
	private String descricao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static CategoriaDTO fromEntidade(Categoria c) {
		if (c == null) return null;
		
		CategoriaDTO dto = new CategoriaDTO();
		dto.setId(c.getId());
		dto.setDescricao(c.getDescricao());
		
		return dto;
	}

}
