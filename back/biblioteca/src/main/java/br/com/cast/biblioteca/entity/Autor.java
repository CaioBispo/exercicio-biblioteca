package br.com.cast.biblioteca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cast.biblioteca.dto.AutorDTO;

@Entity
@Table(name = "autor", schema = "biblioteca")
public class Autor {

	@Id
	@Column(name = "id", length = 36, nullable = false)
	private String id;

	@Column(name = "nome", length = 200, nullable = false)
	private String nome;

	@Column(name = "pseudonimo", length = 200, nullable = false)
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
	
	public static Autor fromDTO(AutorDTO dto) {
		if (dto == null) return null;
		
		Autor a = new Autor();
		a.setId(dto.getId());
		a.setNome(dto.getNome());
		a.setPseudonimo(dto.getPseudonimo());
		
		return a;
	}

}
