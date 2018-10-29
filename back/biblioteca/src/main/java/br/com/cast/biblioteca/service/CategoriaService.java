package br.com.cast.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.biblioteca.dto.CategoriaDTO;
import br.com.cast.biblioteca.entity.Categoria;
import br.com.cast.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<CategoriaDTO> buscarTodos() {
		List<Categoria> categorias = categoriaRepository.buscarTodos();
		return categorias.stream().map(c -> CategoriaDTO.fromEntidade(c)).collect(Collectors.toList());
	}
	
}
