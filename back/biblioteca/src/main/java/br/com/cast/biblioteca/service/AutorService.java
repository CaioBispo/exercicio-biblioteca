package br.com.cast.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.biblioteca.dto.AutorDTO;
import br.com.cast.biblioteca.entity.Autor;
import br.com.cast.biblioteca.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository categoriaRepository;
	
	public List<AutorDTO> buscarTodos() {
		List<Autor> autores = categoriaRepository.buscarTodos();
		return autores.stream().map(c -> AutorDTO.fromEntidade(c)).collect(Collectors.toList());
	}
	
}
