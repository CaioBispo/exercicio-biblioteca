package br.com.cast.biblioteca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cast.biblioteca.dto.CategoriaDTO;

@Entity
@Table(name = "categoria", schema = "biblioteca")
public class Categoria {

	@Id
	@Column(name = "id", length = 36, nullable = false)
	private String id;

	@Column(name = "descricao", length = 200, nullable = false)
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

	public static Categoria fromDTO(CategoriaDTO dto) {
		if (dto == null) return null;
		
		Categoria c = new Categoria();
		c.setId(dto.getId());
		c.setDescricao(dto.getDescricao());
		
		return c;
	}
}
